package sk.stuba.fei.uim.oop;

import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

@Setter@Getter
public class MyJPanel extends JPanel implements MouseMotionListener, MouseListener {

    private int counterForCollor=0;
    private int whatToPaint=1;
    private Color myJpanelColor;

    private int startingX;
    private int endingX;
    private int startingY;
    private int endingY;
    private int roadCheckerOne;
    private int roadCheckerSecond;


    private JLabel mod;

    ArrayList<ObjectForPaint> objectForPaints = new ArrayList<>();
    ArrayList<LinerDrawer> linerDrawers = new ArrayList<>();

    LinerDrawer linerDrawer;
    ObjectForPaint objectForPaint;

    private ObjectForPaint firstRoader;
    private ObjectForPaint secondRoader;


    MyJPanel(JLabel mod){
        this.mod = mod;
        this.setBackground(Color.WHITE);
        this.myJpanelColor =Color.RED;
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
    }

    @Override
    public void paint(Graphics g) {

        super.paint(g);

        if(this.objectForPaint!=null){
            this.objectForPaint.myPainter(g);
        }
        if(this.linerDrawer!=null){
            this.linerDrawer.linePainter(g);
        }
        for (ObjectForPaint objectForPaint : objectForPaints) {
            objectForPaint.myPainter(g);

        }
        for (LinerDrawer linerDrawer : linerDrawers) {
            linerDrawer.linePainter(g);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        startingX=e.getX();
        startingY=e.getY();
        if(whatToPaint!=3){


            objectForPaint= new ObjectForPaint(startingX,startingY, myJpanelColor,whatToPaint);
            objectForPaints.add(objectForPaint);
            counterForCollor++;
            if(counterForCollor%3==0){
                myJpanelColor=Color.RED;
            }
            if(counterForCollor%3==1){
                myJpanelColor=Color.BLUE;
            }
            if(counterForCollor%3==2){
                myJpanelColor=Color.GREEN;
            }
            this.mod.setBackground(myJpanelColor);
            repaint();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

        startingX=e.getX();
        startingY=e.getY();
        if(whatToPaint==3){
            if(objectForPaints!=null){
                for (ObjectForPaint objectForPaint : objectForPaints) {
                    if(objectForPaint.contains(e.getX(),e.getY())){
                        this.firstRoader=objectForPaint;
                        break;
                    }
                }
            }
        }



    }

    @Override
    public void mouseReleased(MouseEvent e) {
        startingX=e.getX();
        startingY=e.getY();
        if(whatToPaint==3){
            if(objectForPaints!=null){
                for (ObjectForPaint objectForPaint : objectForPaints) {
                    if(objectForPaint.contains(e.getX(),e.getY())){
                        this.secondRoader=objectForPaint;
                        break;
                    }
                }
            }
            if(this.firstRoader.getWhatToPaint()!=this.secondRoader.getWhatToPaint()){
                this.linerDrawers.add(new LinerDrawer(firstRoader.getMiddleX(),firstRoader.getMiddleY(),secondRoader.getMiddleX(),secondRoader.getMiddleY()));
            }
            repaint();
        }
        this.linerDrawer=null;
        repaint();
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if(whatToPaint==3){
            startingX=e.getX();
            startingY=e.getY();
            this.linerDrawer= new LinerDrawer(this.firstRoader.getMiddleX(),this.firstRoader.getMiddleY(),e.getX(),e.getY());
            repaint();
        }

    }

    @Override
    public void mouseMoved(MouseEvent e) {

        this.objectForPaint=new ObjectForPaint(e.getX(),e.getY(),getMyJpanelColor(),whatToPaint);
        if(objectForPaint.getColor()==Color.RED){
            objectForPaint.setColor(new Color(255,0,0,127));
        }
        if(objectForPaint.getColor()==Color.GREEN){
            objectForPaint.setColor(new Color(0,255,0,127));
        }
        if(objectForPaint.getColor()==Color.BLUE){
            objectForPaint.setColor(new Color(0,0,255,127));
        }
        repaint();

    }
}