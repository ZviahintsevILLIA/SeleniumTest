package register.form.test;

import org.apache.commons.collections.ListUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class RegisterTestPage {
    private WebDriver driver;
    private String longText = "12345678901234567890123456789012345678901234567890123456789012345678901234567890" +
    "1234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890124567801234590";

    @BeforeSuite
    public void setUp() {
        driver = new FirefoxDriver();
    }
    @BeforeMethod
    public void openURL() {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://www.cheapdomains.com.au/register/member_register_test.php");
    }

    @AfterSuite
    public void closeTest () {
//        driver.close();
    }

    @Test (description = "Bug 1. Validation of field First Name", priority = 1,enabled = false)
    public void validFirstName() {
        boolean testPassed = false;
        HomePage home = new HomePage(driver);
        home.fillAllFieldsCorrectlyPersonal();
        home.fillFirstName("!@#$%^&*()"); //put invalid first name
        home.submit();
        try {
            Alert alert = driver.switchTo().alert();
            String message = alert.getText();
            alert.accept();
            String [] invalidFields = message.split("\n");
            for (String invalidField : invalidFields) {
                if (invalidField.contains("First Name")) {
                    testPassed = true;
                    break;
                }
            }
        }
        finally {
            Assert.assertTrue(testPassed);
        }
    }
    @Test (description = "Bug 2. Validation of field Last Name", priority = 2,enabled = false)
    public void validLastName() {
        boolean testPassed = false;
        HomePage home = new HomePage(driver);
        home.fillAllFieldsCorrectlyPersonal();
        home.fillLastName("!@#$%^&*()"); //put invalid last name
        home.submit();
        try {
            Alert alert = driver.switchTo().alert();
            String message = alert.getText();
            alert.accept();
            String [] invalidFields = message.split("\n");
            for (String invalidField : invalidFields) {
                if (invalidField.contains("Last Name")) {
                    testPassed = true;
                    break;
                }
            }
        }
        finally {
            Assert.assertTrue(testPassed);
        }
    }
    @Test (description = "Bug 3. Validation of field Address", priority = 3,enabled = false)
    public void validAddress() {
        boolean testPassed = false;
        HomePage home = new HomePage(driver);
        home.fillAllFieldsCorrectlyPersonal();
        home.fillAddress(longText); //put invalid address
        home.submit();
        try {
            Alert alert = driver.switchTo().alert();
            String message = alert.getText();
            alert.accept();
            String [] invalidFields = message.split("\n");
            for (String invalidField : invalidFields) {
                if (invalidField.contains("Address")) {
                    testPassed = true;
                    break;
                }
            }
        }
        finally {
            Assert.assertTrue(testPassed);
        }
    }
    @Test (description = "Bug 4. Validation of field City", priority = 4,enabled = false) //No validation as postcode
    public void validCity() {
        boolean testPassed = false;
        HomePage home = new HomePage(driver);
        home.fillAllFieldsCorrectlyPersonal();
        home.fillCity(longText); //put invalid city
        home.submit();
        try {
            Alert alert = driver.switchTo().alert();
            String message = alert.getText();
            alert.accept();
            String [] invalidFields = message.split("\n");
            for (String invalidField : invalidFields) {
                if (invalidField.contains("City")) {
                    testPassed = true;
                    break;
                }
            }
        }
        finally {
            Assert.assertTrue(testPassed);
        }
    }
    @Test (description = "Bug 5. Validation of Postcode", priority = 5,enabled = false)
    public void validPostcode() {
        boolean testPassed = false;
        HomePage home = new HomePage(driver);
        home.fillAllFieldsCorrectlyPersonal();
        home.fillPostcode("!@#$%^&*()"); //put invalid postcode
        home.submit();
        try {
            Alert alert = driver.switchTo().alert();
            String message = alert.getText();
            alert.accept();
            String [] invalidFields = message.split("\n");
            for (String invalidField : invalidFields) {
                if (invalidField.contains("Post Code")) {
                    testPassed = true;
                    break;
                }
            }
        }
        finally {
            Assert.assertTrue(testPassed);
        }
    }
    @Test (description = "Bug 6. Select border line “---------” as a country", priority = 6,enabled = false)
    public void validCountry() {
        boolean testPassed = false;
        HomePage home = new HomePage(driver);
        home.fillAllFieldsCorrectlyPersonal();
        home.selectCountrySimpleWithoutStateChange("-----------------"); //put invalid country
        home.submit();
        try {
            Alert alert = driver.switchTo().alert();
            String message = alert.getText();
            alert.accept();
            String [] invalidFields = message.split("\n");
            for (String invalidField : invalidFields) {
                if (invalidField.contains("Country")) {
                    testPassed = true;
                    break;
                }
            }
        }
        finally {
            Assert.assertTrue(testPassed);
        }
    }
    @Test (description = "Bug 7. Validation of State", priority = 7,enabled = false)
    public void validState() {
        boolean testPassed = false;
        HomePage home = new HomePage(driver);
        home.fillAllFieldsCorrectlyPersonal();
        home.fillState(longText); //put invalid state
        home.submit();
        try {
            Alert alert = driver.switchTo().alert();
            String message = alert.getText();
            alert.accept();
            String [] invalidFields = message.split("\n");
            for (String invalidField : invalidFields) {
                if (invalidField.contains("State")) {
                    testPassed = true;
                    break;
                }
            }
        }
        finally {
            Assert.assertTrue(testPassed);
        }
    }
    @Test (description = "Bug 8. Validation of Phone Number", priority = 8,enabled = false)
    public void validPhone() {
        boolean testPassed = false;
        HomePage home = new HomePage(driver);
        home.fillAllFieldsCorrectlyPersonal();
        home.fillPhone("qqqqqqqqqqq1"); //put invalid phone number
        home.submit();
        try {
            Alert alert = driver.switchTo().alert();
            String message = alert.getText();
            alert.accept();
            String [] invalidFields = message.split("\n");
            for (String invalidField : invalidFields) {
                if (invalidField.contains("Phone")) {
                    testPassed = true;
                    break;
                }
            }
        }
        finally {
            Assert.assertTrue(testPassed);
        }
    }
    @Test (description = "Bug 9. Validation of Email", priority = 9,enabled = false)
    public void validEmail() {
        boolean testPassed = false;
        HomePage home = new HomePage(driver);
        home.fillAllFieldsCorrectlyPersonal();
        home.fillEmail("@.gi"); //put invalid email
        home.submit();
        try {
            Alert alert = driver.switchTo().alert();
            String message = alert.getText();
            alert.accept();
            String [] invalidFields = message.split("\n");
            for (String invalidField : invalidFields) {
                if (invalidField.contains("Email")) {
                    testPassed = true;
                    break;
                }
            }
        }
        finally {
            Assert.assertTrue(testPassed);
        }
    }
    @Test (description = "Bug 10. Fields “Business Name” and “Business Number” a hidden", priority = 10,enabled = false)
    public void hiddenFields() {
        boolean testPassed = false;
        HomePage home = new HomePage(driver);
        if (home.getUserTypeBusiness().isSelected()) { //if user type is business
            if (home.getBusinessName().isDisplayed()&&home.getBusinessNumber().isDisplayed()) testPassed = true;
        }
        else testPassed = true;
        Assert.assertTrue(testPassed);

    }
    @Test (description = "Bug 11. Validation of Business Name", priority = 11,enabled = false)
    public void validBusinessName() {
        boolean testPassed = false;
        HomePage home = new HomePage(driver);
        home.fillAllFieldsCorrectlyBusiness();
        home.fillBusinessName(longText); //put invalid business name
        home.submit();
        try {
            Alert alert = driver.switchTo().alert();
            String message = alert.getText();
            alert.accept();
            String [] invalidFields = message.split("\n");
            for (String invalidField : invalidFields) {
                if (invalidField.contains("Business Name")) {
                    testPassed = true;
                    break;
                }
            }
        }
        finally {
            Assert.assertTrue(testPassed);
        }
    }
    @Test (description = "Bug 12. Validation of Business Phone", priority = 12,enabled = false)
    public void validBusinessPhone() {
        boolean testPassed = false;
        HomePage home = new HomePage(driver);
        home.fillAllFieldsCorrectlyBusiness();
        home.fillBusinessPhone("phone"); //put invalid business phone
        home.submit();
        try {
            Alert alert = driver.switchTo().alert();
            String message = alert.getText();
            alert.accept();
            String [] invalidFields = message.split("\n");
            for (String invalidField : invalidFields) {
                if (invalidField.contains("Business Number")) {
                    testPassed = true;
                    break;
                }
            }
        }
        finally {
            Assert.assertTrue(testPassed);
        }
    }
    @Test (description = "Bug 13. Wrong element in line near Business Number", priority = 13,enabled = false)
    public void wrongElement() {
        HomePage home = new HomePage(driver);
        home.getUserTypeBusiness().click();
        Assert.assertFalse(driver.findElement(By.xpath(".//*[@id='business_type_div']")).isDisplayed());
    }
    @Test (description = "Bug 14. Validation of Username", priority = 14,enabled = false)
    public void validUsername() {
        boolean testPassed = false;
        HomePage home = new HomePage(driver);
        home.fillAllFieldsCorrectlyPersonal();
        home.fillUsername("1"); //put invalid username
        home.fillFirstName("ILLIA"); //because Bug 16
        home.submit();
        try {
            Alert alert = driver.switchTo().alert();
            String message = alert.getText();
            alert.accept();
            String [] invalidFields = message.split("\n");
            for (String invalidField : invalidFields) {
                if (invalidField.contains("Username")) {
                    testPassed = true;
                    break;
                }
            }
        }
        finally {
            Assert.assertTrue(testPassed);
        }
    }
    @Test (description = "Bug 15. Validation of Username", priority = 15,enabled = false)
    public void validPassword() {
        boolean testPassed = false;
        HomePage home = new HomePage(driver);
        home.fillAllFieldsCorrectlyPersonal();
        home.fillPassword("123"); //put invalid password
        home.submit();
        try {
            Alert alert = driver.switchTo().alert();
            String message = alert.getText();
            alert.accept();
            String [] invalidFields = message.split("\n");
            for (String invalidField : invalidFields) {
                if (invalidField.contains("Password")) {
                    testPassed = true;
                    break;
                }
            }
        }
        finally {
            Assert.assertTrue(testPassed);
        }
    }
    @Test (description = "Bug 16. Clearing of the field “First Name”, when click any element after input Username",
            priority = 16,enabled = false)
    public void passwordBug() {
        HomePage home = new HomePage(driver);
        String testName = "ILLIA";
        home.fillFirstName(testName);
        home.fillUsername(testName);
        home.fillLastName("");
        Assert.assertTrue(home.getFirstName().getAttribute("value").equals(testName));
    }
    @Test (description = "Bug 17. While selecting State in Australia country, " +
            "Phone Number prefix must be autofill in international format",
            priority = 17,enabled = false)
    public void autofillPhonePrefixAustraliaState() {
        HomePage home = new HomePage(driver);
        home.selectStateOfDifficaltCountry("Australia","Australian Capital Territory");
        Assert.assertTrue(home.getPhoneNumber().getAttribute("value").equals("+612"));
    }
    @Test (description = "Bug 18. Wrong autofill of State field while select New Zealand Country",
            priority = 18,enabled = false)
    public void wrongStateAutofillNewZealand() {
        HomePage home = new HomePage(driver);
        home.getCountry().selectByVisibleText("New Zealand");
        Assert.assertTrue(home.getState().getAttribute("value").equals(""));
    }
    @Test (description = "Bug 19. In Japan Country list of states is not sorted alphabetically",
            priority = 19,enabled = false)
    public void sortingOfJapanStates() {
        HomePage home = new HomePage(driver);
        home.selectCountry("Japan"); //You can try this test for "United States"
        Select stateSelectable = new Select(home.getState());
        List<WebElement> states = stateSelectable.getOptions();
        states.remove(0);
        List<String> statesByNames = new ArrayList<String>();
        for (WebElement state : states) {
            statesByNames.add(state.getText());
        }
        List<String> sortedStatesNames = new ArrayList<String>(statesByNames);
        Collections.sort(sortedStatesNames);
        Assert.assertTrue(ListUtils.isEqualList(statesByNames,sortedStatesNames));
    }
    @Test (description = "Bug 20. When user select wrong country in full countries list, which also present in " +
            "favorite list and try to select country again, selected one will in favorites list, so need to scroll down",
            priority = 20,enabled = false)
    public void retrySelectCountryBug() {
        HomePage home = new HomePage(driver);
        int a = 21; //21 - index of Australia in full countries list
        home.getCountry().selectByIndex(a);
        int indexOfSelectedCountry = Integer.parseInt(home.getCountry().getFirstSelectedOption().getAttribute("index"));
        Assert.assertTrue(a == indexOfSelectedCountry);
    }
    @Test (description = "Bug 21. The Bahamas as The Gambia must contain article “The”", priority = 21,enabled = false)
    public void BahamasBug() {
        boolean testPassed = false;
        HomePage home = new HomePage(driver);
        List<WebElement> countries = home.getCountry().getOptions();
        for (WebElement country : countries) {
            String s = country.getText();
            if (s.equals("Bahamas")) {
                break;
            }
            if (s.equals("Bahamas, The")) {
                testPassed = true;
                break;
            }
        }
        Assert.assertTrue(testPassed);
    }
    @Test (description = "Bug 22. While selecting Hong Kong S.A.R. Country, Postcode autofill with “00000”",
            priority = 22,enabled = false)
    public void autofillHongKongPostcode() {
        HomePage home = new HomePage(driver);
        String testPostcode = "01001";
        home.fillPostcode(testPostcode);
        home.selectCountry("Hong Kong S.A.R.");
        Assert.assertTrue(testPostcode.equals(home.getPostcode().getAttribute("value")));
    }
    @Test (description = "Bug 23. While selecting Jamaica Country, field State is not available",
            priority = 23,enabled = false)
    public void notAvailableStateOnJamaica() {
        HomePage home = new HomePage(driver);
        home.selectCountry("Jamaica");
        try {
            home.getState();
        }
        catch (Exception e) {
            Assert.assertTrue(false);
        }

    }
    @Test (description = "Bug 24. While selecting United Arab Emirates Country, Postcode autofill with “00000”",
            priority = 24,enabled = true)
    public void autofillUAEPostcode() {
        HomePage home = new HomePage(driver);
        String testPostcode = "01001";
        home.fillPostcode(testPostcode);
        home.selectCountry("United Arab Emirates");
        Assert.assertTrue(testPostcode.equals(home.getPostcode().getAttribute("value")));
    }
}
