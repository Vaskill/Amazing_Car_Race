package Amazing_Car_Race;

//Fred Dolan

//its a gui
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Gui extends JFrame{

    private Race race;
    public static int XS;
    public static int YS;
    private JButton sb;
    private JPanel sc;
    private JPanel game;
    private JFrame app;
    private Graphics g;

    public Gui() {
        
         //resolution
        XS = 800;
        YS = 600;
        //creating the race object
        //int xSize, int ySize, int minSpeed, int maxSpeed, int nStops, int nCars, int nDinos
        race = new Race(XS,YS,2,8,5,7,2);
        app = new JFrame();
        app.setSize(800,600);
        sc = new JPanel();
        sc.setLayout(new BoxLayout(sc,BoxLayout.PAGE_AXIS));
        sb = new JButton("Start Game");
        game = new JPanel();
        sc.setSize(800,600);
        sc.setVisible(true);
        app.setVisible(true);
        sb.setVisible(true);
        sb.setAlignmentX(CENTER_ALIGNMENT);
        ButtonListener bl = new ButtonListener();        
        sb.addActionListener(bl);
        game.setSize(XS, YS);
        game.setVisible(true);
        app.add(sc);
        sc.add(sb);
        app.add(game);
        
    }
         private class ButtonListener implements ActionListener{
              
    @Override
              public void actionPerformed (ActionEvent event){
                  if(event.getSource()== sb){
                      sc.setVisible(false);
                      //sb.setVisible(false);
                      //app.setVisible(false);
                      //game.setVisible(true);
                      startGame();
                      
                       g.clearRect(0,0,XS,YS);
                        g.setColor(Color.BLACK);
                         race.draw(g);
                         repaint();
                  }
              }
         }
      
      public void startGame(){  
        int ind = 0;
        while(!race.getOver()){
            race.go();
            try {
                //the tick rate
                Thread.sleep(100);
            } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
                System.out.println("Everything's broken cry");
            }
            repaint();
            ind++;
            //System.out.println(ind);
        }
      }
        
    @Override
    public void paint(Graphics g) {
        g.clearRect(0,0,XS,YS);
        g.setColor(Color.BLACK);
        race.draw(g);
    }

    public static void main(String argv[]) {        
       // StartScreen sc = new StartScreen();
        Gui c = new Gui();
    }
}
