import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Test;

public class JodaTest {

	private static final String DATE_FORMAT = "E, dd MM YYYY HH:mm:ss z";

	@Test
	public void LastModifiedDate_변환_테스트() {
		DateTime time = new DateTime();
		System.out.println(time.toDateTime(DateTimeZone.UTC).toString(DATE_FORMAT).replace("UTC", "GMT"));
	}

	@Test
	public void if_modified_since_변환_테스트() {
		String dateString = "Thu, 23 04 2015 05:49:08 GMT";
		DateTimeFormatter formatter = DateTimeFormat.forPattern(DATE_FORMAT);
		DateTime reqTime = DateTime.parse(dateString, formatter);
		System.out.println("reqTime = " + reqTime);
	}
}
