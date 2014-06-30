package servlet.common;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 用户上传文件
 */
public class UploadAction {
    /**
     * 保存上传的文件，并解析普通字段值，把普通的字段值和上传路径保存包map中并返回。
     * @param request
     * @param response
     * @return
     */
    public static Map<String,String> getPath(HttpServletRequest request, HttpServletResponse response) {
        Map<String,String> pathMap = new HashMap<String,String>();
        // 1. 创建工厂类
        DiskFileItemFactory factory = new DiskFileItemFactory();
        // 2. 创建FileUpload对象
        ServletFileUpload upload = new ServletFileUpload(factory);
        // 3. 判断是否是上传表单
        boolean b = upload.isMultipartContent(request);
        if (!b) {
            // 不是文件上传
            request.setAttribute("message", "对不起，不是文件上传表单！");
            try {
                request.getRequestDispatcher("/message.jsp").forward(request, response);
            } catch (ServletException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            } catch (IOException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
            return  null;
        }
        // 是文件上传表单
        // 4. 解析request，获得FileItem项
        List<FileItem> fileitems = null;
        try {
            fileitems = upload.parseRequest(request);
        } catch (FileUploadException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        // 5. 遍历集合
        for (FileItem item : fileitems) {
            String name = item.getFieldName();
            // 判断是不是普通字段
            if(item.isFormField()){
                try {
                    pathMap.put(item.getFieldName(),item.getString("utf-8"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                }
            }else{
                String filename = item.getName();
                String fileName = filename.substring(filename.lastIndexOf("\\") + 1);
                // 创建文件
                //检查扩展名
                String fileExt = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();
                //修改文件名
                SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
                fileName = df.format(new Date()) + "_" + new Random().nextInt(1000) +
                        "." + fileExt;
                ServletContext context = request.getSession().getServletContext();
                //TODO...path
                String savePath = getRealPath(context)+"/upload/";
                File dirFile = new File(savePath);
                if (!dirFile.exists()) {
                    dirFile.mkdirs();
                }
                String saveUrl ="/upload/";
                File file = new File(savePath, fileName);
                pathMap.put(name,saveUrl+ fileName);
                try {
                    file.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                // 获得流，读取数据写入文件
                InputStream in = null;
                try {
                    in = item.getInputStream();
                    FileOutputStream fos = new FileOutputStream(file);
                    int len;
                    byte[] buffer = new byte[1024];
                    while ((len = in.read(buffer)) > 0)
                        fos.write(buffer, 0, len);
                    fos.close();
                    in.close();
                    item.delete();  // 删除临时文件
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return  pathMap;
    }
    public static String getRealPath(ServletContext servletContext){
        String path;
        try {
            if((path=servletContext.getRealPath("/"))==null){
                path=servletContext.getResource("/").getPath().substring(1);  //去掉第一个字符-"/"
            }
            return path;
        } catch (MalformedURLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return "";
    }
}
