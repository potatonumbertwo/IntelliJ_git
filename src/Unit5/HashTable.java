//package Unit5;
//
//import static java.util.Objects.hash;
//
///**
// * write a hash table in which both the keys
// * and the values are of type String.
// */
//public class HashTable {
//    public static void main(String[] args) {
//
//    }
//
//    public static void get(String key) {
//
//        int bucket = hash(key);  // At what location should the key be?
//
//        ListNode list = table[bucket];  // For traversing the list.
//        while (list != null) {
//            // Check if the specified key is in the node that
//            // list points to.  If so, return the associated value.
//            if (list.key.equals(key))
//                return list.value;
//            list = list.next;  // Move on to next node in the list.
//        }
//
//        // If we get to this point, then we have looked at every
//        // node in the list without finding the key.  Return
//        // the value null to indicate that the key is not in the table.
//
//        return null;
//    }
//
//    public static void remove(String key) {
//
//
//    }
//
//    public static void containsKey(String key) {
//        int bucket = hash(key);  // In what location should key be?
//
//        ListNode list = table[bucket];  // For traversing the list.
//        while (list != null) {
//            // If we find the key in this node, return true.
//            if (list.key.equals(key))
//                return true;
//            list = list.next;
//        }
//
//        // If we get to this point, we know that the key does
//        // not exist in the table.
//
//        return false;
//    }
//
//
//    public static int size() {
//        return count;
//    }
//
//
//}
