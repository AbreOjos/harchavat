package tests.edge;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.RunMode;
import tests.scenarious.SendFormVehicleTests;

@Test(groups = {RunMode.EDGE})
public class EdgeSendFormVehicleTests extends SendFormVehicleTests {
    private static final Logger log = Logger.getLogger(EdgeSendFormVehicleTests.class);

    @BeforeClass(groups = {RunMode.EDGE}, alwaysRun = true)
    public void setUpClass() {

        WebDriverManager.edgedriver().setup();

    }


    @BeforeMethod(groups = {RunMode.EDGE}, alwaysRun = true)
    public void setUpMethod() {

        createEdgeDriver();

        super.setUpMethod();

        prepareEmptyVehicleDetails();
    }

    public void testCheckEmptyVehicleFields() {
        checkEmptyVehicleFields();
    }

    public void testEditVehicles() {
        editVehicles();
    }

    public void testMultiVehicles() {
        multiVehicles();
    }


}
