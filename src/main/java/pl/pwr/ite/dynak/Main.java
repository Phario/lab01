package pl.pwr.ite.dynak;

import pl.pwr.ite.dynak.data.*;
import pl.pwr.ite.dynak.decoder.Decoder;
import pl.pwr.ite.dynak.encoder.Encoder;

import static pl.pwr.ite.dynak.data.Input.encodingKeyPrompt;
import static pl.pwr.ite.dynak.data.Input.unEncodedStringPrompt;

public class Main {
    public static void main(String[] args) {
        Input Input = new Input(unEncodedStringPrompt(),encodingKeyPrompt());
        Encoder Encoder = new Encoder(Input);
        Encoder.encode();
        Encoder.printEncodedString();
        Decoder Decoder = new Decoder (Input, Encoder.getEncodedString());
        Decoder.decode();
        Decoder.printDecodedString();
    }
    //TODO: add modules
}