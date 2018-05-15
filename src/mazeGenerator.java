import java.util.Random;

public class mazeGenerator {
    private boolean[][] hWalls;
    private boolean[][] vWalls;
    private boolean[][] pathTaken;
    private Random rnd;

    public mazeGenerator(int xSize, int ySize){
        //x,y
        this.pathTaken = new boolean[xSize+2][ySize+2];
        this.hWalls = new boolean[xSize][ySize-1];
        this.vWalls = new boolean[xSize-1][ySize];
        this.rnd = new Random();

        //set up the pathTaken variable to have edges
        for(int i=0;i<pathTaken[0].length;i++){
            pathTaken[0][i] = true;
            pathTaken[ySize+1][i] = true;
        }
        for(int i=0;i<pathTaken.length;i++){
            pathTaken[i][0] = true;
            pathTaken[i][xSize+1] = true;
        }
    }

    //generate the maze
    public void generateMaze(){
        backtracker(1,1);
    }

    public boolean[][] gethWalls(){
        return hWalls;
    }

    public boolean[][] getvWalls(){
        return vWalls;
    }

    //the recursive method for creating the maze
    private void backtracker(int XPos, int YPos){
        pathTaken[XPos][YPos] = true;
        //System.out.println(XPos +  " " + YPos);
        //ugly while(true) loop
        while (true) {
            //if no unvisited neighbours, return
            if (pathTaken[XPos + 1][YPos] && pathTaken[XPos - 1][YPos] && pathTaken[XPos][YPos + 1] && pathTaken[XPos][YPos - 1]) {
                return;
            }
            //else move to random unvisited neighbour
            else {
                int direction = rnd.nextInt(4);

                //0 up, 1 right, 2 down, 3 left
                //move to a neighbour and break the wall between the cells
                switch(direction){
                    //hWall breaks
                    case 0: if(!pathTaken[XPos][YPos - 1]){
                        hWalls[XPos-1][YPos-2] = true;
                        backtracker(XPos, YPos-1);
                        continue;
                    }
                    //vWall breaks
                    case 1: if(!pathTaken[XPos+1][YPos]){
                        vWalls[XPos-1][YPos-1] = true;
                        backtracker(XPos+1, YPos);
                        continue;
                    }
                        //hWall breaks
                    case 2: if(!pathTaken[XPos][YPos + 1]){
                        hWalls[XPos-1][YPos-1] = true;
                        backtracker(XPos, YPos+1);
                        continue;
                    }
                    //vWall breaks
                    case 3: if(!pathTaken[XPos-1][YPos]){
                        vWalls[XPos-2][YPos-1] = true;
                        backtracker(XPos-1, YPos);
                        continue;
                    }

                }
            }
        }
    }

    //for debug
    private void printPathTaken(){
        for(int i=0;i<pathTaken.length;i++){
            for(int j=0;j<pathTaken[0].length;j++){
                if(pathTaken[i][j]) System.out.print("1");
                else System.out.print("0");
            }
            System.out.println("");
        }
    }
}
