package cl.gonzalobenavides.lookifyapp.controller.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.gonzalobenavides.lookifyapp.models.Song;

@Service
public class LookifyService {

	@Autowired
	private LookifyRepository lookifyRepo;
	
	//Devolviendo todos los libros.
		public List<Song> allSongs() {
			return lookifyRepo.findAll();
		}
		
		public List<Song> topTen() {
			return lookifyRepo.findTop10ByClasificacionLessThanOrderByClasificacionDesc(11);
		}
		
		public List<Song> searchByArtist(String artist) {
			return lookifyRepo.findByArtistaContaining(artist);
		}
		
		//Creando un libro.
		public Song createSong(Song b) {
			return lookifyRepo.save(b);
		}
		
		public void deleteSong(Song song) {
			lookifyRepo.delete(song);
		}
		
		//Obteniendo la información de un libro
		public Song findSong(Long id) {
			Optional<Song> optionalSong = lookifyRepo.findById(id);
			if(optionalSong.isPresent()) {
				return optionalSong.get();
			} else {
				return null;
			}
		}
	
}
