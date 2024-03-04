package org.example;

import bll.ClientBLL;
import bll.ProductBLL;
import controller.ProductController;
import database.DataAccess;
import model.Client;
import model.Product;
import view.view;

/**
 * Hello world!
 * basically run the main
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        view productView = new view();
        ProductBLL productBLL= new ProductBLL();
        ProductController productController = new ProductController(productBLL, productView);
        productView.setVisible(true);







//      ** TEST DELETE CLIENT! **
//        Client test= new Client();
//        test.setId(3);
//        test.setName("de sters");
//        test.setEmail("delete@alt.f4");
//        ClientBLL clientBLL = new ClientBLL();
//        System.out.println(test.toString());
//        boolean client = clientBLL.delete(test);
//        System.out.println(client);


//      ** TEST INSERT CLIENT! **
//        Client test= new Client();
//        test.setName("de sters");
//        test.setEmail("delete@alt.f4");
//        ClientBLL clientBLL = new ClientBLL();
//        System.out.println(test.toString());
//        boolean client = clientBLL.insert(test);
//        System.out.println(client);


//        ** TEST INSERT PRODUCT **
//        Product test= new Product();
//        test.setName("Margarina");
//        test.setPrice(10);
//        test.setQuantity(40);
//        ProductBLL productBLL = new ProductBLL();
//        System.out.println(test.toString());
//        boolean product = productBLL.insert(test);
//        ProductBLL clientBLL = new ProductBLL();
//        Product product = clientBLL.findProductById(1);
//       System.out.println(product);
    }
}
