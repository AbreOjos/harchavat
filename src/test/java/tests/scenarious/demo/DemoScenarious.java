package tests.scenarious.demo;

import assertions.AssertionsHarchavat;
import org.apache.log4j.Logger;
import org.testng.Assert;
import pom.forms.PersonalDetails;
import pom.forms.sendform.SendForm;
import pom.forms.vehicles.Vehicle;
import pom.forms.wages.Wage;
import tests.TestBase;

import static constants.EnglishHebrewConstants.*;

public class DemoScenarious extends TestBase {
    private static final Logger log = Logger.getLogger(DemoScenarious.class);

    protected void checkMenuIcons() {
        log.info("Check that Vehicle menu has icons: error, checked, without icon");

        String correctLicense = "12345678";

        Vehicle vehicle = basePage.clickMenuVehicle();
        vehicle.chooseHaveVehicle();
        vehicle.choosePrivateVehicle(0);
        basePage.clickMenuWage();
        vehicle = basePage.clickMenuVehicle();

        // check error icon
        AssertionsHarchavat.assertListContainsExactNumberOfElements(vehicle.getErrorIconMenu(), 1,
                "An error icon menu did not appears when there are empty mandatory fields");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(vehicle.getCheckCircleIconMenu(), 0,
                "A check-circle icon menu did not disappears when there are empty mandatory fields");

        vehicle.choosePrivateVehicle(0);
        vehicle.enterCarLicense(0, correctLicense);
        basePage.clickMenuWage();
        vehicle = basePage.clickMenuVehicle();

        // check check-circle icon
        AssertionsHarchavat.assertListContainsExactNumberOfElements(vehicle.getCheckCircleIconMenu(), 1,
                "A check-circle icon menu did not appears when mandatory fields contain correct values");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(vehicle.getErrorIconMenu(), 0,
                "An error icon menu did not disappears when mandatory fields contain correct values");

        vehicle.chooseDontHaveVehicle();
        basePage.clickMenuWage();
        vehicle = basePage.clickMenuVehicle();

        // check icons disappeared
        AssertionsHarchavat.assertListContainsExactNumberOfElements(vehicle.getCheckCircleIconMenu(), 0,
                "A check-circle icon menu appears when there are no vehicles");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(vehicle.getErrorIconMenu(), 0,
                "An error icon menu appears when there are no vehicles");
    }

    protected void checkDownloadedFormForSeparates() {
        log.info("Choose 'separated', click 'download' link, check that pdf opened in a separate tab");

        PersonalDetails personalDetails = basePage.clickMenuPersonalDetails();
        personalDetails.chooseMaritalStatusSeparated();

        personalDetails.clickDownloadLinkCheckSuffixAndReturn("pdf");
    }

    protected void needFillVehicleDetailsErrorMessage() {
        log.info("Add a few vehicles, play with 'need to fill vehicle details' error messages");

        String vehicleDetails = "abcde";

        Vehicle vehicle = basePage.clickMenuVehicle();
        vehicle.chooseHaveVehicle();
        vehicle.addVehicle();
        vehicle.addVehicle();

        vehicle.chooseAircraftVehicle(0);
        vehicle.chooseAnotherVehicle(1);
        vehicle.chooseCommercialVehicle(2);

        basePage.clickMenuPersonalDetails();
        vehicle = basePage.clickMenuVehicle();

        // check error messages on every panel
        AssertionsHarchavat.assertListContainsExactNumberOfElements(vehicle.getNeedFillVehicleDetailsErrorMessage(0), 0,
                "Error message 'Need to Fill Vehicle Details' appear on a first panel - not Another vehicle");
        AssertionsHarchavat.assertListContainsExactNumberOfElements(vehicle.getNeedFillVehicleDetailsErrorMessage(1), 1,
                "Error message 'Need to Fill Vehicle Details' did not appear on a second panel - Another vehicle");
        AssertionsHarchavat.assertListContainsExactNumberOfElements(vehicle.getNeedFillVehicleDetailsErrorMessage(2), 0,
                "Error message 'Need to Fill Vehicle Details' appear on a third panel - not Another vehicle");

        vehicle.deleteVehicle(2);

        // recheck error messages on every panel
        AssertionsHarchavat.assertListContainsExactNumberOfElements(vehicle.getNeedFillVehicleDetailsErrorMessage(0), 0,
                "Error message 'Need to Fill Vehicle Details' appear on a first panel - not Another vehicle");
        AssertionsHarchavat.assertListContainsExactNumberOfElements(vehicle.getNeedFillVehicleDetailsErrorMessage(1), 1,
                "Error message 'Need to Fill Vehicle Details' did not appear on a second panel - Another vehicle");

        vehicle.deleteAnotherCarTypeDetails(1);
        vehicle.enterAnotherCarTypeDetails(1, vehicleDetails);

        // recheck error messages on every panel
        AssertionsHarchavat.assertListContainsExactNumberOfElements(vehicle.getNeedFillVehicleDetailsErrorMessage(0), 0,
                "Error message 'Need to Fill Vehicle Details' appear on a first panel - not Another vehicle");
        AssertionsHarchavat.assertListContainsExactNumberOfElements(vehicle.getNeedFillVehicleDetailsErrorMessage(1), 0,
                "Error message 'Need to Fill Vehicle Details' did not disappear from a second panel after filling details");
    }

