package constants;

import org.openqa.selenium.By;

public class WagesConstants {

    // == constructors ==
    private WagesConstants() {
    }

    // constants

    // elements
    public static final By wagesDetailsPanel = By.xpath("//div[@class='other-box']/div[2]/div/div/div/div");

    // sub-elements
    public static final By txtEmployerNameSubElementDetails = By.xpath(".//*[@name='employerName']");
    public static final By txtTikNikuimSubElementDetals = By.xpath(".//input[@name='tikNumber']");
    public static final By txtAnnualIncomeSubElementDetails = By.xpath(".//input[@name='anualIncome']");
    public static final By btnIsraelIncomeSubElementDetails = By.xpath(".//button[@value='israelIncome']");
    public static final By btnAbroadIncomeSubElementDetails = By.xpath(".//button[@value='abroardIncome']");
    public static final By dropDownCountrySubElementDetails = By.xpath(".//input[@name='countryOfIncomeWork']");
//    public static final By txtStateSubElementDetails = By.xpath(".//input[@name='state']");
//    public static final By txtCitySubElementDetail = By.xpath(".//input[@name='city']");
    public static final By txtStreetSubElementDetails = By.xpath(".//input[@name='street']");
//    public static final By txtHouseNumSubElementDetails = By.xpath(".//input[@name='houseNum']");
}
