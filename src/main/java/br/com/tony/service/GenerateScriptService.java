package br.com.tony.service;

import br.com.tony.dto.ExampleDTO;

import java.io.*;
import java.util.List;

public class GenerateScriptService {

    public void generate(List<ExampleDTO> exampleDTO) throws IOException {
        OutputStream outputStream = new FileOutputStream("INSERT_TEST.sql");
        Writer writer = new OutputStreamWriter(outputStream);
        BufferedWriter bufferedWriter = new BufferedWriter(writer);
        exampleDTO.remove(0); // The first item of list is the csv header

        try {
            exampleDTO.forEach(dto -> {

                try {
                    String insert = String.format("INSERT INTO public.csvfile (value, industrycode) values ('%s', '%s');",
                            dto.getValue(), dto.getIndustryCodeANZSIC06());
                    bufferedWriter.write(insert);
                    bufferedWriter.newLine();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            });
        } finally {
            bufferedWriter.close();
        }
    }
}
