import java.util.regex.Pattern;

/**
 * Die Klasse StringContent repraesentiert ein String-Token. Es matched auf alle
 * Java-Strings ("some Text").
 *
 * @author Steven Yeates
 */
public class StringContent extends Token {

    private String content;
    private int length;

    public StringContent(String content, int length) {
        this.content = content;
        this.length = length;
    }

    public StringContent() {
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
        if(matcher.find(0) && matcher.start() == 0) {
            return new StringContent(matcher.group(), matcher.end());
        } else {
            return null;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String htmlStart() {
        return "<font color=\"green\">";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String htmlEnd() {
        return "</font>";
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
        return Pattern.compile("\".*\"");
    }
}
