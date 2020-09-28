package org.zerock.Exam;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.zerock.domain.AttachFileDTO;
import net.coobird.thumbnailator.Thumbnailator;

@Controller
public class UploadController {
	public static void main(String[] args) {
		System.out.println(LoggerFactory.getLogger(UploadController.class));
	}

//	private static final Logger logger = LoggerFactory.getLogger(UploadController.class);

	private static final Logger logger = LoggerFactory.getLogger(UploadController.class);
//	@javax.annotation.Resource(name = "uploadPath")
//	private String uploadPath;
	private String uploadPath = "D:\\uploadimg";

	private String getFolder() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String str = sdf.format(date);
		System.out.println("오늘날자" + str);
		return str.replace("-", File.separator);
	}

	private boolean checkImageType(File file) {
		try {
			String contentType = Files.probeContentType(file.toPath());
			return contentType.startsWith("image");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	@RequestMapping(value = "/uploadForm", method = RequestMethod.GET)
	public void uploadForm() {
		System.out.println("=====파일업로드 화면=======");
		logger.info("파일업로드 화면");

	}

	@RequestMapping(value = "/uploadForm", method = RequestMethod.POST)
	public void uploadForm(MultipartFile[] file, Model model) throws Exception {
		File uploadFolder = new File(uploadPath, getFolder());
		System.out.println("" + uploadFolder);
		// 폴더의 존재여부 확인
		if (uploadFolder.exists() == false) {
			uploadFolder.mkdirs();
		}
		for (int i = 0; i < file.length; i++) {
			logger.info("originalName: " + file[i].getOriginalFilename());
			logger.info("size: " + file[i].getSize());
			logger.info("contentType: " + file[i].getContentType());
			System.out.println("======================");
			System.out.println("originalName: " + file[i].getOriginalFilename());
			System.out.println("size: " + file[i].getSize());
			System.out.println("contentType: " + file[i].getContentType());
			File saveFile = new File(uploadFolder, file[i].getOriginalFilename());

			try {
				file[i].transferTo(saveFile);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	@RequestMapping(value = "uploadAjax", method = RequestMethod.GET)
	private void uploadAjax() {
		// TODO Auto-generated method stub
		logger.info("uploadAjax");
		System.out.println("uploadAjax" + logger);
		System.out.println("파일업로드 ajax 화면");
	}

//	@RequestMapping(value = "uploadAjax", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@RequestMapping(value = "uploadAjax", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<AttachFileDTO>> uploadAjax(MultipartFile[] file) {

		File uploadFolder = new File(uploadPath, getFolder());

		List<AttachFileDTO> list = new ArrayList<>();

		System.out.println("" + uploadFolder);
		// 폴더의 존재여부 확인
		if (uploadFolder.exists() == false) {
			uploadFolder.mkdirs();
		}
		for (int j = 0; j < file.length; j++) {
			System.out.println("originalName: " + file[j].getOriginalFilename());

			System.out.println("size: " + file[j].getSize());
			System.out.println("contentType: " + file[j].getContentType());
			String uploadFileName = file[j].getOriginalFilename();
			// UUID추가해서 중복방지

			UUID uuid = UUID.randomUUID();

			uploadFileName = uuid.toString() + "_" + uploadFileName;

			File saveFile = new File(uploadFolder, uploadFileName);
//=======================================DTO 저장=====================			
			AttachFileDTO attach = new AttachFileDTO();

			String fileName = file[j].getOriginalFilename();
			System.out.println("=======fileName==========" + fileName);
			attach.setFileName(fileName);
//			attach.setUploadPath(getFolder().replace("\\", "/"));
			attach.setUploadPath(getFolder());
			attach.setUuid(uuid.toString());

			System.out.println("===========" + attach);

//=======================================DTO 저장=====================			

			try {
				file[j].transferTo(saveFile);
				if (checkImageType(saveFile)) {
					attach.setImage(true);// AttachFileDTO 이미지 체크
					list.add(attach);// AttachFileDTO list에 넣어주기
					FileOutputStream thumnail = new FileOutputStream(new File(uploadFolder, "s_" + uploadFileName));
					Thumbnailator.createThumbnail(file[j].getInputStream(), thumnail, 100, 100);
					thumnail.close();
				}else {
					list.add(attach);// AttachFileDTO list에 넣어주기					
				}



			} catch (Exception e) {
				e.printStackTrace();
			}
		}
//		return new ResponseEntity<>("success", HttpStatus.CREATED);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	// display(업로드 파일이 이미지 인거)
	@RequestMapping(value = "display", method = RequestMethod.GET)
	public ResponseEntity<byte[]> getFile(String fileName) {
		System.out.println("====fileName======" + fileName);
		File file = new File("D:\\uploadimg\\" + fileName);
		System.out.println("====file======" + file);
		ResponseEntity<byte[]> result = null;
		try {
			HttpHeaders header = new HttpHeaders();
			header.add("content-Type", Files.probeContentType(file.toPath()));
			result = new ResponseEntity<>(FileCopyUtils.copyToByteArray(file), header, HttpStatus.OK);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return result;
	}

	// download(업로드 파일이 이미지 아닌거)
	@RequestMapping(value = "download", method = RequestMethod.GET, produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
	public ResponseEntity<Resource> downloadFile(String fileName) {
		System.out.println(logger);
		System.out.println("=========다운로드 파일  : " + fileName);

		Resource resource = new FileSystemResource("D:\\uploadimg\\" + fileName);

		System.out.println("=========resource  : " + resource);

		String resourceName = resource.getFilename();
		HttpHeaders header = new HttpHeaders();
		try {
			header.add("Content-Disposition",
					"attachment;filename=" + new String(resourceName.getBytes("UTF-8"), "ISO-8859-1"));
			System.out.println("=========header  : " + header);

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		return new ResponseEntity<>(resource, header, HttpStatus.OK);
	}

	@RequestMapping(value = "deleteFile", method = RequestMethod.POST)
	public ResponseEntity<String> fileDelete(String fileName, String type) {
//		System.out.println(logger);
		System.out.println(fileName);
		System.out.println(type);
		File file;
		try {
			file = new File("D:\\uploadimg\\" + URLDecoder.decode(fileName, "UTF-8"));
			file.delete();
			if (type.equals("image")) {
				String originalFile = file.getAbsolutePath().replace("s_", "");
				file = new File(originalFile);
				file.delete();
			}
			file.delete();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		return new ResponseEntity<>("이미지 삭제 성공", HttpStatus.OK);
	}

}
