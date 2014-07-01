package servlet.common;


import common.SystemContext;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URLEncoder;

public class DownloadAction {
    /**
     *  如果文件不存在，提示。存在就输出到 HttpServletResponse返回。
     * @param myFile
     * @param response
     * @param request
     * @throws IOException
     */
    private static void outFile(MyFile myFile,HttpServletResponse response,HttpServletRequest request) throws IOException {
        ServletContext context=request.getSession().getServletContext();
        InputStream in = null;
        //如果 myFile为空,没有数据源或数据源为空则提示 文件不存在
        if(myFile==null || (myFile.fileisNull()&&myFile.getUrl()==null)||(in =getInputStream(context,myFile))==null){
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.write("<script>") ;
            out.write("alert('文件不存在');") ;
            out.write("history.go(-1);") ;
            out.write("</script>") ;
        }else{
            String fileName = myFile.getFileName() ;
            fileName = URLEncoder.encode(fileName, "UTF-8");//在火狐下文件名有问题
	        /*
	         * see http://support.microsoft.com/default.aspx?kbid=816868
	         */
            if (fileName.length() > 150) {
                //String guessCharset = request.getLocale().get /*根据request的locale 得出可能的编码，中文操作系统通常是gb2312*/
                fileName = new String(myFile.getFileName().getBytes("gb2312"), "ISO8859-1");
            }
            response.reset();
            response.setContentType("application/x-msdownload");
            response.setHeader("Content-disposition","attachment; filename="+fileName);
            //以上输出文件元信息
            byte[] b = new byte[2048];
            int fileLength=0;
            int len = 0;
            while((len=in.read(b)) >0){
                response.getOutputStream().write(b,0,len);      //向浏览器输出
                fileLength+=len;
            }
            response.setContentLength(fileLength);      //设置输入文件长度
            in.close();         //关闭文件输入流
            response.flushBuffer();
        }
    }

    /**
     * 得到服务器文件的输入流
     * @param servletContext
     * @param myFile
     * @return
     */
    private static InputStream getInputStream(ServletContext servletContext,MyFile myFile) {
        InputStream input =null;
        if(myFile.getUrl()==null){
            input= new ByteArrayInputStream(myFile.getFile());
        }else{
            //去掉 绝对路径根目录  如: 路径为/liangfa/resources/new/jquery.js
            //修改后为:/resources/new/jquery.js
            String contextPath = servletContext.getContextPath();
            String realUrl = myFile.getUrl();
            if(realUrl.startsWith(contextPath)){
                realUrl = realUrl.substring(contextPath.length());
            }
            myFile.setUrl(realUrl);
            File file = new File(getRealPath(servletContext)+myFile.getUrl());
            try {
                input= new FileInputStream(file);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return null;
            }

        }
        return input;

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

    public static void download(HttpServletRequest request,HttpServletResponse response){
        String filePath = request.getParameter("conPath");
        String fileExt = filePath.substring(filePath.lastIndexOf(".") + 1).toLowerCase();
        String fileName = "附件"+fileExt;
        MyFile myFile = new MyFile();
        myFile.setUrl(filePath);
        myFile.setFileName(fileName);
        try {
            outFile(myFile, response, request);
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
}
 class MyFile {
    private String fileName;


    private byte[] file;
    private String url;
    public String getFileName() {
        return fileName;
    }
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    public byte[] getFile() {
        return file;
    }
    public void setFile(byte[] file) {
        this.file = file;
    }

    public boolean fileisNull(){
        return this.fileName==null ||this.file==null || this.file.length==0;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }


}
