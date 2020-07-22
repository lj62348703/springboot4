package com.handler;

import com.entity.Article;
import com.github.pagehelper.PageInfo;
import com.service.IArticleService;
import com.util.LoadUtil;
import com.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.HashMap;

@Controller
public class ArticleHandler {
    @Value("${image.prefix}")
    private String imagePrefix;

    @Autowired
    private IArticleService articleServiceImpl;

    @RequestMapping("/admin/findAllArticle.action")
    @ResponseBody
    public HashMap<String,Object> findAllArticle(Integer page,Integer limit){
        PageInfo<Article> pageInfo = articleServiceImpl.findAll(page,limit);
        return ResultUtil.getResult("0","",pageInfo.getTotal(),pageInfo.getList());
    }

    @RequestMapping("/admin/deleteAritcle.action")
    @ResponseBody
    public HashMap<String,Object> deleteAritcle(Integer article_id){
        if(article_id == null) return ResultUtil.getResult("-2","参数异常");
        int num = articleServiceImpl.delete(article_id);
        return num == 0 ? ResultUtil.getResult("-1","删除失败") : ResultUtil.getResult("0","删除成功");
    }

    @RequestMapping("/admin/findAricleById.action")
    @ResponseBody
    public HashMap<String,Object> findAricleById(Integer article_id){
        if(article_id == null) return ResultUtil.getResult("-2","参数异常");
        Article article = articleServiceImpl.findById(article_id);
        return article == null ? ResultUtil.getResult("-1","查询失败") : ResultUtil.getResult("0","查询成功",article);
    }

    @RequestMapping("/admin/uploadImage.action")
    @ResponseBody
    public HashMap<String,Object> uploadImage(MultipartFile file){
        String showPath = LoadUtil.uploadImage(file);
        HashMap<String,String> date = new HashMap<String,String>();
        date.put("src",imagePrefix+showPath);
        return showPath == null ? ResultUtil.getResult("-1","上传失败") : ResultUtil.getResult("0","上传成功",date);
    }

    @RequestMapping("/admin/updateAritcle.action")
    @ResponseBody
    public HashMap<String,Object> updateAritcle(@Validated  Article article , BindingResult br){
        if(br.hasErrors()) return ResultUtil.getResult("-2","参数异常");
        int num = articleServiceImpl.update(article);
        return num == 0 ? ResultUtil.getResult("-1","更新失败") : ResultUtil.getResult("0","更新成功");
    }

    @RequestMapping("/admin/addAritcle.action")
    @ResponseBody
    public HashMap<String,Object> addAritcle(@Validated  Article article , BindingResult br){
        if(br.hasErrors()) return ResultUtil.getResult("-2","参数异常");
        article.setArticle_publish_time(new Date());
        int num = articleServiceImpl.addArticle(article);
        return num == 0 ? ResultUtil.getResult("-1","添加失败") : ResultUtil.getResult("0","添加成功");
    }

    @RequestMapping("/article/{article_type_id}-{pageNum}-{pageSize}.html")
    public String articleList(Model model, @PathVariable Integer article_type_id,@PathVariable Integer
            pageNum,@PathVariable Integer pageSize){
        PageInfo<Article> pageInfo = articleServiceImpl.findAllByArticleType(article_type_id, pageNum, pageSize);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("imagePrefix",imagePrefix);
        return "articleList";
    }
}
