package controller;

import bll.ClientBLL;
import bll.ProductBLL;
import model.Client;
import model.Product;
import view.viewClient;
import view.view;
import view.viewPurchase;
import bll.PurchaseBLL;
import model.Purchase;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class PurchaseController {
    private viewPurchase viewPurchase;
    private PurchaseBLL purchaseBLL;

    public PurchaseController(viewPurchase view, PurchaseBLL purchaseBLL) {
        this.viewPurchase = view;
        this.purchaseBLL = purchaseBLL;

        // Add action listeners to the buttons
        view.getSearchIdPurchaseBtn().addActionListener(new SearchIdPurchaseListener());
        view.getGiveAllOrdersBtn().addActionListener(new GiveAllOrdersListener());
        view.getGoPurchaseBtn().addActionListener(new GoProductListener());
        view.getGoClientBtn().addActionListener(new GoClientListener());
        view.createOrderButton.addActionListener(new CreateOrder());
    }

    class CreateOrder implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int clientId = Integer.parseInt(viewPurchase.textFieldClientId.getText());
            int productId = Integer.parseInt(viewPurchase.textFieldProductID.getText());
            int quantity = Integer.parseInt(viewPurchase.textFieldQuantity.getText());
            try {
                    ProductBLL productBLL= new ProductBLL();
                    Product product = productBLL.findProductById(productId);
                    ClientBLL clientBLL = new ClientBLL();
                    Client client = clientBLL.findClientById(clientId);
                    if(product!=null&&client!=null){
                        if(product.getQuantity()<quantity){
                            JOptionPane.showMessageDialog(viewPurchase, "We don't have "+ quantity + " "+product.getName()+" we have only "+product.getQuantity());
                            return;
                        }
                        product.setQuantity(product.getQuantity()-quantity);
                        productBLL.updateProduct(product);
                        Purchase purchase= new Purchase();
                        purchase.setClientID(clientId);
                        purchase.setProductId(productId);
                        purchase.setQuantity(quantity);
                        purchase.setId(0);
                        purchase.setTotalPrice(quantity*product.getPrice());
                        viewPurchase.totalPriceTag.setText(""+purchase.getTotalPrice());
                        if(purchaseBLL.insert(purchase)) {
                            JOptionPane.showMessageDialog(viewPurchase, "Purchase was made!");
                        }
                    }


                // view.displayPurchaseDetails(purchase);
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(viewPurchase, "Purchase not found!");
            }
        }
    }

    // ActionListener for searchIdPurchaseBtn
    class SearchIdPurchaseListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int id = Integer.parseInt(viewPurchase.getTextId().getText());
            try {
                Purchase purchase = purchaseBLL.findPurchaseById(id);
               // view.displayPurchaseDetails(purchase);
            } catch (NoSuchElementException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(viewPurchase, "Purchase not found!");
            }
        }
    }

    // ActionListener for giveAllOrdersBtn
    class GiveAllOrdersListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            ArrayList<Purchase> purchases = purchaseBLL.findAll();
            //view.displayAllPurchases(purchases);
        }
    }

    // ActionListener for goPurchaseBtn
    class GoProductListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            view productView = new view();
            ProductBLL productBLL= new ProductBLL();
            ProductController productController = new ProductController(productBLL, productView);
            productView.setVisible(true);
            viewPurchase.setVisible(false);
        }
    }

    // ActionListener for goClientBtn
    class GoClientListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            viewClient clientView = new viewClient();
            ClientBLL clientBLL =new ClientBLL();
            ClientController clientController = new ClientController(clientView, clientBLL);
            clientView.setVisible(true);
            viewPurchase.setVisible(false);
        }
    }
}
