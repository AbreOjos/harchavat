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
    public static final By txtEmployerAddressSubElementDetails = By.xpath(".//input[@name='employerAddress']");
    public static final By txtTikNikuimSubElementDetals = By.xpath(".//input[@name='tikNumber']");
    public static final By txtAnnualIncomeSubElementDetails = By.xpath(".//input[@name='anualIncome']");
}
