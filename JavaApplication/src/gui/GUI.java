package gui;

import program.Goods;
import program.GoodsServiceMySQL;
import program.Order;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class GUI implements ActionListener, MouseListener, KeyListener {
    public ArrayList<Goods> cart = new ArrayList<>();
    JFrame mainFrame = new JFrame("electronics store - main menu");
    JLayeredPane mainPane = new JLayeredPane();
    JLabel kittenInBox = new JLabel();
    JLabel kittenMessage = new JLabel("<html><style>.name{text-align: center;}</style><div class='name'>Hello, we are <b>Biba</b> and <b>Boba</b><br>and we will help you navigate in our store</div>");
    JPanel bgPanel = new JPanel();
    JButton showGoods = new JButton("show products");
    JButton findByName = new JButton("<html><style>.name{text-align: center;}</style><div class='name'>search product<br>by name</div>");
    JButton findByBrand = new JButton("<html><style>.name{text-align: center;}</style><div class='name'>search product<br>by brand</div>");
    JButton addToCart = new JButton("<html><style>.name{text-align: center;}</style><div class='name'>add product<br>to cart</div>");
    JButton showCart = new JButton("show cart");
    JButton removeFromCart = new JButton("<html><style>.name{text-align: center;}</style><div class='name'>remove product<br>from cart</div>");
    JButton showOrders = new JButton("show orders");
    JButton removeOrder = new JButton("remove order");
    ImageIcon btnGoods = new ImageIcon("img/mm/gadgets.png");
    ImageIcon btnFBN = new ImageIcon("img/mm/fbn.png");
    ImageIcon btnFBB = new ImageIcon("img/mm/fbb.png");
    ImageIcon btnATC = new ImageIcon("img/mm/atc.png");
    ImageIcon btnSC = new ImageIcon("img/mm/sc.png");
    ImageIcon btnRFC = new ImageIcon("img/mm/rfc.png");
    ImageIcon btnSO = new ImageIcon("img/mm/so.png");
    ImageIcon btnRO = new ImageIcon("img/mm/ro.png");
    ImageIcon kittens = new ImageIcon("img/mainframe/kitten.gif");
    ImageIcon mainFrameIcon = new ImageIcon("img/mainframe/shop.png");

    public GUI() {
        bgPanel.setBackground(Color.decode("#251f31"));
        bgPanel.setBounds(0, 0, 1500, 700);

        showGoods.setBackground(Color.decode("#5f3b73"));
        showGoods.setBounds(50, 50, 200, 200);
        showGoods.setFocusable(false);
        showGoods.setFocusPainted(false);
        showGoods.setIcon(btnGoods);
        showGoods.setHorizontalTextPosition(JButton.CENTER);
        showGoods.setVerticalTextPosition(JButton.BOTTOM);
        showGoods.setFont(new Font("Century Gothic", Font.BOLD, 18));
        showGoods.setForeground(Color.decode("#a58bb5"));
        showGoods.addActionListener(this);
        showGoods.addMouseListener(this);
        showGoods.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        findByName.setBackground(Color.decode("#5f3b73"));
        findByName.setBounds(300, 50, 200, 200);
        findByName.setFocusable(false);
        findByName.setFocusPainted(false);
        findByName.setIcon(btnFBN);
        findByName.setHorizontalTextPosition(JButton.CENTER);
        findByName.setVerticalTextPosition(JButton.BOTTOM);
        findByName.setFont(new Font("Century Gothic", Font.BOLD, 18));
        findByName.setForeground(Color.decode("#a58bb5"));
        findByName.addActionListener(this);
        findByName.addMouseListener(this);
        findByName.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        findByBrand.setBackground(Color.decode("#5f3b73"));
        findByBrand.setBounds(550, 50, 200, 200);
        findByBrand.setFocusable(false);
        findByBrand.setFocusPainted(false);
        findByBrand.setIcon(btnFBB);
        findByBrand.setHorizontalTextPosition(JButton.CENTER);
        findByBrand.setVerticalTextPosition(JButton.BOTTOM);
        findByBrand.setFont(new Font("Century Gothic", Font.BOLD, 18));
        findByBrand.setForeground(Color.decode("#a58bb5"));
        findByBrand.addActionListener(this);
        findByBrand.addMouseListener(this);
        findByBrand.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        addToCart.setBackground(Color.decode("#5f3b73"));
        addToCart.setBounds(800, 50, 200, 200);
        addToCart.setFocusable(false);
        addToCart.setFocusPainted(false);
        addToCart.setIcon(btnATC);
        addToCart.setHorizontalTextPosition(JButton.CENTER);
        addToCart.setVerticalTextPosition(JButton.BOTTOM);
        addToCart.setFont(new Font("Century Gothic", Font.BOLD, 18));
        addToCart.setForeground(Color.decode("#a58bb5"));
        addToCart.addActionListener(this);
        addToCart.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        addToCart.addMouseListener(this);
        addToCart.addMouseListener(this);
        addToCart.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        showCart.setBackground(Color.decode("#5f3b73"));
        showCart.setBounds(50, 300, 200, 200);
        showCart.setFocusable(false);
        showCart.setFocusPainted(false);
        showCart.setIcon(btnSC);
        showCart.setHorizontalTextPosition(JButton.CENTER);
        showCart.setVerticalTextPosition(JButton.BOTTOM);
        showCart.setFont(new Font("Century Gothic", Font.BOLD, 18));
        showCart.setForeground(Color.decode("#a58bb5"));
        showCart.addActionListener(this);
        showCart.addMouseListener(this);
        showCart.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        removeFromCart.setBackground(Color.decode("#5f3b73"));
        removeFromCart.setBounds(300, 300, 200, 200);
        removeFromCart.setFocusable(false);
        removeFromCart.setFocusPainted(false);
        removeFromCart.setIcon(btnRFC);
        removeFromCart.setHorizontalTextPosition(JButton.CENTER);
        removeFromCart.setVerticalTextPosition(JButton.BOTTOM);
        removeFromCart.setFont(new Font("Century Gothic", Font.BOLD, 18));
        removeFromCart.setForeground(Color.decode("#a58bb5"));
        removeFromCart.addActionListener(this);
        removeFromCart.addMouseListener(this);
        removeFromCart.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        showOrders.setBackground(Color.decode("#5f3b73"));
        showOrders.setBounds(550, 300, 200, 200);
        showOrders.setFocusable(false);
        showOrders.setFocusPainted(false);
        showOrders.setIcon(btnSO);
        showOrders.setHorizontalTextPosition(JButton.CENTER);
        showOrders.setVerticalTextPosition(JButton.BOTTOM);
        showOrders.setFont(new Font("Century Gothic", Font.BOLD, 18));
        showOrders.setForeground(Color.decode("#a58bb5"));
        showOrders.addActionListener(this);
        showOrders.addMouseListener(this);
        showOrders.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        removeOrder.setBackground(Color.decode("#5f3b73"));
        removeOrder.setBounds(800, 300, 200, 200);
        removeOrder.setFocusable(false);
        removeOrder.setFocusPainted(false);
        removeOrder.setIcon(btnRO);
        removeOrder.setHorizontalTextPosition(JButton.CENTER);
        removeOrder.setVerticalTextPosition(JButton.BOTTOM);
        removeOrder.setFont(new Font("Century Gothic", Font.BOLD, 18));
        removeOrder.setForeground(Color.decode("#a58bb5"));
        removeOrder.addActionListener(this);
        removeOrder.addMouseListener(this);
        removeOrder.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        kittenInBox.setBounds(1150, 130, 230, 230);
        kittenInBox.setIcon(kittens);
        kittenInBox.setBackground(Color.decode("#251f31"));
        kittenInBox.setOpaque(true);

        kittenMessage.setFont(new Font("Century Gothic", Font.PLAIN, 18));
        kittenMessage.setBounds(1075, 350, 650, 100);
        kittenMessage.setForeground(Color.decode("#a58bb5"));
        kittenMessage.setBackground(Color.decode("#251f31"));
        kittenMessage.setOpaque(true);

        mainPane.setBounds(0, 0, 1500, 700);
        mainPane.addMouseListener(this);
        mainPane.add(showGoods);
        mainPane.add(findByName);
        mainPane.add(findByBrand);
        mainPane.add(addToCart);
        mainPane.add(showCart);
        mainPane.add(removeFromCart);
        mainPane.add(showOrders);
        mainPane.add(removeOrder);
        mainPane.add(kittenMessage);
        mainPane.add(kittenInBox);

        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setIconImage(mainFrameIcon.getImage());
        mainFrame.setSize(1500, 600);
        mainFrame.setResizable(false);
        mainFrame.getContentPane().setBackground(Color.decode("#251f31"));
        mainFrame.setVisible(true);
        mainFrame.addKeyListener(this);
        mainFrame.add(mainPane);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == showGoods) {
            new ShowGoods();
        }
        if (actionEvent.getSource() == findByName) {
            new FindByNameGUI();
        }
        if (actionEvent.getSource() == findByBrand) {
            new FindByBrandGUI();
        }
        if (actionEvent.getSource() == addToCart) {
            new AddProductToCart();
        }
        if (actionEvent.getSource() == showCart) {
            new ShowCart();
        }
        if (actionEvent.getSource() == removeFromCart) {
            new RemoveProductFromCart();
        }
        if (actionEvent.getSource() == showOrders) {
            new ShowOrders();
        }
        if (actionEvent.getSource() == removeOrder) {
            new RemoveOrder();
        }
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {
        if (mouseEvent.getSource() == showGoods) {
            kittenInBox.setIcon(new ImageIcon("img/mainframe/showGoods.gif"));
            kittenInBox.setBounds(1170, 130, 230, 230);
            kittenMessage.setText("Show all products in our store");
            kittenMessage.setBounds(1135, 350, 650, 80);
        }
        if (mouseEvent.getSource() == findByName) {
            kittenInBox.setIcon(new ImageIcon("img/mainframe/findKitty.gif"));
            kittenInBox.setBounds(1170, 130, 230, 230);
            kittenMessage.setText("Find all products by name");
            kittenMessage.setBounds(1135, 350, 650, 80);
        }
        if (mouseEvent.getSource() == findByBrand) {
            kittenInBox.setIcon(new ImageIcon("img/mainframe/findKitty.gif"));
            kittenInBox.setBounds(1170, 130, 230, 230);
            kittenMessage.setText("Find all products by brand");
            kittenMessage.setBounds(1135, 350, 650, 80);
        }
        if (mouseEvent.getSource() == showCart) {
            kittenInBox.setIcon(new ImageIcon("img/mainframe/showGoods.gif"));
            kittenInBox.setBounds(1170, 130, 230, 230);
            kittenMessage.setText("Show cart contents");
            kittenMessage.setBounds(1175, 350, 650, 80);
        }
        if (mouseEvent.getSource() == addToCart) {
            kittenInBox.setIcon(new ImageIcon("img/mainframe/addToCart.gif"));
            kittenInBox.setBounds(1150, 130, 250, 230);
            kittenMessage.setText("Add product to your cart");
            kittenMessage.setBounds(1160, 330, 650, 80);
        }
        if (mouseEvent.getSource() == removeFromCart) {
            kittenInBox.setIcon(new ImageIcon("img/mainframe/deleteKitty.gif"));
            kittenInBox.setBounds(1170, 130, 230, 230);
            kittenMessage.setText("Remove product from your cart");
            kittenMessage.setBounds(1110, 350, 650, 80);
        }
        if (mouseEvent.getSource() == showOrders) {
            kittenInBox.setIcon(new ImageIcon("img/mainframe/showOrders.gif"));
            kittenInBox.setBounds(1170, 130, 230, 230);
            kittenMessage.setText("Show order list");
            kittenMessage.setBounds(1210, 350, 650, 80);
        }
        if (mouseEvent.getSource() == removeOrder) {
            kittenInBox.setIcon(new ImageIcon("img/mainframe/deleteKitty.gif"));
            kittenInBox.setBounds(1170, 130, 230, 230);
            kittenMessage.setText("Decline order");
            kittenMessage.setBounds(1210, 350, 650, 80);
        }
        if (mouseEvent.getSource() == mainPane) {
            kittenInBox.setIcon(new ImageIcon("img/mainframe/kitten.gif"));
            kittenInBox.setBounds(1150, 130, 230, 230);
            kittenMessage.setText("<html><style>.name{text-align: center;}</style><div class='name'>Hello, we are <b>Biba</b> and <b>Boba</b><br>and we will help you navigate in our store</div>");
            kittenMessage.setBounds(1075, 350, 650, 100);
        }
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {
    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {
    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == KeyEvent.VK_ESCAPE) {
            System.exit(0);
        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {
    }

    class AddProductToCart implements ActionListener {
        JFrame frame = new JFrame("electronic store - add product to cart");

        JLayeredPane mainPane = new JLayeredPane();

        JButton buttonSubmit = new JButton(" Add");

        JTextField input = new JTextField();

        JLabel searchResult = new JLabel();
        JLabel catMessage = new JLabel("Enter product name what do you want to add to your cart");
        JLabel icon = new JLabel();

        ImageIcon contains = new ImageIcon("img/reactions/contain.gif");
        ImageIcon notContains = new ImageIcon("img/reactions/notContain.gif");
        ImageIcon defaultImg = new ImageIcon("img/reactions/default.gif");
        ImageIcon btnSubmit = new ImageIcon("img/reactions/add.png");
        ImageIcon frameIcon = new ImageIcon("img/mainframe/atc.png");

        AddProductToCart() {
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
            catMessage.setBounds(90, 250, 650, 100);
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
                new GoodsServiceMySQL().addProductToCart(cart, input.getText());
                if (cart.isEmpty()) {
                    icon.setBounds(210, 70, 230, 230);
                    icon.setIcon(notContains);
                    catMessage.setBounds(200, 250, 650, 100);
                    catMessage.setText("Product '" + input.getText() + "' is out of stock!");
                } else {
                    icon.setBounds(230, 70, 230, 230);
                    icon.setIcon(contains);
                    catMessage.setBounds(90, 250, 650, 100);
                    catMessage.setText("Product '" + input.getText() + "' successfully added to your cart!");
                }
            }
        }
    }

    class RemoveProductFromCart implements ActionListener {
        JFrame frame = new JFrame("electronic store - remove product from cart");
        JLayeredPane mainPane = new JLayeredPane();
        JButton buttonSubmit = new JButton(" Remove");
        JTextField input = new JTextField();
        JLabel searchResult = new JLabel();
        JLabel catMessage = new JLabel("Enter product number that you want to remove");
        JLabel icon = new JLabel();
        ImageIcon emptyCart = new ImageIcon("img/reactions/deleteAngry.gif");
        ImageIcon notEmptyCart = new ImageIcon("img/reactions/deleteHappy.gif");
        ImageIcon defaultImg = new ImageIcon("img/reactions/default.gif");
        ImageIcon btnSubmit = new ImageIcon("img/reactions/remove.png");
        ImageIcon frameIcon = new ImageIcon("img/mainframe/rfc.png");

        RemoveProductFromCart() {
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
                if (cart.isEmpty()) {
                    icon.setIcon(emptyCart);
                    catMessage.setText("Your cart is empty!");
                    catMessage.setBounds(240, 250, 650, 100);
                } else {
                    int delVal = Integer.parseInt(input.getText());
                    new GoodsServiceMySQL().removeProductFromCart(cart.get(delVal - 1).getProduct());
                    String delProdName = cart.get(delVal - 1).getProduct();
                    cart.remove(delVal - 1);
                    icon.setBounds(200, 90, 200, 200);
                    icon.setIcon(notEmptyCart);
                    catMessage.setBounds(100, 250, 650, 100);
                    catMessage.setText("Product '" + delProdName + "' successfully deleted from your cart!");
                }
            }
        }
    }

    class ShowCart implements ActionListener {
        JButton createOrder = new JButton("  Make an order");
        JLayeredPane mainPane = new JLayeredPane();
        JTextArea textArea = new JTextArea();
        JLabel catMessage = new JLabel();
        JLabel icon = new JLabel();
        ImageIcon cartEmpty = new ImageIcon("img/reactions/notContain.gif");
        ImageIcon orderDenied = new ImageIcon("img/reactions/veryAngry.gif");
        ImageIcon orderAccepted = new ImageIcon("img/reactions/orderCreated.gif");
        ImageIcon defaultImg = new ImageIcon("img/reactions/cartDefault.gif");
        ImageIcon btnSubmit = new ImageIcon("img/reactions/courier.png");
        ImageIcon frameIcon = new ImageIcon("img/mainframe/cart.png");

        ShowCart() {
            createOrder.setIcon(btnSubmit);
            createOrder.setBounds(240, 25, 250, 50);
            createOrder.setFont(new Font("Century Gothic", Font.BOLD, 18));
            createOrder.setBackground(Color.decode("#5f3b73"));
            createOrder.setForeground(Color.decode("#a58bb5"));
            createOrder.setFocusable(false);
            createOrder.setFocusPainted(false);
            createOrder.addActionListener(this);
            createOrder.setOpaque(true);

            catMessage.setFont(new Font("Century Gothic", Font.PLAIN, 16));
            catMessage.setForeground(Color.decode("#a58bb5"));
            catMessage.setBackground(Color.decode("#251f31"));
            catMessage.setOpaque(true);

            icon.setBounds(390, 70, 230, 230);
            icon.setIcon(defaultImg);

            if (cart.isEmpty()) {
                icon.setBounds(260, 70, 230, 230);
                icon.setIcon(cartEmpty);
                catMessage.setBounds(300, 240, 650, 80);
                catMessage.setText("Your cart is empty!");
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                int num = 1;
                for (Goods goods : cart) {
                    stringBuilder.append(num + ") " + goods + "\n");
                    num++;
                }
                textArea = new JTextArea(stringBuilder.toString());
                textArea.setFont(new Font("Century Gothic", Font.PLAIN, 18));
                textArea.setBounds(10, 260, 730, 500);
                textArea.setBackground(Color.decode("#251f31"));
                textArea.setForeground(Color.decode("#a58bb5"));
                textArea.setOpaque(true);
            }
            mainPane.setBounds(0, 0, 730, 500);
            mainPane.add(icon);
            mainPane.add(catMessage);
            mainPane.add(textArea);
            mainPane.add(createOrder);
            JFrame frame = new JFrame("electronic store - cart contents");
            frame.getContentPane().setBackground(Color.decode("#251f31"));
            frame.setSize(730, 500);
            frame.setIconImage(frameIcon.getImage());
            frame.setVisible(true);
            frame.setResizable(false);
            frame.add(mainPane);
        }

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            if (actionEvent.getSource() == createOrder) {
                if (cart.isEmpty()) {
                    icon.setBounds(260, 70, 230, 230);
                    icon.setIcon(orderDenied);
                    catMessage.setText("I told you that your cart is empty!!!");
                    catMessage.setBounds(230, 250, 650, 80);
                } else {
                    for (Goods goods : cart) {
                        Order order = new Order(goods.getProduct(), goods.getBrand(), "processed", goods.getPrice());
                        new GoodsServiceMySQL().makeOrder(order);
                    }
                    cart.clear();
                    textArea.setVisible(false);
                    icon.setBounds(260, 100, 190, 190);
                    icon.setIcon(orderAccepted);
                    catMessage.setBounds(170, 265, 650, 80);
                    catMessage.setText("Order successfully created, courier is on the way ;)");
                }
            }
        }
    }
}

