package exception;

public class FileNotFoundException extends Exception{
    public FileNotFoundException(String path) {
        super(String.format("File %s does not exist", path));
    }
}
