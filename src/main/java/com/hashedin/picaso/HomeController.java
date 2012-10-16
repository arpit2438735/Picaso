package com.hashedin.picaso;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Arpit
 *
 */
@Controller
public class HomeController {
	@RequestMapping(value="/")
	public ModelAndView Albums(){
		Map<String, Object> model= new HashMap<String, Object>();
		model.put("name","Arpit Albums");
		model.put("categories","Mobile Phones");
		model.put("id", "1");
		return new ModelAndView("home", model);
	}
	@RequestMapping(value="/albums/{id}")
	public ModelAndView Photos(String id){
		Map<String,Object> newmodel=new HashMap<String,Object>();
		Fetchdata fetchdata=new Fetchdata();
		
		newmodel.put("fetchdata",fetchdata.getalbums());
		return new ModelAndView("images",newmodel);
	}

}