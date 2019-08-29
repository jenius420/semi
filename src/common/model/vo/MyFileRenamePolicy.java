package common.model.vo;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.oreilly.servlet.multipart.FileRenamePolicy;

public class MyFileRenamePolicy implements FileRenamePolicy {

	@Override
	public File rename(File originFile) { // 원본 파일 받을 거임
		
		// 원본명 --> 변경명 : 파일업로드한시간(년월일시분초)+0~100000사이의 랜덤값 (5자리의 랜덤값) 부여할것
		// aaa.jpg --> 2019082103211296523.jpg
		
		// 현재 시간을 long 형으로 받을 거임
		long currentTime = System.currentTimeMillis();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		int ranNum = (int)(Math.random()*100000); // 5자리의 랜덤 숫자
		
		// 파일명은 변경해도 확장자를 유지하기 위해
		// 별도로 확장자명 가져오기
		String name = originFile.getName();	// 원본파일명 ("aaa.jpg")
		
		String ext = "";	// 확장자만 추출해서 담아줄 변수 미리 선언
		
		int dot = name.lastIndexOf(".");	// .의 위치값(인덱스) 알아내기
		
		if(dot != -1) { // 존재할 경우
			// .포함해서 확장자 추출(ext)
			ext = name.substring(dot);	// .의 위치값부터 마지막까지 전체 추출 --> ".jpg"
		}
		
		// 최종적으로 수정할 파일명
		String fileName = sdf.format(new Date(currentTime)) + ranNum + ext; // 2019082113281265324.jpg
		
		// 전달받은 파일(originFile)을 변경된 파일명으로 파일 객체 생성
		File newFile = new File(originFile.getParent(), fileName);
		
		return newFile;
	}

}
