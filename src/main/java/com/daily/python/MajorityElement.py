class Solution(object):
    def majorityElement(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        return None if not nums else sorted(nums)[len(nums)/2]