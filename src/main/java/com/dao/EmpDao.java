package com.dao;

import java.math.BigInteger;
import java.util.List;

import javax.sql.DataSource;

import com.vo.EmployeeVo;

public interface EmpDao {

	/**
	 * This is the method to be used to initialize database resources
	 */
	public void setDataSource(DataSource ds);

	/**
	 * This is the method to be used to create a record in the Employee table.
	 * @return 
	 */
	public int create(BigInteger id, String firstName, String lastName, String dept, String doj, String dNo,
			String line, String street, String city, String state, String country, BigInteger zipcode);

	/**
	 * This is the method to be used to list down a record from the Employee
	 * table corresponding to a passed Employee id.
	 */
	public EmployeeVo getEmployee(BigInteger id);

	/**
	 * This is the method to be used to list down all the records from the
	 * Employee table.
	 */
	public List<EmployeeVo> getEmployees();

	/**
	 * This is the method to be used to delete a record from the Employee table
	 * corresponding to a passed Employee id.
	 * @return 
	 */
	public int delete(Integer id);
	
	
	public int[] batchDelete(List<BigInteger> ids);
	/**
	 * This is the method to be used to update a record into the Employee table.
	 * @return 
	 */
	public int update(BigInteger id, String firstName, String lastName, String dept, String doj, String dNo,
			String line, String street, String city, String state, String country, BigInteger zipcode);

}
