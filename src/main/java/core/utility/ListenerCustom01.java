package core.utility;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerCustom01 implements ITestListener {

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Print tittle on success - Custom Method");
        ITestListener.super.onTestSuccess(result);

    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Check what is wrong with your code - Custom Method");
        ITestListener.super.onTestFailure(result);
    }
}
