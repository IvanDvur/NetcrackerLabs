package model;


import java.time.LocalDate;

/**
 * Родительский класс Contract, содержащий общую информацию о контракте, присущую всем типам контрактов
 */
public class Contract {
    /**
     * Id контракта, автоматически присваивается при добавлении в репозиторий
     */
    private Long id;

    /**
     * Дата начала контракта
     */
    private LocalDate startDate;

    /**
     * Дата окончания контракта
     */
    private LocalDate endDate;


    /**
     * Номер контракта
     */
    private Long contractNumber;

    /**
     * Сущность "Человек", привязанная к контракту
     */
    private Person person;


    /**
     * Конструктор с требуемыми параметрами
     *
     * @param startDate      дата начала контракта
     * @param endDate        дата окончания контракта
     * @param contractNumber номер контракта
     * @param person         сущность «Человек»
     */
    public Contract(LocalDate startDate, LocalDate endDate, Long contractNumber, Person person) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.contractNumber = contractNumber;
        this.person = person;
    }

    public Contract() {
    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
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
