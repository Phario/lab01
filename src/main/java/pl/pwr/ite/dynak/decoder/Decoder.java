package pl.pwr.ite.dynak.decoder;

import pl.pwr.ite.dynak.data.Input;
import pl.pwr.ite.dynak.data.KeyBrowser;

import java.util.Arrays;

public class Decoder {
    private Character[][] key;
    private String encodedString;
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
            if (encodedString.length() > i+1) {
                Integer[] firstPosition = KeyBrowser.getPosition(workableData[i]);
                Integer[] secondPosition = KeyBrowser.getPosition(workableData[i + 1]);
                //remove 'x' from the end of a string:
                //handling 'x' in encoded strings:
                if (workableData[i+1] == 'x' && encodedString.length() == i) {
                    decodedString.append(workableData[i]);
                }
                else if (workableData[i+1] == 'x') {
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
                else if (!(firstPosition[0].equals(secondPosition[0])) && (firstPosition[1].equals(secondPosition[1]))) {
                    if (firstPosition[0] == 4) {
                        decodedString.append(key[0][firstPosition[1]]);
                        decodedString.append(key[secondPosition[0] + 1][secondPosition[1]]);
                    } else if (secondPosition[0] == 4) {
                        decodedString.append(key[firstPosition[0] + 1][firstPosition[1]]);
                        decodedString.append(key[0][secondPosition[1]]);
                    } else {
                        decodedString.append(key[firstPosition[0] + 1][firstPosition[1]]);
                        decodedString.append(key[secondPosition[0] + 1][secondPosition[1]]);
                    }
                }
                //same column, different row:
                else if ((firstPosition[0].equals(secondPosition[0])) && !(firstPosition[1].equals(secondPosition[1]))) {
                    if (firstPosition[1] == 4) {
                        decodedString.append(key[firstPosition[0]][0]);
                        decodedString.append(key[secondPosition[0]][secondPosition[1] + 1]);
                    } else if (secondPosition[1] == 4) {
                        decodedString.append(key[firstPosition[0]][firstPosition[1] + 1]);
                        decodedString.append(key[secondPosition[0]][0]);
                    } else {
                        decodedString.append(key[firstPosition[0]][firstPosition[1] + 1]);
                        decodedString.append(key[secondPosition[0]][secondPosition[1] + 1]);
                    }
                }
                //same letter
                else {
                    decodedString.append(key[firstPosition[0]][firstPosition[1]]);
                    decodedString.append("x");
                    decodedString.append(key[secondPosition[0]][secondPosition[1]]);
                    i++;
                }

            }
            else {
                decodedString.append(workableData[i]);
                decodedString.append("x");
            }
        }
        this.decodedString = decodedString.toString();
    }
    public void printDecodedString() {
        System.out.println(Arrays.deepToString(key));
        System.out.println("Decoded string: " + decodedString);
    }
    public String getDecodedString() {
        return decodedString;
    }
}
