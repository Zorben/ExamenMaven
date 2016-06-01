import java.io.IOException;
import java.io.Reader;
import java.net.Socket;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;




import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ATestMockito {
	A a = new A();
	Boolean b;

	@Mock
	Connection con;
	@Mock
	DatabaseMetaData dbmd;
	@Mock
	ResultSet rs;
	@Mock
	ResultSetMetaData rmd;
	int x = 1;

	@Mock
	HttpsURLConnection huc;
	@Mock
	SSLSocketFactory sss;
	@Mock
	Socket soc;





	/*
	public boolean isAutoIncrement(Connection con) throws SQLException {
		DatabaseMetaData metadata = con.getMetaData();
		ResultSet resultSet = metadata.getIndexInfo("", "", "", true, false);
		return resultSet.getMetaData().isAutoIncrement(0);
	}*/

	@Test
	public void testIsAutoIncrement() throws SQLException {
		Mockito.when(con.getMetaData()).thenReturn(dbmd);
		Mockito.when(dbmd.getIndexInfo("", "", "", true, false)).thenReturn(rs);
		Mockito.when(rs.getMetaData()).thenReturn(rmd);
		a.isAutoIncrement(con);
	}

	/*
	public int createSocket(HttpsURLConnection connection) throws IOException {
		SSLSocketFactory sslFactory = connection.getSSLSocketFactory();
		Socket createSocket = sslFactory.createSocket("localhost", 8080);
		return createSocket.getPort();
	}*/

	@Test
	public void testCreateSocket() throws IOException {
		Mockito.when(huc.getSSLSocketFactory()).thenReturn(sss);
		Mockito.when(sss.createSocket("localhost", 8080)).thenReturn(soc);
		Mockito.when(soc.getPort()).thenReturn(x);
		a.createSocket(huc);
	}

}
