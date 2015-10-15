package eureka.domain.msp;

public class Music {
	private String name;

	public Music(String name) {
		super();
		if (name == null || name.isEmpty()) {
			throw new NullPointerException("Name can not be null or empty");
		}
		this.name = name;
	}

	public String getName() {
		return name;
	}

}
