import exception.UnsupportedFileException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.nio.file.*;

public class LearnFileIO {
    private static final String FILE_EXTENSION= ".csv";
    private static final String DIRECTORY= "./src/import";

    public static void printResults( Path path) throws IOException, FileNotFoundException, UnsupportedFileException{
        if(Files.notExists(path)){
            throw new FileNotFoundException();
        }
        FileProcessing fileProcessing;
        FileProcessingStrategy strategy;

        String fileName= path.getFileName().toString();
        String fileExtension=fileName.substring(fileName.lastIndexOf("."));
        if(!fileExtension.equals(FILE_EXTENSION)){
            throw new UnsupportedFileException(FILE_EXTENSION);
        }else{
            fileProcessing= CSVFileProcessing.getInstance();
        }

        if(Files.size(path)>= 30_000_00){
            strategy = LargeFileProcessingStrategy.getInstance();
        }
        else{
            strategy= NormalFileProcessingStrategy.getInstance();
        }
        fileProcessing.printResult(path,strategy);

    }

    public static void main(String[] args) throws IOException, UnsupportedFileException {
        Path importDirectory= Paths.get(DIRECTORY);

        try (WatchService watchService = FileSystems.getDefault().newWatchService()) {
            importDirectory.register(watchService,
                    StandardWatchEventKinds.ENTRY_CREATE,
                    StandardWatchEventKinds.ENTRY_MODIFY,
                    StandardWatchEventKinds.ENTRY_DELETE);

            WatchKey key;
            while ((key = watchService.take()) != null) {
                for (WatchEvent<?> event : key.pollEvents()) {
                    System.out.printf("Event kind: %s. File affected: %s.%n", event.kind(), event.context());
                    printResults(importDirectory.resolve(event.context().toString()));
                }
                key.reset();
            }

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }
}
