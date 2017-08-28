$(function() {
	// solving active menu problem
	switch (menu) {
	case 'About Us':
		// make class active
		$('#about').addClass('active');
		// flash the menu clicked
		$('#about').fadeOut(500).fadeIn(500);
		break;
	case 'Contact Us':
		$('#contact').addClass('active').fadeOut(500).fadeIn(500);
		break;
	case 'All Products':
		$('#listProducts').addClass('active').fadeOut(500).fadeIn(500);
		break;
	case 'Manage Products':
		$('#manageProducts').addClass('active').fadeOut(500).fadeIn(500);
		break;
	default:
		if (menu === "Home")
			break;
		$('#listProducts').addClass('active');
		$('#a_' + menu).addClass('active');
		break;
	}

	// code for jquery dataTable

	var $table = $('#productListTable');

	// execute the below code only where we have this table
	if ($table.length) {
		// console.log('Inside the table !');

		var jsonUrl = '';
		if (window.categoryId == '') {
			jsonUrl = window.contextRoot + '/json/data/all/products';
		} else {
			jsonUrl = window.contextRoot + '/json/data/category/'
					+ window.categoryId + '/products';
		}

		$table
				.DataTable({

					order : [ [ 1, "asc" ], [ 2, "asc" ], [ 3, "asc" ] ],
					// define types with column index for sorting
					columnDefs : [ {
						type : 'currency',
						targets : 3
					} ],
					lengthMenu : [
							[ 3, 5, 10, -1 ],
							[ '3 records', '5 records', '10 records',
									'All records' ] ],
					pageLength : 5,
					// data: products
					ajax : {
						url : jsonUrl,
						dataSrc : ''
					},
					columns : [
							{
								data : 'code',
								mRender : function(data, type, row) {
									// css class customDataTableImg is not
									// working in chrome
									// for this i added custom css property
									// class = "customDataTableImg"
									var cssProp = 'style="border: 1px solid #ddd; border-radius: 50%; padding: 5px;	box-shadow: 0 0 2px 1px rgba(0, 140, 186, 0.5);	width: 100px; height: 100px;"';
									return '<img src="' + window.contextRoot
											+ '/static/images/' + data
											+ '.jpg" ' + cssProp + '/>';

								}
							},
							{
								data : 'name'

							},
							{
								data : 'brand'

							},
							{
								data : 'unitPrice',
								bSortable : true,
								mRender : function(data, type, row) {
									// Doller sign is preventing sort
									return ' &#2547; ' + data; // '&#2547; ' +
								}

							},
							{
								data : 'quantity',
								mRender : function(data, type, row) {
									if (data < 1) {
										return '<span style="color:red">Out of Stock</span>';
									}
									return data;
								}

							},
							{
								data : 'id',
								bSortable : false,
								mRender : function(data, type, row) {
									var str = '';
									str += '<a href="'
											+ window.contextRoot
											+ '/show/'
											+ data
											+ '/product" class="btn btn-primary"><span class="glyphicon glyphicon-eye-open"></span></a> &#160;';

									if (row.quantity < 1) {
										str += '<a href="javascript:void(0)" class="btn btn-success disabled"><span class="glyphicon glyphicon-shopping-cart"></span></a>';
									} else {

										str += '<a href="'
												+ window.contextRoot
												+ '/cart/add/'
												+ data
												+ '/product" class="btn btn-success"><span class="glyphicon glyphicon-shopping-cart"></span></a>';
									}

									return str;
								}
							} ]

				});
	}

	// dismissing the alert after 3 seconds
	// reference transition.js

	// ---------------------------------------

	$('.switch input[type="checkbox"]')
			.on(
					'change',
					function() {

						// alert('entering function');
						var checkbox = $(this);
						// check if the checkbox is checked returns true or
						// false
						var checked = checkbox.prop('checked');
						var dMsg = (checked) ? 'You want to activate the product?'
								: 'You want to deactivate the product?';
						var value = checkbox.prop('value');

						bootbox
								.confirm({
									size : 'medium',
									title : 'Product Activation & Deactivation',
									message : dMsg,

									callback : function(confirmed) {
										if (confirmed) {

											bootbox
													.alert({
														size : 'medium',
														title : 'Information',
														message : 'You are going to perform operation on product'
																+ value
													});

										} else {
											checkbox.prop('checked', !checked);
										}
									}
								});

					});

	// -----------------------
	// data table for admin
	// ---------------------------

	var $adminProductsTable = $('#adminProductsTable');

	// execute the below code only where we have this table
	if ($adminProductsTable.length) {
		// console.log('Inside the table !');

		var jsonUrl = window.contextRoot + '/json/data/admin/all/products';

		$adminProductsTable
				.DataTable({
					// order : [ [ 1, "asc" ], [ 2, "asc" ], [ 3, "asc"
					// ] ],
					// define types with column index for sorting
					// columnDefs : [ {
					// type : 'currency',
					// targets : 3
					// } ],
					lengthMenu : [
							[ 10, 30, 50, -1 ],
							[ '10 records', '30 records', '50 records',
									'All records' ] ],
					pageLength : 30,
					// data: products
					ajax : {

						url : jsonUrl,
						dataSrc : ''

					},
					columns : [

							{
								data : 'id'
							},
							{
								data : 'code',
								mRender : function(data, type, row) {
									// css class customDataTableImg is
									// not
									// working in chrome
									// for this i added custom css
									// property
									// class = "customDataTableImg"
									var cssProp = 'style="border: 1px solid #ddd; border-radius: 50%; padding: 5px;	box-shadow: 0 0 2px 1px rgba(0, 140, 186, 0.5);	width: 100px; height: 100px;"';
									return '<img class="adminDataTableImg" src="'
											+ window.contextRoot
											+ '/static/images/'
											+ data
											+ '.jpg" />';

								}
							},
							{
								data : 'name'

							},
							{
								data : 'brand'

							},

							{
								data : 'quantity',
								mRender : function(data, type, row) {
									if (data < 1) {
										return '<span style="color:red">Out of Stock</span>';
									}
									return data;
								}

							},
							{
								data : 'unitPrice',
								bSortable : true,
								mRender : function(data, type, row) {
									// Doller sign is preventing sort
									return ' &#2547; ' + data; // '&#2547;
									// ' +
								}

							},
							{
								data : 'active',
								bSortable : false,
								mRender : function(data, type, row) {

									var str = '';
									str += '<label class="switch">';
									if (data)// if active

										str += '<input type="checkbox" checked="checked" value="'
												+ row.id + '" />';
									else
										str += '<input type="checkbox" value="'
												+ row.id + '" />';
									str += '<div class="slider" ></div>	</label>';

									return str;
								}
							},
							{
								data : 'id',
								bSortable : false,
								mRender : function(data, type, row) {
									var str = '';

									str += '	<a href="'
											+ window.contextRoot
											+ '/manage/'
											+ data
											+ '/product" class="btn btn-warning" >';
									str += '<span class="glyphicon glyphicon-pencil"></span></a>';

									return str;
								}
							} ],
					initComplete : function() {

						var api = this.api();

						api
								.$('.switch input[type="checkbox"]')
								.on(
										'change',
										function() {

											// alert('entering function');
											var checkbox = $(this);
											// check if the checkbox is
											// checked
											// returns true or
											// false
											var checked = checkbox
													.prop('checked');
											var dMsg = (checked) ? 'You want to activate the product?'
													: 'You want to deactivate the product?';
											var value = checkbox.prop('value');

											bootbox
													.confirm({
														size : 'medium',
														title : 'Product Activation & Deactivation',
														message : dMsg,

														callback : function(
																confirmed) {

															if (confirmed) {

																var activationUrl = window.contextRoot
																		+ '/manage/product/'
																		+ value
																		+ '/activation';
																$
																		.post(
																				activationUrl,
																				function(
																						data) {
																					bootbox
																							.alert({
																								size : 'medium',
																								title : 'Info',
																								message : data
																							});
																				});

															} else {
																checkbox
																		.prop(
																				'checked',
																				!checked);
															}
														}
													});

										});
					}

				});

	}

	// --------------------------

	// -----------------------------
	// ----- Jquery validator--------
	// ------------------------------

	var $categoryForm = $('#categoryForm');

	if ($categoryForm.length) {
		$categoryForm.validate({

			rules : {
				name : {
					required : true,
					minlength : 2
				},
				description : {
					required : true
				}
			},
			messages : {
				name : {
					required : 'Please add the category name',
					minlength : 'The category name should not be less than 2'
				},
				description : {
					required : 'Please add a description for this category!'
				}

			},
			errorElement : 'em',
			errorPlacement : function(error, element) {
				//add the class of help-block
				error.addClass('help-block');
				//add the error element after the input element
				error.insertAfter(element);
			}

		});
	}

	// ------------------------------
});