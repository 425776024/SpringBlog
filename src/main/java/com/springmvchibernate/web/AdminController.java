package com.springmvchibernate.web;

import com.springmvchibernate.model.*;
import com.springmvchibernate.service.SpringBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * Author: Xin
 * Date: 14-5-7
 * Time: 上午9:29
 */

@Controller
@SessionAttributes("user")
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private SpringBlogService springBlogService;
//处理url:/admin，非表单的GET方式
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public ModelAndView login(){
        return new ModelAndView("login");
    }
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public ModelAndView main(HttpServletRequest request){
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if(user == null){
            return new ModelAndView("login");
        }else{
            return new ModelAndView("admin-index");
        }
    }
    //处理url:/admin，表单的POST方式
    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody Map<String,Object> processLogin(@RequestParam String name, @RequestParam String password,
                                                         HttpServletRequest request){
        Map<String,Object> resultMap = new HashMap<String, Object>();
        HttpSession httpSession = request.getSession();


        User user = this.springBlogService.findUserByName(name);
        if(user != null){
            if(user.getPassword().equals(password.trim())){

                httpSession.setAttribute("user",user);
                resultMap.put("resultCode",BlogConstant.RETURN_CODE_SUCC);
                resultMap.put("msg","login success");
                resultMap.put("user",user);

            }else {
                resultMap.put("resultCode",BlogConstant.RETURN_CODE_ERR);
                resultMap.put("msg","Password error!");
            }

        }else {
            resultMap.put("resultCode",BlogConstant.RETURN_CODE_ERR);
            resultMap.put("msg","The user does not exist!");

        }
        return resultMap;

    }

    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public ModelAndView indexHandler(HttpServletRequest request,ModelAndView mav){

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        if(user == null){
            mav.setView(new RedirectView("/admin"));
        }else{
            mav.setViewName("admin-index");
        }
        return mav;
    }

    @RequestMapping(value = "/view/home",method = RequestMethod.GET)
    public ModelAndView homeHandler(){
        return new ModelAndView("admin-welcome");
    }
    @RequestMapping(value = "/logout")
    public String logout(SessionStatus status,HttpServletRequest request){
        status.setComplete();
//        request.getSession().setAttribute("user",null);
//        return "redirect:admin-index";
        return "redirect:/";
    }

    @RequestMapping(value = "/view/new",method = RequestMethod.GET)
    public ModelAndView newHandler(){
        return new ModelAndView("admin-newpost");
    }

    @RequestMapping(value = "/view/posts",method = RequestMethod.GET)
    public ModelAndView postsHandler(){

        return new ModelAndView("admin-posts");
    }

    @RequestMapping(value = "/view/categories",method = RequestMethod.GET)
    public ModelAndView categoryHandler(){

        return new ModelAndView("admin-categories");
    }

    @RequestMapping(value = "/view/comments",method = RequestMethod.GET)
    public ModelAndView commentsHandler(){

        return new ModelAndView("admin-comments");
    }

    @RequestMapping(value = "/view/post/{postId}",method = RequestMethod.GET)
    public ModelAndView postHandler(@PathVariable Long postId){

        Map<String,Object> model = new HashMap<String, Object>();

        Post post = this.springBlogService.findPostById(postId);
        Category category = this.springBlogService.findCategoryById(post.getCategoryId());
        User author = this.springBlogService.findUserById(post.getAuthorId());
        SimpleDateFormat dateformat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss E");
        String postDate = dateformat.format(post.getPostDate());


        model.put("post",post);
        model.put("category",category);
        model.put("author",author.getUserName());
        model.put("postDate",postDate);

        return new ModelAndView("admin-post",model);
    }




    @RequestMapping(value = "/posts",method = RequestMethod.GET)
    public @ResponseBody Map<String,Object> listPost(){

        Map<String, Object> model = new HashMap<String, Object>();

        model.put("posts",this.springBlogService.findAllPost());

        return model;
    }

    @RequestMapping(value = "/post",method = RequestMethod.POST)
    public @ResponseBody Map<String,Object> savePost(HttpServletRequest request){

        Map<String,Object> resultMap = new HashMap<String, Object>();

        User user = (User) request.getSession().getAttribute("user");
        Post post = new Post();
        post.setCommentStatus(BlogConstant.POST_COMMETNS_STATUS_OPEN);
        String categoryIdStr = request.getParameter("categoryId");
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        String postIdStr = request.getParameter("postId");
        String postStatusStr = request.getParameter("postStatus");
        String commentStatusStr = request.getParameter("commentStatus");

        if(postIdStr != null && !postIdStr.equals("")){
            Long postId = Long.parseLong(postIdStr);
            if(postId != null){
                post.setPostId(postId);

            }
        }

        Long categoryId = null;
        if(categoryIdStr != null && !categoryIdStr.equals("")){
            categoryId = Long.parseLong(categoryIdStr);

        }
        post.setAuthorId(user.getUserId());

        if(categoryId != null){
            post.setCategoryId(categoryId);
        }
        if(title != null){
            post.setPostTitle(title);

        }
        if(content != null){
            post.setPostContent(content);
        }
        if(postStatusStr != null && !postStatusStr.equals("")){
            post.setPostStatus(Integer.parseInt(postStatusStr));
        }
        if(commentStatusStr != null && !commentStatusStr.equals("")){
            post.setCommentStatus(Integer.parseInt(commentStatusStr));
        }
        post.setPostDate(new Date());
        post.setPostModifiedDate(new Date());

        Long id = this.springBlogService.savePost(post);

        resultMap.put("postId",id);
        resultMap.put("returnCode", BlogConstant.RETURN_CODE_SUCC);

        return resultMap;
    }



    @RequestMapping(value = "/post/{postId}",method = RequestMethod.GET)
    public @ResponseBody Map<String,Object>  findPost(@PathVariable Long postId){

        Map<String,Object> model = new HashMap<String, Object>();

        Post post = this.springBlogService.findPostById(postId);
        Category category = this.springBlogService.findCategoryById(post.getCategoryId());
        User author = this.springBlogService.findUserById(post.getAuthorId());
        SimpleDateFormat dateformat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss E");
        String postDate = dateformat.format(post.getPostDate());

        model.put("post",post);
        model.put("category",category);
        model.put("author",author.getUserName());
        model.put("postDate",postDate);

        return model;
    }

    @RequestMapping(value = "/post/{postId}",method = RequestMethod.DELETE)
    public @ResponseBody Map<String,Object>  deletePost(@PathVariable Long postId){

        Map<String, Object> resultMap = new HashMap<String, Object>();

        this.springBlogService.deletePost(postId);
        resultMap.put("returnCode", BlogConstant.RETURN_CODE_SUCC);

        return resultMap;

    }



    @RequestMapping(value = "/posts",method = RequestMethod.DELETE)
    public @ResponseBody void batchDeletePost(@RequestBody MultiValueMap<String, String> body){


        Map<String, String> params = body.toSingleValueMap();
        String idsStr = params.get("ids");
        String[] idsArr = idsStr.split(",");

        List<Long> ids = new ArrayList<Long>();
        for(int i = 0; i < idsArr.length; i++){
            ids.add(Long.parseLong(idsArr[i]));
        }

    }


    @RequestMapping(value = "/post/{postId}",method = RequestMethod.PUT)
    public @ResponseBody Map<String,Object>  updatePost(@PathVariable Long postId, @RequestBody MultiValueMap<String, String> body, HttpServletResponse response){

        Map<String, Object> resultMap = new HashMap<String, Object>();

        Post post = this.springBlogService.findPostById(postId);
        Map<String, String> params = body.toSingleValueMap();

        String commentStatusStr = params.get("commentStatus");

        if(commentStatusStr != null && !commentStatusStr.equals("")){
            post.setCommentStatus(Integer.parseInt(commentStatusStr));
        }

        this.springBlogService.savePost(post);

        resultMap.put("returnCode", BlogConstant.RETURN_CODE_SUCC);

        return resultMap;
    }
