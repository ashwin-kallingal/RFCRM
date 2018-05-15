package com.fcrm.utility;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.imageio.ImageIO;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Utility 
{	
	public static String getFormattedDateTime()
	{
		SimpleDateFormat sdf = new SimpleDateFormat("dd_MM_YYYY_hh_mm_ss");
		return sdf.format(new Date());
	}
	
	public static String getScreenshot(WebDriver driver, String name)
	{
		String path = "E:/RFCRM/FCRM/snapshot"+"/"+name+".png";
		try
		{
			TakesScreenshot ts = (TakesScreenshot)driver;
			File srcFile = ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(srcFile, new File(path));			
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}		
		return path;
	}
	
	public static void getDesktopScreenshot(String imgPath)
	{
		String timeStamp=getFormattedDateTime();
		
		try
		{
			Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
			Rectangle scrnRect = new Rectangle(d);
			
			Robot r = new Robot();
			BufferedImage img = r.createScreenCapture(scrnRect);
			
			File output = new File(imgPath+timeStamp+".png");
			ImageIO.write(img, "png", output);			
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}		
	}	
}