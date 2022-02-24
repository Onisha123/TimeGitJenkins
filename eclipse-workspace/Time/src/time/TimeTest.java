package time;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class TimeTest {

	
	
	//Miliseconds
	@Test
	public void testGetMiliseconds() {
		int milliseconds = Time.getMilliseconds("10:59:59:005");
		assertTrue("The Milliseconds are calculated wong",milliseconds==5);
	}
	
	@Test
	public void testBoundaryGetMiliseconds() {
		assertThrows(StringIndexOutOfBoundsException.class, ()-> {Time.getMilliseconds("10:00:");});
		
	}
	
	@ParameterizedTest
	@ValueSource(strings = { "05:00:00:000", "05:00:00:000" })
	void testGetTotalMilisecondsSecondsBoundary(String candidate) {
	int millisecondsseconds = Time.getMilliseconds(candidate);
	assertTrue("The hours were not calculated properly", millisecondsseconds == 0000);
	}
	
	//TotalSeconds
	@Test
	public void testGetTotalSecondsGood() 
	{
	int seconds = Time.getTotalSeconds("05:05:05");
	assertTrue("The seconds were not calculated  properly", seconds==18305);
	}

	@Test
	public void testGetTotalSecondsBad() 
	{
	assertThrows(StringIndexOutOfBoundsException.class, ()-> {Time.getTotalSeconds("10:00");});
	}
	

	@ParameterizedTest
	@ValueSource(strings = { "05:00:00", "05:00:00" })
	void testGetTotalSecondsBoundary(String candidate) {
	int seconds = Time.getTotalSeconds(candidate);
	assertTrue("The hours were not calculated properly", seconds ==18000 );
	}

	
    //Minutes
	@Test
	public void testGetTotalMinutesGood() 
	{
	int minutes = Time.getTotalMinutes("05:05:05");
	assertTrue("The seconds were not calculated  properly", minutes==5);
	}

	
	@Test
	public void testGetTotalMinutesBad() 
	{
	assertThrows(StringIndexOutOfBoundsException.class, ()-> {Time.getTotalMinutes("10");});
	}
	

	
	@ParameterizedTest
	@ValueSource(strings = { "05:03:00", "05:03:59" })
	void testGetTotalMinutesBoundary(String candidate) {
	int minutes = Time.getTotalMinutes(candidate);
	assertTrue("The minutes were not calculated properly", minutes == 3);
	}
	
	
	//Hours
	
	@Test
	public void testGetTotalHoursGood() 
	{
	int hours = Time.getTotalHours("05:05:05");
	assertTrue("The seconds were not calculated  properly", hours==5);
	}
	
	
	@Test
	public void testGetTotalHoursBad() 
	{
	assertThrows(StringIndexOutOfBoundsException.class, ()-> {Time.getTotalMinutes("100");});
	}
	
	@ParameterizedTest
	@ValueSource(strings = { "05:00:00", "05:59:59" })
	void testGetTotalHours(String candidate) {
	int hours = Time.getTotalHours(candidate);
	assertTrue("The hours were not calculated properly",hours ==5);
	}


	//GetSeconds
	
	@Test
	public void testGetSecondsGood() 
	{
	int seconds = Time.getSeconds("05:05:05");
	assertTrue("The seconds were not calculated  properly", seconds==5);
	}

	@Test
	public void testGetSecondsBad() 
	{
	assertThrows(StringIndexOutOfBoundsException.class, ()-> {Time.getTotalSeconds("10");});
	}
	
	@ParameterizedTest
	@ValueSource(strings = { "05:00:00", "05:00:00" })
	void testGetSecondsBoundary(String candidate) {
	int seconds = Time.getSeconds(candidate);
	assertTrue("The hours were not calculated properly", seconds ==0);
	
	
	}

	


/*	@Test
	void testGetSeconds() {
		fail("Not yet implemented");
	}

	@Test
	void testGetTotalMinutes() {
		fail("Not yet implemented");
	}

	@Test
	void testGetTotalHours() {
		fail("Not yet implemented");
	}
*/
}
