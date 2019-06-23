
var vmRecommend = new Vue({
	el:'#vm-recommend',
	data: vueData,
	watch: {
	},
	mounted: function() {
	},
	methods: {
		toggleRegist: function() {
			
			console.log(this.registYn);
			if (this.registYn == true) {
				// 등록하는 로직.
				
				console.log('뭐');
				request.post('/book/recommend/add', this.newBookRecommend, callback=function(response) {
					alert('등록되었습니다.');
					console.log(response);
				});
				
				this.registYn = false;
			} else {
				this.registYn = true;
			}
			
		}
	}
});