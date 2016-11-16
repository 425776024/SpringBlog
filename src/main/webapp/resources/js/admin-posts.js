(function($) {

    var COMMETNS_STAUTS_CLOSE = 0;
    var COMMETNS_STAUTS_OPEN = 1;

    var table = $('.admin-posts-table');
    var tbody = table.find('tbody');


    function _init(){

        _listPost();
    }


    function _initEvent(){

        $('.admin-posts-read').on('click',function(){

            _readPost();

        });

         $('.admin-posts-edit').on('click',function(){

            _editPost();

        });

        $('.admin-posts-delete').on('click',function(){

            _deletePost();

        });

        $('.admin-posts-close-comments').on('click',function(){

            _changeCommentStatus(COMMETNS_STAUTS_CLOSE);

        });

        $('.admin-posts-open-comments').on('click', function(){

            _changeCommentStatus(COMMETNS_STAUTS_OPEN);

        });

        $('tr',tbody).each(function(){

            $(this).on('click',function(){
                refreshBtnGroup();
            });

        });


    }

    function refreshBtnGroup(){

       var checkArr =  $('tbody input[type=checkbox]:checked','.admin-posts-table');
       var count = checkArr.length;

        console.log('refresh----'+count);

       switch (count){
           case 1:
               $('.admin-posts-read').removeAttr('disabled');
                $('.admin-posts-edit').removeAttr('disabled');
               $('.admin-posts-delete').removeAttr('disabled');
               $('.admin-posts-close-comments').removeAttr('disabled');
               $('.admin-posts-open-comments').removeAttr('disabled');
               break;

           default:

               $('.admin-posts-read').attr('disabled','disabled');
                $('.admin-posts-edit').attr('disabled','disabled');
               $('.admin-posts-delete').attr('disabled','disabled');
               $('.admin-posts-close-comments').attr('disabled','disabled');
               $('.admin-posts-open-comments').attr('disabled','disabled');

       }
    }

    function _buildBtnGroup(){
        var html = [];
        var btnGroup = $('.new-post-btn-group');
        html.push(' <button type="button" class="btn btn-default admin-posts-read">Read</button>');
        html.push(' <button type="button" class="btn btn-default admin-posts-edit">Edit</button>');
        html.push(' <button type="button" class="btn btn-default admin-posts-delete">Delete</button>');
        html.push(' <button type="button" class="btn btn-default admin-posts-close-comments">Close comments</button>');
        html.push(' <button type="button" class="btn btn-default admin-posts-open-comments">Open comments</button>');
        btnGroup.empty();
        btnGroup.append(html.join(''));
    }

    function _loadPostData(posts){
        var html = [];
        for(var i = 0; i < posts.length; i++){

            var post = posts[i];

            html.push(' <tr data-key="'+post.postId+'">');
            html.push(' <td>');
            html.push(' <div class="checkbox">');
            html.push(' <label>');
            html.push(' <input type="checkbox" value="">');
            html.push(' <h4>'+post.postTitle+'</h4>');
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

    function _readPost(){

        var selection = $('tbody input[type=checkbox]:checked','.admin-posts-table');

        var postId = selection.parents('tr').attr('data-key');

        console.log(postId);

        $.admin.container.load('/admin/view/post/'+postId,function(){

        });

    }

    function _editPost(){

        var selection = $('tbody input[type=checkbox]:checked','.admin-posts-table');

        var postId = selection.parents('tr').attr('data-key');

        $.get('/admin/post/'+postId,function(data){

            var post = data.post;
            var category = data.category;

            $('.admin-posts-container').load('/admin/view/new',function(){

                $('#new-post-content').val(post.postContent);
                $('.admin-new-post-title').val(post.postTitle);
                $('.admin-new-post-title').attr('data-key',post.postId);
                $('.newpost-category-btn-name').html(category.catName);
                $('.newpost-category-btn-name').attr('data-key',category.catId);

            });

        });
    }

    function _deletePost(){

        var selection = $('tbody input[type=checkbox]:checked','.admin-posts-table');

        var postId = selection.parents('tr').attr('data-key');

        $.delete('/admin/post/'+postId,null,function(response,textStatus){

            _listPost();
        });



    }

    function _changeCommentStatus(commentStatus){

        var selection = $('tbody input[type=checkbox]:checked','.admin-posts-table');

        var postId = selection.parents('tr').attr('data-key');
        var data = {
            commentStatus : commentStatus
        }
        var url = '/admin/post/'+postId;
        $.put(url,data,function(data){

            if(data.returnCode == 1){

                if(commentStatus == COMMETNS_STAUTS_CLOSE){

                    $('.admin-posts-alert-msg-notice').html('You successfully close comments of the post.')

                }else{

                    $('.admin-posts-alert-msg-notice').html('You successfully open comments of the post.')

                }
                $('.admin-posts-alert').addClass('alert-success');
                $('.admin-posts-alert').css('display','block');


            }

        });

    }

    function _listPost(){

        $.get('/admin/posts', function(data){
            var posts = data.posts;
            _loadPostData(posts);
        });

    }



    _init();


})(jQuery);