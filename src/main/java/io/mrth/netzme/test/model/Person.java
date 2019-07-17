package io.mrth.netzme.test.model;

import io.mrth.netzme.test.endpoint.NetzmePerson;

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

	public Person(NetzmePerson netzmePerson) {
		this.fullName = netzmePerson.getName().getTitle() + " " + netzmePerson.getName().getFirst() + " " + netzmePerson.getName().getLast();
		this.gender = netzmePerson.getGender();
		this.address = netzmePerson.getLocation().getStreet() + " " + netzmePerson.getLocation().getCity();
		this.picture = netzmePerson.getPicture().getLarge();
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
