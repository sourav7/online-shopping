$(function() {
	// solving active menu problem
	switch (menu) {
	case 'About Us':
		$('#about').addClass('active');
		break;
	case 'Contact Us':
		$('#contact').addClass('active');
		break;
	case 'All Products':
		$('#listProducts').addClass('active');
		break;
	default:
		if(menu === "Home") break;
		$('#listProducts').addClass('active');
		$('#a_' + menu).addClass('active');
		break;
	}
	
	// code for jquery dataTable

	
	var $table = $('#productListTable');
	
	// execute the below code only where we have this table
	if($table.length){
		// console.log('Inside the table !');
		
		var jsonUrl = '';
		if(window.categoryId == ''){
			jsonUrl = window.contextRoot + '/json/data/all/products';
		}else{
			jsonUrl = window.contextRoot + '/json/data/category/' + window.categoryId + '/products';
		}
		
		$table.DataTable({
			
			lengthMenu: [[3,5,10,-1],  ['3 records','5 records','10 records','All records']],
			pageLength: 5,
			//data: products
			ajax: {
				url: jsonUrl,
				dataSrc: ''
			},
			columns: [	
						{
							data: 'code',
							mRender: function(data,type,row){
								//css class customDataTableImg is not working in chrome 
								//for this i added custom css property
								//class = "customDataTableImg"
								var cssProp = 'style="border: 1px solid #ddd; border-radius: 50%; padding: 5px;	box-shadow: 0 0 2px 1px rgba(0, 140, 186, 0.5);	width: 100px; height: 100px;"';
								return '<img src="' + window.contextRoot + '/static/images/' + data + '.jpg" '+ cssProp + '/>';
								
							}
						},
						{
							data: 'name'
							
						},
						{
							data: 'brand'
							
						},
						{
							data: 'unitPrice',
							mRender: function(data, type, row){
								return '&#2547; ' + data;
							}
							
						},
						{
							data: 'quantity',
							mRender: function(data, type, row){
								if(data < 1){
									return '<span style="color:red">Out of Stock</span>';
								}
								return data;
							}
							
						},
						{
							data: 'id',
							bSortable: false, 
							mRender: function(data, type, row){
								var str = '';
								str += '<a href="' + window.contextRoot + '/show/' + data + '/product" class="btn btn-primary"><span class="glyphicon glyphicon-eye-open"></span></a> &#160;';
								
								if(row.quantity < 1){
									str += '<a href="javascript:void(0)" class="btn btn-success disabled"><span class="glyphicon glyphicon-shopping-cart"></span></a>';
								}else{
									
									str += '<a href="' + window.contextRoot + '/cart/add/' + data + '/product" class="btn btn-success"><span class="glyphicon glyphicon-shopping-cart"></span></a>';
								}
								
								
								return str;
							}
						}
					]
			
		});
	}
	
});