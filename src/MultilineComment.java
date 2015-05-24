import java.util.regex.Pattern;

/**
 * Die Klasse MultilineComment repraesentiert ein MultilineComment-Token. Es
 * matched auf mehrzeilige Java Kommentare (eingeleitet durch "/*").
 *
 * @author Steven Yeates
 */
public class MultilineComment extends Token {

    private String content;

    @Override
    protected Token getToken() {
        if (content != null) {
            MultilineComment result = new MultilineComment();

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
        return "</font></i>";
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
        return Pattern.compile("/" + Pattern.quote("*") + "[.]*" + Pattern.quote("*") + "/", Pattern.MULTILINE);
    }
}
