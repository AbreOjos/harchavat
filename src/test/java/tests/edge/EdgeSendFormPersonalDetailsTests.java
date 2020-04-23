package tests.edge;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.RunMode;
import tests.scenarious.SendFormPersonalDetailsTests;

@Test(groups = {RunMode.EDGE})
public class EdgeSendFormPersonalDetailsTests extends SendFormPersonalDetailsTests {
    private static final Logger log = Logger.getLogger(EdgeSendFormPersonalDetailsTests.class);

    @BeforeClass(groups = {RunMode.EDGE}, alwaysRun = true)
    public void setUpClass() {

        WebDriverManager.edgedriver().setup();

    }


    @BeforeMethod(groups = {RunMode.EDGE}, alwaysRun = true)
    public void setUpMethod() {

        createEdgeDriver();

        super.setUpMethod();

        prepareEmptyPhoneAndEmailFieldsPersonalDetails();
    }

    public void testPersonalDetailsNotFilledFields() {
        personalDetailsNotFilledFields();
    }

    public void testIsraeliBachelor() throws InterruptedException {
        israeliBachelor();
    }

    public void testExpatriateMarriedIsraeli() throws InterruptedException {
        expatriateMarriedIsraeli();
    }

    public void testIsraeliSpouseAllianceExpatriate() throws InterruptedException {
        israeliSpouseAllianceExpatriate();
    }

    public void testExpatriatePolygamyExpatriate() throws InterruptedException {
        expatriatePolygamyExpatriate();
    }

}
