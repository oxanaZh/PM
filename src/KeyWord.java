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
    private int length;

    public KeyWord(String content, int length) {
        this.content = content;
        this.length = length;
    }

    public KeyWord() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected int getLength() {
        return length;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Token getToken() {
        if(matcher.find(0) && matcher.start() == 0) {
        return new KeyWord(matcher.group(), matcher.end());
        }else{
            return null;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String htmlStart() {
        return "<font color=\"red\"><b>";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String htmlEnd() {
        return "</b></font>";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String getContent() {
        return content;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Pattern getPattern() {
        return Pattern.compile("void|import|class|public|private|protected|finally|final|static|return|if|else|while|try|catch");
    }

}
