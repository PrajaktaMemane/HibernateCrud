package demo;

import domain.Product;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Scanner;

public class DisplayAllByCategory {
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
        Scanner sc= new Scanner(System.in);
        System.out.println("enter product category");
        String productCategory=sc.next();
        Query q=ses.createQuery("select p from Product p where p.productCategory= +productCategory+");
        List<Product> ProductList=q.list();
        for(Product p:ProductList)
        {
            System.out.println(p);
        }


    }
}
