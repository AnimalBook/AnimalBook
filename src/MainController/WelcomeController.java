package MainController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WelcomeController {
	
	@RequestMapping("/weclome")
	public ModelAndView welcomePage(){
		ModelAndView model = new ModelAndView("welcomePage");
		model.addObject("message", "welcomePage");
		return model;
	}
	
	
}
