package com.yxf.controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.yxf.common.pojo.PictureResult;
import com.yxf.common.utils.JsonUtils;
import com.yxf.service.IPictureService;

/**
 * @ClassName: PictureController
 * @Description: 图片上传的Controller
 * @author donhuexu
 * @date 2018年5月14日 下午12:50:43
 * 
 */
@Controller
@RequestMapping("/pic")
public class PictureController {

	@Resource
	private IPictureService pictureService;

	/** 
	* @Title: uploadPic 
	* @Description: 图片上传 
	* @param @param uploadFile
	* @param @return
	* @param @throws Exception     
	* @return PictureResult 
	* @throws 
	*/
	@RequestMapping("/uploadPic")
	@ResponseBody
	public PictureResult uploadPic(MultipartFile uploadFile) throws Exception {
		PictureResult result = pictureService.uploadPic(uploadFile);
		//为解决浏览器兼容问题，这里使用Json工具类，将包装对象转换成Json数据返回
		//String picJson = JsonUtils.objectToJson(result);
		return result;
	}
}
