package com.mapper;

import java.math.BigInteger;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.vo.EmployeeVo;

@Component
public class EmpVoMapper implements RowMapper<EmployeeVo> {

	public EmployeeVo mapRow(ResultSet rs, int rowNum) throws SQLException {
		EmployeeVo employee = new EmployeeVo(new BigInteger(String.valueOf(rs.getInt("id"))), rs.getString("firstName"),
				rs.getString("lastName"), rs.getString("dept"), rs.getString("doj"), rs.getString("dNo"),
				rs.getString("line"), rs.getString("street"), rs.getString("city"), rs.getString("state"),
				rs.getString("country"), new BigInteger(String.valueOf(rs.getInt("zipcode"))));
		return employee;
	}

}
