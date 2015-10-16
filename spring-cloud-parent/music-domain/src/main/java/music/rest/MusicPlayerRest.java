package music.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import music.data.MusicDAO;
import music.domain.Artist;

@RestController
@RequestMapping("/sync")
public class MusicPlayerRest {

	private MusicDAO dao = null;
	private Gson gson;

	@RequestMapping(method = RequestMethod.GET, value = "/artista/{json}", consumes = "application/json")
	private String artista(String artistaJson) {
		Artist artist = getGson().fromJson(artistaJson, Artist.class);

		StringBuilder sb = new StringBuilder();

		sb.append(artist.getId());
		sb.append("\t");
		sb.append(artist.getName());
		sb.append("\n");

		return sb.toString();
	}

	private MusicDAO getMusicPlayerDAO() {
		if (dao == null) {
			dao = new MusicDAO();
		}
		return dao;
	}

	public Gson getGson() {
		if (gson == null) {
			gson = new Gson();
		}
		return gson;
	}
}
