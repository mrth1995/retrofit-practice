package io.mrth.netzme.test.endpoint;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class NetzmePerson {
	private String gender;
	private String email;
	private Name name;
	private Location location;
	private Picture picture;

	public String getGender() {
		return gender;
	}

	public String getEmail() {
		return email;
	}

	public Name getName() {
		return name;
	}

	public Location getLocation() {
		return location;
	}

	public Picture getPicture() {
		return picture;
	}

	public class Name {
		private String title;
		private String first;
		private String last;

		public String getTitle() {
			return title;
		}

		public String getFirst() {
			return first;
		}

		public String getLast() {
			return last;
		}
	}

	public class Location {
		private String street;
		private String city;
		private String postcode;
		private String state;

		public String getStreet() {
			return street;
		}

		public String getCity() {
			return city;
		}

		public String getPostcode() {
			return postcode;
		}

		public String getState() {
			return state;
		}
	}

	public class Picture {
		private String large;

		public String getLarge() {
			return large;
		}
	}
}
