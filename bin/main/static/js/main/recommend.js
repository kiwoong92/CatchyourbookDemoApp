
var vmRecommend = new Vue({
	el:'#vm-recommend',
	data: vueData,
	watch: {
	},
	mounted: function() {
	},
	methods: {
		toggleRegist: function() {
			
			if (this.registYn) {
				// 등록하는 로직.
			}
			
			this.registYn = ~this.registYn;
		}
	}
});