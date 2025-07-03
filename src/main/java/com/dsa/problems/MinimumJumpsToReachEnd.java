package com.dsa.problems;

public class MinimumJumpsToReachEnd {

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
        int minJumps = findMinJumps(arr);
        System.out.println("Minimum jumps to reach the end: " + minJumps);
    }

    private static int findMinJumps(int[] arr) {
        int n = arr.length;
        if (n <= 1) {
            return 0;
        }
        int[] dp = new int[n];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i < n; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                if (j + arr[j] >= i) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }

        if (dp[n - 1] == Integer.MAX_VALUE) {
            System.out.println("Not possible to reach the end");
            return -1;
        } else {
            System.out.println("Minimum jumps to reach the end: " + dp[n - 1]);
            return dp[n - 1];
        }
    }
}
