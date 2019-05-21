package utilities;

import bags.UserAccountBag;
import users.UserAccount;

public class SortArraysNew {
	private static UserAccount[] users;
	private static UserAccount[] asInserted;
	private static UserAccount[] afterInserted;
	private static int nElemsAs;
	private static int nElemsAfter;
	private static String timeResult;

	private SortArraysNew() {
	}

	public static UserAccountBag sortArrays(UserAccount[] usersFrom) {
		createArrays(usersFrom);
		return new UserAccountBag(afterInserted, nElemsAfter);
	}

	private static void createArrays(UserAccount[] usersFrom) {
		users = usersFrom;
		asInserted = new UserAccount[users.length];
		afterInserted = new UserAccount[users.length];
		nElemsAs = 0;
		nElemsAfter = 0;
		fillAfterArray();
		System.out.println(timeMethods());
	}

	private static void fillAfterArray() {
		for (int i = 0; i < users.length; i++) {
			if (users[nElemsAfter + 1] != null) {
				afterInserted[nElemsAfter] = users[nElemsAfter++];
				if (users[nElemsAfter + 1] == null) {
					afterInserted[nElemsAfter] = users[nElemsAfter++];
					break;
				}
			}
		}
	}

	private static String timeMethods() {
		long startTime = System.nanoTime();
		afterInserted = insertionSort(afterInserted, nElemsAfter);
		long endTime = System.nanoTime();
		int resultTime = (int) ((endTime - startTime) / 1000000);
		timeResult = resultTime + "ms to complete AfterInserted Method \n";
		startTime = System.nanoTime();
		asInserted = fillAsArray(asInserted);
		endTime = System.nanoTime();
		resultTime = (int) ((endTime - startTime) / 1000000);
		return timeResult += resultTime + "ms to complete AsInserted Method \n";
	}

	private static UserAccount[] fillAsArray(UserAccount[] array) {
		for (int i = 0; i < users.length; i++) {
			if (users[nElemsAs + 1] != null) {
				if (users[nElemsAs + 1] == null) {
					afterInserted[nElemsAfter] = users[nElemsAfter];
					break;
				}
				array[nElemsAs] = users[nElemsAs++];
				insertionSort(array, nElemsAs);
			}
		}
		return array;
	}

	private static UserAccount[] insertionSort(UserAccount[] array, int nElems) {
		int in;
		int out;
		for (out = 1; out < nElems; out++) {
			UserAccount temp = array[out];
			in = out;
			while (in > 0 && array[in - 1].getUserName().compareTo(temp.getUserName()) > 0) {
				array[in] = array[in - 1];
				in--;
			}
			array[in] = temp;
		}
		return array;
	}
}
