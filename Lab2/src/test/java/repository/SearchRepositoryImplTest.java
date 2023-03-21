package repository;

import model.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;


import static org.junit.Assert.*;

public class SearchRepositoryImplTest {

    Person person = new Person("Двуреченский Иван Сергеевич", LocalDate.of(2000, Month.JULY, 9), "0010257454", true);
    Person person2 = new Person("Петров Пётр Петрович", LocalDate.of(2001, Month.AUGUST, 15), "4220442454", true);
    Person person3 = new Person("Иванов Иван Иванович", LocalDate.of(2002, Month.AUGUST, 15), "4220442454", true);
    Contract mcc = new MobileCommunicationContract(LocalDate.now(), LocalDate.of(2027, Month.AUGUST, 23), 100L, person, 500, 200, 1000);
    Contract mcc1 = new MobileCommunicationContract(LocalDate.now(), LocalDate.of(2027, Month.AUGUST, 23), 101L, person2, 500, 200, 1000);
    Contract mcc2 = new MobileCommunicationContract(LocalDate.now(), LocalDate.of(2027, Month.AUGUST, 23), 102L, person3, 500, 200, 1000);
    Contract dtvc = new DigitalTVContract(LocalDate.now(), LocalDate.of(2027, Month.AUGUST, 23), 200L, person, ChannelPack.ECONOMY);
    Contract dtvc1 = new DigitalTVContract(LocalDate.now(), LocalDate.of(2027, Month.AUGUST, 23), 201L, person2, ChannelPack.PREMIUM);
    Contract dtvc2 = new DigitalTVContract(LocalDate.now(), LocalDate.of(2027, Month.AUGUST, 23), 202L, person3, ChannelPack.STANDARD);
    Contract ic = new InternetContract(LocalDate.now(), LocalDate.of(2027, Month.AUGUST, 23), 300L, person, 100);
    Contract ic1 = new InternetContract(LocalDate.now(), LocalDate.of(2027, Month.AUGUST, 23), 301L, person2, 75);
    Contract ic2 = new InternetContract(LocalDate.now(), LocalDate.of(2027, Month.AUGUST, 23), 302L, person3, 50);
    SearchContractRepository repo = new SearchRepositoryImpl();

    @org.junit.Test
    public void find() {
        repo.addContracts(new Contract[]{mcc, dtvc, ic1});
        repo.addContracts(new Contract[]{mcc1, dtvc1, ic});
        repo.addContracts(new Contract[]{mcc2, dtvc2, ic2});
        SearchContractRepository newRepo = (SearchContractRepository) repo.find(x -> x.getPerson().getFullname().equals("Двуреченский Иван Сергеевич"));
        long[] expectedIds = new long[]{0, 1, 5};
        long[] actualIds = Arrays.stream(newRepo.getContracts()).filter(Objects::nonNull).mapToLong(Contract::getId).toArray();
        assertEquals(3, newRepo.getNbOfElems());
        assertArrayEquals(expectedIds, actualIds);

    }

    @org.junit.Test
    public void sort() {
        Comparator<Contract> comp = (o1, o2) -> o2.getId().compareTo(o1.getId());
        repo.addContracts(new Contract[]{mcc, dtvc, ic});
        repo.addContracts(new Contract[]{mcc1, dtvc1, ic1});
        repo.addContracts(new Contract[]{mcc2, dtvc2, ic2});
        repo.sort(comp);
        System.out.println(repo);
    }
}