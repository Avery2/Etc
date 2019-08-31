
public class learning {

	public static void main(String[] args) {
		System.out.println("Hello World!");
//		for (int i=0; i<10; i++) {
//			System.out.println(i);
//		}
		
		int[] arr = new int[5]; // {0, 0, 0, 0, 0} // arr[4]
		int[][] arr2 = new int[5][5];
		
//		arr[4] = 8;
//		System.out.println(arr[4]);
		
		for (int i=0; i<arr.length; i++) {
			arr[i] = i;
		}
		
		for (int i=0; i<arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

}
