package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashPage extends PageBase {
    @FindBy(css = "li.has-treeview:nth-child(5)")
    private WebElement promotions_group;

    @FindBy(css = "body > div.wrapper > aside > div > div.os-padding > div > div > nav > ul > li:nth-child(5) > ul > li:nth-child(1) > a")
    private  WebElement Discounts;

    private void Collapse_group(WebElement list_group) {
        list_group.click();
        list_group.click();
    }

    public DashPage(WebDriver driver) {
        super(driver);
    }

    public void Open_discountPage() {
        Collapse_group(promotions_group);
        Discounts.click();
    }
}
