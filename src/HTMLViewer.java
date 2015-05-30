import javax.swing.*;
import java.awt.*;


/**
 * Created by Patrick on 25.05.2015.
 */
public class HTMLViewer extends JFrame {

    JPanel panelUserControl = new JPanel();
    JPanel panelHTML = new JPanel();
    JTextPane HTMLOutput = new JTextPane();
    JTextPane inputField = new JTextPane();


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

        HTMLOutput.setContentType("text/html");
        HTMLOutput.setEditable(false);

        setSize(1024, 768);
        setLayout(new GridLayout(2,1,0,30));

        panelHTML.setBorder(BorderFactory.createLineBorder(Color.black));
        panelHTML.setLayout(new BorderLayout());

        panelUserControl.setBorder(BorderFactory.createLineBorder(Color.black));
        panelUserControl.setLayout(new BorderLayout());


        panelHTML.setPreferredSize(new Dimension(0,220));

        add(panelHTML);
        add(panelUserControl);


        panelHTML.add(new JScrollPane(HTMLOutput));

        panelUserControl.add(new JScrollPane(inputField), BorderLayout.CENTER);
        panelUserControl.add(refreshButton, BorderLayout.SOUTH);


        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setVisible(true);

    }

    private void useLexer() {
        String s = "";

        try {


        for (Token token : lexer.tokenize(inputField.getText())) {

            s += token.getHtml();
            System.out.println("token.getContent() = " + token.getContent());
        }
        } catch (Lexer.NoTokenException e){
            errorNoToken(e.getMessage());
        }
         catch (Lexer.NoCatchAllException e) {
             errorNoCatchAll(e.getMessage());
         }
        finally {
            HTMLOutput.setText(s);
        }
    }


    private void errorNoCatchAll(String message){
        Object[] options = { "Add NoCatchAllToken", "Exit" };
        int result;
        result = JOptionPane.showOptionDialog(null, message, "Warning", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
        if (result == JOptionPane.YES_OPTION){
            lexer.registerCatchAll(new CatchAll());
        } else {
            dispose();
        }
    }
    private void errorNoToken(String message){
    Object[] options = { "Add recommended token", "Exit" };
    int result;
        message+= "\nDo you want to add recommended token to tokenize java source code?";
    result = JOptionPane.showOptionDialog(null, message, "Warning", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
    if (result == JOptionPane.YES_OPTION){
            lexer.registerToken(new KeyWord());
            lexer.registerToken(new JavaDocComment());
            lexer.registerToken(new MultilineComment());
            lexer.registerToken(new Comment());
            lexer.registerToken(new Annotation());
            lexer.registerToken(new StringContent());
            lexer.registerToken(new CharacterContent());
            lexer.registerToken(new NewLine());
            lexer.registerCatchAll(new CatchAll());

    } else {
        dispose();
    }
}


}
