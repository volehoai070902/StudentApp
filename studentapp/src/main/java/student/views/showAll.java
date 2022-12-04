package student.views;

import javax.swing.JPanel;
import javax.swing.JTextArea;

import java.awt.BorderLayout;
import student.controller.studentController;

public class showAll extends JPanel{
    private studentController show = new studentController();
    private JTextArea textArea = new JTextArea();
    public showAll(){
        show.Show_all(textArea);
        textArea.setEditable(false);
        this.setLayout(new BorderLayout());
        this.add(textArea);
    }
}
