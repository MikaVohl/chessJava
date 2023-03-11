import java.util.Arrays;

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
            if(col == i){
                continue;
            }
            if(positions[row][i] == ' '){
                validMove[row][i] = true;
            }
            else if(currentTurn == true){ // if whites turn
                if(Character.isLowerCase(positions[row][i])){ // if encountering a black piece
                    validMove[row][i] = true;
                }
                break;
            }
            else{
                if(Character.isUpperCase(positions[row][i])){
                    validMove[row][i] = true;
                }
                break;
            }
        }
        for(int i=col; i >= 0; i--){ // check to the left
            if(col == 0) {
                break;
            }
            if(col == i){
                continue;
            }
            if(positions[row][i] == ' '){
                validMove[row][i] = true;
            }
            else if(currentTurn == true){ // if whites turn
                if(Character.isLowerCase(positions[row][i])){
                    validMove[row][i] = true;
                }
                break;
            }
            else{
                if(Character.isUpperCase(positions[row][i])){
                    validMove[row][i] = true;
                }
                break;
            }
        }
        for(int i=row; i >= 0; i--){ // check to the top
            if(row == 0){
                break;
            }
            if(row == i){
                continue;
            }
            if(positions[i][col] == ' '){
                validMove[i][col] = true;
            }
            else if(currentTurn == true){ // if whites turn
                if(Character.isLowerCase(positions[i][col])){
                    validMove[i][col] = true;
                }
                break;
            }
            else{
                if(Character.isUpperCase(positions[i][col])){
                    validMove[i][col] = true;
                }
                break;
            }

        }
        for(int i=row; i <= 7; i++){ // check to the bottom
            if(row == 7){
                break;
            }
            if(i == row){
                continue;
            }
            if(positions[i][col] == ' '){
                validMove[i][col] = true;
            }
            else if(currentTurn == true){ // if whites turn
                if(Character.isLowerCase(positions[i][col])){
                    validMove[i][col] = true;
                }
                break;
            }
            else{
                if(Character.isUpperCase(positions[i][col])){
                    validMove[i][col] = true;
                }
                break;
            }
        }

        return validMove;
    }

    public boolean[][] pawnMove(int row, int col, boolean currentTurn){
        boolean validMove[][] = new boolean[8][8];
        byte edge = 0;
        byte oneOffEdge = 1;
        int oneForward = row - 1;
        int twoForward = row - 2;
        if(!currentTurn){
            edge = 7;
            oneOffEdge = 6;
            oneForward = row + 1;
            twoForward = row + 2;
        }

        if(row == edge){ // if at top of board
            return validMove;
        }
        else if(row == oneOffEdge){ // if second to top of board
            validMove[row-1][col] = true;
            return validMove;
        }
        else if(positions[oneForward][col] == ' '){
            validMove[oneForward][col] = true;
            if(positions[twoForward][col] == ' ' && row == Math.abs(oneOffEdge - 7)){
                validMove[twoForward][col] = true;
            }
        }
        if(col != 0){ // if not on left wall
            if(currentTurn){ // if white
                if(Character.isLowerCase(positions[oneForward][col-1])){ // if black piece diagonal left
                    validMove[oneForward][col-1] = true;
                }
            }else{ // if black
                if(Character.isUpperCase(positions[oneForward][col-1])){ // if white piece diagonal left
                    validMove[oneForward][col-1] = true;
                }
            }
        }
        if(col != 7){
            if(currentTurn){ // if white
                if(Character.isLowerCase(positions[oneForward][col+1])){ // if black piece diagonal left
                    validMove[oneForward][col+1] = true;
                }
            }else{ // if black
                if(Character.isUpperCase(positions[oneForward][col+1])){ // if white piece diagonal left
                    validMove[oneForward][col+1] = true;
                }
            }
        }
        return validMove;
    }

    public boolean[][] choosePiece(int coord1, int coord2, boolean currTurn){
        if(Character.toLowerCase(positions[coord1][coord2]) == 'p')
            return pawnMove(coord1, coord2, currTurn);
        else if(Character.toLowerCase(positions[coord1][coord2]) == 'r')
            return rookMove(coord1, coord2, currTurn);
        return pawnMove(coord1, coord2, currTurn);
    }
}
