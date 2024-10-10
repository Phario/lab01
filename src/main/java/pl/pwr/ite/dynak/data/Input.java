package pl.pwr.ite.dynak.data;
import java.util.Scanner;
public class Input {
    static Character[][] key;
    private static String data;
    public Input(String data, Character[][] key) {
        Input.key = key;
        Input.data = data;
    }
    public static Character[][] encodingKeyPrompt() {
        System.out.println("Enter the encoding key:");
        Scanner KeyScanner = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            System.out.println("Enter line no. " + (i + 1) +" ( 5 letters):");
            String keyLine = KeyScanner.next();
            for (int j = 0; j<5; j++) {
                key[i][j] = keyLine.charAt(j);
            }
            //key[i] = KeyScanner.next().toCharArray();
        }
        return key;
    }
    public static String unEncodedStringPrompt() {
        Scanner StringScanner = new Scanner(System.in);
        System.out.println("Enter string to encode (a-z without x):");
        data = StringScanner.nextLine();
        return data;
    }
    public Character[][] getKey() {return key;}
    public String getData() {return data;}
}