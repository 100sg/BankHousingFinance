package skbaek.homework.demo.util;

import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvParser;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class FileCsvParser {

    public <T> List<T> read(Class<T> classType, MultipartFile file, CsvSchema schema) {
        List<T> result = new ArrayList<>();

        try {
            CsvMapper mapper = new CsvMapper();
            ObjectReader reader = initReader(mapper, schema, classType);
            InputStream stream = file.getInputStream();
            result = reader.<T>readValues(stream).readAll();
        } catch (IOException e) {
            log.error(e.toString());
        }
        return result;
    }

    private <T> ObjectReader initReader(CsvMapper mapper, CsvSchema schema, Class<T> classType) {
        return mapper.enable(CsvParser.Feature.IGNORE_TRAILING_UNMAPPABLE).readerFor(classType).with(schema);
    }
}