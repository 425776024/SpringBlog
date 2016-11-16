package com.springmvchibernate.web;


import com.springmvchibernate.model.Category;
import com.springmvchibernate.model.Comment;
import com.springmvchibernate.model.Post;
import com.springmvchibernate.model.User;
import com.springmvchibernate.service.SpringBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Author: Xin
 * Date: 14-5-5
 * Time: 上午10:10
 */

@Controller
public class SpringBlogController {

    @Autowired
    private SpringBlogService springBlogService;

    @RequestMapping("/")
    public String index(){
        return "blog-index";
    }


    @RequestMapping(value = "/posts", method = RequestMethod.GET)
    public @ResponseBody Map<String,Object> findAllPost(){

        Map<String,Object> resultMap = new HashMap<String, Object>();
        resultMap.put("posts",this.springBlogService.findAllPost());
        return resultMap;

    }


    @RequestMapping(value = "/view/post/{postId}", method = RequestMethod.GET)
    public ModelAndView findPost(@PathVariable Long postId){

        Map<String,Object> model = new HashMap<String, Object>();

        Post post = this.springBlogService.findPostById(postId);
        User author = this.springBlogService.findUserById(post.getAuthorId());
        SimpleDateFormat dateformat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss E");
        String postDate = dateformat.format(post.getPostDate());
        Category category = this.springBlogService.findCategoryById(post.getCategoryId());

        model.put("post",post);
        model.put("category",category);
        model.put("author",author.getUserName());
        model.put("postDate",postDate);

        return new ModelAndView("blog-post", model);
    }

    @RequestMapping(value = "/categorie/{categorieId}",method = RequestMethod.GET)
    public ModelAndView categoryView(@PathVariable Long categorieId){
        Category category=this.springBlogService.findCategoryById(categorieId);
        Collection<Post> posts = this.springBlogService.findAllPostByCategoryId(categorieId);
        Map<String,Object> model = new HashMap<String, Object>();
        model.put("category",category);
        model.put("posts",posts);
        return new ModelAndView("blog-categorie",model);
    }

    @RequestMapping(value = "/categories", method = RequestMethod.GET)
    public @ResponseBody Map<String,Object> findAllCategory(){

        Map<String,Object> resultMap = new HashMap<String, Object>();
        resultMap.put("categories",this.springBlogService.findAllCategory());
        return resultMap;

    }

    @RequestMapping(value = "/post/{postId}/comment", method = RequestMethod.POST)
    public @ResponseBody Map<String,Object> saveComment(@PathVariable Long postId, @RequestParam String name, @RequestParam String commentContent){

        Map<String,Object> resultMap = new HashMap<String, Object>();

        Comment comment = new Comment();
        comment.setCommentContent(commentContent);
        comment.setPostId(postId);
        comment.setCommentAuthor(name);
        comment.setCommentDate(new Date());

        this.springBlogService.saveComment(comment);

        return resultMap;

    }

    @RequestMapping(value = "/post/{postId}/comments", method = RequestMethod.GET)
    public @ResponseBody Map<String,Object> findCommentByPostId(@PathVariable Long postId){

        Map<String,Object> resultMap = new HashMap<String, Object>();

        resultMap.put("comments",this.springBlogService.findCommentByPostId(postId));

        return resultMap;

    }

}
