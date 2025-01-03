class Solution {
      public int rob2(int[] nums,int i,int dp[])
      {
        if(i>=nums.length)
        {
            return 0;
        }
        if(dp[i]!=-1)
        {
            return dp[i];
        }
        else
        {
            return dp[i]=Math.max(rob2(nums,i+1,dp),rob2(nums,i+2,dp)+nums[i]);
        }
      }






    public int rob(int[] nums)
     {
        int dp[]=new int[nums.length+1];
        Arrays.fill(dp,-1);
        return rob2(nums,0,dp);
    }
}