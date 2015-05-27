import java.util.regex.Pattern;

/**
 * Die Klasse Comment repraesentiert ein Comment-Token. Es matched auf Strings
 * wie zb. "//dies ist ein Kommentar".
 *
 * @author Steven Yeates
 */
public class Comment extends Token {

    private String content;
    private int length;

    public Comment(String content, int length) {
        this.content = content;
        this.length = length;
    }

    public Comment() {
    }

    @Override
    protected int getLength() {
        return length;
    }

    @Override
    protected Token getToken() {
        if(matcher.find(0) && matcher.start() == 0) {
        return new Comment(matcher.group(), matcher.end());
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
        return "</i></font><br />";
    }

    @Override
    protected String getContent() {
        return content;
    }

    @Override
    protected Pattern getPattern() {
       // return Pattern.compile("//[\\w ]*" + "[" + Pattern.quote("\n") + Pattern.quote("\r\n") + "]{0,1}");
        return Pattern.compile("//.*\\n?\\r?");
    }

}
