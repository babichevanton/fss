package springapp.fss.dao;

import java.util.List;
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
import springapp.fss.pojo.Administrator;

@Repository("clientDAO")
public class ClientDAO {

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

    public List<Client> search_clients(SearchClientForm form) {
        Session session = sessionFactory.getCurrentSession();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

        Criteria criteria = session
            .createCriteria(Client.class, "client")
            .createAlias("client.seats", "seat")
            .createAlias("seat.sclass", "sclass")
            .createAlias("sclass.flight", "pt_flight")
            .createAlias("pt_flight.flight", "flight")
            .createAlias("flight.airline", "airline")
            .createAlias("flight.dptr_airport", "dptr_airport")
            .createAlias("flight.arr_airport", "arr_airport");
        addRestrictionIfNotNull(criteria, "flight.number", form.getNumber(), 0);
        addRestrictionIfNotNull(criteria, "dptr_airport.city", form.getDptr_city(), 0);
        addRestrictionIfNotNull(criteria, "arr_airport.city", form.getArr_city(), 0);
        addRestrictionIfNotNull(criteria, "airline.name", form.getAirline(), 0);
        if (form.getOrdered()) {
                addRestrictionIfNotNull(criteria, "seat.status", 1, 0);
        }
        if (form.getReserved()) {
                addRestrictionIfNotNull(criteria, "seat.status", 2, 0);
        }
        try {
            addRestrictionIfNotNull(criteria, "pt_flight.dptr", sdf.parse(form.getDptr_time()), 1);
            addRestrictionIfNotNull(criteria, "pt_flight.arr", sdf.parse(form.getArr_time()), 2);
        } catch (ParseException ex) {}
                
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
