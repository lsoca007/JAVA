
public class UnbalancedTreeMap {

	class BinaryNode { // a tree node (sub class)
		public OrderedKeyValue keyValue; // key, value pair
		public BinaryNode leftChild; // left child node
		public BinaryNode rightChild; // right child node

		public BinaryNode(OrderedKeyValue keyValue) { // constructor of sub class
			this.keyValue = keyValue;
			leftChild = null;
			rightChild = null;
		}
	}

	public BinaryNode root; // root of the tree
	public int count = 0; // tree node count

	public UnbalancedTreeMap() { // constructor
		root = null; // new tree root
	}

	public int get(String key) { // getting value from a key, if not found then returns 0
		BinaryNode temp = root; //for traversing the tree from root to the node with the same key

		while (temp != null) { //until node becomes null(=leaf node's child)
			if (temp.keyValue.compareTo(key) < 0) { //comparing if the current node is smaller than the given key
				temp = temp.rightChild; //as current value if larger go to right child
			} else if (temp.keyValue.compareTo(key) > 0) { //comparing if the current node is larger than the given key
				temp = temp.leftChild; //as current value if smaller go to left child
			} else { //current node's key is equal to the given key
				return temp.keyValue.value; //return the value corresponding to the node
			}
		}

		return 0; //no matched ket return value 0
	}

	public int put(String key, int value) { //inserting value to tree

		OrderedKeyValue newNodeKeyValue = new OrderedKeyValue(key, value); 

		if (root == null) {//first node
			root = new BinaryNode(newNodeKeyValue); //making the tree node
			count++; //increasing the count of node in tree
			return 0; 
		}

		BinaryNode temp = root;//for traversing the tree from root to proper node to insert

		while (temp != null) { //until node becomes null(=leaf node's child)

			if (temp.keyValue.compareTo(key) < 0) {//comparing if the current node is smaller than the given key
				if (temp.rightChild == null) { //want to go right child, but it is empty (=place to insert new node)
					temp.rightChild = new BinaryNode(newNodeKeyValue);  //making the tree node
					count++; //increasing the count of node in tree
					return 0;
				} else {
					temp = temp.rightChild; //go right child
				}

			} else if (temp.keyValue.compareTo(key) > 0) {//comparing if the current node is larger than the given key
				if (temp.leftChild == null) {//want to go left child, but it is empty (=place to insert new node)
					temp.leftChild = new BinaryNode(newNodeKeyValue); //making the tree node
					count++; //increasing the count of node in tree
					return 0;
				} else {
					temp = temp.leftChild; //go left child
				}
			} else { //current node's key is equal to the given key (=key already exist)
				int oldValue = temp.keyValue.value; //saving the old value to return
				temp.keyValue = newNodeKeyValue; //updating the new value
				return oldValue; //returning the old value
			}
		}

		return 0;
	}

	private String[] keys; //for storing all the keys in the tree
	private int currPtr = 0; //for tracking the index of the key array

	public String[] keySet() { //returns all the keys in the tree in sorted order (aaa,bbb,ccc)
		keys = new String[count]; //initializing the array with the size of total node count in tree
		inorderRec(root); //calling the recursive function for updating the keys array
		return keys;
	}

	
	void inorderRec(BinaryNode node) { //function that recursively finds key in inorder (= Scanning order: left child -> parent -> right child)
		if (node != null) {
			inorderRec(node.leftChild); //go to left most child
			keys[currPtr++] = node.keyValue.key; //then print the current value
			inorderRec(node.rightChild); //go to right child
		}
		//       g
		//     /   \
		//    d     j
		//   / \     \
		//  a   e     x
		//in order: a,d,e,g,j,x
		//explain: a is left most child, then go to it's parent d, then goto right e ....
	}
}
