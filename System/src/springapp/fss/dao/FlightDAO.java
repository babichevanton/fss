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

    private void addRestrictionIfNotNull(Criteria criteria, String propertyName, Object value, int type) {
        if (value != null) {
            switch (type) {
                case 0:
                    criteria.add(Restrictions.eq(propertyName, value));
                    break;
                case 1:
                    criteria.add(Restrictions.le(propertyName, value));
                    break;
                case 2:
                    criteria.add(Restrictions.ge(propertyName, value));
                    break;
                default:
                    break;
            }
        }
    }

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public List<ParticularFlight> client_search(SearchflightForm form) {
        Session session = sessionFactory.getCurrentSession();

	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

        Criteria criteria = session
        	.createCriteria(ParticularFlight.class, "pt_flight")
        	.createAlias("pt_flight.Flight", "flight")
        	.createAlias("flight.Dptr_airport", "dptr_arp")
        	.createAlias("flight.Arr_airport", "arr_arp");

        addRestrictionIfNotNull(criteria, "dptr_arp.city", form.getDptr_town(), 0);
        addRestrictionIfNotNull(criteria, "arr_arp.city", form.getArr_town(), 0);
        //*
        try {
        	Calendar dptr_time = Calendar.getInstance();
        	Calendar arr_time = Calendar.getInstance();
        	dptr_time.setTime(sdf.parse(form.getDptr_time()));
        	arr_time.setTime(sdf.parse(form.getArr_time()));
	        addRestrictionIfNotNull(criteria, "pt_flight.dptr", dptr_time, 2);
	        addRestrictionIfNotNull(criteria, "pt_flight.arr", arr_time, 1);
        } catch(ParseException ex) {}
		//*/

        List<ParticularFlight> result = (List<ParticularFlight>) criteria.list();

        return result;
	}

	public List<ParticularFlight> search(SearchflightForm form) {
        Session session = sessionFactory.getCurrentSession();

        List<ParticularFlight> result = session.createCriteria(ParticularFlight.class).list();

        return result;
	}

	public List<ParticularFlight> getAll() {
        Session session = sessionFactory.getCurrentSession();

        List<ParticularFlight> result = session.createCriteria(ParticularFlight.class).list();

        return result;
	}

}

