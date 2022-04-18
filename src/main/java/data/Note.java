package data;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class Note {

    //самый простой вариант с текстом и заголовком

    private String head;
    private String text;
    private String xPathOptionButton = "//*[@class = \"posting_itx_ac_menu\"]";
    private String xPathAddHeadButton = "//*[@data-action = \"add_header\"]";
    private String xPathTextField = "//*[contains(@class, 'ok-posting-handler')]";
    private String xPathHeadField = "//*[@data-id = 'adHeader']";
    private String xPathSendButton = "//*[@data-l = 't,button.submit']";


    public Note(String head, String text){
        this.head = head;
        this.text = text;
    }

    public Note(String text){
        this.text= text;
    }

    public void sendNote(){
        if (head !=null){
            $(By.xpath(xPathOptionButton)).click();
            $(By.xpath(xPathAddHeadButton)).click();
            $(By.xpath(xPathHeadField)).setValue(head);
        }

        if (text != null) {
            $(By.xpath(xPathTextField)).setValue(text);
        }

        $(By.xpath(xPathSendButton)).shouldBe(Condition.visible.because("Button send not displayed")).click();
        $(By.xpath(xPathTextField)).shouldNot(Condition.visible.because("Not exit window note"));
    }


}