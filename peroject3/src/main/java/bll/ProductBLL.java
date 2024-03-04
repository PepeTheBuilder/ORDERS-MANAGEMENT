package bll;

import abstractDAO.ProductDAO;
import model.Client;
import model.Product;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class ProductBLL {
    private ProductDAO productDAO;

    public ProductBLL(){
        productDAO=new ProductDAO();
    }
    public Product findProductById(int id) {
        Product st = productDAO.findById(id);
        if (st == null) {
            throw new NoSuchElementException("The client with id =" + id + " was not found!");
        }
        return st;
    }
    public boolean insert(Product product){
        if(!productDAO.insert(product)){
            System.out.print("Insert product error, return=false\n");
            return false;
        }
        return true;
    }

    public boolean delete(Product product){
        if(!productDAO.delete(product)){
            System.out.print("delete product error, return=false\n");
            return false;
        }
        return true;
    }
    public boolean updateProduct(Product product) {
        boolean product1=productDAO.update(product);
        if(!product1){
            System.out.println("The product=" + product.toString() + " was not updated in db");
            return  false;
        }
        return true;
    }

    public ArrayList<Product> getAllProducts() {
        return productDAO.findAll();
    }


}
