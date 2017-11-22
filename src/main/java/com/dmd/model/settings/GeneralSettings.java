package com.dmd.model.settings;


public class GeneralSettings {
    private String settingFileName;
    private String apiURL;
    private String apiUser;
    private String apiPassword;


    public GeneralSettings() {
    }

    public GeneralSettings(String settingFileName) {
        this.settingFileName = settingFileName;
    }

    public GeneralSettings(String settingFileName, String apiURL, String apiUser, String apiPassword) {
        this.settingFileName = settingFileName;
        this.apiURL = apiURL;
        this.apiUser = apiUser;
        this.apiPassword = apiPassword;
    }

    public String getSettingFileName() {
        return settingFileName;
    }

    public void setSettingFileName(String settingFileName) {
        this.settingFileName = settingFileName;
    }

    public String getApiURL() {
        return apiURL;
    }

    public void setApiURL(String apiURL) {
        this.apiURL = apiURL;
    }

    public String getApiUser() {
        return apiUser;
    }

    public void setApiUser(String apiUser) {
        this.apiUser = apiUser;
    }

    public String getApiPassword() {
        return apiPassword;
    }

    public void setApiPassword(String apiPassword) {
        this.apiPassword = apiPassword;
    }

    @Override
    public String toString() {
        return "GeneralSettings{" +
                "settingFileName='" + settingFileName + '\'' +
                ", apiURL='" + apiURL + '\'' +
                ", apiUser='" + apiUser + '\'' +
                ", apiPassword='" + apiPassword + '\'' +
                '}';
    }
}
