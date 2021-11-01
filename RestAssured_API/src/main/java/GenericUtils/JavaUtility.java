package GenericUtils;

import java.util.Random;

public class JavaUtility {
	
	public int getrandom() {
		Random ram = new Random();
		int random = ram.nextInt(1000);
		return random;
	}

}
