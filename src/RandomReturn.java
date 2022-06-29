public class RandomReturn {

	/**
	 * @return a random number in range of 1 - 10.
	 */
	static public int randomNumber() {
		int randomNumber = (int)(Math.random() * 10 + 1 );
		
			return randomNumber;
	}

	static public int fromRangeOf(int min, int max) {
		int randomNumber = (int)(Math.random() * (max - min +1) + min );

			return randomNumber;
	}


}