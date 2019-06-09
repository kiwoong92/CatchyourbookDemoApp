
var vmJoinUs = new Vue({
	el:'#vm-joinus',
	data: vueData,
	mounted: function() {
	},
	methods: {
		submitMember: function() {
			var memberInfo = this.memberInfo;
			console.log(memberInfo);
			if (this.memberPw2 != memberInfo.memberPw) {
				alert('비밀번호를 확인해주세요!');
			} else {
				console.log("hello")
				request.post('/member/add', memberInfo, callback=function(response) {
					if(response.success == "success") {
						alert('가입되었습니다');
						window.location.href="/login";
					} else {
						var emptylist = Object.keys(response);
						emptylist.forEach(function(v) {
							if (v != 'success') {
								$('#'+ v).css('border', '1px solid red')
							}
						});
					}
					
				});
			}
		}
	}
});

