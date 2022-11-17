package br.com.tony.service;

import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class ReadCsvService<T> {
    private final String filePath;
    public ReadCsvService(String filePath) {
        this.filePath = filePath;
    }

    public List<T> readAll(Class<? extends T> type) throws FileNotFoundException {
        return new CsvToBeanBuilder<T>(new FileReader(filePath))
                .withType(type)
                .build()
                .parse();
    }
}
