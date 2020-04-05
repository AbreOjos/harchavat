package constants;

import org.openqa.selenium.By;

public class WagesConstants {

    // == constructors ==
    private WagesConstants() {
    }

    // constants

    // elements
    public static final By wagesDetailsPanel = By.xpath("//div[@class='layout row wrap']//div[@class='layout row wrap']/div/div/div");

    // sub-elements
    public static final By txtEmployerNameSubElementDetails = By.xpath(".//*[@name='employerName']");
    public static final By txtTikNikuimSubElementDetals = By.xpath(".//input[@name='tikNumber']");
    public static final By txtAnnualIncomeSubElementDetails = By.xpath(".//input[@name='anualIncome']");
    public static final By btnIsraelIncomeSubElementDetails = By.xpath(".//input[@name='israelIncome']");
    public static final By btnAbroadIncomeSubElementDetails = By.xpath(".//button[@value='abroardIncome']");
    public static final By dropDownCountrySubElementDetails = By.xpath(".//div[@class='v-select__slot']");
//    public static final By txtStateSubElementDetails = By.xpath(".//input[@name='state']");
//    public static final By txtCitySubElementDetail = By.xpath(".//input[@name='city']");
    public static final By txtStreetSubElementDetails = By.xpath(".//input[@name='street']");
//    public static final By txtHouseNumSubElementDetails = By.xpath(".//input[@name='houseNum']");
}
