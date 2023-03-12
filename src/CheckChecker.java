import java.util.Arrays;

public class CheckChecker {
    public boolean CheckChecker(char[][] piecePositions, boolean kingSide, int kingRow, int kingCol){
        boolean inDanger = false;
        boolean[][] dangerousSquares = new boolean[8][8];
        Piece pieceMoves = new Piece();

        // get every array of valid moves from every enemy piece
        for(int i=0; i<=7; i++){
            for(int j=0; j<=7; j++){
                char currentPiece = piecePositions[i][j];
                dangerousSquares = new boolean[8][8];
                // if kingSide is true, checking if white is in check
                // if kingSide is false, checking if black is in check
                if(kingSide){ // if white king is being checked
                    if(currentPiece == 'p'){
                        dangerousSquares = pieceMoves.pawnMove(i, j, kingSide);
                    }
                    else if(currentPiece == 'n'){
                        dangerousSquares = pieceMoves.knightMove(i, j, kingSide);
                    }
                    else if(currentPiece == 'r'){
                        dangerousSquares = pieceMoves.rookMove(i, j, kingSide);
                    }
                    else if(currentPiece == 'q'){
                        dangerousSquares = pieceMoves.queenMove(i, j, kingSide);
                    }
                    else if(currentPiece == 'b'){
                        dangerousSquares = pieceMoves.bishopMove(i, j, kingSide);
                    }
                    else if(currentPiece == 'k'){
                        dangerousSquares = pieceMoves.kingMove(i, j, kingSide);
                    }
                }
                else{
                    if(currentPiece == 'P'){
                        dangerousSquares = pieceMoves.pawnMove(i, j, kingSide);
                    }
                    else if(currentPiece == 'N'){
                        dangerousSquares = pieceMoves.knightMove(i, j, kingSide);
                    }
                    else if(currentPiece == 'R'){
                        dangerousSquares = pieceMoves.rookMove(i, j, kingSide);
                    }
                    else if(currentPiece == 'Q'){
                        dangerousSquares = pieceMoves.queenMove(i, j, kingSide);
                    }
                    else if(currentPiece == 'B'){
                        dangerousSquares = pieceMoves.bishopMove(i, j, kingSide);
                    }
                    else if(currentPiece == 'K'){
                        dangerousSquares = pieceMoves.kingMove(i, j, kingSide);
                    }
                }
                if(dangerousSquares[kingRow][kingCol] == true){
                    System.out.println(true);
                    return true;
                }
            }
        }
        System.out.println(false);
        return false;
    }
}
