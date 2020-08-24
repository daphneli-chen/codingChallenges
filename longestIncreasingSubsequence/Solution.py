class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        if len(nums) == 0:
            return 0
        biggest = 1
        longest = [0] * len(nums)
        for i in range(len(nums)):
            longest[i] = 1
            for j in range(i):
                if nums[j] < nums[i]:
                    longest[i] = max(longest[i], longest[j] + 1)
            biggest = max(biggest, longest[i])
        return biggest    