import model.Company;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class NormalFileProcessingStrategy implements FileProcessingStrategy{
    // Singleton Pattern
    private static NormalFileProcessingStrategy instance;

    public synchronized static NormalFileProcessingStrategy getInstance(){
        if (instance==null){
            instance= new NormalFileProcessingStrategy();
        }
        return instance;
    }

    private NormalFileProcessingStrategy(){}

    @Override
    public long totalCompanyLocatedInCityByCode(List<Company> companies) {
        long count= companies.stream()
                .filter(company -> company.getState().equals(CODE))
                .count();
        return count;
    }

    @Override
    public List<String> nameCompaniesCountry(List<Company> companies) {
        return companies.stream()
                .filter(company -> company.getState().equals(CODE))
                // using comparing static method to make code more concise
                .sorted(Comparator.comparing(Company::getAddress).reversed())
                .map(Company::getName)
                .collect(Collectors.toList());

    }
}
