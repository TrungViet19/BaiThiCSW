package service;

import com.google.gson.Gson;
import entity.Product;
import org.hibernate.Session;
import util.HibernateUtil;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@WebService
public class ProductService {

    public static void main(String[] args) {
        Product product = new Product();
        product.setName("One");
        product.setPrice(1000);
        product.setQuantity(1);
//        new ProductService().addProduct(product);
//        new ProductService().sellProduct(1,3);
        System.out.println(new Gson().toJson(new ProductService().getAllProduct()));

    }

    @WebMethod
    public boolean addProduct(Product p) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.save(p);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @WebMethod
    public String getAllProduct() {

        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        List<Product> products = session.createCriteria(Product.class).list();
        session.getTransaction().commit();
        session.close();
        return new Gson().toJson(products);
    }

    @WebMethod
    public boolean sellProduct(int productId, int quantity) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Product product = session.get(Product.class, productId);
        if (product.getQuantity() < quantity){
            session.close();
            return false;
        }
        product.setQuantity(product.getQuantity() - quantity);
        session.saveOrUpdate(product);
        session.getTransaction().commit();
        session.close();
        return true;
    }
}
