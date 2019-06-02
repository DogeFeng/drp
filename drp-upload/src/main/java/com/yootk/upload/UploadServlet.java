package com.yootk.upload;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@WebServlet("/upload.action")
public class UploadServlet extends HttpServlet {
    public static final long MAX_SIZE = 3145728L; // 表单允许的最大上传数量为3M
    public static final long FILE_MAX_SIZE = 1048576L ; // 表示单个文件允许上传的最大长度，本次为1M
    public static final String TEMP_DIR = "/tmp" ; // 设置临时的目录
    public static final String UPLOAD_DIR = "http://111.230.131.204/drp/upload.action"; // 设置临时的目录
    public static final String DEFAULT_ENCODING = "UTF-8" ; // 设置参数的接收编码
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getContentType() != null &&
                request.getContentType().startsWith("multipart/form-data")) {
            DiskFileItemFactory factory = new DiskFileItemFactory() ;
            factory.setRepository(new File(TEMP_DIR)); // 设置所有上传的临时存储目录
            ServletFileUpload fileUpload = new ServletFileUpload(factory) ; // 定义上传处理类
            fileUpload.setSizeMax(MAX_SIZE);    // 设置允许上传的总长度限制
            fileUpload.setFileSizeMax(FILE_MAX_SIZE); // 设置单个上传文件的大小限制
            if (fileUpload.isMultipartContent(request)) {   // 判断当前的表单是否属于封装状态
                try {
                    Map<String, List<FileItem>> map = fileUpload.parseParameterMap(request) ; // 解析所有的上传参数
                    if (map.containsKey("file") || map.containsKey("contentType")) {
                        FileItem fileItem = map.get("file").get(0) ;
                        String contentType = map.get("contentType").get(0).getString() ;
                        if (!fileItem.isFormField()) {  // 不是文本
                            String fileName = UUID.randomUUID() + "." + contentType.substring(contentType.lastIndexOf("/") + 1) ;
                            String filePath = request.getServletContext().getRealPath("/com/yootk/upload/") + fileName ;  // 文件保存路径
                            fileItem.write(new File(filePath));
                            response.getWriter().print(fileName);
                        }
                    }
                } catch (Exception e) {
                    response.getWriter().print("nophoto.jpg");
                }
            }
        } else {
            response.getWriter().print("nophoto.jpg");
        }
    }

}
