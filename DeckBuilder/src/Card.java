import java.awt.image.BufferedImage;

public class Card {
private String id;
private String set;
private String type;
private String mana;
private String name;
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
private boolean isGolden;
private String image;

public Card(String _id, String _name, String _set, String _hero, String _type, String _attack, String _health, 
		String _rarity, String _mana, String _img) {
		
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

public Card(String _id, String _name, String _set, String _hero, String _type, String _rarity, String _mana, String _img) {
		
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
public String getAttack() {
	return attack;
}
public String getHealth() {
	return health;
}
public String getRarity() {
	return rarity;
}
public String getMana() {
	return mana;
}

public String toString() {
	return name + id;
}
}
