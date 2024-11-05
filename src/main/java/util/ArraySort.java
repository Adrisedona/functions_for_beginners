package util;


public final class ArraySort {
	/**
	 * Esta es una libreria de funciones, no se debe instanciar un objeto de esta
	 * clase
	 */
	private ArraySort() {

	}

	public static void swapper(int[] array, int index1, int index2) {
		int swap = array[index1];
		array[index1] = array[index2];
		array[index2] = swap;
	}

	public static void swapper(char[] array, int index1, int index2) {
		char swap = array[index1];
		array[index1] = array[index2];
		array[index2] = swap;
	}

	public static void swapper(double[] array, int index1, int index2) {
		double swap = array[index1];
		array[index1] = array[index2];
		array[index2] = swap;
	}

	public static <T> void swapper(T[] array, int index1, int index2) {
		T swap = array[index1];
		array[index1] = array[index2];
		array[index2] = swap;
	}

	/**
	 * Llamada inicial a un metodo recursivo de ordenacion de arrays
	 * 
	 * @param array array a ordenar
	 */
	public static void quicksort(int[] array) {
		quicksort(array, 0, array.length - 1);
	}

	private static void quicksort(int[] array, int lowIndex, int highIndex) {
		if (lowIndex >= highIndex) {
			return;
		}
		int pivot = array[highIndex];
		int leftPointer = lowIndex;
		int rightPointer = highIndex;
		while (leftPointer < rightPointer) {
			while (array[leftPointer] <= pivot && rightPointer > leftPointer++)
				;
			while (array[rightPointer] >= pivot && leftPointer < rightPointer--)
				;
			swapper(array, leftPointer, rightPointer);
		}
		swapper(array, leftPointer, highIndex);
		quicksort(array, lowIndex, leftPointer - 1);
		quicksort(array, leftPointer + 1, highIndex);
	}

	public static void quicksort(char[] array) {
		quicksort(array, 0, array.length - 1);
	}

	private static void quicksort(char[] array, int lowIndex, int highIndex) {
		if (lowIndex >= highIndex) {
			return;
		}
		char pivot = array[highIndex];
		int leftPointer = lowIndex;
		int rightPointer = highIndex;
		while (leftPointer < rightPointer) {
			while (array[leftPointer] <= pivot && rightPointer > leftPointer++)
				;
			while (array[rightPointer] >= pivot && leftPointer < rightPointer--)
				;
			swapper(array, leftPointer, rightPointer);
		}
		swapper(array, leftPointer, highIndex);
		quicksort(array, lowIndex, leftPointer - 1);
		quicksort(array, leftPointer + 1, highIndex);
	}

	public static void quicksort(double[] array) {
		quicksort(array, 0, array.length - 1);
	}

	private static void quicksort(double[] array, int lowIndex, int highIndex) {
		if (lowIndex >= highIndex) {
			return;
		}
		double pivot = array[highIndex];
		int leftPointer = lowIndex;
		int rightPointer = highIndex;
		while (leftPointer < rightPointer) {
			while (array[leftPointer] <= pivot && rightPointer > leftPointer++)
				;
			while (array[rightPointer] >= pivot && leftPointer < rightPointer--)
				;
			swapper(array, leftPointer, rightPointer);
		}
		swapper(array, leftPointer, highIndex);
		quicksort(array, lowIndex, leftPointer - 1);
		quicksort(array, leftPointer + 1, highIndex);
	}

	public static void bubblesort(char[] array) {
		boolean sorted;
		do {
			sorted = true;
			for (int i = 0; i < array.length - 1; i++) {
				if (array[i] > array[i + 1]) {
					swapper(array, i, i + 1);
					sorted = false;
				}
			}
		} while (!sorted);
	}

	public static void bubblesort(double[] array) {
		boolean sorted;
		do {
			sorted = true;
			for (int i = 0; i < array.length - 1; i++) {
				if (array[i] > array[i + 1]) {
					swapper(array, i, i + 1);
					sorted = false;
				}
			}
		} while (!sorted);
	}

