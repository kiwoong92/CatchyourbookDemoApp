/**
 * books.html에서 사용할  
 */

function selectTop(groupId) {
	
//	var url = "/rest/book/" + productId;
}


var vmMyTables = new Vue({
	el:'#vm-mytable-vue',
	data: vueData,
	mounted: function() {
	},
	methods: {
		selectTop: function(groupId) {
//			console.log(groupId);
			if (groupId != undefined && groupId != null && groupId != "") {
				var url = "/rest/uniclassgroup/" + groupId
				request.get(url, function(response) {
					vmMyTables.childGroupList = response;
				});
			} else {
				
				vmMyTables.selectedClassId = '';

				vmMyTables.childGroupList = [];
				vmMyTables.classList = [];
				
			}
		},
		selectChild: function() {
			var groupId = vmMyTables.selectedChild;
//			console.log(groupId);
			if (groupId != undefined && groupId != null && groupId != "") {
				var url = "/rest/uniclass/" + groupId
				request.get(url, function(response) {
					
					vmMyTables.classList = response;
					vmMyTables.selectedClassId = '';
					
				});
			} else {
				vmMyTables.classList = [];
			}
		},
		selectClass: function() {
			var selectedClassId = vmMyTables.selectedClassId;
			var find = vmMyTables.classList.map(function(v) {
				return v.classId;
			}).indexOf(selectedClassId);
			
			var exist = vmMyTables.selectedClassList.indexOf(selectedClassId);

			
			console.log(exist);
			if (exist < 0) {
				vmMyTables.selectedClassList.push(selectedClassId);
				vmMyTables.updateTable( vmMyTables.classList[find]);		//색칠해주는 로직.
				
				vmMyTables.selectedChild = '';
				vmMyTables.selectedClassId = '';
				vmMyTables.classList = [];
			} else {
				alert('이미 추가된 수업입니다!');
			}
			
		},
		updateTable: function(classObj) {
			createTable(classObj);
			this.tableColorIdx ++;
		}, 
		moveMatchingPage: function() {
			// console.log(vMyTables.)
			var form = $('#classform');
			console.log(this.selectedClassList);
			
			form.submit();
		}
	}
});


function createTable(uniClass) {
	
	var prefix = "#cell_";
	var classList = uniClass.uniClasstimes;
	var color = vmMyTables.tableColors[vmMyTables.tableColorIdx];
	
	for (var i = 0; i < classList.length; i++) {
		var time = classList[i];
		
		//TODO : 30 분 단위의 케이스에 대한 처리
		var startIndex = (time.startTime - 90000)/10000 * 2 + 1;
		var endIndex = (time.endTime - 90000)/10000*2 + 1;
		
		var tableId = prefix + time.classDay.toLowerCase() +"_";
		var height = (endIndex - startIndex) * 50 + (endIndex - startIndex - 1);
		var cell = $(tableId + startIndex).offset();

//		for (var j = startIndex; j < endIndex; j ++) {
//			$(tableId + j).css({
//				'background-color': vmMyTables.tableColors[vmMyTables.tableColorIdx],
//				'border-bottom':'1px solid ' + vmMyTables.tableColors[vmMyTables.tableColorIdx]
//			});
//		}
		
		console.log(height);
//		console.log("=======================================");
//		console.log(">>>> startIndex : ", startIndex);
//		console.log(">>>> endIndex   : ", endIndex);
//		console.log(">>>> height     : ", height);
//		console.log(">>>> cell.top   : ", cell.top);
//		console.log(">>>> cell.left  : ", cell.left);
//		console.log(">>>> cell.width : ", $(tableId)[0].offsetWidth);
	
		var divId = uniClass.classId + '_' + i ;
//		
		$(tableId + startIndex).html(
			'<div id=\"' + divId + '\" class=\"table-info\">'
			+	'<div><img src=\"/images/xbutton.png\" onclick=\"deleteTable(\''+uniClass.classId+'\')\"></div>'
			+ 	'<div>' + uniClass.name + '</div>'
			+	'<div>' + '[강의실정보]' + '</div>'
			+'</div>');
		
		$('#' + divId).css({
			"top": cell.top  + "px",
			"left": cell.left + "px",
			"position" : 'absolute',
			"background-color": vmMyTables.tableColors[vmMyTables.tableColorIdx],
			"height":height,
			"width": $(tableId + startIndex)[0].offsetWidth + "px"
		});
	}	
}

function deleteTable(classId) {
	console.log(classId);
	console.log($('div[id^=\''+classId+'\']'));
	$('div[id^=\''+classId+'\']').remove();
	console.log(vmMyTables.selectedClassList);
	
	var find = vmMyTables.selectedClassList.indexOf(classId);
	console.log(find);
	vmMyTables.selectedClassList.splice(find, 1);
	console.log(vmMyTables.selectedClassList);
}

$(window).resize(function() {
	console.log("resize");
})