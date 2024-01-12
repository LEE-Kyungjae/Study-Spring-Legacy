package service;

import java.io.File;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import vo.PhotoVO;


public class FileUploadService {
	@Autowired
	static
	ServletContext app;

	public static void uploadserve(PhotoVO vo) {
		String webPath = "/resources/upload/";
		String savePath = app.getRealPath(webPath);
		System.out.println("절대경로" + savePath);
		// 업로드된 파일의 정보
		MultipartFile photo = vo.getPhoto();

		String filename = "no_file";

		if (!photo.isEmpty()) {
			filename = photo.getOriginalFilename();// 업로드 된 실제 파일명(a.jpg)
			File saveFile = new File(savePath, filename);
			if (!saveFile.exists()) {
				saveFile.mkdirs();
			} else {
				// 파일이름이 중복되지 않게 변경
				long time = System.currentTimeMillis();
				filename = String.format("%d_%s", time, filename);
				saveFile = new File(savePath, filename);
			}
			try {
				// 임시저장소에 있던 파일정보를 내가 지정해둔 경로로 물리적으로 복사
				photo.transferTo(saveFile);
			} catch (Exception e) {
			}
		} // if
		vo.setFilename(filename);
	}

}
