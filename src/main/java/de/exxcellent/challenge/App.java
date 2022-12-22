package de.exxcellent.challenge;

/**
 * The entry class for your solution. This class is only aimed as starting point and not intended as baseline for your software
 * design. Read: create your own classes and packages as appropriate.
 *
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 */
public final class App {

    /**
     * This is the main entry method of your program.
     * @param args The CLI arguments passed
     */
    public static void main(String... args) {

        String weather = "C:\\Users\\Frederik\\Documents\\eXXcelent\\programming-challenge\\src\\main\\resources\\de" +
                "\\exxcellent\\challenge\\weather.csv";
        String football = "C:\\Users\\Frederik\\Documents\\eXXcelent\\programming-challenge\\src\\main\\resources\\de" +
                "\\exxcellent\\challenge\\football.csv";

        Table table = Table.readFromCsv(weather);
        table.appendColumn(table.subtractIntegerColumns("MxT", "MnT", "TempSpread"));

        String dayWithSmallestTempSpread = table.getMinimumOfIntegerColumn("TempSpread");
        System.out.printf("Day with smallest temperature spread : %s%n", dayWithSmallestTempSpread);

        String teamWithSmallestGoalSpread = "A good team"; // Your goal analysis function call …
        System.out.printf("Team with smallest goal spread       : %s%n", teamWithSmallestGoalSpread);
    }
}
