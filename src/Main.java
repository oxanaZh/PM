import org.apache.commons.lang.StringEscapeUtils;

public class Main {

	public static void main(String[] args){
		Lexer lexer = new Lexer();
		String exampleString = "a void \n //kommentar\n /**javaDoc\nCommant*/ @annotation /*Multiline\nCommant*/ \"string\" \'C\'" ;
		lexer.registerToken(new Comment());
		lexer.registerToken(new MultilineComment());
		lexer.registerToken(new JavaDocComment());
		lexer.registerToken(new StringContent());
		lexer.registerToken(new CharacterContent());
		lexer.registerToken(new KeyWord());
		lexer.registerToken(new Annotation());
		lexer.registerToken(new NewLine());
		lexer.registerCatchAll(new CatchAll());
//		System.out.println(exampleString);
		String s = "";
		String p = "";
		try {
			for (Token token : lexer.tokenize(exampleString)){
                s+= token.getHtml();
				p+= token.getContent();
            }
		} catch (Lexer.NoCatchAllException e) {
			e.printStackTrace();
		}
		//System.out.println(StringEscapeUtils.escapeJava(s));
		//System.out.println(StringEscapeUtils.escapeJava(p));
		HTMLViewer viewer = new HTMLViewer(lexer);
	}
}
