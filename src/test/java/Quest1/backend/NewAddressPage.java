package Quest1.backend;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class NewAddressPage {

    private WebDriver driver;

    @FindBy(name = "alias")
    private WebElement aliasField;

    @FindBy(name = "address1")
    private WebElement addressField;

    @FindBy(name = "city")
    private WebElement cityField;

    @FindBy(name = "postcode")
    private WebElement zipField;

    @FindBy(name = "id_country")
    private WebElement countryField;

    @FindBy(name = "phone")
    private WebElement phoneField;

    @FindBy(xpath = "//*[@id=\"content\"]//button")
    private WebElement saveButton;

    public NewAddressPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void inputAlias(String alias) {
        aliasField.clear();
        aliasField.sendKeys(alias);
    }

    public void inputAddress(String address) {
        addressField.clear();
        addressField.sendKeys(address);
    }

    public void inputCity(String city) {
        cityField.clear();
        cityField.sendKeys(city);
    }

    public void inputZip(String zip) {
        zipField.clear();
        zipField.sendKeys(zip);
    }
    public void chooseCountry(String countryCode) {
        Select countrySelect = new Select(countryField);
        countrySelect.selectByValue(countryCode);

    }
    public void inputPhone(int phone) {
        phoneField.clear();
        phoneField.sendKeys(String.valueOf(phone));

    }

    public void saveAddress() {
        saveButton.click();
    }
}
