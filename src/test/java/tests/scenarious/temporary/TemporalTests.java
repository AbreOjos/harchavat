package tests.scenarious.temporary;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import pom.forms.PersonalDetails;
import pom.forms.realestates.RealEstate;
import pom.forms.various.Various;
import pom.forms.vehicles.Vehicle;
import pom.forms.wages.Wage;
import pom.forms.sendform.SendForm;
import readresources.documents.FileAttachments;
import tests.TestBase;

import java.net.URISyntaxException;

import static constants.EnglishHebrewConstants.*;

public class TemporalTests extends TestBase {
    private static final Logger log = Logger.getLogger(TemporalTests.class);

    protected void clickSideMenu() {
        log.info("open page, click Fill Form upper link, click all side menus");

        PersonalDetails personalDetails = basePage.clickMenuPersonalDetails();

        Wage wage = basePage.clickMenuWage();

        RealEstate realEstate = basePage.clickMenuRealEstate();

        Various various = basePage.clickMenuVarious();

        Vehicle vehicle = basePage.clickMenuVehicle();

        SendForm sendForm = basePage.clickMenuSendForm();

    }

    protected void clickNextPreviousButtons() {
        log.info("open page, click Fill Form upper link, cycle with Next / Previous buttons");

        PersonalDetails personalDetails = new PersonalDetails(driver);
        personalDetails.clickBtnContinue();

        Vehicle vehicle = new Vehicle(driver);
        vehicle.clickBtnContinue();

        Wage wage = new Wage(driver);
        wage.clickBtnContinue();

        RealEstate realEstate = new RealEstate(driver);
        realEstate.clickBtnContinue();

        Various various = new Various(driver);
        various.clickBtnContinue();

        SendForm sendForm = new SendForm(driver);
        sendForm.clickBtnReturn();

        various = new Various(driver);
        various.clickBtnReturn();

        realEstate = new RealEstate(driver);
        realEstate.clickBtnReturn();

        wage = new Wage(driver);
        wage.clickBtnReturn();

        vehicle = new Vehicle(driver);
        vehicle.clickBtnReturn();
    }

    protected void fillPersonalDetails() throws InterruptedException, URISyntaxException {
        log.info("open page, click Fill Form upper link, click Personal Details side menus, fill fields");

        PersonalDetails personalDetails = basePage.clickMenuPersonalDetails();

        personalDetails.checkAgreement();

        personalDetails.enterIdentity("123456789");
        personalDetails.enterFirstName("Igor");

        personalDetails.deleteFirstName();

        personalDetails.enterLastName("Gindin");
        personalDetails.enterCellular("0523798168");
        personalDetails.enterPhone("0506585162");
        personalDetails.enterEmail("jgjhg@jhgjhg.gov");

        personalDetails.checkCanSendEmail();
        personalDetails.uncheckCanSendEmail();

        personalDetails.chooseExpatriate();
        personalDetails.chooseIsraeli();

        personalDetails.chooseMaritalStatusBachelor();
        personalDetails.chooseMaritalStatusMarried();

        personalDetails.chooseSpouseExpatriate();

        personalDetails.enterSpousePassport("123321123");
        personalDetails.chooseStateSpouseIsrael();
        personalDetails.chooseStateSpouseZambia();
        personalDetails.chooseStateSpouseUsa();
        personalDetails.enterSpouseState("AAAAAAAAAAAA");

        personalDetails.chooseSpouseIsraeli();

        personalDetails.enterSpouseIdentity("321258549");

        personalDetails.chooseMaritalStatusDivorced();
        personalDetails.chooseMaritalStatusWidow();
        personalDetails.chooseMaritalStatusSpousalAlliance();
        personalDetails.chooseMaritalStatusSeparated();

        personalDetails.attachFile(FileAttachments.getDocumentPdf().toString());

        personalDetails.chooseMaritalStatusPolygamy();

        basePage.clickBtnSave();
        basePage.clickBtnPrint();
        basePage.clickButtonLogOut();
    }

    protected void fillVehiclesDetails() {

        Vehicle vehicle = basePage.clickMenuVehicle();

        vehicle.chooseDontHaveVehicle();
        vehicle.chooseHaveVehicle();

        vehicle.addVehicle();
        vehicle.addVehicle();

        vehicle.choosePrivateVehicle(0);
        vehicle.choosePrivateVehicle(2);
        vehicle.enterCarLicense(0, "rytrytrytr");
        vehicle.enterCarLicense(2, "123456");
//        vehicle.enterCarLicense(2,"bbb");


        vehicle.choosePrivateUsage(0);
        vehicle.chooseAnotherUsage(0);
        vehicle.deleteVehicle(1);

        vehicle.enterCarLicense(0,"aaaaa");
        vehicle.chooseCommercialVehicle(0);
        vehicle.chooseAircraftVehicle(0);
        vehicle.chooseAircraftVehicle(1);
        vehicle.chooseCommercialUsage(1);
        vehicle.chooseAnotherUsage(0);
//        vehicle.enterAnotherUsageDetails(0, "spam");

        vehicle.chooseHeavyVehicle(1);
        vehicle.chooseCommercialUsage(1);

        vehicle.addVehicle();
        vehicle.chooseAnotherVehicle(2);
        vehicle.enterAnotherCarTypeDetails(2, "Just my another car");
    }

