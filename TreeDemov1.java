class Node{
	   int value;
	   Node left, right;
	   
	   public Node(int value){
	      this.value = value;
	      left = null;
	      right = null;
	   }

	}

	class BinarySearchTree{

	   Node root;
	  
	   
	   /*
	   recursive insert method
		
	   */
	   /*
	   inserts a node into the tree
	   */
	   public void insert(int value){
	      //tree is empty
	      if(root == null){
	         root = new Node(value);
	         return;
	      }else{
	         Node current = root;
	         Node parent = null;
	         
	         while(true){
	            parent = current;
	            
	            if(value < current.value){
	               current = current.left;
	               if(current == null){
	                  parent.left = new Node(value);
	                  return;
	               }
	            }else{
	               current = current.right;
	               if(current == null){
	                  parent.right = new Node(value);
	                  return;
	               }
	            }
	           
	         }//closing while
	      
	      }//closing main if-else
	   }
	   
	   /*
	   pre-order traversal
	   Prints the value of every node preorder
	   */
	   public void preOrderTraversal(Node root){
         // Traverses the binary tree until a null node is reached.	      
         if (root != null) {
            System.out.print(root.value + ",");
            preOrderTraversal(root.left);
            preOrderTraversal(root.right);
         }
	   }

	   
	   
	   /*
	   in-order traversal
	   */
	   public void inOrderTraversal(Node root){
         // Traverses the binary tree until a null node is reached.	      
         if (root != null) {
            inOrderTraversal(root.left);
            System.out.print(root.value + ",");
            inOrderTraversal(root.right);
         }
	   }
	   
	   
	   
	   /*
	   post-order traversal
	   */
	  
	   public void postOrderTraversal(Node root){
         // Traverses the binary tree until a null node is reached.	      
         if (root != null) {
            postOrderTraversal(root.left);
            postOrderTraversal(root.right);
            System.out.print(root.value + ",");
         }
	   }
      
      
	   
	   /*
	   a method to find the node in the tree
	   with a specific value
	   */
	   public boolean find(Node root, int key){
		   //If key < value, traverses left. > value, right, = value, returns true. Reaches null, returns false.
         if (root != null) {
            if (key < root.value) {
               // Recursive call to left tree.
               return find(root.left, key);
            } else if (key > root.value) {
               // Recursive call to right tree.
               return find(root.right, key);
            } else {
               // Base case 1. (Item found)
               return true;
            }
         } else {
            // Base case 2. (Item not found)
            return false;
         }
	   }
	   
      
      
	   /*
	   a method to find the node in the tree
	   with a smallest key
	   */
	   public int getMin(Node root){
         int returnValue = 0;
         // Traverses left until there is nothing left.
         // The leftest node is always the smallest.
         if (root.left != null) {
            return getMin(root.left);
         } else {
            // Base Case, leftest node;
            return root.value;
         }
	   }
	  
	  
	  
	   /*
	   a method to find the node in the tree
	   with a largest key
	   */
	   public int getMax(Node root){
         int returnValue = 0;
         // Traverses right until there is nothing right.
         // The rightest node is always the largest.
         if (root.right != null) {
            return getMax(root.right);
         } else {
            // Base Case, leftest node;
            return root.value;
         }
	   }
	   
	   
	   
	   /*
	   this method will not compile until getMax
	   is implemented
	   */
	   public Node delete(Node root, int key){
	      
	      if(root == null){
	         return root;
	      }else if(key < root.value){
	         root.left = delete(root.left, key);
	      }else if(key > root.value){
	         root.right = delete(root.right, key);
	      }else{
	         //node has been found
	         if(root.left==null && root.right==null){
	            //case #1: leaf node
	            root = null;
	         }else if(root.right == null){
	            //case #2 : only left child
	            root = root.left;
	         }else if(root.left == null){
	            //case #2 : only right child
	            root = root.right;
	         }else{
	            //case #3 : 2 children
	            root.value = getMax(root.left);
	            root.left = delete(root.left, root.value);
	         }
	      }
	      return root;  
	   }
	   
	   
	   
	}



	public class TreeDemov1{
	   public static void main(String[] args){
	      BinarySearchTree t1  = new BinarySearchTree();
	      t1.insert(24);
	      t1.insert(80);
	      t1.insert(18);
	      t1.insert(9);
	      t1.insert(90);
	      t1.insert(22);
	            
         // If there is no root node, does not run any of the code.
         if (t1.root != null) {
	         System.out.print("pre-order\t:   ");
	         t1.preOrderTraversal(t1.root);
	         System.out.print("\nin-order\t\t:   ");
	         t1.inOrderTraversal(t1.root);
	         System.out.print("\npost-order\t:   ");
	         t1.postOrderTraversal(t1.root);
	         System.out.println();

	         System.out.print("\nmin-value\t:   " + t1.getMin(t1.root));
	         System.out.print("\nmax-value\t:   " + t1.getMax(t1.root));
	         System.out.println();

	         System.out.print("\nfind(9) =\t   " + t1.find(t1.root, 9));
	         System.out.print("\nfind(18) =\t   " + t1.find(t1.root, 18));
	         System.out.print("\nfind(22) =\t   " + t1.find(t1.root, 22));
	         System.out.print("\nfind(24) =\t   " + t1.find(t1.root, 24));
	         System.out.print("\nfind(80) =\t   " + t1.find(t1.root, 80));
	         System.out.print("\nfind(90) =\t   " + t1.find(t1.root, 90));
            
	         System.out.print("\nfind(17) =\t   " + t1.find(t1.root, 17));
	         System.out.print("\nfind(21) =\t   " + t1.find(t1.root, 21));
	         System.out.print("\nfind(93) =\t   " + t1.find(t1.root, 93));

         } else {
            System.out.print("Tree is empty!");
         }
	      System.out.println();
         
	   }  
	}
