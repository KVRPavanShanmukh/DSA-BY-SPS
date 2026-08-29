/*
BishopJourney:

There is an 8 x 8 empty chessboard with 1-indexed rows and columns.
You are given an array source = [sr, sc] representing the starting position of a bishop, and an array target = [tr, tc]. In one move, the bishop travels any number of squares along a single diagonal direction, staying within the board.
Return the minimum number of moves for the bishop to land exactly on target. If it can never reach target, return -1.
Example 1:
Input: source = [8,1], target = [1,8]
Output: 1

Explanation:
A single diagonal move takes the bishop straight from (8, 1) to (1, 8).©leetcode
 */
public class BishopJourney {

    public int minBishopMoves(int[] s, int[] t) {
        int srow = s[0];
        int scol = s[1];

        int trow = t[0];
        int tcol = t[1];

        if (srow == trow && scol == tcol) {
            return 0;
        }
        if ((srow + scol) % 2 != (trow + tcol) % 2) {
            return -1;
        }
        if (Math.abs(srow - trow) == Math.abs(scol - tcol)) {
            return 1;
        }
        return 2;
    }
}
