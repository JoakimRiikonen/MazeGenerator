public class MazeGen {

    public static void main(String[] args){
        mazeGenerator Gen = new mazeGenerator(10,10);
        Gen.generateMaze();
        drawMaze(Gen.gethWalls(),Gen.getvWalls());
    }



    public static void drawMaze(boolean[][] hWalls, boolean[][] vWalls){
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
