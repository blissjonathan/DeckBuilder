import java.awt.image.BufferedImage;

public class Card {
private String id;
private String set;
private String type;
private int mana;
private String name;
private int attack;
private int health;
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
private boolean isGolden;
private String image;

public Card(String _id, String _name, String _set, String _hero, String _type, int _attack, int _health, 
		String _rarity, int _mana, String _img) {
		
		name = _name;
		type = _type;
		attack = _attack;
		health = _health;
		rarity = _rarity;
		mana = _mana;
		hero = _hero;
		id = _id;
		set = _set;
		image = _img;
}

public Card(String _id, String _name, String _set, String _hero, String _type, String _rarity, int _mana, String _img) {
		
		name = _name;
		type = _type;
		rarity = _rarity;
		mana = _mana;
		hero = _hero;
		id = _id;
		set = _set;
		image = _img;
}

public String getName() {
	return name;
}
public int getAttack() {
	return attack;
}
public int getHealth() {
	return health;
}
public String getRarity() {
	return rarity;
}

public String getImage() {
	return image;
}

public void setAttack(int _attack) {
	attack = _attack;
}

public void setHealth(int _health) {
	health = _health;
}

public String toString() {
	return name + ":" + id + ":" + image;
}
}