class ShowGoods {
    ImageIcon frameIcon = new ImageIcon("img/mainframe/goods.png");

    ShowGoods() {
        List<Goods> list = new GoodsServiceMySQL().goodsData();
        StringBuilder stringBuilder = new StringBuilder();
        for (Goods s : list) {
            stringBuilder.append(s).append("\n");
        }
        JTextArea textArea = new JTextArea(stringBuilder.toString());
        textArea.setFont(new Font("Century Gothic", Font.PLAIN, 18));
        textArea.setSize(650, 550);
        textArea.setBackground(Color.decode("#251f31"));
        textArea.setForeground(Color.decode("#a58bb5"));
        JFrame frame = new JFrame("electronic store - goods list");
        frame.setResizable(false);
        frame.setSize(730, 500);
        frame.setIconImage(frameIcon.getImage());
        frame.setVisible(true);
        frame.add(textArea);
    }
}

class ShowOrders {
    ShowOrders() {
        JLabel catMessage = new JLabel();
        catMessage.setFont(new Font("Century Gothic", Font.PLAIN, 16));
        catMessage.setBounds(130, 250, 650, 100);
        catMessage.setForeground(Color.decode("#a58bb5"));
        catMessage.setBackground(Color.decode("#251f31"));
        catMessage.setOpaque(true);

        JLayeredPane mainPane = new JLayeredPane();
        mainPane.setBounds(0, 0, 730, 500);

        List<Order> list = new GoodsServiceMySQL().ordersData();

        JTextArea textArea = new JTextArea();

        ImageIcon showOrders = new ImageIcon("img/mm/so.png");

        if (list.isEmpty()) {
            catMessage.setText("Order list is empty");
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            for (Order o : list) {
                stringBuilder.append(o).append("\n");
            }
            textArea = new JTextArea(stringBuilder.toString());
            textArea.setFont(new Font("Century Gothic", Font.PLAIN, 18));
            textArea.setBounds(0, 0, 730, 500);
            textArea.setBackground(Color.decode("#251f31"));
            textArea.setForeground(Color.decode("#a58bb5"));
            textArea.setOpaque(true);
        }
        mainPane.add(catMessage);
        mainPane.add(textArea);
        JFrame frame = new JFrame("electronic store - orders list");
        frame.setSize(730, 500);
        frame.setIconImage(showOrders.getImage());
        frame.setVisible(true);
        frame.setResizable(false);
        frame.add(mainPane);
    }
}

class RemoveOrder implements ActionListener {
    JFrame frame = new JFrame("electronic store - remove order from order list");
    JLayeredPane mainPane = new JLayeredPane();
    JButton buttonSubmit = new JButton(" Remove");
    JTextField input = new JTextField();
    JLabel searchResult = new JLabel();
    JLabel catMessage = new JLabel("Enter product name that you want to remove");
    JLabel icon = new JLabel();
    ImageIcon defaultImg = new ImageIcon("img/reactions/default.gif");
    ImageIcon deleteSuccess = new ImageIcon("img/reactions/deleteHappy.gif");
    ImageIcon btnSubmit = new ImageIcon("img/reactions/remove.png");
    ImageIcon frameIcon = new ImageIcon("img/mainframe/ro.png");

    RemoveOrder() {
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
        frame.setIconImage(frameIcon.getImage());
        frame.setVisible(true);
        frame.setResizable(false);
        frame.add(mainPane);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == buttonSubmit) {
            new GoodsServiceMySQL().cancelOrder(input.getText());
            catMessage.setBounds(200, 250, 650, 100);
            catMessage.setText("Order successfully declined");
            icon.setIcon(deleteSuccess);
        }
    }
}
