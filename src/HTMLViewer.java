import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
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

        }

        } catch (Lexer.NoCatchAllException e) {
            errorMessage(e.getMessage());
            s = HTMLOutput.getText();
        }
        finally {
            HTMLOutput.setText(s);
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
