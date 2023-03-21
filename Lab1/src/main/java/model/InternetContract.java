package model;


import java.time.LocalDate;

public class InternetContract extends Contract {
    /**
     * Поле «Скорость подключения»
     */
    private int connectionSpeed;

    public InternetContract(int connectionSpeed) {
        this.connectionSpeed = connectionSpeed;
    }

    public InternetContract(LocalDate startDate, LocalDate endDate, Long contractNumber, Person person, int connectionSpeed) {
        super(startDate, endDate, contractNumber, person);
        this.connectionSpeed = connectionSpeed;
    }

    @Override
    public String toString() {
        return "Интернет {" +
                "Скорость соединения=" + connectionSpeed +
                "} " + super.toString();
    }
}
