package pl.pwr.ite.dynak;

import pl.pwr.ite.dynak.data.*;

import static pl.pwr.ite.dynak.data.Input.encodingKeyPrompt;
import static pl.pwr.ite.dynak.data.Input.unEncodedStringPrompt;

public class Main {
    public static void main(String[] args) {
        Input Input = new Input(unEncodedStringPrompt(),encodingKeyPrompt());
    }
    //TODO: add modules
}