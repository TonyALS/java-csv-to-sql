package br.com.tony.service;

import br.com.tony.dto.ExampleDTO;
import br.com.tony.util.WriterUtil;

import java.io.BufferedWriter;
import java.io.IOException;
import java.security.InvalidParameterException;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class GenerateSQLImpl implements IGenerateSQL {

    @Override
    public void generate(List<ExampleDTO> data, String outputFilename, Integer limitRows) throws IOException {
        AtomicInteger limit = new AtomicInteger(limitRows);
        AtomicInteger countCut = new AtomicInteger(1);
        AtomicInteger count = new AtomicInteger(0);
        AtomicReference<BufferedWriter> bufferedWriter = new AtomicReference<>(
                WriterUtil.getWriter("INSERT_".concat(countCut.toString()).concat(".sql"))
        );
        try {
            data.remove(0); // The first item of list is the csv header

            data.forEach(dto -> {

                try {
                    String insert = String.format("INSERT INTO public.csvfile (value, industrycode) values ('%s', '%s');",
                            dto.getPeriod(), dto.getDataValue());
                    bufferedWriter.get().write(insert);
                    bufferedWriter.get().newLine();
                    count.getAndIncrement();
                    if (limit.get() == count.get()) {
                        bufferedWriter.get().close();
                        countCut.getAndIncrement();
                        bufferedWriter.getAndSet(WriterUtil.getWriter("INSERT_".concat(countCut.toString()).concat(".sql")));
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

    @Override
    public void generate(List<ExampleDTO> data, String outputFilename) throws IOException,
            InvalidParameterException {

        if (Objects.isNull(outputFilename)) {
            throw new InvalidParameterException("Output filename cannot be null");
        }

        BufferedWriter writer = WriterUtil.getWriter(outputFilename);

        //  The first index of list is the header of csv
        data.remove(0);
        AtomicInteger count = new AtomicInteger(0);

        String beginOfInsert = "INSERT INTO tablename VALUES ";
        writer.write(beginOfInsert);
        writer.newLine();
        try {
            data.forEach(d -> {
                try {
                    String values;
                    if (count.get() == (data.size() - 1)) {
                        values = String.format("('%s', '%s');", d.getDataValue(), d.getPeriod());
                    } else {
                        values = String.format("('%s', '%s'),", d.getDataValue(), d.getPeriod());
                    }
                    writer.write(values);
                    writer.newLine();
                    count.getAndIncrement();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        } finally {
            writer.close();
        }
    }
}
