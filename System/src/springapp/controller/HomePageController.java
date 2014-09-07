package springapp.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import springapp.fss.form.AuthorizationForm;
import springapp.fss.dao.ClientDAO;
import springapp.fss.pojo.Client;

@Controller
@SessionAttributes("person")
@Transactional(propagation = Propagation.REQUIRED)
public class HomePageController {
	private ClientDAO clientDAO;

	@Autowired
	public void setClientDAO(ClientDAO clientDao) {
		this.clientDAO = clientDao;
	}

	@RequestMapping(value="/home")
	public String homepage(Model model) {
		return "home";
	}

    @RequestMapping(value = "/authorization/client", method = RequestMethod.GET)
    public String authorization(Model model) {
    	AuthorizationForm form;
    	if (!model.containsAttribute("person")) {
    		form = new AuthorizationForm();
    		form.setLogin("login");
    		form.setPassword("password");
	    	model.addAttribute("person", new AuthorizationForm());
	    	return "authorization_client";
    	} else {
    		form = (AuthorizationForm) model.asMap().get("person");
    	}
    	Client client = clientDAO.authorize(form);
    	try {
	    	client.getName();
	        return "for_clients";
    	} catch (NullPointerException ooops) {
    		return "authorization_client_failed";
    	}
    }
    
    @RequestMapping(value = "/authorization/client", method = RequestMethod.POST)
    public String authorize(@ModelAttribute("SpringWeb")AuthorizationForm form, Model model) {
        model.addAttribute("person", form.getLogin());
        model.addAttribute("password", form.getPassword());
      
        return "redirect:/authorization_client";
    }
}
