public class RandomGame {
	int min;
	int max;


	/**
	 * @return a rendom number between in range of 1 - 10.
	 */
	static public int rendomNumber() {
		int rendomNumber = (int)(Math.random() * 10 + 1 );
		
			return rendomNumber;
	}

	static public int rendomNumber(int min, int max) {
		int rendomNumber = (int)(Math.random() * (max - min +1) + min );

			return rendomNumber;
	}

}