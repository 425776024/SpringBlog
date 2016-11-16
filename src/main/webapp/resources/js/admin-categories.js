(function($) {

    var createModal = $('#createCategoryModal');
    var editModal = $('#editCategoryModal');

    var table = $('.admin-categories-table');
    var tbody = table.find('tbody');

   function _init(){
        _initEvent();
       _listCategory();

   }

    function _initEvent(){

        $('.admin-categories-create').on('click',function(){
            createModal.find('.category-name').val('category-name');
            createModal.modal('show');

        });

        createModal.find('.save-category-btn').on('click',function(){
            _saveCategory();

        });

        $('.admin-categories-edit').on('click',function(){

            _editCategory();

        });

        editModal.find('.edit-category-btn').on('click',function(){

            _updateCategory();
        });

        $('.admin-categories-delete').on('click',function(){
           _deleteCategory();
        });

        $('tr',tbody).each(function(){

            $(this).on('click',function(){
                refreshBtnGroup();
            });

        });

    }

    function refreshBtnGroup(){

        var checkArr =  $('tbody input[type=checkbox]:checked','.admin-categories-table');
        var count = checkArr.length;
        // alert(count);
        if(count==0){
            $('.admin-categories-edit').attr('disabled','disabled');
            $('.admin-categories-delete').attr('disabled','disabled');
        }else if(count==1){
            $('.admin-categories-edit').removeAttr('disabled');
            $('.admin-categories-delete').removeAttr('disabled');
        }else if(count>1){
            $('.admin-categories-edit').attr('disabled','disabled');
            $('.admin-categories-delete').removeAttr('disabled');
        }
    }

    function _loadCategoryData(categories){
        var html = [];
        for(var i = 0; i < categories.length; i++){
            var category = categories[i];

            html.push(' <tr data-key="'+category.catId+'">');
            html.push(' <td>');
            html.push(' <div class="checkbox">');
            html.push(' <label>');
            html.push(' <input type="checkbox" data-key="'+category.catId+'">');
            html.push(' <h4>'+category.catName+'</h4>');
            html.push(' </label>');
            html.push(' </div>');
            html.push(' </td>');
            html.push(' </tr>');

        }
        tbody.empty();
        tbody.append(html.join(''));

        //刷新多选
        $('tr',tbody).each(function(){

            $(this).on('click',function(){
                refreshBtnGroup();
            });

        });

    }


    //ajax

    function _saveCategory(){

        var name = $('#createCategoryModal').find('.category-name').val();

        createModal.modal('hide');

        $.post('/admin/category',{categoryName:name},function(){
            _listCategory();

        });

    }

    function _editCategory(){

        var selection = $('tbody input[type=checkbox]:checked','.admin-categories-table');

        var categoryId = selection.parents('tr').attr('data-key');

        $.get('/admin/category/'+categoryId,function(data){

            var category = data.category;
            editModal.find('.category-name').val(category.catName);
            editModal.modal('show');

        });

    }

    function _updateCategory(){

        var selection = $('tbody input[type=checkbox]:checked','.admin-categories-table');

        var categoryId = selection.parents('tr').attr('data-key');

        var categoryName =  editModal.find('.category-name').val();


        editModal.modal('hide');

        $.put('/admin/category/'+categoryId,{categoryName:categoryName},function(){

            _listCategory();

        });
    }


    function _deleteCategory(){

        // var selection = $('tbody input[type=checkbox]:checked','.admin-categories-table');
        var selection = $('tbody input[type=checkbox]:checked');
        selection.each(function () {
            console.log($(this).attr('data-key'));
            $.delete('/admin/category/'+$(this).attr('data-key'),null,function(data){
                _listCategory();
            });
        })
    }

    function _listCategory(){

        $.get('/admin/categories',function(data){
            console.log(data);
            var categories = data.categories;
            _loadCategoryData(categories);
        })


    }



    _init();



})(jQuery);