    protected void expatriatePolygamyExpatriate() throws InterruptedException {
        log.info("Expatriate polygamy alliance with expatriate");

        String correctPhoneNumber = "123456789";
        String correctSpousePassport= "325969987";
        String correctSpouseState = "ABCDEF";

        PersonalDetails personalDetails = basePage.clickMenuPersonalDetails();

        personalDetails.checkAgreement();
        personalDetails.enterPhone(correctPhoneNumber);
        personalDetails.chooseExpatriate();
        personalDetails.chooseMaritalStatusPolygamy();

        personalDetails.chooseSpouseExpatriate();
        personalDetails.deleteSpousePassport();
        personalDetails.deleteSpouseState();
        personalDetails.enterSpousePassport(correctSpousePassport);
        personalDetails.chooseStateSpouseUsa();
        personalDetails.enterSpouseState(correctSpouseState);

        SendForm sendForm = basePage.clickMenuSendForm();

        Assert.assertTrue(sendForm.landlinesPhoneContains(correctPhoneNumber),
                String.format("Instead of landlines phone '%s' found '%s'", correctPhoneNumber, sendForm.getLandlinesPhone().get(0).getText()));

        Assert.assertTrue(sendForm.israelCitizenContains(NO),
                String.format("Instead of Israeli Citizen '%s' found '%s'", NO, sendForm.getIsraeliCitizen().get(0).getText()));

        Assert.assertTrue(sendForm.spouseIsraeliCitizenContains(NO),
                String.format("Instead of Israeli Citizen '%s' found '%s'", NO, sendForm.getSpouseIsraeliCitizen().get(0).getText()));

        Assert.assertTrue(sendForm.spousePassportContains(correctSpousePassport),
                String.format("Instead of spouse passport '%s' found '%s'", correctSpousePassport, sendForm.getSpousePassport().get(0).getText()));

        Assert.assertTrue(sendForm.spouseCountryContains(USA),
                String.format("Instead of spouse country '%s' found '%s'", USA, sendForm.getSpouseCountry().get(0).getText()));

        Assert.assertTrue(sendForm.spouseStateContains(correctSpouseState),
                String.format("Instead of spouse state '%s' found '%s'", correctSpouseState, sendForm.getSpouseState().get(0).getText()));

    }

