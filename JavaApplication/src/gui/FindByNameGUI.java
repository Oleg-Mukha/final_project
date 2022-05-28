package gui;

import program.GoodsServiceMySQL;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FindByNameGUI implements ActionListener {
    JFrame frame = new JFrame("electronic store - find by name");

    JLayeredPane mainPane = new JLayeredPane();

    JButton buttonSubmit = new JButton("Search");

    JTextField input = new JTextField();

    JLabel searchResult = new JLabel();
    JLabel catMessage = new JLabel("Enter product name what do you want to find");
    JLabel icon = new JLabel();

    ImageIcon contains = new ImageIcon("img/reactions/contain.gif");
    ImageIcon notContains = new ImageIcon("img/reactions/notContain.gif");
    ImageIcon defaultImg = new ImageIcon("img/reactions/default.gif");
    ImageIcon btnSubmit = new ImageIcon("img/reactions/search.png");
    ImageIcon frameIcon = new ImageIcon("img/mainframe/search.png");
    FindByNameGUI() {
        buttonSubmit.setIcon(btnSubmit);
        buttonSubmit.setBounds(435, 25, 150, 50);
        buttonSubmit.setFont(new Font("Century Gothic", Font.BOLD, 18));
        buttonSubmit.setBackground(Color.decode("#5f3b73"));
        buttonSubmit.setForeground(Color.decode("#a58bb5"));
        buttonSubmit.setFocusable(false);
        buttonSubmit.setFocusPainted(false);
        buttonSubmit.addActionListener(this);
        buttonSubmit.setOpaque(true);

        input.setBounds(50, 25, 360, 50);
        input.setBackground(Color.decode("#a58bb5"));
        input.setForeground(Color.decode("#5f3b73"));
        input.setFont(new Font("Century Gothic", Font.BOLD, 18));
        input.setOpaque(true);

        searchResult.setFont(new Font("Century Gothic", Font.PLAIN, 16));
        searchResult.setBounds(25, 250, 650, 100);
        searchResult.setForeground(Color.decode("#a58bb5"));
        searchResult.setBackground(Color.decode("#251f31"));
        searchResult.setOpaque(true);

        catMessage.setFont(new Font("Century Gothic", Font.PLAIN, 16));
        catMessage.setBounds(130, 250, 650, 100);
        catMessage.setForeground(Color.decode("#a58bb5"));
        catMessage.setBackground(Color.decode("#251f31"));
        catMessage.setOpaque(true);

        icon.setBounds(200, 70, 230, 230);
        icon.setIcon(defaultImg);

        mainPane.setBounds(0, 0, 650, 500);
        mainPane.add(input);
        mainPane.add(buttonSubmit);
        mainPane.add(icon);
        mainPane.add(catMessage);
        mainPane.add(searchResult);

        frame.getContentPane().setBackground(Color.decode("#251f31"));
        frame.setSize(650, 370);
        frame.setResizable(false);
        frame.setIconImage(frameIcon.getImage());
        frame.setVisible(true);
        frame.add(mainPane);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == buttonSubmit) {
            searchResult.setText(new GoodsServiceMySQL().findByProduct(input.getText()));
            if ((searchResult.getText()).contains("There are no products with name '" + input.getText() + "'!")) {
                icon.setIcon(notContains);
                icon.setBounds(200, 70, 230, 230);
                searchResult.setBounds(125, 250, 650, 100);
            } else {
                icon.setIcon(contains);
                icon.setBounds(220, 70, 230, 230);
                searchResult.setBounds(25, 250, 650, 100);
            }
            catMessage.setVisible(false);
        }
    }
}
