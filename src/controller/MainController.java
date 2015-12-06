package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class MainController {

		@RequestMapping("/welcome")
		public ModelAndView document(){
				ModelAndView model = new ModelAndView("document");
				return model;
		}
}
