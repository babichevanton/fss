package springapp.controller;

import java.util.List;

import javax.validation.Valid;

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

import springapp.fss.dao.ClientDAO;
import springapp.fss.pojo.Client;
import springapp.fss.pojo.Bonus;
import springapp.fss.pojo.Seat;
//import springapp.fss.pojo.Administrator;

@Controller
@SessionAttributes("person")
@Transactional(propagation = Propagation.REQUIRED)
public class ClientPageController {
	private ClientDAO clientDAO;

	@Autowired
	public void setClientDAO(ClientDAO clientDao) {
		this.clientDAO = clientDao;
	}

    @RequestMapping(value = "/for_clients/client={cl_id}/view_profile", method = RequestMethod.GET)
    public String order_seat(@PathVariable(value="cl_id") Integer cl_id, Model model) {
    	Client client = clientDAO.getClientById(cl_id);
    	List<Seat> seats = clientDAO.getClientSeats(client);
    	List<Bonus> cards = clientDAO.getClientBonuses(client);

        model.addAttribute("client", client);
        model.addAttribute("seats", seats);
        model.addAttribute("cards", cards);

        return "view_profile";
    }
}
