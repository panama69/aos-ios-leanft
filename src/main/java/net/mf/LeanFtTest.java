package net.mf;

import com.hp.lft.sdk.GeneralLeanFtException;
import com.hp.lft.sdk.ReplayObjectNotFoundException;
import com.hp.lft.sdk.mobile.DeviceDescription;
import com.mf.LabDevice;
import com.mf.utils.Logging;
import com.mf.utils.Logging.LOG_LEVEL;
import org.junit.*;
import unittesting.UnitTestClassBase;

public class LeanFtTest extends UnitTestClassBase {

    private LabDevice.LabType labType = LabDevice.LabType.SRF;  // Using Mobile Center for devices instead of SRF
    private LabDevice labDevice = new LabDevice();
    private static AppModelAOS_iOS appModel;

    Logging logging = new Logging();

    public LeanFtTest() {
        //Change this constructor to private if you supply your own public constructor
    }

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        instance = new LeanFtTest();
        globalSetup(LeanFtTest.class);
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        globalTearDown();
    }

    @Before
    public void setUp() throws Exception {
        logging.logMessages("Enter setUp() method ", LOG_LEVEL.INFO);

        getLabType();

        labDevice.setInstallApp(true); // install the app at the start of the test true or false
        labDevice.setUninstallApp(false); // uninstall app at end of test true or false
        labDevice.setHighlight(true); // highlight the objects when working with them true or false
        labDevice.setPackaged(true); // is a packaged app true or false
        labDevice.setAppIdentifier("com.mf.iShopping");
        labDevice.setAppVersion("1.1.4");
//        labDevice.setAppIdentifier("com.Advantage.iShopping");
//        labDevice.setAppVersion("1.1.3");

        try {
            DeviceDescription deviceDescription = new DeviceDescription();

            deviceDescription.setOsType("IOS");
            deviceDescription.setOsVersion(">=9.0.0");
            deviceDescription.setModel("iPhone 5s (GSM)");

            labDevice.lockDevice(deviceDescription, labType);
            //labDevice.lockDeviceById("e11bff56cec8edbb132e602b2ad9e7a9babeb178", labType);

            if (labDevice.getDevice() != null) {
                appModel = new AppModelAOS_iOS(labDevice.getDevice());
                labDevice.setApp();

                logging.logMessages ("Allocated device: \"" + labDevice.getDevice().getName() + "\" (" + labDevice.getDevice().getId() + "), Model :"
                        + labDevice.getDevice().getModel() + ", OS: " + labDevice.getDevice().getOSType() + ", version: " + labDevice.getDevice().getOSVersion()
                        + ", manufacturer: " + labDevice.getDevice().getManufacturer() + ". App in use: \"" + labDevice.getApp().getName()
                        + "\" v" + labDevice.getApp().getVersion(), LOG_LEVEL.INFO);
                if (labDevice.isInstallApp()) {
                    logging.logMessages ("Installing app: " + labDevice.getApp().getName(), LOG_LEVEL.INFO);
                    labDevice.getApp().install();
                } else {
                    logging.logMessages ("Restarting app: " + labDevice.getApp().getName(), LOG_LEVEL.INFO);
                    labDevice.getApp().restart();
                }
            } else {
                logging.logMessages ("Device couldn't be allocated, exiting script", LOG_LEVEL.ERROR);
            }
        } catch (Exception ex) {
            logging.logMessages ("Exception in setup(): " + ex.getMessage(), LOG_LEVEL.ERROR);
        }
    }

    private void getLabType (){
        if (System.getProperty("lab") != null){
            switch (System.getProperty("lab")){
                case "MC":
                    this.labType = LabDevice.LabType.MC;
                    break;
                case "SRF":
                    this.labType = LabDevice.LabType.SRF;
                    break;
                default:
                    this.labType = LabDevice.LabType.UNKNOWN;
                    if (labType == LabDevice.LabType.UNKNOWN){
                        logging.logMessages("Unknown mobile device lab.  Passed in: "+System.getProperty("lab"), LOG_LEVEL.ERROR);
                        Assert.fail();
                    }
                    break;
            }
        }
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void test() throws GeneralLeanFtException, InterruptedException {
        if (labDevice.getDevice() == null) {
            Assert.fail();
            return;
        }

        try {
            logging.logMessages("Clear Allow message if it appears",LOG_LEVEL.INFO);

            logging.logMessages ("Tap 'Open Menu'", LOG_LEVEL.INFO);
            if (labDevice.isHighlight())
                appModel.AdvantageShoppingApplication().MenuButton().highlight();
            appModel.AdvantageShoppingApplication().MenuButton().tap();

            logging.logMessages ("Check if the user signed in", LOG_LEVEL.INFO);
            if (appModel.AdvantageShoppingApplication().SIGNOUTLabel().exists(5)) {
                signOut();
                deviceSync(2000);
                logging.logMessages ("Tap 'Open Menu (after sign-out)'", LOG_LEVEL.INFO);
                appModel.AdvantageShoppingApplication().MenuButton().tap();
                deviceSync(2000);
            }

            logging.logMessages ("Tap login label", LOG_LEVEL.INFO);
            if (labDevice.isHighlight())
                appModel.AdvantageShoppingApplication().LOGINLabel().highlight();
            appModel.AdvantageShoppingApplication().LOGINLabel().tap();

            logging.logMessages ("Type name", LOG_LEVEL.INFO);
            if (labDevice.isHighlight())
                appModel.AdvantageShoppingApplication().USERNAMEEditField().highlight();
            appModel.AdvantageShoppingApplication().USERNAMEEditField().setText("sshiff");

            logging.logMessages ("Type password", LOG_LEVEL.INFO);
            if (labDevice.isHighlight())
                appModel.AdvantageShoppingApplication().PASSWORDEditField().highlight();
            appModel.AdvantageShoppingApplication().PASSWORDEditField().setSecure("97ededd61184a118aeb05c9627");

            logging.logMessages ("Tap login button", LOG_LEVEL.INFO);
            if (labDevice.isHighlight())
                appModel.AdvantageShoppingApplication().LOGINButton().highlight();
            appModel.AdvantageShoppingApplication().LOGINButton().tap();

            logging.logMessages ("Select 'laptop' category", LOG_LEVEL.INFO);
            if (labDevice.isHighlight())
                appModel.AdvantageShoppingApplication().LAPTOPSLabel().highlight();
            appModel.AdvantageShoppingApplication().LAPTOPSLabel().tap();

            logging.logMessages ("Select a laptop", LOG_LEVEL.INFO);
            if (labDevice.isHighlight())
                appModel.AdvantageShoppingApplication().SelectedLaptop4().highlight();
            appModel.AdvantageShoppingApplication().SelectedLaptop4().tap();

            logging.logMessages ("Tap 'Add to Cart' button", LOG_LEVEL.INFO);
            if (labDevice.isHighlight())
                appModel.AdvantageShoppingApplication().ADDTOCARTButton().highlight();
            appModel.AdvantageShoppingApplication().ADDTOCARTButton().tap();
            deviceSync(1500);

            logging.logMessages ("Tap the back button", LOG_LEVEL.INFO);
            if (labDevice.isHighlight())
                appModel.AdvantageShoppingApplication().BackButton().highlight();
            appModel.AdvantageShoppingApplication().BackButton().tap();

            logging.logMessages ("Tap 'Open Menu'", LOG_LEVEL.INFO);
            if (labDevice.isHighlight())
                appModel.AdvantageShoppingApplication().MenuButton().highlight();
            appModel.AdvantageShoppingApplication().MenuButton().tap();

            logging.logMessages ("Tap 'Open Cart'", LOG_LEVEL.INFO);
            if (labDevice.isHighlight())
                appModel.AdvantageShoppingApplication().OpenCart().highlight();
            appModel.AdvantageShoppingApplication().OpenCart().tap();

            logging.logMessages ("Tap the checkout button", LOG_LEVEL.INFO);
            if (labDevice.isHighlight())
                appModel.AdvantageShoppingApplication().CHECKOUTPAYButton().highlight();
            appModel.AdvantageShoppingApplication().CHECKOUTPAYButton().tap();

            logging.logMessages ("Tap the pay now button", LOG_LEVEL.INFO);
            if (labDevice.isHighlight())
                appModel.AdvantageShoppingApplication().PAYNOWButton().highlight();
            appModel.AdvantageShoppingApplication().PAYNOWButton().tap();

            logging.logMessages ("Tap OK", LOG_LEVEL.INFO);
            if (labDevice.isHighlight())
                appModel.AdvantageShoppingApplication().OkButton().highlight();
            appModel.AdvantageShoppingApplication().OkButton().tap();

            appModel.AdvantageShoppingApplication().MenuButton().tap();
            signOut();

            logging.logMessages ("********** Test completed successfully **********", LOG_LEVEL.INFO);

        } catch (ReplayObjectNotFoundException ronfex) {
            logging.logMessages ("error code: " + ronfex.getErrorCode() + " - " + ronfex.getMessage(), LOG_LEVEL.ERROR);
            Assert.fail();
        }
    }

    private void signOut() throws GeneralLeanFtException {
        if (labDevice.isHighlight())
            appModel.AdvantageShoppingApplication().SIGNOUTLabel().highlight();
        appModel.AdvantageShoppingApplication().SIGNOUTLabel().tap();

        if (labDevice.isHighlight())
            appModel.AdvantageShoppingApplication().YesButton().highlight();
        appModel.AdvantageShoppingApplication().YesButton().tap();
    }

    private void deviceSync (int millisecons) throws InterruptedException {
        Thread.sleep(millisecons);
    }

}