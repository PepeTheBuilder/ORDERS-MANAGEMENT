package view;

import javax.swing.*;
import java.awt.*;

public class view extends JFrame{
    private JTextField textId;
    private JTextField textName;
    private JTextField textQuantity;
    private JTextField textPrice;
    private JButton prodSearchIdBtn;
    private JButton prodCreateBtn;
    private JButton prodSearchAllBtn;
    private JButton goClientBtn;
    private JButton goPurchaseBtn;
    private JButton prodDeleteBtn;
    private JButton prodUpdateBtn;
    private JPanel jPanel;
    public view(){
        this.add(jPanel);
        // Set the title of the frame
        setTitle("Product View");

        // Set the dimensions of the frame
        setSize(700, 700);

        // Center the frame on the screen
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(screenSize.width / 2 - getWidth() / 2, screenSize.height / 2 - getHeight() / 2);

        // Set the default close operation
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public JButton getProdSearchIdBtn() {
        return prodSearchIdBtn;
    }

    public JButton getProdCreateBtn() {
        return prodCreateBtn;
    }

    public JButton getProdSearchAllBtn() {
        return prodSearchAllBtn;
    }

    public JButton getGoClientBtn() {
        return goClientBtn;
    }

    public JButton getGoPurchaseBtn() {
        return goPurchaseBtn;
    }
    public JButton getProdDeleteBtn() {
        return prodDeleteBtn;
    }

    public JButton getProdUpdateBtn() {
        return prodUpdateBtn;
    }

    public JTextField getTextId() {
        return textId;
    }

    public JTextField getTextName() {
        return textName;
    }

    public JTextField getTextQuantity() {
        return textQuantity;
    }

    public JTextField getTextPrice() {
        return textPrice;
    }
}
