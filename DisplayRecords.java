package demo;

import domain.Product;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DisplayRecords {
    public static void main(String[] args) {
        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction tx;

        cfg=new Configuration();
        cfg=cfg.addAnnotatedClass(Product.class);
        factory=cfg.buildSessionFactory();
        ses=factory.openSession();
        //fetch first 3 records from database table
        Criteria crt1=ses.createCriteria(Product.class);
        crt1.setMaxResults(3);
        List<Product>ProductList=crt1.list();
        for(Product p:ProductList)
        {
            System.out.println(p);
        }
        //exclude first 3 records
        Criteria crt2=ses.createCriteria(Product.class);
        crt2.setMaxResults(3);
        List<Product>List1=crt2.list();
        for(Product p:List1)
        {
            System.out.println(p);
        }
        //display product having price less than 30000
        Criteria crt4=ses.createCriteria(Product.class);
        crt4.add(Restrictions.lt("productPrice",30000));
        List<Product>List3=crt4.list();
        for(Product p:List3)
        {
            System.out.println(p);
        }
    }
}


