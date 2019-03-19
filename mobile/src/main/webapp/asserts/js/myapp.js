/* {
	
	// for adding a loader
	$(window).load(function(){
		setTimeout(function() {
			$(".se-pre-con").fadeOut("slow");
		}, 500);			
	});	
	
	// for handling CSRF token
	var token = $('meta[name="_csrf"]').attr('content');
	var header = $('meta[name="_csrf_header"]').attr('content');
	
	if((token!=undefined && header !=undefined) && (token.length > 0 && header.length > 0)) {		
		// set the token header for the ajax request
		$(document).ajaxSend(function(e, xhr, options) {			
			xhr.setRequestHeader(header,token);			
		});				
	}
 */

// solving the active menu problem
$(function() {
	switch (menu) {

	case 'About':
		$('#about').addClass('active');
		break;
	case 'contact':
		$('#contact').addClass('active');
		break;
	case 'All the products':
		$('#listProducts').addClass('active');
		break;
	case 'Product Management':
		$('#manageProduct').addClass('active');
		break;
	case 'Shopping Cart':
		$('#userModel').addClass('active');
		break;
	default:
		if (menu == "Home")
			break;
		$('#listProducts').addClass('active');
		$('#a_' + menu).addClass('active');
		break;
	}

	/*
	 * var products = [ [ '1', 'veera' ], [ '2', 'Hari' ], [ '3', 'Ramu' ], [
	 * '4', 'Krishna' ], [ '5', 'RamaKrishna' ], ];
	 */

	var $table = $('#productListTable');

	if ($table.length) {
		// console.log("hello veeru!");

		var jsonUrl = '';
		if (window.categoryId == '') {

			jsonUrl = window.contextRoot + '/json/data/all/products';
		} else {
			jsonUrl = window.contextRoot + '/json/data/category/'
					+ window.categoryId + '/products';
		}
		$table.DataTable({

			lengthMenu : [ [ 3, 5, 10, -1 ],
					[ '3Records', '5Records', '10 Records', 'All' ] ],
			pageLength : 5,

			ajax : {

				url : jsonUrl,
				dataSrc : ''

			},
			columns : [
				
				{
					data:'code',
					bSortable : false,
					mRender(data,type,row)	{
						return '<img src="'+window.contextRoot+'/resoureces/images/'+data+'.jpg" class="dataTableImg"/>';
						//return '<img src="'${images}/.jpg" class="dataTableImg"/>';
						

					/*	data : 'code',
						bSortable : false,
						mRender : function(data, type, row) {

							return '<img src="' + window.contextRoot
									+ '/resources/images/' + data
									+ '.jpg" class="dataTableImg"/>';*/

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
				mRender:function(data,type,row){
					return '&#8377; '+data
				}
			},

			{
				data : 'quantity'
			} ,
			
			{
				data :'id',
				bSortable:false,
				mRender:function(data,type,row){
					
					var str='';
					
					str+='<a href="'+window.contextRoot+'/show/'+data+'/product" class="btn btn-primary"><span class="glyphicon glyphicon-eye-open"></span><a/> &#160';
					str+='<a href="'+window.contextRoot+'/cart/add/'+data+'/product" class="btn btn-success"><span class="glyphicon glyphicon-shopping-cart"></span</a>';
					
					return str;
					
				}
				
			}
			
			
			]

		});

	}

});
