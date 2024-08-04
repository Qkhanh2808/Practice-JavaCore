import model.Company;

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
    public long totalCompanyLocatedInCityByCode(List<Company> companies) {
        return companies.parallelStream()
                .filter(company -> company.getState().equals(CODE))
                .count();
    }

    @Override
    public List<String> nameCompaniesCountry(List<Company> companies) {
        return companies.parallelStream()
                .filter(company -> company.getState().equals(CODE))
                // using comparing static method to make code more concise
                .sorted(Comparator.comparing(Company::getAddress).reversed())
                .map(Company::getName)
                .collect(Collectors.toList());

    }

}
