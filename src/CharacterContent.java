import java.util.regex.Pattern;

/**
 * Die Klasse CharacterContent repraesentiert ein Character-Token. Es matched
 * auf Strings wie zb. " 'a' ".
 *
 * @author Steven Yeates
 */
public class CharacterContent extends Token {

    private String content;
    private int length;

    public CharacterContent(String content, int length) {
        this.content = content;
        this.length = length;
    }

    public CharacterContent() {
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
        return new CharacterContent(matcher.group(), matcher.end());
        }else{
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
        return Pattern.compile(Pattern.quote("'") + "." + Pattern.quote("'"));
    }
}
