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

//import springapp.fss.form.AuthorizationForm;
//import springapp.fss.form.RegistrationForm;
//import springapp.fss.dao.ClientDAO;
//import springapp.fss.pojo.Client;
//import springapp.fss.pojo.Administrator;

@Controller
//@SessionAttributes("person")
@Transactional(propagation = Propagation.REQUIRED)
public class ClientPageController {
	//private ClientDAO clientDAO;

	//@Autowired
	//public void setClientDAO(ClientDAO clientDao) {
	//	this.clientDAO = clientDao;
	//}

    @RequestMapping(value = "for_clients/profile=*_view", method = RequestMethod.GET)
    public String view_profile(Model model) {
        return "view_profile";
    }

}
