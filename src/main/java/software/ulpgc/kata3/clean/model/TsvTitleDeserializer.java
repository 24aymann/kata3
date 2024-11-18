package software.ulpgc.kata3.clean.model;

import java.util.Arrays;
import java.util.List;

public class TsvTitleDeserializer implements TitleDeserializer {
    @Override
    public Title deserialize(String line) {
        return deserialize(line.split("\t"));
    }

    private Title deserialize(String[] fields) {
        return new Title(
                fields[3],
                fields[4].equals("1"),
                fields[8].equals("\\N") ? List.of() : Arrays.asList(fields[8].split(","))
        );
    }
}