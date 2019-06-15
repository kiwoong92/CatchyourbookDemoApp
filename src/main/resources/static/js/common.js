/**
 * 공통으로 사용할  
 */

Vue.filter('price', function (value) {
	if (!value) return 'NaN'
	if (value == 0) return '0'
	
    value = value.toString()
    return value.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
})
	 
new Vue({
  // ...
});



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