package com.aram.daikichipath;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/daikichi")
public class DiakichiController {
	// 1. Annotation
    @RequestMapping("")
    // 3. Method that maps to the request route above
    public String welcome() { // 3
            return "Welcome!";
    }
    @RequestMapping("/today")
    // 3. Method that maps to the request route above
    public String today() { // 3
            return "Today you will find luck in all your endeavors!";
    }
    @RequestMapping("/tomorrow")
    // 3. Method that maps to the request route above
    public String tomorrow() { // 3
            return "Tomorrow, an opportunity will arise, so be sure to be open to new ideas!";
    }
    
    @RequestMapping("/{city}")
    public String showCity(@PathVariable("city") String city){
    return "Congratulations! You will soon travel to!! " + city;
    
}

@RequestMapping("/{name}/travel/{city}")
public String showAction(@PathVariable ("name") String name, @PathVariable ("city") String city){
return "Congratulations! You will soon travel to!! " + city;

}

@RequestMapping("/{name}/lotto/{number}")
	public String showLottoEven (@PathVariable ("name") String name,@PathVariable("number") int number){
		if  (number%2 == 0){
			return "You will take a grand journey in the near futurem but be wary of tempting offers";}
		else {
				return "You have enjoyed the fruits of your labor but now is a great time to spend time with family and friends";
			}
		}

}
