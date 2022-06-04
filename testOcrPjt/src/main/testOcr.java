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
		
		/* file path 오류로 인해 파일이 생성되지 않는 경우 tess4j 는 에러를 뱉어낸다. */
		if(file.exists()) {
			System.out.println("true");
		}else {
			System.out.println("false");
		}
		
		ITesseract instance = new Tesseract(); 
		
		/* https://tesseract-ocr.github.io/tessdoc/Data-Files 에서 번역하고자 하는 datafile을 다운받아 경로를 지정 */
		String trainedDataPath = System.getProperty("user.dir")+"/tessdata";
		instance.setDatapath(trainedDataPath);
		
		/* ISO 639-3 규격을 이용하여 언어를 설정할 수 있다. default 는 eng.traineddata로 설정 */
		instance.setLanguage("kor");
		
		try {
			String result = instance.doOCR(file);
			System.out.println(result);
		} catch (TesseractException e) {
			System.out.println(e.getMessage());
		}
	}
}
