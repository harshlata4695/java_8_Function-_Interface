package com.harshlata;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

//===============================================================================

/* The function interface has an abstract method apply which takes argument of type T and return of type R.
 * 
 *  public interface Function
 *  {
 *  public R apply(T t);
 *  }
 *  
*/

//================================================================================

/*   Stream Pipeline - Java streams are designed in such a way that most of the stream operations (called intermediate operations) return a Stream. This helps to create a chain of stream operations. This is called stream pipe-lining.
   Note - that a stream maintains the same ordering of the elements as the ordering in the stream source.
*/

//=================================================================================

/*Function Chaning - we can  apply more than one function on a single input (Both are default functions in Function Interface)
  1. andThen - call first calling function and then passed function
  2. compose - execute first passed function and then call
*/

//=================================================================================

// Differernce between Predicate and function interface

/*
 * 1. Predicate - is one of the functional interface. and it takes one argument and return true or false.
 * 2. prediacte always return true or false whereas function provide that which we have provided
*/

//==================================================================================
// BiFunction<T ,U , R>

/*1. T -> First Argument
2. U -> Second Argument
3. R -> return
*/

//===================================================================================

// what are variants of Function Interface

/*1. IntFunction  , LongFunction , DoubleFunction ; arguments are of specified type , return type is parameterized.
2. ToIntFunction ,ToLongFunction , ToDoubleFunction : return type is of specified type , arguments are parameterized.
3. DoubleToIntFunction , DoubleToLongFunction , IntToDoubleFunction , IntToLongFunction , LongToIntFunction   , LongToDoubleFunction : having oth argument and return type defined as primitive types , as specified by their names.
*/

public class FunctionDemo {

	public static void main(String[] args) {

		// example to understand function interface

		Function<String, Integer> function = (str) -> str.length();
		System.out.println("print length of string " + function.apply("harshlata"));

		// example to understand method chaning in function interface ( functionality of
		// andThen & compose)

		Function<String, String> convertToUpperCase = (str) -> str.toUpperCase();
		Function<String, String> concatFirstNameAndLastName = (str) -> new String(str + " gupta ");

		System.out.println("full name : " + concatFirstNameAndLastName.andThen(convertToUpperCase).apply("harshlata"));

		// example to understand difference between predicate and function interface

		Predicate<String> p = x -> x.length() > 5;
		System.out.println("p = " + p.test("harshlata"));

		Function<String, Boolean> f = s -> s.length() > 5;
		System.out.println("f = " + f.apply("harshlata"));

		// example of BIFunction

		BiFunction<String, String, String> concatName = (s1, s2) -> s1.concat(s2);
		System.out.println("fetch name using Bifunction " + concatName.apply("harshu ", "gupta"));

	}
}