	public static void bubblesort(int[] array) {
		boolean sorted;
		do {
			sorted = true;
			for (int i = 0; i < array.length - 1; i++) {
				if (array[i] > array[i + 1]) {
					swapper(array, i, i + 1);
					sorted = false;
				}
			}
		} while (!sorted);
	}

	public static void mySort(double[] array) {
		for (int i = array.length - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if (array[i] < array[j]) {
					swapper(array, i, j);
				}
			}
		}
	}

	public static void mySort(char[] array) {
		for (int i = array.length - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if (array[i] < array[j]) {
					swapper(array, i, j);
				}
			}
		}
	}

	public static void mySort(int[] array) {
		for (int i = array.length - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if (array[i] < array[j]) {
					swapper(array, i, j);
				}
			}
		}
	}

	/**
	 * Baraja un array de manera aleatoria
	 * 
	 * @param array array a barajar
	 * @param copy  {@code true} para barajar una copia del array, {@code false}
	 *              para barajar el propio array
	 * @return el array barajado, solo es necesario guardar este return cuando el
	 *         parametro {@code copy} es {@code true}
	 */
	public static <T> T[] shuffle(T[] array, boolean copy) {
		T[] arrayReturn;
		if (copy) {
			arrayReturn = array.clone();
		} else {
			arrayReturn = array;
		}
		for (int i = 0; i < arrayReturn.length; i++) {
			swapper(arrayReturn, (int) (Math.random() * arrayReturn.length),
					(int) (Math.random() * arrayReturn.length));
		}
		return arrayReturn;
	}

	/**
	 * Baraja un array de manera aleatoria
	 * 
	 * @param array array a barajar
	 * @param copy  {@code true} para barajar una copia del array, {@code false}
	 *              para barajar el propio array
	 * @return el array barajado, solo es necesario guardar este return cuando el
	 *         parametro {@code copy} es {@code true}
	 */
	public static double[] shuffle(double[] array, boolean copy) {
		double[] arrayReturn;
		if (copy) {
			arrayReturn = array.clone();
		} else {
			arrayReturn = array;
		}
		for (int i = 0; i < arrayReturn.length; i++) {
			ArraySort.swapper(arrayReturn, (int) (Math.random() * arrayReturn.length),
					(int) (Math.random() * arrayReturn.length));
		}
		return arrayReturn;
	}

	/**
	 * Baraja un array de manera aleatoria
	 * 
	 * @param array array a barajar
	 * @param copy  {@code true} para barajar una copia del array, {@code false}
	 *              para barajar el propio array
	 * @return el array barajado, solo es necesario guardar este return cuando el
	 *         parametro {@code copy} es {@code true}
	 */
	public static int[] shuffle(int[] array, boolean copy) {
		int[] arrayReturn;
		if (copy) {
			arrayReturn = array.clone();
		} else {
			arrayReturn = array;
		}
		for (int i = 0; i < arrayReturn.length; i++) {
			ArraySort.swapper(arrayReturn, (int) (Math.random() * arrayReturn.length),
					(int) (Math.random() * arrayReturn.length));
		}
		return arrayReturn;
	}

	/**
	 * Baraja un array de manera aleatoria
	 * 
	 * @param array array a barajar
	 * @param copy  {@code true} para barajar una copia del array, {@code false}
	 *              para barajar el propio array
	 * @return el array barajado, solo es necesario guardar este return cuando el
	 *         parametro {@code copy} es {@code true}
	 */
	public static char[] shuffle(char[] array, boolean copy) {
		char[] arrayReturn;
		if (copy) {
			arrayReturn = array.clone();
		} else {
			arrayReturn = array;
		}
		for (int i = 0; i < arrayReturn.length; i++) {
			ArraySort.swapper(arrayReturn, (int) (Math.random() * arrayReturn.length),
					(int) (Math.random() * arrayReturn.length));
		}
		return arrayReturn;
	}
}
