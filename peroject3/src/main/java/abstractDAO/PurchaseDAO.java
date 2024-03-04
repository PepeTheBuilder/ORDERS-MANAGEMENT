package abstractDAO;

import model.Purchase;

import java.util.ArrayList;
import java.util.List;

public class PurchaseDAO extends  AbstractDAO<Purchase>{
    @Override
    public boolean insert(Purchase purchase) {
        return super.insert(purchase);
    }
    @Override
    public Purchase findById(int id) {
        return super.findById(id);
    }
    @Override
    public String createInsertQuery() {return "INSERT INTO Purchase (client_id,product_id,quantity, total_price) values (?,?,?,?)";}
    @Override
    public ArrayList<Purchase> findAll() {return super.findAll();}

}
