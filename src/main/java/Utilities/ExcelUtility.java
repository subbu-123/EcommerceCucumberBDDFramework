package Utilities;

import java.util.ArrayList;
import java.util.List;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class ExcelUtility {
	
	public static List<Object[]> getDataFromExcel(String excelPath, String sheetname) throws FilloException
	{
		Fillo flo = new Fillo();
		Connection con = flo.getConnection(excelPath); // This connection class is of fillo not java
		String query = "Select * From "+ sheetname;
		Recordset rs = con.executeQuery(query);
		List<Object[]> testdata = new ArrayList<Object[]>();
		
		List<String> fieldNames = rs.getFieldNames();
		while(rs.next())
		{
			Object[] obj = new Object[fieldNames.size()];
			for(int i=0;i<fieldNames.size(); i++)
			{
				obj[i] = rs.getField(fieldNames.get(i));
			}
			testdata.add(obj);
		}

		rs.close();
		con.close();
		return testdata;
	}

}
