package shopIn.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import shopIn.pojo.Cellpones;
import shopIn.sevice.CellponesService;
@Controller
public class CellponesController {
	private CellponesService cellponesService;
	
	

	@Autowired
	public CellponesController(CellponesService cellponesService) {
		this.cellponesService = cellponesService;
	}

	//手机集合页面
	@RequestMapping(method=RequestMethod.GET,value="/Cellpones/list")
	public String cellponesFind(Model model) {
		System.out.println("测试");	
		List<Cellpones> cellpones=cellponesService.findAll();
		model.addAttribute("cellpones", cellpones);
		return "Cellpones-list";
	}//详情页
	
	@RequestMapping(method=RequestMethod.GET,value="/cellpones/{id}/details")
	public String cellponesDetails(@PathVariable int id,Model model) {
		Cellpones  cellpones=cellponesService.findOne(id);
		model.addAttribute("cellpones", cellpones);
	return "cellpones-details";
	}
	//更新页面先往数据库在往页走
	@RequestMapping(method=RequestMethod.GET,value="/cellpones/{id}/update")
	public String cellponesUpdate(@PathVariable int id,Model model) {
//		Cellpones  cellpones=cellponesService.findOne(id);
//		model.addAttribute("cellpones", cellpones);
		return"cellpones-update";		
	}
	@RequestMapping(method=RequestMethod.GET,value="/obscurefind/list")
	public String obscureFind(@ModelAttribute Cellpones cellpones,Model model) {
		
	
		System.out.println("检查"+cellpones.getOs());
		List<Cellpones> cellpone=cellponesService.obscureFind(cellpones);
		model.addAttribute("cellpone", cellpone);
		return "obscurefind-list";
	}


}
