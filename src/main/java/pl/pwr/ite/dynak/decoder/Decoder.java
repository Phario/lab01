package pl.pwr.ite.dynak.decoder;

import pl.pwr.ite.dynak.data.Input;
import pl.pwr.ite.dynak.data.KeyBrowser;

import java.util.Arrays;

public class Decoder {
    private final Character[][] key;
    private final String encodedString;
    private String decodedString;
    public Decoder(Input DecoderData, String encodedString) {
        this.key = DecoderData.getKey();
        this.encodedString = encodedString;
    }
    public void decode(){
        StringBuilder decodedString = new StringBuilder();
        char[] workableData = encodedString.toCharArray();
        KeyBrowser KeyBrowser = new KeyBrowser();
        KeyBrowser.fillKeyMap(key);
        for (int i = 0; i < encodedString.length(); i += 2) {

            if (encodedString.length() >= i+1) {
                Integer[] firstPosition = KeyBrowser.getPosition(workableData[i]);
                Integer[] secondPosition = KeyBrowser.getPosition(workableData[i + 1]);
                //remove 'x' from the end of a string:
                if (workableData[i+1] == 'x' && encodedString.length() == i + 2) {
                    decodedString.append(workableData[i]);
                }
                //handling 'x' inside of encoded strings:
                else if (workableData[i+1] == 'x' && workableData[i+2] == workableData[i]) {
                    decodedString.append(workableData[i]);
                    decodedString.append(workableData[i]);
                    i++;
                }
                //different rows and columns:
                else if (!(firstPosition[0].equals(secondPosition[0])) && !(firstPosition[1].equals(secondPosition[1]))) {
                    decodedString.append(key[secondPosition[0]][firstPosition[1]]);
                    decodedString.append(key[firstPosition[0]][secondPosition[1]]);
                }
                //same row, different column:
                else if (!(firstPosition[0].equals(secondPosition[0]))) {
                    if (firstPosition[0] == 0) {
                        decodedString.append(key[4][firstPosition[1]]);
                        decodedString.append(key[secondPosition[0] - 1][secondPosition[1]]);
                    } else if (secondPosition[0] == 0) {
                        decodedString.append(key[firstPosition[0] - 1][firstPosition[1]]);
                        decodedString.append(key[4][secondPosition[1]]);
                    } else {
                        decodedString.append(key[firstPosition[0] - 1][firstPosition[1]]);
                        decodedString.append(key[secondPosition[0] - 1][secondPosition[1]]);
                    }
                }
                //same column, different row:
                else if (!(firstPosition[1].equals(secondPosition[1]))) {
                    if (firstPosition[1] == 0) {
                        decodedString.append(key[firstPosition[0]][4]);
                        decodedString.append(key[secondPosition[0]][secondPosition[1] - 1]);
                    } else if (secondPosition[1] == 0) {
                        decodedString.append(key[firstPosition[0]][firstPosition[1] - 1]);
                        decodedString.append(key[secondPosition[0]][4]);
                    } else {
                        decodedString.append(key[firstPosition[0]][firstPosition[1] - 1]);
                        decodedString.append(key[secondPosition[0]][secondPosition[1] - 1]);
                    }
                }
            }
        }
        this.decodedString = decodedString.toString();
    }
    public void printDecodedString() {
        System.out.println(Arrays.deepToString(key));
        System.out.println("Decoded string: " + decodedString);
    }
}
