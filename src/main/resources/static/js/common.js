/**
 * 공통으로 사용할  
 */
console.log("import common.js!!")

var request = {
	get : function(url,callback) {
		$.ajax({
			type:"get",
			url: url,
			dataType : "json",
			success: function(response){
				callback(response);
			}
		});
	},
	post: function(url, data, callback) {
		$.ajax({
			type:"post",
			url: url,
			data: JSON.stringify(data),
			contentType: 'application/json',
			dataType : "json",
			success: function(response){
				callback(response);
			}
		});
	}
}