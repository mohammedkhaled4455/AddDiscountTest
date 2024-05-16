package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class AddDiscount extends PageBase {
    public AddDiscount(WebDriver driver) {
        super(driver);
    }
    @FindBy(css ="body > div.wrapper > div.content-wrapper > div.content-header.clearfix > div > a")
    WebElement new_btn;

    @FindBy(id = "Name")
    WebElement goto_name;

    @FindBy(id = "DiscountTypeId")
    WebElement categoryType;

    String[] categories= {"Assigned to order total","Assigned to products","Assigned to categories","Assigned to manufacturers","Assigned to shipping","Assigned to order subtotal"};

    @FindBy(id = "UsePercentage")
    WebElement usePercentage;

    @FindBy(id = "DiscountAmount")
    WebElement amount;

    @FindBy(id = "DiscountPercentage")
    WebElement percentage;

    @FindBy (id = "RequiresCouponCode")
    WebElement checkCouponCode;

    @FindBy (id = "CouponCode")
    WebElement couponCode;

    @FindBy(name = "save")
    WebElement save;

    @FindBy(css = "body > div.wrapper > div.content-wrapper > div.alert.alert-success.alert-dismissable")
    public WebElement success;

    public void addNewDiscount(String name,int type, boolean percent, int value,int code){
        new_btn.click();
        goto_name.sendKeys(name);
        categoryType.click();
        Select selectDiscountCategory = new Select(categoryType);
        selectDiscountCategory.selectByVisibleText(categories[type - 1]);
        //categoryType.findElement(By.xpath("//option[. = '"+categories[type-1]+"']")).click();
        if (percent)
        {
            usePercentage.click();
            percentage.clear();
            percentage.sendKeys(Integer.toString(value));
        }
        else
        {
            amount.clear();
            amount.sendKeys(Integer.toString(value));
        }
        checkCouponCode.click();
        couponCode.sendKeys(Integer.toString(code));

        save.click();
    }
}
