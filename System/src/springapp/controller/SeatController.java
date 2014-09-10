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

import springapp.fss.form.OrderSeatForm;
import springapp.fss.dao.SeatDAO;
import springapp.fss.pojo.Seat;
import springapp.fss.pojo.Bonus;

@Controller
@Transactional(propagation = Propagation.REQUIRED)
public class SeatController {
	private SeatDAO seatDAO;

	@Autowired
	public void setSeatDAO(SeatDAO seatDao) {
		this.seatDAO = seatDao;
	}

    @RequestMapping(value="/for_clients/client={cl_id}/flights/part_fl={fl_id}/order_seat={s_id}", method=RequestMethod.GET)
    public String viewseat(
            @PathVariable(value="cl_id") Integer cl_id, 
            @PathVariable(value="fl_id") Integer fl_id, 
            @PathVariable(value="s_id") Integer s_id, 
            Model model) {
        Seat seat = (Seat) seatDAO.getSeatById(s_id);
        Bonus card = (Bonus) seatDAO.getBonusOnSeat(s_id, cl_id);

        model.addAttribute("seat", seat);
        model.addAttribute("bonus", card);
        model.addAttribute("command", new OrderSeatForm());

        return "order_seat";
    }
    
    @RequestMapping(value="/for_clients/client={cl_id}/seat={s_id}/de-reserve", method=RequestMethod.GET)
    public String de_order(
            @PathVariable(value="cl_id") Integer cl_id, 
            @PathVariable(value="s_id") Integer s_id, 
            Model model) {
        seatDAO.dereserveSeatById(s_id);
        Seat seat = (Seat) seatDAO.getSeatById(s_id);

        model.addAttribute("seat", seat);
        model.addAttribute("cl_id", cl_id);

        return "dereserve_confirmation";
    }
    
    @RequestMapping(value = "/for_clients/client={cl_id}/flights/part_fl={fl_id}/order_seat={s_id}/confirmation", method = RequestMethod.POST)
    public String order_seat(
            @PathVariable(value="cl_id") Integer cl_id, 
            @PathVariable(value="fl_id") Integer fl_id,
            @PathVariable(value="s_id") Integer s_id,
            @ModelAttribute("SpringWeb")OrderSeatForm form, Model model) {
        seatDAO.order_seat(s_id, cl_id, form);
        Seat seat = (Seat) seatDAO.getSeatById(s_id);

        model.addAttribute("seat", seat);
        model.addAttribute("cl_id", cl_id);

        return "order_confirmation";
    }
    
}
