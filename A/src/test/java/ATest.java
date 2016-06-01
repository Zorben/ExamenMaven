import java.io.IOException;
import java.math.BigDecimal;
import java.net.Socket;
import java.sql.Array;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Date;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ATest {

	A clase = new A();
	private String sql = "select count(*) from 1h where convocatoria in	 (junio,septiembre)";
	@Mock
	private Connection databaseConnection;
	@Mock
	private HttpsURLConnection urlConnection;
	@Mock
	private SSLSocketFactory factory;
	@Mock
	private Socket socketActual;
	@Mock
	private CallableStatement callable;
	@Mock
	private Array array;
	@Mock
	private DatabaseMetaData metadata;
	@Mock
	private ResultSet resultSet;
	@Mock
	private ResultSetMetaData resultSetMetadata;


	@Test
	public void testValueIsDivisibleByNumber() throws IOException {
		Assert.assertNotNull(clase.valueIsDivisibleByNumber(new BigDecimal(10), new BigDecimal(3)));
		Assert.assertEquals(new BigDecimal(1), clase.valueIsDivisibleByNumber(new BigDecimal(10), new BigDecimal(3)));
		Assert.assertEquals(new BigDecimal(2), clase.valueIsDivisibleByNumber(new BigDecimal(11), new BigDecimal(3)));

		try {
			clase.valueIsDivisibleByNumber(null, null);
			Assert.fail("nunca se va a ejecutar");
		} catch (NullPointerException e) {
		}

	}

	@Test
	public void testDateBigIsGreaterThanSmall() throws IOException {

		Date before = new Date();
		before.setYear(0);
		Date after = new Date();

		Assert.assertTrue(clase.dateBigIsGreaterThanSmall(before, after));

		try {
			clase.dateBigIsGreaterThanSmall(after, before);
			Assert.fail("nunca se va a ejecutar");
		} catch (Exception e) {
		}

		try {
			clase.dateBigIsGreaterThanSmall(null, null);
			Assert.fail("nunca se va a ejecutar");
		} catch (NullPointerException e) {
		}

	}



	@Test
	public void testDateGreaterThanAWeek() throws IOException {

		Date date = new Date();
		Assert.assertFalse(clase.dateGreaterThanAWeek(date));

		date.setYear(0);
		Assert.assertTrue(clase.dateGreaterThanAWeek(date));

	}

	@Test
	public void testDateGreaterThanAWeekWhenDateIsNull() throws IOException {

		try {
			clase.dateGreaterThanAWeek(null);
			Assert.fail("nunca se va a ejecutar");
		} catch (IllegalArgumentException e) {
		}

	}

	@Test
	public void testCreateSocket() throws IOException {
		Mockito.when(urlConnection.getSSLSocketFactory()).thenReturn(factory);
		Mockito.when(factory.createSocket("localhost", 8080)).thenReturn(socketActual);
		Mockito.when(socketActual.getPort()).thenReturn(8080);
		Assert.assertEquals(8080, clase.createSocket(urlConnection));
	}

	@Test
	public void testisAutoIncrement() throws SQLException, IOException {
		Mockito.when(databaseConnection.getMetaData()).thenReturn(metadata);
		Mockito.when(metadata.getIndexInfo("", "", "", true, false)).thenReturn(resultSet);
		Mockito.when(resultSet.getMetaData()).thenReturn(resultSetMetadata);
		Mockito.when(resultSetMetadata.isAutoIncrement(0)).thenReturn(false);
		clase.isAutoIncrement(databaseConnection);
	}

}
