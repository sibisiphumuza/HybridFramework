package functionalityTestcases;

import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.TestBase;
import utilities.ReadExcelFile;
import utilities.ReadObject;
import utilities.UIOperation;

public class RegisterFunctionalityTestExecution extends TestBase {

	@Test(dataProvider = "hybridData")
	public void FunctionalityTestExecution(String testcaseName, String keyword, String objectName, String objectType,
			String value) throws Exception {

		ReadObject object = new ReadObject();
		Properties allObjects = object.getObjectRepository();
		UIOperation operation = new UIOperation(driver);
		// Call perform function to perform operation on UI
		operation.perform(allObjects, keyword, objectName, objectType, value);
	}

	@DataProvider(name = "hybridData")
	public Object[][] getDataFromDataprovider() throws IOException {
		Object[][] object = null;
		ReadExcelFile file = new ReadExcelFile();

		// Read keyword sheet
		Sheet sheet = file.readExcel(System.getProperty("user.dir") + "\\src\\test\\resources\\testdata\\",
				"TestExecution.xlsx", "VerifyRegisterUserValidTest");
		// Find number of rows in excel file
		int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
		object = new Object[rowCount][5];

		for (int i = 0; i < rowCount; i++) {
			// Loop over all the rows
			Row row = sheet.getRow(i + 1);
			// Create a loop to print cell values in a row
			for (int j = 0; j < row.getLastCellNum(); j++) {
				// Print excel data in console
				if (row.getCell(j) != null) {
					object[i][j] = row.getCell(j).toString();
				}
			}
		}
		return object;
	}

}
