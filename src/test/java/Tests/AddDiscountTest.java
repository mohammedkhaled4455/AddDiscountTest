package Tests;

import Pages.DashPage;
import Pages.LoginPage;
import Pages.AddDiscount;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class AddDiscountTest extends TestBase {
    LoginPage loginPage;
    DashPage dashPage;
    AddDiscount addDiscount;
    @Test
    public void AddEditDiscount() throws IOException, InterruptedException {
        loginPage = new LoginPage(driver);
        loginPage.LogIn("admin@yourstore.com", "admin");
        dashPage = new DashPage(driver);
        dashPage.Open_discountPage();
        addDiscount = new AddDiscount(driver);
        addDiscount.addNewDiscount("50 percent discount",2,false,50,1);
        Assert.assertTrue(addDiscount.success.getText().contains("successfully"));
    }
}
