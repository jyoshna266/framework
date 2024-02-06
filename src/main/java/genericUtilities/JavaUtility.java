package genericUtilities;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * this class contains reasuble method to perform java realted operations
 * @author 91630
 */
public class JavaUtility {
	/**
	 * this method fetches current date and time in specified format
	 * 
	 * @return
	 */
	public String getCurrentTime() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd_MM_yy_hh_mm_ss");
		return sdf.format(date);
	}

}