    protected void sendFormMultiVehicles() {
        log.info("Add and delete a few vehicles, check that data does not loss");

        String anotherVehicle = "Another vehicle";
        String anotherUsage = "Another usage";
        String firstCorrectLicense = "12345678";
        String secondCorrectLicense = "12-345-67";
        String thirdCorrectLicense = "123-45-678";

        Vehicle vehicle = basePage.clickMenuVehicle();
        vehicle.chooseHaveVehicle();

        vehicle.addVehicle();
        vehicle.addVehicle();

        vehicle.choosePrivateVehicle(0);
        vehicle.chooseAircraftVehicle(1);
        vehicle.chooseAnotherVehicle(2);

        vehicle.deleteAnotherCarTypeDetails(2);
        vehicle.enterAnotherCarTypeDetails(2, anotherVehicle);

        vehicle.choosePrivateUsage(0);
        vehicle.chooseAnotherUsage(1);
        vehicle.chooseCommercialUsage(2);

        vehicle.deleteAnotherUsageDetails(1);
        vehicle.enterAnotherUsageDetails(1, anotherUsage);

        vehicle.deleteCarLicense(0);
        vehicle.enterCarLicense(0, firstCorrectLicense);
        vehicle.deleteCarLicense(1);
        vehicle.enterCarLicense(1, secondCorrectLicense);
        vehicle.deleteCarLicense(2);
        vehicle.enterCarLicense(2, thirdCorrectLicense);

        SendForm sendForm = basePage.clickMenuSendForm();

        AssertionsHarchavat.assertListContainsExactNumberOfElements(sendForm.getVehicle(), 3,
                String.format("Expected %d vehicles on Send Form page, but found %d", 3, sendForm.getVehicle().size()));

        Assert.assertTrue(sendForm.vehiclePrivate(0), "First vehicle not private");
        Assert.assertTrue(sendForm.vehicleAircraft(1), "Second vehicle not aircraft");
        Assert.assertTrue(sendForm.typeVehicleContainsText(2, anotherVehicle), String.format("Third vehicle not '%s'", anotherVehicle));

        Assert.assertTrue(sendForm.licenseVehicleContainsText(0, firstCorrectLicense), String.format("First vehicle license not '%s'", firstCorrectLicense));
        Assert.assertTrue(sendForm.licenseVehicleContainsText(1, secondCorrectLicense), String.format("Second vehicle license not '%s'", secondCorrectLicense));
        Assert.assertTrue(sendForm.licenseVehicleContainsText(2, thirdCorrectLicense), String.format("Third vehicle license not '%s'", thirdCorrectLicense));

        Assert.assertTrue(sendForm.usageVehiclePrivate(0), "First vehicle usage not private");
        Assert.assertTrue(sendForm.usageVehicleContainsText(1, anotherUsage), String.format("Second vehicle usage not '%s'", anotherUsage));
        Assert.assertTrue(sendForm.usageVehicleBusiness(2), "Third vehicle usage not business");

        vehicle = basePage.clickMenuVehicle();

        vehicle.deleteVehicle(1);

        sendForm = basePage.clickMenuSendForm();

        AssertionsHarchavat.assertListContainsExactNumberOfElements(sendForm.getVehicle(), 2,
                String.format("Expected %d vehicles on Send Form page, but found %d", 2, sendForm.getVehicle().size()));

        Assert.assertTrue(sendForm.vehiclePrivate(0), "First vehicle not private");
        Assert.assertTrue(sendForm.typeVehicleContainsText(1, anotherVehicle), String.format("Second vehicle not '%s'", anotherVehicle));

        Assert.assertTrue(sendForm.licenseVehicleContainsText(0, firstCorrectLicense), String.format("First vehicle license not '%s'", firstCorrectLicense));
        Assert.assertTrue(sendForm.licenseVehicleContainsText(1, thirdCorrectLicense), String.format("Second vehicle license not '%s'", thirdCorrectLicense));

        Assert.assertTrue(sendForm.usageVehiclePrivate(0), "First vehicle usage not private");
        Assert.assertTrue(sendForm.usageVehicleBusiness(1), "Second vehicle usage not business");
    }

    //==

