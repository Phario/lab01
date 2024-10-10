package pl.pwr.ite.dynak.data;
import java.util.HashMap;
public class KeyBrowser {
    HashMap<Character, Integer[]> letterPositions = new HashMap<>();
    public KeyBrowser(){}
    public void fillKeyMap(Character[][] key) {
        for (int i = 0; i<5; i++) {
            for (int j = 0; j<5; j++) {
                Integer[] coordinates = new Integer[]{i,j};
                letterPositions.put(key[i][j], coordinates);
            }
        }
    }
    public Integer[] getPosition(Character letter) {
        return letterPositions.get(letter);
    }
}
