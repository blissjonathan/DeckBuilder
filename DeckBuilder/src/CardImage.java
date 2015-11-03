import java.awt.image.BufferedImage;

public class CardImage {
private String name;
private BufferedImage image;
	public CardImage(String _name, BufferedImage _image) {
		name = _name;
		image = _image;
	}
	
	public CardImage(String _name) {
		name = _name;
	}
	public BufferedImage getImage() {
		return image;
	}
	
	public String getName() {
		return name;
	}
	
}
