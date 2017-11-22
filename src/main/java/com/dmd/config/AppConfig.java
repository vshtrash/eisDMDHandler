package com.dmd.config;

import javax.annotation.Resource;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.castor.CastorMarshaller;
import com.dmd.xml.*;


@Configuration
public class AppConfig {

    @Resource
    ConfigurableApplicationContext appContext;

    @Bean
    XmlConverter xmlConverter(){
        XmlConverter xmlConverter = new XmlConverter();
        xmlConverter.setMarshaller(castorMarshaller());
        xmlConverter.setUnmarshaller(castorMarshaller());
        return xmlConverter;
    }

    @Bean
    public CastorMarshaller castorMarshaller(){
        CastorMarshaller castorMarshaller = new CastorMarshaller();
        castorMarshaller.setMappingLocation(appContext.getResource("classpath:mapping.xml"));  //ref to xml mapping
        return castorMarshaller;
    }
}
