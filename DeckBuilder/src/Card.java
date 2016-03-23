import java.awt.image.BufferedImage;

public class Card {
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
private BufferedImage image;

public Card(String _name, String _attack, String _health, 
		String _rarity, String _mana, String _hero) {
		
		name = _name;
		attack = _attack;
		health = _health;
		rarity = _rarity;
		mana = _mana;
		hero = _hero;
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
public BufferedImage getImage() {
	return image;
}

public void setImage(BufferedImage _image) {
	image = _image;
}
}