    protected void checkUnnecessaryIsraelIncomeFields() {
        log.info("Check that after changing income from Abroad to Israel necessary fields stored and unnecessary removed");

        String annualIncome = "123";
        String employerName = "Employer Name";
        String state = "State";
        String city = "City";
        String street = "Street";
        String homeNum = "10 a";

        Wage wage = basePage.clickMenuWage();
        wage.chooseDontHaveWage();
        wage.clickBtnSave();
        wage.chooseHaveWage();

        // choose Abroad Income, fill all fields
        wage.chooseAbroadIncome(0);
        wage.enterAnnualIncome(0, annualIncome);
        wage.enterEmployerName(0, employerName);
        wage.selectCountryFromDropDownListByIndex(0, 0);
        wage.enterState(0, state);
        wage.enterCity(0, city);
        wage.enterStreet(0, street);
        wage.enterHouseNum(0, homeNum);

        // switch to Israel Income
        wage.chooseIsraelIncome(0);

        // go to Send Form page, check fields
        SendForm sendForm = basePage.clickMenuSendForm();

        String fieldLost = "field lost after moving from Abroad to Israel income";
        String fieldNotRemoved = "was not removed after moving from Abroad to Israel income";
        String incorrectValue = "incorrect after moving from Abroad to Israel income";

        Assert.assertTrue(sendForm.typeIncomeExists(0), "Type Income " + fieldLost);
        Assert.assertTrue(sendForm.wageIncomeTypeIsrael(0), "Type Income " + incorrectValue);
        Assert.assertTrue(sendForm.annualIncomeExists(0), "Annual Income " + fieldLost);
        Assert.assertTrue(sendForm.wageAnnualIncomeContainsText(0, annualIncome), "Annual Income " + incorrectValue);
        Assert.assertTrue(sendForm.employerNameExists(0), "Employer Name " + fieldLost);
        Assert.assertTrue(sendForm.wageEmployerNameContainsText(0, employerName), "Employer Name " + incorrectValue);
        Assert.assertFalse(sendForm.countryExists(0), "Country " + fieldNotRemoved);
        Assert.assertFalse(sendForm.stateExists(0), "State " + fieldNotRemoved);
        Assert.assertFalse(sendForm.cityExists(0), "City " + fieldNotRemoved);
        Assert.assertFalse(sendForm.streetExists(0), "Street " + fieldNotRemoved);
        Assert.assertFalse(sendForm.houseNumberExists(0), "House Number " + fieldNotRemoved);
    }

