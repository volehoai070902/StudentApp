package student.views;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import student.controller.studentController;





public class addView extends JPanel{
    private JLabel label = new JLabel("STUDENT ID");
    private JLabel label2= new JLabel("FIRST NAME");
    private JLabel label3= new JLabel("LAST NAME");
    private JLabel label4= new JLabel("DATE OF BIRTH");
    private JLabel label5= new JLabel("ADDRESS");
    private JTextField textField = new JTextField();
    private JTextField textField2 = new JTextField();
    private JTextField textField3 = new JTextField();
    private JTextField textField4 = new JTextField();
    private JTextField textField5 = new JTextField();
    private JButton add_buton = new JButton("ADD");
    private studentController studentController = new studentController();

    public addView()
    {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(label);
        this.add(textField);
        this.add(label2);
        this.add(textField2);
        this.add(label3);
        this.add(textField3);
        this.add(label4);
        this.add(textField4);
        this.add(label5);
        this.add(textField5);

        this.add(add_buton);
        add_buton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                studentController.Add(textField.getText(), textField2.getText(), textField3.getText(), textField4.getText(), textField5.getText(), getPanel());
            }
        });
    }

    public JPanel getPanel(){
        return this;
    }

    public JTextField getTextField() {
        return textField;
    }

    public JTextField getTextField2() {
        return textField2;
    }

    public JTextField getTextField3() {
        return textField3;
    }

    public JTextField getTextField4() {
        return textField4;
    }

    public JTextField getTextField5() {
        return textField5;
    }
}
