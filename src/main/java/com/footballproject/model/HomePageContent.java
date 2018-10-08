package com.footballproject.model;

public class HomePageContent {
	public int memberCount;
	public int teamCount;
	public int branchCount;
	public int departmentCount;
	public int bookingCount;
	public int bookedCount;
	public int staffCount;
	public int juniorSubs;
	public int seniorSubs;
	
	
	
	
	public HomePageContent(int memberCount, int teamCount, int branchCount, int departmentCount, int bookingCount,
			int bookedCount, int staffCount, int juniorSubs, int seniorSubs) {
		super();
		this.memberCount = memberCount;
		this.teamCount = teamCount;
		this.branchCount = branchCount;
		this.departmentCount = departmentCount;
		this.bookingCount = bookingCount;
		this.bookedCount = bookedCount;
		this.staffCount = staffCount;
		this.juniorSubs = juniorSubs;
		this.seniorSubs = seniorSubs;
	}
	
	public HomePageContent() {}
	
	
	public int getMemberCount() {
		return memberCount;
	}
	public void setMemberCount(int memberCount) {
		this.memberCount = memberCount;
	}
	public int getTeamCount() {
		return teamCount;
	}
	public void setTeamCount(int teamCount) {
		this.teamCount = teamCount;
	}
	public int getBranchCount() {
		return branchCount;
	}
	public void setBranchCount(int branchCount) {
		this.branchCount = branchCount;
	}
	public int getDepartmentCount() {
		return departmentCount;
	}
	public void setDepartmentCount(int departmentCount) {
		this.departmentCount = departmentCount;
	}
	public int getBookingCount() {
		return bookingCount;
	}
	public void setBookingCount(int bookingCount) {
		this.bookingCount = bookingCount;
	}
	public int getBookedCount() {
		return bookedCount;
	}
	public void setBookedCount(int bookedCount) {
		this.bookedCount = bookedCount;
	}
	public int getStaffCount() {
		return staffCount;
	}
	public void setStaffCount(int staffCount) {
		this.staffCount = staffCount;
	}
	public int getJuniorSubs() {
		return juniorSubs;
	}
	public void setJuniorSubs(int juniorSubs) {
		this.juniorSubs = juniorSubs;
	}
	public int getSeniorSubs() {
		return seniorSubs;
	}
	public void setSeniorSubs(int seniorSubs) {
		this.seniorSubs = seniorSubs;
	}
	
	
	
}
