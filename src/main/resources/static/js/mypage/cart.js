
var vmCart = new Vue({
	el:'#vm-cart',
	data: vueData,
	watch: {
		cartList : {
			handler: function() {
				this.computeTotal();
				this.isChanged = true;
			},deep:true
		}
	},
	mounted: function() {
		this.computeTotal();
	},
	methods: {
		changeQty: function(bookId, type) {

			var cartList = this.cartList;
			var curBookPrd = undefined;
			
			cartList.map(function(v) {
				if (v.bookId == bookId) {
					curBookPrd = v;
					return;
				}
			});
			
			if (type == 'plus') {
				curBookPrd.qty ++;
			} else if (type == 'minus') {
				if (curBookPrd.qty > 1) {
					curBookPrd.qty --;
				}
			}
		},
		computeTotal: function() {

			var amount = 0;
			var totalQty = 0;
			this.cartList.forEach(function(v){
				amount += (v.qty * v.bookPrd.dcPrice);
				totalQty += (v.qty);
			});
			
			this.totalQty = totalQty;
			this.totalPrice = amount;
		},
		deleteBookPrd: function(idx) {
			this.cartList.splice(idx,1);
		},
		saveCartChanged: function() {
			request.post('/cart/save', this.cartList, callback=function() {
				console.log("response");
				alert('저장되었습니다.');
				location.reload();
			});
		}
	
	}
});