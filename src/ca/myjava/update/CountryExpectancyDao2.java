package ca.myjava.update;

import java.util.ArrayList;
import java.util.List;

import ca.myjava.model.CountryExpectancy;
import ca.myjava.util.DBHelper;

public class CountryExpectancyDao2 {
	DBHelper dbHelper = new DBHelper();
	public int addCountryExpectancyUsingPreStmt(CountryExpectancy countryExpectancy) {
		String sql = "insert into country_expectancy (name,both_sexes,male,female)values(?,?,?,?)";
		List<Object> params = new ArrayList<Object>();
		params.add(countryExpectancy.getName());
		params.add(countryExpectancy.getBothSex());
		params.add(countryExpectancy.getMale());
		params.add(countryExpectancy.getFemale());
		System.out.println(sql);
		return dbHelper.executeOperateByPreStmt(sql, params);
	}	
	
	public int addCountryExpectancyUsingStmt(CountryExpectancy countryExpectancy) {
		String sql = "insert into country_expectancy (name,both_sexes,male,female)values("+countryExpectancy.insertSqlSegment()+")";
		System.out.println(sql);
		return dbHelper.executeOperateByStmt(sql);
	}
	public int updateCountryExpectancyUsingPreStmt(CountryExpectancy countryExpectancy) {
		String sql = "update country_expectancy set name=?,both_sexes=?,male=?,female=? where id=?";
		System.out.println(sql);
		List<Object> params = new ArrayList<Object>();
		params.add(countryExpectancy.getName());
		params.add(countryExpectancy.getBothSex());
		params.add(countryExpectancy.getMale());
		params.add(countryExpectancy.getFemale());
		params.add(countryExpectancy.getId());
		System.out.println(sql);
		return dbHelper.executeOperateByPreStmt(sql, params);
	}	
	public int updateCountryExpectancyUsingStmt(CountryExpectancy countryExpectancy) {
		String sql = "update country_expectancy " +countryExpectancy.updateSqlSegment();
		System.out.println(sql);
		return dbHelper.executeOperateByStmt(sql);
	}
	public int deleteCountryExpectancyUsingPreStmt(int id) {
		String sql = "delete from country_expectancy where id=?";
		System.out.println(sql);
		List<Object> params = new ArrayList<Object>();
		params.add(id);
		return dbHelper.executeOperateByPreStmt(sql, params);
	}
	public int deleteCountryExpectancyUsingStmt(int id) {
		String sql = "delete from country_expectancy where id="+id;
		return dbHelper.executeOperateByStmt(sql);
	}
	
}


		
	