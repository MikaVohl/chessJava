import java.util.Arrays;

public class CheckChecker {
    public boolean CheckChecker(boolean kingSide, int kingRow, int kingCol){
//        System.out.println(Arrays.deepToString(pieceClass.getPositions()).replace("], ", "]\n").replace("[[", "[").replace("]]", "]"));
        boolean[][] dangerousSquares;
        boolean[][] totalDangerSquares = new boolean[8][8];
        Piece pieceMoves = new Piece();
        // get every array of valid moves from every enemy piece
        for(int i=0; i<=7; i++){ // loop through every row of the board
            for(int j=0; j<=7; j++){ // loop through every column of the board
                dangerousSquares = new boolean[8][8]; // Fills array with false values
                if(Piece.positions[i][j] != ' '){ // if current row and column has something on the board

                    if(kingSide){ // if we are looking for checks on the white king
                        if(Character.isLowerCase(Piece.positions[i][j])){ // if the piece at the current position is black
//                            dangerousSquares = pieceMoves.choosePiece(i, j, false);
                            dangerousSquares = pieceMoves.choosePiece(i, j, false);
                        }
                    }
                    else{ // if we are looking for checks on the black king
                        if(Character.isUpperCase(Piece.positions[i][j])){ // if the piece at the current position is white
//                            dangerousSquares = pieceMoves.choosePiece(i, j, true);
                            dangerousSquares = pieceMoves.choosePiece(i, j, true);
                        }
                    }



//                    System.out.println(Arrays.deepToString(dangerousSquares).replace("], ", "]\n").replace("[[", "[").replace("]]", "]")+"\n");
                    System.out.println(kingRow+"   "+ kingCol);
                    if(dangerousSquares[kingRow][kingCol] == true){
                        System.out.println("King row is "+kingRow+" king col is "+kingCol);
                        if(kingSide)
                            System.out.println("white is in check");
                        else
                            System.out.println("black is in check");
//                        System.out.println(Piece.positions[i][j] +" "+ i +", "+ j);
                        return true;
                    }

                    for(int x=0; x<=7; x++){
                        for(int y=0; y<=7; y++){
                            if(dangerousSquares[x][y] == true)
                                totalDangerSquares[x][y] = true;
                        }
                    }
                }

            }
        }
        if(kingSide)
            System.out.println("Squares that are dangerous for white");
        else
            System.out.println("Squares that are dangerous for black");

        System.out.println(Arrays.deepToString(totalDangerSquares).replace("], ", "]\n").replace("[[", "[").replace("]]", "]")+"\n");

        System.out.println(false);
        return false;
    }
}
