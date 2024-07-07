package Utilities;

public class Config {

    // List of Chrome switches and flags, many of which will work with Chromedriver:
    // https://chromium.googlesource.com/chromium/src/+/master/chrome/common/chrome_switches.cc
    // https://peter.sh/experiments/chromium-command-line-switches/
    public static String[] ChromeOptions = {
            "--headless"
    };
    public static int elementWaitTimeout = 60;
}
