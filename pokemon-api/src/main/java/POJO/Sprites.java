package POJO;

import jakarta.persistence.Embeddable;

@Embeddable
public class Sprites{
	
    private String front_default;

    public Sprites() {}

    public String getFrontDefault() {
        return front_default;
    }
}