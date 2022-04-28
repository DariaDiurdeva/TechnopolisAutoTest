package pages.main;

import org.openqa.selenium.By;

public enum MainPageToolbar {
    MESSAGE(By.xpath("//*[@data-l='t,messages']")),
    MINITOOLBAR(By.xpath("//*[@class='ucard-mini toolbar_ucard js-toolbar-menu']")),
    EXITBUTTON(By.xpath("//*[@data-l=\"t,logout\"]"));

    private By element;

    MainPageToolbar(By element){
        this.element = element;

    }

    public By getElement(){
        return element;
    }

}
