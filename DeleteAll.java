package demo;

import domain.Product;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class DeleteAll {
    public static void main(String[] args) {
        Configuration cfg;
        SessionFactory factory;
        Session ses;
        cfg=new Configuration();
        cfg=cfg.configure();
        cfg=cfg.addAnnotatedClass(Product.class);
        factory=cfg.buildSessionFactory();
        ses=factory.openSession();
        //to display all the objects of product class

        Query q=ses.createQuery("delete p from Product p");
        List<Product> ProductList=q.list();
        for(Product p:ProductList)
        {
            System.out.println(p);
        }


    }
}
