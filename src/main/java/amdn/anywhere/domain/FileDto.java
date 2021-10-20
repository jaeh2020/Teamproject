package amdn.anywhere.domain;

public class FileDto {
	private String fileId; // 유일한 파일 분별코드
	private String fileName; //실제 파일 이름
	private String contentType;
	
	public FileDto() {}
	
	public FileDto(String fileId, String fileName, String contentType) {
		
		this.fileId = fileId;
		this.fileName = fileName;
		this.contentType = contentType;
	}

	public String getFileId() {
		return fileId;
	}

	public void setFileId(String fileId) {
		this.fileId = fileId;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	@Override
	public String toString() {
		return "FileDto [fileId=" + fileId + ", fileName=" + fileName + ", contentType=" + contentType + "]";
	}
	
	
}
