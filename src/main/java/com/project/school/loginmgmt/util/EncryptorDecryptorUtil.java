/**
 * 
 */
package com.project.school.loginmgmt.util;

import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * @author Vishal
 *
 */
@Service
@Scope("prototype")
public class EncryptorDecryptorUtil {
	 public StringEncryptor stringEncryptor() {
	     PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
	     SimpleStringPBEConfig config = new SimpleStringPBEConfig();
	     config.setPassword("school");
	     config.setAlgorithm("PBEWithMD5AndDES");
	     config.setKeyObtentionIterations("1000");
	     config.setPoolSize("1");
	     config.setProviderName("SunJCE");
	     config.setSaltGeneratorClassName("org.jasypt.salt.ZeroSaltGenerator");
	     config.setStringOutputType("base64");
	     encryptor.setConfig(config);
	     return encryptor;
	 }
	 
		public String encryptString(String text) {
			return stringEncryptor().encrypt(text);
		}
		public String decryptString(String text) {
			return stringEncryptor().decrypt(text);
		}

}
