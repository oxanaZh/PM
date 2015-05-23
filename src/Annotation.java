import java.util.regex.Pattern;

/**
 * Die Klasse Annotation repraesentiert ein Annotation-Token. Es matched auf
 * Strings wie zb. "@Override".
 *
 * @author Steven Yeates
 */

public class Annotation extends Token {

    private String content;

	@Override
	protected Token getToken() {
        Annotation result = new Annotation();

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
