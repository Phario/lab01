package pl.pwr.ite.dynak.encoder;

import pl.pwr.ite.dynak.data.Input;
import pl.pwr.ite.dynak.data.KeyBrowser;

import java.util.HashMap;

public class Encoder {
    private Character[][] key;
    private String data;
    public Encoder(Input EncoderData) {
        this.key = EncoderData.getKey();
        this.data = EncoderData.getData();
    }
    public String encode(Input Input) {
        StringBuilder encodedString = new StringBuilder();
        char[] workableData = data.toCharArray();
        KeyBrowser KeyBrowser = new KeyBrowser();
        KeyBrowser.fillKeyMap(key);
        for (int i = 0; i < data.length(); i += 2) {
            if (true) {

            }
        }
        //TODO: encoding logic
        return encodedString.toString();
    }
}
