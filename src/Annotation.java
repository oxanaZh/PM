import java.util.regex.Pattern;

/**
 * Die Klasse Annotation repraesentiert ein Annotation-Token. Es matched auf
 * Strings wie zb. "@Override".
 *
 * @author Steven Yeates
 */

public class Annotation extends Token {

    private String content;
    private int length;

    public Annotation(String content, int length) {
        this.content = content;
        this.length = length;
    }

    public Annotation() {
    }

    @Override
    protected int getLength() {
        return length;
    }

    @Override
	protected Token getToken() {
        if(matcher.find(0) && matcher.start() == 0) {
            return new Annotation(matcher.group(), matcher.end());
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
        return Pattern.compile("@([A-z])+");
    }

}
