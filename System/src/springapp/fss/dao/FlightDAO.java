package springapp.fss.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import springapp.fss.pojo.ParticularFlight;

@Repository("flightDAO")
public class FlightDAO {

	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public List<ParticularFlight> getAll() {
        Session session = sessionFactory.getCurrentSession();

        List<ParticularFlight> result = session.createCriteria(ParticularFlight.class).list();

        return result;
	}
}

