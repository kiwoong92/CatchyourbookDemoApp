/**
 * books.html에서 사용할  
 */

function viewDetail(productId) {
	console.log(productId);
	var url = "/rest/book/" + productId;
	
	$('#'+productId).tooltip();
	
//	request.get(url, function(response) {
//		console.log("common.request.get test", response);
//	});
}

function addCart(bookId) {
	console.log(bookId);
	request.get('/cart/add/' + bookId, callback=function(response) {
		console.log(response)
		if (response.success == "success") {
			alert('장바구니에 추가되었습니다.');
		} else {
			alert('로그인이 필요한 서비스 입니다.\n로그인 후 진행해주세요.')
		}
	});
}