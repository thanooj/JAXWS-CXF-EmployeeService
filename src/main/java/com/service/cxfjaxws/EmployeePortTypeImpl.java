package com.service.cxfjaxws;

import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cxfjaxws.CreateEmployeeRequestType;
import com.cxfjaxws.CreateEmployeeResponseType;
import com.cxfjaxws.CreateEmployeesRequestType;
import com.cxfjaxws.CreateEmployeesResponseType;
import com.cxfjaxws.DeleteEmployeeRequestType;
import com.cxfjaxws.DeleteEmployeeResponseType;
import com.cxfjaxws.DeleteEmployeesRequestType;
import com.cxfjaxws.DeleteEmployeesResponseType;
import com.cxfjaxws.DeptType;
import com.cxfjaxws.EmployeePortType;
import com.cxfjaxws.EmployeeType;
import com.cxfjaxws.GetEmployeeListResponseType;
import com.cxfjaxws.GetEmployeeRequestType;
import com.cxfjaxws.GetEmployeeResponseType;
import com.cxfjaxws.IndiaAddressType;
import com.cxfjaxws.NoArgType;
import com.cxfjaxws.ObjectFactory;
import com.cxfjaxws.UpdateEmployeeRequestType;
import com.cxfjaxws.UpdateEmployeeResponseType;
import com.dao.EmpDaoImpl;
import com.vo.EmployeeVo;

@Component
public class EmployeePortTypeImpl implements EmployeePortType {

	private final Logger logger = LoggerFactory.getLogger(EmployeePortTypeImpl.class);

	ObjectFactory objectFactory = new ObjectFactory();

	@Autowired
	private EmpDaoImpl empDaoImpl;

	public EmpDaoImpl getEmpDaoImpl() {
		return empDaoImpl;
	}

	public void setEmpDaoImpl(EmpDaoImpl empDaoImpl) {
		this.empDaoImpl = empDaoImpl;
	}

	@Override
	public GetEmployeeResponseType getEmployee(GetEmployeeRequestType parameters) {

		EmployeeVo employee = empDaoImpl.getEmployee(new BigInteger(parameters.getId().toString()));

		logger.info("##################");
		logger.info("ID, " + parameters.getId());
		logger.info("##################");
		EmployeeType emp = objectFactory.createEmployeeType();
		GetEmployeeResponseType employeeResponse = objectFactory.createGetEmployeeResponseType();

		/*
		 * employeeResponse.setFirstname("Sriram");
		 * employeeResponse.setLastname("Ayodya");
		 * employeeResponse.setId(parameters.getId()); XMLGregorianCalendar date
		 * = null; try { GregorianCalendar gCalendar = new GregorianCalendar();
		 * gCalendar.setTime(new Date()); date =
		 * DatatypeFactory.newInstance().newXMLGregorianCalendar(gCalendar); }
		 * catch (DatatypeConfigurationException e) { e.printStackTrace(); }
		 * employeeResponse.setDOJ(date);
		 * employeeResponse.setDept(DeptType.DEV); IndiaAddressType addressType
		 * = objectFactory.createIndiaAddressType(); addressType.setDNo("35");
		 * addressType.setLine("7th Main"); addressType.setStreet("Tavarekere");
		 * addressType.setCity("Banalore"); addressType.setState("Karnataka");
		 * addressType.setCountry("India");
		 * addressType.setZipcode(BigInteger.valueOf(560029));
		 * employeeResponse.setAddr(addressType);
		 */

		/*
		 * employee.getId() employee.getFirstName() employee.getLastName()
		 * employee.getDept() employee.getDoj() employee.getdNo()
		 * employee.getLine() employee.getStreet() employee.getCity()
		 * employee.getState() employee.getCountry() employee.getZipcode()
		 */
		emp.setId(employee.getId());
		emp.setFirstname(employee.getFirstName());
		emp.setLastname(employee.getLastName());
		XMLGregorianCalendar date = null;
		SimpleDateFormat formatter = new SimpleDateFormat("dd-mm-yyyy");
		try {
			Date d = formatter.parse(employee.getDoj());
			GregorianCalendar gCalendar = new GregorianCalendar();
			gCalendar.setTime(d);
			date = DatatypeFactory.newInstance().newXMLGregorianCalendar(gCalendar);
		} catch (DatatypeConfigurationException | ParseException e) {
			e.printStackTrace();
		}
		emp.setDOJ(date);
		emp.setDept(employee.getDept().equals(DeptType.DEV) ? DeptType.DEV
				: employee.getDept().equals(DeptType.PROD) ? DeptType.PROD
						: employee.getDept().equals(DeptType.TEST) ? DeptType.TEST : DeptType.DEV);
		IndiaAddressType addressType = objectFactory.createIndiaAddressType();
		addressType.setDNo(employee.getDoj());
		addressType.setLine(employee.getdNo());
		addressType.setStreet(employee.getLine());
		addressType.setCity(employee.getCity());
		addressType.setState(employee.getState());
		addressType.setCountry(employee.getCountry());
		addressType.setZipcode(employee.getZipcode());
		emp.setAddr(addressType);
		employeeResponse.setEmployee(emp);
		return employeeResponse;
	}

