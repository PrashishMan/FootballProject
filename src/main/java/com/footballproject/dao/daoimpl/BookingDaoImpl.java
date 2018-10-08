package com.footballproject.dao.daoimpl;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.footballproject.dao.BookingDao;
import com.footballproject.model.Booking;
import com.footballproject.model.Branch;
import com.footballproject.model.Team;

@Repository("bookingDao")
public class BookingDaoImpl implements BookingDao {

	@Autowired
	SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void addBooking(Booking booking) {
		getSession().saveOrUpdate(booking);
	}

	@Override
	public Booking getBooking(int bookingId) {
		return (Booking) getSession().get(Booking.class, bookingId);
	}
	
	@Override
	public void removeBooking(Booking bookingId) {
		String deleteQuery = "DELETE FROM Booking WHERE bookingId = ?";
		Query query = getSession().createQuery(deleteQuery);
		query.setParameter(0, bookingId.bookingId);
		query.executeUpdate();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Booking> getBooking() {
		return (List<Booking>) getSession().createCriteria(Booking.class).list();
	}

	@Override
	public int getBookingCount() {
		Query query = getSession().createQuery("SELECT count(*) FROM Booking DAY ( date ) >= DAY ( SYSDATE() ) ");
		int count = 0;
		if (query.uniqueResult() != null) {
			count = ((Long) query.uniqueResult()).intValue();
		}
		return count;
	}
	
	@Override
	public List<Booking> monthlyBookingRecord(int month) {
		Date date = new Date();
		Query query = getSession().createQuery("FROM Booking WHERE MONTH ( date ) = ? AND YEAR ( date ) = ?");
		query.setParameter(0, date.getMonth());
		query.setParameter(1, date.getYear());
		@SuppressWarnings("unchecked")
		List<Booking> bookingList = (List<Booking>)query.list();
		return bookingList;
	}
	

	@Override
	public int getBookedCount() {
		Query query = getSession().createQuery("SELECT count(*) FROM Booking WHERE DAY ( date ) < DAY ( SYSDATE() ) ");
		int count = 0;
		if (query.uniqueResult() != null) {
			count = ((Long) query.uniqueResult()).intValue();
		}
		return count;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Booking> getBranchBooked(Branch branchId) {
		Query query = getSession().createQuery("FROM Booking WHERE branchId = ? AND date > ?");
		query.setParameter(0, branchId);
		query.setParameter(1, new Date());
		if (query.list() != null) {
			return (List<Booking>) query.list();
		}
		return null;

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Booking> getTeamBooked(Team teamName) {
		Query query = getSession().createQuery("FROM Booking WHERE teamName = ? AND date > ?");
		query.setParameter(0, teamName);
		query.setParameter(1, new Date());
		if (query.list() != null) {
			return (List<Booking>) query.list();
		}
		return null;

	}

	@Override
	public boolean isPitchBooked(Booking booking) {
		Query query = getSession().createQuery("FROM Booking WHERE pitchNo = ? AND branchId = ? AND bookingTime = ? AND date = ? ");
		query.setParameter(0, booking.pitchNo);
		query.setParameter(1, booking.branchId);
		query.setParameter(2, booking.bookingTime);
		query.setParameter(3, booking.date);
		List list = query.list();
		if (!list.isEmpty() || list.size() != 0 ) {
			return true;
		} else {
			return false;
		}
	}

}
