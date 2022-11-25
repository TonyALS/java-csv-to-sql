package br.com.tony.service;

import br.com.tony.util.WriterUtil;
import br.com.tony.dto.ExampleDTO;

import java.io.*;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class GenerateScriptService {

    public void generate(List<ExampleDTO> exampleDTO, Integer limitRows) throws IOException {
        AtomicInteger limit = new AtomicInteger(limitRows);
        AtomicInteger countCut = new AtomicInteger(1);
        AtomicInteger count = new AtomicInteger(0);
        AtomicReference<BufferedWriter> bufferedWriter = new AtomicReference<>(
                WriterUtil.getWriter("INSERT_".concat(countCut.toString()))
        );
        try {
            exampleDTO.remove(0); // The first item of list is the csv header

            exampleDTO.forEach(dto -> {

                try {
                    String insert = String.format("INSERT INTO public.csvfile (value, industrycode) values ('%s', '%s');",
                            dto.getValue(), dto.getIndustryCodeANZSIC06());
                    bufferedWriter.get().write(insert);
                    bufferedWriter.get().newLine();
                    count.getAndIncrement();
                    if (limit.get() == count.get()) {
                        bufferedWriter.get().close();
                        countCut.getAndIncrement();
                        bufferedWriter.getAndSet(WriterUtil.getWriter("INSERT_".concat(countCut.toString())));
                        count.getAndSet(0);
                    }
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            });
        } finally {
            bufferedWriter.get().close();
        }
    }
}
