<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
  <head>
  </head>
  <body>
    <div class="row">
      <div class="col-lg-10">
        <div class="input-group">

            <div class="input-group-btn">
                <button type="button" class="btn btn-default newpost-category-btn-name">Category</button>
                <button type="button" class="btn btn-default dropdown-toggle newpost-category-btn" data-toggle="dropdown">
                    <span class="caret"></span>
                    <span class="sr-only">Toggle Dropdown</span>
                </button>
                <ul class="dropdown-menu newpost-category-select-menu" role="menu">

                </ul>
            </div>

            <input type="text" class="form-control admin-new-post-title">
        </div><!-- /input-group -->
      </div><!-- /.col-lg-6 -->
    </div><!-- /.row -->

    <div class="row">
        <div class="col-lg-10">
            <div class="new-post-content-wrap">
                <textarea id ="new-post-content" >
                </textarea>
            </div>
            <div class="alert admin-new-post-alert">
                <strong class="new-post-alert-msg">Well done!</strong>
                <span class="new-post-alert-msg-notice">You successfully save this post.</span>
            </div>
            <div class="btn-group new-post-btn-group">
                <button type="button" class="btn btn-default new-post-cancel-btn">Cancel</button>
                <button type="button" class="btn btn-default new-post-save-btn">Save</button>
                <button type="button" class="btn btn-default new-post-publish-btn">Publish</button>
            </div>
        </div><!-- /.col-lg-6 -->
    </div><!-- /.row -->

   <script src="/resources/js/admin-newpost.js"/>
  </body>
</html>
