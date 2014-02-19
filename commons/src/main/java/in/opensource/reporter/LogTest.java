package in.opensource.reporter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogTest {
	static Logger LOG = LoggerFactory.getLogger(LogTest.class);
	
	public static void main(String[] x)
	{
		LOG.info("hello");
		LOG.debug("OMG");
	}
}

