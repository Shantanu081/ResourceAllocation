package com.shantanu.productcatalogue.model;

public class OutputDTO {

	private Integer senior;
	private Integer junior;
	
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
		return "OutputDTO [senior=" + senior + ", junior=" + junior + "]";
	}
}
