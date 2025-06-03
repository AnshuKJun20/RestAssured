package Serialization;

public class addressPojo {
	private String street;
	private String suite;
	private String city;
	private String zipcode;
	private Geo geo;
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getSuite() {
		return suite;
	}
	public void setSuite(String suite) {
		this.suite = suite;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getzipcode() {
		return zipcode;
	}
	public void setzipcode(String zipCode) {
		this.zipcode = zipCode;
	}
	public Geo getGeo() {
		return geo;
	}
	public void setGeo(Geo geo) {
		this.geo = geo;
	}

}
