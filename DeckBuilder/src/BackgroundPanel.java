import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

class BackgroundPanel extends JPanel
{
  Image image;
  public BackgroundPanel(Image _image)
  {
    try
    {
      image = _image;
    }
    catch (Exception e) { /*handled in paintComponent()*/ }
  }
 
  @Override
  protected void paintComponent(Graphics g)
  {
    super.paintComponent(g); 
    if (image != null)
      g.drawImage(image, 0,0,this.getWidth(),this.getHeight(),this);
  }
}