    protected void fillWagesDetails() {
        Wage wage = basePage.clickMenuWage();

        wage.chooseDontHaveWage();
        wage.chooseHaveWage();

        wage.addWage();
        wage.addWage();

        wage.enterAnnualIncome(0, "1000");
        //wage.enterEmployerAddress(2, "Ramat Gan");

        wage.deleteWage(1);

        wage.enterEmployerName(0,"Moshe");
        wage.chooseIsraelIncome(1);
        wage.enterTikNikuim(1, "123456");

        wage.addWage();
        wage.chooseAbroadIncome(2);
//        wage.enterTikNikuim(2,"aaaa");
        wage.enterEmployerName(2, "BBB");
        //wage.enterEmployerAddress(2, "cccc");
        wage.enterAnnualIncome(2, "0");

    }

    protected void fillRealEstateDetails() throws Exception {
        RealEstate realEstate = basePage.clickMenuRealEstate();

        realEstate.chooseDontHaveRealEstate();
        realEstate.chooseHaveRealEstate();

        realEstate.addRealEstate();
        realEstate.addRealEstate();

        realEstate.deleteRealEstate(1);

        realEstate.addRealEstate();

        realEstate.pickDayMonthYear(1, "12", MARCH, "2020");

        realEstate.chooseRealEstateTypeHousingUnit(1);
        realEstate.chooseRealEstateTypeAnother(0);

        realEstate.enterRealEstateSize(0, "10");
        realEstate.enterRealEstateOwnershipPercentage(0, "15");

        realEstate.enterRealEstateSize(1, "20");
        realEstate.enterRealEstateOwnershipPercentage(1, "25");

        realEstate.chooseRealEstateInIsrael(0);
        realEstate.chooseRealEstateOversea(1);

        realEstate.enterRealEstateBlock(0, "BBB");
        realEstate.enterRealEstatePlot(0, "CCC");

        realEstate.chooseRealEstateFamilyUsage(0);
        realEstate.chooseRealEstateRenting(1);

//        realEstate.chooseRealEstateBusinessPurpose(1);

//        realEstate.chooseRealEstateDivided(1);
        realEstate.chooseRealEstateSplit(1);
        realEstate.setAmountPartitionsOfDividedRealEstate(1, 5);
        System.out.println("Amount of partitions " + realEstate.amountPartitionsOfDividedRealEstate(1));

//        realEstate.chooseRealEstateTenantNotIsraeli(1);
//        realEstate.enterRenterCountry(1, "USA");
        realEstate.chooseRealEstateRenting(1);
//        realEstate.enterRenterPassport(1, "123456789");
        realEstate.enterMonthlyRent(1, "3000");

        realEstate.addTenant(1);
        realEstate.addTenant(1);
        realEstate.chooseTenantFromAbroad(1, 2);
        realEstate.chooseTenantFromIsrael(1, 0);

        realEstate.enterTenantId(1, 0, "320959604");
        realEstate.enterTenantPassport(1, 2, "999999");

        realEstate.deleteTenant(1, 1);

        realEstate.selectCountryRenterFromDropDownListByName(1, 1, USA);
        realEstate.enterTenantState(1, 1, "Alabama");

        realEstate.attachContractFile(1, FileAttachments.getDocumentPdf().toString());
    }

