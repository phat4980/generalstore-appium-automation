import PageObjects.LoginPage;
import PageObjects.ProductPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class GeneralStoreTest extends BaseTest {
    @Test
    public void testLoginForm() throws InterruptedException {
        // Instantiate Page Object
        LoginPage loginPage = new LoginPage(driver);
        ProductPage productPage = new ProductPage(driver);

        // Expected Values
        final String EXPECTED_COUNTRY = "Vietnam";
        final String EXPECTED_NAME = "TanPhat";
        final String EXPECTED_GENDER = "Male";
        final String EXPECTED_PRODUCT_TITLE = "Products";

        // Step 1: Perform Actions
        loginPage.setCountrySelector(EXPECTED_COUNTRY);
        loginPage.setNameField(EXPECTED_NAME);
        loginPage.setGender(EXPECTED_GENDER);

        // Step 2: Assert Values
        Assert.assertEquals(loginPage.getCountrySelector(), EXPECTED_COUNTRY, "Country does not match!");
        Assert.assertEquals(loginPage.getNameField(), EXPECTED_NAME, "Name does not match!");
        Assert.assertEquals(loginPage.getGender(), EXPECTED_GENDER, "Gender does not match!");

        // Step 3: Click Login Button
        loginPage.clickLoginButton();

        // Step 4: Validate Product Page is displayed
        Thread.sleep(Duration.ofSeconds(2));
        Assert.assertEquals(productPage.getHomePageTitle(), EXPECTED_PRODUCT_TITLE, "Title does not match!");
    }
}
