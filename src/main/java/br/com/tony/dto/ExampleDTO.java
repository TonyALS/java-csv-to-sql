package br.com.tony.dto;

import com.opencsv.bean.CsvBindByPosition;

public class ExampleDTO {
    @CsvBindByPosition(position = 1)
    private String period;
    @CsvBindByPosition(position = 2)
    private String dataValue;

    public String getPeriod() {
        return period;
    }

    public String getDataValue() {
        return dataValue;
    }
}
