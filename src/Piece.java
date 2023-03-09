public class Piece {

    public char[][] positions = {
            {'r', 'n', 'b', 'q', 'k', 'b', 'n', 'r'},
            {'p', 'p', 'p', 'p', 'p', 'p', 'p', 'p'},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P'},
            {'R', 'N', 'B', 'Q', 'K', 'B', 'N', 'R'},
    };

    public void makeMove(int initial1, int initial2, int next1, int next2){
        positions[next1][next2] = positions[initial1][initial2];
        positions[initial1][initial2] = ' ';
    }


    public boolean isValidFirst(int clickCoordRow, int clickCoordCol, boolean currentTurn){
        // First click is invalid if clicking on whitespace, the wrong color piece
        char currentPiece = positions[clickCoordRow][clickCoordCol];
        if(currentPiece == ' ')
            return false;
        else if(currentTurn){ // if white's turn
            if(Character.isLowerCase(currentPiece)){
                return false;
            }
        }
        else{ // if black's turn
            if(Character.isUpperCase(currentPiece)){
                return false;
            }
        }
        return true;
    }

}
