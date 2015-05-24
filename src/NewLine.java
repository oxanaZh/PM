import java.util.regex.Pattern;

/**
 * Die Klasse NewLine repraesentiert ein Absatz/NewLine-Token. Es matched auf
 * Strings wie "\r\n und \n", welche einen Absatz anzeigen.
 *
 * @author Steven Yeates
 */
public class NewLine extends Token {

    private String content;
    private int length;

    public NewLine(String content, int length) {
        this.content = content;
        this.length = length;
    }

    public NewLine() {
    }

    @Override
    protected int getLength() {
        return length;
    }

    @Override
    protected Token getToken() {
        if(matcher.find(0) && matcher.start() == 0) {
        return new NewLine(matcher.group(), matcher.end());
        }else{
            return null;
        }
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
    protected Pattern getPattern() {
        return Pattern.compile(Pattern.quote("\n"), Pattern.UNIX_LINES);
    }

}
