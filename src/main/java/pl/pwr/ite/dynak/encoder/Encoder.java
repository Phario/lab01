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
            Integer[] firstPosition = KeyBrowser.getPosition(workableData[i]);
            Integer[] secondPosition = KeyBrowser.getPosition(workableData[i+1]);
            //different rows and columns:
            if (!(firstPosition[0].equals(secondPosition[0])) && !(firstPosition[1].equals(secondPosition[1]))) {
                encodedString.append(key[secondPosition[0]][firstPosition[1]]);
                encodedString.append(key[firstPosition[0]][secondPosition[1]]);
            }
            //same row, different column:
            else if (!(firstPosition[0].equals(secondPosition[0])) && (firstPosition[1].equals(secondPosition[1]))) {
                encodedString.append(key[][]);
                encodedString.append(key[][]);
            }
            //same column, different row:
            else if ((firstPosition[0].equals(secondPosition[0])) && !(firstPosition[1].equals(secondPosition[1]))) {
                encodedString.append(key[][]);
                encodedString.append(key[][]);
            }
            //same letter
            else () {
                //TODO: increase i by 1 and insert x between the letters, make sure string has even number of character, otherwise add x
            }
        }
        //TODO: encoding logic
        return encodedString.toString();
    }
}
