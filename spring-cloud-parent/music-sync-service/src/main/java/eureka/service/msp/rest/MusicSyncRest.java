package eureka.service.msp.rest;

import java.util.Collection;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import music.data.MusicDAO;
import music.domain.Artist;
import music.domain.Music;

@RestController
@RequestMapping("/")
public class MusicSyncRest {

	private MusicDAO dao = null;

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
	private Object artistaPorId(@PathVariable("id") int id) {
		Artist artist = getMusicPlayerDAO().getArtistById(id);
		return artist;
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

	private MusicDAO getMusicPlayerDAO() {
		if (dao == null) {
			dao = new MusicDAO();
		}
		return dao;
	}
}
