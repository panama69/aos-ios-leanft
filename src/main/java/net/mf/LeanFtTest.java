package net.mf;

import org.junit.*;
import com.hp.lft.sdk.*;
import com.hp.lft.sdk.mobile.*;
import com.hp.lft.verifications.*;

import unittesting.*;

public class LeanFtTest extends UnitTestClassBase {

    private boolean noProblem;
    private String tags[] = {"flynn","forrester","remote"};
    private Device device;
    private static AppModelAOS_iOS appModel;
    private MCUtils utils = new MCUtils();

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
        utils.logMessages("Enter setUp() method ", LOG_LEVEL.INFO );
        utils.INSTALL_APP = true;
        utils.UNINSTALL_APP = false;
        utils.HIGHLIGHT =true;
        //utils.APP_IDENTIFIER = "com.Advantage.iShopping";
        utils.APP_IDENTIFIER = "com.mf.iShopping";
        utils.APP_VERSION = "1.1.4";
        utils.IS_PACKAGED = true;
        noProblem = true;
        try {
            DeviceDescription deviceDescription = new DeviceDescription();
            deviceDescription.setOsType("IOS");
            deviceDescription.setOsVersion(">=9.0.0");
            deviceDescription.setModel("iPhone 5s (GSM)");
            deviceDescription.set("testName", "Mobile AOS");
            deviceDescription.set("tags", tags);
            utils.lockDevice(deviceDescription);
            //utils.lockDeviceById("8a05bbf719c5a6840177ad62b88674ee53893590");
            if (utils.device != null) {
                appModel = new AppModelAOS_iOS(utils.device);
                utils.setApp();

                utils.logMessages ("Allocated device: \"" + utils.device.getName() + "\" (" + utils.device.getId() + "), Model :"
                        + utils.device.getModel() + ", OS: " + utils.device.getOSType() + " version: " + utils.device.getOSVersion()
                        + ", manufacturer: " + utils.device.getManufacturer() + ". App in use: \"" + utils.app.getName()
                        + "\" v" + utils.app.getVersion(), LOG_LEVEL.INFO);

                if (utils.INSTALL_APP) {
                    utils.logMessages ("Installing app: " + utils.app.getName(), LOG_LEVEL.INFO);
                    utils.app.install();
                } else {
                    utils.logMessages ("Restarting app: " + utils.app.getName(), LOG_LEVEL.INFO);
                    utils.app.restart();
                }
            } else {
                utils.logMessages ("Device couldn't be allocated, exiting script", LOG_LEVEL.ERROR);
                noProblem = false;
            }
        } catch (Exception ex) {
            utils.logMessages ("Exception in setup(): " + ex.getMessage(), LOG_LEVEL.ERROR);
            noProblem = false;
        }
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void test() throws GeneralLeanFtException, InterruptedException {
        if (!noProblem) {
            Assert.fail();
            return;
        }

        try {
            utils.logMessages ("Tap 'Open Menu'", LOG_LEVEL.INFO);
            if (utils.HIGHLIGHT)
                appModel.AdvantageShoppingApplication().MenuButton().highlight();
            appModel.AdvantageShoppingApplication().MenuButton().tap();

            utils.logMessages ("Check if the user signed in", LOG_LEVEL.INFO);
            if (appModel.AdvantageShoppingApplication().SIGNOUTLabel().exists(5)) {
                signOut();
                utils.windowSync(2000);
                utils.logMessages ("Tap 'Open Menu (after sign-out)'", LOG_LEVEL.INFO);
                appModel.AdvantageShoppingApplication().MenuButton().tap();
                utils.windowSync(2000);
            }

            utils.logMessages ("Tap login label", LOG_LEVEL.INFO);
            if (utils.HIGHLIGHT)
                appModel.AdvantageShoppingApplication().LOGINLabel().highlight();
            appModel.AdvantageShoppingApplication().LOGINLabel().tap();

            utils.logMessages ("Type name", LOG_LEVEL.INFO);
            if (utils.HIGHLIGHT)
                appModel.AdvantageShoppingApplication().USERNAMEEditField().highlight();
            appModel.AdvantageShoppingApplication().USERNAMEEditField().setText("mercury1");

            utils.logMessages ("Type password", LOG_LEVEL.INFO);
            if (utils.HIGHLIGHT)
                appModel.AdvantageShoppingApplication().PASSWORDEditField().highlight();
            appModel.AdvantageShoppingApplication().PASSWORDEditField().setSecure("97ededd61184a118aeb05c9627");

            utils.logMessages ("Tap login button", LOG_LEVEL.INFO);
            if (utils.HIGHLIGHT)
                appModel.AdvantageShoppingApplication().LOGINButton().highlight();
            appModel.AdvantageShoppingApplication().LOGINButton().tap();

            utils.logMessages ("Select 'laptop' category", LOG_LEVEL.INFO);
            if (utils.HIGHLIGHT)
                appModel.AdvantageShoppingApplication().LAPTOPSLabel().highlight();
            appModel.AdvantageShoppingApplication().LAPTOPSLabel().tap();

            utils.logMessages ("Select a laptop", LOG_LEVEL.INFO);
            if (utils.HIGHLIGHT)
                appModel.AdvantageShoppingApplication().SelectedLaptop4().highlight();
            appModel.AdvantageShoppingApplication().SelectedLaptop4().tap();

            utils.logMessages ("Tap 'Add to Cart' button", LOG_LEVEL.INFO);
            if (utils.HIGHLIGHT)
                appModel.AdvantageShoppingApplication().ADDTOCARTButton().highlight();
            appModel.AdvantageShoppingApplication().ADDTOCARTButton().tap();
            utils.windowSync(1500);

            utils.logMessages ("Tap the back button", LOG_LEVEL.INFO);
            if (utils.HIGHLIGHT)
                appModel.AdvantageShoppingApplication().BackButton().highlight();
            appModel.AdvantageShoppingApplication().BackButton().tap();

            utils.logMessages ("Tap 'Open Menu'", LOG_LEVEL.INFO);
            if (utils.HIGHLIGHT)
                appModel.AdvantageShoppingApplication().MenuButton().highlight();
            appModel.AdvantageShoppingApplication().MenuButton().tap();

            utils.logMessages ("Tap 'Open Cart'", LOG_LEVEL.INFO);
            if (utils.HIGHLIGHT)
                appModel.AdvantageShoppingApplication().OpenCart().highlight();
            appModel.AdvantageShoppingApplication().OpenCart().tap();

            utils.logMessages ("Tap the checkout button", LOG_LEVEL.INFO);
            if (utils.HIGHLIGHT)
                appModel.AdvantageShoppingApplication().CHECKOUTPAYButton().highlight();
            appModel.AdvantageShoppingApplication().CHECKOUTPAYButton().tap();

            utils.logMessages ("Tap the pay now button", LOG_LEVEL.INFO);
            if (utils.HIGHLIGHT)
                appModel.AdvantageShoppingApplication().PAYNOWButton().highlight();
            appModel.AdvantageShoppingApplication().PAYNOWButton().tap();

            utils.logMessages ("Tap OK", LOG_LEVEL.INFO);
            if (utils.HIGHLIGHT)
                appModel.AdvantageShoppingApplication().OkButton().highlight();
            appModel.AdvantageShoppingApplication().OkButton().tap();

            appModel.AdvantageShoppingApplication().MenuButton().tap();
            signOut();

            utils.logMessages ("********** Test completed successfully **********", LOG_LEVEL.INFO);

        } catch (ReplayObjectNotFoundException ronfex) {
            utils.logMessages ("error code: " + ronfex.getErrorCode() + " - " + ronfex.getMessage(), LOG_LEVEL.ERROR);
            Assert.fail();
        }
    }

    private void signOut() throws GeneralLeanFtException {
        if (utils.HIGHLIGHT)
            appModel.AdvantageShoppingApplication().SIGNOUTLabel().highlight();
        appModel.AdvantageShoppingApplication().SIGNOUTLabel().tap();

        if (utils.HIGHLIGHT)
            appModel.AdvantageShoppingApplication().YesButton().highlight();
        appModel.AdvantageShoppingApplication().YesButton().tap();
    }

}