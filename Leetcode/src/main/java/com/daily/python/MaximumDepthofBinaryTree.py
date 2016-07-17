# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def maxDepth(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        if root == None:
            return 0
        depth=1
        leftDepth=0
        rightDepth=0
        if not root.left is None:
            leftDepth=leftDepth+self.maxDepth(root.left)
        if not root.right is None:
            rightDepth=rightDepth+self.maxDepth(root.right)
        depth=depth+max(leftDepth,rightDepth)
        return depth