package eureka.service.msp.rest;

import java.util.Collection;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import eureka.data.msp.MusicPlayerDAO;
import eureka.domain.msp.Artist;
import eureka.domain.msp.Music;

@RestController
@RequestMapping("/")
public class MusicPlayerRest {

	private MusicPlayerDAO dao = null;

	@RequestMapping(method = RequestMethod.GET, value = "/artistas", produces = "application/json")
	private String artistas() {
		Collection<Artist> artists = getMusicPlayerDAO().getAllArtist();

		StringBuilder sb = new StringBuilder();

		for (Artist artist : artists) {
			sb.append(artist.getId());
			sb.append("\t");
			sb.append(artist.getName());
			sb.append("\n");
		}

		return sb.toString();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/artista/{id}", produces = "application/json")
	private String artistaPorId(@PathVariable("id") int id) {
		Artist artist = getMusicPlayerDAO().getArtistById(id);

		StringBuilder sb = new StringBuilder();
		sb.append("id: ");
		sb.append(artist.getId());
		sb.append("\n");
		sb.append("nome: ");
		sb.append(artist.getName());

		return sb.toString();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/musicas", produces = "application/json")
	private String musicas() {
		Collection<Artist> artists = getMusicPlayerDAO().getAllArtist();

		StringBuilder sb = new StringBuilder();

		for (Artist artist : artists) {
			for (Music music : artist.getMusics()) {
				sb.append("nome: ");
				sb.append(music.getName());
				sb.append("\n");
			}
		}

		return sb.toString();
	}

	private MusicPlayerDAO getMusicPlayerDAO() {
		if (dao == null) {
			dao = new MusicPlayerDAO();
		}
		return dao;
	}
}
