package shopIn.controller.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import shopIn.pojo.Cellpones;
import shopIn.sevice.CellponesService;
@Controller
public class HomeController extends BaseServiceController{
		
	private CellponesService cellponesService;
	
	@Autowired
	public HomeController(CellponesService cellponesService) {
		this.cellponesService = cellponesService;
	}
		

	 @RequestMapping(method = RequestMethod.GET, value = "/")
	    public String home(Model model) {
		 List<Cellpones> cellpones=cellponesService.findAll();
		model.addAttribute("cellpones", cellpones);
	        return "index";
	    }

}
