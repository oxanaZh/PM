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

    private int start;
    private int end;

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
        Matcher matcher = getPattern().matcher(string);

        if (matcher.find() && matcher.start() == 0) {
            start = matcher.start();
            end = matcher.end();
            setContent(matcher.group());
        }

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

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    protected abstract Token getToken();

	protected abstract String htmlStart();

	protected abstract String htmlEnd();

	protected abstract String getContent();

    protected abstract void setContent(String content);

    protected abstract Pattern getPattern();

}
