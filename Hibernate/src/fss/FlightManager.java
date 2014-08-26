package fss;

import org.hibernate.Session;

import java.util.List;

import util.HibernateUtil;

public class FlightManager {

    public static void main(String[] args) {
        FlightManager mgr = new FlightManager();

        if (args[0].equals("store")) {
            mgr.createAndStoreFlight(args[1], Integer.parseInt(args[2]), args[3], args[4], args[5]);
        } else if (args[0].equals("list")) {
            List flights = mgr.listFlights();
            for (int i = 0; i < flights.size(); i++) {
                Flight theFlight = (Flight) flights.get(i);
                System.out.println("Flight: " + theFlight.getNumber());
            }
        }

        HibernateUtil.getSessionFactory().close();
    }
/*
    private void addFlightToFlight(int flightId, int FlightId) {

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        Flight aFlight = (Flight) session.load(Flight.class, flightId);
        Flight anFlight = (Flight) session.load(Flight.class, FlightId);

        aFlight.getFlights().add(anFlight);

        session.getTransaction().commit();
    }
*/
    private void createAndStoreFlight(
            String number, 
            Integer length, 
            String airline_name, 
            String dptr_arp, 
            String arr_arp) {

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction();

        Flight theFlight = new Flight();
        theFlight.setNumber(number);
        theFlight.setLength(length);

        Airline anAirline = (Airline) session
            .createQuery("FROM Airline air WHERE air.name = :airline")
            .setParameter("airline", airline_name)
            .uniqueResult();

        Airport dptr = (Airport) session
            .createQuery("FROM Airport air WHERE air.name = :airport")
            .setParameter("airport", dptr_arp)
            .uniqueResult();

        Airport arr = (Airport) session
            .createQuery("FROM Airport air WHERE air.name = :airport")
            .setParameter("airport", arr_arp)
            .uniqueResult();

        //System.out.println(anAirline.getId());
        theFlight.setAirline(anAirline);
        theFlight.setDptr_airport(dptr);
        theFlight.setArr_airport(arr);


        session.save(theFlight);

        session.getTransaction().commit();
    }

    private List listFlights() {

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction();

        List result = session.createQuery("FROM Flight").list();

        session.getTransaction().commit();

        return result;
    }

}
