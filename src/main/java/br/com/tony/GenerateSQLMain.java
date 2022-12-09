package br.com.tony;

import br.com.tony.dto.ExampleDTO;
import br.com.tony.service.GenerateSQLImpl;
import br.com.tony.service.GenerateScriptService;
import br.com.tony.service.IGenerateSQL;
import br.com.tony.service.ReadCsvService;

import java.io.IOException;
import java.util.List;

public class GenerateSQLMain {
    public static void main(String[] args) {
        IGenerateSQL generateScriptService = new GenerateSQLImpl();
        try {
            ReadCsvService<ExampleDTO> csvService = new ReadCsvService<>("dummy-csv-3.csv", ExampleDTO.class);
            List<ExampleDTO> exampleDTOS = csvService.readAll();
//            generateScriptService.generate(exampleDTOS, "INSERT_TEST.sql");
            generateScriptService.generate(exampleDTOS, "INSERT_TEST.sql", 5000);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}