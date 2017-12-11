package algo.medium.AddTwoNumbers;

/**
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * Example
 * <p>
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */

import commons.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }

        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        int carryOver = 0;
        ListNode resultNode = null;
        ListNode currentNode = null;
        while (l1 != null || l2 != null) {
            int sumOfNodes = (l1 == null ? 0 : l1.getVal()) +  (l2 == null? 0 : l2.getVal()) + carryOver;
            if (sumOfNodes > 9) {
                carryOver = sumOfNodes / 10;
                sumOfNodes = sumOfNodes % 10;
            }
            else {
                carryOver = 0;
            }
            ListNode n = new ListNode(sumOfNodes);
            if (resultNode == null) {
                resultNode = n;
                currentNode = n;
            } else {
                currentNode.next = n;
                currentNode = currentNode.next;
            }
            l1 = l1 == null? null : l1.next;
            l2 = l2 == null? null: l2.next;
        }
        if(carryOver > 0){
            currentNode.next = new ListNode(carryOver);
        }

        return resultNode;
    }

    public static void main(String args[]) {
        ListNode number1 = buildListNode(243);
        ListNode number2 = buildListNode(564);
        ListNode answerNode = addTwoNumbers(number1, number2);
        while(answerNode != null) {
            System.out.print(answerNode.getVal() + "->");
            answerNode = answerNode.next;
        }
    }

    private static ListNode buildListNode(int number) {

        ListNode numberedNode = null;
        ListNode currentNode = null;
        while (number > 0) {
            int num = number % 10;
            ListNode node = new ListNode(num);
            if(numberedNode == null){
                numberedNode = node;
                currentNode = numberedNode;
            }
            else {
                currentNode.next = node;
                currentNode = currentNode.next;
            }
            number = number / 10;
        }
        return numberedNode;
    }

}
