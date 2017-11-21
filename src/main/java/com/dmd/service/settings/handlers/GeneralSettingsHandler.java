package com.dmd.service.settings.handlers;

import com.dmd.service.settings.beans.GeneralSettingsBean;
import org.springframework.stereotype.Service;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

@Service
public class GeneralSettingsHandler {
    private static final String SETTING_FILE_NAME = "dmdSettings.xml";


    public GeneralSettingsBean loadSettings(String fileName) throws JAXBException {
        GeneralSettingsBean generalSettingsBean = new GeneralSettingsBean();

        generalSettingsBean.setApiUser("AASS");
        jaxbObjectToXML(generalSettingsBean, SETTING_FILE_NAME );

        if (fileName != null && fileName != "") {
            generalSettingsBean = jaxbXMLToObject(fileName);
            generalSettingsBean.setSettingFileName(fileName);
        } else {
            generalSettingsBean = jaxbXMLToObject(SETTING_FILE_NAME);
            generalSettingsBean.setSettingFileName(SETTING_FILE_NAME);
        }
        return generalSettingsBean;
    }


    private static GeneralSettingsBean jaxbXMLToObject(String fileName) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(GeneralSettingsBean.class);
        Unmarshaller un = context.createUnmarshaller();
        GeneralSettingsBean generalSettingsBean = (GeneralSettingsBean) un.unmarshal(new File(fileName));
        return generalSettingsBean;
    }


    private static void jaxbObjectToXML(GeneralSettingsBean generalSettingsBean, String fileName) throws JAXBException {

        JAXBContext context = JAXBContext.newInstance(GeneralSettingsBean.class);
        Marshaller m = context.createMarshaller();
        //for pretty-print XML in JAXB
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        // Write to System.out for debugging
        // m.marshal(emp, System.out);

        // Write to File
        m.marshal(generalSettingsBean, new File(fileName));
    }


}