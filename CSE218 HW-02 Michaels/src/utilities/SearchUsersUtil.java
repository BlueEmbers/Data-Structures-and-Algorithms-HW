package utilities;

import java.util.Arrays;

import users.UserAccount;

public class SearchUsersUtil {
	private static UserAccount[] usersWithoutNulls;

	private SearchUsersUtil() {
	}

	public static void createArrayNoNulls(UserAccount[] users) {
		usersWithoutNulls = new UserAccount[CountNamesUtil.getUserAmount()];
		removeNulls(users);
	}

	private static void removeNulls(UserAccount[] users) {
		int endCondition = 1;
		int nElems = 0;
		do {
			for (UserAccount user : users) {
				if (nElems == usersWithoutNulls.length) {
					usersWithoutNulls = Arrays.copyOf(usersWithoutNulls, usersWithoutNulls.length + 1);
				}
				if (user == null) {
					endCondition = 0;
					break;
				} else if (user != null) {
					usersWithoutNulls[nElems++] = user;
				}
			}
		} while (endCondition != 0);
		usersWithoutNulls = Arrays.copyOf(usersWithoutNulls, usersWithoutNulls.length - 1);
	}

//	public static UserAccount getUserFromUserName(String userName) {
//		return usersWithoutNulls[Arrays.binarySearch(usersWithoutNulls,new UserAccount(null, null, null, null, 0.0, userName, null), (a, b) -> a.compareTo(b))];
//	}
	public static UserAccount getUserFromUserName(String userName) {
		int l = 0;
		int r = usersWithoutNulls.length - 1;
		while (l <= r) {
			int m = l + (r - l) / 2;
			if (usersWithoutNulls[m].getUserName().compareTo(userName) == 0) {
				return usersWithoutNulls[m];
			}
			if (usersWithoutNulls[m].getUserName().compareTo(userName) < 0) {
				l = m + 1;
			} else
				r = m - 1;
		}
		return null;
	}

}
