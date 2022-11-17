package br.com.tony;

import br.com.tony.dto.ExampleDTO;
import br.com.tony.service.GenerateScriptService;
import br.com.tony.service.ReadCsvService;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        GenerateScriptService generateScriptService = new GenerateScriptService();
        try {
            ReadCsvService<ExampleDTO> csvService = new ReadCsvService<>("dummy-csv.csv");
            List<ExampleDTO> exampleDTOS = csvService.readAll(ExampleDTO.class);
            generateScriptService.generate(exampleDTOS);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}