    protected void multiWages() {
        log.info("Add and delete a few wages, check that data does not loss");

        String firstAnnualIncome = "123";
        String firstEmployerName = "Employer Name";
        String firstHouseNum = "10 a";
        String firstTikNikuim = "123456789";

        String secondAnnualIncome = "456";
        String secondEmployerName = "Second Employer Name";
        String secondHouseNum = "20 a";
        String secondTikNikuim = "987654321";

        String thirdAnnualIncome = "789";
        String thirdEmployerName = "Third Employer Name";
        String thirdState = "State";
        String thirdCity = "City";
        String thirdStreet = "Street";
        String thirdHouseNum = "30 a";

        Wage wage = basePage.clickMenuWage();
        wage.chooseDontHaveWage();
        wage.clickBtnSave();
        wage.chooseHaveWage();

        wage.addWage();
        wage.addWage();

        // fill first wage
        wage.chooseIsraelIncome(0);
        wage.enterAnnualIncome(0, firstAnnualIncome);
        wage.enterEmployerName(0, firstEmployerName);
        String firstSelectedCity = wage.selectCityFromDropDownListByIndex(0, 0);
        String firstSelectedStreet = wage.selectStreetFromDropDownListByIndex(0, 0);
        wage.enterHouseNum(0, firstHouseNum);
        wage.enterTikNikuim(0, firstTikNikuim);

        // fill second wage
        wage.chooseIsraelIncome(1);
        wage.enterAnnualIncome(1, secondAnnualIncome);
        wage.enterEmployerName(1, secondEmployerName);
        String secondSelectedCity = wage.selectCityFromDropDownListByIndex(1, 1);
        String secondSelectedStreet = wage.selectStreetFromDropDownListByIndex(1, 1);
        wage.enterHouseNum(1, secondHouseNum);
        wage.enterTikNikuim(1, secondTikNikuim);

        // fill third wage
        wage.chooseAbroadIncome(2);
        wage.enterAnnualIncome(2, thirdAnnualIncome);
        wage.enterEmployerName(2, thirdEmployerName);
        String thirdCountry = wage.selectCountryFromDropDownListByIndex(2, 2);
        wage.enterState(2, thirdState);
        wage.enterCity(2, thirdCity);
        wage.enterStreet(2, thirdStreet);
        wage.enterHouseNum(2, thirdHouseNum);

        // go to Send Form, check data
        SendForm sendForm = basePage.clickMenuSendForm();

        AssertionsHarchavat.assertListContainsExactNumberOfElements(sendForm.getWage(), 3,
                String.format("Expected %d wages on Send Form page, but found %d", 3, sendForm.getWage().size()));

        // first wage
        Assert.assertTrue(sendForm.wageIncomeTypeIsrael(0), "Type Income incorrect, expected Israel");
        Assert.assertTrue(sendForm.wageAnnualIncomeContainsText(0, firstAnnualIncome),
                String.format("Annual Income incorrect, expected %s", firstAnnualIncome));
        Assert.assertTrue(sendForm.wageEmployerNameContainsText(0, firstEmployerName),
                String.format("Employer Name incorrect, expected %s", firstEmployerName));
        Assert.assertTrue(sendForm.wageCityContainsText(0, firstSelectedCity),
                String.format("City incorrect, expected %s", firstSelectedCity));
        Assert.assertTrue(sendForm.wageStreetContainsText(0, firstSelectedStreet),
                String.format("Street incorrect, expected %s", firstSelectedStreet));
        Assert.assertTrue(sendForm.wageNumHouseContainsText(0, firstHouseNum),
                String.format("House Number incorrect, expected %s", firstHouseNum));
        Assert.assertTrue(sendForm.wageTikNikuimContainsText(0, firstTikNikuim),
                String.format("Tik Nikuim incorrect, expected %s", firstTikNikuim));

        // second wage
        Assert.assertTrue(sendForm.wageIncomeTypeIsrael(1), "Type Income incorrect, expected Israel");
        Assert.assertTrue(sendForm.wageAnnualIncomeContainsText(1, secondAnnualIncome),
                String.format("Annual Income incorrect, expected %s", secondAnnualIncome));
        Assert.assertTrue(sendForm.wageEmployerNameContainsText(1, secondEmployerName),
                String.format("Employer Name incorrect, expected %s", secondEmployerName));
        Assert.assertTrue(sendForm.wageCityContainsText(1, secondSelectedCity),
                String.format("City incorrect, expected %s", secondSelectedCity));
        Assert.assertTrue(sendForm.wageStreetContainsText(1, secondSelectedStreet),
                String.format("Street incorrect, expected %s", secondSelectedStreet));
        Assert.assertTrue(sendForm.wageNumHouseContainsText(1, secondHouseNum),
                String.format("House Number incorrect, expected %s", secondHouseNum));
        Assert.assertTrue(sendForm.wageTikNikuimContainsText(1, secondTikNikuim),
                String.format("Tik Nikuim incorrect, expected %s", secondTikNikuim));

        // third wage
        Assert.assertTrue(sendForm.wageIncomeTypeAbroad(2), "Type Income incorrect, expected Abroad");
        Assert.assertTrue(sendForm.wageAnnualIncomeContainsText(2, thirdAnnualIncome),
                String.format("Annual Income incorrect, expected %s", thirdAnnualIncome));
        Assert.assertTrue(sendForm.wageEmployerNameContainsText(2, thirdEmployerName),
                String.format("Employer Name incorrect, expected %s", thirdEmployerName));
        Assert.assertTrue(sendForm.wageCountryContainsText(2, thirdCountry),
                String.format("Country incorrect, expected %s", thirdCountry));
        Assert.assertTrue(sendForm.wageStateContainsText(2, thirdState),
                String.format("State incorrect, expected %s", thirdState));
        Assert.assertTrue(sendForm.wageCityContainsText(2, thirdCity),
                String.format("City incorrect, expected %s", thirdCity));
        Assert.assertTrue(sendForm.wageStreetContainsText(2, thirdStreet),
                String.format("Street incorrect, expected %s", thirdStreet));
        Assert.assertTrue(sendForm.wageNumHouseContainsText(2, thirdHouseNum),
                String.format("House Number incorrect, expected %s", thirdHouseNum));

        // return to Wage, delete one of the wages
        wage = basePage.clickMenuWage();
        wage.deleteWage(1);

        // return to Send Form, re-check data
        sendForm = basePage.clickMenuSendForm();

        AssertionsHarchavat.assertListContainsExactNumberOfElements(sendForm.getWage(), 2,
                String.format("Expected %d wages on Send Form page, but found %d", 2, sendForm.getWage().size()));

        // first wage
        Assert.assertTrue(sendForm.wageIncomeTypeIsrael(0), "Type Income incorrect, expected Israel");
        Assert.assertTrue(sendForm.wageAnnualIncomeContainsText(0, firstAnnualIncome),
                String.format("Annual Income incorrect, expected %s", firstAnnualIncome));
        Assert.assertTrue(sendForm.wageEmployerNameContainsText(0, firstEmployerName),
                String.format("Employer Name incorrect, expected %s", firstEmployerName));
        Assert.assertTrue(sendForm.wageCityContainsText(0, firstSelectedCity),
                String.format("City incorrect, expected %s", firstSelectedCity));
        Assert.assertTrue(sendForm.wageStreetContainsText(0, firstSelectedStreet),
                String.format("Street incorrect, expected %s", firstSelectedStreet));
        Assert.assertTrue(sendForm.wageNumHouseContainsText(0, firstHouseNum),
                String.format("House Number incorrect, expected %s", firstHouseNum));
        Assert.assertTrue(sendForm.wageTikNikuimContainsText(0, firstTikNikuim),
                String.format("Tik Nikuim incorrect, expected %s", firstTikNikuim));

        // second wage (former third)
        Assert.assertTrue(sendForm.wageIncomeTypeAbroad(1), "Type Income incorrect, expected Abroad");
        Assert.assertTrue(sendForm.wageAnnualIncomeContainsText(1, thirdAnnualIncome),
                String.format("Annual Income incorrect, expected %s", thirdAnnualIncome));
        Assert.assertTrue(sendForm.wageEmployerNameContainsText(1, thirdEmployerName),
                String.format("Employer Name incorrect, expected %s", thirdEmployerName));
        Assert.assertTrue(sendForm.wageCountryContainsText(1, thirdCountry),
                String.format("Country incorrect, expected %s", thirdCountry));
        Assert.assertTrue(sendForm.wageStateContainsText(1, thirdState),
                String.format("State incorrect, expected %s", thirdState));
        Assert.assertTrue(sendForm.wageCityContainsText(1, thirdCity),
                String.format("City incorrect, expected %s", thirdCity));
        Assert.assertTrue(sendForm.wageStreetContainsText(1, thirdStreet),
                String.format("Street incorrect, expected %s", thirdStreet));
        Assert.assertTrue(sendForm.wageNumHouseContainsText(1, thirdHouseNum),
                String.format("House Number incorrect, expected %s", thirdHouseNum));

    }

