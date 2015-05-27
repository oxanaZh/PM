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
    JTextPane HTMLContent = new JTextPane();
    JTextPane inputField = new JTextPane();
    //HTMLEditorKit editorKit = new HTMLEditorKit();
   // HTMLDocument document = new HTMLDocument();


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
        HTMLContent.setEditable(false);
       // HTMLContent.setEditorKit(editorKit);
       // HTMLContent.setDocument(document);
        setSize(1024, 768);
        setLayout(new GridLayout(2,1,0,30));
        //content.setSize(640, 480);
        panelHTML.setBorder(BorderFactory.createLineBorder(Color.black));
        panelHTML.setLayout(new BorderLayout());

        panelUserControl.setBorder(BorderFactory.createLineBorder(Color.black));
        panelUserControl.setLayout(new BorderLayout());
       //panelUserControl.setPreferredSize(new Dimension(0,220));


        panelHTML.setPreferredSize(new Dimension(0,220));
        //panelUserControl.setMaximumSize(new Dimension(320, 240));

        add(panelHTML);
        add(panelUserControl);


        panelHTML.add(new JScrollPane(HTMLContent));

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
