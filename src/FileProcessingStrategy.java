import model.Company;

import java.util.List;

public interface FileProcessingStrategy {
    String CODE= "\"CA\"";
    long totalCompanyLocatedInCityByCode(List<Company> companies);
    List<String> nameCompaniesCountry(List<Company> companies);
}
