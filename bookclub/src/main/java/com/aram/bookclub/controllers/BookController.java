package com.aram.bookclub.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;

import com.aram.bookclub.models.Book;
import com.aram.bookclub.models.User;
import com.aram.bookclub.services.BookService;
import com.aram.bookclub.services.UserService;

@Controller
public class BookController {

	@Autowired
	private BookService bServ;
	@Autowired
	private UserService uServ;
	
	@GetMapping(value={"/books", "/dashboard"})
	public String books(Model model, HttpSession seshRogen) {
		// Explicitly cast session Object to type		
		Long userId = (Long) seshRogen.getAttribute("user_id");
		// Route protect		
		if (userId == null) {
			return "redirect:/";
		}
		// Debug message		
		System.out.println("Reached Dashboard route.");
		// Get data for logged in user		
		User currentUser = uServ.readOne(userId);
		// Send to jsp		
		model.addAttribute("currentUser", currentUser);
		
		List<Book> books = bServ.getAll();
		model.addAttribute("books", books);
		return "books.jsp";		
	}
	
	@GetMapping("/books/new")
	public String newBook(@ModelAttribute Book book,
						  Model model,
						  HttpSession seshRogen) {
		// Explicitly cast session Object to type		
		Long userId = (Long) seshRogen.getAttribute("user_id");
		// Route protect		
		if (userId == null) {
			return "redirect:/";
		}
		//	Debug message
		System.out.println("Reached new book route");
		User currentUser = uServ.readOne(userId);
		model.addAttribute("user", currentUser);
		
		return "createEditBook.jsp";
	}
	
    @PostMapping("/books/process")
    public String processBook(@Valid @ModelAttribute Book book, 
            BindingResult result, Model model, HttpSession seshRogen) {
		// Explicitly cast session Object to type		
		Long userId = (Long) seshRogen.getAttribute("user_id");
		// Route protect		
		if (userId == null) {
			return "redirect:/";
		}
		
    	//	Use Service to validate and conditionally create 
    	Book newBook = bServ.create(book, result);
 
        // to do some extra validations and create a new user!
        if (newBook == null || result.hasErrors() ) {
        	// Errors, get info to pass forward again
    		User currentUser = uServ.readOne(userId);
    		model.addAttribute("user", currentUser);
    		return "createEditBook.jsp";
    	}        	
    
        return "redirect:/dashboard";
    }
    
    @GetMapping("/books/{id}")
    public String viewBook(@PathVariable String id,
    						HttpSession seshRogen,
    						Model model) {
		// Explicitly cast session Object to type		
		Long userId = (Long) seshRogen.getAttribute("user_id");
		// Route protect		
		if (userId == null) {
			return "redirect:/";
		}
		
		// Read PathVariable as String so no errors		
		 Long var;
		 try{
			 // Try to parse as Long			 
		 	var = Long.parseLong(id);
		 }
		 //	If fail, print the error and render dashboard		 
		 catch (NumberFormatException ex){
		 	ex.printStackTrace();
		 	return "redirect:/dashboard";
		 }
		 Book b = bServ.readOne(var);
		 model.addAttribute("book", b );
		 return "viewBook.jsp";
    }
    
    @GetMapping("/books/{id}/edit")
    public String editBook(@PathVariable String id,
    		HttpSession seshRogen,
    		Model model) {
    	// Explicitly cast session Object to type		
    	Long userId = (Long) seshRogen.getAttribute("user_id");
    	// Route protect		
    	if (userId == null) {
    		return "redirect:/";
    	}
    	
    	// Read PathVariable as String so no errors		
    	Long var;
    	try{
    		// Try to parse as Long			 
    		var = Long.parseLong(id);
    	}
    	//	If fail, print the error and render dashboard		 
    	catch (NumberFormatException ex){
    		ex.printStackTrace();
    		return "redirect:/dashboard";
    	}
    	Book b = bServ.readOne(var);
    	model.addAttribute("book", b );
    	// Edit used for conditional rendering header    	
    	model.addAttribute("edit", true);
    	return "createEditBook.jsp";
    }
    
//    @DeleteMapping("/books/{Id}/delete")
//	public String delete(@PathVariable("id") Long id, HttpSession session) {
//		if (session.getAttribute("id")==null)
//			return "redirect:/";
//		
//		bServ.deleteOne(id);
//		return "redirect:/books";
//	}
    
    @DeleteMapping("/books/{id}/delete")
    public String delete(@PathVariable("id") Long id) {
    	Book b = bServ.readOne(id);
        bServ.deleteOne(id);
        return "redirect:/books";
    }
    
    @PutMapping("/books/process/{id}")
    public String updateBook(@Valid @ModelAttribute Book book, 
            BindingResult result, Model model, HttpSession seshRogen) {
		// Explicitly cast session Object to type		
		Long userId = (Long) seshRogen.getAttribute("user_id");
		// Route protect		
		if (userId == null) {
			return "redirect:/";
		}
		
    	//	Use Service to validate and conditionally create 
    	Book editedBook = bServ.updateOne(book, result);
 
        // to do some extra validations and create a new user!
        if (editedBook == null || result.hasErrors() ) {
        	// Errors, get info to pass forward again
    		User currentUser = uServ.readOne(userId);
    		model.addAttribute("user", currentUser);
    		return "createEditBook.jsp";
    	}        	
    
        return "redirect:/books/" + editedBook.getId();
    }
}