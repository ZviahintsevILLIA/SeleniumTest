package register.form.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by ILONA on 19.09.2016.
 */
public class HomePage {
    private WebDriver driver;
    private WebElement firstName;
    private WebElement lastName;
    private WebElement address;
    private WebElement city;
    private WebElement postcode;
    private Select country;
    private WebElement state;
    private WebElement phoneNumber;
    private WebElement email;
    private WebElement userTypePersonal;
    private WebElement userTypeBusiness;

    private WebElement businessName;
    private WebElement businessNumber;

    private WebElement username;
    private WebElement password;


    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.firstName = driver.findElement(By.name("first_name"));
        this.lastName = driver.findElement(By.name("last_name"));
        this.address = driver.findElement(By.name("address"));
        this.city = driver.findElement(By.name("city"));
        this.postcode = driver.findElement(By.name("post_code"));
        this.country = new Select(driver.findElement(By.name("country")));
        this.state = driver.findElement(By.name("state"));
        this.phoneNumber = driver.findElement(By.name("phone"));
        this.email = driver.findElement(By.name("email"));
        this.userTypePersonal = driver.findElement(By.xpath(".//*[@id='account_type_personal']"));
        this.userTypeBusiness = driver.findElement(By.xpath(".//*[@id='account_type_business']"));
        this.businessName = driver.findElement(By.name("business_name"));
        this.businessNumber = driver.findElement(By.name("business_number"));
        this.username = driver.findElement(By.name("username"));
        this.password = driver.findElement(By.name("password"));

    }
    public WebElement getBusinessName() {
        return businessName;
    }

    public WebElement getBusinessNumber() {
        return businessNumber;
    }

    public WebElement getUserTypeBusiness() {
        return userTypeBusiness;
    }

    public WebElement getUserTypePersonal() {
        return userTypePersonal;
    }

    public WebElement getLastName() {
        return lastName;
    }

    public WebElement getFirstName() {
        return firstName;
    }

    public WebElement getPhoneNumber() {
        return phoneNumber;
    }

    public Select getCountry() {
        return country;
    }

    public WebElement getState() {
        state = driver.findElement(By.name("state"));
        return state;
    }

    public WebElement getPostcode() {
        postcode = driver.findElement(By.name("post_code"));
        return postcode;
    }

    public void fillAllFieldsCorrectlyPersonal() {

        putText(lastName,"ZVIAHINTSEV");
        putText(address, "Gagarina street");
        putText(city, "Kyiv");
        putText(postcode, "01001");
        country.selectByValue("UA");
        putText(driver.findElement(By.name("state")), "Kyiv region");
        putText(phoneNumber, "+380674483306");
        putText(email, "izviahintsev@gmail.com");
        userTypePersonal.click();
        putText(username, "Someusername");
        putText(password, "password123");
        putText(firstName,"ILLIA");
    }

    public void fillAllFieldsCorrectlyBusiness() {
        fillAllFieldsCorrectlyPersonal();
        userTypeBusiness.click();
        putText(businessName, "ILLIA Co.");
        putText(businessNumber,"+380441111111");
    }

    private void putText (WebElement element, String s) { //put text to field
        element.clear();
        element.sendKeys(s);
    }

    public void submit() {//Continue order
        driver.findElement(By.xpath(".//*[@id='content_pad']/form[2]/table[3]/tbody/tr/td[2]/input")).click();
    }

    public void fillFirstName(String s) { //fill first name field
        putText(firstName, s);
    }

    public void fillLastName(String s) {
        putText(lastName,s);
    }

    public void fillAddress(String s) {
        putText(address,s);
    }

    public void fillCity(String s) {
        putText(city,s);
    }

    public void fillPostcode(String s) {
        putText(postcode, s);
    }

    public void selectCountrySimpleWithoutStateChange(String visibleText) {
        String stateCopyValue = driver.findElement(By.name("state")).getAttribute("value");
        country.selectByVisibleText(visibleText);
        putText(driver.findElement(By.name("state")), stateCopyValue);
    }

    public void fillState(String s) {
        state = driver.findElement(By.name("state"));
        putText(state, s);
    }

    public void fillPhone(String s) {
        putText(phoneNumber, s);
    }


    public void fillEmail(String s) {
        putText(email, s);

    }

    public void fillBusinessName(String s) {
        putText(businessName, s);
    }

    public void fillBusinessPhone(String s) {
        putText(businessNumber, s);
    }

    public void fillUsername(String s) {
        putText(username, s);
    }

    public void fillPassword(String s) {
        putText(password, s);
    }

    public void selectStateOfDifficaltCountry(String countryName, String stateName) {
        country.selectByVisibleText(countryName);
        Select state = new Select(driver.findElement(By.name("state")));
        state.selectByVisibleText(stateName);
    }

    public void selectCountry(String s) {
        country.selectByVisibleText(s);
    }

    public void setPersonalUserType() {
        userTypePersonal.click();
    }
}
