package ru.alex.lesson5;

import com.opencsv.bean.ColumnPositionMappingStrategy;

public class MyMappingStrategy<T> extends ColumnPositionMappingStrategy<T> {
    private static final String[] HEADER = new String[]{"name", "accountNumber",
            "amount", "age"};


}
