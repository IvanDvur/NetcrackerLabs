package model;


import java.time.LocalDate;


public class Contract {

    private Long id;

    private LocalDate startDate;

    private LocalDate endDate;

    private Long contractNumber;

    private Person person;

    public Contract(LocalDate startDate, LocalDate endDate, Long contractNumber, Person person) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.contractNumber = contractNumber;
        this.person = person;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Long getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(Long contractNumber) {
        this.contractNumber = contractNumber;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "Общее{" +
                "id=" + id +
                ", Начало контракта=" + startDate +
                ", Конец контракта=" + endDate +
                ", Номер контракта=" + contractNumber +
                ", Клиент=" + person.getFullname() +
                '}';
    }
}
