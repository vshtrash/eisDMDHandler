package com.dmd;

import com.dmd.service.settings.handlers.GeneralSettingsHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.dmd.service.HelloMessageService;
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
			generalSettingsHandler.loadSettings(args[0].toString());
			//System.out.println(helloService.getMessage(args[0].toString()));
		} else {
			generalSettingsHandler.loadSettings(null);
		}

		exit(0);
	}
}