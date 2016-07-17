class Solution(object):
    def maxSlidingWindow(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: List[int]
        """
        if nums == None or nums == []:
            temp=[]
            return temp
        result=[]
        for i in range(len(nums)-k+1):
            result.append(max(nums[i:i+k]))
        return result
