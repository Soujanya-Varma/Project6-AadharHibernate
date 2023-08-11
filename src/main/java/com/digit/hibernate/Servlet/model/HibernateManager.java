package com.digit.hibernate.Servlet.model;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.Query;
import com.digit.hibernate.Servlet.bean.AadharDetails;





public class HibernateManager {
	private Session session;
	private Transaction ref;
	
	
//	public void generateaadhar() {
//        Random r = new Random();
//        int Ano = (100000 + r.nextInt(900000));
//        id = Ano;
//    }
	public HibernateManager() {
		Configuration conf=new Configuration().configure("hibernate.cfg.xml");
		ServiceRegistryBuilder builder=new ServiceRegistryBuilder().applySettings(conf.getProperties());
		SessionFactory sessionfactory=conf.buildSessionFactory(builder.buildServiceRegistry());
		session=sessionfactory.openSession();
		System.out.println("Connected to pf");
	}
	public boolean saveObject(AadharDetails a) {
		// TODO Auto-generated method stub
		Transaction tran=session.beginTransaction();
		session.save(a);
		tran.commit();
		System.out.println("object saved");
		return true;
		 
	}

	


public boolean update(int id, String fstname) {
	
	Transaction transaction= session.beginTransaction();
	AadharDetails ad=(AadharDetails)session.get(AadharDetails.class,id);
	ad.setFirst_name(fstname);
	session.update(ad);
	System.out.println("Update Success");
	transaction.commit();
	return true;
	


}
	
	public boolean delete(int id) {
		Transaction transaction= session.beginTransaction();
		AadharDetails ad=(AadharDetails)session.get(AadharDetails.class,id);
		
		session.delete(ad);
		System.out.println("Delete Success");
		transaction.commit();
		return true;
		
		
	}
	
//	public void view(int id) {
//        session.beginTransaction();
//
// 
//
//        AadharDetails a = (AadharDetails) session.get(AadharDetails.class, id);
//
//        this.id = a.getId();
//        this.first_name = a.getFirst_name();
//        this.email = a.getEmail();
//        this.phone_number = a.getPhone_number();
//        this.address = a.getAddress();
//        this.last_name = a.getLast_name();
//        this.state = a.getState();
//        this.pin_code = a.getPin_code();
//        this.father_name = a.getFather_name();
//    }
	public AadharDetails readSpecific(int id) {

        Transaction tran=session.beginTransaction();

        AadharDetails ad=(AadharDetails) session.get(AadharDetails.class, id);

        return ad;

    }

	}
	
	
