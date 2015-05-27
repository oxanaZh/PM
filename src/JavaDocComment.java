import java.util.regex.Pattern;

/**
 * Die Klasse JavaDocComment repraesentiert ein JavaDocComment-Token. Es matched
 * auf Strings wie zb. "/** JavaDoc Kommentar * /".
 *
 * @author Steven Yeates
 */
public class JavaDocComment extends Token {

    private String content;
    private int length;

    public JavaDocComment(String content, int length) {
        this.content = content;
        this.length = length;
    }

    public JavaDocComment() {
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
        return new JavaDocComment(matcher.group(), matcher.end());
        }else{
            return null;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String htmlStart() {
        return "<font color=\"blue\">";
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
        return Pattern.compile("/" + Pattern.quote("**") + ".*?" + Pattern.quote("*/"), Pattern.UNIX_LINES | Pattern.DOTALL);
    }

}
