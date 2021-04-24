package pl.coderslab.mystore.cucumber;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pl.coderslab.mystore.pageobject.MyStorePage;

import static org.junit.Assert.assertEquals;

public class AddAddressSteps {

    private WebDriver driver;
    private MyStorePage myStorePage;

    @Given("an open browser with My Store page")
    public void displayMyStorePage(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        this.driver = new ChromeDriver();
        this.driver.get("https://prod-kurs.coderslab.pl/index.php");
        this.myStorePage = new MyStorePage(driver);
    }

    @When("user \"pdamgiapmwwotjyrll@miucce.com\" logs in")
    public void shouldLogIn() {
        this.myStorePage.clickSignIn();
        this.myStorePage.logInToYourAccount();
    }

    @And("user clicks to add a new address")
    public void shouldClickAddAddress() {
        this.myStorePage.clickAddAddress();
    }

    @And("user fills in the details with {string}, {string}, {string}, {string}, {string}, {string}")
    public void shouldFillAddressDetails(String alias, String address, String city, String postalCode, String country,
                                         String phone) {
        this.myStorePage.addAlias(alias);
        this.myStorePage.addAddress(address);
        this.myStorePage.addCity(city);
        this.myStorePage.addPostcode(postalCode);
        this.myStorePage.selectCountry(country);
        this.myStorePage.addPhone(phone);
    }

    @And("user clicks \"save\"")
    public void shouldClickSave() {
        this.myStorePage.clickSave();
    }

    @Then("a new address is added")
    public void shouldPrintSuccessMessage() {
        assertEquals("Address successfully added!", this.myStorePage.receiveSuccessMessage());
    }

    @Then("the details {string}, {string}, {string}, {string}, {string}, {string} are correct")
    public void shouldConfirmAddress(String alias, String address, String city, String postalCode, String country, String phone) {
        assertEquals(alias, this.myStorePage.readAlias());
        String[] splitAddress = this.myStorePage.readAddress();
        assertEquals(address, splitAddress[1]);
        assertEquals(city, splitAddress[2]);
        assertEquals(postalCode, splitAddress[3]);
        assertEquals(country, splitAddress[4]);
        assertEquals(phone, splitAddress[5]);
    }

    @When("user clicks to delete address")
    public void shouldDeleteAddress() {
        this.myStorePage.deleteAddress();
    }

    @Then("success message is printed")
    public void shouldPrintDeletionMessage() {
        assertEquals("Address successfully deleted!", this.myStorePage.receiveSuccessMessage());
    }
}
