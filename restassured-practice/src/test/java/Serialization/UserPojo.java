package Serialization;

public class UserPojo {
	private String id;
	private String name;
	private addressPojo address;
	private String email;
	private CompanyPojo company;
	private String username;
	private String phone;
	private String website;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public addressPojo getAddress() {
		return address;
	}
	public void setAddress(addressPojo address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public CompanyPojo getCompany() {
		return company;
	}
	public void setCompany(CompanyPojo company) {
		this.company = company;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
}
	