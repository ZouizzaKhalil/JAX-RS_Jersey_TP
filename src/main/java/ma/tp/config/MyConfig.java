package ma.tp.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.glassfish.jersey.jaxb.internal.XmlJaxbElementProvider;

import ma.tp.restapi.CompteRestJaxRSAPI;

@Configuration
public class MyConfig {
	
	@Bean
	public ResourceConfig resourceConfig() {
		ResourceConfig jersyServlet = new ResourceConfig();
		jersyServlet.register(CompteRestJaxRSAPI.class);
        jersyServlet.register(XmlJaxbElementProvider.App.class);
		return jersyServlet;
	}
}
