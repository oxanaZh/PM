import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by Ruben on 31.05.2015.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
        OurAnnotationTest.class,
        OurCatchAllTest.class,
        OurCharacterContentTest.class,
        OurCommentTest.class,
        OurJavaDocCommentTest.class,
        OurKeyWordTest.class,
        OurMultilineCommentTest.class,
        OurNewLineTest.class,
        OurStringContentTest.class,
        OurLexerTest.class})
public class TestAllOur {

}