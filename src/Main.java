
public class Main {
 
	public static void main(String[] args){
		Lexer lexer = new Lexer();
		String exampleString = "// total irre: public void foo()\npublic void foo(String s) {}";
		lexer.registerToken(new KeyWord());
		lexer.registerToken(new Annotation());
		lexer.registerToken(new CharacterContent());
		lexer.registerToken(new Comment());
		lexer.registerToken(new JavaDocComment());
		lexer.registerToken(new KeyWord());
		lexer.registerToken(new MultilineComment());
		lexer.registerToken(new NewLine());
		lexer.registerToken(new StringContent());
		System.out.println(exampleString);
		HTMLViewer viewer = new HTMLViewer(lexer);
	}
}
