// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.*;
class Main {
    public static void main(String[] args) {
        int arr[] = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.print(lIS(arr));
    }
    
    static int lIS(int arr[]){
        int n = arr.length;
        int dp[][] = new int[n][n+1];
        for(int row[] : dp) Arrays.fill(row, -1);
        return longestIncresingSequence(0, -1, arr, dp);
        
    }
    
    static int longestIncresingSequence(int ind, int pre_ind,int arr[], int dp[][]){
        
        if(ind == arr.length) return 0;
        if(dp[ind][pre_ind+1] != -1) return dp[ind][pre_ind+1];
        int notTake =longestIncresingSequence(ind+1,pre_ind,arr,dp);
        
        int take = 0;
        if(pre_ind == -1 || arr[ind] < arr[pre_ind]) {
          take= 1+longestIncresingSequence(ind+1, ind, arr,dp);
        }
        
        return dp[ind][pre_ind+1] = Math.max(take, notTake);
        
    }
}