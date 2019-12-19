package de.hfu;
import org.junit.Test;

public class UtilTest {
	
	@Test
	public void testistErstesHalbjahr() {
		
		
		try {
		assert(Util.istErstesHalbjahr(7));
		}
		catch(ArithmeticException e) {
			
		}
		
		
		}
	
	
}
