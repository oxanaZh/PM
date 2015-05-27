import java.util.regex.Pattern;

/**
 * Die Klasse TabStop repraesentiert ein Absatz/TabStop-Token. Es matched auf
 * Strings wie "\r\n und \n", welche einen Absatz anzeigen.
 *
 * @author Steven Yeates
 */
public class NewLine extends Token {

    private String content;
    private int length;

    public NewLine(String content, int length) {
        this.content = content;
        this.length = length;
    }

    public NewLine() {
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
        return new NewLine(matcher.group(), matcher.end());
        }else{
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
        return "<br />";
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
        return Pattern.compile(Pattern.quote("\n"), Pattern.UNIX_LINES);
    }

}
