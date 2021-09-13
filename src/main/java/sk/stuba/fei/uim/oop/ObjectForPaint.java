package sk.stuba.fei.uim.oop;


import lombok.Getter;
import lombok.Setter;
import java.awt.*;

@Setter
@Getter
public class ObjectForPaint extends Rectangle {
    private int startingX;
    private int endingX;
    private int startingY;
    private int endingY;
    private Color color;
    private int whatToPaint;

    private int middleX;
    private int middleY;


    public ObjectForPaint(int startingX,int startingY, Color color, int whatToPaint) {
        super(startingX-25,startingY-25,50,50);

        this.middleX=startingX;
        this.middleY=startingY;
        this.startingX = startingX-25;
        this.startingY = startingY-25;

        this.color = color;
        this.whatToPaint = whatToPaint;

    }

    public void myPainter(Graphics g){

        if(this.getWhatToPaint()==1){
            g.setColor(this.getColor());
            g.fillOval((this.getStartingX()),(this.getStartingY()),50,(int)33.333333);
            g.fillRect((int)(this.getStartingX()+(16.666667)),(int)(this.getStartingY()+(33.33333)),(int)(16.666667),(int)(16.666667));

        }
        if(this.getWhatToPaint()==2){
            g.setColor(this.getColor());
            g.fillPolygon(new int[]{(int)(startingX+12.5),(int)(startingX+37.5),(startingX+25)},new int[]{startingY+25,(startingY+25),startingY},3);
            g.fillRect((int)(startingX+12.5),startingY+25,25,25);
        }
    }
}
