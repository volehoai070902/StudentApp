package student.views;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Color;

public class Footer extends JPanel{
    private JLabel label = new JLabel("Cảm ơn các bạn đã sử dụng");
    public Footer(){
        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        setLayout(layout);
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        this.setBackground(Color.GRAY);
        label.setForeground(Color.WHITE);
        
        this.add(label, gbc);
    }
}
