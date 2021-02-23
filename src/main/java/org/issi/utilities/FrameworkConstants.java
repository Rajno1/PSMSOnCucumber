package org.issi.utilities;

public final class FrameworkConstants {
    private FrameworkConstants() {
    }

    private static final String MAINRESOURCEPATH = System.getProperty("user.dir") + "/src/main/resources";
    private static final String TESTRESOURCESPATH = System.getProperty("user.dir") + "/src/test/resources";
    private static final String CONFIGFILEPATH = TESTRESOURCESPATH + "/config/config.properties";

    public static String getConfigFilePath() {
        return CONFIGFILEPATH;
    }


}
