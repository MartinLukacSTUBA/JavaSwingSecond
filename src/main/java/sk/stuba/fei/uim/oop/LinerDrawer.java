package sk.stuba.fei.uim.oop;

import lombok.Getter;
import lombok.Setter;

import java.awt.*;

@Setter@Getter
public class LinerDrawer {

    private int startingX;
    private int startingY;
    private int endingX;
    private int endingY;

    public LinerDrawer(int startingX, int startingY, int endingX, int endingyY) {
        this.startingX = startingX;
        this.startingY = startingY;
        this.endingX = endingX;
        this.endingY = endingyY;
    }

    public void linePainter(Graphics g){
        g.setColor(Color.BLACK);
        g.drawLine(startingX,startingY,endingX, endingY);
    }
}
