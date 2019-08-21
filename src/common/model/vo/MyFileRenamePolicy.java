package common.model.vo;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.oreilly.servlet.multipart.FileRenamePolicy;

public class MyFileRenamePolicy implements FileRenamePolicy {

	@Override
	public File rename(File originFile) {
		
		long currentTime = System.currentTimeMillis();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		int random = (int)(Math.random()*100000);
		
		String name = originFile.getName(); // 원본파일명 가져오기
		
		String ext = ""; // 확장자 추출
		int dot = name.lastIndexOf(".");
		
		if(dot != -1) {
			ext = name.substring(dot);
		}
		
		String fileName = sdf.format(new Date(currentTime)) + random + ext;
		
		File newFile = new File(originFile.getParent(), fileName);
		
		return newFile;
	}
	
	

}
