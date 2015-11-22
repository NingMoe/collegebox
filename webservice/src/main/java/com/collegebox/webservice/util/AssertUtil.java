package com.collegebox.webservice.util;

import java.util.Collection;
import java.util.Map;

import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import com.collegebox.webservice.exception.CollegeBoxException;

public abstract class AssertUtil {
	
	/**
	 * Assert a boolean expression, throwing {@code IllegalArgumentException}
	 * if the test result is {@code false}.
	 * <pre class="code">Assert.isTrue(i &gt; 0, "The value must be greater than zero");</pre>
	 * @param expression a boolean expression
	 * @param code the exception code to use if the assertion fails
	 * @throws CollegeBoxException if expression is {@code false}
	 */
	public static void isTrue(boolean expression, int code) {
		if (!expression) {
			throw new CollegeBoxException(code);
		}
	}

	/**
	 * Assert that an object is {@code null} .
	 * <pre class="code">Assert.isNull(value, "The value must be null");</pre>
	 * @param object the object to check
	 * @param code the exception code to use if the assertion fails
	 * @throws CollegeBoxException if the object is not {@code null}
	 */
	public static void isNull(Object object, int code) {
		if (object != null) {
			throw new CollegeBoxException(code);
		}
	}

	/**
	 * Assert that an object is not {@code null} .
	 * <pre class="code">Assert.notNull(clazz, "The class must not be null");</pre>
	 * @param object the object to check
	 * @param code the exception code to use if the assertion fails
	 * @throws CollegeBoxException if the object is {@code null}
	 */
	public static void notNull(Object object, int code) {
		if (object == null) {
			throw new CollegeBoxException(code);
		}
	}

	/**
	 * Assert that an array has elements; that is, it must not be
	 * {@code null} and must have at least one element.
	 * <pre class="code">Assert.notEmpty(array, "The array must have elements");</pre>
	 * @param array the array to check
	 * @param code the exception code to use if the assertion fails
	 * @throws CollegeBoxException if the object array is {@code null} or has no elements
	 */
	public static void notEmpty(Object[] array, int code) {
		if (ObjectUtils.isEmpty(array)) {
			throw new CollegeBoxException(code);
		}
	}

	/**
	 * Assert that an array has no null elements.
	 * Note: Does not complain if the array is empty!
	 * <pre class="code">Assert.noNullElements(array, "The array must have non-null elements");</pre>
	 * @param array the array to check
	 * @param code the exception code to use if the assertion fails
	 * @throws CollegeBoxException if the object array contains a {@code null} element
	 */
	public static void noNullElements(Object[] array, int code) {
		if (array != null) {
			for (Object element : array) {
				if (element == null) {
					throw new CollegeBoxException(code);
				}
			}
		}
	}

	/**
	 * Assert that a collection has elements; that is, it must not be
	 * {@code null} and must have at least one element.
	 * <pre class="code">Assert.notEmpty(collection, "Collection must have elements");</pre>
	 * @param collection the collection to check
	 * @param code the exception code to use if the assertion fails
	 * @throws CollegeBoxException if the collection is {@code null} or has no elements
	 */
	public static void notEmpty(Collection<?> collection, int code) {
		if (CollectionUtils.isEmpty(collection)) {
			throw new CollegeBoxException(code);
		}
	}

	/**
	 * Assert that a Map has entries; that is, it must not be {@code null}
	 * and must have at least one entry.
	 * <pre class="code">Assert.notEmpty(map, "Map must have entries");</pre>
	 * @param map the map to check
	 * @param code the exception code to use if the assertion fails
	 * @throws CollegeBoxException if the map is {@code null} or has no entries
	 */
	public static void notEmpty(Map<?, ?> map, int code) {
		if (CollectionUtils.isEmpty(map)) {
			throw new CollegeBoxException(code);
		}
	}

}
