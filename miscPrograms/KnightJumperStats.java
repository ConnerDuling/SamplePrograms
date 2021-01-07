class KnightJumperStats{

    public static void main(String args[]){
        /*
        *Good morning! Here's your coding interview problem for today.
        *This problem was asked by Two Sigma.
        *A knight is placed on a given square on an 8 x 8 chessboard.
        *It is then moved randomly several times, where each move is a standard knight move.
        *If the knight jumps off the board at any point, however, it is not allowed to jump back on.
        *After k moves, what is the probability that the knight remains on the board?
        */
        
        //Number of jumps you want the sample board to try for each starting square.
        int n = 2;
        
        //Prints out probability between 1 and 0 that the piece would still be on the board if random
        //knight moves are taken, and pieces are allowed to jump off the board.
        for(int i = 0; i < 8; i++){
            System.out.print(" -- ");
            for(int j = 0; j < 8; j++){
                System.out.print(String.format("%.5f", probability(n,i,j))+" -- ");
            }
            System.out.print("\n");
        }
    }

    /**
    *@param k the number of jumps to take
    *@param x the horizontal portion of the board. Can go from 0-7
    *@param y the vertical portion of the board. Can go from 0-7
    *@return a value between 1 and 0 for the probability the knight
    will remain on the board after the given number of k jumps
    */
   static double  probability(int k, int x, int y){
        //If there are zero more jumps to take.
        if(k < 0){
            return 0;
        }
        //If out of bounds, this piece can't move, and so has zero probability of staying on the board.
        //Else, it is on the board, and can make moves.
        if(y < 0 || y > 7 || x < 0 || x > 7){
            return 0;
        }else{
            //If the piece is on the board, and we are at the last recursive jump.
            if(k == 0){
                return 1;
            }
            //Else, get probability of all the other sums with moves still available
            double probabilitySum = 0;
            probabilitySum += probability(k-1,x+1,y+2);
            probabilitySum += probability(k-1,x+2,y+1);
            probabilitySum += probability(k-1,x+1,y-2);
            probabilitySum += probability(k-1,x+2,y-1);
            probabilitySum += probability(k-1,x-1,y+2);
            probabilitySum += probability(k-1,x-2,y+1);
            probabilitySum += probability(k-1,x-1,y-2);
            probabilitySum += probability(k-1,x-2,y-1);

            return (probabilitySum *1.0 / 8);
        }
    }
}
