package utils.utilitiesForInfra;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.enums.CSVReaderNullFieldIndicator;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.Reader;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static automation.tests.infra.helpers.resourceshelpers.ReadResources.getBufferedReader;

public class CSVUtilsForInfra {
    private static final Logger log = Logger.getLogger(CSVUtilsForInfra.class);

    // == public methods
    public static Object[][] getCsvTwoDArray(String filePath, Integer skipLines, Integer multilineLimit) {
        log.debug("Transfer List<String[]> to String[][], return as Object[][]");
        List<String[]> allLines = getAllLines(filePath, skipLines, multilineLimit);
        return (Object[][])allLines.toArray(new String[allLines.size()][]);
    }

    public static List<String> getCsvSingleColumn(String filePath) {
        List<String[]> allLines = getAllLines(filePath, null, null);

        return allLines.stream().map(e -> e[0]).collect(Collectors.toList());
    }

    // == private methods ==
    /**
     * Getting all lines from given CSV file
     *
     * @param filePath
     * @param skipLines
     * @param multilineLimit
     * @return
     */
    private static List<String[]> getAllLines(String filePath, Integer skipLines, Integer multilineLimit) {
        log.debug(String.format("Get all lines from file %s", filePath));
        List<String[]> allLines = new ArrayList<>();
        try (Reader reader = getBufferedReader(filePath)) {
            allLines = readAllLines(reader, skipLines, multilineLimit);
        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
        }

        return allLines;
    }

    private static List<String[]> readAllLines(Reader reader, Integer skipLines, Integer multilineLimit) {
        log.debug("Reading all lines from given csv file");
        List<String[]> allLines = new ArrayList<>();
        try (CSVReader csvReader = buildCSVReader(reader, skipLines)) {
            allLines = csvReader.readAll();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return (multilineLimit == null ? allLines : allLines.subList(0, multilineLimit));
    }

    private static CSVReader buildCSVReader(Reader reader, Integer skipLines) {
        log.debug("Building CSV reader");
        CSVParser csvParser = new CSVParserBuilder()
                .withSeparator(',')
                .withFieldAsNull(CSVReaderNullFieldIndicator.EMPTY_SEPARATORS)
                .build();

        CSVReaderBuilder csvReaderBuilder = new CSVReaderBuilder(reader);
        if (skipLines != null) csvReaderBuilder.withSkipLines(skipLines);
        return csvReaderBuilder.withCSVParser(csvParser).build();
    }
}
