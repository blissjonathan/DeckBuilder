import java.util.ArrayList;
import java.util.Collections;

public class Deck {
	private ArrayList<Card> cards = new ArrayList<Card>();
	private final int maxsize = 30;
	private int currentsize = 0;
	private String format;
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
	
	public Deck() {
		
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
	
	public ArrayList<Card> getAllCards() {
		return cards;
	}
	
	
	public void removeCard(String name) {
		cards.remove(getCard(name));
		currentsize--;
		sortCards();
	}
	
	public int getSize() {
		return currentsize;
	}
	

	public void setFormat(String _format) {
		format = _format;
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
	
	public void setName(String _name) {
		name = _name;
	}
	
	public void setHero(String _hero) {
		hero = _hero;
	}

	public Boolean addCard (Card _card) {
		if(Collections.frequency(cards, _card) < 2 && currentsize <= maxsize && _card != null) {
		cards.add(_card);
		currentsize++;
		sortCards();
		return true;
		} else {
			return false;
		}
		
	}
	
	public void sortCards() {
		Card curCard =null;
		for(int i = 0; i < cards.size();i++) {
			if(i !=0) {
			if(cards.get(i-1).getMana() > cards.get(i).getMana()) {
				Card tempCard = cards.get(i);
				cards.set(i, cards.get(i-1));
				cards.set(i-1, tempCard);
			}
			}
		}
		
	}

}
