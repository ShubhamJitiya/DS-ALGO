package BackTracking;

public class C03_QueenCombination {
    static int count = 0;

    public static void main(String[] args) {
        QueenCombination(new boolean[4], 0, 2, "", -1);// or lastBoxUsed 0
    }

    public static void QueenCombination(boolean[] boxes, int qpsf, int tq, String ans, int lastBoxUsed) {
        if (qpsf == tq) {
            count++;
            System.out.println(count + ". " + ans);
            return;
        }
        for (int i = lastBoxUsed+1; i < boxes.length; i++) { //or lastBoxeUsed  - must mention if condn
            boxes[i] = true;
            QueenCombination(boxes, qpsf + 1, tq, ans + "q" + qpsf + "b" + i + " ", i);
            boxes[i] = false; //Undo - Backtracking
        }
    }
}