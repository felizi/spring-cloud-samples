package music.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class Artist {

	private int id;
	private String name;
	private Collection<Music> musics;

	public Artist(int id, String name, Collection<Music> musics) {
		super();
		this.id = id;
		this.name = name;
		this.musics = new ArrayList<>();
		this.addMusics(musics);
	}

	public Artist(int id, String name) {
		super();
		this.id = id;
		this.name = name;
		this.musics = new ArrayList<>();
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Collection<Music> getMusics() {
		return Collections.unmodifiableCollection(this.musics);
	}

	public boolean addMusics(Collection<Music> musics) {
		if (musics == null || musics.isEmpty()) {
			throw new NullPointerException("Musics can not be null or empty");
		}

		for (Music music : musics) {
			if (music == null) {
				throw new NullPointerException("Music can not be null");
			}
		}

		return this.musics.addAll(musics);
	}

	public boolean addMusic(Music music) {
		return addMusics(Arrays.asList(music));
	}
}
