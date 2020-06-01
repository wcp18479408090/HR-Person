package com.controller;

import com.entity.Dept;
import com.entity.Document;
import com.entity.UserS;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.service.DocumentService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * (Document)表控制层
 *
 * @author makejava
 * @since 2020-05-15 07:41:37
 */
@RestController
@RequestMapping("document")
public class DocumentController {
    /**
     * 服务对象
     */
    @Resource
    private DocumentService documentService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @RequestMapping("selectOne")
    public Document selectOne(Integer id) {
        return this.documentService.queryById(id);
    }

    @RequestMapping("selectAll")

    public PageInfo selectAll(@RequestParam(value = "pageNum",required = false,defaultValue = "1")Integer pageNum,
                              @RequestParam(value = "pageSize",required = false,defaultValue = "5")Integer pageSize){

        System.out.println("进入Document");
        PageHelper.startPage(pageNum, pageSize);
        List<Document> deptList = this.documentService.queryAll(new Document());
        PageInfo<Document> pageInfo = new PageInfo<Document>(deptList);
        System.out.println(pageInfo);
        return  pageInfo;
    }
    @RequiresPermissions("document:Upload")
    @RequestMapping("Upload")
    public void upload( MultipartFile file,Document document, HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");

      if(file==null||file.getSize()<0){
          return;
      }
      String documentDir="document";
        //上传路径保存设置
        String dir = request.getServletContext().getRealPath("/upload");
        System.out.println("request.getServletContext():"+request.getServletContext());
         //随机获取文件（图片）前缀，以防文件名相同
       String fileName = UUID.randomUUID().toString();
       //获取后缀
       String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().indexOf("."));
       //得到文件绝对路径
       String  savaPash = dir+"/"+fileName+suffix;

        //上传文件地址
        System.out.println("文件绝对路径:"+savaPash);

        file.transferTo(new File(savaPash));
        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String format = sdf.format(now);
        document.setDDate(format);
        document.setSize(file.getSize());
        document.setSuffix(suffix);
        UserS user = (UserS)SecurityUtils.getSubject().getSession().getAttribute("user");
        document.setUId(user.getUId());
        document.setFilepash(documentDir+"/"+fileName+suffix);
        if(this.documentService.insert(document)>0){
            response.getWriter().print("<script>alert('上传成功');window.history.go(-1);</script>");
            return;
        }response.getWriter().print("<script>alert('上传失败');window.history.go(-1);</script>");
        return;
    }

//    @RequiresPermissions("document:download")
//    @RequestMapping("download/{id}")
//    public void download(HttpServletRequest req,HttpServletResponse resp,@PathVariable("id") Integer id){
//        Document document = documentService.queryById(id);
//        if(document==null){
//            return;
//        }
//        InputStream in =null;
//        try{
//            resp.setHeader("content-disposition","attachment;filename="+ URLEncoder.encode(document.getDFilename()+document.getSuffix(),"UTF-8"));
//
//            String realPath = req.getServletContext().getRealPath("");
//            String dir = req.getServletContext().getRealPath("");
//            in = new FileInputStream(dir+"/"+document.getFilepash());
//            int len=0;
//            byte[] buffer = new byte[1024];
//            OutputStream out = resp.getOutputStream();
//            while((len=in.read(buffer))>0){
//                out.write(buffer,0,len);
//            }
//            in.close();
//            out.close();
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//
//    }

        @ResponseBody
    @RequestMapping("download/{id}")
    @RequiresPermissions("document:download")
    public String download(HttpServletRequest request,HttpServletResponse response,@PathVariable("id") Integer id)throws Exception{
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");
        Document document = documentService.queryById(id);
        String realPath = request.getServletContext().getRealPath("");
        response.setHeader("content-disposition", "attachment;filename=" + URLEncoder.encode(document.getDFilename()+document.getSuffix(), "UTF-8"));
        InputStream in = null;
        OutputStream out = null;
        try {
            in = new FileInputStream(realPath+"/"+document.getFilepash());
            int len = 0;
            byte[] buffer = new byte[1024];
            out = response.getOutputStream();
            while((len = in.read(buffer)) > 0)
            {
                out.write(buffer,0,len);
            }
            in.close();
            out.close();
    }catch (Exception e){
            return "false";
        }

        return "true";
    }
    @RequestMapping("selectById")
    public Document queryById(Integer dId){
        return this.documentService.queryById(dId);
    }
    @RequestMapping("update")
    public int update(Document document){
        return this.documentService.update(document);
    }
    @RequestMapping("delete")
    public boolean  deleteById(@RequestParam("ids") List<Integer> ids ){
        Boolean flag = false;
        if(ids.size()>0){
            for (int i=0;i<ids.size();i++){
                flag = this.documentService.deleteById(ids.get(i));
            }
        }
        return  flag;
    }
}