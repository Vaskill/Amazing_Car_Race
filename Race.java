package Amazing_Car_Race;

//Fred Dolan

//creates and holds all the entities and makes them go
import java.util.ArrayList;
import java.awt.Graphics;
import java.util.Random;
import java.awt.Color;
public class Race
{
    private ArrayList<Car> cars;
    private ArrayList<Stop> stops;
    private ArrayList<Dinosaur> dinos;

    private Random gen;
    private int xSize;
    private int ySize;
    private int maxSpeed;
    private int minSpeed;
    private int nCars;
    private int nStops;
    private int nDinos;
    private boolean over;
    public Race()
    {
        
    }
    public Race(int xSize, int ySize, int minSpeed, int maxSpeed, int nStops, int nCars, int nDinos)
    {
        Setup setup = new Setup();
        over=false;
        gen = new Random();
        
        //add the stops
        stops = new ArrayList<Stop>();
        int index = 0;
        while(index<nStops){
            stops.add(new Stop(gen.nextInt(xSize-200)+100,gen.nextInt(ySize-200)+100, "Stop "+index));
            index++;
        }
        dinos = new ArrayList<Dinosaur>();
        index=0;
        
        //add the dinos
        while(index<nDinos){
            dinos.add(new Dinosaur(gen.nextInt(xSize-200)+100,gen.nextInt(ySize-200)+100, 
            setup.getDinoNames().get(gen.nextInt(setup.getDinoNames().size()))+" "+setup.getDinoNames().get(gen.nextInt(setup.getDinoNames().size()))));
            index++;
        }
        
        //add the cars
        cars = new ArrayList<Car>();
        index = 0;
        while(index<nCars){
            cars.add(new Car(gen.nextInt(xSize-200)+100,gen.nextInt(ySize-200)+100, 
            setup.getFirstNames().get(gen.nextInt(setup.getFirstNames().size()))+" "+setup.getLastNames().get(gen.nextInt(setup.getLastNames().size())), 
            gen.nextInt(maxSpeed-minSpeed)+minSpeed, stops));
            index++;
        }
    }

    public void draw(Graphics g)
    {
        for(Car car: cars)
        {
            car.draw(g);
        }
        for(Stop stop: stops)
        {
            stop.draw(g);
        }
        for(Dinosaur d: dinos)
        {
            d.draw(g);
        }
    }
    
    //checks if there's a winner
    public String findWinner()
    {
        for(Car c:cars)
        {
            if(c.getWinner()==true)
            {
                return c.getName();
            }
        }
        return null;
    }
    
    //makes stuff go if there isn't a winner
    public void go()
    {
        if(findWinner()!=null){
            over=true;
            System.out.println(findWinner()+" has won");
        }
        else{
            for(Dinosaur d: dinos)
            {
                d.go();
            }
            goCars();
        }
    }
    
    //makes the cars check for hazards and react or go normally
    public void goCars()
    {
        for(Car c: cars)
        {
            c.incShutup();
            if(c.checkDinos(dinos)!=null)
            {
                c.flee(c.checkDinos(dinos));
            }
            else
            {
                c.go();
            }
        }
    }

    //is the game still going?
    public boolean getOver()
    {
        return over;
    }
}

