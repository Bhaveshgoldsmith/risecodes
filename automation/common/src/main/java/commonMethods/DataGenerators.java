package commonMethods;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class DataGenerators {
	@SuppressWarnings("deprecation")
	public static Object[][] TestDataGenerator(String FilePath, String SheetName) throws IOException {
		FileInputStream file = new FileInputStream(FilePath);
		@SuppressWarnings("resource")
		XSSFWorkbook wb = new XSSFWorkbook(file);
		XSSFSheet loginSheet = wb.getSheet(SheetName);
		int columns = getColumnsCount(loginSheet);
		int rows = loginSheet.getPhysicalNumberOfRows();
		Object[][] testdata = new Object[rows - 1][columns];
		for (int rowIndex = 1; rowIndex < rows; rowIndex++) {
			XSSFRow row = loginSheet.getRow(rowIndex);
			Iterator<Cell> cellIterator = row.cellIterator();
			int columnIndex = 0;
			while (cellIterator.hasNext()) {
				Cell cell = cellIterator.next();
				switch (cell.getCellType()) {
				case Cell.CELL_TYPE_BOOLEAN:
					testdata[rowIndex - 1][columnIndex] = cell.getBooleanCellValue();
					break;
				case Cell.CELL_TYPE_NUMERIC:
					testdata[rowIndex - 1][columnIndex] = cell.getNumericCellValue();
					break;
				default:
					testdata[rowIndex - 1][columnIndex] = cell.getStringCellValue();
					break;
				}
				++columnIndex;
			}
		}
		return testdata;
	}
	private static int getColumnsCount(XSSFSheet xssfSheet) {
		int result = 0;
		Iterator<Row> rowIterator = xssfSheet.iterator();
		while (rowIterator.hasNext()) {
			Row row = rowIterator.next();
			List<Cell> cells = new ArrayList<>();
			Iterator<Cell> cellIterator = row.cellIterator();
			while (cellIterator.hasNext()) {
				cells.add(cellIterator.next());
			}
			for (int i = cells.size(); i >= 0; i--) {
				Cell cell = cells.get(i - 1);
				if (cell.toString().trim().isEmpty()) {
					cells.remove(i - 1);
				} else {
					result = cells.size() > result ? cells.size() : result;
					break;
				}
			}
		}
		return result;
	}
}
