package pl.ktif.ttlz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import pl.ktif.ttlz.service.TournamentService;

@Controller
@RequestMapping("/welcome.do")
public class TtlzController {

	@Autowired
	TournamentService tournamentService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView helloWorld(){
 
		String json = tournamentService.getAllTournamentsJson();
		ModelAndView model = new ModelAndView("main");
		model.addObject("msg", json);
 
		return model;
	}
	
}
