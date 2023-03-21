import repository.SearchContractRepository;

import java.io.File;

public interface CsvParser {

    void loadToRepo(File csvFile, SearchContractRepository repository);
}
