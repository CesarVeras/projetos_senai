package br.senai.sc;

import java.util.ArrayList;
import java.util.LinkedList;

public class Principal {
	public static void main(String[] args) {
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		LinkedList<Integer> linkedList = new LinkedList<Integer>();

		// ArrayList add
		long startTime = System.currentTimeMillis();

		for (int i = 0; i < 100000; i++) {
			arrayList.add(i);
		}
		long endTime = System.currentTimeMillis();
		double duration = endTime - startTime;
		System.out.println("ArrayList add:  " + duration / 1000);

		// LinkedList add
		startTime = System.currentTimeMillis();

		for (int i = 0; i < 100000; i++) {
			linkedList.add(i);
		}
		endTime = System.currentTimeMillis();
		duration = endTime - startTime;
		System.out.println("LinkedList add: " + duration / 1000);

		// ArrayList get
		startTime = System.currentTimeMillis();

		for (int i = 0; i < 10000; i++) {
			arrayList.get(i);
		}
		endTime = System.currentTimeMillis();
		duration = endTime - startTime;
		System.out.println("ArrayList get:  " + duration / 1000);

		// LinkedList get
		startTime = System.currentTimeMillis();

		for (int i = 0; i < 100000; i++) {
			linkedList.get(i);
		}
		endTime = System.currentTimeMillis();
		duration = endTime - startTime;
		System.out.println("LinkedList get: " + duration / 1000);

		// ArrayList remove
		startTime = System.currentTimeMillis();

		for (int i = 99999; i >= 0; i--) {
			arrayList.remove(i);
		}
		endTime = System.currentTimeMillis();
		duration = endTime - startTime;
		System.out.println("ArrayList remove:  " + duration / 1000);

		// LinkedList remove
		startTime = System.currentTimeMillis();

		for (int i = 99999; i >= 0; i--) {
			linkedList.remove(i);
		}
		endTime = System.currentTimeMillis();
		duration = endTime - startTime;
		System.out.println("LinkedList remove: " + duration / 1000);

	}
}
