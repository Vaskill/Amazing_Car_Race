///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package Amazing_Car_Race;
//
//import static Amazing_Car_Race.Gui.XS;
//import static Amazing_Car_Race.Gui.YS;
//import java.awt.Color;
//import java.awt.Component;
//import java.awt.Graphics;
//import java.awt.GridLayout;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import javax.swing.Box;
//import javax.swing.BoxLayout;
//import javax.swing.JButton;
//import javax.swing.JFrame;
//import javax.swing.JPanel;
//
///**
// *
// * @author Evan Vasilauskas
// */
//public class StartScreen extends JFrame {
//    
//    private JFrame start;
//    public JButton startButton;
//    private JPanel buttons;
//     
//    
//    
//   
//    
//    public StartScreen()
//    {
//        
//        start = new JFrame();
//        start.setLayout(new GridLayout());
//        buttons = new JPanel();
//        buttons.setLayout(new BoxLayout(buttons,BoxLayout.PAGE_AXIS));
//        buttons.setSize(800,600);
//        start.setSize(800,600);
//        start.setVisible(true);        
//        startButton = new JButton("Start");        
//        buttons.add(startButton);
//        startButton.setAlignmentX(Component.CENTER_ALIGNMENT);       
//        buttons.add(Box.createVerticalGlue());
//        start.add(buttons);
//        buttons.add(Box.createHorizontalGlue());        
//        ButtonListener bl = new ButtonListener();        
//        startButton.addActionListener(bl);
//       
//        
//    }
//     
//    
//    
//    private class ButtonListener implements ActionListener
//    {
//         Race race = new Race();
//    public void paint(Graphics g) {
//        g.clearRect(0,0,XS,YS);
//        g.setColor(Color.BLACK);
//        race.draw(g);
//    }
//        
//        @Override
//        public void actionPerformed (ActionEvent event){
//            
//            if(event.getSource()== startButton)
//            {
//                JPanel panel = new JPanel();
//                start.setVisible(false);
//                buttons.setVisible(false);
//                Gui c = new Gui();
//                panel.add(c);
//                panel.setVisible(true);
//                while(!race.getOver()){
//                c.repaint();
//                }
//            }
//            
//    }
//     
//    }
//    
//     
//            
//    
//}
