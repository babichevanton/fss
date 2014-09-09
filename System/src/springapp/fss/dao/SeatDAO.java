package springapp.fss.dao;

import java.util.List;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.text.ParseException;

import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import springapp.fss.form.OrderSeatForm;
import springapp.fss.pojo.*;

@Repository("seatDAO")
public class SeatDAO {

	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

    public Seat getSeatById(int id) {
        Session session = sessionFactory.getCurrentSession();

        Seat result = (Seat) session
                .createCriteria(Seat.class)
                .add(Restrictions.eq("id", id))
                .uniqueResult();

        return result;
    }

    public Bonus getBonusOnSeat(int s_id, int cl_id) {
        Session session = sessionFactory.getCurrentSession();

        Seat seat = (Seat) session
                .createCriteria(Seat.class)
                .add(Restrictions.eq("id", s_id))
                .uniqueResult();

        Client client = (Client) session
                .createCriteria(Client.class)
                .add(Restrictions.eq("id", cl_id))
                .uniqueResult();

        Airline airline = seat.getServiceClass().getParticularFlight().getFlight().getAirline();
        Integer length = seat.getServiceClass().getParticularFlight().getFlight().getLength();
        Float coeff = seat.getServiceClass().getCoeff();

        Bonus bonus = (Bonus) session
                .createCriteria(Bonus.class)
                .add(Restrictions.eq("Airline", airline))
                .add(Restrictions.eq("Client", client))
                .add(Restrictions.ge("points", new Long(Math.round(length * coeff))))
                .addOrder(Order.asc("points"))
                .setMaxResults(1)
                .uniqueResult();

        return bonus;
    }

    public void order_seat(int s_id, int cl_id, OrderSeatForm form) {
        Session session = sessionFactory.getCurrentSession();

        Seat seat = (Seat) session
                .createCriteria(Seat.class)
                .add(Restrictions.eq("id", s_id))
                .uniqueResult();

        Client client = (Client) session
                .createCriteria(Client.class)
                .add(Restrictions.eq("id", cl_id))
                .uniqueResult();

        Integer length = seat.getServiceClass().getParticularFlight().getFlight().getLength();
        Float coeff = seat.getServiceClass().getCoeff();

        seat.setOwner(client);

        if (form.getType().equals("reserve")) { // reservation needs pay
            if (form.getCard()) {
                Bonus bonus = (Bonus) session
                        .createCriteria(Bonus.class)
                        .add(Restrictions.eq("id", form.getId()))
                        .uniqueResult();

                bonus.setPoints(bonus.getPoints() - new Long(Math.round(length * coeff)));
                session.saveOrUpdate(bonus);
            } else {
                Airline airline = seat.getServiceClass().getParticularFlight().getFlight().getAirline();

                Bonus bonus = (Bonus) session
                        .createCriteria(Bonus.class)
                        .add(Restrictions.eq("airline", airline))
                        .add(Restrictions.eq("client", client))
                        .addOrder(Order.desc("points"))
                        .setMaxResults(1)
                        .uniqueResult();

                try {
                    bonus.setPoints(bonus.getPoints() + new Long(Math.round(length * coeff)));
                    session.saveOrUpdate(bonus);
                } catch (NullPointerException no_bonus) {}
            }

            seat.setStatus((byte) 2);
        } else if (form.getType().equals("order")) {
            seat.setStatus((byte) 1);
        }

        session.saveOrUpdate(seat);
    }

}

