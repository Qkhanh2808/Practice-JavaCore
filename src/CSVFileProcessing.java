import model.Company;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CSVFileProcessing implements FileProcessing{
    private static final String DELIMITER =",";
    private static CSVFileProcessing instance;

    // Singleton Pattern
    public synchronized static CSVFileProcessing getInstance(){
        if(instance==null)
            instance= new CSVFileProcessing();
        return instance;
    }
    private CSVFileProcessing(){}

    @Override
    public List<Company> convertToCompany(Path path) {
        List<String> lines= new ArrayList<>();
        try(BufferedReader reader= Files.newBufferedReader(path)) {
            lines= reader.lines().skip(1).toList();
             return lines.stream()
                    .map(s -> s.split(DELIMITER))
                    .map(company-> Company.builder()
                            .id(Integer.parseInt(company[0]))
                            .name(company[1])
                            .website(company[2])
                            .address(company[3])
                            .city(company[4])
                            .state(company[5])
                            .zip(company[6])
                            .latitude(company[7])
                            .longitude(company[8])
                            .description(company[9])
                            .build()
                    )
                     .collect(Collectors.toList());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
