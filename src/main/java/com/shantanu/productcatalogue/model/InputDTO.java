package com.shantanu.productcatalogue.model;

import java.util.List;

public class InputDTO {

	private List<Integer> rooms;
	private Integer senior;
	private Integer junior;
	
	public List<Integer> getRooms() {
		return rooms;
	}
	public void setRooms(List<Integer> rooms) {
		this.rooms = rooms;
	}
	public Integer getSenior() {
		return senior;
	}
	public void setSenior(Integer senior) {
		this.senior = senior;
	}
	public Integer getJunior() {
		return junior;
	}
	public void setJunior(Integer junior) {
		this.junior = junior;
	}
	@Override
	public String toString() {
		return "InputDTO [rooms=" + rooms + ", senior=" + senior + ", junior=" + junior + "]";
	}
	
}
