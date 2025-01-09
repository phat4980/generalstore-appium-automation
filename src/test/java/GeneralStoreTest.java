import PageObjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GeneralStoreTest extends BaseTest {
    @Test
    public void LoginFormTest() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);

        // Input login form
        String expectedCountry = "Vietnam";
        String expectedName = "TanPhat";

        loginPage.setCountrySelector("Vietnam");
        loginPage.setNameField("TanPhat");
        loginPage.setGender("Male");

        // Assert
        Assert.assertEquals(loginPage.getCountrySelector(), expectedCountry, "Country does not match!");
        Assert.assertEquals(loginPage.getNameField(), expectedName, "Name does not match!");

        loginPage.clickLoginButton();
        Thread.sleep(3000);
    }
}
