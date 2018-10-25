package assignment3;

import java.util.Arrays;

public class heap {

	private static int[] array;
	
	private int storageNumberAmount;
	
    private int numberChild;
    
    private int sizing;


    public heap(int n) {
        this.array = new int[10];
        
       	this.storageNumberAmount = 0;
       	
    	this.numberChild = n;
    	
        this.sizing=array.length;
    }
  
    private void doubleArray(){
    	
        int[] doubledArr = new int[sizing*2]; 
        
        for (int i=0;i<sizing;i++)
        	
            doubledArr[i]=array[i];
        	array=doubledArr;
            sizing*=2;
    
    }
	
    public void insert(int n){
    	
    	if(storageNumberAmount==sizing){
    		doubleArray();
    	}
    	
    	array[storageNumberAmount]=n;
    	
    	name(storageNumberAmount);
    	
    	storageNumberAmount++;
    }
    
    public void name(int n){
    	int value;
    	value=array[n];
    	int index=(n-1)/numberChild;
    	while((n>0) && (array[index]<value)){
    		array[n]=array[index];
    		n=index;
    		index=(index-1)/numberChild;
    	}
    	array[n]=value;
    }
    
    public int finalMax(){
        int max=array[0];
        
        array[0]=array[storageNumberAmount-1];
        array[storageNumberAmount-1]=0;
        storageNumberAmount--;
        sink(0);
        return max;
    }
    
    private void sink(int n){
        int largestindex;
        int val=array[n];
        int quot=storageNumberAmount/numberChild;
        while(n<quot) {
            largestindex = largestChild(n);
            if (array[largestindex] <= val) {
                break;
            }
            array[n] = array[largestindex];
            n = largestindex;
        }
        array[n]=val;
    }

    private int largestChild(int n){    
    	
    	int largeIndex=numberChild*n+1;
        int max=array[largeIndex];
        for(int i=0;i<numberChild;i++){
        	
            if ((array[(numberChild*n)+(i+1)]!=0) && array[(numberChild*n)+(i+1)]>max){
                max=array[(numberChild*n)+(i+1)];
                largeIndex=(numberChild*n)+(i+1);
            }
            
        }
        return largeIndex;

    }

  
    void heapfind(int arr[], int n, int i){
        int largestNumber = i;
        largestNumber=largestChild(i);
        
        if (largestNumber != i)
        {
            int swap = arr[i];
            arr[i] = arr[largestNumber];
            arr[largestNumber] = swap;

       
            heapfind(arr, n, largestNumber);
        }
    }

    
    

    public int[] daryHeapsort() {	
    	
    	sort(array);
    	return array;
 
    }
    


    public void sort(int arr[]){
        int n = arr.length;

      
        for (int i = n / 2 - 1; i >= 0; i--)
            heapfind(arr, n, i);

        
        for (int i=n-1; i>=0; i--)
        {
            
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

          
            heapfind(arr, i, 0);
        }
    }
    
    
    //what runs at ends of all the code
    public static void main(String[]args) {
    	heap heap= new heap(3);
    	
        int[] array = {3,5,6,12,1,8, 10, 9, 13, 4, 7,1};
        
        for(int i=0; i<array.length; i++) {
    		heap.insert(array[i]);
    	}
        
        System.out.println(Arrays.toString(array));
        
        heap.finalMax();
        System.out.println(Arrays.toString(array));
        heap.finalMax();
        System.out.println(Arrays.toString(array));
        
        heap.sort(array);
        
    }

}
