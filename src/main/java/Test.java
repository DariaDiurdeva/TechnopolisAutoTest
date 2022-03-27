import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Test {

    @org.junit.jupiter.api.Test
    public void  Test(){
        open("https://ok.ru");
        //Configuration.pageLoadTimeout(40, TimeUnit.SECONDS);
        User user = new User("Блин Блинчиков", "89119877204","blin");
        LoginPage loginPage = new LoginPage();
        MainPage mainPage = new MainPage();
        loginPage.login(user);
        try{
            assertEquals(mainPage.getName(), user.getName());
        } catch(Exception e){
            System.out.println("No such elements");
        }

    }

}
