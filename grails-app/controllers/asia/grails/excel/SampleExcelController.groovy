package asia.grails.excel

import jxl.Workbook
import jxl.write.Label
import jxl.write.WritableSheet
import jxl.write.WritableWorkbook

class SampleExcelController {

    def index() {}

    def downloadSampleExcel() {
        response.setContentType('application/vnd.ms-excel')
        response.setHeader('Content-Disposition', 'Attachment;Filename="example.xls"')

        WritableWorkbook workbook = Workbook.createWorkbook(response.outputStream)
        WritableSheet sheet1 = workbook.createSheet("Students", 0)
        sheet1.addCell(new Label(0,0, "First Name"))
        sheet1.addCell(new Label(1,0, "Last Name"))
        sheet1.addCell(new Label(2,0, "Age"))

        sheet1.addCell(new Label(0,1, "John"))
        sheet1.addCell(new Label(1,1, "Doe"))
        sheet1.addCell(new Label(2,1, "20"))

        sheet1.addCell(new Label(0,2, "Jane"))
        sheet1.addCell(new Label(1,2, "Smith"))
        sheet1.addCell(new Label(2,2, "18"))

        WritableSheet sheet2 = workbook.createSheet("Courses", 1)
        sheet2.addCell(new Label(0,0, "Course Name"))
        sheet2.addCell(new Label(1,0, "Number of units"))

        sheet2.addCell(new Label(0,1, "Algebra"))
        sheet2.addCell(new Label(1,1, "3"))

        sheet2.addCell(new Label(0,2, "English Grammar"))
        sheet2.addCell(new Label(1,2, "5"))

        workbook.write();
        workbook.close();
    }
}
