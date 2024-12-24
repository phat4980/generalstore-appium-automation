import PageObjects.LoginPage;
import org.testng.annotations.Test;

public class GeneralStoreTest extends BaseTest {
    @Test
    public void LoginFormTest() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);

        //Input  login form
        loginPage.setCountrySelector("Vietnam");
        loginPage.setNameField("TanPhat");
        loginPage.setGender("Male");
        loginPage.clickLoginButton();

        Thread.sleep(3000);
    }
}
