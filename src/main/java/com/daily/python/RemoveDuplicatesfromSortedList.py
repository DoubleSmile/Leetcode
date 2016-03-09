# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None
class Solution(object):
    def deleteDuplicates(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        if head is None or head.next is None:
            return head
        node=head
        while node is not None:
            if node.next is not None and node.val==node.next.val:
                temp=node.next.next
                node.next.next=None
                node.next=temp
                continue
            node=node.next
        return head