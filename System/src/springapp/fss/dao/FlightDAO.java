package springapp.fss.dao;

import java.util.List;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.text.ParseException;

import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import springapp.fss.form.SearchflightForm;
import springapp.fss.pojo.ParticularFlight;
import springapp.fss.pojo.Flight;

@Repository("flightDAO")
public class FlightDAO {

	private SessionFactory sessionFactory;

    private void addRestrictionIfNotNull(Criteria criteria, String propertyName, String value) {
        if (!value.equals("")) {
            criteria.add(Restrictions.eq(propertyName, value));
        }
    }

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public List<ParticularFlight> client_search(SearchflightForm form) {
        Session session = sessionFactory.getCurrentSession();

	    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        Criteria criteria = session
        	.createCriteria(ParticularFlight.class, "pt_flight")
        	.createAlias("pt_flight.Flight", "flight")
        	.createAlias("flight.Dptr_airport", "dptr_arp")
        	.createAlias("flight.Arr_airport", "arr_arp");

        addRestrictionIfNotNull(criteria, "dptr_arp.city", form.getDptr_town());
        addRestrictionIfNotNull(criteria, "arr_arp.city", form.getArr_town());

        try {
        	if (!form.getDptr_time().equals("")) {
	        	Calendar dptr_time = Calendar.getInstance();
	        	dptr_time.setTime(sdf.parse(form.getDptr_time()));
	        	criteria.add(Restrictions.ge("pt_flight.dptr", dptr_time));
        	}
        	if (!form.getArr_time().equals("")) {
	        	Calendar arr_time = Calendar.getInstance();
	        	arr_time.setTime(sdf.parse(form.getArr_time()));
	        	criteria.add(Restrictions.le("pt_flight.arr", arr_time));
        	}
        } catch(ParseException ex) {}

        List<ParticularFlight> result = (List<ParticularFlight>) criteria.list();

        return result;
	}

    public ParticularFlight getFlightById(int id) {
        Session session = sessionFactory.getCurrentSession();

        ParticularFlight result = (ParticularFlight) session
                .createCriteria(ParticularFlight.class)
                .add(Restrictions.eq("id", id))
                .uniqueResult();

        return result;
    }

	public List<ParticularFlight> getAll() {
        Session session = sessionFactory.getCurrentSession();

        List<ParticularFlight> result = session.createCriteria(ParticularFlight.class).list();

        return result;
	}

}