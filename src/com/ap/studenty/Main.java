package com.ap.studenty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {

	public static void main(String[] args) {

		System.out.println(zegar(1, 2, 3, 4));
		System.out.println(zegar(2, 2, 2, 2));
		System.out.println(zegar(0, 0, 0, 0));
		System.out.println(zegar(2, 9, 9, 9));
		System.out.println(zegar(2, 9, 9, 9));
		System.out.println(zegar(1, 9, 9, 9));
		System.out.println(zegar(1, 5, 9, 9));
		System.out.println(zegar(2, 3, 5, 9));
		System.out.println(zegar(2, 4, 6, 0));
		System.out.println(zegar(-2, 9, 9, 9));
		System.out.println(zegar(23, 9, 9, 9));
		System.out.println(zegar(0, 9, 5, 6));

	}

	private static String zegar(int i, int j, int k, int l) {

		ArrayList<Integer> list = new ArrayList<>(Arrays.asList(i, j, k, l));

		ArrayList<Integer> result = new ArrayList<>();
		//sortowanie od najwiekszej
		Collections.sort(list, Collections.reverseOrder());
		//sprawdzanie zakresu wartosci
		for (Integer value : list) {
			if (value < 0 || value > 9)
				return "error";
		}
		//sprawdzenie czy istnieje wartosc od 2 - 0
		for (Integer value : list) {
			if (value <= 2) {
				result.add(value);
				list.remove(value);
				break;
			}
		}
		// nie mozna stworzyc godziny
		if(result.isEmpty())
			return "error";

		
		for (Integer value : list) {
			if (result.get(0) == 2) {
				if (value <= 3) {
					result.add(value);
					list.remove(value);
					break;
				}
			} else {
				if (value <= 9) {
					result.add(value);
					list.remove(value);
					break;
				}
			}
		}
		setMinutes(list, result);

		if (result.size() != 4)
			return "error";

		return result.toString();
}
	
	private static void setMinutes(ArrayList<Integer> list, ArrayList<Integer> result) {
		for (Integer value : list) {
			if (value <= 5) {
				result.add(value);
				list.remove(value);
				break;
			}
		}
		for (Integer value : list) {
			if (value <= 9) {
				result.add(value);
				list.remove(value);
				break;
			}
		}
	}

}
