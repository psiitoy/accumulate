package org.sprintdragon.algorithm.lc.dp;

public class Title90 {

    public int numDecodings(String s) {
        if (s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = 1;
        int preNum = s.charAt(0) - '0';
        for (int i = 2; i <= s.length(); i++) {
            int val = s.charAt(i - 1) - '0';
            if (val == 0 && preNum == 0) {
                return 0;
            }
            if (val == 0 && preNum > 2) {
                return 0;
            }
            if ((val == 0 || val > 2) && i < s.length() && s.charAt(i) == '0') {
                return 0;
            }
            int sum = preNum * 10 + val;
            preNum = val;
            if (sum >= 11 && sum <= 26 && sum != 10 && sum != 20) {
                if (i < s.length() && s.charAt(i) == '0') {
                    dp[i] = dp[i - 1];
                } else {
                    dp[i] = dp[i - 1] + dp[i - 2];
                }
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[s.length()];
    }

}
