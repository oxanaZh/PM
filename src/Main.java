
public class Main {
 
	public static void main(String[] args){
		Lexer lexer = new Lexer();
		String exampleString = "// total irre: public void foo()\npublic void foo(String s) {}";
		System.out.println(exampleString);
		lexer.registerToken(new Comment());
		lexer.registerToken(new KeyWord());
		lexer.registerToken(new NewLine());
		lexer.registerToken(new CatchAll());
	}
}