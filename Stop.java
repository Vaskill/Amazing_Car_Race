package Amazing_Car_Race;

//Fred Dolan

//Stops are locations that the cars travel between
import java.util.ArrayList;
import java.awt.Graphics;
import java.util.Random;
import java.awt.Color;
public class Stop extends Location
{
    public Stop(double x, double y, String n)
    {
        super(x,y,n);
    }
    public void draw(Graphics g)
    {
        int xpoints[] = {(int)Math.round(super.getXPos())+0, (int)Math.round(super.getXPos()+10), (int)Math.round(super.getXPos())+5};
        int ypoints[] = {(int)Math.round(super.getYPos())+10, (int)Math.round(super.getYPos())+10, (int)Math.round(super.getYPos())+0};
        g.fillPolygon(xpoints, ypoints, 3);
        g.fillRect(0+(int)Math.round(super.getXPos()), 10+(int)Math.round(super.getYPos()), 10, 10);
        g.drawString(""+super.getName(), (int)Math.round(super.getXPos()), (int)Math.round(super.getYPos()));
    }
    
    //when this is called the stop sends itself back with the command to do the atStop method
    public void doThing(Entity entity)
    {
        entity.atStop(this);
    }
}
