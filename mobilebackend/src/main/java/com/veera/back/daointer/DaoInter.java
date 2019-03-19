package com.veera.back.daointer;

import java.util.List;

import com.veera.back.dto.Catagory;

public interface DaoInter {

	boolean add(Catagory category);

	List<Catagory> list();

	Catagory get(int id);

	boolean update(Catagory category);

	boolean delete(Catagory category);
}
