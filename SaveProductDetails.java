package demo;

import domain.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class SaveProductDetails {
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
        p1.setProductId(1);
        p1.setProductName("laptop");
        p1.setProductCategory("electronics");
        p1.setProductPrice(45000.25);

        //start the transaction

        tx=ses.beginTransaction();
        ses.save(p1);
        tx.commit();
        System.out.println("product inserted successfully");


    }


}
