import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;

public class mazeDraw extends JPanel{

    private boolean[][] hWalls;
    private boolean[][] vWalls;
    //the size of the walls drawn, makes the graphics scale
    private double xWallSize;
    private double yWallSize;

    public mazeDraw(boolean[][] hWalls, boolean[][] vWalls){
        this.hWalls = hWalls;
        this.vWalls = vWalls;
        this.xWallSize = 500.0 / hWalls.length;
        this.yWallSize = 500.0 / vWalls[0].length;
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        //cast to Graphics2D so that the line can be made thicker
        Graphics2D g2d = (Graphics2D) g;
        this.setBackground(Color.WHITE);
        g2d.setStroke(new BasicStroke(3));
        g2d.setColor(Color.BLACK);
        //the border
        g2d.drawRect(1,1,499,499);

        //the maze itself
        for(int i=0;i<hWalls[0].length*2+1;i++){
            //vWalls
            if(i%2 == 0) {
                for(int j=0;j<vWalls.length;j++){
                    if(!vWalls[j][i/2]){
                        //draw a wall
                        g2d.draw(new Line2D.Double((j+1) * xWallSize, i/2 * yWallSize, (j+1) * xWallSize, (i/2+1) * yWallSize));
                    }
                }
            }
            //hWalls
            else{
                for(int j=0;j<hWalls.length;j++){
                    if(!hWalls[j][(i-1)/2]){
                        //draw a wall
                        g2d.draw(new Line2D.Double(j*xWallSize, (i/2+1)*yWallSize, (j+1)*xWallSize, (i/2+1)*yWallSize));
                    }

                }
            }
        }
    }
}
