package com.pg.premiumcalculator.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.apache.commons.io.FilenameUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.pg.premiumcalculator.models.Vehicle;
import com.pg.premiumcalculator.repository.VehicleRepository;
import com.pg.premiumcalculator.resource.PremiumResource;

@Service
public class VehicleDataService {
	
	@Autowired
	VehicleRepository vehicleRepository;
	
	@Autowired
	ServletContext context;
	
	private static Logger logger = LogManager.getLogger(PremiumResource.class.getName());
	
	public List<Vehicle> findAll()
	{
//		List<String> images = getVehicleImages();
//		for(String url : images)
//		{
//			logger.debug(url);
//		}
		List<Vehicle> vehicles = vehicleRepository.findAll();
		return vehicles;
	}
	
	private List<String> getVehicleImages()
	{
		List<String> images = new ArrayList<String>();
		
		String filesPath = context.getRealPath("/vehicleImages");

		logger.debug("error tag"+filesPath);
		
		File fileFolder = new File(filesPath);
		if(fileFolder!=null)
		{
			for(File file : fileFolder.listFiles())
			{
				if(!file.isDirectory())
				{
					String encodeBase64 = null;
					try
					{
						String extension = FilenameUtils.getExtension(file.getName());
						FileInputStream fileInputStream = new FileInputStream(file);
						byte[] bytes = new byte[(int)file.length()];
						fileInputStream.read(bytes);
						encodeBase64 = Base64.getEncoder().encodeToString(bytes);
						images.add("data:image/"+extension+";base64,"+encodeBase64);
						fileInputStream.close();
					}
					catch(Exception e) {}
				}
			}
		}
		return images;
	}
}
