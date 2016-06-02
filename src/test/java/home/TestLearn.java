package home;

import java.text.DateFormat;
import java.util.Date;

import org.junit.Test;

public class TestLearn {

	@Test
	public void testDateFormat(){
		String[] ss = "com.unj.dubbotest.provider.DemoService^0.0.0.7^true".split("\\^");
		
		for (String string : ss) {
			
			System.out.println(string);
		}
	}
}
