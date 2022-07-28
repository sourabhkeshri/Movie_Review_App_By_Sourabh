package com.sourabh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.sourabh.model.Movie;
import com.sourabh.service.MovieService;

@Controller
public class MovieController {
	
	@Autowired
	MovieService movieService ;
	
	//display list of Movies
	@GetMapping("/")
	public String viewHomePage(Model model) {
		model.addAttribute("list",movieService.getAllMovies());
		
		return "index";
		
	}
	
	@GetMapping("/showNewMovieForm")
	public String showNewMovieForm(Model model) {
		Movie movie = new Movie();
		
		model.addAttribute("movie", movie);
		return "new_movie";
		
	}
	
	@PostMapping("/saveMovie")
	public String saveMovie(@ModelAttribute("movie") Movie movie) {
		this.movieService.saveMovie(movie);
		return "redirect:/";
	}
	
	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable ( value = "id") long id, Model model) {
		
		// get employee from the service
		Movie movie = movieService.getMovieById(id);
		
		// set employee as a model attribute to pre-populate the form
		model.addAttribute("movie", movie);
		return "update_movie";
	}
	
	@GetMapping("/deleteMovie/{id}")
	public String deleteMovie(@PathVariable (value = "id") long id) {
		
		// call delete employee method 
		this.movieService.deleteMovieById(id);
		return "redirect:/";
	}

}
