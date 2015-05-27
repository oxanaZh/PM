import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Ein Token repraesentiert eine logisch zusammengehoerige Einheit aus einem
 * String. Es beinhaltet ein Pattern Object, welches einen beliebigen RegEx
 * haelt und dadruch festlegt, auf welche Einheit eines Strings das Token passt.
 *
 * @see java.util.regex.Pattern
 * @author Steven Yeates
 */
public abstract class Token {

    protected Pattern pattern;
    protected Matcher matcher;

    /**
     * Die Methode match() ist in der abstrakten Basisklasse implementiert
     * (final). Sie erzeugt aus dem uebergebenen String und dem im Feld pattern
     * hinterlegten regulaeren Ausdruck ein Matcher-Objekt, welches sie im Feld
     * matcher fuer die spaetere Verwendung speichert.
     *
     * @see java.util.regex.Pattern
     * @see java.util.regex.Matcher
     *
     *      Bei erfolgreichem Match liefert sie unter Benutzung der Methode
     *      getToken() eine neue Instanz der konkreten Tokenklasse zurueck
     *      (sonst null).
     *
     * @param string
     *            - Ein beliebiger Text
     * @return Instanz der konkreten Tokenklasse, null wenn kein Match gefunden wurde.
     */
    public final Token match(String string) {
        if(pattern == null){
            pattern = getPattern();
        }

        matcher = pattern.matcher(string);
        return getToken();
    }

    /**
     * Nach einem erfolgreichen Match durch die Methode match(String string)
     * liefert getHtml den im Match gefundenen Text eingebettet in einem
     * html-Code zurück.
     *
     * @return Match-Ergebnis
     */
    public final String getHtml() {
        return htmlStart() + getContent() + htmlEnd();
    }

    /**
     * Gibt die Länge des gematchden Strings zurück
     * @return Länge des Strings
     */
    protected abstract int getLength();

    /**
     * Erstellt nach dem Template Method Pattern ein passendes Token
     * @return Das Token
     */
    protected abstract Token getToken();

    /**
     * Gibt die öffnenden Html Tags für dieses Token zurück
     * @return Ein String aus den Html Tags
     */
	protected abstract String htmlStart();

    /**
     * Gibt die schließenden Html Tags für dieses Token zurück
     * @return Ein String aus den Html Tags
     */
	protected abstract String htmlEnd();

    /**
     * Gibt den Text dieses Tokens zurück
     * @return Den Text als String
     */
	protected abstract String getContent();

    /**
     * Gibt das Pattern dieses Tokens zurück
     * @return Das Pattern Objekt dieses Tokens
     */
    protected abstract Pattern getPattern();

}
