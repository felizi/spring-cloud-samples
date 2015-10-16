package music.data;

import java.util.Collection;
import java.util.Collections;

import music.domain.Artist;
import music.domain.Music;

public class MusicDAO {
	private MusicDataInterface musicData = null;

	public Collection<Artist> getAllArtist() {
		return Collections.unmodifiableCollection(getMusicData().getAllArtists());
	}

	public Collection<Music> getAllMusicsByArtist(int id) {
		Artist artistById = getArtistById(id);
		if (artistById != null) {
			return artistById.getMusics();
		}
		return null;
	}

	public Artist getArtistById(int id) {
		for (Artist artist : getMusicData().getAllArtists()) {
			if (artist.getId() == id) {
				return artist;
			}
		}
		return null;
	}

	private MusicDataInterface getMusicData() {
		if (musicData == null) {
			musicData = new MusicDataMock();
		}
		return musicData;
	}
}
