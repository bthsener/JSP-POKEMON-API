package POJO;

import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Pokemon")
public class Pokemon {
	
	@Id
	private int id;
	private String name;
	@Embedded
	private List<Stats> stats;
	@Embedded
	private Sprites sprites;
	
	
	public Pokemon() {
		super();
	}
	
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

	public List<Stats> getStats() {
        return stats;
    }
    
    public void setStats(List<Stats> stats) {
        this.stats = stats;
    }
	
}

