import java.util.*;
public class Task1{
    public static void main(String args[]){
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++) arr[i]=sc.nextInt();
        int k=sc.nextInt();
        // for rotation of array
        int rot[]=new int[n];
        rot=rotated(arr,k);
        System.out.println("Printing rotated array");
        for(int i:root) System.out.print(i+" ");

        // Printing maximum sum

        int ans=kadanes(arr);
        System.out.println("maximum sum of contigous array" + ans);

    }
    public static void rotated(int arr[], int k){
        int n=arr.length;
        // taking the help of new array
        int ct[]=new int[n];

        // we can use the logic of operator modulus with length n
        // eg. (2+k)%5 -> (2+2)%5==4  ,  (2+4)%5==1
        for(int i=0;i<n;i++){
            ct[(i+k)%n]=arr[i];
        }
        // returning the rotated array
        return ct;
    }

    public static int kadanes(int arr[]){
        int n=arr.length;
        // lets take help of new array dp
        int dp[]=new int[n];
        dp[0]=arr[0];
        // creating currSum variable to keep track of currSum;
        int currSum=arr[0];
        if(currSum<0) currSum=0;
        // edge case
        dp[0]=Math.max(dp[0],currSum);
        for(int i=1;i<n;i++){
            currSum+=arr[i];
            // if currSum becomes negative, then no need of taking that value to add to next subarray, change it to 0;
            if(currSum<0) currSum=0;
            // we can update curr element in dp and currSum;
            dp[i]=Math.max(dp[i-1],currSum);
        }


        // o(1) space

        int maxSum=Integer.MIN_VALUE;
        // maxSum is used for keeping track of previous maxSum values and updation
        maxSum=arr[0];
        currSum=Math.max(currSum,0);
        for(int i=1;i<n;i++){
            // adding continously current elments , which acts as prefix sum
            currSum+=arr[i];

            // if currSum becomes negative, then no need of taking that value to add to next subarray, change it to 0;
            if(curSum<0) currSum=0;

            // updating maxSum with currSum;
            maxSum=Math.max(maxSum,currSum);
        }
        
       // return dp[n-1];
       return maxSum;
    }
}