package beta;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Demo1 {
	private static Logger log = LogManager.getLogger(Demo1.class.getName());

	public static void main(String[] args) {
		log.debug("Debugging");
		int a = 2;
		if (a < 1) {
			log.debug("Object is present");
		} else {
			log.error("Object is not present");
			log.fatal("Fatal");
		}
		log.info("End");
	}
}
