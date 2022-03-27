import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    private String xPathLogin ="st.email";
    private String xPathPassword = "st.password";

    public void login(User user){
        $(By.name(xPathLogin)).setValue(user.getLogin());
        $(By.name(xPathPassword)).setValue(user.getPassword()).pressEnter();
    }
}
