import javafx.scene.web.HTMLEditor;

import javax.swing.*;
import javax.swing.text.EditorKit;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;

import java.awt.*;


/**
 * Created by Patrick on 25.05.2015.
 */
public class HTMLViewer extends JFrame {

    JPanel content = new JPanel();

    JTextPane HTMLContent = new JTextPane();
    HTMLEditorKit editorKit = new HTMLEditorKit();
    HTMLDocument document = new HTMLDocument();


    Lexer lexer;

    public HTMLViewer(Lexer lexer) {
        this.lexer = lexer;
        initialize();
    }

    private void initialize() {
        JButton refreshButton = new JButton("Use Lexer");
        refreshButton.addActionListener(ae -> {
            useLexer();
            revalidate();
        });

        HTMLContent.setContentType("text/html");
        HTMLContent.setEditorKit(editorKit);
        HTMLContent.setDocument(document);
        setSize(640, 480);

        content.setSize(640, 480);
        content.setLayout(new BorderLayout());

        add(content, BorderLayout.CENTER);

        content.add(HTMLContent, BorderLayout.CENTER);
        content.add(refreshButton, BorderLayout.SOUTH);


        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setVisible(true);

    }

    private void useLexer() {
        String s = "";

        try {


        for (Token token : lexer.tokenize(HTMLContent.getText())) {
            if (token.getHtml() != null){
            s += token.getHtml();}
        }

        } catch (Lexer.NoCatchAllException e) {
            errorMessage(e.getMessage());
            s = HTMLContent.getText();
        }
        finally {
            HTMLContent.setText(s);
            System.out.println(s);
        }
    }


    private void errorMessage(String message){
        Object[] options = { "Add NoCatchAllToken", "CANCEL" };
        int result;
        result = JOptionPane.showOptionDialog(null, message, "Warning", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
        if (result == JOptionPane.YES_OPTION){
            lexer.registerCatchAll(new CatchAll());
        }
    }

}
