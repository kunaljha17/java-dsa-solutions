//Approach
//in this we do with normal way too with use if trie , in this way i have ti insert every element of list into trie then , search each substring and then check recusive call for remaining substring if both return true then finally return true

//Approach 2 , with i use here 
// in this i use set to store list string , then search there if found then , then save in dp[] true and return true
//here i use 1D dp to store , like memoization 
//here i check in if (search or contains with remaining recusuive return true ) then return true



class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        Boolean[] dp = new Boolean[s.length()];
        return solve(s, 0, set, dp);
    }

    private boolean solve(String s, int start,Set<String> set, Boolean[] dp) {
        if (start == s.length()) {
            return true;
        }

        if (dp[start] != null) {
            return dp[start];
        }

        for (int end = start + 1; end <= s.length(); end++) {
            String word = s.substring(start, end);
            if (set.contains(word) && solve(s, end, set, dp)) {
                return dp[start] = true;
            }
        }
        return dp[start] = false;
    }
}
