package pages.Wrappers;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ToolBarWrapper {
    private SelenideElement toolbar;
    private final String xPathMessageButton=".//*[@data-l='t,messages']";
    private final String xPathMiniToolbar = ".//*[@class='ucard-mini toolbar_ucard js-toolbar-menu']";
    private final String exitButton = "//*[@data-l=\"t,logout\"]";
    private final String confirmExitButton = "//*[@class='form-actions __center']//*[@data-l='t,logout']";

    public ToolBarWrapper(SelenideElement toolbar){
        this.toolbar = toolbar;
    }

    public void getMessagesPage(){
       toolbar.$(By.xpath(xPathMessageButton)).click();
    }

    public void openMiniToolbar(){
        toolbar.$(By.xpath(xPathMiniToolbar)).click();
    }
    public void exit(){
        openMiniToolbar();
        $(By.xpath(exitButton)).shouldBe(Condition.visible.because("Button exit not displayed")).click();
        $(By.xpath(confirmExitButton)).shouldBe(Condition.visible.because("Confirm button exit not displayed")).click();
    }
}
