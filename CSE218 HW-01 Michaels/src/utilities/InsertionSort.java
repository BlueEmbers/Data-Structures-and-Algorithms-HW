package utilities;

import people.Name;

public class InsertionSort {
		private static int nElems;
		private static Name[] sorted;
		
		private InsertionSort(){
		}
		
		public static Name[] sort(Name[] names) {
			sorted = new Name[names.length];
			for(int i = 0; i < names.length; i++) {
				sorted[nElems] = names[nElems++];
			}
			return insertionSort();
		}
		
		public static Name[] insertionSort() {
			int in;
			int out;
			
			for(out = 1; out < nElems; out++) {
				Name temp = sorted[out];
				in = out;
				
				while(in > 0 && sorted[in - 1].compareTo(temp) > 0) {
					sorted[in] = sorted[in - 1];
					in--;
				}
				sorted[in] = temp;
			}
			return sorted;
		}
		
	}
