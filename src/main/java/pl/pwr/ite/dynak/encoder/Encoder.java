package pl.pwr.ite.dynak.encoder;

import pl.pwr.ite.dynak.data.Input;

public class Encoder {
    private char[][] key;
    private String data;
    public Encoder(Input encoderData) {
        this.key = encoderData.getKey();
        this.data = encoderData.getData();
    }
    public String encode() {
        String encodedString = ""; //TODO: encoding logic
        return encodedString;
    }
}
