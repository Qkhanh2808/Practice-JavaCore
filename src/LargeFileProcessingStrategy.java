import model.Company;

import java.nio.file.Path;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class LargeFileProcessingStrategy implements FileProcessingStrategy{

    // Singleton Pattern
    private static LargeFileProcessingStrategy instance;

    public synchronized static LargeFileProcessingStrategy getInstance(){
        if (instance==null){
            instance= new LargeFileProcessingStrategy();
        }
        return instance;
    }

    private LargeFileProcessingStrategy(){}

    @Override
    public int totalCapitalOfHeadquarters(List<Company> companies) {
        return companies.parallelStream()
                .filter(company -> company.isHeadquarter() &&
                        company.getCountry().equals(CODE))
                .reduce(0, (partialResult, company)-> partialResult+ company.getCapital(), Integer::sum);
    }

    @Override
    public List<String> nameCompaniesCountry(List<Company> companies) {
        return companies.parallelStream()
                .filter(company -> company.getCountry().equals(CODE))
                // using comparing static method to make code more concise
                .sorted(Comparator.comparing(Company::getCapital).reversed())
                .map(Company::getName)
                .collect(Collectors.toList());

    }

}
