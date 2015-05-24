import java.util.regex.Pattern;

/**
 * Die Klasse CatchAll repraesentiert ein CatchAll-Token. Es matched auf jedes
 * beliebige Zeichen.
 *
 * @author Steven Yeates
 */
public class CatchAll extends Token {

    private String content;
    private int length;

    public CatchAll(String content, int length) {
        this.content = content;
        this.length = length;
    }

    public CatchAll() {
    }

    @Override
    protected int getLength() {
        return length;
    }

    @Override
    protected Token getToken() {
        if (matcher.find(0) && matcher.start() == 0) {
            return new CatchAll(matcher.group(), matcher.end());
        } else {
            return null;
        }
    }

    @Override
    protected String htmlStart() {
        return "";
    }

    @Override
    protected String htmlEnd() {
        return "";
    }

    @Override
    protected String getContent() {
        return content;
    }

    @Override
    protected Pattern getPattern() {
        return Pattern.compile(".", Pattern.DOTALL);
    }
}
