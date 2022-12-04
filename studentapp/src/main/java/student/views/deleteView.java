package student.views;

import javax.swing.BorderFactory;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import student.controller.studentController;


public class deleteView extends JPanel{
    private JPanel panel_1 = new JPanel();
    private JPanel panel_2 = new JPanel();
    private JLabel Id_Label = new JLabel("ID");
    private JTextField Id_TextField = new JTextField();
    private JButton delete_button = new JButton("DELETE");
    private JTextArea textArea = new JTextArea();
    private JLabel label = new JLabel("Nhập ID người dùng mà bạn muốn xóa");
    private studentController studentController = new studentController();

    public deleteView(){
        this.setLayout(new BorderLayout());
        panel_1.setLayout(new FlowLayout());
        panel_2.setLayout(new FlowLayout());

        panel_1.setPreferredSize(new Dimension(400,200));
        panel_2.setPreferredSize(new Dimension(400,200));
        panel_2.setBorder(BorderFactory.createLoweredBevelBorder());
        panel_2.add(Id_Label);
        Id_TextField.setPreferredSize(new Dimension(100,22));
        panel_2.add(Id_TextField);
        panel_2.add(delete_button);
        
        panel_1.add(panel_2);
        
        label.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(label, BorderLayout.NORTH);
        this.add(panel_1, BorderLayout.CENTER);

        textArea.setPreferredSize(new Dimension(720, 360));
        this.add(textArea, BorderLayout.SOUTH);

        delete_button.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                studentController.Delete(Id_TextField.getText(), textArea);
                Id_TextField.setText("");
            }
        });
    }

}