package top.musuixin.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.baidu.ueditor.ActionEnter;
import org.apache.commons.io.FilenameUtils;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;


import com.sun.jersey.api.client.Client;


import top.musuixin.Unitl.ResponseUtils;
import top.musuixin.Unitl.Upload;

/**
 * baidu-ueditor
 * @author libo
 */
@Controller
@RequestMapping("/ueditor")
@PropertySource("classpath:config.properties")
public class UEditorController {
    @Value(value="${ueditor}")    //后台图片保存地址
    private String ueditor;
    @Value(value="${uploadHost}")
    private String uploadHost;    //项目host路径

    /**
     * ueditor文件上传（上传到外部服务器）
     * @param request
     * @param response
     * @param action
     */
    @ResponseBody
    @RequestMapping(value="/ueditorUpload.do", method={RequestMethod.GET, RequestMethod.POST})
    public void editorUpload(HttpServletRequest request, HttpServletResponse response, String action) {
        response.setContentType("application/json");
        String rootPath = request.getSession().getServletContext().getRealPath("/");
        try {
            if("config".equals(action)){    //如果是初始化
                String exec = new ActionEnter(request, rootPath).exec();
                PrintWriter writer = response.getWriter();
                writer.write(exec);
                writer.flush();
                writer.close();
            }else if("uploadimage".equals(action) || "uploadvideo".equals(action) || "uploadfile".equals(action)){    //如果是上传图片、视频、和其他文件
                try {
                    MultipartHttpServletRequest multiRequest=(MultipartHttpServletRequest)request;
                    Iterator iter=multiRequest.getFileNames();
                    // 实例化一个jersey
                    Client client = new Client();
                    while(iter.hasNext()){
                        JSONObject jo = new JSONObject();
                        MultipartFile file=multiRequest.getFile(iter.next().toString());
                        long size = file.getSize();    //文件大小
                        String originalFilename = file.getOriginalFilename();  //原来的文件名
                        String uploadInfo = Upload.upload(client, file, request, response, uploadHost, ueditor);
                        if(!"".equals(uploadInfo)){    //如果上传成功
                            String[] infoList = uploadInfo.split(";");
                            jo.put("state", "SUCCESS");
                            jo.put("original", originalFilename);//原来的文件名
                            jo.put("size", size);//文件大小
                            jo.put("title", infoList[1]);//随意，代表的是鼠标经过图片时显示的文字
                            jo.put("type", FilenameUtils.getExtension(file.getOriginalFilename()));//文件后缀名
                            jo.put("url", infoList[2]);//这里的url字段表示的是上传后的图片在图片服务器的完整地址（http://ip:端口/***/***/***.jpg）
                        }else{    //如果上传失败
                        }
                        ResponseUtils.renderJson(response, jo.toString());
                    }
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
        }
    }
}