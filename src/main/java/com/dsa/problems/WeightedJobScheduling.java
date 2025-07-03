package com.dsa.problems;

import java.util.Arrays;

public class WeightedJobScheduling {

    public static int getMaximumProfit(int[][] jobs) {
        int length = jobs.length;
        int[] dp = new int[length];
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        int result = 0;
        for (int i = length - 1; i >= 0; i--) {
            dp[i] = jobs[i][2];
            for (int j = i + 1; j < length; j++) {
                if (jobs[j][0] >= jobs[i][1]) {
                    dp[i] = Math.max(dp[i], jobs[i][2] + dp[j]);
                }
            }
            result = Math.max(result, dp[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] jobs = {
                {1, 2, 50},
                {3, 5, 20},
                {6, 19, 100},
                {2, 100, 200}
        };

        System.out.println("Maximum profit: " + getMaximumProfit(jobs));
    }
}
