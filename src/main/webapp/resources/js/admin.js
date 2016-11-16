(function($) {

    $.extend({
        admin: {}
    });

    $.admin.container = $('.admin-container-inner-wrap');

    function _init(){

        $.admin.container.load('/admin/view/home',function(){

            $('.menu-btn-home').addClass('active');

        });
        _initEvent();


    }

    function _initEvent(){

        $('.menu-btn-home').on('click',function(){

            $('.admin-menu').find('a').each(function(){
                $(this).removeClass('active');
            });

            $.admin.container.load('/admin/view/home',function(){

                $('.menu-btn-home').addClass('active');

           });
        });
        $('.menu-btn-new').on('click',function(){

            $('.admin-menu').find('a').each(function(){
                $(this).removeClass('active');
            });

            $.admin.container.load('/admin/view/new',function(){

                $('.menu-btn-new').addClass('active');
            });
        });
        $('.menu-btn-posts').on('click',function(){
            $('.admin-menu').find('a').each(function(){
                $(this).removeClass('active');
            });
            $.admin.container.load('/admin/view/posts',function(){
                $('.menu-btn-posts').addClass('active');

            });
        });
        //添加分类
        $('.menu-btn-categories').on('click',function(){
            $('.admin-menu').find('a').each(function(){
                $(this).removeClass('active');
            });
            $.admin.container.load('/admin/view/categories',function(){
                $('.menu-btn-categories').addClass('active');

            });
        });
        $('.menu-btn-comments').on('click',function(){
            $('.admin-menu').find('a').each(function(){
                $(this).removeClass('active');
            });
            $.admin.container.load('/admin/view/comments',function(){
                $('.menu-btn-comments').addClass('active');
            });
        });
    }

    _init();




})(jQuery);