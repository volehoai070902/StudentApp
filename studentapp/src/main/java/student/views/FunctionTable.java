package student.views;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.GridLayout;

public class FunctionTable extends JPanel {
    private JButton button_1 = new JButton("Show all");
    private JButton button_2 = new JButton("Add");
    private JButton button_3 = new JButton("Search");
    private JButton button_4 = new JButton("Update");
    private JButton button_5 = new JButton("Delete");

    public FunctionTable() {
        setLayout(new GridLayout(5, 0));
        this.add(button_1);
        this.add(button_2);
        this.add(button_3);
        this.add(button_4);
        this.add(button_5);
    }

    public JButton getButton_1() {
        return button_1;
    }

    public JButton getButton_2() {
        return button_2;
    }

    public JButton getButton_3() {
        return button_3;
    }

    public JButton getButton_4() {
        return button_4;
    }

    public JButton getButton_5() {
        return button_5;
    }
    public static void main(String[] args) {
        
    }
}
