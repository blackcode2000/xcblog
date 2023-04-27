package com.xc.service;

import com.xc.domain.ResponseResult;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;


public interface FileService {

    ResponseResult uploadImg(MultipartFile img);
}
