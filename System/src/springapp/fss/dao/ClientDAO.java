package springapp.fss.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import springapp.fss.form.AuthorizationForm;
import springapp.fss.form.RegistrationForm;
import springapp.fss.pojo.Client;
import springapp.fss.pojo.Administrator;

@Repository("clientDAO")
public class ClientDAO {

	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
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
