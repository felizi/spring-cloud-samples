package music.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import music.domain.Artist;
import music.domain.Music;

public class MusicDataMock implements MusicDataInterface {

	@Override
	public Collection<Artist> getAllArtists() {
		Collection<Artist> artists = new ArrayList<>();

		artists.add(new Artist(1, "Metallica", Arrays.asList(new Music("The Unforgiven"), new Music("For Whom The Bell Tolls"), new Music("Seek and Destroy"))));
		artists.add(new Artist(2, "Megadeth", Arrays.asList(new Music("99 ways to die"), new Music("Peace Sells"), new Music("Trust"))));
		artists.add(new Artist(3, "AC/DC", Arrays.asList(new Music("Highway to Hell"), new Music("T.N.T."), new Music("Back in Black"))));
		artists.add(new Artist(4, "System of a Down", Arrays.asList(new Music("Chop Suey"), new Music("Aerials"), new Music("Toxicity"))));
		artists.add(new Artist(5, "Korn", Arrays.asList(new Music("Blind"), new Music("Freak on a Leash"), new Music("Thoughtless"))));
		artists.add(new Artist(6, "Iron Maiden", Arrays.asList(new Music("Fear of the Dark"), new Music("The Trooper"), new Music("Speed of Light"))));

		return artists;
	}

}
