import model.Company;

import java.nio.file.Path;
import java.util.List;

public interface FileProcessingStrategy {
    String CODE= "CH";
    int totalCapitalOfHeadquarters(List<Company> companies);
    List<String> nameCompaniesCountry(List<Company> companies);
}
