import java.lang.Object;
import java.util.Arrays;

public class problemnumber4 {

	public static void main(String[] args) {
		//anylse new array
		int[] a= {4, 1,2, 3, 5, 6, 2 , 4};
		
		int size=a.length;
		
		int[] output=problem4parta(a, size);
		
		printArray(output);
	}
	public static void printArray(int[] output) {
		System.out.print("[ ");
		
			for(int i=0; i<output.length; i++) {
				System.out.print(output[i] + " ");
			}
		System.out.println("]");
	}
	//where sorting happens
	public static int[] problem4parta(int[] a, int arrsize){
		int midlocate;
		boolean odd;
		Arrays.sort(a);
		int[] maxormin=new int[arrsize];
		//locating middle point
			if(arrsize%2==0) {
				odd=false;
				midlocate=arrsize/2;
			}
			else {
				odd=true;
				midlocate=(arrsize/2)+1;
			}
		
		int[] maxes=new int[arrsize-midlocate];
		int[] mins=new int[midlocate];
		
		int count=midlocate;
		//locating sorted mid point
			for(int i=0; i<arrsize-midlocate; i++) {
				maxes[i]=a[count];
				count++;
			}
			//merging 
			for(int i=0; i<midlocate; i++) {
				mins[i]=a[i];
			}

		int count2=0;
		//merging
			for(int i=0; i< mins.length; i++) {
				maxormin[count2]=mins[i];
				count2+=2;
			}
		int count3=1;
		
			for(int i=0; i< maxes.length; i++) {
				maxormin[count3]=maxes[i];
				count3+=2;
			}
		
	return maxormin;
	}
	
}
