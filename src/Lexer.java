import java.util.ArrayList;
import java.util.List;

/**
 * Die Klasse Lexer ist ein lexikalischer Scanner (Tokenizer), der Plain Text in
 * einzelne logisch zusammengehoerigen Einheiten, so genannte Token zerlegt und
 * diese Token dem Anwender verfugbar macht.
 *
 * @author Steven Yeates
 */
public class Lexer {

	private List<Token> token;
	private Token catchAll;
    // fill me :)

    /**
     * Mit dieser Methode werden die Tokenklassen in der gewuenschten
     * Reihenfolge im Lexer registriert (und in dieser Reihenfolge intern in
     * einer Liste gespeichert). In dieser Reihenfolge entsprechend werden sie
     * durch die Methode testTokens() abgearbeitet.
     *
     * @param das
     *            Token, dass registriert werden soll
     */
    public void registerToken(Token token) {
        // fill me :)
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
     * @param ein
     *            Token, welches auf genau ein beliebiges Zeichen passt.
     */
    public void registerCatchAll(Token token) {
        // fill me :)
    }

    /**
     * Die Methode tokenize() zerlegt den uebergebenen String unter Benutzung
     * der testTokens(String string) Methode. Der String wird komplett in
     * einzelne Token zerlegt, welche anschliessend zurueck gegeben werden.
     *
     * @param String
     *            , der lexikalisch untersucht werden soll.
     * @return alle erkannten Token in einer List
     */
    public List<Token> tokenize(String string) {
  return null;
        // fill me :)
    }
    
    private Token testTokens(String string){
    	return null;
    }

    // fill me :)

}
