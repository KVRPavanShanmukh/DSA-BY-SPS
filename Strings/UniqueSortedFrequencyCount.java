/*
Problem Statement:
Write a program to find the frequency of characters in a string: This program counts the frequency of characters in a string, i.e., which character is present how many times in the string. 
Note: Print frequency in alphabetical order

Input format :
The input consists of a single string in the first line.

Output format :
The output consists of multiple lines where each line contains a character and its frequency, printed in alphabetical order.
<character> <frequency>

Refer to the sample output for the formatting specifications.

Code constraints :
1 ≤ length of the string ≤ 1000
All characters are lowercase — simplifies the problem (no need to handle uppercase or special chars).

Sample test cases :
Input 1 :
placementseason
Output 1 :
a 2
c 1
e 3
l 1
m 1
n 2
o 1
p 1
s 2
t 1

*/
// You are using Java
// You are using Java
import java.util.*;

public class UniqueSortedFrequencyCount{
    public static void main(String [] args){
        Scanner s = new Scanner(System.in);
        String s1 = s.next();
        
        PriorityQueue<Character> pq = new PriorityQueue<>();    // just for the constraint : sorted o/p
        for(char i : s1.toCharArray()){
            pq.add(i);
        }
        
        HashMap<Character,Integer> hm = new HashMap<>();
        for(char i: s1.toCharArray()){
            hm.put(i,hm.getOrDefault(i,0)+1);
        }
        
        while(!pq.isEmpty()){
            char res = pq.poll();
            if(hm.containsKey(res)){
                int cnt = hm.get(res);
                System.out.println(res+ " " +cnt);
                hm.remove(res);
            }
        }
    }
}

//Sorting takes N*logN time which is less efficient when compared to O(N). So I used a PQ.
// TC : O(N for pq + N for hm);
// SC : O(N for pq + N for hm);