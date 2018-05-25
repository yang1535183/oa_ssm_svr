package com.yxf.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.yxf.common.pojo.PictureResult;

/**
 * @ClassName: IPictureService
 * @Description: 图片上传的接口
 * @author donhuexu
 * @date 2018年5月14日 下午12:29:45
 * 
 */
public interface IPictureService {

	PictureResult uploadPic(MultipartFile picFile) throws Exception;

}
