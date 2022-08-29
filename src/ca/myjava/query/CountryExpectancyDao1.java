package ca.myjava.query;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ca.myjava.model.CountryExpectancy;
import ca.myjava.util.DBHelper;

public class CountryExpectancyDao1 {
	
	DBHelper dbHelper = new DBHelper();
	public List<CountryExpectancy> findByRangeUsingPreStmt(String columnName,List<Object> params ){
		String sql= "select * from country_expectancy where "+columnName +" between ? and ?";
		ResultSet res= dbHelper.executeQueryByPreStmt(sql, params);
		return getList(res);
	}
	public List<CountryExpectancy> findByRangeUsingStmt(String columnName,List<Object> params ){
		String sql= "select * from country_expectancy where "+columnName+" between "+params.get(0).toString()+" and "+params.get(1).toString();
		ResultSet res= dbHelper.executeQueryByStmt(sql);
		System.out.println(sql);
		return getList(res);
	}
	
	public List<CountryExpectancy> findAll(){
		String sql= "select * from country_expectancy";
		ResultSet res= dbHelper.executeQueryByStmt(sql);
		return getList(res);
	}
	
	//extract common part
	public List<CountryExpectancy> getList(ResultSet res){
		List<CountryExpectancy> countryExpectancies = new ArrayList<CountryExpectancy>();
		try {
			while(res.next()) {
				CountryExpectancy countryExpectancy = new CountryExpectancy();
				countryExpectancy.setId(res.getInt("id"));
				countryExpectancy.setName(res.getString("name"));
				countryExpectancy.setBothSex(res.getDouble("both_sexes"));
				countryExpectancy.setFemale(res.getDouble("female"));
				countryExpectancy.setMale(res.getDouble("male"));
				countryExpectancies.add(countryExpectancy);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return countryExpectancies;
	}

}
