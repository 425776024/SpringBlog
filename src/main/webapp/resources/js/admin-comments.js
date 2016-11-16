(function($){



    var editModal = $('#editCommentModal');

    var table = $('.admin-comments-table');
    var tbody = table.find('tbody');

    function _init(){
        _listComment();

    }
    function _initEvent(){

        $('tr',tbody).each(function(){

            $(this).on('click',function(){
                refreshBtnGroup();
            });

        });


        $('.admin-comments-edit').on('click',function(){
            _findComment();
        });
        editModal.find('.edit-comment-btn').on('click',function(){
            _updateComment();
        });

         $('.admin-comments-delete').on('click',function(){
            _deleteComment();

        });

    }

    function refreshBtnGroup(){

        var checkArr =  $('tbody input[type=checkbox]:checked','.admin-comments-table');
        var count = checkArr.length;

        switch (count){
            case 1:
                $('.admin-comments-edit').removeAttr('disabled');
                 $('.admin-comments-delete').removeAttr('disabled');
                break;
            default:
                $('.admin-comments-edit').attr('disabled','disabled');
                 $('.admin-comments-delete').attr('disabled','disabled');

        }
    }

    function _buildBtnGroup(){
        var html = [];
        var btnGroup = $('.comments-btn-group');
        html.push('  <button type="button" class="btn btn-default admin-comments-edit">Edit</button>');
        html.push(' <button type="button" class="btn btn-default admin-comments-delete">Delete</button>');
        btnGroup.empty();
        btnGroup.append(html.join(''));
    }

    function _loadCommentData(comments){

        var html = [];
        for(var i = 0; i < comments.length; i++){
            var comment = comments[i];

            html.push(' <tr data-key="'+comment.commentId+'">');
            html.push(' <td>');
            html.push(' <div class="checkbox">');
            html.push(' <label>');
            html.push(' <input type="checkbox" value="">');
            html.push(' <h4>'+comment.commentContent+'</h4>');
            html.push(' </label>');
            html.push(' </div>');
            html.push(' </td>');
            html.push(' </tr>');

        }
        tbody.empty();
        tbody.append(html.join(''));

        _buildBtnGroup();
        _initEvent();
        refreshBtnGroup();
    }



    //ajax

    function _findComment(){
        var selection = $('tbody input[type=checkbox]:checked','.admin-comments-table');
        var commentId = selection.parents('tr').attr('data-key');
        $.get('/admin/comment/'+commentId,function(data){
            var comment = data.comment;
            editModal.find('.comment-content').val(comment.commentContent);
            editModal.modal('show');
        });
    }

    function _updateComment(){

        var selection = $('tbody input[type=checkbox]:checked','.admin-comments-table');
        var commentId = selection.parents('tr').attr('data-key');
        var commentContent = editModal.find('.comment-content').val();

        editModal.modal('hide');

        $.put('/admin/comment/'+commentId,{commentContent : commentContent},function(){
            _listComment();
        });
    }

    function _deleteComment(){

        var selection = $('tbody input[type=checkbox]:checked','.admin-comments-table');
        var commentId = selection.parents('tr').attr('data-key');

        $.delete('/admin/comment/'+commentId,null,function(){
            _listComment();
        })
    }


    function _listComment(){

        $.get('/admin/comments',function(data){
            var comments = data.comments;
            _loadCommentData(comments);
        })


    }



    _init();



})(jQuery);