package demo;

import domain.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UpdateOneRecord {
    public static void main(String[] args) {

            Configuration cfg;
            SessionFactory factory;
            Session ses;
            Transaction tx;

            cfg=new Configuration();
            cfg=cfg.configure();
            factory=cfg.buildSessionFactory();
            ses=factory.openSession();
            Product p1=ses.load(Product.class,1);
            p1.setProductName("tv");

            tx=ses.beginTransaction();
            ses.update(p1);
            tx.commit();
            System.out.println("update sucessfully");
    }
}
