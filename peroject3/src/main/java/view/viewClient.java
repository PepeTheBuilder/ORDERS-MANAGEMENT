package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class viewClient extends JFrame{
    public JTextField idTextField;
    public JTextField nameTextField;
    public JTextField emailTextField;
    public JButton findClientByIdButton;
    public JButton updateClientButton;
    public JButton showAllClientButton;
    public JButton createClientButton;
    public JButton deleteClientButton;
    public JButton goToProductsButton;
    public JButton goToPurchaseButton;
    private JPanel jPanel;

    public viewClient(){
        this.add(jPanel);
        // Set the title of the frame
        setTitle("Client View");

        // Set the dimensions of the frame
        setSize(700, 700);

        // Center the frame on the screen
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(screenSize.width / 2 - getWidth() / 2, screenSize.height / 2 - getHeight() / 2);

        // Set the default close operation
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }
    public void FindClientByIdListener(ActionListener e) {
        findClientByIdButton.addActionListener(e);
    }
    public void UpdateClientListener(ActionListener e) {
        updateClientButton.addActionListener(e);
    }
    public void ShowAllClientListener(ActionListener e) {
        showAllClientButton.addActionListener(e);
    }
    public void CreateClientListener(ActionListener e) {
        createClientButton.addActionListener(e);
    }
    public void DeleteClientListener(ActionListener e) {
        deleteClientButton.addActionListener(e);
    }
    public void GoToPurchaseListener(ActionListener e) {
        goToPurchaseButton.addActionListener(e);
    }
    public void GoToProductListener(ActionListener e) {

            goToProductsButton.addActionListener(e);
    }


}
