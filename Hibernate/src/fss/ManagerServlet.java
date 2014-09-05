package fss;

// Imports

public class ManagerServlet extends HttpServlet {

    // Servlet code

	protected void doGet(
		HttpServletRequest request,
	    HttpServletResponse response)
	        throws ServletException, IOException {

	    try {
	        // Begin unit of work
	        HibernateUtil.getSessionFactory()
	                .getCurrentSession().beginTransaction();

			// Write HTML header
			PrintWriter out = response.getWriter();
			out.println("<html><head><title>Manager</title></head><body>");

			// Handle actions
			if ( "storeflight".equals(request.getParameter("action")) ) {

			    String number = request.getParameter("number");
			    String length = request.getParameter("length");
			    String airline = request.getParameter("airline");
			    String dptr_arp = request.getParameter("dptr_airport");
			    String arr_arp = request.getParameter("arr_airport");

			    if ("".equals(number) || "".equals(length) || "".equals(airline) || "".equals(dptr_arp) || "".equals(arr_arp)) {
			        out.println("<b><i>Please enter flight number, length, airline, departure and arrival airports.</i></b>");
			    } else {
			        createAndStoreFlight(number, Integer.parseInt(length), airline, dptr_arp, arr_arp);
			        out.println("<b><i>Added flight.</i></b>");
			    }
			}

			// Print page
			printEventForm(out);
			listflights(out);

			// Write HTML footer
			out.println("</body></html>");
			out.flush();
			out.close();

	        // End unit of work
	        HibernateUtil.getSessionFactory()
	                .getCurrentSession().getTransaction().commit();

	    } catch (Exception ex) {
	        HibernateUtil.getSessionFactory()
	                .getCurrentSession().getTransaction().rollback();
	        throw new ServletException(ex);
	    }

	}

	private void printEventForm(PrintWriter out) {
	    out.println("<h2>Add new flight:</h2>");
	    out.println("<form>");
	    out.println("Number: <input name='number' length='50'/><br/>");
	    out.println("Length: <input name='length' length='10'/><br/>");
	    out.println("Airline: <input name='airline' length='20'/><br/>");
	    out.println("Departure: <input name='dptr_arp' length='20'/><br/>");
	    out.println("Arrival: <input name='arr_arp' length='20'/><br/>");
	    out.println("<input type='submit' name='action' value='store'/>");
	    out.println("</form>");
	}

	private void listFlights(PrintWriter out) {

	    List result = HibernateUtil.getSessionFactory()
	                    .getCurrentSession().createCriteria(Flight.class).list();
	    if (result.size() > 0) {
	        out.println("<h2>Flights in database:</h2>");
	        out.println("<table border='1'>");
	        out.println("<tr>");
	        out.println("<th>Flight number</th>");
	        out.println("<th>Flight length</th>");
	        out.println("<th>Airline</th>");
	        out.println("<th>Departure</th>");
	        out.println("<th>Arrival</th>");
	        out.println("</tr>");
	        for (Iterator it = result.iterator(); it.hasNext();) {
	            Flight flight = (Flight) it.next();
	            out.println("<tr>");
	            out.println("<td>" + flight.getNumber() + "</td>");
	            out.println("<td>" + flight.getLength() + "</td>");
	            out.println("<td>" + flight.getAirline().getName() + "</td>");
	            out.println("<td>" + flight.getDptr_airport().getName() + "</td>");
	            out.println("<td>" + flight.getDptr_airport().getName() + "</td>");
	            out.println("</tr>");
	        }
	        out.println("</table>");
	    }
	}

    protected void createAndStoreFlight(
            String number, 
            Integer length, 
            String airline_name, 
            String dptr_arp, 
            String arr_arp) {

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

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
    }

}