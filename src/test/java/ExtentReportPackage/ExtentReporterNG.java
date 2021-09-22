package ExtentReportPackage;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.xml.XmlSuite;
import org.uncommons.reportng.HTMLReporter;

import java.io.File;
import java.util.List;
import java.util.Map;

public class ExtentReporterNG implements IReporter {

    public static ExtentReports extentReports;
    public static HTMLReporter htmlReporter;

    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites,
                               String outputDirectory) {



        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("C:\\Users\\shubhi.bansal\\IdeaProjects\\Maven003\\test-output\\" + "MyExtent.html");
        sparkReporter.config().setTheme(Theme.DARK);
        sparkReporter.config().setDocumentTitle("I am DOC title");
        sparkReporter.config().setReportName("I am Report Name");
        extentReports.attachReporter(sparkReporter);
        //Iterating over each suite included in the test
        for (ISuite suite : suites) {

            //Following code gets the suite name
            String suiteName = suite.getName();

            //Getting the results for the said suite
            Map<String, ISuiteResult> suiteResults = suite.getResults();
            for (ISuiteResult sr : suiteResults.values()) {
                ITestContext tc = sr.getTestContext();
                System.out.println("Passed tests for suite '" + suiteName +
                        "' is:" + tc.getPassedTests().getAllResults().size());
                System.out.println("Failed tests for suite '" + suiteName +
                        "' is:" + tc.getFailedTests().getAllResults().size());
                System.out.println("Skipped tests for suite '" + suiteName +
                        "' is:" + tc.getSkippedTests().getAllResults().size());
            }
        }

        extentReports.flush();
        extentReports.getClass();
    }
}