    protected void fillVariousDetails() {
        Various various = basePage.clickMenuVarious();

        // NonWorkIncomesDetails
        various.chooseHaveNonWorkIncomes();
        various.chooseDontHaveNonWorkIncomes();
        various.chooseHaveNonWorkIncomes();

        various.addNonWorkIncomes();
        various.addNonWorkIncomes();
        various.deleteNonWorkIncomes(1);
        various.addNonWorkIncomes();

        various.chooseNonWorkIncomesIncomeIsraeli(0);
        various.chooseNonWorkIncomesIncomeOversea(2);

        various.enterNonWorkIncomesIncomeSource(0, "AAAAAAAAAAAA");
        various.enterNonWorkIncomesYearlyIncome(0, "1000");
        various.enterNonWorkIncomesPayerName(0, "Igor");
        various.enterNonWorkIncomesTikNikuim(0, "tik AAA");
        various.selectCityNonWorkIncomesFromDropDownListByName(0, JERUSALEM);
        various.enterNonWorkIncomesHouseNum(0, "10");

        various.enterNonWorkIncomesIncomeSource(2, "BBBBBBBBBB");
        various.enterNonWorkIncomesYearlyIncome(2, "123456");
        various.selectCountryNonWorkIncomesFromDropDownListByName(2, ISRAEL);
        various.enterNonWorkIncomesState(2, "Alabama");

        // AbroadBankAccountsDetails
        various.chooseHaveAbroadBankAccounts();
        various.chooseDontHaveAbroadBankAccounts();
        various.chooseHaveAbroadBankAccounts();

        various.addAbroadBankAccounts();
        various.addAbroadBankAccounts();
        various.deleteAbroadBankAccounts(1);
        various.addAbroadBankAccounts();

        various.selectCountryAbroadBankAccountsFromDropDownListByName(2, ISRAEL);
        various.enterAbroadBankAccountsState(2, "Alaska");
        various.enterAbroadBankAccountsCity(2, "Moscow");
        various.enterAbroadBankAccountsBankName(2, "Hapoalim");
        various.enterAbroadBankAccountsBankNum(2, "40");
        various.enterAbroadBankAccountsBranchName(2, "Noname");
        various.enterAbroadBankAccountsBranchNum(2, "12");
        various.enterAbroadBankAccountsAccountNum(2, "021548");
        various.enterAbroadBankAccountsPartners(2, "3");

        // DigitalCoinsDetails
        various.chooseHaveDigitalCoins();
        various.chooseDontHaveDigitalCoins();
        various.chooseHaveDigitalCoins();

        various.addDigitalCoins();
        various.addDigitalCoins();
        various.deleteDigitalCoins(1);
        various.addDigitalCoins();

        various.chooseDigitalCoinsCardano(0);
        various.chooseDigitalCoinsNano(1);
        various.chooseDigitalCoinsAnotherCoin(2);
        various.enterDigitalCoinsCoinAmount(1, "1000");
        various.enterDigitalCoinsPublicKey(1, "asdfgh");
        various.chooseDigitalCoinsCoinsDontMaterialized(1);
        various.chooseDigitalCoinsCoinsMaterialized(2);
        various.enterDigitalCoinsAmountMaterialized(2, "8765");
        various.enterDigitalCoinsMaterializationValue(2, "1234554321");
        various.chooseDigitalCoinsDontPurchasedWithCoins(2);
        various.chooseDigitalCoinsPurchasedWithCoins(1);
        various.enterDigitalCoinsAmountSold(1, "5");
        various.enterDigitalCoinsSoldValue(1, "333");

        // StocksDetails
        various.chooseHaveStocks();
        various.chooseDontHaveStocks();
        various.chooseHaveStocks();

        various.addStocks();
        various.addStocks();
        various.deleteStocks(1);
        various.addStocks();

        various.enterStocksCompanyName(0,"Igor");
        various.enterStocksCompanyName(1,"Gindin");

        various.chooseStocksCompanySourceOversea(0);
        various.chooseStocksCompanySourceIsrael(1);

        various.selectCountryStocksFromDropDownListByName(0, ISRAEL);
        various.enterStocksState(0, "DC");
        various.enterStocksCompanyNum(0, "123");
        various.enterStocksCompanyPercentage(0, "12");

        various.enterStocksCompanyNum(1, "987");
        various.enterStocksCompanyPercentage(1, "95");

        // PartnershipsDetails
        various.chooseHavePartnerships();
        various.chooseDontHavePartnerships();
        various.chooseHavePartnerships();

        various.addPartnerships();
        various.addPartnerships();
        various.deletePartnerships(1);
        various.addPartnerships();

        various.enterPartnershipName(0, "Igor");
        various.enterPartnershipName(2, "Gindin");

        various.choosePartnershipLocationIsrael(0);
        various.choosePartnershipLocationOversea(2);

        various.enterPartnershipOsekNum(0, "123");
        various.enterPartnershipPercentage(0, "14");

        various.selectCountryPartnershipsFromDropDownListByName(2, ISRAEL);
        various.enterPartnershipsState(2, "DC");
        various.enterPartnershipPercentage(2, "69");

        // OwnJewelryDetails
        various.chooseHaveJewelry();
        various.chooseDontHaveJewelry();
        various.chooseHaveJewelry();

        // OwnArtDetails
        various.chooseHaveArt();
        various.chooseDontHaveArt();
        various.chooseHaveArt();

    }

    protected void getSendFormVehicleText() {
        SendForm sendForm = basePage.clickMenuSendForm();

        String firstVehicleDetails = driver.findElement(By.xpath("(//*[@class='info-box'])[2]//ul/li")).getText();

        System.out.println(firstVehicleDetails);
    }

}
