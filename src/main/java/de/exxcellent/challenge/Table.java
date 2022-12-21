package de.exxcellent.challenge;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static de.exxcellent.challenge.ValueChecker.bothListsAreInteger;

/**
 * The csv-files are handled as tables and this class acts as the basic data structure, responsible for value
 * selection and comparisons
 * A singular value is saved as a String and represents a cell in the table
 */
public class Table {
    private List<List<String>> cells;

    public Table(List<List<String>> cells){
        setCells(cells);
    }

    /**
     * The standard way of creating a table is reading the values from a csv-file, a functionality provided by this method.
     * We initialize an ArrayList and save the Strings which are read by a BufferedReader in that list
     */
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

    public List<List<String>> getCells() {
        return this.cells;
    }

    public static String getDelimiter() {
        return ",";
    }

    public void setCells(List<List<String>> newValues) {
        this.cells = newValues;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();

        for (int index = 0; index < getCells().size(); index++) {
            sb.append(String.join(getDelimiter(), getCells().get(index)));
            sb.append("\n");
        }

        sb.setLength(sb.length() - 1);
        return sb.toString();
    }

    public List<String> getColumnByHeader(String columnName) {
        int columnNmbr = getCells().get(0).indexOf(columnName);
        String[] column = new String[getCells().size()];
        for(int i=0; i<column.length; i++){
            column[i] = getCells().get(i).get(columnNmbr);
        }
        return List.of(column);
    }

    public List<String> calculateNumericDistanceBetween(String firstColumn, String secondColumn) {
        ArrayList<String> columnOne = new ArrayList<>(getColumnByHeader(firstColumn));
        columnOne.remove(0);
        ArrayList<String> columnTwo = new ArrayList<>(getColumnByHeader(secondColumn));
        columnTwo.remove(0);
        String[] result = new String[columnOne.size() + 1];

        if (bothListsAreInteger(columnOne, columnTwo)) {

            for(int index = 0; index < columnOne.size(); index++) {
                result[index + 1] = Integer.toString(
                        Integer.parseInt(columnOne.get(index)) - Integer.parseInt(columnTwo.get(index))
                );
                result[0] = "NumDis" + firstColumn + secondColumn;
            }

        } else {
            throw new IllegalArgumentException("We can not compare columns, that are not of the same type and do not " +
                    "contain either integer or double values.");
        }

        return List.of(result);
    }

    public void appendColumn(List<String> newColumn) {
        
    }
}
