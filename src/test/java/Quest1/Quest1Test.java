package Quest1;

import Quest1.backend.Generators;
import Quest1.backend.NewAddressPage;
import Quest1.backend.YourAddressesPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Quest1Test {

    //    variables
    public String loginPage = "https://prod-kurs.coderslab.pl/index.php?controller=authentication&back=my-account";
    public String addressPage = "https://prod-kurs.coderslab.pl/index.php?controller=address";
    public String alias = "BB";
    public String address = "BARTŁOMIEJOWA 99";
    public String city = "BARTŁOMIEJOWO";
    public String zipCode = "66-666";
    public int phone = Generators.randomPhoneNumber();
    public String countryCode = "17";
    public String country = "United Kingdom";
    private NewAddressPage newAddressPage;
    public WebDriver driver;
//    colors for console
    public static final String GREEN = "\033[0;32m";
    public static final String RED = "\033[0;31m";
    public static final String RESET = "\033[0m";
    public static final String BMAG = "\u001b[36;1m";


    @Given("^an open browser with login page$")
    public void goToLoginPage() {
        System.out.println(BMAG + "TEST START" + RESET);
        // Skonfiguruj sterownik przeglądarki
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver");
        // Uruchom nowy egzemplarz przeglądarki Chrome
        driver = new ChromeDriver();
        // Zmaksymalizuj okno przeglądarki
        driver.manage().window().maximize();
        // Przejdź do LoginPage
        driver.get(loginPage);
    }

    @When("^user successfully sign in using: (.*), (.*)$")

    public void userSignIn(String login, String password) {

        WebElement emailInputField = driver.findElement(By.name("email"));
        emailInputField.sendKeys(login);

        WebElement passwordInputField = driver.findElement(By.name("password"));
        passwordInputField.sendKeys(password);
        driver.findElement(By.id("submit-login")).click();

    }

    @Then("^user should be on \"your account\" page$")
    public void checkIfUserIsOnMyAccountPage() {
        try {
            String pageHeader = driver.findElement(By.className("page-header")).getText();
            Assert.assertTrue(pageHeader.contains("Your account"));
            System.out.println(GREEN + "Successful login" +RESET);
        } catch (AssertionError error) {
            System.out.println(RED + "Unsuccessful login" + RESET);
        }
    }

    @When("^user goes to address page$")
    public void userGoesToNewAddressPage() {
//        driver.findElement(By.id("address-link")).click();
        driver.get(addressPage);
        newAddressPage = new NewAddressPage(driver);
        System.out.println(GREEN + "Going to new address page" + RESET);
    }

    @Then("^user should be on \"create new address\" page$")
    public void checkIfUserIsOnAddressPage() {
        try {
            String pageHeader = driver.findElement(By.className("page-header")).getText();
            Assert.assertTrue(pageHeader.contains("New address"));
            System.out.println(GREEN + "User is on New Address page" + RESET);
        } catch (AssertionError error) {
            System.out.println(RED + "This is not New Address page" + RESET);
        }

    }

    @When("^user fills and save form with new address$")
    public void userFillsAndSaveForm() throws InterruptedException {
        System.out.println(GREEN + "Adding new address" + RESET);


        newAddressPage.inputAlias(alias);
        newAddressPage.inputAddress(address);
        newAddressPage.inputCity(city);
        newAddressPage.inputZip(zipCode);
        newAddressPage.chooseCountry(countryCode);
        newAddressPage.inputPhone(phone);
        Thread.sleep(1000);
        newAddressPage.saveAddress();


    }

    @Then("^user see success prompt$")
    public void userSeeSuccessPrompt() {
        try {
            YourAddressesPage yourAddressesPage = new YourAddressesPage(driver);
            Assert.assertEquals("Address successfully added!",
                    yourAddressesPage.getAddressAddedMessage());
            System.out.println(GREEN + "Address successfully added" + RESET);
        } catch (AssertionError error) {
            System.out.println(RED + "Something went wrong" + RESET);

        }
    }

    @Then("^user checks if added address is correct$")
    public void checkingNewAddress(){
        System.out.println(GREEN + "Checking if address is correct");
        String lastAddress = "//*[@class='col-lg-4 col-md-6 col-sm-6']" +
                "[last()]//*[@class='address']//*[@class='address-body']/address";
        WebElement lastAddressElement = driver.findElement(By.xpath(lastAddress));
        String newAddedAddress = lastAddressElement.getText();
        Assert.assertTrue(newAddedAddress.contains(address));
        System.out.println("Address ok");
        Assert.assertTrue(newAddedAddress.contains(zipCode));
        System.out.println("ZipCode ok");
        Assert.assertTrue(newAddedAddress.contains(city));
        System.out.println("City ok");
        Assert.assertTrue(newAddedAddress.contains(country));
        System.out.println("Country ok");
        Assert.assertTrue(newAddedAddress.contains(String.valueOf(phone)));
        System.out.println("Phone ok" + RESET);

        }

    @When("^user delete added address$")
    public void userDeleteAddedAddress() {
        String lastAddressDelete = "//*[@class='col-lg-4 col-md-6 col-sm-6']" +
                "[last()]//*[@class='address']//*[@class='address-footer']/a[contains(.,'Delete')]";
        WebElement element = driver.findElement(By.xpath(lastAddressDelete));
        element.click();


    }

    @Then("^user checks if address is deleted$")
    public void userChecksIfAddressIsDeleted() {
        try {
            YourAddressesPage yourAddressesPage = new YourAddressesPage(driver);
            Assert.assertEquals("Address successfully deleted!",
                    yourAddressesPage.getAddressDeletedMessage());
            System.out.println(GREEN + "Address successfully deleted!" + RESET);
        } catch (AssertionError error) {
            System.out.println(RED + "Something went wrong" + RESET);
            throw error;

        }
        driver.quit();

    }

    @And("^browser quits$")
    public void browserQuits() {
        System.out.println(BMAG + "MISSION2 ACCOMPLISHED" + RESET);
        driver.quit();
    }
}

//TODO: dopisać feature do dodatkowych zadań
//TODO: zrobić runnery
//TODO: Poprawi&#x107; try assert
//TODO: poprawić thread.sleep na implicitywait
//TODO: dodać timestampa do nazw plików - screenshot
//TODO: niepoprawny assert -> printscreen z miejscem w którym wystąpił ?