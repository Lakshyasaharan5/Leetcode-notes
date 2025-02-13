/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        // create a copy list without thinking about random pointer
        // interweave both the lists so that random is node.next ... you know
        Node tmp = head;
        while(tmp!=null){
            Node newNode = new Node(tmp.val);
            newNode.next = tmp.next;
            tmp.next = newNode;
            tmp = newNode.next;
        }
        
        // now iterate and assign the random pointers
        tmp = head;
        while(tmp!=null){
            if(tmp.random != null){
                tmp.next.random = tmp.random.next; 
            }else{
                tmp.next.random = null;
            }
            tmp = tmp.next.next;
        }

        // separate the lists
        tmp = head;
        Node copy = tmp.next;
        Node result = copy;
        while(true){
            tmp.next = copy.next;
            if(copy.next == null) break;
            copy.next = copy.next.next;
            tmp = tmp.next;
            copy = copy.next;
        }

        return result;
    }
}