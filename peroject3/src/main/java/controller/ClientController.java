package controller;

import bll.ClientBLL;
import bll.ProductBLL;
import bll.PurchaseBLL;
import model.Client;
import view.viewClient;
import view.view;
import view.viewPurchase;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ClientController {
    private viewClient viewClient;
    private ClientBLL model;

    public ClientController(viewClient view, ClientBLL model) {
        this.viewClient = view;
        this.model = model;

        // Add action listeners to the buttons
        view.findClientByIdButton.addActionListener(new FindClientByIdListener());
        view.updateClientButton.addActionListener(new UpdateClientListener());
        view.showAllClientButton.addActionListener(new ShowAllClientListener());
        view.createClientButton.addActionListener(new CreateClientListener());
        view.deleteClientButton.addActionListener(new DeleteClientListener());
        view.goToProductsButton.addActionListener(new GoToPurchaseListener());
        view.goToPurchaseButton.addActionListener(new GoToProductListener());
    }


    // ActionListener for the "Go to Products" button
    class GoToProductListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            view productsView = new view();
            ProductBLL productBLL =new ProductBLL();
            ProductController productsController = new ProductController(productBLL, productsView);
            productsView.setVisible(true);
            viewClient.setVisible(false);
        }
    }

    // ActionListener for the "Go to Purchase" button
    class GoToPurchaseListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            viewPurchase purchaseView = new viewPurchase();
            PurchaseBLL purchaseBLL= new PurchaseBLL();
            PurchaseController purchaseController = new PurchaseController(purchaseView, purchaseBLL);
            purchaseView.setVisible(true);
            viewClient.setVisible(false);
        }
    }



    /**
     * ActionListener for the "Find Client by ID" button
     */
    class FindClientByIdListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int id = Integer.parseInt(viewClient.idTextField.getText());
            Client client = model.findClientById(id);
            if (client != null) {
                viewClient.nameTextField.setText(client.getName());
                viewClient.emailTextField.setText(client.getEmail());
            } else {
                JOptionPane.showMessageDialog(null, "Client not found!");
            }
        }
    }

    /**
     * ActionListener for the "Update Client" button
     */
    class UpdateClientListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int id = Integer.parseInt(viewClient.idTextField.getText());
            String name = viewClient.nameTextField.getText();
            String email = viewClient.emailTextField.getText();

            Client client = new Client();
            client.setId(id);
            client.setName(name);
            client.setEmail(email);

            boolean updated = model.updateClient(client);
            if (updated) {

                JOptionPane.showMessageDialog(null, "Client updated successfully!");
            } else {
                JOptionPane.showMessageDialog(null, "Failed to update client!");
            }
        }
    }

    /**
     * ActionListener for the "Show All Clients" button
     */
    class ShowAllClientListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            ArrayList<Client> clients = model.getAllClients();
            // Display the clients in the view (e.g., using a table or list)
            // ...
        }
    }

    /**
     * ActionListener for the "Create Client" button
     */
    class CreateClientListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String name = viewClient.nameTextField.getText();
            String email = viewClient.emailTextField.getText();

            Client client = new Client();
            client.setName(name);
            client.setEmail(email);

            boolean created = model.insert(client);
            if (created) {
                JOptionPane.showMessageDialog(null, "Client created successfully!");
            } else {
                JOptionPane.showMessageDialog(null, "Failed to create client!");
            }
        }
    }

    /**
     * ActionListener for the "Delete Client" button
     */
    class DeleteClientListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int id = Integer.parseInt(viewClient.idTextField.getText());
            boolean deleted = model.delete(model.findClientById(id));
            if (deleted) {
                JOptionPane.showMessageDialog(null, "Client deleted successfully!");
            } else {
                JOptionPane.showMessageDialog(null, "Failed to delete client!");
            }
        }
    }
}
