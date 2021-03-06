package com.dmd.xml.settings;

import com.dmd.model.settings.GeneralSettings;
import com.dmd.xml.XmlConverter;
import org.springframework.stereotype.Service;

import java.io.IOException;

import javax.annotation.Resource;
import javax.xml.bind.JAXBException;

@Service
public class GeneralSettingsHandler {
    private static final String SETTING_FILE_NAME = "dmdSettings.xml";
    @Resource
    XmlConverter xmlConverter;


    public GeneralSettings loadSettings(String fileName) throws IOException, JAXBException {
        fileName = composeFileName(fileName);
        GeneralSettings generalSettings = (GeneralSettings) xmlConverter.convertFromXMLToObject(fileName);
        return generalSettings;
    }

    public void saveSettings(String fileName) throws IOException, JAXBException {
        fileName = composeFileName(fileName);
        GeneralSettings generalSettings = new GeneralSettings(fileName);
        xmlConverter.convertFromObjectToXML(generalSettings, fileName);
    }


    private String composeFileName(String fileName) {
        if (fileName == null || fileName == "") {
            fileName = SETTING_FILE_NAME;
        }
        return fileName;
    }
}