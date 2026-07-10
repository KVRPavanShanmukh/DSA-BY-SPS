// https://hive.smartinterviews.in/contests/smart-interviews-primary/problems/minimum-cost-to-connect-rods?page=0&pageSize=10&tagFilter=HEAPS

import java.io.*;
import java.util.*;

public class MinCostToConnect2Rods {
    static long a[] = new long[100001];
    static int size = 0;

    public static void insertIntoHeap(long val){
        a[size] = val;
        int curr = size;
        size++;

        while(curr > 0){
            int parent = (curr - 1) / 2;
            if(a[curr] < a[parent]){
                long t = a[curr];
                a[curr] = a[parent];
                a[parent] = t;

                curr = parent;
            }else{
                break;  //bcz it isn't CBT
            }
        }
    }
    
    public static long DeleteMin(){
        if(size == 0)   return -1;

        long eleToDel = a[0];
        a[0] = a[size - 1];
        size--;

        int curr = 0;
        while(true){
            int lc = 2*curr+1;
            int rc = 2*curr+2;

            int smallest = curr;
            if(lc < size && a[lc] < a[smallest]){
                smallest = lc;
            }
            if(rc < size && a[rc] < a[smallest]){
                smallest = rc;
            }
            if(smallest == curr){
                break;
            }
            
            long t = a[curr];
            a[curr] = a[smallest];
            a[smallest] = t;

            curr = smallest;
        }
        return eleToDel;
    }

    public static long minCost(){
        long totalCost = 0;
        long cost = 0;

        while(size > 1){
            long cost1 = DeleteMin();
            long cost2 = DeleteMin();
            
            cost = cost1 + cost2;
            totalCost += cost;
            
            insertIntoHeap(cost);
        }
        return totalCost;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            int n = Integer.parseInt(br.readLine());
            size = 0;   //size should reset at every test case level.
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            long a[] = new long[n];
            for(int i = 0;i < n;i++){
                long val = Long.parseLong(st.nextToken());
                insertIntoHeap(val);
            }
            sb.append(minCost()).append("\n");
        }
        System.out.println(sb);
    }
}