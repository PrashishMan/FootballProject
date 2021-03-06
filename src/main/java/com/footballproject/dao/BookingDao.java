package com.footballproject.dao;

import java.util.List;

import com.footballproject.model.Booking;
import com.footballproject.model.Branch;
import com.footballproject.model.Team;

public interface BookingDao {
	public void addBooking(Booking booking);
	public Booking getBooking(int bookingId);
	public List<Booking> getBooking();
	public int getBookingCount();
	public int getBookedCount();
	public List<Booking> getBranchBooked(Branch branchId);
	public List<Booking> getTeamBooked(Team teamName);
	public boolean isPitchBooked(Booking booking);
	public void removeBooking(Booking bookingId);
	public List<Booking> monthlyBookingRecord(int month);
}
