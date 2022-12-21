package de.exxcellent.challenge;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Table {
    private List<List<String>> values;

    public Table(List<List<String>> values){
        setValues(values);
    }

    public static Table readFromCsv(String pathToFile){
        List<List<String>> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(pathToFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(getDelimiter());
                records.add(Arrays.asList(values));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return new Table(records);
    }

    public List<List<String>> getValues() {
        return this.values;
    }

    public static String getDelimiter() {
        return ",";
    }

    public void setValues(List<List<String>> newValues) {
        this.values = newValues;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();

        for (int index = 0; index < getValues().size(); index++) {
            sb.append(String.join(getDelimiter(), getValues().get(index)));
            sb.append("\n");
        }

        sb.setLength(sb.length() - 1);
        return sb.toString();
    }
}
