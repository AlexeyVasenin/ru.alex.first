package ru.alex.lesson5;

import com.opencsv.bean.CsvBindByName;

import java.io.Serializable;

public class Depositor implements Serializable {


    @CsvBindByName
    String name; // полное имя вкладчика

    @CsvBindByName
    Integer accountNumber; //номер счета

    @CsvBindByName
    Integer amount; // величина вклада

    @CsvBindByName
    Integer age; //год открытия вклада

    @CsvBindByName
    Integer id; //порядковый номер вкладчика

    public Depositor() {
    }

    public Depositor(String name, Integer accountNumber,
                     Integer amount,
                     Integer age, Integer id) {
        super();
        this.name = name;
        this.accountNumber = accountNumber;
        this.amount = amount;
        this.age = age;
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Integer accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Depositor [" + name + " | " + amount + " | "
                + age + "]";
    }
}
