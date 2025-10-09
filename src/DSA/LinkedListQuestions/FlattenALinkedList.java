//package LinkedListQuestions;
//import java.util.*;
//// uses same concept as Merge sort: merging two sorted arrays
//
//public class FlattenALinkedList {
//    public static void main(String[] args) {
//        // see code on gfg
//    }
//
//    static Node merge(Node root1, Node root2){
//        if(root1==null) return root2;
//        if(root2==null) return root1;
//
//        Node result = new Node(0);
//        Node output = result;
//
//        while(root1!=null && root2!=null){
//            if(root1.data < root2.data){
//                Node x = new Node(root1.data);
//                result.bottom = x;
//                root1 = root1.bottom;
//            }
//            else{
//                Node x = new Node(root2.data);
//                result.bottom = x;
//                root2 = root2.bottom;
//            }
//            result = result.bottom;
//        }
//
//        while(root1!=null){
//            Node x = new Node(root1.data);
//            result.bottom = x;
//            root1 = root1.bottom;
//            result = result.bottom;
//        }
//
//        while(root2!=null){
//            Node x = new Node(root2.data);
//            result.bottom = x;
//            root2 = root2.bottom;
//            result = result.bottom;
//        }
//
//        return output.bottom;
//    }
//
//    Node flatten(Node root) {
//        Node result = root;
//
//        while(root!=null){
//            root = root.next;
//            result = merge(result,root);
//        }
//
//        return result;
////        if(root==null) return null;
////        ArrayList<Integer> list = new ArrayList<>();
////        Node temp = root;
////
////        while(temp!=null){
////            Node temp2 = temp;
////            while(temp2!=null){
////                list.add(temp2.data);
////                temp2 = temp2.bottom;
////            }
////            temp = temp.next;
////        }
////        Collections.sort(list);
////        Node head = new Node(list.get(0));
////        Node ans = head;
////        int n = list.size();
////        for(int i=1;i<n;i++){
////            Node mynode = new Node(list.get(i));
////            head.bottom = mynode;
////            head = head.bottom;
////        }
////        return ans;
//    }
//}
////class Node
////{
////    int data;
////    Node next;
////    Node bottom;
////
////    Node(int d)
////    {
////        data = d;
////        next = null;
////        bottom = null;
////    }
////}