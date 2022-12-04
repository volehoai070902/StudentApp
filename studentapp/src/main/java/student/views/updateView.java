package student.views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import student.controller.studentController;

public class updateView extends JPanel{
    //Implement label
    private JLabel id_Label = new JLabel("Id");
    private JLabel fname_Label = new JLabel("First_name");
    private JLabel lname_Label = new JLabel("Last_name");
    private JLabel dateofbirth_Label = new JLabel("Date of birth");
    private JLabel address_Label = new JLabel("address");
    //Implement textfield
    private JTextField id_Textfield = new JTextField();
    private JTextField fname_TextField= new JTextField();
    private JTextField lname_TextField = new JTextField();
    private JTextField dateofbirth_TextField = new JTextField();
    private JTextField address_TextField = new JTextField();
    //Implement panel
    private JPanel neededID_panel = new JPanel();
    private JPanel getValue_panel = new JPanel();

    private JLabel ID_update = new JLabel("ID");
    private JTextField ID_TextFieldUpdate = new JTextField(); 
    private JButton update_Button = new JButton("UPDATE");

    private studentController Update = new studentController();

    public updateView(){
        GridBagLayout gridbag = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();

        this.setLayout(new BorderLayout());
        //setup getValue_panel
        getValue_panel.setLayout(gridbag);
        gbc.weighty = 0.1;
        //ID
        gbc.gridx = 0;
        gbc.gridy = 0;
        getValue_panel.add(id_Label, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.insets = new Insets(0,21,0,0);
        id_Textfield.setPreferredSize(new Dimension(100,20));
        getValue_panel.add(id_Textfield, gbc);

        //FIRST NAME
        gbc.gridx = 0;
        gbc.gridy = 1;
        getValue_panel.add(fname_Label, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.insets = new Insets(0,21,0,0);
        fname_TextField.setPreferredSize(new Dimension(100,20));
        getValue_panel.add(fname_TextField, gbc);

        //LAST NAME
        gbc.gridx = 0;
        gbc.gridy = 2;
        getValue_panel.add(lname_Label, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.insets = new Insets(0,21,0,0);
        lname_TextField.setPreferredSize(new Dimension(100,20));
        getValue_panel.add(lname_TextField, gbc);

        //DATE OF BIRTH
        gbc.gridx = 0;
        gbc.gridy = 3;
        getValue_panel.add(dateofbirth_Label, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.insets = new Insets(0,21,0,0);
        dateofbirth_TextField.setPreferredSize(new Dimension(100,20));
        getValue_panel.add(dateofbirth_TextField, gbc);

        //ADDRESS
        gbc.gridx = 0;
        gbc.gridy = 4;
        getValue_panel.add(address_Label, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.insets = new Insets(0,21,0,0);
        address_TextField.setPreferredSize(new Dimension(100,20));
        getValue_panel.add(address_TextField, gbc);

        //BUTTON
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        getValue_panel.add(update_Button,gbc);
        //setup neededID_panel
        neededID_panel.setLayout(new FlowLayout());
        neededID_panel.add(ID_update);
        ID_TextFieldUpdate.setPreferredSize(new Dimension(100,20) );
        neededID_panel.add(ID_TextFieldUpdate);

        neededID_panel.setBorder(BorderFactory.createLoweredBevelBorder());
        this.add(neededID_panel, BorderLayout.NORTH);
        getValue_panel.setBorder(BorderFactory.createLoweredBevelBorder());
       
        this.add(getValue_panel,BorderLayout.CENTER);

        JTextArea result = new JTextArea();
        result.setPreferredSize(new Dimension(300, 100));
        this.add(result, BorderLayout.SOUTH);

        update_Button.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Update = new studentController();
                Update.Update(ID_TextFieldUpdate.getText(), id_Textfield.getText(), fname_TextField.getText(), lname_TextField.getText(), dateofbirth_TextField.getText(), address_TextField.getText());
            }
        });
    }
}
