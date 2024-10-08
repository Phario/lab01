package pl.pwr.ite.dynak.data;
import java.util.Scanner;
public class Input {
    private char[][] key;
    private String data;
    public Input(String data, char[][] key) {
        this.key = key;
        this.data = data;
    }
    public void encodingKeyPrompt() {
        System.out.println("Enter the encoding key:");
        Scanner keyScanner = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            System.out.println("Enter line no. " + (i + 1) +":");
            key[i] = keyScanner.next().toCharArray();
        }
    }
    public void unEncodedStringPrompt() {
        Scanner stringScanner = new Scanner(System.in);
        System.out.println("Enter string to encode (a-z):");
        data = stringScanner.nextLine();
    }
    public char[][] getKey() {return key;}
    public String getData() {return data;}
}