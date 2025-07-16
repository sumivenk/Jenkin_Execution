package Generic_Utilities;

import java.util.Random;

public class Java_Utilities {
	
	/**This method is used to avoid Duplicate
	 * @author Sumitha
	 * 
	 */
	
	public int getRandomNum()
	{
		Random ran = new Random();
		int ranNum = ran.nextInt(1000);
		return ranNum;
	}
	

}
