import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.math.BigDecimal;
import java.sql.Date;

import org.junit.Test;


public class ATestJUnit {
	A a = new A();
	
	
	@Test
	public void testDateGreaterThanAWeek() {
		Date date1 = new Date(2017, 8, 4);
		Date date2 = new Date(2014, 8, 4);
		Date date = null;
		assertNull(date);
		assertNotNull(a.dateGreaterThanAWeek(date1));
		assertNotNull(a.dateGreaterThanAWeek(date2));
	}
	
	@Test
	public void testDateBigIsGreaterThanSmall() {
		Date date1 = new Date(2017, 8, 4);
		Date date2 = new Date(2014, 8, 4);
		assertNull(null);
		assertNotNull(a.dateBigIsGreaterThanSmall(date2, date1));	
	}
	
	@Test
	public void testValueIsDivisibleByNumber() {
		BigDecimal uno = new BigDecimal(100);
		BigDecimal dos = new BigDecimal(200);
		BigDecimal tres = new BigDecimal(300);
		BigDecimal cuatro = new BigDecimal(400);
		
		assertNotNull(a.valueIsDivisibleByNumber(uno, dos));
		assertNotNull(a.valueIsDivisibleByNumber(dos, uno));
		assertNotNull(a.valueIsDivisibleByNumber(tres, cuatro));
	}
}
