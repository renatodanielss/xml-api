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

	private final S3 s3 = new S3();

	public S3 getS3() {
		return s3;
	}

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

	public static class S3 {

		private String accessKeyId;

		private String secretAccessKey;
		
		private String bucket;
		
		private String bucketDefault;
		
		private String photoDefaultAccount;
		
		private String pathAccount;
		
		private String photoDefaultDealer;
		
		private String pathDealer;
		
		private String photoDefaultStore;
		
		private String pathStore;

		public String getAccessKeyId() {
			return accessKeyId;
		}

		public void setAccessKeyId(String accessKeyId) {
			this.accessKeyId = accessKeyId;
		}

		public String getSecretAccessKey() {
			return secretAccessKey;
		}

		public void setSecretAccessKey(String secretAccessKey) {
			this.secretAccessKey = secretAccessKey;
		}

		public String getBucket() {
			return bucket;
		}

		public void setBucket(String bucket) {
			this.bucket = bucket;
		}

		public String getPhotoDefaultAccount() {
			return photoDefaultAccount;
		}

		public void setPhotoDefaultAccount(String photoDefaultAccount) {
			this.photoDefaultAccount = photoDefaultAccount;
		}

		public String getPathAccount() {
			return pathAccount;
		}

		public void setPathAccount(String pathAccount) {
			this.pathAccount = pathAccount;
		}

		public String getPhotoDefaultDealer() {
			return photoDefaultDealer;
		}

		public void setPhotoDefaultDealer(String photoDefaultDealer) {
			this.photoDefaultDealer = photoDefaultDealer;
		}

		public String getPathDealer() {
			return pathDealer;
		}

		public void setPathDealer(String pathDealer) {
			this.pathDealer = pathDealer;
		}

		public String getPhotoDefaultStore() {
			return photoDefaultStore;
		}

		public void setPhotoDefaultStore(String photoDefaultStore) {
			this.photoDefaultStore = photoDefaultStore;
		}

		public String getPathStore() {
			return pathStore;
		}

		public void setPathStore(String pathStore) {
			this.pathStore = pathStore;
		}

		public String getBucketDefault() {
			return bucketDefault;
		}

		public void setBucketDefault(String bucketDefault) {
			this.bucketDefault = bucketDefault;
		}
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
