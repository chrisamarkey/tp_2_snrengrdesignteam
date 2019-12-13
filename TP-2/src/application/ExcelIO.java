package application;

import java.util.*;
import java.io.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.hssf.usermodel.*;


public class ExcelIO { // Overloaded methods based on which class is being created

	
	private double avgGPA;
	private Workbook studentWB, projectWB, teamWB;
	private Sheet studentSheet, projectSheet, teamSheet;
	private Row studentRow, projectRow, teamRow;
	private FileOutputStream teamStream;
	private Iterator<Row> studentRI, projectRI;
	private Iterator<Cell> studentCI, projectCI;
	ExcelIO() {
		
	}
	
	public void createSStream(File studentFile) {
		try {
		studentWB = WorkbookFactory.create(studentFile);
		studentSheet = studentWB.getSheetAt(0);
		studentRI = studentSheet.rowIterator();
		studentRow = studentRI.next();
		studentRow = studentRI.next(); // To skip the first row and not read in the labels.		
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void createPStream(File projectFile) {
		try {
		projectWB = WorkbookFactory.create(projectFile);
		projectSheet = projectWB.getSheetAt(0);
		projectRI = projectSheet.rowIterator();
		projectRow = projectRI.next();
		projectRow = projectRI.next(); // To skip the first row and not read in the labels.		
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public boolean readNextRow(Student newStudent) {
		DataFormatter formatter = new DataFormatter();
		Row row = studentRow;
		studentCI = row.cellIterator();
		Cell cell = studentCI.next();
		newStudent.setName(formatter.formatCellValue(cell)); 
		cell = studentCI.next();
		newStudent.setID(Integer.parseInt(formatter.formatCellValue(cell)));
		cell = studentCI.next();
		newStudent.setMajor(formatter.formatCellValue(cell));
		cell = studentCI.next();
		newStudent.setGPA(Double.parseDouble(formatter.formatCellValue(cell)));
		// Possibly blank columns have to be handled differently.
		cell = row.getCell(4, Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);
		if (cell != null) {
			newStudent.addEnemyNames((formatter.formatCellValue(cell)));
			Cell iteratorHelper1 = studentCI.next(); //The iterator needs to keep hopping along if it's going to pick up once we get through these cells, but in a way that doesn't alter the main functionally. 
			//So create a dummy cell object to hold the hop until we're ready to use the iterator properly again.
		}
		cell = row.getCell(5, Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);
		if (cell != null) {
			newStudent.setFavProject(formatter.formatCellValue(cell));
			Cell iteratorHelper2 = studentCI.next();
		}
		cell = row.getCell(6, Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);
		if (cell != null) {
			newStudent.setWeight(Integer.parseInt(formatter.formatCellValue(cell)));
			Cell iteratorHelper3 = studentCI.next();
		}		
		while (studentCI.hasNext()) { 
			// Will work for any number of preferred projects, so long as the list is the last thing in the input file.
			cell = studentCI.next();
			newStudent.addPreferredProjects((formatter.formatCellValue(cell)));
		}
		//check if there is another student to read
		if (studentRI.hasNext()) {
			studentRow = studentRI.next();
			return true; // Some sort of way to indicate to the factory whether there is more to read or not
		}
		else
			return false;
	}
	
	public boolean readNextRow(Project newProject) {
		DataFormatter formatter = new DataFormatter();
		Row row = projectRow;
		projectCI = row.cellIterator();
		Cell cell = projectCI.next();
		newProject.setName(formatter.formatCellValue(cell));
		int meCount = 0;
		int eeCount = 0;
		int civeCount = 0;
		int ceCount = 0;
		while (projectCI.hasNext()) { 
			// Iterates as long as there is another non-blank cell in the row, meaning it should be able to handle teams of various sizes
			cell = projectCI.next(); 
//			meCount = 0;
//			eeCount = 0;
//			civeCount = 0;
//			ceCount = 0;
			switch (formatter.formatCellValue(cell)) {
			case ("Mechanical Engineer"): {
				meCount++;
				break;
			}
			case ("Electrical Engineer"): {
				eeCount++;
				break;
			}
			case ("Civil Engineer"): {
				civeCount++;
				break;
			}
			case ("Computer Engineer"): {
				ceCount++;
				break;
			}
			default:
				break;
			}
		}
		newProject.addRequiredMembers("Mechanical Engineer", meCount);
		newProject.addRequiredMembers("Electrical Engineer", eeCount);
		newProject.addRequiredMembers("Civil Engineer", civeCount);
		newProject.addRequiredMembers("Computer Engineer", ceCount);
		
		newProject.setNumRequired(meCount + eeCount + civeCount + ceCount);
		
		//check if there is another project to read
		if (projectRI.hasNext()) {
			projectRow = projectRI.next();
			return true; // Some sort of way to indicate to the factory whether there is more to read or not
		}
		else
			return false;
	}
	public void prepOutputFile(double averageGPA) { //Pass in Double avgGPA
		avgGPA = averageGPA;
		teamWB = new XSSFWorkbook();
		CreationHelper helper = teamWB.getCreationHelper();
		teamSheet = teamWB.createSheet();
		teamSheet = teamWB.getSheetAt(0);
		teamRow = teamSheet.createRow(0);
		teamRow.createCell(0).setCellValue(helper.createRichTextString("Project Name"));
		teamRow.createCell(1).setCellValue(helper.createRichTextString("Student 1 Name"));
		teamRow.createCell(2).setCellValue(helper.createRichTextString("Student 2 Name"));
		teamRow.createCell(3).setCellValue(helper.createRichTextString("Student 3 Name"));
		teamRow.createCell(4).setCellValue(helper.createRichTextString("Student 4 Name"));
		teamRow.createCell(5).setCellValue(helper.createRichTextString("Student 5 Name"));
		teamRow.createCell(6).setCellValue(helper.createRichTextString("Student 6 Name"));
		teamRow.createCell(7).setCellValue(helper.createRichTextString("Student 1 GPA"));
		teamRow.createCell(8).setCellValue(helper.createRichTextString("Student 2 GPA"));
		teamRow.createCell(9).setCellValue(helper.createRichTextString("Student 3 GPA"));
		teamRow.createCell(10).setCellValue(helper.createRichTextString("Student 4 GPA"));
		teamRow.createCell(11).setCellValue(helper.createRichTextString("Student 5 GPA"));
		teamRow.createCell(12).setCellValue(helper.createRichTextString("Student 6 GPA"));
		teamRow.createCell(13).setCellValue(helper.createRichTextString("Team AVG GPA")); // I set up conditional formatting to highlight this cell if the GPA is out of range
		
	}
	public void writeNextRow (Project project, int rowNumber) { // Row "0" is the labels, so start feeding with Row 1.
		CreationHelper helper = teamWB.getCreationHelper();
		//Create styles for later formatting
		CellStyle black = teamWB.createCellStyle();
		black.setFillForegroundColor(IndexedColors.BLACK.index);
		black.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		CellStyle yellow = teamWB.createCellStyle();
		yellow.setFillForegroundColor(IndexedColors.YELLOW.index);
		yellow.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		teamRow = teamSheet.createRow(rowNumber);
		teamRow.createCell(0).setCellValue(helper.createRichTextString(project.getName()));
		for (int i = 1; i <= project.getActualMembers().size(); i++) { // these conditionals are.. not great, but might be the best way to get through this.
			teamRow.createCell(i).setCellValue(helper.createRichTextString(project.getActualMembers().get(i-1).getName()));
		}
		if (project.getActualMembers().size() < 6) {
			for (int i = project.getActualMembers().size() + 1; i <= 6; i++) { // questionable conditional, works but sloppy?
				teamRow.createCell(i).setBlank();
				if (i > project.getNumRequired()) {
					teamRow.getCell(i).setCellStyle(black);
				}
				else {
					teamRow.getCell(i).setCellStyle(yellow);
				}		
			}
		}
		for (int i = 7; i <= project.getActualMembers().size() + 6; i++) { // questionable conditional, works but sloppy?
			teamRow.createCell(i).setCellValue(project.getActualMembers().get(i-7).getGPA());
		}
		if (project.getActualMembers().size() < 6) {
			for ( int i = project.getActualMembers().size() + 7; i <= 12; i++) { // questionable conditional, works but sloppy?
				teamRow.createCell(i).setBlank();
				if ((i - 6) > project.getNumRequired()) {
					teamRow.getCell(i).setCellStyle(black);
				}
				else {
					teamRow.getCell(i).setCellStyle(yellow);
				}	
			}
		}
		//Calculate Team Average GPA
		CellReference cellRef7 = createCellReference(teamRow.getCell(7));
		CellReference cellRef12 = createCellReference(teamRow.getCell(12));
		teamRow.createCell(13).setCellFormula("AVERAGE(" + cellRef7.formatAsString() + ":" + cellRef12.formatAsString() + ")");
		//Highlight GPA's out of range
		SheetConditionalFormatting sheetCF = teamSheet.getSheetConditionalFormatting();
		ConditionalFormattingRule rule = sheetCF.createConditionalFormattingRule(ComparisonOperator.NOT_BETWEEN, Double.toString(avgGPA - 0.2), Double.toString(avgGPA + 0.2)); 
		PatternFormatting format = rule.createPatternFormatting();
		format.setFillBackgroundColor(IndexedColors.RED.index);
		CellReference cellRef13 = createCellReference(teamRow.getCell(13));
		CellRangeAddress[] target = { CellRangeAddress.valueOf(cellRef13.formatAsString()) };
		sheetCF.addConditionalFormatting(target, rule);
		
	}
	
	public boolean saveNewFile(File destinationFile) {
		try {
		teamStream = new FileOutputStream(destinationFile);
		teamWB.write(teamStream);
		return true;
		}
		catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public CellReference createCellReference(Cell cell) {
		CellReference cellRef = new CellReference(teamRow.getRowNum(), cell.getColumnIndex());
		return cellRef;
	}

	public Workbook getStudentWB() {
		return studentWB;
	}

	public Workbook getProjectWB() {
		return projectWB;
	}

	public Sheet getStudentSheet() {
		return studentSheet;
	}

	public Sheet getProjectSheet() {
		return projectSheet;
	}

	public Row getStudentRow() {
		return studentRow;
	}

	public Row getProjectRow() {
		return projectRow;
	}

	public Iterator<Row> getStudentRI() {
		return studentRI;
	}

	public Iterator<Row> getProjectRI() {
		return projectRI;
	}
	
	public double getAvgGPA() {
		return avgGPA;
	}

	public Workbook getTeamWB() {
		return teamWB;
	}

	public Sheet getTeamSheet() {
		return teamSheet;
	}

	public Row getTeamRow() {
		return teamRow;
	}
}
