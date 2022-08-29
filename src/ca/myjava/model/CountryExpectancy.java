package ca.myjava.model;

public class CountryExpectancy {
	private int id;
	private String name;
	private double bothSex;
	private double male;
	private double female;
	
	public CountryExpectancy() {}

	public CountryExpectancy(Integer id, String name, double bothSex, double male, double female) {
		super();
		this.id=id;
		this.name = name;
		this.bothSex = bothSex;
		this.male = male;
		this.female = female;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getBothSex() {
		return bothSex;
	}

	public void setBothSex(double bothSex) {
		this.bothSex = bothSex;
	}

	public double getMale() {
		return male;
	}

	public void setMale(double male) {
		this.male = male;
	}

	public double getFemale() {
		return female;
	}

	public void setFemale(double female) {
		this.female = female;
	}
	
	public String insertSqlSegment() {
		return "'"+this.getName()+"',"+this.getBothSex()+","+this.getMale()+","+this.getFemale();
	}
	public String updateSqlSegment() {
		String sqlString = "set name="+"'"+this.getName()+"', both_sexes="+this.getBothSex()+", female="+this.getFemale()+", male="+this.getMale()+" where id= "+this.getId();
		return sqlString;
	}
}
