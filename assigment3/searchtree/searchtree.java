package assignment3;

import java.util.ArrayList;

public class searchtree{
	
	int data;
	int searchcompare;
	searchtree left, right, parent;
	searchtree base;
	 searchtree() {  
	     this.left=null;
	     this.right=null;
	     this.parent=null;     
	     searchcompare=0;
	 }
	///testing cases//
	 public static void main(String[] args) {
		 searchtree searchtreeOne=new searchtree();
		 searchtreeOne.move(3);
		 searchtreeOne.move(7);
		 searchtreeOne.move(2);
		 searchtreeOne.move(4);
		 int[] arr= {6,5,8,1,3};
		 searchtreeOne.move2(arr);
		 searchtreeOne.infix(searchtreeOne.base);
		 System.out.println();
		 
		 int[] finalfind=new int[searchtreeOne.Size()];
		 finalfind=searchtreeOne.sortedTree();
		 for(int i=0; i<finalfind.length;i++) {
			 System.out.print(finalfind[i] + " ");
		 }
		 System.out.println();

		 infix(balanceTreeOne(finalfind));
		 System.out.println();
		 
		 searchtreeOne.transformToList();
		 searchtree ptr=searchtreeOne.base;
		 searchtreeOne.infix(searchtreeOne.base);
	 }
	 
	 searchtree repeat(searchtree base, int n) { 
	        if (base == null) { 
	            base = new searchtree();
	            base.data=n;
	            
	            return base; 
	        } 
	        if (n > base.data) 
	            base.right = repeat(base.right, n); 
	        else if (n < base.data) 
	            base.left = repeat(base.left, n); 
	        return base; 
	    } 
	 
	 void move (int value) { 
		 base=repeat(base, value);
	 }
	 void move2(int[] a) {
		 for(int i=0; i<a.length; i++) {
			 move(a[i]);
		 }
	 }
	 int Size() { 
		 return returnSize(base);
	 }
	 
	 int searchMove(int key){ 
	     
	     if(repeatsearch(base, key)==null) {
	    	 System.out.println("Value cannot be found!");
	    	 System.out.println("Number of searching comparisons: " + searchcompare);
	    	 searchcompare=0;
	    	 return 0;
	     }
	     else 
	    	System.out.println("Number of searching comparisons: " + searchcompare);
    	 	searchcompare=0;
	    	return (repeatsearch(base, key)).data; 	
	 } 
	 
	 private searchtree repeatsearch(searchtree base, int key){ 
		 if (base.data > key) { 
		    	searchcompare++;
		        return repeatsearch(base.left, key); 
		 }
		 if (base.data==key) {
			 searchcompare++;
			 return base; 
		 }
		 if (base==null) {
			 searchcompare++; 
	    	 return null;
	     }
	     else {
	    	 searchcompare++;
	    	 return repeatsearch(base.right, key);
	     }
	 }
	 
	 int returnSize(searchtree root) {
		 if (root==null)
			 return 0;
		 else 
	        return(returnSize(root.left) + 1 + returnSize(root.right)); 
	 }
	 
	 public static void infix(searchtree base) {
			if(base== null) {
				return;
			}
			infix(base.left);
			System.out.print(base.data + " "); 
			infix(base.right);
	 }
	  
	 int[] sortedTree() { 	
		int[] result= new int[Size()];
		ArrayList<Integer> arrayOfSearch = new ArrayList<Integer>();
		inorder(base, arrayOfSearch);
		for(int i=0; i<result.length; i++) {
			result[i]=arrayOfSearch.get(i);
		}
		return result;
		
	 }

	 public static ArrayList<Integer> inorder(searchtree base,ArrayList<Integer> arrayOfSearch) {	//helper for sorted tree
			if (base == null) {
				return arrayOfSearch;
			}
			inorder(base.left,arrayOfSearch);
			arrayOfSearch.add(base.data);
			inorder(base.right,arrayOfSearch);
			return arrayOfSearch;
		}
	
	 static searchtree balanceTreeOne(int[] a) {
		 return balance(a, 0, a.length-1);
	 }
	 static searchtree balance(int a[], int start, int end) { 
	        if (start > end) { 
	            return null; 
	        } 
	        int mid = (start + end) / 2; 
	        searchtree newTree = new searchtree(); 
	        newTree.data=a[mid];
	        newTree.left = balance(a, start, mid - 1); 
	        newTree.right = balance(a, mid + 1, end); 
	        return newTree; 
	    } 
	 
	 private searchtree parent(searchtree currentbase, searchtree child) {        
		    if (child==base || currentbase==null){
		            return null;
		    }
		    else{
		        if(currentbase.left==child || currentbase.right==child)
		            return currentbase;
		        else {
		            if (currentbase.data<child.data) {
		                return parent(currentbase.right,child);
		            }
		            else {
		                return parent(currentbase.left,child);
		            }
		        }
		    }
		}  
	 
	 searchtree rotateRight(searchtree h) { 	
		 if (h.left == null) {
	            return h;
	     }
		 if(h==base) {
			 base=h.left;
		 }
		 searchtree oldLeft = h.left; 
	     h.left=oldLeft.right;
	     oldLeft.right=h;
	     return oldLeft;
	 }
	 
	 searchtree rotateLeft(searchtree h) { 		
		 if (h.right == null) {
			 return h;
		 }
		 if(h==base) {
			 base=h.right;
		 }
		 searchtree x=h.right;
		 h.right=x.left;
		 x.left=h;
		 return x;
	 }
	 
	  void transformToList() {
		  if(base.left!=null) {
			  base=rotateRight(base);
		  }
		  while(base.left !=null) {	
			  base=rotateRight(base);
		  }
		  System.out.println("rotating");
			 infix(base);
		  searchtree func=base;
		  func=func.right;
		  while(func !=null) {	
			  while(func.left!=null) {
				  func=rotateRight(func);
				  System.out.println("In process of rotation");
				 infix(base);
				 
			  }
			  func=func.right;
		  }
	  }
	  
	  void balanceTreeTwo() {
		  transformToList();
		  int N=Size();
		  double M= (N+1) - (Math.pow(2, Math.floor((Math.log(N))/Math.log(2))));
		  base=rotateLeft(base);	
		  for(int i=1; i<M; i++) {
			  base=rotateLeft(base.right);
		  }
		  double K= Math.floor(Math.log(N)/Math.log(2)) - 1;
		  base=rotateLeft(base);
		  for(int i=1; i<K; i++) {
			  base=rotateLeft(base.right);
		  }
	  
	  }  
	  
}

