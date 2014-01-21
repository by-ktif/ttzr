package pl.ktif.ttlz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

import pl.ktif.ttlz.service.TournamentService;
import pl.ktif.ttlz.service.UserService;

@Controller
@RequestMapping("/welcome.do")
public class TtlzController {

	@Autowired
	UserService userService;

	@Autowired
	TournamentService tournamentService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView helloWorld(){
 
		String json = new Gson().toJson(userService.getTournamentUserDTOs(1));
		String json2 = new Gson().toJson(tournamentService.getTournamentDTO(1));
		ModelAndView model = new ModelAndView("main");
		model.addObject("msg", json);
		model.addObject("msg2", json2);
 
		return model;
	}
	
}
