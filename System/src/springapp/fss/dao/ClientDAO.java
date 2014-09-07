package springapp.fss.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import springapp.fss.pojo.Client;

@Repository("clientDAO")
public class ClientDAO {

	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Client authorize(AuthorizationForm form) {
        Session session = sessionFactory.getCurrentSession();

        Client result = session
        	.createCriteria(Client.class)
        	.add(Restrictions.eq("login", form.getLogin()))
        	.add(Restrictions.eq("password", form.getPassword()))
        	.uniqueResult();

        return result;
	}
}

