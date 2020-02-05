package com.partnaire.stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.google.common.base.Preconditions;

public class Stack {

	final List<Integer> stack;

	public Stack() {
		this.stack = new ArrayList<>();
	}

	void push(final Integer i) {
		this.stack.add(i);
	}

	int pop() {
		Preconditions.checkState(!this.stack.isEmpty());
		final Integer last = this.stack.get(this.stack.size() - 1);
		this.stack.remove(this.stack.size() - 1);
		return last;
	}

	void print() {
		this.stack.forEach(System.out::println);
	}

	void reverse() {
		Collections.reverse(stack);
	}

	void shake() {
		Collections.shuffle(stack);
	}

	boolean isPalindrome() {

		if (this.stack.isEmpty()) {
			return true;
		}

		// quick
		final List<Integer> reversed = this.stack.stream().collect(Collectors.toList());
		Collections.reverse(reversed);
		return stack.equals(reversed);
	}

	boolean canBePalindrom() {

		// on map Clef / Nombre d'occurence
		final Map<Integer, Long> mapped = this.stack.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		if (this.stack.size() % 2 == 0) {
			//Si pair, tous les elements doivent se retrouver n fois, où n est pair
			return mapped.entrySet().stream().allMatch(entry -> entry.getValue() % 2 == 0);
		} else {
			// Si impair, un seul element doit se retrouver une fis
			return mapped.entrySet().stream().filter(entry -> entry.getValue() % 2 == 1).count() == 1;
		}
	}
}
