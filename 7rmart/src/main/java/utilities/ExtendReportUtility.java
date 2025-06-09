package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtendReportUtility {
	public static final ExtentReports extentReports = new ExtentReports();

	public synchronized static ExtentReports createExtentReports() {//call from Listerners class
		ExtentSparkReporter reporter = new ExtentSparkReporter("./extent-reports/extent-report.html");
		reporter.config().setReportName("DEMO Project");
		extentReports.attachReporter(reporter);
		extentReports.setSystemInfo("Organization", "Obsqura");//organisationname,team member name
		extentReports.setSystemInfo("Name", "DHANASREE");
		//extentReports.setSystemInfo("Name", "ANU");can add more members
		return extentReports;//return report public_extend report
		//synchronized-for not overlap
	}

}



















//avenstack dependency provide avenstack class
//7//class provided by avenstack dependency
//location of report ./is directory //extend-reports-foldername
//
//extend-reort in folder generate
//reporter-
//extendReports-object of extend report
//path is same for all projects
//create extend report call in listeners class