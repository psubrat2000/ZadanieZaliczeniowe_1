package pl.coderslab.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MyStorePage {

    private WebDriver driver;

    @FindBy(css = "div#_desktop_user_info div.user-info a")
    private WebElement signIn;

    @FindBy(name = "email")
    private WebElement email;

    @FindBy(name = "password")
    private WebElement password;

    @FindBy(id = "submit-login")
    private WebElement logIn;

    @FindBy(id = "addresses-link")
    private WebElement addAddress;

    @FindBy(css = "div.addresses-footer a")
    private WebElement createNewAddress;

    @FindBy(name = "alias")
    private WebElement alias;

    @FindBy(name = "address1")
    private WebElement address;

    @FindBy(name = "city")
    private WebElement city;

    @FindBy(name = "postcode")
    private WebElement postcode;

    @FindBy(name = "id_country")
    private WebElement country;

    @FindBy(name = "phone")
    private WebElement phone;

    @FindBy(css = "button.btn.btn-primary.float-xs-right")
    private WebElement save;

    @FindBy(css = "article.alert.alert-success li")
    private WebElement successMessage;

    @FindBy(css = "article.address div.address-body h4")
    private List<WebElement> savedAlias;

    @FindBy(css = "div.address-body address")
    private List<WebElement> savedAddress;

    @FindBy(css ="div.address-footer a[data-link-action=delete-address]")
    private List<WebElement> addressDeletion;

    public MyStorePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickSignIn() {
        this.signIn.click();
    }

    public void logInToYourAccount() {
        this.email.clear();
        this.email.sendKeys("pdamgiapmwwotjyrll@miucce.com");
        this.password.clear();
        this.password.sendKeys("password123");
        this.logIn.click();
    }

    public void clickAddAddress() {
        this.addAddress.click();
        this.createNewAddress.click();
    }

    public void addAlias(String newAlias) {
        this.alias.sendKeys(newAlias);
    }

    public void addAddress(String newAddress) {
        this.address.sendKeys(newAddress);
    }

    public void addCity(String newCity) {
        this.city.sendKeys(newCity);
    }

    public void addPostcode(String newPostcode) {
        this.postcode.sendKeys(newPostcode);
    }

    public void selectCountry(String newCountry) {
        this.country.sendKeys(newCountry);
    }

    public void addPhone(String newPhone) {
        this.phone.sendKeys(newPhone);
    }

    public void clickSave() {
        this.save.click();
    }

    public String receiveSuccessMessage() {
        return this.successMessage.getText();
    }

    public String readAlias() {
        return this.savedAlias.get(1).getText();
    }

    public String[] readAddress() {
        String savedAddress1 = this.savedAddress.get(1).getText();
        String[] parts = savedAddress1.split("\n");
        return parts;
    }

    public void deleteAddress() {
        this.addressDeletion.get(1).click();
    }
}