package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

public class MainPage {

    private final String xPathFullName = "//*[@id=\"hook_Block_Navigation\"]/div/div/a[1]/div";
    private final String xPathExitButton = "//*[@data-l=\"t,logout\"]";
    public String getName(){
        SelenideElement element = $(By.xpath(xPathFullName));
        return element.getText();
    }

    public MessagePage getMessagePage(){
        $(By.xpath("//div[@class='toolbar_nav_a toolbar_nav_a__messa js-msg-tt h-mod']")).click();
        return new MessagePage();
    }

    public LoginPage exit(){
        $(By.xpath("//*[@class=\"ucard-mini toolbar_ucard js-toolbar-menu\"]")).click();
        $(By.xpath(xPathExitButton)).click();
        $(By.xpath("//*[@class='form-actions __center']//*[@data-l='t,logout']")).click();
        return new LoginPage();
    }
}
