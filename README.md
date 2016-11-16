#SpringBlog

This is a tiny blog system based on SpringMVC and Hibernate,just for learning spring.

##Use:

1. Spring IoC container
2. Spring mvc for web
3. Hibernate for mysql database access
4. Ehcache for second level cache
5. Tiles3
6. Boostrap for front page
7. bootstrap3-wysihtml5

##Finish:

1. System basic architecture
2. Database design
3. Integrate tiles
4. Admin login and publish post
5. Manage posts
6. Manage comments
7. Blog show
8. Add [bootstrap3-wysihtml5](https://github.com/schnawel007/bootstrap3-wysihtml5) which supports boostrap3
9. Add [BootstrapValidator](https://github.com/nghuuphuoc/bootstrapvalidator)

##Problem

1. Session out of time,how to save information of login user?  
   Don't use @SessionAttributes annotation,but use the traditional session.setAttribute method to save login information.Spring docs about [SessionAttributes](http://docs.spring.io/spring/docs/3.2.8.RELEASE/javadoc-api/org/springframework/web/bind/annotation/SessionAttributes.html)
2. How to design restful api for delete many objects?
3. org.hibernate.HibernateException: No Session found for current thread
4. Error too much recursion while using BootstrapValidator  
   Must wrap the element with class form-group,such as  

   ```html  
   <div class="form-group">  
     <input name="name"  type="text" class="form-control form-signin-name">  
   </div>  
   ```  
   
5. find soon...

