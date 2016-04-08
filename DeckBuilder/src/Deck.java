import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

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
	private boolean aoe;
	private boolean upgrades;
	private boolean tempo;
	private boolean finished;
	private int dust = 0;
	private String type = null;
	
	
	private int tempoCount = 0;
	private int finisherCount = 0;
	private int aoeCount = 0;
	private int burstCount = 0;
	private int drawCount = 0;
	
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
		if(Collections.frequency(cards, _card) < 2 && currentsize < maxsize && _card != null
				&& !(_card.getRarity().equals("Legendary"))) {
		cards.add(_card);
		currentsize++;
		dust = dust + _card.getDust();
		sortCards();
		return true;
		} else if(!(cards.contains(_card)) && _card.getRarity().equals("Legendary")) {
			cards.add(_card);
			currentsize++;
			dust = dust + _card.getDust();
			sortCards();
			return true;
		} else {
			return false;
		}
	}
	
	public void setType() {
		
	}
	
	public String getType() {
		return type;
	}
	
	public int getDust() {
		return dust;
	}
	
	public boolean hasBurst() {
		if(burstCount > 0 ) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean hasDraw() {
		if(drawCount > 0 ) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean hasFinisher() {
		if(finisherCount > 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean hasTempo() {
		if(tempoCount > 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean isComplete() {
		if(currentsize==30) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean hasAOE() {
		if(aoeCount > 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public String getFormat() {
		return format;
	}
	
	public String toString() {
		String deckStr = "DECK|";
		
		deckStr = deckStr + name + "|" + hero;
		
		for(int i = 0; i < cards.size(); i++) {
			deckStr = deckStr + "|" + cards.get(i).getName();
		}
		return deckStr;
	}
	
	public void sortCards() {
		Collections.sort(cards, new Comparator<Card>() {
	        @Override public int compare(Card c1, Card c2) {
	            return c1.getCost() - c2.getCost(); // Ascending
	        }	
	    });
		
	}

}
