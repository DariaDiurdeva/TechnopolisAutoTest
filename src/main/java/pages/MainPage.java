package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import pages.Wrappers.ToolBarWrapper;

import static com.codeborne.selenide.Selenide.$;

public class MainPage extends BasePage{

    private final String xPathFullName = "//*[@id=\"hook_Block_Navigation\"]/div/div/div[1]/a/div";
    private ToolBarWrapper toolbar = new ToolBarWrapper($(By.xpath("//div[contains(@data-module,'ToolbarManager')]")));

    public MainPage(){
        isLoaded();
    }

    public String getName(){
        SelenideElement element = $(By.xpath(xPathFullName));
        return element.getText();
    }

    public MessagePage openMessage(){
        toolbar.getMessagesPage();
        return  new MessagePage();
    }

    public LoginPage exit(){
        toolbar.exit();
        return new LoginPage();
    }

    @Override
    public void isLoaded() {
       $(By.xpath(xPathFullName)).shouldBe(Condition.visible.because("Fullname not displayed"));
    }
}
