package Quest1.backend;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YourAddressesPage {

    private WebDriver driver;

    @FindBy(xpath = "//*[@id=\"notifications\"]//li")
    private WebElement addressAddedMessage;

    @FindBy(xpath = "//*[@id=\"notifications\"]//li")
    private WebElement addressDeletedMessage;

    public YourAddressesPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public String getAddressAddedMessage() {
        return addressAddedMessage.getText();
    }
    public String getAddressDeletedMessage(){
        return addressDeletedMessage.getText();
    }
}
