package Amazing_Car_Race;

//Fred Dolan

//Entity class holds an x and y position, a method to calculate distance, 
//and a few methods to enable communication between different entities
import java.util.ArrayList;
import java.awt.Graphics;
import java.util.Random;
import java.awt.Color;
public class Entity
{
    private double xPos;
    private double yPos;
    private String name;
    private int state;

    public Entity(double x, double y, String n){
        xPos=x;
        yPos=y;
        name=n;
    }
    
    public void draw(Graphics g)
    {
        
    }
    
    //pythagorean theorem to find distance from another entity
    public double calcDistance(Entity ent)
    {
        return Math.abs(Math.sqrt(((xPos-ent.getXPos())*(xPos-ent.getXPos()))+((yPos-ent.getYPos())*(yPos-ent.getYPos()))));
    }
    
    //empty method used in child classes
    //this method will be activated from another entity passing that entity as a parameter
    public void doThing(Entity entity)
    {
        
    }
    
    //empty method used in child classes
    //this is called when the entity is at a stop
    public void atStop(Stop stop)
    {
        
    }
    
    public double getXPos()
    {
        return xPos;
    }
    public double getYPos()
    {
        return yPos;
    }
    public String getName()
    {
        return name;
    }
    public int getState()
    {
        return state;
    }
    
    public void setXPos(double x)
    {
        xPos = x;
    }
    public void setYPos(double y)
    {
        yPos = y;
    }
    public void setState(int nState)
    {
        state=nState;
    }
    
        public int hashCode()
    {
        int x = 1;
        x+=xPos*5;
        x+=yPos*7;
        x+=name.hashCode()*3;
        return x;
    }
    public boolean equals(Object o)
    {
        return o.hashCode()==this.hashCode();
    }
}
