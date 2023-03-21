import org.testng.annotations.Test;
import repository.SearchRepositoryImpl;

import java.io.File;
import java.util.Arrays;

import static org.junit.Assert.*;

public class CsvParserImplTest {

    SearchRepositoryImpl repo = new SearchRepositoryImpl();


    @Test
    public void loadToRepo(){
        CsvParser parser = new CsvParserImpl();
        File csv = new File("src/test/java/contracts.csv");
        parser.loadToRepo(csv,repo);
        assertEquals(7,repo.getNbOfElems());
        System.out.println(Arrays.toString(repo.getContracts()));
    }
}