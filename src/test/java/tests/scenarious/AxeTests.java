package tests.scenarious;

import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import pom.forms.realestates.RealEstate;
import pom.forms.various.Various;
import pom.forms.vehicles.Vehicle;
import pom.forms.wages.Wage;
import tests.TestBase;
import tests.scenarious.axe.Axe;

import static org.testng.AssertJUnit.assertTrue;
import static org.testng.AssertJUnit.fail;

public class AxeTests extends TestBase {

    private static final Logger log = Logger.getLogger(AxeTests.class);

    protected void personalDetailsPage() {
        basePage.clickMenuPersonalDetails();

        String name = new Object(){}.getClass().getEnclosingMethod().getName();
        checkRun(name);
    }

    protected void vehiclesDetailsPage() {
        Vehicle vehicle = basePage.clickMenuVehicle();

        vehicle.chooseHaveVehicle();
        vehicle.addVehicle();
        vehicle.chooseAnotherUsage(0);
        vehicle.chooseAnotherVehicle(0);

        String name = new Object(){}.getClass().getEnclosingMethod().getName();
        checkRun(name);
    }

    protected void wageDetailsPage() {
        Wage wage = basePage.clickMenuWage();

        wage.chooseHaveWage();
        wage.addWage();

        String name = new Object(){}.getClass().getEnclosingMethod().getName();
        checkRun(name);
    }

    protected void realEstateDetailsPage() {
        RealEstate realEstate = basePage.clickMenuRealEstate();

        realEstate.chooseHaveRealEstate();
        realEstate.addRealEstate();
        realEstate.chooseRealEstateInIsrael(0);
        realEstate.chooseRealEstateOversea(1);

        String name = new Object(){}.getClass().getEnclosingMethod().getName();
        checkRun(name);
    }

    protected void variousDetailsPage() {
        Various various = basePage.clickMenuVarious();

        various.chooseHaveNonWorkIncomes();
        various.chooseHaveAbroadBankAccounts();
        various.chooseHaveDigitalCoins();
        various.chooseHaveStocks();
        various.chooseHavePartnerships();

        String name = new Object(){}.getClass().getEnclosingMethod().getName();
        checkRun(name);
    }

    protected void sendFormDetailsPage() {
        basePage.clickMenuSendForm();

        String name = new Object(){}.getClass().getEnclosingMethod().getName();
        checkRun(name);
    }



    // == private methods ==
    private void checkRun(String methodName) {
        JSONObject responseJSON = new Axe.Builder(driver, scriptUrl).analyze();

        JSONArray violations = responseJSON.getJSONArray("violations");

        if (violations.length() == 0) {
            assertTrue("No violations found", true);
        } else {
            Axe.writeResults(methodName, responseJSON);
            fail(Axe.report(violations));
        }
    }

}
