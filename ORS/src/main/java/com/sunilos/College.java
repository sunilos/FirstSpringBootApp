package com.sunilos;

public class College {

	private long id = 0;
	private String name = null;
	private String address = null;

	public College() {
	}

	public College(long id, String name, String address) {
		this.id = id;
		this.name = name;
		this.address = address;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
