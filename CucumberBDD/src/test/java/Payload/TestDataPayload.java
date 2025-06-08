package Payload;

import pojo.CompanyPojo;
import pojo.Geo;
import pojo.UserPojo;
import pojo.addressPojo;

public class TestDataPayload {
	
	public UserPojo addEmployeePayload() {
		UserPojo pj = new UserPojo();
		addressPojo ad = new addressPojo();
		Geo g = new Geo();
		CompanyPojo c = new CompanyPojo();

		ad.setCity("Pune");
		ad.setStreet("3rd lane1");
		ad.setSuite("101");
		ad.setzipcode("109099");

		g.setLat("32.89");
		g.setLng("76.65");

		c.setBs("12");
		c.setCatchPhrase("Not bull");
		c.setName("Adsk");

		ad.setGeo(g);
		pj.setAddress(ad);
		pj.setEmail("ak@gmail.com");
		pj.setId("2");
		pj.setName("Eden");
		pj.setPhone("9938543890");
		pj.setWebsite("anc@ac.in");
		pj.setUsername("kk123");
		return pj;
	}
}
