package pl.pwr.ite.dynak.encoder;

import pl.pwr.ite.dynak.data.Input;
import pl.pwr.ite.dynak.data.KeyBrowser;
import java.util.Arrays;

public class Encoder {
    private final Character[][] key;
    private final String data;
    private String encodedString;
    public Encoder(Input EncoderData) {
        this.key = EncoderData.getKey();
        this.data = EncoderData.getData();
    }
    public void encode(){
        StringBuilder encodedString = new StringBuilder();
        char[] workableData = data.toCharArray();
        KeyBrowser KeyBrowser = new KeyBrowser();
        KeyBrowser.fillKeyMap(key);
        for (int i = 0; i < data.length(); i += 2) {
            if (data.length() > i+1) {
                Integer[] firstPosition = KeyBrowser.getPosition(workableData[i]);
                Integer[] secondPosition = KeyBrowser.getPosition(workableData[i + 1]);
                //different rows and columns:
                if (!(firstPosition[0].equals(secondPosition[0])) && !(firstPosition[1].equals(secondPosition[1]))) {
                    encodedString.append(key[secondPosition[0]][firstPosition[1]]);
                    encodedString.append(key[firstPosition[0]][secondPosition[1]]);
                }
                //same row, different column:
                else if (!(firstPosition[0].equals(secondPosition[0]))) {
                    encodedString.append(key[(firstPosition[0] + 1) % 5][firstPosition[1]]);
                    encodedString.append(key[(secondPosition[0] + 1) % 5][secondPosition[1]]);
                }
                //same column, different row:
                else if (!(firstPosition[1].equals(secondPosition[1]))) {
                    encodedString.append(key[firstPosition[0]][(firstPosition[1] + 1) % 5]);
                    encodedString.append(key[secondPosition[0]][(secondPosition[1] + 1) % 5]);
                }
                //same letter
                else {
                    encodedString.append(key[firstPosition[0]][firstPosition[1]]);
                    encodedString.append("x");
                    encodedString.append(key[secondPosition[0]][secondPosition[1]]);
                }

            }
            else {
                encodedString.append(workableData[i]);
                encodedString.append("x");
            }
        }
        this.encodedString = encodedString.toString();
    }
    public void printEncodedString() {
        System.out.println("Encoding square:");
        System.out.println(Arrays.deepToString(key));
        System.out.println("Encoded string: " + encodedString);
    }
    public String getEncodedString() {
        return encodedString;
    }
}
