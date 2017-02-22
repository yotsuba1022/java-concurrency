package idv.java.ccr.executor;

import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author Carl Lu
 */
public class UrlDetector implements Runnable {

    private final static int NORMAL_STATUS_CODE = 200;
    private final static int MOVE_PERMANENTLY_CODE = 301;
    private final static String REQUEST_METHOD = "GET";
    private final String url;

    public UrlDetector(String url) {
        this.url = url;
    }

    @Override
    public void run() {
        String result = "";

        try {
            URL siteUrl = new URL(url);
            HttpURLConnection httpURLConnection = (HttpURLConnection) siteUrl.openConnection();
            httpURLConnection.setRequestMethod(REQUEST_METHOD);
            httpURLConnection.connect();

            if ((httpURLConnection.getResponseCode() == NORMAL_STATUS_CODE)
                    || (httpURLConnection.getResponseCode() == MOVE_PERMANENTLY_CODE)) {
                result = "GREEN";
            }

        } catch (Exception e) {
            result = ">>RED<<";
        }

        System.out.println(url + " status: " + result);
    }
}
