package Generic_Libraries;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Properties;

public class Utility {
	
	public static ListIterator<Object[]> commonlogic(String sheetname, String scriptname) throws Exception {
		
		Excelfn e = new Excelfn(System.getProperty("user.dir")+"\\src\\main\\resources\\emIDAM-credentials.xlsx");
	
//	Get the rowcount
		int grc = e.getrowcount(sheetname);
		
//	Get the colcount	
		int gcc = e.getcolcount(sheetname);
	
//		Creation of List array
		
		List<Object[]> l = new ArrayList<Object[]>();
	
		for(int i=1;i<=grc;i++) {

			String flag = e.readvalue(i, 1, sheetname);
					
			String script= e.readvalue(i,3, sheetname);

			if(flag.equalsIgnoreCase("Y") && (script.equalsIgnoreCase(scriptname))) {
				
				Map<String, String> hm = new HashMap<String,String>();
				Object[] o = new Object[1];
				
				for(int j=0; j<gcc;j++) {
				
					String key = e.readvalue(0,j, sheetname);
					String val = e.readvalue(i,j, sheetname);
					hm.put(key, val);
			}
				o[0] = hm;
				l.add(o);
		}
		}
			return l.listIterator();
		}
	
//	Get property data
	public static String getprop(String k) throws Exception {
		
		FileInputStream ft = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\IDAM-Config.properties");
		Properties p = new Properties();
		p.load(ft);
		return p.getProperty(k);
		}
}
