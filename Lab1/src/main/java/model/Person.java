package model;


import java.time.LocalDate;
import java.time.Period;


public class Person {
    /**
     * Id человека, автоматически присваиваемое значение
     */
    private Long id;
    /**
     * Поле «ФИО»
     */
    private String fullname;
    /**
     * Поле «Дата рождения»
     */
    private LocalDate birthday;

    /**
     * Поле «Серия и номер паспорта»
     */
    private String passportNumber;

    /**
     * Поле «Пол» false - женщина; true - мужчина
     */
    private Boolean gender;
    /**
     * Поле «Возраст», вычисляется при инициализации объекта
     */
    private int age;

    public Person() {
    }

    public Person(String fullname, LocalDate birthday, String passportNumber, Boolean gender) {
        this.gender = gender;
        this.fullname = fullname;
        this.birthday = birthday;
        this.passportNumber = passportNumber;
        this.age = Period.between(birthday, LocalDate.now()).getYears();
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
