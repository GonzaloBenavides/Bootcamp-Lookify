package cl.gonzalobenavides.lookifyapp.controller.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cl.gonzalobenavides.lookifyapp.models.Song;

@Repository
public interface LookifyRepository extends CrudRepository<Song, Long> {

	List<Song> findAll();
	//Este método encuentra un Song por su Artista
	List<Song> findByArtistaContaining(String search);
	//Este método encuentra un Song por su id
	Optional<Song> findById(Long search);
	//Este método cuenta cuántos Songs contiene cierta cadena en el título
//	Long countByTituloContaining(String search);
	//Este método borra un Song que empieza con un título específico
//	Long deleteByTituloStartingWith(String search);
	//Este método agrega un Song
	Song save(Song song);
	
	List<Song> findTop10ByClasificacionLessThanOrderByClasificacionDesc(Integer clasificacion);
}
