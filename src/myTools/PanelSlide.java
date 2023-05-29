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
    private Component outgoingCom;
    private Component incomingCom;
    private AnimateType animateType;
    private int speedIncrease = 35;

    public PanelSlide() {

    	GroupLayout gLayout = new GroupLayout(this);
        setLayout(gLayout);
        gLayout.setHorizontalGroup(gLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 10, Short.MAX_VALUE));
        gLayout.setVerticalGroup(gLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 10, Short.MAX_VALUE));

        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent ce) { incomingCom.setSize(getSize()); }
        });

        timer = new Timer(0, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) { animate(); }
        });
    }

    public void show(Component com, AnimateType animateType) {

        if (!timer.isRunning()) {

            this.animateType = animateType;
            incomingCom = com;
            com.setSize(getSize());

            if (getComponentCount() == 0) {

                add(com);
                outgoingCom = com;
                repaint();
                revalidate();

            } else {

                if (animateType == AnimateType.TO_RIGHT) { incomingCom.setLocation(-incomingCom.getWidth(), 0); }

                else { incomingCom.setLocation(getWidth(), 0); }

                add(com);
                repaint();
                revalidate();
                timer.start();
            }
        }
    }

    private void animate() {

        if (animateType == AnimateType.TO_RIGHT) {

            if (incomingCom.getLocation().x < 0) {

                incomingCom.setLocation(incomingCom.getLocation().x + speedIncrease, 0);
                outgoingCom.setLocation(outgoingCom.getLocation().x + speedIncrease, 0);

            } else {

                incomingCom.setLocation(0, 0);
                timer.stop();
                remove(outgoingCom);
                outgoingCom = incomingCom;
            }

        } else {

            if (incomingCom.getLocation().x > 0) {

                incomingCom.setLocation(incomingCom.getLocation().x - speedIncrease, 0);
                outgoingCom.setLocation(outgoingCom.getLocation().x - speedIncrease, 0);

            } else {

                incomingCom.setLocation(0, 0);
                timer.stop();
                remove(outgoingCom);
                outgoingCom = incomingCom;
            }
        }
    }

    public static enum AnimateType { TO_RIGHT, TO_LEFT }
}