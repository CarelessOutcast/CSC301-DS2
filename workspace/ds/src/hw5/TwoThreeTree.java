package hw5;

import edu.princeton.cs.algs4.Queue;

public class TwoThreeTree {
    // Change these three back to private; Used for testing //FIXME
	private Node root;
	private class Node {
		public int type;			// the node type.  Should be 2, 3, or 4
		public int[] keys;			// the keys in this node.  Only slots 0 .. type-2 are valid
		public Node[] subtrees;	// the children of this node.  Only slots 0 .. type-1 are valid

		/**
		 * Construct a new 2-node
		 * @param k0 the key for the node
		 * @param st0 the left child (subtree) for the node
		 * @param st1 the right child (subtree) for the node
		 */
		public Node(int k0, Node st0, Node st1) {
			type = 2;
			keys = new int[3];
			keys[0] = k0;
			subtrees = new Node[4];
			subtrees[0] = st0;
			subtrees[1] = st1;
		}
		
		/**
		 * Create an empty node
		 * This constructor can be used if an emtpy node needs to be created
		 * that whose keys, children, and type will be set later.
		 * The type is set to -1 to mark it as an invalid node
		 */
		public Node() {
			type = -1;
			keys = new int[3];
			subtrees = new Node[4];
		}
	}

	/**
	 * Construct an empty 2-3 tree.
	 */
	public TwoThreeTree() {
		root = null;
	}

	/**
	 * Construct a 2-3 tree given when given the keys in level order.
	 * A comma separates the nodes.  A space separates two keys when they appear in the same node.
	 * For example, the level order "40 50,25,47,61 72" would produce the tree:
	 * 
	 *                            (40   50)
	 *                            /   |   \
	 *                        (25)  (47)  (61  72)
	 * @param s the level order traversal of the tree.
	 */
	public TwoThreeTree(String s) {
		if (s.length() > 0) {
			String[] nodeStrings = s.split(",");
			Queue<Node> q = new Queue<Node>();
			String[] keys = nodeStrings[0].split(" ");
			root = new Node();
			root.keys[0] = Integer.parseInt(keys[0]);
			root.type = 2;
			if (keys.length > 1) {
				root.keys[1] = Integer.parseInt(keys[1]);
				root.type = 3;
			}
			q.enqueue(root);
			int i = 1;
			while (i < nodeStrings.length) {
				Node n = q.dequeue();
				for(int k = 0; k < n.type; k++) {
					Node newNode = new Node();
					keys = nodeStrings[i++].split(" ");
					newNode.keys[0] = Integer.parseInt(keys[0]);
					newNode.type = 2;
					if (keys.length > 1) {
						newNode.keys[1] = Integer.parseInt(keys[1]);
						newNode.type = 3;
					}
					q.enqueue(newNode);
					n.subtrees[k] = newNode;
				}
			}
		}
	}


    // ----------------------------------------------------
    public void add(int k)
    {
        if (root == null) { 
            root = new Node(k,null,null); 
            return;
        }
        
        // I need a copy to compare
        Node copyRoot = new Node();
        copyRoot.type = root.type;
        copyRoot.keys[0] = root.keys[0];
        copyRoot.keys[1] = root.keys[1];
        copyRoot.subtrees[0] = root.subtrees[0];
        copyRoot.subtrees[1] = root.subtrees[1];
        copyRoot.subtrees[2] = root.subtrees[2];

        Node rRooty = add(root,k);

        if (copyRoot.type > 2)
        {
            if (rRooty.type == 4)
            {   
                Node newHead = null;
                // pull key up, put in correct location; shift accordingly
                if (rRooty.keys[1] < copyRoot.keys[0])
                {
                    Node newLeft = new Node(rRooty.keys[1], rRooty.subtrees[0], rRooty.subtrees[1]);

                    Node newRight = new Node(rRooty.keys[2], rRooty.subtrees[2], rRooty.subtrees[3]);

                    newHead = new Node(rRooty.keys[0],newLeft, newRight);
                }
                else if (rRooty.keys[1] >= copyRoot.keys[0] && rRooty.keys[1] <= copyRoot.keys[1])
                {
                    Node newLeft = new Node(rRooty.keys[0], rRooty.subtrees[0], rRooty.subtrees[1]);

                    Node newRight = new Node(rRooty.keys[2], rRooty.subtrees[2], rRooty.subtrees[3]);

                    newHead = new Node(rRooty.keys[1],newLeft, newRight);
                    
                }
                else if (rRooty.keys[1] > copyRoot.keys[1])
                {
                    Node newLeft = new Node(rRooty.keys[0], rRooty.subtrees[0], rRooty.subtrees[1]);

                    Node newRight = new Node(rRooty.keys[2], rRooty.subtrees[2], rRooty.subtrees[3]);

                    newHead = new Node(rRooty.keys[1],newLeft, newRight);
                }
//                assert(!(newHead == null)): "T3 Rouge Root Rooty!";
                root = newHead;
                return;
            }
        } else {
            // just shift around
            if (rRooty.type == 4)
            {   
                // pull key up, put in correct location; shift accordingly
                if (rRooty.keys[1] < copyRoot.keys[0]) 
                {
                    copyRoot.keys[1] = copyRoot.keys[0];
                    copyRoot.keys[0] = rRooty.keys[1];
                    copyRoot.subtrees[2] = copyRoot.subtrees[1];
                    // split it
                    copyRoot.subtrees[1] = new Node(rRooty.keys[2], rRooty.subtrees[2], rRooty.subtrees[3]);
                    copyRoot.subtrees[0] = new Node(rRooty.keys[0], rRooty.subtrees[0], rRooty.subtrees[1]);
                }
                else if (rRooty.keys[1] > copyRoot.keys[0])
                {
                    copyRoot.keys[1] = rRooty.keys[1];
                    // split it 
                    copyRoot.subtrees[2] = new Node(rRooty.keys[2], rRooty.subtrees[2], rRooty.subtrees[3]);
                    copyRoot.subtrees[1] = new Node(rRooty.keys[0], rRooty.subtrees[0], rRooty.subtrees[1]);
                }
                copyRoot.type++;
//                assert(!(copyRoot.type > 4)): "Root type > 4?";
            }
        }
//        assert(!(rRooty == null)): "T2 Rouge Root Rooty" ;
    }

