<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
  <head>
  </head>

  <body>
    <div class="row">
        <div class="col-lg-10">
            <h2>All Comments</h2>
            <table class="table table-hover admin-comments-table">
                <tbody>
                <c:if test="${comments != null}">

                    <c:forEach items="${comments}" var="item">
                        <tr data-key="${item.commentId}">
                            <td>
                                <div class="checkbox">
                                    <label>
                                        <input type="checkbox" value="">
                                        <h4>${item.commentContent}</h4>
                                    </label>
                                </div>
                            </td>
                        </tr>
                    </c:forEach>
                </c:if>
                </tbody>
            </table>
            <div class="btn-group comments-btn-group">

            </div>

            <!-- Modal -->
            <div class="modal fade" id="editCommentModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            <h4 class="modal-title" id="myModalLabel">Edit comment</h4>
                        </div>
                        <div class="modal-body">
                            <h5>Comment content</h5>
                            <input type="text" class="form-control comment-content">

                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                            <button type="button" class="btn btn-primary edit-comment-btn">Save</button>
                        </div>
                    </div><!-- /.modal-content -->
                </div><!-- /.modal-dialog -->
            </div><!-- /.modal -->

        </div><!-- /.col-lg-6 -->
    </div><!-- /.row -->

  <script src="/resources/js/admin-comments.js"/>

  </body>
</html>
