package cl.gonzalobenavides.lookifyapp.controller;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cl.gonzalobenavides.lookifyapp.controller.services.LookifyService;
import cl.gonzalobenavides.lookifyapp.models.Song;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;

@Controller
public class LookifyController {
	
	@Autowired
	private LookifyService lookifyService;

	@GetMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@GetMapping("")
	public String indexNone() {
		return this.index();
	}
	
	
	@GetMapping("/dashboard")
	public String dashboard(@Valid @ModelAttribute Song artista, Model model) {
		List<Song> songs = lookifyService.allSongs();
		model.addAttribute("artista", new Song());
		model.addAttribute("lista", songs);
		return "dashboard.jsp";
	}
	
	@GetMapping("/search/topTen")
	public String topTen(Model model) {
		List<Song> songs = lookifyService.topTen();
		model.addAttribute("lista", songs);
		return "../topSongs.jsp";
	}
	
	@PostMapping("/search")
	public String searchGet(@ModelAttribute Song artista, BindingResult res, Model model) {
		return "redirect:/search/"+ artista.getArtista();
	}
	
	@GetMapping("/search/{artista}")
	public String searchPost(@Valid @ModelAttribute Song newArtista, @PathVariable("artista") String artista, BindingResult res, Model model) {
		List<Song> songs = lookifyService.searchByArtist(artista);
		model.addAttribute("lista", songs);
		model.addAttribute("newArtista", new Song());
		model.addAttribute("artista", artista);
		return "../searchArtist.jsp";
	}
	
	@GetMapping("/songs/new")
	public String newSong(@ModelAttribute("song")Song song) {
		return "../newSong.jsp";
	}
	
	@GetMapping("/songs/{id}")
	public String search(@PathVariable(value="id") Long id, Model model) {
		Song song = lookifyService.findSong(id);
		model.addAttribute("song", song);
		return "../song.jsp";
	}
	
	@GetMapping("/songs/delete/{id}")
	public String deleteSong(@PathVariable(value="id") Long id) {
		Song song = lookifyService.findSong(id);
		if(song == null) {
			return "redirect:/dashboard";
		}
		lookifyService.deleteSong(song);
		
		System.out.println("Canción eliminada: " + song.getTitulo());
		return "redirect:/dashboard";
	}
	
	@PostMapping("/songs/new")
	public String addSong(@Valid @ModelAttribute("song") Song song, BindingResult res) {
		if(res.hasErrors()) {
			return "../newSong.jsp";
		}
		
		lookifyService.createSong(song);
		System.out.println("Nueva canción: " + song.getTitulo());
		return "redirect:/dashboard";
	}
}
