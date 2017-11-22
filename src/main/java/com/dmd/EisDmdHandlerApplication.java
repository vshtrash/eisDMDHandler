package com.dmd;

import com.dmd.xml.settings.GeneralSettingsHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;

import static java.lang.System.exit;

@SpringBootApplication
public class EisDmdHandlerApplication implements CommandLineRunner {

	@Autowired
	private GeneralSettingsHandler generalSettingsHandler;
	//private HelloMessageService helloService;

	public static void main(String[] args) throws Exception {

		//disabled banner, don't want to see the spring logo
		SpringApplication app = new SpringApplication(EisDmdHandlerApplication.class);
		app.setBannerMode(Banner.Mode.OFF);
		app.run(args);

	}

	// Put your logic here.
	@Override
	public void run(String... args) throws Exception {

		if (args.length > 0) {
			generalSettingsHandler.saveSettings(null);
			generalSettingsHandler.loadSettings(args[0].toString());
			//System.out.println(helloService.getMessage(args[0].toString()));
		} else {
			generalSettingsHandler.saveSettings(null);
			generalSettingsHandler.loadSettings(null);
		}

		exit(0);
	}
}