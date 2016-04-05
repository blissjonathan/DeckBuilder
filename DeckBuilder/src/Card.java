import java.awt.image.BufferedImage;

public class Card {
private String id;
private String set;
private String type;
private int cost;
private String name;
private String text;
private String attack;
private String health;
private String flavor;
private String rarity;
private String hero;
private boolean draw;
private boolean spellpower;
private boolean finisher;
private boolean burst;
private boolean buff;
private boolean nerf;
private boolean aoe;
private String image;
private String fileName;

public Card(String _id, String _name, String _set, String _hero, String _type, String _attack, String _health, 
		String _rarity, String _mana) {
		
		name = _name;
		type = _type;
		attack = _attack;
		health = _health;
		rarity = _rarity;
		hero = _hero;
		id = _id;
		set = _set;
}

public Card(String _id, String _name, String _set, String _hero, String _type, String _rarity, String _mana, String _img) {
		
		name = _name;
		type = _type;
		rarity = _rarity;
		hero = _hero;
		id = _id;
		set = _set;
		image = _img;
}

public Card() {
}

public String getName() {
	return name;
}

public String getHero() {
	return hero;
}
public String getAttack() {
	return attack;
}
public String getHealth() {
	return health;
}
public String getRarity() {
	return rarity;
}

public String getImage() {
	return image;
}

public String getType() {
	return type;
}

public String getID() {
	return id;
}

public int getCost() {
	return cost;
}


public void setHealth(int _health) {
	attack = String.valueOf(_health);

}

public String toString() {
	return name + ":" + hero + ":" + id + ":" + image;
}

public void setHero(String _hero) {
hero = _hero;
	
}

public void setID(String string) {
	id = string;
	
}

public void setName(String string) {
name = string;
	
}

public void setType(String string) {
type = string;
	
}

public void setText(String string) {
	text = string;
	
}

public void setSet(String string) {
	set = string;
	
}

public void setAttack(int string) {
	attack = String.valueOf(string);
	
}

public void setImg(String string) {
	image = string;
	
}

public void setCost(int string) {
	cost = string;

}

public void setRarity(String string) {
	rarity =  string;
	
}

public boolean hasImage() {
	Boolean hasimg;
	
	if(image != null) {
		hasimg = true;
	} else {
		hasimg = false;
	}
	
	return hasimg;
}


}
