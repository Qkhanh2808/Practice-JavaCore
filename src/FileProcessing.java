import model.Company;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public interface FileProcessing {

    default void printResult(Path path, FileProcessingStrategy strategy) throws IOException {
        List<Company> companies= convertToCompany(path);
        System.out.println("Total company located in CA: "
                + strategy.totalCompanyLocatedInCityByCode(companies));
        System.out.println("Name of Companies located in CA: ");
        strategy.nameCompaniesCountry(companies).forEach(System.out::println);
    }

    List<Company> convertToCompany(Path path ) throws IOException;

}
