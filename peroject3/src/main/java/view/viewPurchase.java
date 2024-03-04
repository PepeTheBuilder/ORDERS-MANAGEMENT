package view;

import javax.swing.*;
import java.awt.*;

public class viewPurchase extends JFrame {
    private JButton goClientBtn;
    private JTextField textId;
    private JButton searchIdPurchaseBtn;
    private JButton giveAllOrdersBtn;
    private JButton goToProductBtn;
    private JPanel jPanel;
    public JButton createOrderButton;
    public JTextField textFieldClientId;
    public JTextField textFieldProductID;
    public JTextField textFieldQuantity;
    public JLabel totalPriceTag;

    public viewPurchase(){

        this.add(jPanel);
        // Set the title of the frame
        setTitle("Purchase/Order View");

        // Set the dimensions of the frame
        setSize(700, 700);

        // Center the frame on the screen
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(screenSize.width / 2 - getWidth() / 2, screenSize.height / 2 - getHeight() / 2);

        // Set the default close operation
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    public JButton getGoClientBtn() {
        return goClientBtn;
    }

    public void setGoClientBtn(JButton goClientBtn) {
        this.goClientBtn = goClientBtn;
    }

    public JButton getGoPurchaseBtn() {
        return goToProductBtn;
    }

    public void setGoPurchaseBtn(JButton goPurchaseBtn) {
        this.goToProductBtn = goPurchaseBtn;
    }

    public JTextField getTextId() {
        return textId;
    }

    public void setTextId(JTextField textId) {
        this.textId = textId;
    }

    public JButton getSearchIdPurchaseBtn() {
        return searchIdPurchaseBtn;
    }

    public void setSearchIdPurchaseBtn(JButton searchIdPurchaseBtn) {
        this.searchIdPurchaseBtn = searchIdPurchaseBtn;
    }

    public JButton getGiveAllOrdersBtn() {
        return giveAllOrdersBtn;
    }

    public void setGiveAllOrdersBtn(JButton giveAllOrdersBtn) {
        this.giveAllOrdersBtn = giveAllOrdersBtn;
    }
}
