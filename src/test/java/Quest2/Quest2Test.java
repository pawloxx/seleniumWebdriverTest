package Quest2;



import Quest2.backend.PhoneNumberGenerator;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;


public class Quest2Test {

    //    variables
    public String loginPage = "https://prod-kurs.coderslab.pl/" +
            "index.php?controller=authentication&back=my-account";
    private String orderReference;
    private String orderPrice;
    private String orderSummary;
    public String address = "BARTŁOMIEJOWA 99";
    public String city = "BARTŁOMIEJOWO";
    public String zipCode = "66-666";
    public int phone = PhoneNumberGenerator.randomPhoneNumber();
    public String countryCode = "17";

    public WebDriver driver;
    //    colors for console output
    public static final String GREEN = "\033[0;32m";
    public static final String RED = "\033[0;31m";
    public static final String RESET = "\033[0m";
    public static final String BMAG = "\u001b[36;1m";

    @Given("^open browser with login page$")
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

    @When("^user sign in using: (.*), (.*)$")

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
            System.out.println(GREEN + "Successful login" + RESET);
        } catch (AssertionError error) {
            System.out.println(RED + "Unsuccessful login" + RESET);
        }
    }

    @When("^user put name of item in the search box and clicks ENTER button$")
    public void userPutNameOfItemInTheSearchBox() {
        String searchBoxXpath = "//*[@id='search_widget']/form/input[@name='s']";
        driver.findElement(By.xpath(searchBoxXpath)).clear();
        driver.findElement(By.xpath(searchBoxXpath)).click();
        driver.findElement(By.xpath(searchBoxXpath)).sendKeys("Hummingbird Printed Sweater", Keys.ENTER);
    }

    @Then("^user should be on search results page$")
    public void userShouldSeeResultsOfSearching() {
        String searchPage = driver.findElement(By.xpath("//*[@id='js-product-list-header']")).getText();
        Assert.assertTrue(searchPage.contains("SEARCH RESULTS"));
        System.out.println(GREEN + searchPage + RESET);
    }

    @When("^user clicks on specific item$")
    public void userClicksOnSpecificItem() {
        String chosenItem = "//a[.='Hummingbird printed sweater']";
        driver.findElement(By.xpath(chosenItem)).click();
        System.out.println(GREEN + "Click on specific item" + RESET);
    }

    @Then("^user should be on item page$")
    public void userShouldBeOnItemPage() {
        String header = driver.findElement(By.linkText("Hummingbird printed sweater")).getText();
        Assert.assertTrue(header.contains("Hummingbird printed sweater"));
        System.out.println(GREEN + "User is on selected item page" + RESET);

    }

    @And("^user should check discount$")
    public void userShouldCheckIfDiscount() {
        WebElement discount = driver.findElement(By.xpath("//span[contains(concat(' ', @class, ' '), " +
                "'discount discount-percentage')]"));
        discount.getText();
        Assert.assertTrue(discount.getText().contains("SAVE 20%"));
        System.out.println(GREEN + "Discount = 20%" + RESET);

    }

    @When("^user chooses item (.*)$")
    public void userChoosesSize(String sizeOfItem) throws InterruptedException {
        Select dropDownValue = new Select(driver.findElement(By.name("group[1]")));
        dropDownValue.selectByVisibleText(sizeOfItem);
        Thread.sleep(1500);
        System.out.println(GREEN + "Size " + sizeOfItem + " has been chosen" + RESET);

    }

    @Then("^user checks if there is enough products in stock$")
    public void userChecksIfThereIsEnoughProductsInStock() {
            WebElement stockInfo = driver.findElement(By.xpath("//span[contains(concat(' ', @id, ' ')," +
                    "'product-availability')]"));
            if (stockInfo.getText().contains("There are not enough products in stock")) {
                String stockEmptyMessage = "There are not enough products in stock";
                Assert.assertFalse(RED+ stockInfo.getText()+ RESET, stockInfo.getText()
                        .contains(stockEmptyMessage));

            } else {
                System.out.println(GREEN + "There is enough products in stock" + RESET);
            }
    }

    @When("^user choose item (.*)$")
    public void userChooseItemQuantity(int quantity) {
        WebElement quantityField = driver.findElement(By.xpath("//input[contains(concat(' ', @id, ' ')," +
                "'quantity_wanted')]"));

        quantityField.clear();
        quantityField.click();
        quantityField.sendKeys(String.valueOf(quantity));
        System.out.println(GREEN + "Make it " + quantity +" "+ "!!!" + RESET);

    }

    @And("^user clicks 'Add to cart' button$")
    public void userClicksAddToCartButton() {
        WebElement AddToCartBtn = driver.findElement(By.xpath("//button[contains(concat(' ', " +
                "@class, ' '),'btn btn-primary add-to-cart')]"));
        AddToCartBtn.click();
        System.out.println(GREEN + "Button touched");

    }

    @Then("^shop should show prompt and frame with buttons$")
    public void shopShouldShowPromptAndFrameWithButtons() throws InterruptedException {
        Thread.sleep(1100);
        String promptText = "Product successfully added to your shopping cart";
        WebElement promptSource = driver.findElement(By.xpath("//*[@id='myModalLabel']"));
        String promptMessage = promptSource.getText();
        Assert.assertTrue(promptMessage.contains(promptText));
        System.out.println(GREEN + promptText + RESET);

    }


    @When("^user clicks on Proceed to checkout button$")
    public void userClicksOnProceedToCheckoutButton() {
        WebElement proceedCheckout = driver.findElement(By.xpath("//*[@class='cart-content-btn']//*" +
                "[@class='btn btn-primary']"));
        proceedCheckout.click();
        
    }

    @Then("^user should be on Cart Page$")
    public void userShouldBeOnCartPage() {
        WebElement cartSite = driver.findElement(By.xpath("//*[@class='card-block']//*[@class='h1']"));
        Assert.assertEquals(cartSite.getText(),"SHOPPING CART");
        System.out.println(GREEN + cartSite.getText()+ RESET);
    }

    @When("^user clicks again on Proceed to checkout button$")
    public void proceedToCheckout() {
        WebElement proceedCheckout = driver.findElement(By.xpath("//*[@class='text-sm-center']//*" +
                "[@class='btn btn-primary']"));
        proceedCheckout.click();
    }

    @Then("^user should be on checkout page$")
    public void userShouldBeOnOrderPage() {
        WebElement bodyEl = driver.findElement(By.xpath("//*[@id='checkout']"));
        Assert.assertTrue(bodyEl.isDisplayed());
        System.out.println(GREEN + "Checkout Page" + RESET);
    }

    @When("^user approves address and clicks continue button$")
    public void userApprovesAddressAndClicksContinueButton() {
//TODO: poprawić funkcję, ma sprawdzać czy adres istnieje, jak nie to ma uzyć innego feature do wypelnienie pól

//        if (driver.findElement(By.xpath("//*[@class='address-item selected']//*"))
//                .isDisplayed()) {

            WebElement continueButton = driver.findElement(By.xpath("//*[@class='clearfix']//*[@type='submit']"));
            continueButton.click();
            System.out.println(GREEN + "Address ok, continue" + RESET);

//        } else {

//            newAddressPage.inputAddress(address);
//            newAddressPage.inputCity(city);
//            newAddressPage.inputZip(zipCode);
//            newAddressPage.chooseCountry(countryCode);
//            newAddressPage.inputPhone(phone);
//            newAddressPage.saveAddress();
//            System.out.println(GREEN + "Address added, continue" + RESET);
//        }
    }

    @And("^user chooses shipping metod and clicks continue button$")
    public void userChoosesShippingMetod() {
        WebElement shipMetod = driver.findElement(By.xpath("//*[@id='delivery_option_1']"));
        shipMetod.sendKeys("1");

        WebElement continueButton = driver.findElement(By.xpath("//*[@class='continue " +
                "btn btn-primary float-xs-right']"));

        continueButton.click();
        System.out.println(GREEN + "Shipping metod chosen, continue" + RESET);
    }

    @And("^user chooses payment metod$")
    public void userChoosesPaymentMetod() {
        WebElement payMetod = driver.findElement(By.xpath("//*[@id='payment-option-1']"));
        payMetod.click();

        WebElement termsCheckbox = driver.findElement(By.xpath("//*[@id='conditions_to_approve" +
                "[terms-and-conditions]']"));
        termsCheckbox.click();

        WebElement orderButton = driver.findElement(By.xpath("//*[@id='payment-confirmation']//*[@type='submit']"));
        orderButton.click();

    }

    @Then("^user should see order confirmation$")
    public String userShouldSeeOrderConfirmation() {
        String promptText = "YOUR ORDER IS CONFIRMED";
        WebElement promptSource = driver.findElement(By.xpath("//*[@class='h1 card-title']"));
        String promptMessage = promptSource.getText();
        Assert.assertTrue(promptMessage.contains(promptText));
        WebElement orderReferenceObj = driver.findElement(By.xpath("//*[contains(text(),'Order reference:')]"));
        this.orderReference = orderReferenceObj.getText();
        WebElement orderPriceObj = driver.findElement(By.xpath("//*[@class='font-weight-bold']/td[last()]"));
        this.orderPrice = orderPriceObj.getText();
        this.orderSummary = orderReference + "," + orderPrice;
        System.out.println(GREEN + promptText + RESET);
        return orderSummary;

    }

    @And("^user takes a screen shoot$")
    public void userTakesASs() throws IOException {
        File sourceFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(sourceFile, new File("/home/tomasz/Desktop/Coderslab/ZadaniaWarsztatyCL/src" +
                "/test/java/Quest2/screenshots/screenshot.png"));
        System.out.println(GREEN + "Screenshot" + RESET);

    }

    @When("^user goes to order history page$")
    public void userGoesToMyAccountPage() {
        WebElement myAccountLink = driver.findElement(By.xpath("//*[@class='user-info']//*[@class='account']"));
        myAccountLink.click();
        WebElement orderHistoryLink = driver.findElement(By.xpath("//*[@id='history-link']"));
        orderHistoryLink.click();

    }

    @Then("^user checks if order is correct$")
    public void userChecksIfOrderIsCorrect() {

        int iEnd = orderSummary.indexOf(",");
        String price = orderSummary.substring(iEnd + 1);
        String referenceNumber = orderSummary.substring(iEnd - 9, iEnd);

        WebElement orderSummaryObj = driver.findElement(By.xpath("//*[@class='table table-striped " +
                "table-bordered table-labeled hidden-sm-down']/tbody/tr"));
        String orderSummaryStr = orderSummaryObj.getText();
        System.out.println(GREEN + "Price: " + price + "\n" + "Reference Numer: " + referenceNumber + RESET);

        Assert.assertTrue(orderSummaryStr.contains(price));
        Assert.assertTrue(orderSummaryStr.contains(referenceNumber));
        Assert.assertTrue(orderSummaryStr.contains("Awaiting check payment"));

        System.out.println(BMAG + "MISSION2 ACCOMPLISHED" + RESET);

//        driver.quit();
    }
}