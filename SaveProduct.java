package demo;

import domain.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;


public class SaveProduct {
    public static void main(String[] args) {
        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction tx;

        //activate hibernate framework
        cfg=new Configuration();
        cfg=cfg.configure();    // for read data

        //establish communication link
        factory=cfg.buildSessionFactory();

        //start the session
        ses=factory.openSession();

        //create object of domain class
        Product p1=new Product();
       Scanner sc=new Scanner(System.in);
        System.out.println("enter id");
        int id=sc.nextInt();
        System.out.println("enter product name");
        String name=sc.next();
        System.out.println("enter product category");
        String category=sc.next();
        System.out.println("enter product price");
        double price=sc.nextDouble();

        p1.setProductId(id);
        p1.setProductName(name);
        p1.setProductCategory(category);
        p1.setProductPrice(price);

        tx=ses.beginTransaction();
        ses.save(p1);
        tx.commit();
        System.out.println("product inserted");




    }

}
