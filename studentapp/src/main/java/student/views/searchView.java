package student.views;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import student.controller.studentController;



public class searchView extends JPanel{
    private JPanel panel1 = new JPanel();
    private JPanel panel2 = new JPanel();
    private JLabel ID_label= new JLabel("ID");
    private JLabel NAME_label= new JLabel("LAST_NAME");
    private JTextField ID_TextField = new JTextField();
    private JTextField NAME_TextField = new JTextField();
    private JButton searchButton = new JButton("Search");
    private JTextArea textArea = new JTextArea();
    private studentController Search = new studentController();
    searchView(){
        GridBagLayout gridbag = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();

        //setup layout for panel search id and name
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        panel1.setLayout(gridbag);
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel1.add(ID_label, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.insets = new Insets(0,21,0,0);
        ID_TextField.setPreferredSize(new Dimension(100,20));
        panel1.add(ID_TextField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel1.add(NAME_label, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.insets = new Insets(0,21,0,0);
        NAME_TextField.setPreferredSize(new Dimension(100,20));
        panel1.add(NAME_TextField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 2;
        panel1.add(searchButton, gbc);

        //setup textarea
        panel2.setLayout(new BorderLayout());
        panel2.add(textArea);

        panel1.setPreferredSize(new Dimension(360,120));
        panel1.setBorder(BorderFactory.createLineBorder(Color.black));
        this.add(panel1);
        this.add(panel2);
        
        searchButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Search.Search(ID_TextField.getText(), NAME_TextField.getText(), getTextArea());
            }
        });
    }

    public JTextArea getTextArea() {
        textArea.setEditable(false);
        return textArea;
    }
}
