import java.util.regex.Pattern;

/**
 * Die Klasse KeyWord repraesentiert ein KeyWord-Token. Es matched auf die
 * JavaKeywords
 * "void,import,class,public,private,final,static,return,if,else,while,try,
 * catch,finally"
 *
 * @author Steven Yeates
 */
public class KeyWord extends Token {

    private String content;

    @Override
    protected Token getToken() {
        KeyWord result = new KeyWord();

        result.setContent(content);
        return result;
    }

    @Override
    protected String htmlStart() {
        return "<font color=\"red\"><b>";
    }

    @Override
    protected String htmlEnd() {
        return "</b></font>";
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
