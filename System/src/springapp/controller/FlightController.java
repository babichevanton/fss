package springapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import springapp.fss.form.SearchflightForm;
import springapp.fss.dao.FlightDAO;
import springapp.fss.pojo.ParticularFlight;

@Controller
@Transactional(propagation = Propagation.REQUIRED)
public class FlightController {
	private FlightDAO flightDAO;

	@Autowired
	public void setFlightDAO(FlightDAO flightDao) {
		this.flightDAO = flightDao;
	}

    @RequestMapping(value = "/for_clients/searchflights", method = RequestMethod.GET)
    public String view_searchflights_form(Model model) {
    	model.addAttribute("command", new SearchflightForm());
        return "client_searchflights";
    }

    @RequestMapping(value = "/for_clients/flights", method = RequestMethod.POST)
    public String search_flights(@ModelAttribute("SpringWeb")SearchflightForm form, Model model) {
        List<ParticularFlight> flights = flightDAO.client_search(form);
        model.addAttribute("flights", flights);

        return "client_flights";
    }

    @RequestMapping(value="/for_clients/flights/part_fl={id}", method=RequestMethod.GET)
    public String view_flight(@PathVariable(value="id") Integer id, Model model) {
        ParticularFlight pt_flight = (ParticularFlight) flightDAO.getFlightById(id);
        model.addAttribute("pt_flight", pt_flight);
        return "client_flight";
    }
    
}

