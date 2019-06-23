
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
			request.post('/cart/save/all', this.cartList, callback=function() {
				alert('저장되었습니다.');
				location.reload();
			});
		},
		addAddress: function() {
			//daum api 사용
			new daum.Postcode({
		        oncomplete: function(data) {
		        	console.log(data);

		        	var deliveryAddress = {};
		        	var jibeon = data.jibunAddress;
		        	
		        	jibeon = jibeon.replace(data.sido,'');
		        	jibeon = jibeon.replace(data.sigungu,'');
		        	
		        	newDeliveryAddress = {};
		        	
		        	newDeliveryAddress.postCode = data.postcode;
		        	newDeliveryAddress.sido = data.sido; 
		        	newDeliveryAddress.sigungu = data.sigungu;
		        	
		        	newDeliveryAddress.roadAddress = data.roadAddress;
		        	newDeliveryAddress.eupmyeondong = jibeon;
		        	newDeliveryAddress.buildingName = data.buildingName;
		        	
		        	
		        	vmCart.newDeliveryAddresses.push(newDeliveryAddress);
		        }
		    }).open();
		},
		updateMemberDeliveryAddress: function() {
			
			console.log(vmCart.memberDeliveryAddress);
			
			request.post('/address/update', vmCart.memberDeliveryAddress, callback = function(response) {
				console.log(response);
				if (response.success == 'success') {
					alert('저장되었습니다.');
				}
			})
		},
		saveDeliveryAddresses: function() {
			
			var data = [];
			data.push.apply(data, vmCart.memberDeliveryAddresses);
			data.push.apply(data, vmCart.newDeliveryAddresses)
			
			console.log(data);
			
			request.post('/address/save/all', data, callback=function(response) {
				if (response.success=='success') {
					alert('저장되었습니다.');
				}
			});
		},
		deleteAddress: function(objName, idx) {
			vmCart[objName].splice(idx, 1);
		}
	}
});