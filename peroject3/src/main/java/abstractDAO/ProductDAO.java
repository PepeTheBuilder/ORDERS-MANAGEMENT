package abstractDAO;

import model.Product;

import java.util.ArrayList;

public class ProductDAO extends AbstractDAO<Product>{
    @Override
    public ArrayList<Product> findAll() {
        return super.findAll();
    }
    @Override
    public Product findById(int id) {
        return super.findById(id);
    }
    @Override
    public boolean insert(Product product) {
        return super.insert(product);
    }
    @Override
    public boolean update(Product product) {
        return super.update(product);
    }
    @Override
    public String createUpdateQuery(){
        return "UPDATE Product SET name = ?, price= ?, quantity = ? WHERE id = ?";
    }
    @Override
    public String createInsertQuery() {
        return "INSERT INTO Product (`name`, `price`, `quantity`) VALUES (?, ?, ?);";
    }

}
