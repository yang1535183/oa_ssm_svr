package com.yxf.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.yxf.common.pojo.PictureResult;
import com.yxf.common.utils.FastDFSClient;
import com.yxf.service.IPictureService;

/**
 * @ClassName: PictureServiceImpl
 * @Description: 图片上传的实现类
 * @author donhuexu
 * @date 2018年5月14日 下午12:29:15
 * 
 */

@Service
public class PictureServiceImpl implements IPictureService {

	@Value("${IMAGE_BASE_URL}")
	private String IMAGE_BASE_URL;

	@Override
	public PictureResult uploadPic(MultipartFile picFile) throws Exception {
		PictureResult result = new PictureResult();
		if (picFile.isEmpty()) {
			result.setError(1);
			result.setMessage("图片为空");
			return result;
		}
		try {
			// 获取图片扩展名、
			String originalFilename = picFile.getOriginalFilename();
			// 取出扩展名，不要"."
			String extName = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
			// 获取客户端的连接属性文件
			FastDFSClient client = new FastDFSClient("classpath:properties/fdfs_client.conf");
			String url = client.uploadFile(picFile.getBytes(), extName);
			// 拼接图片服务器的ip地址
			url = IMAGE_BASE_URL + url;
			System.out.println(url);
			// 把url响应给客户端
			result.setError(0);
			result.setMessage("图片上传成功");
			result.setUrl(url);
		} catch (Exception e) {
			e.printStackTrace();
			result.setError(1);
			result.setMessage("图片上传失败");
		}
		return result;
	}

}
