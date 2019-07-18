package io.mrth.netzme.test.model;

import io.mrth.netzme.test.endpoint.RandomPerson;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Person {
	private String fullName;
	private String gender;
	private String address;
	private String picture;

	public Person() {
	}

	public Person(RandomPerson randomPerson) {
		this.fullName = randomPerson.getName().getTitle() + " " + randomPerson.getName().getFirst() + " " + randomPerson.getName().getLast();
		this.gender = randomPerson.getGender();
		this.address = randomPerson.getLocation().getStreet() + " " + randomPerson.getLocation().getCity();
		this.picture = randomPerson.getPicture().getLarge();
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}
}
