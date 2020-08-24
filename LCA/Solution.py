# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    
    def __init__(self):
        self.ans = None
    
    def search(self, curr, p, q):
        if not curr:
            return False
        
        mid = False
        if curr == p or curr == q:
            mid = True
        left = self.search(curr.left, p, q)
        right = self.search(curr.right, p, q)
        
        if mid + left + right >= 2:
            self.ans = curr
        
        return mid or left or right
        
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        self.search(root, p, q)
        return self.ans
        