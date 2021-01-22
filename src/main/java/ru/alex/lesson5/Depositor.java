package ru.alex.lesson5;

import com.opencsv.bean.CsvBindByPosition;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Depositor {


   @CsvBindByPosition(position = 0)
    String name;

   @CsvBindByPosition(position = 1)
    Integer accountNumber;

    @CsvBindByPosition(position = 2)
    Integer amount;

   @CsvBindByPosition(position = 3)
    Integer age;

    public Depositor()
    {
    }

    public Depositor(String name, Integer accountNumber,
                     Integer amount,
                     Integer age)
    {
        super();
        this.name = name;
        this.accountNumber = accountNumber;
        this.amount = amount;
        this.age = age;
    }


    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Integer getAccountNumber()
    {
        return accountNumber;
    }

    public void setAccountNumber(Integer accountNumber)
    {
        this.accountNumber = accountNumber;
    }

    public Integer getAmount()
    {
        return amount;
    }

    public void setAmount(Integer amount)
    {
        this.amount = amount;
    }

    public Integer getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age=age;
    }

    @Override
    public String toString()
    {
        return "Depositor [" + name + " " + accountNumber + " " + amount + " " + age + "]";
    }

}
