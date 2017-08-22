package com.fhz;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

//读取一个二维码
public class ReadQR {

	public static void main(String[] args) {

		//创建一个二维码
		MultiFormatReader formateReader = new MultiFormatReader();
		//创建一个二维码读取
		File file = new File("D:/code.png");
		BufferedImage bi;
		try {
			bi = ImageIO.read(file);
			BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(bi)));
			
			//定义二维码参数,如果不加也可以生成.这个map是定义二维码的样式.
			HashMap hMap = new HashMap<>();
			//字符集
			hMap.put(EncodeHintType.CHARACTER_SET, "utf-8");
					
			//解析二维码		
			Result result = formateReader.decode(binaryBitmap,hMap);
			
			System.out.println("解析结果="+result.toString());
			System.out.println("二维码类型="+result.getBarcodeFormat());
			System.out.println("二维码内容="+result.getText());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
	}

}
