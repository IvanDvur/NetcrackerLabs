package repository;


import model.*;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.Assert.*;

public class ContractRepositoryImplTest {

    Person person = new Person("Двуреченский Иван Сергеевич", LocalDate.of(2000, Month.JULY,9),"0010257454");
    Person person2 = new Person("Петров Пётр Петрович", LocalDate.of(2001, Month.AUGUST,15),"4220442454");
    Person person3 = new Person("Иванов Иван Иванович", LocalDate.of(2002, Month.AUGUST,15),"4220442454");
    Contract mcc = new MobileCommunicationContract(LocalDate.now(),LocalDate.of(2027, Month.AUGUST,23),100L,person,500,200,1000);
    Contract mcc1 = new MobileCommunicationContract(LocalDate.now(),LocalDate.of(2027, Month.AUGUST,23),101L,person2,500,200,1000);
    Contract mcc2 = new MobileCommunicationContract(LocalDate.now(),LocalDate.of(2027, Month.AUGUST,23),102L,person3,500,200,1000);
    Contract dtvc = new DigitalTVContract(LocalDate.now(),LocalDate.of(2027, Month.AUGUST,23),200L,person, ChannelPack.ECONOMY);
    Contract dtvc1 = new DigitalTVContract(LocalDate.now(),LocalDate.of(2027, Month.AUGUST,23),201L,person2, ChannelPack.ECONOMY);
    Contract dtvc2 = new DigitalTVContract(LocalDate.now(),LocalDate.of(2027, Month.AUGUST,23),202L,person3, ChannelPack.ECONOMY);
    Contract ic = new InternetContract(LocalDate.now(),LocalDate.of(2027, Month.AUGUST,23),300L,person, 100);
    Contract ic1 = new InternetContract(LocalDate.now(),LocalDate.of(2027, Month.AUGUST,23),301L,person2, 100);
    Contract ic2 = new InternetContract(LocalDate.now(),LocalDate.of(2027, Month.AUGUST,23),302L,person3, 100);

    @org.junit.Test
    public void addContracts() {
        ContractRepositoryImpl repo = new ContractRepositoryImpl();
        repo.addContracts(new Contract[]{mcc,dtvc,ic,mcc,dtvc,ic});
        assertEquals(7,repo.getLength());
    }

    @org.junit.Test
    public void addContractsWithEnsuredCapacity() {
        ContractRepositoryImpl repo = new ContractRepositoryImpl(5);
        Contract[] contracts2 = new Contract[]{mcc,dtvc,ic,mcc,dtvc,ic,mcc};
        repo.addContracts(contracts2);
        assertEquals(8,repo.getLength());
    }


    @org.junit.Test
    public void findContractById() {
        ContractRepositoryImpl repo = new ContractRepositoryImpl();
        Contract[] contracts3 = new Contract[]{mcc,mcc1,mcc2,dtvc,dtvc1,dtvc2,ic,ic1,ic2};
        repo.addContracts(contracts3);
        System.out.println(repo);
        Contract result = repo.findContractById(7L);
        assertEquals(Long.valueOf(7),result.getId());
        assertEquals("Петров Пётр Петрович",result.getPerson().getFullname());
    }

    @org.junit.Test
    public void findContractByIncorrectId(){
        ContractRepositoryImpl repo = new ContractRepositoryImpl();
        Contract[] contracts3 = new Contract[]{mcc,mcc1,mcc2,dtvc,dtvc1,dtvc2,ic,ic1,ic2};
        repo.addContracts(contracts3);
        System.out.println(repo);
        Contract result = repo.findContractById(12L);
    }

    @org.junit.Test
    public void deleteContractById() {
        ContractRepositoryImpl repo = new ContractRepositoryImpl();
        Contract[] contracts3 = new Contract[]{mcc,mcc1,mcc2,dtvc,dtvc1,dtvc2,ic,ic1,ic2};
        repo.addContracts(contracts3);
        System.out.println(repo);
        Contract result = repo.findContractById(12L);
    }


}