package demo;

import domain.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DisplayOneRecord {
    public static void main(String[] args) {
        Configuration cfg;
        SessionFactory factory;
        Session ses;

        cfg=new Configuration();
        cfg=cfg.configure();
        factory=cfg.buildSessionFactory();
        ses=factory.openSession();
        Product p1=ses.load(Product.class ,3);
        System.out.println(p1.getProductId());
        System.out.println(p1.getProductName());
        System.out.println(p1.getProductCategory());
        System.out.println(p1.getProductPrice());

    }
}
