/*
Painting Houses:
There is a line of houses, where each house can be painted with one of the three colors: red, green and blue. The cost of painting each house with a certain color is different. Find the minimum cost to paint all the houses such that no two adjacent house have the same color.

Input Format
The first line of input contains T - number of test cases. It's followed by 4T lines, the first line contains N - number of houses and the second, third and fourth line contains the costs of each house for red, green and blue respectively.
Output Format
For each test case, print the minimum cost, separated by new line.

Constraints
1 <= T <= 100
1 <= N <= 103
1 <= R[i], G[i], B[i] <= 103

Example
Input
1
6
7 3 8 6 1 2
5 6 7 2 4 3
10 1 4 9 7 6

Output
18

Explanation
7 '3' 8 6 '1' 2 
'5' 6 7 '2' 4 '3' 
10 1 '4' 9 7 6

Min cost: 
H-> House
H1 with Green, H2 with Red, H3 with Blue, H4 with Green, H5 with Red, H6 with Green
Overall cost: 5+3+4+2+1+3 = 18
 */

public class PaintingHouses {

    //{Current Choice Cost} + {Min/Max of all valid previous states that don't violate the rule}.
    public static void main(String[] args) {

    }
}
