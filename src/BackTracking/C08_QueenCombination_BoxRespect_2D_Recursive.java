package BackTracking;

public class C08_QueenCombination_BoxRespect_2D_Recursive {
    static int count = 0;
    public static void main(String[] args) {
        queenCombinationBoxRespect2DRecCall(new boolean[3][4], 0, 0, 0, 3, "");
    }
    public static void queenCombinationBoxRespect2DRecCall(boolean[][] board, int row, int col, int qpsf, int tq, String ans) {
        //DON'T INTERCHANGE ORDER OF BASE CASES

        //positive base case
        if (qpsf == tq) {
            count++;
            System.out.println(count + ". " + ans);
            return;
        }
//-----------------------------------------
        //Extra recursive call
        if (col == board[0].length) {
            //Changing row to next
            queenCombinationBoxRespect2DRecCall(board, row+1, 0, qpsf, tq, ans);
            return; //this is mandatory as we don't to call place not place for array out of bound
        }
//-----------------------------------------

        //Negative base case
        if (row == board.length) {
            return;
        }
        //Placed
        board[row][col] = true; //Prep
        queenCombinationBoxRespect2DRecCall(board, row, col + 1, qpsf + 1, tq, ans + "{" + row + "-" + col + "}");
        //Undo
        board[row][col] = false;

        //Not placed
        queenCombinationBoxRespect2DRecCall(board, row, col + 1, qpsf, tq, ans);

    }

}