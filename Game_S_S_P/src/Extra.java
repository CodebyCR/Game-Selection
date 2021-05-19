/********************************************************************************************************
*																										*
*										Christoph Rohde - Extra Class									*
*																										*
*									All rights reserved - Version 1.0									*
*																										*
**											- Rendom Numbers	-										*
*																										*
********************************************************************************************************/

public class Extra {
	int min;
	int max;

	static public int rendom_num_default() {
		int rendom_num_default = (int)(Math.random() * 10 + 1 );	
		
			return rendom_num_default;		
	}

	static public int rendom_num(int min, int max) {
		int rendom_num = (int)(Math.random() * (max - min +1) + min );	
		
			return rendom_num;
	}

}