package tests.edge;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.RunMode;
import tests.scenarious.SendFormWageTests;

@Test(groups = {RunMode.EDGE})
public class EdgeSendFormWageTests extends SendFormWageTests {
    private static final Logger log = Logger.getLogger(EdgeSendFormWageTests.class);

    @BeforeClass(groups = {RunMode.EDGE}, alwaysRun = true)
    public void setUpClass() {

        WebDriverManager.edgedriver().setup();

    }


    @BeforeMethod(groups = {RunMode.EDGE}, alwaysRun = true)
    public void setUpMethod() {

        createEdgeDriver();

        super.setUpMethod();

        prepareEmptyWageDetails();
    }

    public void testCheckEmptyIsraelIncomeFields() {
        checkEmptyIsraelIncomeFields();
    }

    public void testCheckEmptyAbroadIncomeFields() {
        checkEmptyAbroadIncomeFields();
    }

    public void testCheckUnnecessaryIsraelIncomeFields() {
        checkUnnecessaryIsraelIncomeFields();
    }

    public void testCheckUnnecessaryAbroadIncomeFields() {
        checkUnnecessaryAbroadIncomeFields();
    }

    public void testMultiWages() {
        multiWages();
    }

}
