package eureka.data.msp;

import java.util.Collection;
import java.util.Collections;

import eureka.domain.msp.Artist;
import eureka.domain.msp.Music;

public class MusicPlayerDAO {
	private MusicPlayerDataInterface musicPlayerData = null;

	public Collection<Artist> getAllArtist() {
		return Collections.unmodifiableCollection(getMusicPlayerData().getAllArtists());
	}

	public Collection<Music> getAllMusicsByArtist(int id) {
		Artist artistById = getArtistById(id);
		if (artistById != null) {
			return artistById.getMusics();
		}
		return null;
	}

	public Artist getArtistById(int id) {
		for (Artist artist : getMusicPlayerData().getAllArtists()) {
			if (artist.getId() == id) {
				return artist;
			}
		}
		return null;
	}

	private MusicPlayerDataInterface getMusicPlayerData() {
		if (musicPlayerData == null) {
			musicPlayerData = new MusicPlayerDataMock();
		}
		return musicPlayerData;
	}
}
