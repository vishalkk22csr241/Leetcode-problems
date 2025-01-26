class Solution { 
    public List<String> removeInvalidParentheses(String s) {
        int n = s.length();
        HashSet<String> validParentheses = dfs(s, 0, 0, new HashSet[n + 1][n + 1]);
        int maxLen = 0;
        for (String str : validParentheses) maxLen = Math.max(maxLen, str.length());

        List<String> ans = new ArrayList<>();
        for (String str : validParentheses)
            if (str.length() == maxLen)
                ans.add(str);
        return ans;
    }

    HashSet<String> dfs(String s, int i, int nOpen, HashSet<String>[][] memo) {
        HashSet<String> ans = new HashSet<>();
        if (nOpen < 0) return ans;
        if (memo[i][nOpen] != null) return memo[i][nOpen];
        if (i == s.length()) {
            if (nOpen == 0) ans.add(""); 
        } else {
            char c = s.charAt(i);
            if (c == '(' || c == ')') {
                ans.addAll(dfs(s, i + 1, nOpen, memo));
            }
            int newOpen = nOpen;
            if (c == '(') newOpen++;
            else if (c == ')') newOpen--;
            for (String suffix : dfs(s, i + 1, newOpen, memo)) 
                ans.add(c + suffix);
        }
        return memo[i][nOpen] = ans;
    }
}