//处理获取所有分类的json数据
    @RequestMapping(value = "/categories",method = RequestMethod.GET)
    public  @ResponseBody Map<String , Object> listCategory(){

        Map<String, Object> model = new HashMap<String, Object>();
        model.put("categories",this.springBlogService.findAllCategory());

        return model;
    }
//处理表单提交的创建分类请求
    @RequestMapping(value = "/category",method = RequestMethod.POST)
    public @ResponseBody Map<String , Object> saveCategory(@RequestParam String categoryName){
        Map<String, Object> resultMap = new HashMap<String, Object>();

        Category category = new Category();
        category.setCatName(categoryName);

        this.springBlogService.saveCategory(category);

        return resultMap;
    }

    @RequestMapping(value = "/category/{categoryId}",method = RequestMethod.GET)
    public @ResponseBody Map<String, Object> findCategory(@PathVariable Long categoryId){

        Map<String, Object> resultMap = new HashMap<String, Object>();
        Category category = this.springBlogService.findCategoryById(categoryId);
        resultMap.put("category",category);

        return resultMap;

    }

    @RequestMapping(value = "/category/{categoryId}",method = RequestMethod.PUT)
    public @ResponseBody Map<String , Object> saveCategory(@PathVariable Long categoryId, @RequestBody MultiValueMap<String, String> body){

        Map<String, Object> resultMap = new HashMap<String, Object>();

        Category category = new Category();
        category.setCatId(categoryId);

        Map<String, String> params = body.toSingleValueMap();
        String categoryName = params.get("categoryName");
        category.setCatName(categoryName);

        this.springBlogService.saveCategory(category);

        return resultMap;
    }


    @RequestMapping(value = "/category/{categoryId}",method = RequestMethod.DELETE)
    public @ResponseBody Map<String , Object> deleteCategory(@PathVariable Long categoryId){

        Map<String, Object> resultMap = new HashMap<String, Object>();

        this.springBlogService.deleteCategory(categoryId);

        return resultMap;
    }


    @RequestMapping(value = "/comments",method = RequestMethod.GET)
    public @ResponseBody Map<String,Object>  listComment(){

        Map<String, Object> model = new HashMap<String, Object>();
        model.put("comments",this.springBlogService.findAllComment());

        return model;
    }

    @RequestMapping(value = "/comment/{commentId}", method = RequestMethod.GET)
    public @ResponseBody Map<String,Object> findComment(@PathVariable Long commentId){

        Map<String, Object> resultMap = new HashMap<String, Object>();
        Comment comment = this.springBlogService.findCommentById(commentId);
        resultMap.put("comment",comment);
        return resultMap;

    }

    @RequestMapping(value = "/comment/{commentId}", method = RequestMethod.PUT)
    public @ResponseBody Map<String,Object> updateComment(@PathVariable Long commentId, @RequestBody MultiValueMap<String,String> body){

        Map<String, Object> resultMap = new HashMap<String, Object>();

        Map<String, String> params = body.toSingleValueMap();

        String commentContent = params.get("commentContent");

        Comment comment = this.springBlogService.findCommentById(commentId);
        comment.setCommentContent(commentContent);

        this.springBlogService.saveComment(comment);

        return resultMap;

    }

    @RequestMapping(value = "/comment/{commentId}", method = RequestMethod.DELETE)
    public @ResponseBody Map<String,Object> deleteComment(@PathVariable Long commentId){
        Map<String, Object> resultMap = new HashMap<String, Object>();

        this.springBlogService.deleteComment(commentId);

        return resultMap;

    }




}
