package com.xc.service;

import com.xc.domain.ResponseResult;
import org.springframework.web.multipart.MultipartFile;

public interface UploadService {
     ResponseResult uploadImg(MultipartFile img);
}
