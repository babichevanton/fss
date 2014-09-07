package springapp.fss.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import springapp.fss.pojo.Flight;

@Repository("flightDAO")
public class FlightDAO {

	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public List<Flight> getAll() {
        Session session = sessionFactory.getCurrentSession();

        List<Flight> result = session.createQuery("FROM Flight").list();

        return result;
	}
}

