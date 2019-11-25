package application;

import java.util.*;
import java.io.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.*;
import org.apache.poi.hssf.usermodel.*;


public class ExcelIO { // Overloaded methods based on which class is being created

	
	
	private Workbook studentWB, projectWB, teamWB;
	private Sheet studentSheet, projectSheet, teamSheet;
	private Row studentRow, projectRow, teamRow;
	private FileOutputStream teamStream;
	private Iterator<Row> studentRI, projectRI;
	private Iterator<Cell> studentCI, projectCI;
	ExcelIO() {
		try {
		FileInputStream studentStream = new FileInputStream(new File("student input file.xls"));
		FileInputStream projectStream = new FileInputStream(new File("project input file.xls"));
		studentWB = new HSSFWorkbook(studentStream);
		projectWB = new HSSFWorkbook(projectStream);
		studentSheet = studentWB.getSheetAt(0);
		projectSheet = projectWB.getSheetAt(0);
		studentRI = studentSheet.rowIterator();
		projectRI = projectSheet.rowIterator();
		studentRow = studentRI.next(); //methods will iterate this to the next row 
		projectRow = projectRI.next();
		//also set up the output stream in the same try block
		teamStream = new FileOutputStream(new File("team builder results.xls"));	
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
		newStudent.name = formatter.formatCellValue(cell); // Will actually set the various members in student once we see the formats we're working with
		cell = studentCI.next(); // Iterate as many times as appropriate once we see the formats
		newStudent.gpa = Double.parseDouble(formatter.formatCellValue(cell));
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
		newProject.projectName = formatter.formatCellValue(cell); // Will actually set the various members in student once we see the formats we're working with
		cell = projectCI.next(); // Iterate as many times as appropriate once we see the formats
		newProject.requiredMembers.add(formatter.formatCellValue(cell));
		cell = projectCI.next(); // Iterate as many times as appropriate once we see the formats
		newProject.requiredMembers.add(formatter.formatCellValue(cell));
		cell = projectCI.next(); // Iterate as many times as appropriate once we see the formats
		newProject.requiredMembers.add(formatter.formatCellValue(cell));
		cell = projectCI.next(); // Iterate as many times as appropriate once we see the formats
		newProject.requiredMembers.add(formatter.formatCellValue(cell));
		//check if there is another project to read
		if (projectRI.hasNext()) {
			projectRow = projectRI.next();
			return true; // Some sort of way to indicate to the factory whether there is more to read or not
		}
		else
			return false;
	}
	public void prepOutputFile() {
		teamWB = new HSSFWorkbook();
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
		teamRow.createCell(7).setCellValue(helper.createRichTextString("Student 1 GPA")); // Do we want to show these?
		teamRow.createCell(8).setCellValue(helper.createRichTextString("Student 2 GPA"));
		teamRow.createCell(9).setCellValue(helper.createRichTextString("Student 3 GPA"));
		teamRow.createCell(10).setCellValue(helper.createRichTextString("Student 4 GPA"));
		teamRow.createCell(11).setCellValue(helper.createRichTextString("Student 5 GPA"));
		teamRow.createCell(12).setCellValue(helper.createRichTextString("Student 6 GPA"));
		teamRow.createCell(13).setCellValue(helper.createRichTextString("Team AVG GPA")); // I set up conditional formatting to highlight this cell if the GPA is out of range
		//Anything else we want to include in the output?
	}
	public void writeNextRow (Project project, int rowNumber) { // Row "0" is the labels, so start feeding with Row 1.
		CreationHelper helper = teamWB.getCreationHelper();
		//Create styles for later formatting
		CellStyle black = teamWB.createCellStyle();
		black.setFillBackgroundColor(IndexedColors.BLACK.index);
		black.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		CellStyle yellow = teamWB.createCellStyle();
		yellow.setFillBackgroundColor(IndexedColors.YELLOW.index);
		yellow.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		teamRow = teamSheet.createRow(rowNumber);
		teamRow.createCell(0).setCellValue(helper.createRichTextString(project.projectName));
		for (int i = 1; i <= project.actualMembers.size(); i++) { // these conditionals are.. not great, but might be the best way to get through this.
			teamRow.createCell(i).setCellValue(helper.createRichTextString(project.actualMembers.get(i-1).name));
		}
		if (project.actualMembers.size() < 6) {
			for (int i = project.actualMembers.size() + 1; i <= 6; i++) { // questionable conditional, works but sloppy?
				teamRow.createCell(i).setBlank();
				if (project.actualMembers.size() == project.requiredMembers.size()) {
					teamRow.getCell(i).setCellStyle(black);
				}
				else {
					teamRow.getCell(i).setCellStyle(yellow);
				}		
			}
		}
		for (int i = 7; i <= project.actualMembers.size() + 6; i++) { // questionable conditional, works but sloppy?
			teamRow.createCell(i).setCellValue(project.actualMembers.get(i-7).gpa);
		}
		if (project.actualMembers.size() < 6) {
			for ( int i = project.actualMembers.size() + 7; i <= 12; i++) { // questionable conditional, works but sloppy?
				teamRow.createCell(i).setBlank();
				if (project.actualMembers.size() == project.requiredMembers.size()) {
					teamRow.getCell(i).setCellStyle(black);
				}
				else {
					teamRow.getCell(i).setCellStyle(yellow);
				}	
			}
		}
		//Calculate Average GPA
		CellReference cellRef7 = createCellReference(teamRow.getCell(7));
		CellReference cellRef12 = createCellReference(teamRow.getCell(12));
		teamRow.createCell(13).setCellFormula("AVERAGE(" + cellRef7.formatAsString() + ":" + cellRef12.formatAsString() + ")");
		//Highlight GPA's out of range
		SheetConditionalFormatting sheetCF = teamSheet.getSheetConditionalFormatting();
		//Getting the condition range set dynamically should be possible, but I don't have it yet
		ConditionalFormattingRule rule = sheetCF.createConditionalFormattingRule(ComparisonOperator.NOT_BETWEEN, "3.0", "4.0"); 
		PatternFormatting format = rule.createPatternFormatting();
		format.setFillBackgroundColor(IndexedColors.RED.index);
		CellReference cellRef13 = createCellReference(teamRow.getCell(13));
		CellRangeAddress[] target = { CellRangeAddress.valueOf(cellRef13.formatAsString()) };
		sheetCF.addConditionalFormatting(target, rule);
		
	}
	
	public void saveNewFile() {
		try {
		teamWB.write(teamStream);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public CellReference createCellReference(Cell cell) {
		CellReference cellRef = new CellReference(teamRow.getRowNum(), cell.getColumnIndex());
		return cellRef;
	}
	
	public static void main(String[] args) {
		ExcelIO readerWriter = new ExcelIO();
		StudentReader studentReader = new StudentReader();
		ProjectReader projectReader = new ProjectReader();
		LinkedList<Student> studentList = studentReader.createStudents(readerWriter);
		LinkedList<Project> projectList = projectReader.createProjects(readerWriter);
		projectList.get(0).actualMembers.add(studentList.get(0));
		projectList.get(0).actualMembers.add(studentList.get(1));
		projectList.get(0).actualMembers.add(studentList.get(2));
		projectList.get(0).actualMembers.add(studentList.get(3));
		readerWriter.prepOutputFile();
		readerWriter.writeNextRow(projectList.get(0), 1);
		readerWriter.writeNextRow(projectList.get(0), 2);
		readerWriter.writeNextRow(projectList.get(0), 3);
		readerWriter.writeNextRow(projectList.get(0), 4);
		readerWriter.saveNewFile();
	}
}
