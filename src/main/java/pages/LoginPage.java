package pages;

import data.User;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    private String xPathLogin ="st.email";
    private String xPathPassword = "st.password";
    private String xPathButton = "//*[@class='button-pro __wide']";
    private String xPathLoginError = "//*[@class = 'input-e login_error']";

    public MainPage login(User user){
        $(By.name(xPathLogin)).setValue(user.getLogin());
        $(By.name(xPathPassword)).setValue(user.getPassword());
        $(By.xpath(xPathButton)).click();
        if ($(By.xpath(xPathLoginError)).isDisplayed()){
            throw new IllegalArgumentException("Invalid password or login");
        }
        return new MainPage();
    }
}
