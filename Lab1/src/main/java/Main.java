import model.MobileCommunicationContract;
import model.Person;

import java.time.LocalDate;
import java.time.Month;

public class Main {
    public static void main(String[] args) {
        Person person = new Person("Двуреченский Иван Сергеевич",LocalDate.of(2000,Month.JULY,9),"4220257454");
        MobileCommunicationContract mb = new MobileCommunicationContract(LocalDate.now(),LocalDate.of(2027, Month.AUGUST,23),12345L,person,500,200,1000);
        System.out.println(mb);
    }
}
