package com.dmd.xml.settings;

import com.dmd.model.settings.GeneralSettings;
import com.dmd.xml.XmlConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

import javax.annotation.Resource;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

@Service
public class GeneralSettingsHandler {
    private static final String SETTING_FILE_NAME = "dmdSettings.xml";
    @Resource
    XmlConverter xmlConverter;


    public GeneralSettings loadSettings(String fileName) throws IOException, JAXBException {
        if (fileName == null || fileName == "") {
            fileName = SETTING_FILE_NAME;
        }
        GeneralSettings generalSettings = (GeneralSettings) xmlConverter.convertFromXMLToObject(fileName);
        return generalSettings;
    }

    public void saveSettings(String fileName) throws IOException, JAXBException {
        if (fileName == null || fileName == "") {
            fileName = SETTING_FILE_NAME;
        }
        GeneralSettings generalSettings = new GeneralSettings(fileName);
        xmlConverter.convertFromObjectToXML(generalSettings, fileName);
    }

}