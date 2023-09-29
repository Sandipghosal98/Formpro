package com.org.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.org.Dto.Form;
//import com.org.dto.Employee;

public class FormDao {
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Sandip");
	public static boolean saveValue(Form f) {
		try {
			EntityManager em = emf.createEntityManager();
			EntityTransaction et = em.getTransaction();
			et.begin();
			em.persist(f);
			et.commit();
			return true;
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return false;
	}
	public static List<Form> getALLForms(){
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("SELECT f FROM Form f");
		return q.getResultList();
	}
	public static boolean updateForm(Form f) {
		try {
			EntityManager em = emf.createEntityManager();
			EntityTransaction et = em.getTransaction();
			et.begin();
			em.merge(f);
			et.commit();
			return true;
		}catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}
	public static boolean deleteForm(int id) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Form f = em.find(Form.class , id);
		if(f == null) {
			return false;
		}else {
			et.begin();
			em.remove(f);
			et.commit();
			return true;
		}
	}
	public static Form findById(int id) {
		EntityManager em = emf.createEntityManager();
		return em.find(Form.class, id);
}
}
	
