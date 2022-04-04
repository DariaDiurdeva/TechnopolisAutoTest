package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

public class MainPage {

    private final String xPathFullName = "//*[@id=\"hook_Block_Navigation\"]/div/div/a[1]/div";
    public String getName(){
        SelenideElement element = $(By.xpath(xPathFullName));
        return element.getText();
    }
}
