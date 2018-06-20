import javax.swing.*;
import java.util.Scanner;

public class MazeGen {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int xSize;
        int ySize;
        System.out.println("Give the maze size, at least 2 by 2(x y)");
        xSize = sc.nextInt();
        ySize = sc.nextInt();
        sc.close();
        mazeGenerator Gen = new mazeGenerator(xSize,ySize);
        Gen.generateMaze();
        //drawCLIGraphics(Gen.gethWalls(),Gen.getvWalls());
        drawGrapichs(Gen.gethWalls(),Gen.getvWalls());
    }

    public static void drawGrapichs(boolean[][] hWalls, boolean[][] vWalls){
        JFrame frame = new JFrame ("MazeGen");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mazeDraw m = new mazeDraw(hWalls, vWalls);
        frame.add(m);
        //so that the maze is 500x500, the window is sized like this
        frame.setSize(517,541);
        frame.setVisible(true);
    }

    //obsolete, left it here just because
    public static void drawCLIGraphics(boolean[][] hWalls, boolean[][] vWalls){
        //scales to the size of the maze
        //upper wall
        System.out.print("# ");
        for(int i=2;i<vWalls.length*2+2;i++){
            System.out.print("#");
        }
        System.out.println("#");
        //in between top and bottom
        for(int i=0;i<hWalls[0].length*2+1;i++){
            //vWalls
            if(i%2 == 0) {
                System.out.print("#");
                for(int j=0;j<vWalls.length;j++){
                    if(!vWalls[j][i/2]){
                        System.out.print(" #");
                    }
                    else{
                        System.out.print("  ");
                    }
                }
                System.out.println(" #");
            }
            //hWalls
            else{
                System.out.print("#");
                for(int j=0;j<hWalls.length;j++){
                    if(!hWalls[j][(i-1)/2]){
                        System.out.print("##");
                    }
                    else{
                        System.out.print(" #");
                    }
                }
                System.out.println("");
            }
        }

        //bottom wall
        for(int i=0;i<vWalls.length*2+1;i++){
            System.out.print("#");
        }
        System.out.print(" #");
    }
}
