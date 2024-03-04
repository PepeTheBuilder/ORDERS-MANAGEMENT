package bll;

import abstractDAO.PurchaseDAO;
import model.Purchase;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class PurchaseBLL {
    public PurchaseDAO purchaseDAO;
    public PurchaseBLL(){
        purchaseDAO=new PurchaseDAO();
    }
    public Purchase findPurchaseById(int id) {
        Purchase st = purchaseDAO.findById(id);
        if (st == null) {
            throw new NoSuchElementException("The purchase with id =" + id + " was not found!");
        }
        return st;
    }
    public ArrayList<Purchase> findAll(){
        return purchaseDAO.findAll();
    }
    public boolean insert(Purchase purchase){
        if(!purchaseDAO.insert(purchase)){
            System.out.print("Insert purchase error, return=false\n");
            return false;
        }
        return true;
    }
}
