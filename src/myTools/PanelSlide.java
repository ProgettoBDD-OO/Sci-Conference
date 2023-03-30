package myTools;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.GroupLayout;
import javax.swing.JPanel;
import javax.swing.Timer;

public class PanelSlide extends JPanel {

	private final Timer timer;
    private Component comExit;
    private Component comShow;
    private AnimateType animateType;
    private int animate = 20;
	
    public PanelSlide() {
    	
    	GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 319, Short.MAX_VALUE));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 192, Short.MAX_VALUE));
        
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent ce) { comShow.setSize(getSize()); }

        });
        
        timer = new Timer(0, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) { animate(); }
        });
    }

    public void show(Component com, AnimateType animateType) {
    	
        if (!timer.isRunning()) {
        	
            this.animateType = animateType;
            this.comShow = com;
            com.setSize(getSize());
            
            if (getComponentCount() == 0) {
            	
                add(com);
                comExit = com;
                repaint();
                revalidate();
                
            } else {

                if (animateType == AnimateType.TO_RIGHT) { comShow.setLocation(-comShow.getWidth(), 0); }
                
                else { comShow.setLocation(getWidth(), 0); }
                add(com);
                repaint();
                revalidate();
                timer.start();
            }
        }
    }

    private void animate() {
    	
        if (animateType == AnimateType.TO_RIGHT) {
        	
            if (comShow.getLocation().x < 0) {
                comShow.setLocation(comShow.getLocation().x + animate, 0);
                comExit.setLocation(comExit.getLocation().x + animate, 0);
            } else {
                //  Stop animate
                comShow.setLocation(0, 0);
                timer.stop();
                remove(comExit);
                comExit = comShow;
            }
            
        } else {
        	
            if (comShow.getLocation().x > 0) {
                comShow.setLocation(comShow.getLocation().x - animate, 0);
                comExit.setLocation(comExit.getLocation().x - animate, 0);
            } else {
                comShow.setLocation(0, 0);
                timer.stop();
                remove(comExit);
                comExit = comShow;
            }
        }
    }

    public static enum AnimateType { TO_RIGHT, TO_LEFT }
}