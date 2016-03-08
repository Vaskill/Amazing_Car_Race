package Amazing_Car_Race;

//Fred Dolan

//I just didn't want the names cluttering game
import java.util.ArrayList;
public class Setup
{
    private ArrayList<String> firstnames;
    private ArrayList<String> lastnames;
    private ArrayList<String> dinonames;
    public Setup()
    {
        firstnames = new ArrayList<String>();
        firstnames.add("Hank");
        firstnames.add("Dale");
        firstnames.add("Bill");
        firstnames.add("Jeffrey");
        firstnames.add("Frank");
        firstnames.add("Carl");
        firstnames.add("Mittens");
        firstnames.add("Donald");
        firstnames.add("Paula");
        firstnames.add("Susan");
        firstnames.add("Stacy");
        firstnames.add("Enrique");
        firstnames.add("Andrew");
        firstnames.add("Luanne");
        firstnames.add("Dorothy");
        firstnames.add("Sophie");
        firstnames.add("Elizabeth");
        firstnames.add("Montgomery");
        firstnames.add("Lisa");
        firstnames.add("Maggie");
        firstnames.add("Bart");
        lastnames = new ArrayList<String>();
        lastnames.add("Mangione");
        lastnames.add("Hill");
        lastnames.add("Gribble");
        lastnames.add("Boomhauer");
        lastnames.add("Simpson");
        lastnames.add("Jones");
        lastnames.add("Doe");
        lastnames.add("Burns");
        lastnames.add("Ramirez");
        lastnames.add("Tudor");
        lastnames.add("Kennedy");
        lastnames.add("Nguyen");
        lastnames.add("Smith");
        dinonames = new ArrayList<String>();
        dinonames.add("Rawr");
        dinonames.add("Grrrrrrr");
        dinonames.add("Roar");
        dinonames.add("ROAR");
        dinonames.add("ROAAAAAAAAAAAAAAR");
        dinonames.add("GRAUW");
    }
    public ArrayList<String> getFirstNames()
    {
        return firstnames;
    }
    public ArrayList<String> getLastNames()
    {
        return lastnames;
    }
    public ArrayList<String> getDinoNames()
    {
        return dinonames;
    }
}
