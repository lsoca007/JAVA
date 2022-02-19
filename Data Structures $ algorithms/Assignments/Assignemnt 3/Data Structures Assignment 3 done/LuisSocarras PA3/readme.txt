

The standard java.util.TreeMap is more efficient than the UnbalanceTreeMap that I implemented. Java treeMap is faster because implements red-black tree and keep the tree balanced. By keeping the tree in balance at all times, we can ensure that the get and put method will run in order O(log n)time. Red-black trees are a self-balancing tree and guarantee logarithmic time for search operations.


My Unbalanced TreeMap, 137985920 ns
Standard Java Tree Map , 85919648 ns


My Unbalanced TreeMap, 101058951 ns
Standard Java Tree Map , 78717178 ns