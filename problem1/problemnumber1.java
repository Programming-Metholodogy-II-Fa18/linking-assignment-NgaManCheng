
public class problemnumber1 {

	    public static void main(String[] args){
	    	
	    	int sortArray [];  //introduce array that need to test a given array of integers ... storage place for sorts integers
	        problemnumber1 test = new problemnumber1();
	        int[] inputOfArrayNumbers = {7, -48, 89};
	        sortArray = test.sort(inputOfArrayNumbers);
	        
	        for ( int i = 0; i<sortArray.length; i++) //traverses through the array to sort each entry 
	        {
	            System.out.println(sortArray[i]);
	        }
	    }

	    public int[] sort(int readArray[]){ // sorting algorithm
	        
	        int biggest = 0;
	        int sizeArray = readArray.length;
	        int sortCheck;
	        int heldInt;

	        for(int i = 0; i < sizeArray; i++)
	        {
	            heldInt = readArray[i];
	            sortCheck = String.valueOf(heldInt).length();
	            if(sortCheck > biggest)
	            {
	            	biggest = sortCheck;
	            }
	        }

	    for(int j = 1; j < biggest +1; j++) //insert the sorted number into the array and after return
	    {
	        for (int b = 0; b < readArray.length - 1; b++)
	        {
	            int index = b;
	            for (int k = b + 1; k < readArray.length; k++)
	            	if((int)(readArray[ k ]%Math.pow(10,j)/10) < ((int)readArray[index]%Math.pow(10,j)/10) ) {
	                    index = k;
	      
	                    int smallerInt = readArray[index];  
	                    readArray[index] = readArray[b];
	                    readArray[b] = smallerInt;
	        }
	        
	    }
	    
	    }

	    return readArray;
	}
}
