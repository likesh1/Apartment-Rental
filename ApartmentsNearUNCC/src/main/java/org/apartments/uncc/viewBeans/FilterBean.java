package org.apartments.uncc.viewBeans;

import java.util.ArrayList;
import java.util.List;

public class FilterBean {

	private List<String> rentFilter;
	private List<Integer> roomFilter;
	private List<String> bathFilter;
	private List<String> floorFilter;
	
	
	public List<String> getRentFilter() {
		return rentFilter;
	}
	public void setRentFilter(List<String> rentFilter) {
		this.rentFilter = rentFilter;
	}
	public List<Integer> getRoomFilter() {
		return roomFilter;
	}
	public void setRoomFilter(List<Integer> roomFilter) {
		this.roomFilter = roomFilter;
	}
	public List<String> getBathFilter() {
		return bathFilter;
	}
	public void setBathFilter(List<String> bathFilter) {
		this.bathFilter = bathFilter;
	}
	public List<String> getFloorFilter() {
		return floorFilter;
	}
	public void setFloorFilter(List<String> floorFilter) {
		this.floorFilter = floorFilter;
	}
	
	public void addRoomFilter(List<String> filter) {
		
	}
		
}