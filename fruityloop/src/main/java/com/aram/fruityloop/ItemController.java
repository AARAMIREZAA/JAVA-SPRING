package com.aram.fruityloop;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

//New import 
import com.aram.fruityloop.models.Items;

@Controller
public class ItemController {
	@RequestMapping("/")
	public String index(Model model) {
		ArrayList<Items> fruitsArrayList = new ArrayList<Items>();
		fruitsArrayList.add(new Items("kiwi", 1.5));
		fruitsArrayList.add(new Items("Mango", 2.0));
		fruitsArrayList.add(new Items("Bayas de Goyi", 4.0));
		fruitsArrayList.add(new Items("Guayava", 75));
		
		model.addAttribute("fruits",fruitsArrayList);
		return "index.jsp";
	}

}
