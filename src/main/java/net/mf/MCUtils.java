package net.mf;


import com.hp.lft.report.ReportException;
import com.hp.lft.report.Reporter;
import com.hp.lft.report.Status;
import com.hp.lft.sdk.GeneralLeanFtException;
import com.hp.lft.sdk.SrfLab;
import com.hp.lft.sdk.mobile.*;

enum LOG_LEVEL {INFO, ERROR}

public class MCUtils {

    public boolean INSTALL_APP = false;
    public boolean UNINSTALL_APP = false;
    public boolean HIGHLIGHT = false;
    public boolean IS_PACKAGED = false;
    public String APP_IDENTIFIER = "";
    public String APP_VERSION = "";
    public Application app = null;
    public Device device = null;

    private ApplicationDescription[] appDescription = new ApplicationDescription[1];

    public void MCUtils() {
    }

    public void windowSync(long millseconds) throws InterruptedException { Thread.sleep(millseconds); }

    /*
    Log messages to std output and lft report.
    This method also uses the lft reporting classes
    */
    public void logMessages(String message, LOG_LEVEL level) {
        String prefix = (level == LOG_LEVEL.INFO) ? "[INFO] " : "[ERROR] ";
        Status status = (level == LOG_LEVEL.INFO) ? Status.Passed : Status.Failed;
        System.out.println(prefix + " [" + getTimeStamp("dd/MM/yyyy HH:mm:ss") + "] " + message);
        try {
            Reporter.reportEvent(prefix, message, status);
        } catch (ReportException rex) {
            System.out.println("[ERROR] " + rex.getMessage());
        }
    }

    /*
    Private method for time formatting
    */
    private String getTimeStamp(String pattern) {
        return new java.text.SimpleDateFormat(pattern).format(new java.util.Date());
    }

    /*
    Lock device by Device Description, and device source (MC/ADF)
    */
    public void lockDevice(DeviceDescription deviceDescription, DeviceSource deviceSource)  throws GeneralLeanFtException{
        logMessages ("Init device capabilities...", LOG_LEVEL.INFO);
        this.device = null;
        this.device = SrfLab.lockDevice(deviceDescription, this.appDescription, deviceSource);
        logMessages ("Exit lockDevice(DeviceDescription, DeviceSource)", LOG_LEVEL.INFO);
    }

    /*
    Lock device by Device Description
    */
    public void lockDevice(DeviceDescription deviceDescription)  throws GeneralLeanFtException{
        logMessages ("Init device capabilities...", LOG_LEVEL.INFO);
        this.device = null;
        this.device = SrfLab.lockDevice(deviceDescription);
        logMessages ("Exit lockDevice(DeviceDescription)", LOG_LEVEL.INFO);
    }

    /*
    Lock device by Device ID
    */
    public void lockDeviceById (String deviceId) throws GeneralLeanFtException
    {
        logMessages ("Init device capabilities...", LOG_LEVEL.INFO);
        this.device = null;
        this.device = SrfLab.lockDeviceById(deviceId);
        logMessages ("Exit lockDeviceById(deviceId)", LOG_LEVEL.INFO);
    }

    /*
    Setting up the app for the test.
    This method uses the public IS_PACKAGED, APP_VERSION and APP_IDENTIFIER members to identify the app
    */
    public void setApp() throws GeneralLeanFtException{
        ApplicationDescription localAppDescription = new ApplicationDescription.Builder().identifier(APP_IDENTIFIER).
                packaged(IS_PACKAGED).version(APP_VERSION).build();

        app = device.describe(Application.class, localAppDescription);
    }

    /*
    Setting up the app for the test.
    This method uses accept the 3 parameters to identify the app
    */
    public void setApp(String appIdentifier, String appVersion, Boolean isPackaged) throws GeneralLeanFtException{
        ApplicationDescription localAppDescription = new ApplicationDescription.Builder().identifier(appIdentifier).
                packaged(isPackaged).version(appVersion).build();

        app = device.describe(Application.class, localAppDescription);
    }
}