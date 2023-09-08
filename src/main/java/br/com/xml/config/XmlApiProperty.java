package br.com.xml.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import java.util.ArrayList;

@EnableConfigurationProperties
@ConfigurationProperties("register")
public class XmlApiProperty {

	private String originPermitida;

	private ArrayList<String> arrayOriginPermitida;

	private final Seguranca seguranca = new Seguranca();

	public Seguranca getSeguranca() {
		return seguranca;
	}

	public String getOriginPermitida() {
		return originPermitida;
	}

	public void setOriginPermitida(String originPermitida) {
		this.originPermitida = originPermitida;
	}

	public ArrayList<String> getArrayOriginPermitida() {
		return arrayOriginPermitida;
	}

	public void setArrayOriginPermitida(ArrayList<String> arrayOriginPermitida) {
		this.arrayOriginPermitida = arrayOriginPermitida;
	}

	public static class Seguranca {

		private boolean enableHttps;

		public boolean isEnableHttps() {
			return enableHttps;
		}

		public void setEnableHttps(boolean enableHttps) {
			this.enableHttps = enableHttps;
		}

	}

}
