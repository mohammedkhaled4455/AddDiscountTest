package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase{
    public LoginPage(WebDriver driver)
    {
        super(driver);
    }
    @FindBy(id="Email")
    WebElement mail;
    @FindBy(id="Password")
    WebElement pass;
    @FindBy(className="login-button")
    WebElement logBtn;

    public void LogIn(String email,String password)
    {
        mail.clear();
        mail.sendKeys(email);

        pass.clear();
        pass.sendKeys(password);

        logBtn.click();
    }
}