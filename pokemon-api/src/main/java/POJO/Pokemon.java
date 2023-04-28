package POJO;

public class Pokemon {

	private String name;
	private int id;
	private Sprites sprites;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Sprites getSprites() {
		return sprites;
	}

	public void setSprites(Sprites sprites) {
		this.sprites = sprites;
	}



	public class Sprites{
		private String front_default;
		
		public String getFrontDefault() {
            return front_default;
        }
	}
	
	
}
