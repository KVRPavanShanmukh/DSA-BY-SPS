
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Problem Statement: There is one meeting room in a firm. You are given two arrays, start and end each of size N. For an index ‘i’, start[i] denotes the starting time of the ith meeting while end[i] will denote the ending time of the ith meeting. Find the maximum number of meetings that can be accommodated if only one meeting can happen in the room at a particular time. Print the order in which these meetings will be performed.
Input: N = 6,  start[] = {1,3,0,5,8,5}, end[] =  {2,4,5,7,9,9}
Output: [1, 2, 4, 5]
Explanation: These meeting can be conducted in the room.*/
public class N_Meets_One_Room {

    public static void main(String[] args) {
        int TotalMeets = 6;
        int st[] = {1, 3, 0, 5, 8, 5}, en[] = {5, 2, 4, 7, 6, 9};
        List<Integer> ls = new ArrayList<>();
        int lastOccTime = 0;

        Arrays.sort(en);    //Sort meetings by end time so that the ones that finish earliest are considered first.

        for (int i = 0; i < TotalMeets; i++) {
            if (st[i] > lastOccTime) {
                ls.add(i);
                lastOccTime = en[i];
            }
        }

        System.err.print(
                "Meetings order is : ");
        for (int i : ls) {
            System.err.print((i + 1) + " ");
        }
    }
}
