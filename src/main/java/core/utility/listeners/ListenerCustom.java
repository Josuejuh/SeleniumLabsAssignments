package core.utility.listeners;

import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import core.utility.BaseClass;
import com.aventstack.extentreports.Status;
import core.utility.reports.ExtentTestManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class ListenerCustom extends BaseClass implements ITestListener {
    private static long endTime;

    private static void setStartTime(long startTime) {
    }

    private static void setEndTime(long endTime) {
        ListenerCustom.endTime = endTime;
    }

    @Override
    public synchronized void onStart(ITestContext context) {
    }

    @Override
    public synchronized void onFinish(ITestContext context) {
        setStartTime(context.getStartDate().getTime());
        setEndTime(context.getEndDate().getTime());
    }

    @Override
    public synchronized void onTestStart(ITestResult result) {
        System.out.println("--------- Executing :- " + getSimpleMethodName(result) + " ---------");
        ExtentTestManager.createTest(result.getName(), result.getMethod().getDescription());
        ExtentTestManager.setCategoryName(getSimpleClassName(result));
    }

    @Override
    public synchronized void onTestSuccess(ITestResult result) {
        ExtentTestManager.getTest().assignCategory(getSimpleClassName(result));
        addExtentLabelToTest(result);

        Object testClass = result.getInstance();
        WebDriver webDriver = ((BaseClass) testClass).getDriver();
        String base64Screenshot = "data:image/png;base64," + ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BASE64);
        ExtentTestManager.getTest().log(Status.PASS, "Test Success",
                ExtentTestManager.getTest().addScreenCaptureFromBase64String(base64Screenshot).getModel().getMedia().get(0));

        addExtentLabelToTest(result);

        ExtentTestManager.endTest();
    }

    @Override
    public synchronized void onTestFailure(ITestResult result) {
        ExtentTestManager.getTest().assignCategory(getSimpleClassName(result));
        ExtentTestManager.getTest().log(Status.FAIL, result.getName() + " Test is failed" + result.getThrowable());
        addExtentLabelToTest(result);

        Object testClass = result.getInstance();
        WebDriver webDriver = ((BaseClass) testClass).getDriver();
        String base64Screenshot = "data:image/png;base64," + ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BASE64);
        ExtentTestManager.getTest().log(Status.FAIL, "Test Failed",
                ExtentTestManager.getTest().addScreenCaptureFromBase64String(base64Screenshot).getModel().getMedia().get(0));

        addExtentLabelToTest(result);


        ExtentTestManager.endTest();
    }

    @Override
    public synchronized void onTestSkipped(ITestResult result) {
        ExtentTestManager.getTest().log(Status.SKIP, result.getName() + " Test is Skipped" + result.getThrowable());
    }

    @Override
    public synchronized void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    }

    private synchronized String getSimpleClassName(ITestResult result) {
        return result.getMethod().getRealClass().getSimpleName();
    }

    private synchronized String getSimpleMethodName(ITestResult result) {
        return result.getName();
    }

    private synchronized void addExtentLabelToTest(ITestResult result) {
        if (result.getStatus() == ITestResult.SUCCESS)
            ExtentTestManager.getTest().pass(MarkupHelper.createLabel("Test Passed", ExtentColor.GREEN));
        else if (result.getStatus() == ITestResult.FAILURE) {
            ExtentTestManager.getTest().fail(MarkupHelper.createLabel("Test Failed", ExtentColor.RED));
        } else
            ExtentTestManager.getTest().skip(MarkupHelper.createLabel("Test Skipped", ExtentColor.ORANGE));
    }


}
