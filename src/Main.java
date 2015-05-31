

public class Main {

	public static void main(String[] args){
		Lexer lexer = new Lexer();
        lexer.registerToken(new KeyWord());
        lexer.registerToken(new JavaDocComment());
        lexer.registerToken(new MultilineComment());
        lexer.registerToken(new Comment());
        lexer.registerToken(new Annotation());
        lexer.registerToken(new StringContent());
        lexer.registerToken(new CharacterContent());
        lexer.registerToken(new NewLine());
        lexer.registerCatchAll(new CatchAll());

        new HTMLViewer(lexer);
    }
}
