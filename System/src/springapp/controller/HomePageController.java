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
import springapp.fss.form.RegistrationForm;
import springapp.fss.dao.ClientDAO;
import springapp.fss.pojo.Client;
import springapp.fss.pojo.Administrator;

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
    public String client_authorization(Model model) {
    	model.addAttribute("command", new AuthorizationForm());
    	return "authorization_client";
    }
    
    @RequestMapping(value = "/authorization/clientcheck", method = RequestMethod.POST)
    public String authorize_client(@ModelAttribute("SpringWeb")AuthorizationForm form, Model model) {
        Client client = clientDAO.authorize_client(form);
        model.addAttribute("client", client);

        return "authorization_client_check";
    }

    @RequestMapping(value = "/authorization/admin", method = RequestMethod.GET)
    public String admin_authorization(Model model) {
    	model.addAttribute("command", new AuthorizationForm());
    	return "authorization_admin";
    }
    
    @RequestMapping(value = "/authorization/for_admins", method = RequestMethod.POST)
    public String authorize_admin(@ModelAttribute("SpringWeb")AuthorizationForm form, Model model) {
    	Administrator admin = clientDAO.authorize_admin(form);
    	model.addAttribute("admin", admin);

        return "authorization_admin_check";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
    	model.addAttribute("command", new RegistrationForm());
    	return "registration";
    }
    
    @RequestMapping(value = "/registration/confirmation", method = RequestMethod.POST)
    public String register(@ModelAttribute("SpringWeb")RegistrationForm form, Model model) {
    	Client client = clientDAO.register_client(form);
    	model.addAttribute("client", client);

        return "registration_confirmation";
    }

}
