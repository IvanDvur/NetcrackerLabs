package model;


import java.time.LocalDate;

public class MobileCommunicationContract extends Contract {

    private Integer quantityOfMins;
    private Integer quantityOfGb;
    private Integer quantityOfSms;

    public MobileCommunicationContract(LocalDate startDate, LocalDate endDate,
                                       Long contractNumber, Person person, Integer quantityOfMins,
                                       Integer quantityOfGb, Integer quantityOfSms) {
        super(startDate, endDate, contractNumber, person);
        this.quantityOfMins = quantityOfMins;
        this.quantityOfGb = quantityOfGb;
        this.quantityOfSms = quantityOfSms;
    }

    public Integer getQuantityOfMins() {
        return quantityOfMins;
    }

    public void setQuantityOfMins(Integer quantityOfMins) {
        this.quantityOfMins = quantityOfMins;
    }

    public Integer getQuantityOfGb() {
        return quantityOfGb;
    }

    public void setQuantityOfGb(Integer quantityOfGb) {
        this.quantityOfGb = quantityOfGb;
    }

    public Integer getQuantityOfSms() {
        return quantityOfSms;
    }

    public void setQuantityOfSms(Integer quantityOfSms) {
        this.quantityOfSms = quantityOfSms;
    }

    @Override
    public String toString() {
        return "Мобильная связь {" +
                "Кол-во минут=" + quantityOfMins +
                ", Кол-во Гб=" + quantityOfGb +
                ", Кол-во СМС=" + quantityOfSms +
                "} " + super.toString();
    }
}