    private Node add(Node rooty, int k)
    {
//        assert (!(rooty == null)) : "root is null at " + k +". obj: " +this;
//        assert (!(rooty.type > 4)) : " Type > 4: " + rooty.type + " " + this;

        // leaf -------------------------------------------
        if (rooty.subtrees[0] == null)
        {
            if (rooty.type > 2)
            {
                if (k < rooty.keys[0]) // check if swap is necessary
                {
                    // move keys
                    rooty.keys[2] = rooty.keys[1];
                    rooty.keys[1] = rooty.keys[0];
                    rooty.keys[0] = k;
                }
                else if (k >= rooty.keys[0] && k <= rooty.keys[1])
                {
                    // move keys
                    rooty.keys[2] = rooty.keys[1];
                    rooty.keys[1] = k;
                }
                else 
                {
                    rooty.keys[2] = k;
                }
                rooty.type++;
//                assert(!(rooty.type > 4)): "Three Node Type > 4: "+ rooty.type;

            } else {

                // check if you need move single key over
                if (k < rooty.keys[0])
                {
                    rooty.keys[1] = rooty.keys[0];
                    rooty.keys[0] = k;
                } else {
                    rooty.keys[1] = k;
                }
                rooty.type++;
//                assert(!(rooty.type > 4)): "Two Node Type > 4: " + rooty.type;
            }
            return rooty;
        }
         // You're not on a leaf ----------------------------
        Node rRooty = null;

        if (rooty.type > 2) {
            if (k < rooty.keys[0]) {
                rRooty = add(rooty.subtrees[0], k);
            }
            else if (k >= rooty.keys[0] && k <= rooty.keys[1]) {
                rRooty = add(rooty.subtrees[1], k);
            }
            else if (k > rooty.keys[1]) {
                rRooty = add(rooty.subtrees[2], k);
            }

        } else {
            if (k < rooty.keys[0]){
                rRooty = add(rooty.subtrees[0], k);
            }
            else if (k > rooty.keys[0]){
                rRooty = add(rooty.subtrees[1], k);
            }
        }
        // check if fat ------------------------------------
//        assert(!(rRooty == null)) : "Rogue Rooty";

        if (rooty.type > 2)
        {
            if (rRooty.type == 4)
            {   
                // pull key up, put in correct location; shift accordingly
                if (rRooty.keys[1] < rooty.keys[0])
                {
                    rooty.keys[2] = rooty.keys[1];
                    rooty.keys[1] = rooty.keys[0];
                    rooty.keys[0] = rRooty.keys[1];
                    rooty.subtrees[3] = rooty.subtrees[2];
                    rooty.subtrees[2] = rooty.subtrees[1];
                    rooty.subtrees[1] = rooty.subtrees[0];
                    // split it
                    rooty.subtrees[0] = new Node(rRooty.keys[0], rRooty.subtrees[0], rRooty.subtrees[1]);
                    rooty.subtrees[1] = new Node(rRooty.keys[2], rRooty.subtrees[2], rRooty.subtrees[3]);
                }
                else if (rRooty.keys[1] >= rooty.keys[0] && rRooty.keys[1] <= rooty.keys[1])
                {
                    rooty.keys[2] = rooty.keys[1];
                    rooty.keys[1] = rRooty.keys[1];
                    rooty.subtrees[3] = rooty.subtrees[2];
                    // split it 
                    rooty.subtrees[2] = new Node(rRooty.keys[2], rRooty.subtrees[2], rRooty.subtrees[3]);
                    rooty.subtrees[1] = new Node(rRooty.keys[0], rRooty.subtrees[0], rRooty.subtrees[1]);
                }
                else if (rRooty.keys[1] > rooty.keys[1])
                {
                    rooty.keys[2] = rRooty.keys[1];
                    rooty.subtrees[3] = new Node(rRooty.keys[2], rRooty.subtrees[2], rRooty.subtrees[3]);
                    rooty.subtrees[2] = new Node(rRooty.keys[0], rRooty.subtrees[0], rRooty.subtrees[1]);
                }
                rooty.type++;
            }
        } else {
            if (rRooty.type == 4)
            {   
                // pull key up, put in correct location; shift accordingly
                if (rRooty.keys[1] < rooty.keys[0]) 
                {
                    rooty.keys[1] = rooty.keys[0];
                    rooty.keys[0] = rRooty.keys[1];
                    rooty.subtrees[2] = rooty.subtrees[1];
                    // split it
                    rooty.subtrees[1] = new Node(rRooty.keys[2], rRooty.subtrees[2], rRooty.subtrees[3]);
                    rooty.subtrees[0] = new Node(rRooty.keys[0], rRooty.subtrees[0], rRooty.subtrees[1]);
                }
                else if (rRooty.keys[1] > rooty.keys[0])
                {
                    rooty.keys[1] = rRooty.keys[1];
                    // split it 
                    rooty.subtrees[2] = new Node(rRooty.keys[2], rRooty.subtrees[2], rRooty.subtrees[3]);
                    rooty.subtrees[1] = new Node(rRooty.keys[0], rRooty.subtrees[0], rRooty.subtrees[1]);
                }
				rooty.type++;
            }
        }
        return rooty;
    }

