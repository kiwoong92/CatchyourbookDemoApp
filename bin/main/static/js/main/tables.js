/**
 * books.html에서 사용할  
 */

function selectTop(groupId) {
	
//	var url = "/rest/book/" + productId;
}


var vmTables = new Vue({
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
					vmTables.childGroupList = response;
				});
			} else {
				
				vmTables.selectedClassId = '';

				vmTables.childGroupList = [];
				vmTables.classList = [];
				
			}
		},
		selectChild: function() {
			var groupId = vmTables.selectedChild;
//			console.log(groupId);
			if (groupId != undefined && groupId != null && groupId != "") {
				var url = "/rest/uniclass/" + groupId
				request.get(url, function(response) {
					
					vmTables.classList = response;
					vmTables.selectedClassId = '';
					
				});
			} else {
				vmTables.classList = [];
			}
		},
		selectClass: function() {
			var selectedClassId = vmTables.selectedClassId;
			var find = vmTables.classList.map(function(v) {
				return v.classId;
			}).indexOf(selectedClassId);
			
			var exist = vmTables.selectedClassList.indexOf(selectedClassId);

			
			console.log(exist);
			if (exist < 0) {
				vmTables.selectedClassList.push(selectedClassId);
				vmTables.updateTable( vmTables.classList[find]);		//색칠해주는 로직.
				
				vmTables.selectedChild = '';
				vmTables.selectedClassId = '';
				vmTables.classList = [];
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
	var color = vmTables.tableColors[vmTables.tableColorIdx];
	
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
//				'background-color': vmTables.tableColors[vmTables.tableColorIdx],
//				'border-bottom':'1px solid ' + vmTables.tableColors[vmTables.tableColorIdx]
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
			"background-color": vmTables.tableColors[vmTables.tableColorIdx],
			"height":height,
			"width": $(tableId + startIndex)[0].offsetWidth + "px"
		});
	}	
}

function deleteTable(classId) {
	console.log(classId);
	console.log($('div[id^=\''+classId+'\']'));
	$('div[id^=\''+classId+'\']').remove();
	console.log(vmTables.selectedClassList);
	
	var find = vmTables.selectedClassList.indexOf(classId);
	console.log(find);
	vmTables.selectedClassList.splice(find, 1);
	console.log(vmTables.selectedClassList);
}

$(window).resize(function() {
	console.log("resize");
})