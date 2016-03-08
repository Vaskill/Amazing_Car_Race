package Amazing_Car_Race;

//Fred Dolan

//a shell class for movable objects
//this should really all be in Entity shouldn't it?
import java.util.ArrayList;
import java.awt.Graphics;
import java.util.Random;
import java.awt.Color;
public class Movable extends Entity
{
    private double vector;
    private double speed;

    public Movable(double x, double y, String n, int nspeed)
    {
        super(x,y,n);
        vector = 0;
        speed = nspeed;
    }

    //finds the angle that this entity will move at
    public double calcAngle(Entity dest)
    {
        double opp = super.getYPos()-dest.getYPos();
        double adj = super.getXPos()-dest.getXPos();
        double angle = Math.atan(opp/adj);
        if(adj>0)
        {
            return (Math.PI-angle)*-1;
        }
        if(adj<0)
        {
            return angle;
        }
        return angle;
    }

    //moves the entity towards it's destination or does the thing if it's at the destination
    public void moveTo(Entity dest)
    {
        double ang = calcAngle(dest);
        double x = speed*Math.cos(ang);
        double y = speed*Math.sin(ang);
        if(Math.abs(super.getXPos()-dest.getXPos())<speed&&Math.abs(super.getYPos()-dest.getYPos())<speed)
        {
            dest.doThing(this);
        }
        else
        {
            super.setXPos(super.getXPos()+x);
            super.setYPos(super.getYPos()+y);
        }
    }

    //moves the entity away from a target
    public void flee(Entity dest)
    {
        double ang = calcAngle(dest);
        double x = speed*Math.cos(ang);
        double y = speed*Math.sin(ang);

        super.setXPos(super.getXPos()-x);
        super.setYPos(super.getYPos()-y);
    }

    //empty method used in child classes
    public void go(Entity distraction)
    {

    }

    public double getVector()
    {
        return vector;
    }

    public double getSpeed()
    {
        return speed;
    }

    public void setVector(double nVector)
    {
        vector=nVector;
    }

    public void setSpeed(double nSpeed)
    {
        speed = nSpeed;
    }

}
