import java.util.regex.Pattern;

/**
 * Die Klasse Comment repraesentiert ein Comment-Token. Es matched auf Strings
 * wie zb. "//dies ist ein Kommentar".
 *
 * @author Steven Yeates
 */
public class Comment extends Token {

    private String content;
    private int length;

    public Comment(String content, int length) {
        this.content = content;
        this.length = length;
    }

    public Comment() {
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
        return new Comment(matcher.group(), matcher.end());
        }else{
            return null;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String htmlStart() {
        return "<i><font color=\"grey\">";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String htmlEnd() {
        return "</i></font><br />";
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
        return Pattern.compile("//[^\n]*" + "[" + Pattern.quote("\n") + Pattern.quote("\r\n") + "]{0,1}");
    }

}
