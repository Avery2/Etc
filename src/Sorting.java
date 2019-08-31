public class Sorting {
    public static void main(String[] args) {
        //int[] arr = new int[10];
        int[] arr = {1, 10, 7, 8, 3, 2, 6, 9, 4, 5}; // arr to sort
        
        //initial array (unsorted)
        System.out.println("Unsorted Array");
        printArr(arr);
        //sorting small to large
        bubbleSort(arr);
        //final array (sorted)
        System.out.println("Sorted Array");
        printArr(arr);
    }

    static void bubbleSort(int[] arr) {
    	int temp;
        for(int i=0; i<arr.length-1; i++) {
            if (arr[i]>arr[i+1]) {
            	//swap
            	temp = arr[i];
            	arr[i] = arr[i+1];
            	arr[i+1] = temp;
            }
        }
    }
    
    static void printArr(int[] arr) {
    	for(int i=0; i<arr.length; i++) {
    		System.out.println(arr[i]);
    	}
    }
}

//public class HelloWorld {
//	public static void main(String[] args) {
//		System.out.println("Hello World!");
//	}
//}

// for(Sting x: wName.split(" ")) System.out.print(x);