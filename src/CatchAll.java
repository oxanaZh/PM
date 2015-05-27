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

    /**
     * {@inheritDoc}
     */
    @Override
    protected int getLength() {
        return length;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Token getToken() {
        if (matcher.find(0) && matcher.start() == 0) {
            return new CatchAll(matcher.group(), matcher.end());
        } else {
            return null;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String htmlStart() {
        return "";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String htmlEnd() {
        return "";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String getContent() {
        return content;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Pattern getPattern() {
        return Pattern.compile(".", Pattern.DOTALL);
    }
}
