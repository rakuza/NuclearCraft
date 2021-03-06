package nc.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ArrayHelper {
	
	public static <T> List<T> asList(T[] array) {
		List<T> list = new ArrayList<T>();
		for (T t : array) list.add(t);
		return list;
	}
	
	public static <T> List<T> intersect(List<T> list1, List<T> list2) {
		List<T> list = new ArrayList<T>();
		for (T t : list1) if(list2.contains(t)) list.add(t);
		return list;
	}
	
	public static <T> List<T> intersect(List<T> first, List<T>... rest) {
		List<T> tList = new ArrayList<T>();
		tList.addAll(first);
		for (List<T> list : rest) tList = intersect(tList, list);
		return tList;
	}
	
	public static <T> List<T> union(List<T> first, List<T>... rest) {
		Set<T> set = new HashSet<T>();
		set.addAll(first);
		for (List<T> list : rest) set.addAll(list);
		return new ArrayList<T>(set);
	}
	
	public static <T> T[] concatenate(T[] first, T[]... rest) {
		int totalLength = first.length;
		for (T[] array : rest) totalLength += array.length;
		T[] result = Arrays.copyOf(first, totalLength);
		int offset = first.length;
		for (T[] array : rest) {
			System.arraycopy(array, 0, result, offset, array.length);
			offset += array.length;
		}
		return result;
	}
	
	public static <T> T[] concatenate(T[] first, T... rest) {
		int totalLength = first.length + rest.length;
		T[] result = Arrays.copyOf(first, totalLength);
		int offset = first.length;
		System.arraycopy(rest, 0, result, offset, rest.length);
		return result;
	}
	
	public static <T> List<T> concatenate(List<T> first, List<T>... rest) {
		List<T> result = new ArrayList<T>();
		result.addAll(first);
		for (List<T> list : rest) result.addAll(list);
		return result;
	}
	
	public static List concatGeneral(List first, List... rest) {
		List result = new ArrayList();
		result.addAll(first);
		for (List list : rest) result.addAll(list);
		return result;
	}
	
	/* NCInfo */
	
	public static <T> boolean isEmpty(T[][] arrays, int arrayNo) {
		if (arrays.length <= arrayNo) return true;
		else return arrays[arrayNo].length == 0;
	}
	
	public static <T> boolean isNull(T[][] arrays, int arrayNo) {
		if (arrays.length <= arrayNo) return false;
		else return arrays[arrayNo] == null;
	}
	
	/* ****** */
	
	public static int sum(int[] numberArray) {
		int result = 0;
		for (int i = 0; i < numberArray.length; i++) result += numberArray[i];
		return result;
	}
	
	public static double sum(double[] numberArray) {
		double result = 0D;
		for (int i = 0; i < numberArray.length; i++) result += numberArray[i];
		return result;
	}
	
	// Special cases for primitives
	
	public static List<Integer> asIntegerList(int[] array) {
		List<Integer> list = new ArrayList<Integer>();
		for (int t : array) list.add(t);
		return list;
	}
	
	public static List<Double> asDoubleList(double[] array) {
		List<Double> list = new ArrayList<Double>();
		for (double t : array) list.add(t);
		return list;
	}
	
	public static List<Float> asFloatList(float[] array) {
		List<Float> list = new ArrayList<Float>();
		for (float t : array) list.add(t);
		return list;
	}
	
	// List to Array
	
	public static int[] asIntegerArray(List<Integer> list) {
		int[] array = new int[list.size()];
		for (int i = 0; i < list.size(); i++) array[i] = list.get(i);
		return array;
	}
	
	public static double[] asDoubleArray(List<Double> list) {
		double[] array = new double[list.size()];
		for (int i = 0; i < list.size(); i++) array[i] = list.get(i);
		return array;
	}
	
	public static float[] asFloatArray(List<Float> list) {
		float[] array = new float[list.size()];
		for (int i = 0; i < list.size(); i++) array[i] = list.get(i);
		return array;
	}
	
	public static String[] asStringArray(List<String> list) {
		String[] array = new String[list.size()];
		for (int i = 0; i < list.size(); i++) array[i] = list.get(i);
		return array;
	}
	
	// Other methods
	
	public static int[] increasingArray(int start, int length) {
		int[] array = new int[length];
		for (int i = 0; i < length; i++) array[i] = start + i;
		return array;
	}
	
	public static int[] increasingArray(int length) {
		return increasingArray(0, length);
	}
}
