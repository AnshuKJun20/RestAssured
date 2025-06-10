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

		ad.setCity("Nagpur");
		ad.setStreet("3rd lane1");
		ad.setSuite("141");
		ad.setzipcode("108099");

		g.setLat("32.89");
		g.setLng("76.65");

		c.setBs("232");
		c.setCatchPhrase("Not bull");
		c.setName("Avskk");

		ad.setGeo(g);
		pj.setAddress(ad);
		pj.setEmail("a12k@gmail.com");
		pj.setId("2");
		pj.setName("Bideden");
		pj.setPhone("99988543890");
		pj.setWebsite("an23c@ac.in");
		pj.setUsername("kb123");
		return pj;
	}
}
