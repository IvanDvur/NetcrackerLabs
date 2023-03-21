package repository;



import model.*;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.Assert.*;

public class ContractRepositoryImplTest {

    Person person = new Person("Двуреченский Иван Сергеевич", LocalDate.of(2000, Month.JULY,9),"0010257454",true);
    Person person2 = new Person("Петров Пётр Петрович", LocalDate.of(2001, Month.AUGUST,15),"4220442454",true);
    Person person3 = new Person("Иванов Иван Иванович", LocalDate.of(2002, Month.AUGUST,15),"4220442454",true);
    Contract mcc = new MobileCommunicationContract(LocalDate.now(),LocalDate.of(2027, Month.AUGUST,23),100L,person,500,200,1000);
    Contract mcc1 = new MobileCommunicationContract(LocalDate.now(),LocalDate.of(2027, Month.AUGUST,23),101L,person2,500,200,1000);
    Contract mcc2 = new MobileCommunicationContract(LocalDate.now(),LocalDate.of(2027, Month.AUGUST,23),102L,person3,500,200,1000);
    Contract dtvc = new DigitalTVContract(LocalDate.now(),LocalDate.of(2027, Month.AUGUST,23),200L,person, ChannelPack.ECONOMY);
    Contract dtvc1 = new DigitalTVContract(LocalDate.now(),LocalDate.of(2027, Month.AUGUST,23),201L,person2, ChannelPack.PREMIUM);
    Contract dtvc2 = new DigitalTVContract(LocalDate.now(),LocalDate.of(2027, Month.AUGUST,23),202L,person3, ChannelPack.STANDARD);
    Contract ic = new InternetContract(LocalDate.now(),LocalDate.of(2027, Month.AUGUST,23),300L,person, 100);
    Contract ic1 = new InternetContract(LocalDate.now(),LocalDate.of(2027, Month.AUGUST,23),301L,person2, 75);
    Contract ic2 = new InternetContract(LocalDate.now(),LocalDate.of(2027, Month.AUGUST,23),302L,person3, 50);
    ContractRepository repo = new ContractRepositoryImpl();
    @org.junit.Test
    public void addContracts() {
        repo.addContracts(new Contract[]{mcc,dtvc,ic});
        assertEquals(4,repo.getLength());
        assertEquals(3,repo.getNbOfElems());
        repo.addContracts(new Contract[]{mcc1,dtvc1,ic1});
        assertEquals(7,repo.getLength());
        assertEquals(6,repo.getNbOfElems());
        repo.addContracts(new Contract[]{mcc2,dtvc2,ic2});
        assertEquals(11,repo.getLength());
        assertEquals(9,repo.getNbOfElems());
    }

    @org.junit.Test
    public void addContractsWithEnsuredCapacity() {
        ContractRepositoryImpl repo1 = new ContractRepositoryImpl(5);
        Contract[] contracts2 = new Contract[]{mcc,dtvc,ic,mcc,dtvc,ic,mcc};
        repo1.addContracts(contracts2);
        assertEquals(8,repo1.getLength());
    }


    @org.junit.Test
    public void findContractById() {
        addContracts();
        assertEquals(Long.valueOf(8),repo.findContractById(8L).getId());
        assertEquals("0010257454",repo.findContractById(1L).getPerson().getPassportNumber());
        assertEquals(Long.valueOf(201),repo.findContractById(4L).getContractNumber());
    }

    @org.junit.Test
    public void findContractByIncorrectId(){
        ContractRepositoryImpl repo = new ContractRepositoryImpl();
        Contract[] contracts3 = new Contract[]{mcc,mcc1,mcc2,dtvc,dtvc1,dtvc2,ic,ic1,ic2};
        repo.addContracts(contracts3);
        assertNull(repo.findContractById(12L));
    }

    @org.junit.Test
    public void deleteContractById() {
        addContracts();
        repo.deleteContractById(4L);
        assertEquals(8,repo.getNbOfElems());
        assertNull(repo.findContractById(4L));
    }
}