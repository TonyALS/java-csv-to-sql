package br.com.tony.service;

import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class ReadCsvService<T> {
    private final String filePath;
    private final Class<? extends T> typeDto;
    public ReadCsvService(String filePath, Class<? extends T> typeDto) {
        this.filePath = filePath;
        this.typeDto = typeDto;
    }

    public List<T> readAll() throws FileNotFoundException {
        return new CsvToBeanBuilder<T>(new FileReader(filePath))
                .withType(typeDto)
                .build()
                .parse();
    }
}
