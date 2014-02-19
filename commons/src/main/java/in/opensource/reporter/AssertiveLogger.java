package in.opensource.reporter;

import org.apache.log4j.Logger;

public class AssertiveLogger {
	Logger log = null;

	public AssertiveLogger(Class<?> clazz) {
		log = Logger.getLogger(clazz);
	}

	public void info(String message) {
		if (log.isInfoEnabled())
			log.info(message);
	}

	public void info(String message, Throwable t) {
		if (log.isInfoEnabled())
			log.info(message, t);
	}

	public void debug(String message) {
		if (log.isDebugEnabled())
			log.debug(message);
	}

	public void debug(String message, Throwable t) {
		if (log.isDebugEnabled())
			log.debug(message, t);
	}

	public void error(String message) {
		log.error(message);
	}

	public void error(String message, Throwable t) {
		log.error(message, t);
	}

	public void error(Throwable t) {
		log.error(t);
	}

	public void warn(String message, Throwable t) {
		log.warn(message, t);
	}

	public void warn(String message) {
		log.warn(message);
	}
}
