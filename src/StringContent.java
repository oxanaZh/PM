import java.util.regex.Pattern;

/**
 * Die Klasse StringContent repraesentiert ein String-Token. Es matched auf alle
 * Java-Strings ("some Text").
 *
 * @author Steven Yeates
 */
public class StringContent extends Token {

    private String content;

    @Override
    protected Token getToken() {
        if (content != null) {
            StringContent result = new StringContent();

            result.setContent(content);
            return result;
        }

        return null;
    }

    @Override
    protected String htmlStart() {
        return "<font color=\"green\">";
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
        return Pattern.compile("\"[.]*\"");
    }
}
