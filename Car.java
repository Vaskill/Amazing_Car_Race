package Amazing_Car_Race;

//Fred Dolan

//The cars travel from stop to stop in a random order until they have been to them all, at which point they win
import java.util.ArrayList;
import java.awt.Graphics;
import java.util.Random;
import java.awt.Color;
public class Car extends Movable
{
    //the stops this car has been to
    private ArrayList<Stop> visited;
    //all the stops
    private ArrayList<Stop> stops;
    //the stop this care is currently travelling to
    private Stop destination;
    //has this car won
    private boolean winner;
    //a timer to avoid message spam
    private int shutup;
    //colors
    int red;
    int green;
    int blue;

    public Car(double x, double y, String n, int nspeed, ArrayList<Stop> nStops)
    {
        super(x,y,n,nspeed);
        stops = nStops;
        visited = new ArrayList<Stop>();
        destination = findStop();

        //colors
        Random gen = new Random();
        red = gen.nextInt(256);
        green = gen.nextInt(256);
        blue = gen.nextInt(256);
    }

    @Override
    public void draw(Graphics g)
    {
        int x = (int)Math.round(super.getXPos());
        int y = (int)Math.round(super.getYPos());
        g.setColor(Color.black);
        g.fillOval(0+x, 5+y, 5, 5);
        g.fillOval(10+x, 5+y, 5, 5);
        g.setColor(new Color(red, green, blue));
        g.fillRect(2+x, 0+y, 10, 5);
        g.setColor(Color.black);
    }

    //moves the car towards the destination
    public void go()
    {
        moveTo(destination);
    }
    
    //adds the current stop to the visited array and finds a new destination
    @Override
    public void atStop(Stop stop)
    {
        visited.add(stop);
        destination=findStop();
    }

    //checks to see if a dino is near and returns the nearby dino
    public Dinosaur checkDinos(ArrayList<Dinosaur> dinos)
    {
        for(Dinosaur d:dinos)
        {
            if(d.calcDistance(this)<100)
            {
                if(shutup>10)
                {
                    System.out.println(d.getName()+" has scared "+super.getName());
                    shutup=0;
                }
                return d;
            }
        }
        return null;
    }

    //finds an unvisited stop and returns it; sets the car to winner if all stops are visited
    public Stop findStop()
    {
        Random gen = new Random();
        boolean done = false;

        if(stops.size()==visited.size()){
            winner=true;
        }
        else{
            while(!done)
            {
                int index = gen.nextInt(stops.size());

                if(!visited.contains(stops.get(index)))
                {
                    done=true;
                    System.out.println(super.getName()+" next destination is "+stops.get(index).getName());
                    return stops.get(index);
                }
                else
                {
                    done=false;
                }
            }
        }
        int index = gen.nextInt(stops.size());
        return stops.get(index);
    }
    
    //increments the shutup timer
    public void incShutup()
    {
        shutup+=1;
    }

    public boolean getWinner()
    {
        return winner;
    }

    public Stop getDestination()
    {
        return destination;
    }

    public ArrayList<Stop> getVisited()
    {
        return visited;
    }
}
