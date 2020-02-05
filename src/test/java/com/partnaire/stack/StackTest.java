package com.partnaire.stack;

import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.google.common.collect.Lists;

public class StackTest {

	@Test(expected = IllegalStateException.class)
	public void testWhenEmptyThenThrow() {
		new Stack().pop();
		Assert.fail("should have raised exception");
	}

	@Test
	public void testWhenPopThenLastAddedElement() {
		final Stack stack = new Stack();
		stack.push(3);
		stack.push(5);
		Assert.assertEquals(5, stack.pop());
		Assert.assertEquals(3, stack.pop());
	}

	@Test
	public void testWhenReverseThenFirstElement() {
		final Stack stack = new Stack();
		stack.push(3);
		stack.push(5);
		stack.push(8);
		stack.reverse();
		Assert.assertEquals(3, stack.pop());
		Assert.assertEquals(5, stack.pop());
		Assert.assertEquals(8, stack.pop());
	}

	@Test
	public void testWhenEmptyThenIsPalindrome() {
		Assert.assertTrue(new Stack().isPalindrome());
	}

	@Test
	public void testWhenSameElementThenIsPalindrome() {
		final Stack stack = new Stack();
		stack.push(2);
		stack.push(2);
		Assert.assertTrue(stack.isPalindrome());
	}

	@Test
	public void testWhenDifferentThenPalindrome() {
		final Stack stack = new Stack();
		stack.push(2);
		stack.push(3);
		Assert.assertFalse(stack.isPalindrome());
	}

	@Test
	public void testWhenOddThenIsPalindrome() {
		final Stack stack = new Stack();
		stack.push(2);
		stack.push(3);
		stack.push(2);
		Assert.assertTrue(stack.isPalindrome());
	}

	@Test
	public void testWhenExample1ThenIsPalindrome() {
		final Stack stack = new Stack();
		stack.push(0);
		stack.push(1);
		stack.push(2);
		stack.push(1);
		stack.push(0);
		Assert.assertTrue(stack.isPalindrome());
	}

	@Test
	public void testWhenExample2ThenIsPalindrome() {
		final Stack stack = new Stack();
		stack.push(4);
		stack.push(1);
		stack.push(1);
		stack.push(4);
		Assert.assertTrue(stack.isPalindrome());
	}

	@Test
	public void testWhenExample3ThenIsPalindrome() {
		final Stack stack = new Stack();
		stack.push(78);
		stack.push(78);
		stack.push(78);
		Assert.assertTrue(stack.isPalindrome());
	}

	@Test
	public void testWhenEmptyAndShuffleThenIsPalindrome() {
		final Stack stack = new Stack();
		stack.shake();
		Assert.assertTrue(stack.canBePalindrom());
	}

	@Test
	public void testWhenPalindromeThenCanBePalindrome() {
		final Stack stack = new Stack();
		stack.push(78);
		stack.push(78);
		stack.push(78);
		stack.shake();
		Assert.assertTrue(stack.canBePalindrom());
	}

	@Test
	public void testWhenExample2AndShakeThenCanBePalindrome() {
		final Stack stack = new Stack();
		stack.push(4);
		stack.push(1);
		stack.push(1);
		stack.push(4);
		stack.shake();
		Assert.assertTrue(stack.canBePalindrom());
	}
	
	@Test
	public void testWhenManualThenCanBePalindrome() {
		final Stack stack = new Stack();
		final List<Integer> manual = Lists.newArrayList(1,2,3,4,5,6,7,8,9);
		Collections.shuffle(manual);
		manual.forEach(stack::push);
		Assert.assertFalse(stack.canBePalindrom());
		Collections.shuffle(manual);
		manual.forEach(stack::push);
		Assert.assertTrue(stack.canBePalindrom());
		stack.push(42);
		Assert.assertTrue(stack.canBePalindrom());
		
	
	}

}
