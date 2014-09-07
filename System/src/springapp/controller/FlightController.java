package springapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import springapp.fss.dao.FlightDAO;

@Controller
@Transactional(propagation = Propagation.REQUIRED)
public class FlightController {
	private FlightDAO flightDAO;

	@Autowired
	public void setFlightDAO(FlightDAO flightDao) {
		this.flightDAO = flightDao;
	}

	@RequestMapping(value="/flights")
	public String viewpage(Model model) {
		model.addAttribute("flights", flightDAO.getAll());
		return "flights";
	}
}

