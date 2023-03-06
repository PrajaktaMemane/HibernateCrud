package demo;

import domain.Product;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;

import java.util.Iterator;
import java.util.List;


public class DisplayDetails {
    public static void main(String[] args) {
        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction tx;

     cfg=new Configuration();
     cfg=cfg.addAnnotatedClass(Product.class);
     factory=cfg.buildSessionFactory();
     ses=factory.openSession();
     //fetching details from all columns
        //create criteria
        Criteria crt1=ses.createCriteria(Product.class);
        //execute criteria
        List<Product>ProductList=crt1.list();

        for(Product p:ProductList)
        {
            System.out.println(p);
        }
        System.out.println("===========================================================");
        //fetching details from spesific column
        //create criteria
        Criteria crt2=ses.createCriteria(Product.class);
        //add requirememt details
        crt2.setProjection(Projections.property("productName"));
        //execute criteria
        List<String> name=crt2.list();
        for(String s:name)
        {
            System.out.println(s);
        }
        System.out.println("===============================================");

        //fetch details from name and price column
        //create criteria
        Criteria crt3=ses.createCriteria(Product.class);
        //add requirement details
        ProjectionList plist=Projections.projectionList();
        plist.add(Projections.property("productName"));
        plist.add(Projections.property("productPrice"));
        //execute criteria
        List data=crt3.list();
        Iterator itr=data.iterator();
        while(itr.hasNext())
        {
            Object[] arr=(Object[]) itr.next();
            System.out.println(arr[0]+"\t\t"+arr[1]);
        }

    }
}
