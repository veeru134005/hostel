package com.veera.back.test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.veera.back.daointer.DaoInter;
import com.veera.back.dto.Catagory;

public class JunitTest {

	private static AnnotationConfigApplicationContext context;
	private static DaoInter dao;
	private static Catagory cata;

	@BeforeClass
	public static void  beforeTest() {

		context = new AnnotationConfigApplicationContext();
		context.scan("com.veera.back");
		context.refresh();
		dao = context.getBean(DaoInter.class);

	}

	/*@Test
	public void addMethods() {
		cata = new Catagory();
		cata.setDescription("The item may not delete from the try");
		cata.setName("Laptop");
		cata.setImageUrl("hari.jpg");
		assertEquals("submited suceefully", true, dao.add(cata));

	}
*/
/*	@Test
	public void getingData(){
		
		cata=dao.get(3);
		
		assertEquals("success","Laptop",cata.getName());
		
	}*/
	
	@Test
	public void getalldetails(){
		
	List<Catagory> c=dao.list();
	
	assertEquals("success",c);
		
	}
	
	
}
