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

    @Override
    protected int getLength() {
        return length;
    }

    @Override
    protected Token getToken() {
        if(matcher.find(0) && matcher.start() == 0) {
        return new JavaDocComment(matcher.group(), matcher.end());
        }else{
            return null;
        }
    }

    @Override
    protected String htmlStart() {
        return "<font color=\"blue\">";
    }

    @Override
    protected String htmlEnd() {
        return "</font>";
    }

    @Override
    protected String getContent() {
        return content;
    }

    @Override
    protected Pattern getPattern() {
        return Pattern.compile("/" + Pattern.quote("**") + ".*?" + Pattern.quote("*/"), Pattern.DOTALL);
    }

}
