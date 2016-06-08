import static org.junit.Assert.*;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;


public class ATestJUnit {
	A a = new A();
	
	
	@Test
	public void testDateGreaterThanAWeek() {
		Date date1 = new Date(2017, 8, 4);
		Date date2 = new Date();
		date2.setYear(0); // date2 tiene como año 1900
		Date date = null;
		
		//devuelve un valor no nulo
		assertNotNull(a.dateGreaterThanAWeek(date1));
		assertNotNull(a.dateGreaterThanAWeek(date2));
		
		//devuelve valor que corresponde segun parametro introducido
		assertFalse(a.dateGreaterThanAWeek(date1));
		assertTrue(a.dateGreaterThanAWeek(date2));
		
		//devuelve excepcion cuando el parametro es nulo
		try {
			a.dateGreaterThanAWeek(date);
			Assert.fail("nunca se va a ejecutar");
		} catch (IllegalArgumentException e) {
		}
		
	
	}
	
	@Test
	public void testDateBigIsGreaterThanSmall() {
		Date dateB4 = new Date(2014, 8, 4);
		Date dateAF = new Date(2017, 8, 4);
		
		//devuelve valor que corresponde segun parametro introducido
		assertNotNull(a.dateBigIsGreaterThanSmall(dateB4, dateAF));
		assertTrue(a.dateBigIsGreaterThanSmall(dateB4, dateAF));
		
		
		//devuelve excepcion cuando el parametro es nulo o incorrecto
		try {
			a.dateBigIsGreaterThanSmall(dateAF, dateB4); // parametros invertidos
			Assert.fail("nunca se va a ejecutar");
		} catch (IllegalArgumentException e) {
		}

		try {
			a.dateBigIsGreaterThanSmall(null, null);
			Assert.fail("nunca se va a ejecutar");
		} catch (NullPointerException e) {
		}
		
		
	}
	
	@Test
	public void testValueIsDivisibleByNumber(){
		//devuelve un valor no nulo
		Assert.assertNotNull(a.valueIsDivisibleByNumber(new BigDecimal(10), new BigDecimal(3)));
		
		//devuelve valor que corresponde segun parametro introducido
		Assert.assertEquals(new BigDecimal(1), a.valueIsDivisibleByNumber(new BigDecimal(10), new BigDecimal(3)));
		Assert.assertEquals(new BigDecimal(2), a.valueIsDivisibleByNumber(new BigDecimal(11), new BigDecimal(3)));
		
		//devuelve excepcion cuando el parametro es nulo o incorrecto
		try {
			a.valueIsDivisibleByNumber(null, null);
			Assert.fail("nunca se va a ejecutar");
		} catch (NullPointerException e) {
		}

	}
}
