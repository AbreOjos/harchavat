package tests.edge;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.RunMode;
import tests.scenarious.SendFormRealEstateTests;

@Test(groups = {RunMode.EDGE})
public class EdgeSendFormRealEstateTests extends SendFormRealEstateTests {
    private static final Logger log = Logger.getLogger(EdgeSendFormRealEstateTests.class);

    @BeforeClass(groups = {RunMode.EDGE}, alwaysRun = true)
    public void setUpClass() {

        WebDriverManager.edgedriver().setup();

    }


    @BeforeMethod(groups = {RunMode.EDGE}, alwaysRun = true)
    public void setUpMethod() {

        createEdgeDriver();

        super.setUpMethod();

        prepareEmptyRealEstateDetails();
    }

    public void testMultiRealEstateWithoutTenants() throws Exception {
        multiRealEstateWithoutTenants();
    }

    public void testRealEstateWithMultiTenants() throws Exception {
        realEstateWithMultiTenants();
    }

}
