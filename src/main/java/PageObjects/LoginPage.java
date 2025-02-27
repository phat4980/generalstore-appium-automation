package PageObjects;

import Utils.Actions;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends Actions {
    AndroidDriver driver;
    public LoginPage(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "com.androidsample.generalstore:id/nameField")
    private WebElement nameField;

    @AndroidFindBy(xpath = "//android.widget.RadioButton[@resource-id=\"com.androidsample.generalstore:id/radioMale\"]")
    private WebElement maleGender;

    @AndroidFindBy(xpath = "//android.widget.RadioButton[@resource-id=\"com.androidsample.generalstore:id/radioFemale\"]")
    private WebElement femaleGender;

    @AndroidFindBy(id = "android:id/text1")
    private WebElement countrySelector;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/btnLetsShop")
    private WebElement loginButton;

    public void setNameField(String name) {
        nameField.sendKeys(name);
    }

    public String getNameField() {
        return nameField.getText();
    }

    public void setGender(String gender) {
        if (gender.contains("male")) {
            if (!maleGender.isSelected()) {
                maleGender.click();
            }
        } else if (gender.contains("female")) {
            if (!femaleGender.isSelected()) {
                femaleGender.click();
            }
        }
    }

    public String getGender() {
        String maleChecked = maleGender.getAttribute("checked"); // Returns "true" if selected
        String femaleChecked = femaleGender.getAttribute("checked");

        if ("true".equals(maleChecked)) {
            return "Male";
        } else if ("true".equals(femaleChecked)) {
            return "Female";
        }
        return "none";
    }


    public void setCountrySelector(String countryName) {
        countrySelector.click();
        scrollToText(countryName);
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\""+countryName+"\"]")).click();
    }

    public String getCountrySelector() {
        return countrySelector.getText();
    }

    public void clickLoginButton() {
        loginButton.click();
    }
}
