import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

public class MainPage {
    public String getName(){
        SelenideElement element = $(By.xpath("//*[@id=\"hook_Block_Navigation\"]/div/div/a[1]/div"));
        return element.getText();
    }
}
