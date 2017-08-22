package com.fhz;

import java.io.File;
import java.nio.file.Path;
import java.security.spec.EncodedKeySpec;
import java.util.HashMap;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

/**
 * 二维码生产
 * @author Administrator
 *
 */
public class CreateQR {

	public static void main(String[] args) {
		//二维码宽高
		int width = 300;
		int height = 300;
		//图片格式
		String format = "png";
		//链接
		String content = "http://www.fenghongzhang.com";
		
		
		//定义二维码参数,如果不加也可以生成.这个map是定义二维码的样式.
		HashMap hMap = new HashMap<>();
		//字符集
		hMap.put(EncodeHintType.CHARACTER_SET, "utf-8");
		//容错级别.一共有四个级别.
		hMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
		//边距
		hMap.put(EncodeHintType.MARGIN, 2);
		
		try {
			//第一个参数是内容.
			//2,是二维码标准
			//5.是二维码参数
			BitMatrix encode = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, width, height,hMap);
			
			//创建一个路径中
			Path file = new File("D:/code1.png").toPath();
			//MatrixToImageWriter方法可以点出来不同的方法.比如可以写入到流.这个案例是写入到文件.
			MatrixToImageWriter.writeToPath(encode, format, file);
			//输入到一个流中.
			//MatrixToImageWriter.writeToStream(encode, format, stream);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
