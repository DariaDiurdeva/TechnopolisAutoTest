package data;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Message {
    private String text;

    public Message(){

    }

    public Message(String text){
        this.text = text;
    }
}
