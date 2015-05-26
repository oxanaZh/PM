import java.util.regex.Pattern;

/**
 * Die Klasse CatchAll repraesentiert ein CatchAll-Token. Es matched auf jedes
 * beliebige Zeichen.
 *
 * @author Steven Yeates
 */
public class CatchAll extends Token {

    private String content;

    @Override
    protected Token getToken() {
        if (content != null) {
            CatchAll result = new CatchAll();

            result.setContent(content);
            return result;
        }

        return null;
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
    protected void setContent(String content) {
        this.content = content;
    }

    @Override
    protected Pattern getPattern() {
        return null;
    }
}
