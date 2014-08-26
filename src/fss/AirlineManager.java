package fss;

import org.hibernate.Session;

import java.util.List;

import util.HibernateUtil;

public class AirlineManager {

    public static void main(String[] args) {
        AirlineManager mgr = new AirlineManager();

        if (args[0].equals("store")) {
            mgr.createAndStoreAirline("Aeroflot");
        } else if (args[0].equals("list")) {
            List airlines = mgr.listAirlines();
            for (int i = 0; i < airlines.size(); i++) {
                Airline theAirline = (Airline) airlines.get(i);
                System.out.println("Airline: " + theAirline.getName());
            }
        }

        HibernateUtil.getSessionFactory().close();
    }
/*
    private void addFlightToAirline(int flightId, int airlineId) {

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        Flight aFlight = (Flight) session.load(Flight.class, flightId);
        Airline anAirline = (Airline) session.load(Airline.class, airlineId);

        aFlight.getAirlines().add(anAirline);

        session.getTransaction().commit();
    }
*/
    private void createAndStoreAirline(String title) {

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction();

        Airline theAirline = new Airline();
        theAirline.setName(title);

        session.save(theAirline);

        session.getTransaction().commit();
    }

    private List listAirlines() {

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction();

        List result = session.createQuery("from Airline").list();

        session.getTransaction().commit();

        return result;
    }

}
