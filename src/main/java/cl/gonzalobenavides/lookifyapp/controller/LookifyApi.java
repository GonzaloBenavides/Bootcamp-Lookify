package cl.gonzalobenavides.lookifyapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.gonzalobenavides.lookifyapp.controller.services.LookifyService;
import cl.gonzalobenavides.lookifyapp.models.Song;
import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/api")
public class LookifyApi {
	
	@Autowired
	private LookifyService lookiService;
	
	@RequestMapping("/search")
	public List<Song> searchAll() {
		return lookiService.allSongs();
	}
	
	@GetMapping("/search/{:id}")
	public Song searchById(@PathParam(value = "id") Long id) {
		return lookiService.findSong(id);
	}
	
//	@PostMapping("/song/new")
//	public String newSong(@PathParam(value="titulo") String titulo, @PathParam(value="artista") String artista, @PathParam(value="clasificacion") Integer clasificacion) {
//		Song newSong = new Song(titulo, artista, clasificacion);
//		lookiService.createSong(newSong);
//		
//		System.out.println("Recibiendo nueva canción: '"+titulo+"', de "+artista+" ("+clasificacion+")");
//		return "dashboard.jsp";
//	}
	
}