    // -----------------------------------------------------
	public boolean contains(int k) {
		if (root == null) return false;
        return contains(root, k);
	}
	private boolean contains(Node roots, int k) {
        if (roots == null) return false;
        if (roots.type == 2 && roots.keys[0] == k) return true;
        if (roots.type == 3 && (roots.keys[0] == k || roots.keys[1] == k)) return true;
        return contains(roots.subtrees[0], k) || contains(roots.subtrees[1], k) || contains(roots.subtrees[2], k);
	}

    // ----------------------------------------------------
	public int height() {
        return height(root);
	}

	private int height(Node roots) {
        if (roots == null) return -1;
//        if (roots.type == 2) { 
//            int left = height(roots.subtrees[0]) + 1;
//            int right = height(roots.subtrees[1]) + 1;
//            assert(left == right) : "Type 2: Subtrees not the same";
//
//        }       
//        if (roots.type == 3) { 
//            int left = height(roots.subtrees[0]) + 1;
//            int middle = height(roots.subtrees[1]) + 1;
//            int right = height(roots.subtrees[2]) + 1;
//            assert(left == right && right == middle) : "Type 3: Subtrees not the same";
//        }       
        return height(roots.subtrees[0]) + 1;
	}

    // ----------------------------------------------------
	public int nodeCount() {
        return nodeCount(root);
	}
	private int nodeCount(Node roots) {
        if (roots == null) return 0;
        if (roots.type == 2) 
        {
            return 1 + nodeCount(roots.subtrees[0]) + nodeCount(roots.subtrees[1]);
        }
        if (roots.type == 3) 
        {
            return 1 + nodeCount(roots.subtrees[0]) + nodeCount(roots.subtrees[1]) + nodeCount(roots.subtrees[2]);
        }
        return  nodeCount(roots.subtrees[0]) + nodeCount(roots.subtrees[1]) + nodeCount(roots.subtrees[2]);
	}
	
	

	/**
	 * A method for testing.
	 * Returns true if {@code this} tree and {@code otherTree} are identical
	 * (i.e. have the same keys in the same positions).
	 * @param otherTree the tree to compare against
	 * @return {@code true} if {@code this} tree and {@code otherTree} are identical
	 */
	public boolean identical(TwoThreeTree otherTree) {
		return identicalH(this.root, otherTree.root);
	}
	
	private boolean identicalH(Node thisNode, Node otherNode) {
		if (thisNode == null && otherNode == null)
			return true;
		if (thisNode == null || otherNode == null)
			return false;
		if (thisNode.type != otherNode.type)
			return false;
		for(int i = 0; i < thisNode.type-1; i++) {
			if (thisNode.keys[i] != otherNode.keys[i])
				return false;
		}
		for(int i = 0; i < thisNode.type; i++) {
			if (!identicalH(thisNode.subtrees[i], otherNode.subtrees[i]))
				return false;
		}
		return true;
	}


}
