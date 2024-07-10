package Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.io.File;

public class ExtentReportGenerator
{
    public static ExtentReports getExtentReport()
    {
        ExtentReports report=new ExtentReports();
        File extentReportfile=new File("D:\\Intelli workspace\\BestBuy-E-Commerce\\src\\test\\ExtentReports\\eReport.html");
        ExtentSparkReporter sparkReporter=new ExtentSparkReporter(extentReportfile);
        report.attachReporter(sparkReporter);
        return report;
    }
}