    protected void multiVehicles() {
        log.info("Add and delete a few vehicles, check that data does not loss");

        String anotherVehicle = "Another vehicle";
        String anotherUsage = "Another usage";
        String firstCorrectLicense = "12345678";
        String secondCorrectLicense = "12-345-67";
        String thirdCorrectLicense = "123-45-678";

        Vehicle vehicle = basePage.clickMenuVehicle();
        vehicle.chooseHaveVehicle();

        vehicle.addVehicle();
        vehicle.addVehicle();

        vehicle.choosePrivateVehicle(0);
        vehicle.chooseAircraftVehicle(1);
        vehicle.chooseAnotherVehicle(2);

        vehicle.deleteAnotherCarTypeDetails(2);
        vehicle.enterAnotherCarTypeDetails(2, anotherVehicle);

        vehicle.choosePrivateUsage(0);
        vehicle.chooseAnotherUsage(1);
        vehicle.chooseCommercialUsage(2);

        vehicle.deleteAnotherUsageDetails(1);
        vehicle.enterAnotherUsageDetails(1, anotherUsage);

        vehicle.deleteCarLicense(0);
        vehicle.enterCarLicense(0, firstCorrectLicense);
        vehicle.deleteCarLicense(1);
        vehicle.enterCarLicense(1, secondCorrectLicense);
        vehicle.deleteCarLicense(2);
        vehicle.enterCarLicense(2, thirdCorrectLicense);

        SendForm sendForm = basePage.clickMenuSendForm();

        AssertionsHarchavat.assertListContainsExactNumberOfElements(sendForm.getVehicle(), 3,
                String.format("Expected %d vehicles on Send Form page, but found %d", 3, sendForm.getVehicle().size()));

        Assert.assertTrue(sendForm.vehiclePrivate(0), "First vehicle not private");
        Assert.assertTrue(sendForm.vehicleAircraft(1), "Second vehicle not aircraft");
        Assert.assertTrue(sendForm.typeVehicleContainsText(2, anotherVehicle), String.format("Third vehicle not '%s'", anotherVehicle));

        Assert.assertTrue(sendForm.licenseVehicleContainsText(0, firstCorrectLicense), String.format("First vehicle license not '%s'", firstCorrectLicense));
        Assert.assertTrue(sendForm.licenseVehicleContainsText(1, secondCorrectLicense), String.format("Second vehicle license not '%s'", secondCorrectLicense));
        Assert.assertTrue(sendForm.licenseVehicleContainsText(2, thirdCorrectLicense), String.format("Third vehicle license not '%s'", thirdCorrectLicense));

        Assert.assertTrue(sendForm.usageVehiclePrivate(0), "First vehicle usage not private");
        Assert.assertTrue(sendForm.usageVehicleContainsText(1, anotherUsage), String.format("Second vehicle usage not '%s'", anotherUsage));
        Assert.assertTrue(sendForm.usageVehicleBusiness(2), "Third vehicle usage not business");

        vehicle = basePage.clickMenuVehicle();

        vehicle.deleteVehicle(1);

        sendForm = basePage.clickMenuSendForm();

        AssertionsHarchavat.assertListContainsExactNumberOfElements(sendForm.getVehicle(), 2,
                String.format("Expected %d vehicles on Send Form page, but found %d", 2, sendForm.getVehicle().size()));

        Assert.assertTrue(sendForm.vehiclePrivate(0), "First vehicle not private");
        Assert.assertTrue(sendForm.typeVehicleContainsText(1, anotherVehicle), String.format("Second vehicle not '%s'", anotherVehicle));

        Assert.assertTrue(sendForm.licenseVehicleContainsText(0, firstCorrectLicense), String.format("First vehicle license not '%s'", firstCorrectLicense));
        Assert.assertTrue(sendForm.licenseVehicleContainsText(1, thirdCorrectLicense), String.format("Second vehicle license not '%s'", thirdCorrectLicense));

        Assert.assertTrue(sendForm.usageVehiclePrivate(0), "First vehicle usage not private");
        Assert.assertTrue(sendForm.usageVehicleBusiness(1), "Second vehicle usage not business");

    }

