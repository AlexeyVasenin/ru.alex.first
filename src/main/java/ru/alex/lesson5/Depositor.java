package ru.alex.lesson5;

import com.opencsv.bean.CsvBindByPosition;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Depositor implements Serializable {


//    @CsvBindByPosition(position = 1)
    String name;

//    @CsvBindByPosition(position = 2)
    Integer accountNumber;

//    @CsvBindByPosition(position = 3)
    Integer amount;

//    @CsvBindByPosition(position = 4)
    String age;

    public Depositor()
    {
    }

    public Depositor(String name, Integer accountNumber,
                     Integer amount,
                     String age)
    {

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

    public String getAge()
    {
        return age;
    }

    public void setAge(int age) throws ParseException
    {
        String date = Integer.toString(age);
        SimpleDateFormat s = new SimpleDateFormat("yyyy");
        Date y = s.parse(date);
        SimpleDateFormat a = new SimpleDateFormat("yyyy");
        this.age = a.format(y);
    }
}
