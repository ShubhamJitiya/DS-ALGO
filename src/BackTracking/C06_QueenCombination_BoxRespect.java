package BackTracking;

public class C06_QueenCombination_BoxRespect {
    static int count = 0;

    public static void main(String[] args) {
        queenCombinationBoxRespect(new boolean[4], 0, 0, 2, "");
    }

    public static void queenCombinationBoxRespect(boolean[] board, int col, int qpsf, int tq, String ans)
    {
        //DON'T INTERCHANGE ORDER OF BASE CASES

        //positive base case
        if(qpsf == tq)
        {
            System.out.println(ans);
            return;
        }

        //negative base case
        if (col == board.length) {
            return;
        }

        //Placed
        board[col] = true; //Prep
        queenCombinationBoxRespect(board, col+1, qpsf+1, tq, ans + "b" + col);
        //Undo
        board[col] = false;

        //Not placed
        queenCombinationBoxRespect(board, col+1, qpsf, tq, ans);

    }
}