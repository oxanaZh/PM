//import org.apache.commons.lang.StringEscapeUtils;

public class Main {

	public static void main(String[] args){
		Lexer lexer = new Lexer();
		String exampleString = "a void \n //kommentar\n /**javaDoc\nCommant*/ @annotation /*Multiline\nCommant*/ \"string\" \'C\'" ;
		lexer.registerToken(new KeyWord());
		lexer.registerToken(new JavaDocComment());
		lexer.registerToken(new MultilineComment());
		lexer.registerToken(new Comment());
		lexer.registerToken(new Annotation());
		lexer.registerToken(new StringContent());
		lexer.registerToken(new CharacterContent());
		lexer.registerToken(new NewLine());
		lexer.registerCatchAll(new CatchAll());

		HTMLViewer viewer = new HTMLViewer(lexer);
	}
}
