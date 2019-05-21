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