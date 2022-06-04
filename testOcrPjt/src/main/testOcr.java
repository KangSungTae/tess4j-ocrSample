package main;

import java.io.File;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class testOcr {
	
	public static void main(String[] args) {
		
		String path = System.getProperty("user.dir");
		String image = path+"/resource/test.pdf";
		
		File file = new File(image);
		
		/* file path ������ ���� ������ �������� �ʴ� ��� tess4j �� ������ ����. */
		if(file.exists()) {
			System.out.println("true");
		}else {
			System.out.println("false");
		}
		
		ITesseract instance = new Tesseract(); 
		
		/* https://tesseract-ocr.github.io/tessdoc/Data-Files ���� �����ϰ��� �ϴ� datafile�� �ٿ�޾� ��θ� ���� */
		String trainedDataPath = System.getProperty("user.dir")+"/tessdata";
		instance.setDatapath(trainedDataPath);
		
		/* ISO 639-3 �԰��� �̿��Ͽ� �� ������ �� �ִ�. default �� eng.traineddata�� ���� */
		instance.setLanguage("kor");
		
		try {
			String result = instance.doOCR(file);
			System.out.println(result);
		} catch (TesseractException e) {
			System.out.println(e.getMessage());
		}
	}
}
