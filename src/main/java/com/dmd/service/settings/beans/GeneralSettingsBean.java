package com.dmd.service.settings.beans;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "dmd")
@XmlType
public class GeneralSettingsBean {
    private String settingFileName;
    private String apiURL;
    private String apiUser;
    private String apiPassword;

    @XmlTransient
    public String getSettingFileName() {
        return settingFileName;
    }

    public void setSettingFileName(String settingFileName) {
        this.settingFileName = settingFileName;
    }

    @XmlElement(name = "apiURL")
    public String getApiURL() {
        return apiURL;
    }

    public void setApiURL(String apiURL) {
        this.apiURL = apiURL;
    }

    @XmlElement(name = "apiUSER")
    public String getApiUser() {
        return apiUser;
    }

    public void setApiUser(String apiUser) {
        this.apiUser = apiUser;
    }

    @XmlElement(name = "apiPassword")
    public String getApiPassword() {
        return apiPassword;
    }

    public void setApiPassword(String apiPassword) {
        this.apiPassword = apiPassword;
    }

}
