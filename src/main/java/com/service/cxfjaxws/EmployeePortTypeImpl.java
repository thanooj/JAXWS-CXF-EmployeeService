package com.service.cxfjaxws;

import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.cxfjaxws.DeptType;
import com.cxfjaxws.EmployeePortType;
import com.cxfjaxws.EmployeeRequest;
import com.cxfjaxws.EmployeeResponse;
import com.cxfjaxws.IndiaAddressType;
import com.cxfjaxws.ObjectFactory;

@Component
public class EmployeePortTypeImpl implements EmployeePortType {

	private final Logger logger = LoggerFactory.getLogger(EmployeePortTypeImpl.class);

	@Override
	public EmployeeResponse getEmployee(EmployeeRequest parameters) {
		ObjectFactory objectFactory = new ObjectFactory();
		logger.info("##################");
		logger.info("ID, " + parameters.getId());
		logger.info("##################");
		EmployeeResponse createEmployeeResponse = objectFactory.createEmployeeResponse();
		createEmployeeResponse.setFirstname("Sriram");
		createEmployeeResponse.setLastname("Ayodya");
		createEmployeeResponse.setId(parameters.getId());
		XMLGregorianCalendar date = null;
		try {
			GregorianCalendar gCalendar = new GregorianCalendar();
			gCalendar.setTime(new Date());
			date = DatatypeFactory.newInstance().newXMLGregorianCalendar(gCalendar);
		} catch (DatatypeConfigurationException e) {
			e.printStackTrace();
		}
		createEmployeeResponse.setDOJ(date);
		createEmployeeResponse.setDept(DeptType.DEV);
		IndiaAddressType createIndiaAddressType = objectFactory.createIndiaAddressType();
		createIndiaAddressType.setDNo("35");
		createIndiaAddressType.setLine("7th Main");
		createIndiaAddressType.setStreet("Tavarekere");
		createIndiaAddressType.setCity("Banalore");
		createEmployeeResponse.setAddr(createIndiaAddressType);
		return createEmployeeResponse;
	}

}
