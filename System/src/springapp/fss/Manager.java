package springapp.fss;

import org.hibernate.Session;

import springapp.fss.POJO.*;

import java.util.List;
import java.text.SimpleDateFormat;
import java.util.Iterator;

public class Manager {

    public static void main(String[] args) {
        Manager mgr = new Manager();

        if (args[0].equals("storeflight")) {
            mgr.createAndStoreFlight(args[1], Integer.parseInt(args[2]), args[3], args[4], args[5]);
        } else if (args[0].equals("authorization")) {
            Client client = mgr.find_client(args[1], args[2]);
            try {
                String output = client.getName() + " " + client.getPatronymic() + " " + client.getSurname();
                System.out.println(output);
            } catch (NullPointerException ooops) {
                System.out.println("Wrong login/password");
            }
        } else if (args[0].equals("flights")) {
            List flights = mgr.listOf("Flight");
            for (int i = 0; i < flights.size(); i++) {
                Flight one_flight = (Flight) flights.get(i);
                Iterator i_fl = one_flight.getParticularFlights().iterator();
                String output = one_flight.getNumber() + " " + one_flight.getAirline().getName() + " " 
                    + one_flight.getDptr_airport().getName() + " " + one_flight.getArr_airport().getName();
                while (i_fl.hasNext()) {
                    ParticularFlight p_fl = (ParticularFlight) i_fl.next();
                    String time = p_fl.getDptr().getTime() + " " + p_fl.getArr().getTime();
                    System.out.println(output + " " + time);
                    Iterator i_sc = p_fl.getServices().iterator();
                    while (i_sc.hasNext()) {
                        ServiceClass s_cl = (ServiceClass) i_sc.next();
                        String service = "    " + s_cl.getName() + " cost: " + s_cl.getCost();
                        Iterator i_seat = s_cl.getSeats().iterator();
                        int countOf = 0;
                        while (i_seat.hasNext()) {
                            Seat seat = (Seat) i_seat.next();
                            if (seat.getStatus() == 0) {
                                countOf++;
                            }
                        }
                        service += " count: " + countOf;
                        System.out.println(service);
                    }
                    System.out.println("\n");
                }
            }
        } else if (args[0].equals("one_flight")) {
            List flights = mgr.listOf("ParticularFlight");
            for (int i = 0; i < flights.size(); i++) {
                ParticularFlight one_flight = (ParticularFlight) flights.get(i);
                if (one_flight.getId() == Integer.parseInt(args[1])) {
                    System.out.println("\n" + one_flight.getDptr() + "\n" + one_flight.getArr());
                    Iterator i_sc = one_flight.getServices().iterator();
                    while (i_sc.hasNext()) {
                        ServiceClass s_cl = (ServiceClass) i_sc.next();
                        System.out.println("    class: " + s_cl.getName() + "    cost: " + s_cl.getCost());
                        Iterator i_seat = s_cl.getSeats().iterator();
                        while (i_seat.hasNext()) {
                            Seat seat = (Seat) i_seat.next();
                            String one_seat = "" + seat.getRow() + " " + seat.getSymb() + " ";
                            switch (seat.getStatus()) {
                                case 0:
                                    one_seat += "free";
                                    break;
                                case 1:
                                    one_seat += "on order";
                                    break;
                                case 2:
                                    one_seat += "reserved";
                                    break;
                                default:
                                    one_seat += "FFAAAAAAILLLL!!!11!1";
                                    break;
                            }
                            System.out.println(one_seat);
                        }
                    }
                }
            }
        } else if (args[0].equals("order_seat")) {
            List flights = mgr.listOf("ParticularFlight");
            for (int i = 0; i < flights.size(); i++) {
                ParticularFlight one_flight = (ParticularFlight) flights.get(i);
                if (one_flight.getId() == Integer.parseInt(args[1])) {
                    Iterator i_sc = one_flight.getServices().iterator();
                    while (i_sc.hasNext()) {
                        ServiceClass s_cl = (ServiceClass) i_sc.next();
                        Iterator i_seat = s_cl.getSeats().iterator();
                        while (i_seat.hasNext()) {
                            Seat seat = (Seat) i_seat.next();
                            if (seat.getRow() == Integer.parseInt(args[2]) && seat.getSymb().equals(args[3])) {
                                mgr.order_one_seat(seat, args[4]);
                                break;
                            }
                        }
                    }
                }
            }
        } else if (args[0].equals("seats")) {
            List seats = mgr.listOf("Seat");
            for (int i = 0; i < seats.size(); i++) {
                Seat one_seat = (Seat) seats.get(i);
                String output = "" + one_seat.getRow() + " " + one_seat.getSymb() + " " + one_seat.getStatus()+ " "
                 + one_seat.getServiceClass().getName();
                try {
                    output += " " + one_seat.getOwner().getName() + " " + one_seat.getOwner().getSurname();
                } catch (NullPointerException no_owner) {}
                System.out.println(output);
            }
        }

        HibernateUtil.getSessionFactory().close();
    }

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

        theFlight.setAirline(anAirline);
        theFlight.setDptr_airport(dptr);
        theFlight.setArr_airport(arr);


        session.save(theFlight);

        session.getTransaction().commit();
    }

    private void order_one_seat(Seat one_seat, String new_status) {

        if (one_seat.getStatus() == 0) {

            Session session = HibernateUtil.getSessionFactory().getCurrentSession();

            session.beginTransaction();

            if (new_status.equals("order")) {
                one_seat.setStatus((byte) 1);
            } else if (new_status.equals("reserve")) {
                one_seat.setStatus((byte) 2);
            } else {
                System.out.println("Invalid order option " + new_status);
            }

            session.save(one_seat);

            session.getTransaction().commit();

        } else {
            System.out.println("The seat " + one_seat.getRow() + " " + one_seat.getSymb() + " is already ordered");
        }
    }

    private Client find_client(String login, String password) {

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction();

        Client result = (Client) session
            .createQuery("FROM Client cl WHERE cl.login = :login AND cl.password = :password")
            .setParameter("login", login).setParameter("password", password)
            .uniqueResult();

        return result;
    }

    private List listOf(String table_name) {

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction();

        List result = session.createQuery("FROM " + table_name).list();

        session.getTransaction().commit();

        return result;
    }

}
