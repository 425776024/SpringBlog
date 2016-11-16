<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
  <head>
   <title>categories</title>
  </head>

  <body>

    <div class="row">
        <div class="col-lg-10">
            <h2>所有分类</h2>

            <table class="table table-hover admin-categories-table">
                <%--用json遍历出所有数据库里面的分类--%>
                <tbody>

                </tbody>
            </table>
            <div class="alert admin-categories-alert">
                <strong class="admin-categories-alert-msg">Well done!</strong>
                <span class="admin-categories-alert-msg-notice"></span>
            </div>

            <div class="btn-group categories-btn-group">
                 <button type="button" class="btn btn-default admin-categories-create">Create</button>
                 <button type="button" class="btn btn-default admin-categories-edit" disabled="disabled">Edit</button>
                 <button type="button" class="btn btn-default admin-categories-delete" disabled="disabled">Delete</button>
            </div>

            <!-- Modal -->
            <div class="modal fade" id="createCategoryModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
              <div class="modal-dialog">
                <div class="modal-content">
                  <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title" id="myModalLabel">Create new category</h4>
                  </div>
                  <div class="modal-body">
                        <h5>Category Name</h5>
                        <input type="text" class="form-control category-name" placeholder="Category Name">

                  </div>
                  <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    <button type="button" class="btn btn-primary save-category-btn">Save</button>
                  </div>
                </div><!-- /.modal-content -->
              </div><!-- /.modal-dialog -->
            </div><!-- /.modal -->

            <div class="modal fade" id="editCategoryModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            <h4 class="modal-title" id="editModalLabel">Edit category</h4>
                        </div>
                        <div class="modal-body">
                            <h5>Category Name</h5>
                            <input type="text" class="form-control category-name">

                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                            <button type="button" class="btn btn-primary edit-category-btn">Save changes</button>
                        </div>
                    </div><!-- /.modal-content -->
                </div><!-- /.modal-dialog -->
            </div><!-- /.modal -->


        </div><!-- /.col-lg-6 -->
    </div><!-- /.row -->


    <script src="/resources/js/admin-categories.js"></script>
  </body>
</html>
