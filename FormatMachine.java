/**
 * Created by kaarel on 28.02.15.
 */
public class FormatMachine {
    final int WORD = 1;
    final int WHITESCAPE = 2;
    final int PUNCT = 3;

    int state = WORD;
    String punct = ".,:;!?";

    public String process(char c) {
        if (c == ' ' && state == WORD) {
            state = WHITESCAPE;
        }
        else if (punct.contains(Character.toString(c)) && state == WORD) {
            state = PUNCT;
            return Character.toString(c);
        }
        else if (state == WORD)
            return "" + c;
        else if (c == ' ' && state == WHITESCAPE) {
            return "";
        }
        else if (punct.contains(Character.toString(c)) && state == WHITESCAPE) {
            state = PUNCT;
            return Character.toString(c) + " ";
        }
        else if (state == WHITESCAPE) {
            state = WORD;
            return " " + c;
        }
        else if (c == ' ' && state == PUNCT) {
            state = WHITESCAPE;
        }
        else if (state == PUNCT) {
            return "" + c;
        }
        return "";
    }
}
