import java.util.regex.Pattern;

/**
 * Die Klasse CharacterContent repraesentiert ein Character-Token. Es matched
 * auf Strings wie zb. " 'a' ".
 *
 * @author Steven Yeates
 */
public class CharacterContent extends Token {

    private String content;

    @Override
    protected Token getToken() {
        CharacterContent result = new CharacterContent();

        result.setContent(content);
        return result;
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
        return Pattern.compile("\'[a-zA-Z]\'");
    }
}
