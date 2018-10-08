package com.footballproject.services.servicesimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.footballproject.dao.BookingDao;
import com.footballproject.model.Booking;
import com.footballproject.model.Branch;
import com.footballproject.model.Team;
import com.footballproject.services.BookingService;

@Service("bookingService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true )
public class BookingServiceImpl implements BookingService{
	
	@Autowired
	BookingDao bookingDao;

	@Override
	@Transactional(readOnly = false)
	public void addBooking(Booking booking) {
		bookingDao.addBooking(booking);
	}

	@Override
	public Booking getBooking(int bookingId) {
		// TODO Auto-generated method stub
		return bookingDao.getBooking(bookingId);
	}

	@Override
	public List<Booking> getBooking() {
		return bookingDao.getBooking();
	}

	@Override
	public int getBookingCount() {
		return bookingDao.getBookingCount();
	}

	@Override
	public int getBookedCount() {
		return bookingDao.getBookedCount();
	}

	@Override
	public List<Booking> getBranchBooked(Branch branchId) {
		return bookingDao.getBranchBooked(branchId);
	}

	@Override
	public List<Booking> getTeamBooked(Team teamName) {
		return bookingDao.getTeamBooked(teamName);
	}

	@Override
	public boolean isPitchBooked(Booking booking) {
		return bookingDao.isPitchBooked(booking);
	}

	@Override
	public void removeBooking(Booking bookingId) {
		bookingDao.removeBooking(bookingId);		
	}

	@Override
	public List<Booking> monthlyBookingRecord(int month) {
		return bookingDao.monthlyBookingRecord(month);
	}

}
