package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DateDifferenceController{
	@ResponseBody
	@RequestMapping("/")
	public String home() {
		return "My First SpringBoot App";
	}
//	@RequestMapping(value = {"/date"}, method = RequestMethod.GET)
	//public String Date (@RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate) {
	@RequestMapping("/date")
	public String Date(){
        {
	return "DateDifference";
	}
}
	
}