package utils.dataprovider;

import automation.tests.infra.dataproviderclients.CSVUtils;
import org.apache.log4j.Logger;
import org.testng.annotations.DataProvider;

public class CADataProvider {

    private static final Logger log = Logger.getLogger(CADataProvider.class);

    @DataProvider
    public static Object[][] forbiddenCharsPhoneNumber() {
        log.debug("Creating DataProvider for Free Style Search (simple cases)");
        return CSVUtils.getCsvTwoDArray("csv/ForbiddenCharsPhoneNumber.csv", 1, 1);
    }

}
