package com.brs.userservicemanagement.dao;

import org.bouncycastle.jcajce.provider.asymmetric.dsa.DSASigner.stdDSA;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.brs.userservicemanagement.entity.PassengerProfile;


@Repository
public class PassengerProfileDAOImpl 
implements PassengerProfileDAO{
	@Autowired
private SessionFactory sessionFactory;
	@Override
	public Long registerPassengerProfile(PassengerProfile passengerProfile) {
	Long userId=null;
	Session session=null;
	Transaction transaction=null;
	try{
	session=sessionFactory.openSession();
	if(session!=null){
		transaction=session.beginTransaction();
	userId=(Long)session.save(passengerProfile);
	if(transaction!=null && userId!=null){
		transaction.commit();
	}
	}
	}catch(HibernateException he){
		if(transaction!=null){
			transaction.rollback();
		}
	throw he;	
	}finally{
		if(session!=null){
			session.close();
		}
	}
		return userId;
	}

}
