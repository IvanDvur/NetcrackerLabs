package model;


import java.time.LocalDate;

public class MobileCommunicationContract extends Contract {

    /**
     * Поле «Кол-во минут»
     */
    private Integer quantityOfMins;
    /**
     * Поле «Кол-во гигабайт»
     */
    private Integer quantityOfGb;
    /**
     * Поле «Кол-во смс»
     */
    private Integer quantityOfSms;

    public MobileCommunicationContract(Integer quantityOfMins, Integer quantityOfGb, Integer quantityOfSms) {
        this.quantityOfMins = quantityOfMins;
        this.quantityOfGb = quantityOfGb;
        this.quantityOfSms = quantityOfSms;
    }

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
