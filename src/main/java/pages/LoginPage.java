package pages;

import com.codeborne.selenide.Condition;
import data.User;
import org.openqa.selenium.By;
import pages.main.MainPage;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage extends BasePage{

    private By loginField = By.name("st.email");
    private By passwordField = By.name("st.password");
    private By button = By.xpath("//*[@data-l='t,sign_in']");

    private String loginFieldLoadError = "Login field not loaded";
    private String passwordFieldLoadError = "Password field not loaded";
    private String buttonLoadError = "Not loaded button log in";

    public LoginPage(){
        isLoaded();
    }

    public MainPage login(User user){
        $(loginField).setValue(user.getLogin());
        $(passwordField).setValue(user.getPassword());
        $(button).click();
        return new MainPage();
    }

    @Override
    public void isLoaded() {
        $(loginField).shouldBe(Condition.visible.because(loginFieldLoadError));
        $(passwordField).shouldBe(Condition.visible.because(passwordFieldLoadError));
        $(button).shouldBe(Condition.visible.because(buttonLoadError));
    }

    public boolean intoLoginPage(){
        return  $(loginField).isDisplayed();
    }
}
