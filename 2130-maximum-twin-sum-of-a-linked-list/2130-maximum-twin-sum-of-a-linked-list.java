/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int pairSum(ListNode head) {
        List<Integer> arr = new ArrayList<>();

        while(head != null){
            arr.add(head.val);
            head = head.next;
        }

        int max = 0;
        int n = arr.size();

        for(int i = 0; i < n/2; i++){
            max = Math.max(max, arr.get(i) + arr.get(n - 1 - i));
        }
        return max;
    }
}