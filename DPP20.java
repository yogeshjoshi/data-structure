
/**
 * Given two singly linked lists that intersect at some point, 
 * find the intersecting node. The lists are non-cyclical.
 * For example, given A = 3 -> 7 -> 8 -> 10 and B = 99 -> 1 -> 8 -> 10, return the node with value 8.
 * In this example, assume nodes with the same value are the exact same node objects.
 * Do this in O(M + N) time (where M and N are the lengths of the lists) and constant space.
 */
public class DPP20{
    Node head;
    Node head1;

    DPP20(){
        head = null;
        head1 = null;
    }
    DPP20(int data){
        head = new Node(data);
    }
    public static void main(String[] args) {
        DPP20 dpp20 = new DPP20();

        dpp20.head = new Node(3);
        dpp20.head.next = new Node(7);
        dpp20.head.next.next = new Node(5);
        dpp20.head.next.next.next = new Node(8);
        dpp20.head.next.next.next.next = new Node(10);

        dpp20.head1 = new Node(99);
        dpp20.head1.next = new Node(1);
        dpp20.head1.next.next = new Node(9);
        dpp20.head1.next.next.next = new Node(2);
        dpp20.head1.next.next.next.next = new Node(8);
        dpp20.head1.next.next.next.next.next = new Node(10);

        int _out = process(dpp20.head, dpp20.head1);
        System.out.println(_out);

    }


    static int process(Node node1, Node node2){
        int length1 = 0;
        int length2 = 0;

        Node list1 = node1;
        Node list2 = node2;

        while(list1 != null){
            length1 += 1;
            list1 = list1.next;
        }
        while(list2 != null){
            length2 += 1;
            list2 = list2.next;
        }
        int lenDiff = length1-length2;

        if(lenDiff == 0){
            while(node1 != null && node2 != null){
                if(node1.data == node2.data)
                    return node1.data;
                node1 = node1.next;
                node2 = node2.next;
            }
        }else if(lenDiff>0){
            while(lenDiff>0){
                node1 = node1.next;
                lenDiff--;
            }
            while(node1 != null && node2 != null){
                if(node1.data == node2.data)
                    return node1.data;
                node1 = node1.next;
                node2 = node2.next;
            }
        }else{
            lenDiff = Math.abs(lenDiff);
            //System.out.println(lenDiff);
            while(lenDiff>0){
                node2 = node2.next;
                lenDiff--;
            }
            while(node1 != null && node2 != null){
                if(node1.data == node2.data)
                    return node1.data;
                node1 = node1.next;
                node2 = node2.next;
            }
        }

        // System.out.println(length1);
        // System.out.println(length2);

        return 0;
    }
}
class Node{
    int data;
    Node next;

    Node(int data){
        this.data = data;
        this.next = null;
    }
}