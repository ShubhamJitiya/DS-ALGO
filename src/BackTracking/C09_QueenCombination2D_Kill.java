package BackTracking;

public class C09_QueenCombination2D_Kill {
    static int count = 1;

    public static void main(String[] args) {
        queenCombinationBoxRespect2DKill(new boolean[8][8], 0, 0, 0, 8, "");
    }

    public static void queenCombinationBoxRespect2DKill(boolean[][] board, int row, int col, int qpsf, int tq, String ans) {
        //DON'T INTERCHANGE ORDER OF BASE CASES

        //positive base case
        if (qpsf == tq) {
            System.out.println(count + ". " + ans);
            count++;
            return;
        }
//-----------------------------------------
        //Manually variables changes
        if (col == board[0].length) {
            //Changing row to next
            row++;
            col = 0;
            //return;
        }
//-----------------------------------------

        //Negative base case
        if (row == board.length) {
            return;
        }
        //Place only if it is safe
        if (isItSafeToPlaceTheQueen(board, row, col)) {
            board[row][col] = true; //Prep
            queenCombinationBoxRespect2DKill(board, row, col + 1, qpsf + 1, tq, ans + "{" + row + "-" + col + "}");
            //Undo
            board[row][col] = false;
        }

        //Not placed
        queenCombinationBoxRespect2DKill(board, row, col + 1, qpsf, tq, ans);

    }

    private static boolean isItSafeToPlaceTheQueen(boolean[][] board, int row, int col) {

        //vertically upward
        int r = row - 1;
        int c = col;

        while (r >= 0) {
            if (board[r][c]) {
                return false; //not safe
            }
            r--;
        }

        //Horizontal left
        r = row;
        c = col - 1;

        while (c >= 0) {
            if (board[r][c]) {
                return false;
            }
            c--;
        }

        //Diagonally left
        r = row - 1;
        c = col - 1;
        while (r >= 0 && c >= 0) {
            if(board[r][c])
            {
                return false;
            }
            r--;
            c--;
        }

        //Diagonally right
        r = row - 1;
        c = col + 1;
        while (r >= 0 && c < board[0].length) {
            if(board[r][c])
            {
                return false;
            }
            r--;
            c++;
        }

        return true; //If control comes here - i.e safe to place NO DANGER
    }
}