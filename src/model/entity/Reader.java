package model.entity;

import java.util.Date;

public class Reader{

    private String firstName;
    private String lastName;
    private String patronymic;
    private Date birthday;
    private String region;
    private  String area;
    private String city;
    private String street;
    private int home;
    private int flat;
    private String numberPhone;
    private String numberPassport;

    public Reader() {
    }

    public Reader(String firstName, String lastName, String patronymic,
                  Date birthday, String region, String area, String city,
                  String street, int home, int flat, String numberPhone, String numberPassport) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.birthday = birthday;
        this.region = region;
        this.area = area;
        this.city = city;
        this.street = street;
        this.home = home;
        this.flat = flat;
        this.numberPhone = numberPhone;
        this.numberPassport = numberPassport;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getHome() {
        return home;
    }

    public void setHome(int home) {
        this.home = home;
    }

    public int getFlat() {
        return flat;
    }

    public void setFlat(int flat) {
        this.flat = flat;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public String getNumberPassport() {
        return numberPassport;
    }

    public void setNumberPassport(String numberPassport) {
        this.numberPassport = numberPassport;
    }

    @Override
    public String toString() {
        return lastName + ' ' + firstName + ' ' + patronymic;
    }


    public String fullString() {
        return  "Фамилия: " + lastName + System.lineSeparator() +
                "Имя: " + firstName + System.lineSeparator() +
                "Отчество: " + patronymic + System.lineSeparator() +
                "Дата рождения: " + birthday + System.lineSeparator() +
                "**Место проживания**" + System.lineSeparator() +
                "Область: " + region + System.lineSeparator() +
                "Район: " + area + System.lineSeparator() +
                "Город: " + city + System.lineSeparator() +
                "Улица: " + street + System.lineSeparator() +
                "Дом: " + home + System.lineSeparator() +
                "Квартира: " + flat + System.lineSeparator() +
                "Номер телефона: " + numberPhone + System.lineSeparator() +
                "Номер паспорта: " + numberPassport + System.lineSeparator();
    }
}
