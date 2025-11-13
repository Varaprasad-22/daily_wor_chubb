package training;

public class PaymentSystem {

	public static void Sorting() {
		// TODO Auto-generated method stub
		int a[]={1002,110,23445,6789,9807,6455,75432};
		boolean flag=false;
//		for(int i=0;i<a.length;i++) {
//			if(a[i]==8) {
//				System.out.println("Found -Linear Search");
//				flag=true;
//			}
//		}
//		if(!flag) {
//			System.out.println("Not Found");
//		}
//		flag=false;
		//Insertion Sort 
				for (int i = 1; i < a.length; i++) {
		            int key = a[i];
		            int j = i - 1;
		            while (j >= 0 && a[j] > key) {
		                a[j + 1] = a[j];
		                j--;
		            }

		            a[j + 1] = key;
		        }
		for(int i:a) {
			System.out.println(i);
		}
		int l=0,h=a.length-1;
		while(l<=h) {
			int mid=(l+h)/2;
			if(a[mid]==1002) {
				System.out.println("Found");
				flag=true;
				break;
			}else if (a[mid] <1002) {
		        l = mid + 1;
		    } else {
		        h = mid - 1;
		    }
		}
		if(!flag) {
			System.out.println("Not Found");
		}

	}

}
