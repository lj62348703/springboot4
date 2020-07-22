package com.handler;

import com.entity.ArticleType;
import com.github.pagehelper.PageInfo;
import com.service.IArticleTypeService;
import com.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

@Controller
public class ArticleTypeHandler {
    @Autowired
    private IArticleTypeService articleTypeServiceImpl;

    @RequestMapping("/admin/findAllArticleTypePage.action")
    @ResponseBody
    public HashMap<String,Object> findAllArticleTypePage(Integer page,Integer limit){
        PageInfo<ArticleType> info = articleTypeServiceImpl.findAllPage(page,limit);
        return ResultUtil.getResult("0","",info.getTotal(),info.getList());
    }

    @RequestMapping("/admin/deleteArticleType.action")
    @ResponseBody
    public HashMap<String,Object> deleteArticleType(Integer article_type_id){
        if(article_type_id == null) ResultUtil.getResult("-1","数据校验错误");
        int num = articleTypeServiceImpl.delete(article_type_id);
        return num == 0 ? ResultUtil.getResult("-1","数据删除失败") : ResultUtil.getResult("0","删除成功");
    }

    @RequestMapping("/admin/findArticleTypeById.action")
    @ResponseBody
    public HashMap<String,Object> findArticleTypeById(Integer article_type_id){
        ArticleType articleType = articleTypeServiceImpl.findById(article_type_id);
        return articleType == null ? ResultUtil.getResult("-1","查询失败") : ResultUtil.getResult("0","查询成功",articleType);
    }

    @RequestMapping("/admin/findAllArticleType.action")
    @ResponseBody
    public HashMap<String,Object> findAllArticleType(){
        List<ArticleType> articleTypes = articleTypeServiceImpl.findAll();
        return ResultUtil.getResult("0","查询成功",articleTypes);
    }

    @RequestMapping("/admin/updateArticleType.action")
    @ResponseBody
    public HashMap<String,Object> updateArticleType(@Validated ArticleType articleType, BindingResult br){
        if(br.hasErrors()) return ResultUtil.getResult("-2","数据校验异常");
        int num = articleTypeServiceImpl.update(articleType);
        if(num == 0) return ResultUtil.getResult("-1","修改失败");
        return ResultUtil.getResult("0","修改成功");
    }

    @RequestMapping("/admin/addArticleType.action")
    @ResponseBody
    public HashMap<String,Object> addArticleType(@Validated ArticleType articleType, BindingResult br){
        if(br.hasErrors()) return ResultUtil.getResult("-2","数据校验异常");
        int num = articleTypeServiceImpl.add(articleType);
        if(num == 0) return ResultUtil.getResult("-1","添加失败");
        return ResultUtil.getResult("0","添加成功");
    }
}
