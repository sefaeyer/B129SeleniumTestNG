package techproed.utilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class ListenersRetry implements IRetryAnalyzer {
    /*
    Bu sinif sadece FAILED olan test case leri tekrar calistirir
    maxRetryCount ek olarak calisma sayisidir. Bu ornekte Fail olan test (maxRetryCount = 1) normal
    bir kere calistiktan sonra fail olursa birkez daha calisacaktir.
     */
    private int retryCount = 0;
    private static final int maxRetryCount = 2;
    @Override
    public boolean retry(ITestResult result) {
        if (retryCount < maxRetryCount) {
            retryCount++;
            return true;
        }
        return false;
    }
}
