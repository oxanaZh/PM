import java.util.regex.Pattern;

/**
 * Die Klasse MultilineComment repraesentiert ein MultilineComment-Token. Es
 * matched auf mehrzeilige Java Kommentare (eingeleitet durch "/*").
 *
 * @author Steven Yeates
 */
public class MultilineComment extends Token {

    private String content;
    private int length;

    public MultilineComment(String content, int length) {
        this.content = content;
        this.length = length;
    }

    public MultilineComment() {
    }

    @Override
    protected int getLength() {
        return length;
    }

    @Override
    protected Token getToken() {
        if(matcher.find(0) && matcher.start() == 0) {
        return new MultilineComment(matcher.group(), matcher.end());
        }else{
            return null;
        }
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
    protected Pattern getPattern() {
        return Pattern.compile("/" + Pattern.quote("*") + ".*" + Pattern.quote("*") + "/", Pattern.DOTALL);
    }
}
