package br.com.xml.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import java.util.ArrayList;

@EnableConfigurationProperties
@ConfigurationProperties("register")
@Data
public class XmlApiProperty {

	private String originPermitida;

	private ArrayList<String> arrayOriginPermitida;

	private final Seguranca seguranca = new Seguranca();

	@Data
	public static class Seguranca {
		private boolean enableHttps;
	}
}
