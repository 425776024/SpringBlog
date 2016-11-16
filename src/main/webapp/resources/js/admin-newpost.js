(function($) {

    var POST_STATUS_DRAFT = 0;
    var POST_STATUS_PUBLISH = 1;
    var POST_STATUS_PRIVATE = 2;


    function _init(){

        _initEditor();
        _initCategorySelectMenu();
        _initEvent();
    }

    function _initEditor(){

        $('#new-post-content').wysihtml5({
            "font-styles": true, //Font styling, e.g. h1, h2, etc. Default true
            "emphasis": true, //Italics, bold, etc. Default true
            "lists": true, //(Un)ordered lists, e.g. Bullets, Numbers. Default true
            "html": false, //Button which allows you to edit the generated HTML. Default false
            "link": true, //Button to insert a link. Default true
            "image": true, //Button to insert an image. Default true,
            "color": false, //Button to change color of font
            "size": 'sm', //Button size like sm, xs etc.
            stylesheets: ["/resources/css/bootstrap3-wysiwyg5-color.css"]
        });

    }

    function _initCategorySelectMenu(){

        _listCategory();

    }
    function _loadCategoryData(categories){

        var html = '';
        var menu = $('.newpost-category-select-menu');

        for(var i = 0; i < categories.length; i++){
            var category = categories[i];
            html += '<li><a data-key="'+category.catId+'" href="#">'+category.catName+'</a></li>';
        }
        menu.append($(html));

        $('li','.newpost-category-select-menu').each(function(){
            $(this).on('click',function(){
                var category = $(this).find('a');
                $('.newpost-category-btn-name').html(category.html());
                $('.newpost-category-btn-name').attr('data-key',category.attr('data-key'));
                $('.dropdown-toggle').dropdown();

            });

        });

    }
    function _initEvent(){

        $('.new-post-save-btn').on('click',function(){
            _savePosts();

        });
        $('.new-post-publish-btn').on('click',function(){
            _publishPosts();

        });

    }

    //ajax
    function _savePosts(){

        var categoryId = $('.newpost-category-btn-name').attr('data-key');
        var postTitle = $('.admin-new-post-title').val();
        var postContent = $('#new-post-content').val();
        var postId =  $('.admin-new-post-title').attr('data-key');

        var url = '/admin/post';
        var data = {
            categoryId : categoryId,
            title : postTitle,
            content : postContent,
            postStatus : POST_STATUS_DRAFT
        };
        if(postId != undefined && postId != ''){
            data.postId = postId;
        }

        $.post(url,data,function(data){
            console.log('save post success----'+data);
            if(data.returnCode == 1){

                var postId = data.postId;
                $('.admin-new-post-title').attr('data-key',postId);

                $('.admin-new-post-alert').addClass('alert-success');
                $('.admin-new-post-alert').css('display','block');
            }

        });

    }

    function _publishPosts(){

        var categoryId = $('.newpost-category-btn-name').attr('data-key');
        var postTitle = $('.admin-new-post-title').val();
        var postContent = $('#new-post-content').val();
        var postId =  $('.admin-new-post-title').attr('data-key');


        var url = '/admin/post';
        var data = {
            categoryId : categoryId,
            title : postTitle,
            content : postContent,
            postStatus : POST_STATUS_PUBLISH
        };
        if(postId != undefined && postId != ''){
            data.postId = postId;
        }

        $.post(url,data,function(data){
            console.log('save post success----'+data);
            if(data.returnCode == 1){

                var postId = data.postId;

                $.admin.container.load('/admin/view/post/'+postId,function(){

                });

            }


        });

    }
    function _listCategory(){
        $.get('/categories',function(data){
            _loadCategoryData(data.categories);

        });
    }



    _init();


})(jQuery);