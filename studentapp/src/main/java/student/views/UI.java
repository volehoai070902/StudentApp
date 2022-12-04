package student.views;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.*;

public class UI extends JFrame{
    private String add_button = "ADD";
    private FunctionTable functionTable = new FunctionTable();
    private Footer footer = new Footer();
    private JPanel cards = new JPanel();
    private showAll show_All;
    private JPanel mainPanel = new JPanel();
    private JTextField showallText = new JTextField();
    private addView Add_cards = new addView();
    private CardLayout cl = new CardLayout();
    private searchView searchView = new searchView();
    private updateView updateView = new updateView();
    private deleteView deleteView = new deleteView();
    public void setup(){
        this.setSize(960,720);
        JMenuBar mBar = new JMenuBar();
        JMenu Menu = new JMenu("file");

        JMenuItem item_1 = new JMenuItem("save");
        JMenuItem item_2 = new JMenuItem("open");
        

        JMenu Menu2 = new JMenu("Color");
        Menu.add(item_1);
        Menu.add(item_2);
        Menu.add(Menu2);
        mBar.add(Menu);

        this.add(mBar, BorderLayout.NORTH);
        this.add(functionTable, BorderLayout.WEST);
        this.add(footer, BorderLayout.SOUTH);

        cards.setLayout(cl);
        cards.add(mainPanel,"main");
        
        cards.add(Add_cards, add_button);
        cards.add(searchView, "Search");
        cards.add(updateView, "Update");
        cards.add(deleteView, "Delete");
        
        this.add(cards, BorderLayout.CENTER);
        cl.show(cards, "main");

        functionTable.getButton_2().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                
                Add_cards.getTextField().setText("");
                Add_cards.getTextField2().setText("");
                Add_cards.getTextField3().setText("");
                Add_cards.getTextField4().setText("");
                Add_cards.getTextField5().setText("");
                cl.show(cards, add_button);
            }
        });

        functionTable.getButton_1().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                show_All = new showAll();
                cards.add(show_All, "show");
                cl.show(cards, "show");
            }
        });

        functionTable.getButton_3().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                cl.show(cards,"Search");
            }
        });

        functionTable.getButton_4().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                cl.show(cards,"Update");
            }
        });

        functionTable.getButton_5().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                cl.show(cards,"Delete");
            }
        });
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
    }   

    public UI(){
        setup();
    }

}
