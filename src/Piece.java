public class Piece {

    public char[][] positions = {
            {'r', 'n', 'b', 'q', 'k', 'b', 'n', 'r'},
            {'p', 'p', 'p', 'p', 'p', 'p', 'p', 'p'},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P'},
            {'R', 'N', 'B', 'Q', 'K', 'B', 'N', 'R'}
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

    public boolean[][] rookMove(int row, int col, boolean currentTurn){
        boolean validMove[][] = new boolean[8][8];
        for(int i=col; i <= 7; i++){ // check to the right
            if(col == 7){
                break;
            }
            if(positions[row][i] == ' '){
                validMove[row][i] = true;
            }
            else if(currentTurn == true){ // if whites turn
                if(Character.isLowerCase(positions[row][i])){
                    validMove[row][i] = true;
                    break;
                }
            }
            else{
                if(Character.isUpperCase(positions[row][i])){
                    validMove[row][i] = true;
                    break;
                }
            }
        }
        for(int i=col; i >= 0; i--){ // check to the left
            if(col == 0) {
                break;
            }
            if(positions[row][i] == ' '){
                validMove[row][i] = true;
            }
            else if(currentTurn == true){ // if whites turn
                if(Character.isLowerCase(positions[row][i])){
                    validMove[row][i] = true;
                    break;
                }
            }
            else{
                if(Character.isUpperCase(positions[row][i])){
                    validMove[row][i] = true;
                    break;
                }
            }
        }
        for(int i=row; i >= 0; i--){ // check to the top
            if(row == 0){
                break;
            }
            if(positions[i][col] == ' '){
                validMove[i][col] = true;
            }
            else if(currentTurn == true){ // if whites turn
                if(Character.isLowerCase(positions[i][col])){
                    validMove[i][col] = true;
                    break;
                }
            }
            else{
                if(Character.isUpperCase(positions[i][col])){
                    validMove[i][col] = true;
                    break;
                }
            }

        }
        for(int i=row; i <= 7; i++){ // check to the bottom
            if(row == 7){
                break;
            }
            if(positions[i][col] == ' '){
                validMove[i][col] = true;
            }
            else if(currentTurn == true){ // if whites turn
                if(Character.isLowerCase(positions[i][col])){
                    validMove[i][col] = true;
                    break;
                }
            }
            else{
                if(Character.isUpperCase(positions[i][col])){
                    validMove[i][col] = true;
                    break;
                }
            }
        }
        return validMove;
    }
}
