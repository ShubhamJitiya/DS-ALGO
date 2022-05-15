package BackTracking;

public class C08_QueenCombination_BoxRespect_2D_Manual {
    public static void main(String[] args) {
        queenCombinationBoxRespect2D(new boolean[2][2], 0, 0, 0, 2, "");
    }

    public static void queenCombinationBoxRespect2D(boolean[][] board, int row, int col, int qpsf, int tq, String ans) {
        //DON'T INTERCHANGE ORDER OF BASE CASES

        //positive base case
        if (qpsf == tq) {
            System.out.println(ans);
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
        //Placed
        board[row][col] = true; //Prep
        queenCombinationBoxRespect2D(board, row, col + 1, qpsf + 1, tq, ans + "{" + row + "-" + col + "}");
        //Undo
        board[row][col] = false;

        //Not placed
        queenCombinationBoxRespect2D(board, row, col + 1, qpsf, tq, ans);

    }
}