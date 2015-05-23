import java.util.regex.Pattern;

/**
 * Die Klasse JavaDocComment repraesentiert ein JavaDocComment-Token. Es matched
 * auf Strings wie zb. "/** JavaDoc Kommentar * /".
 *
 * @author Steven Yeates
 */
public class JavaDocComment extends Token {

    private String content;

    @Override
    protected Token getToken() {
        JavaDocComment result = new JavaDocComment();

        result.setContent(content);
        return result;
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
    protected void setContent(String content) {
        this.content = content;
    }

    @Override
    protected Pattern getPattern() {
        return null;
    }

}
