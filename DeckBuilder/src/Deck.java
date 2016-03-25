import java.util.ArrayList;
import java.util.Collections;

public class Deck {
	private ArrayList<Card> cards = new ArrayList<Card>();
	private final int maxsize = 30;
	private int currentsize = 0;
	private String name;
	private String hero;
	private String archetype;
	private boolean finisher;
	private boolean burst;
	private boolean boarclear;
	private boolean upgrades;
	private boolean tempo;
	private boolean finished;
	
	public Deck(String _name, String _hero) {
		name = _name;
		hero = _hero;
		
	}
	
	public void calcSize() {
		
		for(int i = 0; i<cards.size();i++) {
			currentsize++;
		}
	}
	
	public String getHero() {
		return hero;
	}
	
	public boolean getFinished() {
		return finished;
	}
	
	public String getName() {
		return name;
	}
	
	public ArrayList getAllCards() {
		return cards;
	}
	
	public void addCard(Card _card) {
		if(currentsize<maxsize) {
			cards.add(_card);
			currentsize++;
		}
		
	}
	
	public void removeCard(String name) {
		
		cards.remove(getCard(name));
		
		
	}
	
	public int getSize() {
		return currentsize;
	}
	
	public Card getCard(String name) {
		for(int i = 0; i < cards.size(); i++) {
			if(cards.get(i).getName()==name) {
				return cards.get(i);
			} else {
				return null;
			}
		}
		return null;
	}

	public Boolean add(Card _card) {
		if(Collections.frequency(cards, _card) <= 2 && !(currentsize >= maxsize) && _card != null) {
		cards.add(_card);
		currentsize++;
		return true;
		} else {
			return false;
		}
		
	}

}
