package gui;

import program.Goods;
import program.GoodsServiceMySQL;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class FindByBrandGUI implements ActionListener {
    JFrame frame = new JFrame("electronic store - find by brand");

    JLayeredPane mainPane = new JLayeredPane();

    JButton buttonSubmit = new JButton("Search");

    JTextField input = new JTextField();

    JLabel catMessage = new JLabel("Enter brand name what do you want to find");
    JLabel icon = new JLabel();

    ImageIcon contains = new ImageIcon("img/reactions/contain.gif");
    ImageIcon notContains = new ImageIcon("img/reactions/notContain.gif");
    ImageIcon defaultImg = new ImageIcon("img/reactions/default.gif");
    ImageIcon btnSubmit = new ImageIcon("img/reactions/search.png");
    ImageIcon frameIcon = new ImageIcon("img/mainframe/search.png");
    FindByBrandGUI() {
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

        icon.setBounds(200, 70, 230, 230);
        icon.setIcon(defaultImg);

        catMessage.setFont(new Font("Century Gothic", Font.PLAIN, 16));
        catMessage.setBounds(130, 250, 650, 70);
        catMessage.setForeground(Color.decode("#a58bb5"));
        catMessage.setBackground(Color.decode("#251f31"));
        catMessage.setOpaque(true);

        mainPane.setBounds(0, 0, 700, 700);
        mainPane.add(buttonSubmit);
        mainPane.add(input);
        mainPane.add(icon);
        mainPane.add(catMessage);

        frame.getContentPane().setBackground(Color.decode("#251f31"));
        frame.setSize(700, 700);
        frame.setResizable(false);
        frame.setIconImage(frameIcon.getImage());
        frame.setVisible(true);
        frame.add(mainPane);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == buttonSubmit) {
            List<Goods> list = new GoodsServiceMySQL().findByBrand(input.getText());
            StringBuilder stringBuilder = new StringBuilder();

            for (Goods s : list) {
                stringBuilder.append(s).append("\n");
            }
            JTextArea searchResult = new JTextArea(stringBuilder.toString());

            searchResult.setFont(new Font("Century Gothic", Font.PLAIN, 16));
            searchResult.setBounds(20, 320, 650, 550);
            searchResult.setForeground(Color.decode("#a58bb5"));
            searchResult.setBackground(Color.decode("#251f31"));
            searchResult.setOpaque(true);
            mainPane.add(searchResult);

            if (list.isEmpty()) {
                icon.setIcon(notContains);
                icon.setBounds(200, 70, 230, 230);
                catMessage.setText("Boba didn't find anything :(");
                catMessage.setBounds(200, 250, 650, 70);
            } else {
                icon.setIcon(contains);
                icon.setBounds(220, 70, 230, 230);
                catMessage.setText("Found according to your request: ");
                catMessage.setBounds(170, 250, 650, 60);
            }
        }
    }
}
