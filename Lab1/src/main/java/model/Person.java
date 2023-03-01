package model;


import java.time.LocalDate;
import java.time.Period;


public class Person {

    private Long id;

    private String fullname;
    private LocalDate birthday;

    private String passportNumber;

    private int age;

    public Person(String fullname, LocalDate birthday, String passportNumber) {
        this.fullname = fullname;
        this.birthday = birthday;
        this.passportNumber = passportNumber;
        this.age = Period.between(birthday, LocalDate.now()).getYears();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
