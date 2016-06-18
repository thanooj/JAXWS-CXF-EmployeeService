package com.dao;

import java.math.BigInteger;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mapper.EmpVoMapper;
import com.vo.EmployeeVo;

@Repository
public class EmpDaoImpl implements EmpDao {

	private final Logger logger = LoggerFactory.getLogger(EmpDaoImpl.class);

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	@Override
	public void setDataSource(DataSource ds) {
		this.dataSource = ds;
		this.jdbcTemplate = new JdbcTemplate(dataSource);

	}

	/**
	 * id; firstName; lastName; dept; doj; dNo; line; street; city; state;
	 * country; zipcode;
	 * 
	 */
	@Override
	public int create(BigInteger id, String firstName, String lastName, String dept, String doj, String dNo,
			String line, String street, String city, String state, String country, BigInteger zipcode) {
		String SQL = "insert into thanooj.employee (id, firstName, lastName, dept, doj, dNo, line, street, city, state, country, zipcode) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		return jdbcTemplate.update(SQL, id, firstName, lastName, dept, doj, dNo, line, street, city, state, country,
				zipcode);
	}

	@Override
	public EmployeeVo getEmployee(BigInteger id) {
		String SQL = "select * from thanooj.employee where id = ?";
		EmployeeVo employee = jdbcTemplate.queryForObject(SQL, new Object[] { id }, new EmpVoMapper());
		return employee;
	}

	@Override
	public List<EmployeeVo> getEmployees() {
		String SQL = "select * from thanooj.employee";
		List<EmployeeVo> employees = jdbcTemplate.query(SQL, new EmpVoMapper());
		return employees;
	}

	@Override
	public int update(BigInteger id, String firstName, String lastName, String dept, String doj, String dNo,
			String line, String street, String city, String state, String country, BigInteger zipcode) {
		String SQLselect = "select * from thanooj.employee where id = ?";
		EmployeeVo employee = jdbcTemplate.queryForObject(SQLselect, new Object[] { id }, new EmpVoMapper());
		if (employee != null && employee.getId() != null && employee.getId().intValue() > 0) {
			String SQL = "update thanooj.employee set firstName = ?, lastName = ?, dept = ?, doj = ?, dNo = ?, line = ?, street = ?, city = ?, state = ?, country = ?, zipcode = ? where id = ?";
			return jdbcTemplate.update(SQL, firstName, lastName, dept, doj, dNo, line, street, city, state, country,
					zipcode, id);
		} else {
			return 0;
		}
	}

	@Override
	public int delete(Integer id) {
		String SQLselect = "select * from thanooj.employee where id = ?";
		EmployeeVo employee = jdbcTemplate.queryForObject(SQLselect, new Object[] { id }, new EmpVoMapper());
		if (employee != null && employee.getId() != null && employee.getId().intValue() > 0) {
			String SQL = "delete from thanooj.employee where id = ?";
			return jdbcTemplate.update(SQL, id);
		} else {
			return 0;
		}
	}

	@Override
	public int[] batchDelete(final List<BigInteger> ids) {
		logger.info("########################### batchDelete starts");
		String SQL = "delete from thanooj.employee where id = ?";
		return jdbcTemplate.batchUpdate(SQL, new BatchPreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				logger.info("########################### batchDelete : " + i + " | " + ids.get(i).intValue());
				ps.setInt(1, ids.get(i).intValue());
			}

			@Override
			public int getBatchSize() {
				logger.info("########################### getBatchSize : " + ids.size());
				return ids.size();
			}
		});
	}

}
