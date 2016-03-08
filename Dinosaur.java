package Amazing_Car_Race;

//Fred Dolan

//Dinosaurs wander aimlessly and scare cars
import java.util.ArrayList;
import java.awt.Graphics;
import java.util.Random;
import java.awt.Color;
public class Dinosaur extends Movable
{
    private float xDest;
    private float yDest;
    private Entity dest;
    private int index;
    private boolean pause;
    private int duration;
    
    public Dinosaur(int x, int y, String n)
    {
        super(x,y,n,4);
        dest = findDest();
    }

    public void draw(Graphics g)
    {
        int x = (int)Math.round(super.getXPos());
        int y = (int)Math.round(super.getYPos());
        g.setColor(Color.green);
        g.fillOval(0+x, 0+y, 9, 7);
        g.fillRect(5+x, 5+y, 4, 12);
        g.fillOval(4+x, 10+y, 25, 12);
        g.fillRect(6+x, 18+y, 5, 9);
        g.fillRect(23+x, 18+y, 5, 9);
    }

    //finds a new random point on the field and makes sure the duration isn't more than the time to reach that destination
    public Entity findDest()
    {
        Random gen = new Random();
        double x = gen.nextInt(Gui.XS);
        double y = gen.nextInt(Gui.YS);
        Entity dest = new Entity(x, y, "");
        duration = gen.nextInt((int)Math.round(super.calcDistance(dest)/super.getSpeed())+1);
        return dest;
    }

    public void go()
    {
        Random gen=new Random();
        //The dino pauses after it reaches a destination for a short time
        if(pause)
        {
            if(index<duration)
            {
                index++;
            }
            else
            {
                index = 0;
                dest = findDest();
                pause = false;
            }
        }
        else
        {
            if(index<duration)
            {
                super.moveTo(dest);
                index++;
            }
            else
            {
                pause = true;
                index = 0;
                duration = gen.nextInt(20);
            }
        }
    }
}