    protected void israeliSpouseAllianceExpatriate() throws InterruptedException {
        log.info("Israeli in spouse alliance with expatriate");

        String correctPhoneNumber = "123456789";
        String correctSpousePassport= "325969987";

        PersonalDetails personalDetails = basePage.clickMenuPersonalDetails();

        personalDetails.checkAgreement();
        personalDetails.enterPhone(correctPhoneNumber);
        personalDetails.chooseIsraeli();
        personalDetails.chooseMaritalStatusSpousalAlliance();

        personalDetails.chooseSpouseExpatriate();
        personalDetails.deleteSpousePassport();
        personalDetails.deleteSpouseState();
        personalDetails.enterSpousePassport(correctSpousePassport);
        personalDetails.chooseStateSpouseUsa();

        SendForm sendForm = basePage.clickMenuSendForm();

        Assert.assertTrue(sendForm.landlinesPhoneContains(correctPhoneNumber),
                String.format("Instead of landlines phone '%s' found '%s'", correctPhoneNumber, sendForm.getLandlinesPhone().get(0).getText()));

        Assert.assertTrue(sendForm.israelCitizenContains(YES),
                String.format("Instead of Israeli Citizen '%s' found '%s'", YES, sendForm.getIsraeliCitizen().get(0).getText()));

        Assert.assertTrue(sendForm.spouseIsraeliCitizenContains(NO),
                String.format("Instead of Israeli Citizen '%s' found '%s'", NO, sendForm.getSpouseIsraeliCitizen().get(0).getText()));

        Assert.assertTrue(sendForm.spousePassportContains(correctSpousePassport),
                String.format("Instead of spouse passport '%s' found '%s'", correctSpousePassport, sendForm.getSpousePassport().get(0).getText()));

        Assert.assertTrue(sendForm.spouseCountryContains(USA),
                String.format("Instead of spouse country '%s' found '%s'", USA, sendForm.getSpouseCountry().get(0).getText()));

        Assert.assertTrue(sendForm.spouseStateContains(NOT_YET_REPORTED),
                String.format("Instead of spouse state '%s' found '%s'", NOT_YET_REPORTED, sendForm.getSpouseState().get(0).getText()));
    }
}
