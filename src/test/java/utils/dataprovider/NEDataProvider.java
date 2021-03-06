package utils.dataprovider;

import automation.tests.infra.dataproviderclients.CSVUtils;
import org.apache.log4j.Logger;
import org.testng.annotations.DataProvider;

public class NEDataProvider {

    private static final Logger log = Logger.getLogger(NEDataProvider.class);

    @DataProvider
    public static Object[][] forbiddenCharsPhoneNumber() {
        return CSVUtils.getCsvTwoDArray("csv/ForbiddenCharsPhoneNumber.csv", 1, null);
    }

    @DataProvider
    public static Object[][] forbiddenChars() {
        return CSVUtils.getCsvTwoDArray("csv/ForbiddenChars.csv", 1, 1);
    }

}
