package vo;

import org.springframework.web.multipart.MultipartFile;

public class PhotoVO {

	// insert_form.jsp
	// 제목:<input name="title">
	// 사진:<input type = "file" name = "photo">
	private String title, filename;
	private MultipartFile photo;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public MultipartFile getPhoto() {
		return photo;
	}

	public void setPhoto(MultipartFile photo) {
		this.photo = photo;
	}
}
