import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * @author Steven Yeates
 * @since SoSe 2105
 *
 */

@RunWith(Suite.class)
@SuiteClasses({
    AnnotationTest.class,
    CatchAllTest.class,
    CharacterContentTest.class,
    CommentTest.class,
    JavaDocCommentTest.class,
    KeyWordTest.class,
    MultilineCommentTest.class,
    NewLineTest.class,
    StringContentTest.class,
    TokenTest.class,
    LexerTest.class })
public class TestAll {

}
