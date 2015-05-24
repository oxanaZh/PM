import java.util.regex.Pattern;

/**
 * Die Klasse NewLine repraesentiert ein Absatz/NewLine-Token. Es matched auf
 * Strings wie "\r\n und \n", welche einen Absatz anzeigen.
 *
 * @author Steven Yeates
 */
public class NewLine extends Token {

    private String content;

    @Override
    protected Token getToken() {
        if (content != null) {
            NewLine result = new NewLine();

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
        return "<br />";
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
        return Pattern.compile(Pattern.quote("\r\n") + "|" + Pattern.quote("\n"));
    }

}
