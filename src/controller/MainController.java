package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class MainController {

		@RequestMapping("api/document")
		public ModelAndView document(){
				ModelAndView model = new ModelAndView("index");
				return model;
		}
		
		@RequestMapping("/")
		public ModelAndView indexView(){
			ModelAndView model = new ModelAndView("coming-soon");
			return model;
		}
		
		
}
