package br.com.tony.dto;

import com.opencsv.bean.CsvBindByPosition;


public class ExampleDTO {
    @CsvBindByPosition(position = 0)
    private String year;
    @CsvBindByPosition(position = 1)
    private String industryAgg;
    @CsvBindByPosition(position = 2)
    private String industryCodeNZSIOC;
    @CsvBindByPosition(position = 3)
    private String industryName;
    @CsvBindByPosition(position = 4)
    private String units;
    @CsvBindByPosition(position = 5)
    private String variableCode;
    @CsvBindByPosition(position = 6)
    private String variableName;
    @CsvBindByPosition(position = 7)
    private String variableCategory;
    @CsvBindByPosition(position = 8)
    private String value;
    @CsvBindByPosition(position = 9)
    private String industryCodeANZSIC06;

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getIndustryAgg() {
        return industryAgg;
    }

    public void setIndustryAgg(String industryAgg) {
        this.industryAgg = industryAgg;
    }

    public String getIndustryCodeNZSIOC() {
        return industryCodeNZSIOC;
    }

    public void setIndustryCodeNZSIOC(String industryCodeNZSIOC) {
        this.industryCodeNZSIOC = industryCodeNZSIOC;
    }

    public String getIndustryName() {
        return industryName;
    }

    public void setIndustryName(String industryName) {
        this.industryName = industryName;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }

    public String getVariableCode() {
        return variableCode;
    }

    public void setVariableCode(String variableCode) {
        this.variableCode = variableCode;
    }

    public String getVariableName() {
        return variableName;
    }

    public void setVariableName(String variableName) {
        this.variableName = variableName;
    }

    public String getVariableCategory() {
        return variableCategory;
    }

    public void setVariableCategory(String variableCategory) {
        this.variableCategory = variableCategory;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getIndustryCodeANZSIC06() {
        return industryCodeANZSIC06;
    }

    public void setIndustryCodeANZSIC06(String industryCodeANZSIC06) {
        this.industryCodeANZSIC06 = industryCodeANZSIC06;
    }
}
