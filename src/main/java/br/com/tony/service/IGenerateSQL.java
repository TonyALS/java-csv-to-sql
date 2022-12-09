package br.com.tony.service;

import br.com.tony.dto.ExampleDTO;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface IGenerateSQL {
    void generate(List<ExampleDTO> data, String outputFilename, Integer limitRows) throws IOException;
    void generate(List<ExampleDTO> data, String outputFilename) throws IOException;
}
