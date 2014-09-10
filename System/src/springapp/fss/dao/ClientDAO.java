package springapp.fss.dao;

import java.util.List;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.text.SimpleDateFormat;
import java.text.ParseException;

import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import springapp.fss.form.SearchClientForm;
import springapp.fss.form.AuthorizationForm;
import springapp.fss.form.RegistrationForm;
import springapp.fss.pojo.Client;
import springapp.fss.pojo.Bonus;
import springapp.fss.pojo.Seat;
import springapp.fss.pojo.Administrator;

@Repository("clientDAO")
public class ClientDAO {

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

    public List<Client> search_clients(SearchClientForm form) {
        Session session = sessionFactory.getCurrentSession();

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        Criteria criteria = session
            .createCriteria(Client.class, "client")
            .createAlias("client.Seats", "seat")
            .createAlias("seat.Sclass", "sclass")
            .createAlias("sclass.Flight", "pt_flight")
            .createAlias("pt_flight.Flight", "flight")
            .createAlias("flight.Airline", "airline")
            .createAlias("flight.Dptr_airport", "dptr_airport")
            .createAlias("flight.Arr_airport", "arr_airport");
        addRestrictionIfNotNull(criteria, "flight.number", form.getNumber());
        addRestrictionIfNotNull(criteria, "dptr_airport.city", form.getDptr_city());
        addRestrictionIfNotNull(criteria, "arr_airport.city", form.getArr_city());
        addRestrictionIfNotNull(criteria, "airline.name", form.getAirline());
        if (!form.getOrdered() && form.getReserved()) {
            criteria.add(Restrictions.eq("seat.status", 2));
        } else if (form.getOrdered() && !form.getReserved()) {
            criteria.add(Restrictions.eq("seat.status", 1));
        }

        try {
            if (!form.getDptr_time().equals("")) {
                Calendar dptr_time = Calendar.getInstance();
                dptr_time.setTime(sdf.parse(form.getDptr_time()));
                criteria.add(Restrictions.le("pt_flight.dptr", dptr_time));
            }
            if (!form.getArr_time().equals("")) {
                Calendar arr_time = Calendar.getInstance();
                arr_time.setTime(sdf.parse(form.getArr_time()));
                criteria.add(Restrictions.le("pt_flight.arr", arr_time));
            }
        } catch(ParseException ex) {}
                
        List<Client> result = (List<Client>) criteria.list();

        return result;
    }

    public Client getClientById(int id) {
        Session session = sessionFactory.getCurrentSession();

        Client result = (Client) session
                .createCriteria(Client.class)
                .add(Restrictions.eq("id", id))
                .uniqueResult();

        return result;
    }

    public Bonus getBonusById(int id) {
        Session session = sessionFactory.getCurrentSession();

        Bonus result = (Bonus) session
                .createCriteria(Bonus.class)
                .add(Restrictions.eq("id", id))
                .uniqueResult();

        return result;
    }

    public List<Seat> getClientSeats(Client client) {
        Session session = sessionFactory.getCurrentSession();

        Calendar now = new GregorianCalendar();

        List<Seat> result = (List<Seat>) session
                .createCriteria(Seat.class, "seat")
                .createAlias("seat.ServiceClass", "sclass")
                .createAlias("sclass.ParticularFlight", "pt_flight")
                .add(Restrictions.eq("Owner", client))
                .add(Restrictions.le("pt_flight.dptr", now))
                .list();

        return result;
    }

    public List<Bonus> getClientBonuses(Client client) {
        Session session = sessionFactory.getCurrentSession();

        List<Bonus> result = (List<Bonus>) session
                .createCriteria(Bonus.class, "seat")
                .add(Restrictions.eq("Client", client))
                .list();

        return result;
    }

    public void deleteClientBonus(Bonus card) {
        Session session = sessionFactory.getCurrentSession();

        session.delete(card);
    }

    public void deleteClient(Client client) {
        Session session = sessionFactory.getCurrentSession();

        session.delete(client);
    }

    public Client authorize_client(AuthorizationForm form) {
        Session session = sessionFactory.getCurrentSession();

        Client result = (Client) session
                .createCriteria(Client.class)
                .add(Restrictions.eq("login", form.getLogin()))
                .add(Restrictions.eq("password", form.getPassword()))
                .uniqueResult();

        return result;
    }

	public Administrator authorize_admin(AuthorizationForm form) {
        Session session = sessionFactory.getCurrentSession();

        Administrator result = (Administrator) session
        	.createCriteria(Administrator.class)
        	.add(Restrictions.eq("login", form.getLogin()))
        	.add(Restrictions.eq("password", form.getPassword()))
        	.uniqueResult();

        return result;
	}

	public Client register_client(RegistrationForm form) {
        Session session = sessionFactory.getCurrentSession();

        Client client = new Client();
        client.setLogin(form.getLogin());
        client.setPassword(form.getPassword());
        client.setName(form.getName());
        client.setPatronymic(form.getPatronymic());
        client.setSurname(form.getSurname());
        client.setAddress(form.getAddress());
        client.setPhone(form.getPhone());
        client.setEmail(form.getEmail());

        session.save(client);

        return client;
	}
}