	@Override
	public GetEmployeeListResponseType getEmployees(NoArgType parameters) {

		List<EmployeeVo> employees = getEmpDaoImpl().getEmployees();

		GetEmployeeListResponseType employeeListResponse = objectFactory.createGetEmployeeListResponseType();
		for (EmployeeVo employee : employees) {
			EmployeeType emp = objectFactory.createEmployeeType();
			emp.setId(employee.getId());
			emp.setFirstname(employee.getFirstName());
			emp.setLastname(employee.getLastName());
			XMLGregorianCalendar date = null;
			SimpleDateFormat formatter = new SimpleDateFormat("dd-mm-yyyy");
			try {
				Date d = formatter.parse(employee.getDoj());
				GregorianCalendar gCalendar = new GregorianCalendar();
				gCalendar.setTime(d);
				date = DatatypeFactory.newInstance().newXMLGregorianCalendar(gCalendar);
			} catch (DatatypeConfigurationException | ParseException e) {
				e.printStackTrace();
			}
			emp.setDOJ(date);
			emp.setDept(employee.getDept().equals(DeptType.DEV) ? DeptType.DEV
					: employee.getDept().equals(DeptType.PROD) ? DeptType.PROD
							: employee.getDept().equals(DeptType.TEST) ? DeptType.TEST : DeptType.DEV);
			IndiaAddressType addressType = objectFactory.createIndiaAddressType();
			addressType.setDNo(employee.getDoj());
			addressType.setLine(employee.getdNo());
			addressType.setStreet(employee.getLine());
			addressType.setCity(employee.getCity());
			addressType.setState(employee.getState());
			addressType.setCountry(employee.getCountry());
			addressType.setZipcode(employee.getZipcode());
			emp.setAddr(addressType);
			employeeListResponse.getEmployee().add(emp);
		}
		return employeeListResponse;
	}

	@Override
	public CreateEmployeeResponseType createEmployee(CreateEmployeeRequestType cERT) {
		CreateEmployeeResponseType createEmployeeResponseType = objectFactory.createCreateEmployeeResponseType();
		EmployeeType e = cERT.getEmployee();
		IndiaAddressType addr = e.getAddr();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-mm-yyyy");
		String dOJ = formatter.format(e.getDOJ().toGregorianCalendar().getTime());
		int create = empDaoImpl.create(e.getId(), e.getFirstname(), e.getLastname(), e.getDept().value(), dOJ,
				addr.getDNo(), addr.getLine(), addr.getStreet(), addr.getCity(), addr.getState(), addr.getCountry(),
				addr.getZipcode());
		createEmployeeResponseType.setNoOfRowsEffected(new BigInteger(String.valueOf(create)));
		return createEmployeeResponseType;
	}

	@Override
	public UpdateEmployeeResponseType updateEmployee(UpdateEmployeeRequestType uERT) {
		UpdateEmployeeResponseType UpdateEmployeeResponseType = objectFactory.createUpdateEmployeeResponseType();
		EmployeeType e = uERT.getEmployee();
		IndiaAddressType addr = e.getAddr();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-mm-yyyy");
		String dOJ = formatter.format(e.getDOJ().toGregorianCalendar().getTime());
		int update = empDaoImpl.update(e.getId(), e.getFirstname(), e.getLastname(), e.getDept().value(), dOJ,
				addr.getDNo(), addr.getLine(), addr.getStreet(), addr.getCity(), addr.getState(), addr.getCountry(),
				addr.getZipcode());
		UpdateEmployeeResponseType.setNoOfRowsEffected(new BigInteger(String.valueOf(update)));
		return UpdateEmployeeResponseType;
	}

	@Override
	public DeleteEmployeeResponseType deleteEmployee(DeleteEmployeeRequestType dERT) {
		int delete = empDaoImpl.delete(dERT.getId().intValue());
		DeleteEmployeeResponseType deleteEmployeeResponseType = objectFactory.createDeleteEmployeeResponseType();
		deleteEmployeeResponseType.setNoOfRowsEffected(new BigInteger(String.valueOf(delete)));
		return deleteEmployeeResponseType;
	}

	@Override
	public CreateEmployeesResponseType createEmployees(CreateEmployeesRequestType cERT) {
		CreateEmployeesResponseType createEmployeesResponseType = objectFactory.createCreateEmployeesResponseType();
		List<EmployeeType> emp = cERT.getEmployee();
		int create = 0;
		for (EmployeeType e : emp) {
			IndiaAddressType addr = e.getAddr();
			SimpleDateFormat formatter = new SimpleDateFormat("dd-mm-yyyy");
			String dOJ = formatter.format(e.getDOJ().toGregorianCalendar().getTime());
			int createStmt = empDaoImpl.create(e.getId(), e.getFirstname(), e.getLastname(), e.getDept().value(), dOJ,
					addr.getDNo(), addr.getLine(), addr.getStreet(), addr.getCity(), addr.getState(), addr.getCountry(),
					addr.getZipcode());
			create = create + createStmt;
			logger.info("createEmployees --- " + create);
		}
		createEmployeesResponseType.setNoOfRowsEffected(new BigInteger(String.valueOf(create)));
		logger.info("createEmployeesResponseType.getNoOfRowsEffected() :: "
				+ createEmployeesResponseType.getNoOfRowsEffected());
		return createEmployeesResponseType;
	}

	@Override
	public DeleteEmployeesResponseType deleteEmployees(DeleteEmployeesRequestType dERT) {
		int[] delete = empDaoImpl.batchDelete(dERT.getId());
		int noOfRowsEffected = 0;
		DeleteEmployeesResponseType deleteEmployeesResponseType = objectFactory.createDeleteEmployeesResponseType();
		for (int i = 0; i < delete.length; i++) {
			noOfRowsEffected++;
		}
		deleteEmployeesResponseType.setNoOfRowsEffected(new BigInteger(String.valueOf(noOfRowsEffected)));
		return deleteEmployeesResponseType;
	}

}
