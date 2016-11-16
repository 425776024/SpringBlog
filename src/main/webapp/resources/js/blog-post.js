(function($){

    var postContainer = $('.blog-post-container');
    var postCommentsContainer = $('.blog-post-comments-container');

    function _init(){

        _initEvent();
        _listComment();

    }

    function _initEvent(){
        $('.comment-box-submit-btn').on('click',function(){

            _submitComment();

        });
    }

    function  _loadCommentData(comments){

        var html = [];
        for(var i = 0 ; i < comments.length; i++){
            var comment =  comments[i];
            var commentDate = new Date(comment.commentDate);
            html.push('<div class="blog-post-comments-one" data-key="'+comment.commentId+'">');
            html.push('<h3>');
            html.push(comment.commentAuthor+' ');
            html.push('<small>');
            html.push(' '+commentDate.toLocaleString());
            html.push('</small>');
            html.push('</h3>');
            html.push('<p>');
            html.push(comment.commentContent);
            html.push('</p>');
            html.push('</div>');
            html.push('<hr>');
        }

        postCommentsContainer.empty();
        postCommentsContainer.append(html.join(''));


    }


    //ajax
    function _submitComment(){

        var postId = $('.blog-post-title').attr('data-key');
        var name = $('.comment-box-name').val();
        var commentContent = $('.comment-box-content').val();

        var data = {
            postId : postId,
            name : name,
            commentContent : commentContent
        }
        $.post('/post/'+postId+'/comment',data,function(){

            $('.comment-box-name').val('');
            $('.comment-box-content').val('');
            _listComment();

        });

    }

    function _listComment(){
        var postId = $('.blog-post-title').attr('data-key');
        $.get('/post/'+postId+'/comments',function(data){
            var comments = data.comments;
            _loadCommentData(comments);
        })
    }

    _init();


})(jQuery)