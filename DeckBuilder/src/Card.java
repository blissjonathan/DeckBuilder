import java.awt.image.BufferedImage;

public class Card {
private String id;
private String set;
private String type;
private int cost;
private int dust;
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
private String race;

private boolean hasDeathrattle = false;
private boolean hasTaunt  = false;
private boolean hasBattleCry = false;
private boolean hasSpellDamage = false;


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

public void setRace(String _race) {
	race = _race;
}

public String getRace() {
	return race;
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
	
	if(string.contains("Taunt")) {
		hasTaunt = true;
	}
	if(string.contains("Spell Damage")) {
		hasSpellDamage = true;
	}
	if(string.contains("Deathrattle")) {
		hasDeathrattle = true;
	}
	
	if(string.contains("Battlecry")) {
		hasBattleCry = true;
	}
	
}

public void setSet(String string) {
	set = string;
	
}

public String getSet() {
	return set;
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
	dust = 0;
	if(rarity.equals("Common")) {
		dust = 40;
	}
	if(rarity.equals("Rare")) {
		dust = 100;
	}
	if(rarity.equals("Epic")) {
		dust = 400;
	}
	if(rarity.equals("Legendary")) {
		dust = 1600;
	}
	
}

public int getDust() {
	return dust;
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
