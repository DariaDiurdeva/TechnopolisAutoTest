package pages;

import com.codeborne.selenide.Condition;
import data.User;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage extends BasePage{
    private String xPathLogin ="st.email";
    private String xPathPassword = "st.password";
    private String xPathButton = "//*[@data-l='t,sign_in']";
    private String xPathLoginError = "//*[@class = 'input-e login_error']";

    public LoginPage(){
        isLoaded();
    }
    public MainPage login(User user){
        $(By.name(xPathLogin)).setValue(user.getLogin());
        $(By.name(xPathPassword)).setValue(user.getPassword());
        $(By.xpath(xPathButton)).click();
        if ($(By.xpath(xPathLoginError)).isDisplayed()){
            throw new IllegalArgumentException("Invalid password or login");
        }
        return new MainPage();
    }

    @Override
    public void isLoaded() {
        $(By.name(xPathLogin)).shouldBe(Condition.visible.because("Login field not loaded"));
        $(By.name(xPathPassword)).shouldBe(Condition.visible.because("Password field not loaded"));
        $(By.xpath(xPathButton)).shouldBe(Condition.visible.because("Not loaded button log in"));
    }

    public boolean intoLoginPage(){
        return  $(By.name(xPathLogin)).isDisplayed();
    }
}
