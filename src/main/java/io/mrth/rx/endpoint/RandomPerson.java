package io.mrth.rx.endpoint;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Objects;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class RandomPerson {
	private String gender;
	private String email;
	private Name name;
	private Location location;
	private Picture picture;

	public RandomPerson() {
	}

	public RandomPerson(String gender, String email, Name name, Location location, Picture picture) {
		this.gender = gender;
		this.email = email;
		this.name = name;
		this.location = location;
		this.picture = picture;
	}

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

	public static class Name {
		private String title;
		private String first;
		private String last;

		public Name() {
		}

		public Name(String title, String first, String last) {
			this.title = title;
			this.first = first;
			this.last = last;
		}

		public String getTitle() {
			return title;
		}

		public String getFirst() {
			return first;
		}

		public String getLast() {
			return last;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;
			Name name = (Name) o;
			return Objects.equals(title, name.title) &&
					Objects.equals(first, name.first) &&
					Objects.equals(last, name.last);
		}

		@Override
		public int hashCode() {
			return Objects.hash(title, first, last);
		}
	}

	public static class Location {
		private Street street;
		private String city;
		private String postcode;
		private String state;
		private String country;

		public Location() {
		}

		public Location(Street street, String city, String postcode, String state) {
			this.street = street;
			this.city = city;
			this.postcode = postcode;
			this.state = state;
		}

		public Street getStreet() {
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

		public String getCountry() {
			return country;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;
			Location location = (Location) o;
			return Objects.equals(street, location.street) &&
					Objects.equals(city, location.city) &&
					Objects.equals(postcode, location.postcode) &&
					Objects.equals(state, location.state);
		}

		@Override
		public int hashCode() {
			return Objects.hash(street, city, postcode, state);
		}

		public static class Street {
			private int number;
			private String name;

			public Street() {
			}

			public Street(int number, String name) {
				this.number = number;
				this.name = name;
			}

			public int getNumber() {
				return number;
			}

			public String getName() {
				return name;
			}

			@Override
			public boolean equals(Object o) {
				if (this == o) return true;
				if (o == null || getClass() != o.getClass()) return false;
				Street street = (Street) o;
				return number == street.number &&
						Objects.equals(name, street.name);
			}

			@Override
			public int hashCode() {
				return Objects.hash(number, name);
			}
		}
	}

	public static class Picture {
		private String large;

		public Picture() {
		}

		public Picture(String large) {
			this.large = large;
		}

		public String getLarge() {
			return large;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;
			Picture picture = (Picture) o;
			return Objects.equals(large, picture.large);
		}

		@Override
		public int hashCode() {
			return Objects.hash(large);
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		RandomPerson that = (RandomPerson) o;
		return Objects.equals(gender, that.gender) &&
				Objects.equals(email, that.email) &&
				Objects.equals(name, that.name) &&
				Objects.equals(location, that.location) &&
				Objects.equals(picture, that.picture);
	}

	@Override
	public int hashCode() {
		return Objects.hash(gender, email, name, location, picture);
	}
}
