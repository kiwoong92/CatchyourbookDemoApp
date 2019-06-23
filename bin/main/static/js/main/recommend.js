
var vmRecommend = new Vue({
	el:'#vm-recommend',
	data: vueData,
	watch: {
	},
	mounted: function() {
	},
	methods: {
		toggleRegist: function() {
			this.registYn = ~this.registYn;
		}
	}
});