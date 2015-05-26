import java.util.regex.Pattern;

/**
 * Die Klasse Comment repraesentiert ein Comment-Token. Es matched auf Strings
 * wie zb. "//dies ist ein Kommentar".
 *
 * @author Steven Yeates
 */
public class Comment extends Token {

    private String content;

    @Override
    protected Token getToken() {
        if (content != null) {
            Comment result = new Comment();

            result.setContent(content);
            return result;
        }

        return null;
    }

    @Override
    protected String htmlStart() {
        return "<i><font color=\"grey\">";
    }

    @Override
    protected String htmlEnd() {
        return "</i></font><br />";
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
