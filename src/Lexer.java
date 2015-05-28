import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Die Klasse Lexer ist ein lexikalischer Scanner (Tokenizer), der Plain Text in
 * einzelne logisch zusammengehoerigen Einheiten, so genannte Token zerlegt und
 * diese Token dem Anwender verfugbar macht.
 *
 * @author Steven Yeates
 */
public class Lexer {

    private List<Token> tokens = new ArrayList<>();

    /**
     * Mit dieser Methode werden die Tokenklassen in der gewuenschten
     * Reihenfolge im Lexer registriert (und in dieser Reihenfolge intern in
     * einer Liste gespeichert). In dieser Reihenfolge entsprechend werden sie
     * durch die Methode testTokens() abgearbeitet.
     *
     * @param token das Token, dass registriert werden soll
     */
    public void registerToken(Token token) {
        tokens.add(token);
    }

    /**
     * Das Catch-All-Token dient dazu, Text zwischen zwei anderen Token aus dem
     * String zu entfernen. Da man nicht weiss, wieviel Text zwischen zwei Token
     * kommen wird und da das Catch-All-Token keine Kenntnis ueber die anderen
     * Token-Klassen haben soll, passt das Catch-All-Token auf genau ein
     * beliebiges Zeichen. Es wird in der Methode testTokens() als letzte
     * Tokenklasse geprueft, wenn keine der anderen Tokenklassen gepasst hat und
     * entfernt genau ein Zeichen vom Anfang des Strings.
     *
     * @param token ein Token, welches auf genau ein beliebiges Zeichen passt.
     */
    public void registerCatchAll(Token token) {
        tokens.add(token);
    }

    /**
     * Die Methode tokenize() zerlegt den uebergebenen String unter Benutzung
     * der testTokens(String string) Methode. Der String wird komplett in
     * einzelne Token zerlegt, welche anschliessend zurueck gegeben werden.
     *
     * @param string String, der lexikalisch untersucht werden soll.
     * @return alle erkannten Token in einer List
     */
    public List<Token> tokenize(String string) throws NoCatchAllException {
        List<Token> result = new LinkedList<>();
        if(!hasCatchAll()){
            throw new NoCatchAllException();
        }
        while (string.length() > 0) {
            Token current = testTokens(string);

            if (current != null) {
                string = string.substring(current.getLength(), string.length());
                result.add(current);
            }
        }

        return result;
    }

    private Token testTokens(String string) {
        for (Token token : tokens) {
            Token resultToken = token.match(string);

            if (resultToken != null) {
                return resultToken;
            }
        }

        return null;
    }

    protected boolean hasCatchAll(){
        if (tokens.get(tokens.size()-1) instanceof CatchAll){
            return true;
        } else {
            for (Iterator<Token> itr = tokens.iterator(); itr.hasNext(); ) {
                Token next =  itr.next();
                if (next instanceof CatchAll){
                    itr.remove();
                    tokens.add(next);
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Eine Exception die geworfen wird, falls versucht wird tokenize aufzurufen ohne vorher ein CatchAll registriert zu haben.
     * @see CatchAll
     */
    public class NoCatchAllException extends Exception{

        public NoCatchAllException(){
            super("Lexer must contains a CatchAll-Token");
        }
    }
}
