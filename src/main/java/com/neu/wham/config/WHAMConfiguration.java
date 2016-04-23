package com.neu.wham.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import com.neu.wham.exceptions.WHAMConfigurationException;
import com.neu.wham.keys.DBConstants;

/**
 * This class is used to configure the WEBAPPLICATION
 * @author Viji
 *
 */
public class WHAMConfiguration {
	@Autowired
	private ApplicationContext context;
	Logger log = LoggerFactory.getLogger(WHAMConfiguration.class);
	public WHAMConfiguration() {
		log.info("Under WHAMCOnfig");
		String CATALINA_HOME = System.getProperty("catalina.home");
		if(null==CATALINA_HOME){
			log.error("CATALINA_HOME is not set, WHAM failed to startup.");
			System.exit(1);
		}
		Properties properties = new Properties();
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(CATALINA_HOME+"/WhamConfig/wham.config");
			properties.load(fis);
			log.info(properties.toString());
			validateLogProperties(properties);
			fis.close();
			fis = null;
		} catch (FileNotFoundException e) {
			log.error(e.getMessage());
			System.exit(1);
		} catch (IOException e) {
			log.error(e.getMessage());
			System.exit(1);
		} catch (WHAMConfigurationException e) {
			log.error(e.getMessage());
			System.exit(1);
		}finally{
			if(fis!=null){
				try {
					fis.close();
				} catch (IOException e) {
					log.error(e.getMessage());
				}
				fis = null;
			}
		}
	}
	
	private void validateLogProperties(Properties properties) throws WHAMConfigurationException {
		if(properties!=null && properties.containsKey("DB_IP")  
				&& properties.containsKey("DB_PORT") && properties.containsKey("DB_USERNAME") 
				&& properties.containsKey("DB_PASSWORD") && properties.containsKey("WHAM_IMAGE_STORAGE_LOCATION")
				&& properties.containsKey("SERVER_IP") && properties.containsKey("SERVER_PORT")
				&& checkForString(properties.getProperty("SERVER_IP")) && checkForString(properties.getProperty("SERVER_PORT"))
				&& checkForString(properties.getProperty("DB_IP")) && checkForString(properties.getProperty("DB_PORT"))
				&& checkForString(properties.getProperty("DB_PASSWORD")) && checkForString(properties.getProperty("DB_USERNAME"))
				&& checkForString(properties.getProperty("WHAM_IMAGE_STORAGE_LOCATION"))){
			
				DBConstants.DB_URL = properties.getProperty("DB_IP")+":"+properties.getProperty("DB_Port")+"/whamDB";
				DBConstants.USER = properties.getProperty("DB_USERNAME");
				DBConstants.PASS = properties.getProperty("DB_PASSWORD");
				com.neu.wham.keys.Constants.IMAGE_UPLOAD_PATH = properties.getProperty("WHAM_IMAGE_STORAGE_LOCATION");
				com.neu.wham.keys.Constants.AMAZON_IMAGE_URL = "http://"+ properties.getProperty("SERVER_IP")+":"+properties.getProperty("SERVER_PORT")+"/WHAM/user_images/";
				
				//Check if the Image storage folder exists
				File whamImagesStorageFolder = new File(com.neu.wham.keys.Constants.IMAGE_UPLOAD_PATH);
				if(whamImagesStorageFolder.exists()){
					log.info("WHAM IMAGE STORAGE FOLDER already exists at location " + com.neu.wham.keys.Constants.IMAGE_UPLOAD_PATH);
				}else{
					if(whamImagesStorageFolder.mkdir())
						log.info("WHAM IMAGE STORAGE FOLDER newly created at location " + com.neu.wham.keys.Constants.IMAGE_UPLOAD_PATH);
						else
						log.info("Error in creating folder");

				}
				
				log.info("Configuration Values");
				log.info("DB_IP" + properties.getProperty("DB_IP"));
				log.info("DB_PORT" + properties.getProperty("DB_PORT"));
				log.info("DB_USERNAME" + properties.getProperty("DB_USERNAME"));
				log.info("DB_PASSWORD" + properties.getProperty("DB_PASSWORD"));
				log.info("WHAM_IMAGE_STORAGE_LOCATION" + properties.getProperty("WHAM_IMAGE_STORAGE_LOCATION"));
				log.info("SERVER_IP" + properties.getProperty("SERVER_IP"));
				log.info("SERVER_PORT" + properties.getProperty("SERVER_PORT"));
				log.info("****** WHAM IS CONFIGURED *****");
				return;
		}
		throw new WHAMConfigurationException("WHAM configuration file doesnot have all the entities\nThere should be 5 entries that are should be not null");
	}
	
	private boolean checkForString(Object str){
		log.info(str+"");
		return str!=null && !(((String)str).isEmpty());
	}
}
