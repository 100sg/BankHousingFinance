package skbaek.homework.demo.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileUploadService {
    void upload(MultipartFile file) throws Exception;

}
