$(document).ready(function(){
	
		var i18n = { // 本地化
			previousMonth	: '上个月',
			nextMonth		: '下个月',
			months			: ['一月','二月','三月','四月','五月','六月','七月','八月','九月','十月','十一月','十二月'],
			weekdays		: ['周日','周一','周二','周三','周四','周五','周六'],
			weekdaysShort	: ['日','一','二','三','四','五','六']
		}
	
		 var realBirthDay = new Pikaday({
			field: jQuery('#realBirthDay')[0],
			firstDay: 2,
			minDate:	new Date('2000-01-01'), 
			maxDate:	new Date('2020-12-31'), 
			yearRange:	[2000,2020],
			i18n: 		i18n,
			onSelect: 	function() {
				var date = this.getDate(); //生成的时间格式化成 2013-09-25.Format('yyyy-MM-dd') + ' '//dd.getFullYear() + '-' + dd.getMonth() + '-' + dd.getDate()
				var dd = new Date(date.getTime());
				var month = parseInt(dd.getMonth()) + 1;
				$('#realBirthDay').val(dd.getFullYear() + '-' + month + '-' + dd.getDate());
			}
		}); 
		
		var diseaseTime = new Pikaday({
			field: jQuery('#diseaseTime')[0],
			firstDay: 2,
			minDate:	new Date('2000-01-01'), 
			maxDate:	new Date('2020-12-31'), 
			yearRange:	[2000,2020],
			i18n: 		i18n,
			onSelect: 	function() {
				var date = this.getDate(); //生成的时间格式化成 2013-09-25.Format('yyyy-MM-dd') + ' '//dd.getFullYear() + '-' + dd.getMonth() + '-' + dd.getDate()
				var dd = new Date(date.getTime());
				var month = parseInt(dd.getMonth()) + 1;
				$('#diseaseTime').val(dd.getFullYear() + '-' + month + '-' + dd.getDate());
			}
		});
		
		var diseaseTime2 = new Pikaday({
			field: jQuery('#diseaseTime2')[0],
			firstDay: 2,
			minDate:	new Date('2000-01-01'), 
			maxDate:	new Date('2020-12-31'), 
			yearRange:	[2000,2020],
			i18n: 		i18n,
			onSelect: 	function() {
				var date = this.getDate(); //生成的时间格式化成 2013-09-25.Format('yyyy-MM-dd') + ' '//dd.getFullYear() + '-' + dd.getMonth() + '-' + dd.getDate()
				var dd = new Date(date.getTime());
				var month = parseInt(dd.getMonth()) + 1;
				$('#diseaseTime2').val(dd.getFullYear() + '-' + month + '-' + dd.getDate());
			}
		});
		
		var coughStartTime = new Pikaday({
			field: jQuery('#coughStartTime')[0],
			firstDay: 2,
			minDate:	new Date('2000-01-01'), 
			maxDate:	new Date('2020-12-31'), 
			yearRange:	[2000,2020],
			i18n: 		i18n,
			onSelect: 	function() {
				var date = this.getDate(); //生成的时间格式化成 2013-09-25.Format('yyyy-MM-dd') + ' '//dd.getFullYear() + '-' + dd.getMonth() + '-' + dd.getDate()
				var dd = new Date(date.getTime());
				var month = parseInt(dd.getMonth()) + 1;
				$('#coughStartTime').val(dd.getFullYear() + '-' + month + '-' + dd.getDate());
			}
		});
		
		var diarrheaContinueTime = new Pikaday({
			field: jQuery('#diarrheaContinueTime')[0],
			firstDay: 2,
			minDate:	new Date('2000-01-01'), 
			maxDate:	new Date('2020-12-31'), 
			yearRange:	[2000,2020],
			i18n: 		i18n,
			onSelect: 	function() {
				var date = this.getDate(); //生成的时间格式化成 2013-09-25.Format('yyyy-MM-dd') + ' '//dd.getFullYear() + '-' + dd.getMonth() + '-' + dd.getDate()
				var dd = new Date(date.getTime());
				var month = parseInt(dd.getMonth()) + 1;
				$('#diarrheaContinueTime').val(dd.getFullYear() + '-' + month + '-' + dd.getDate());
			}
		});
		
		var dizzyContinueTime = new Pikaday({
			field: jQuery('#dizzyContinueTime')[0],
			firstDay: 2,
			minDate:	new Date('2000-01-01'), 
			maxDate:	new Date('2020-12-31'), 
			yearRange:	[2000,2020],
			i18n: 		i18n,
			onSelect: 	function() {
				var date = this.getDate(); //生成的时间格式化成 2013-09-25.Format('yyyy-MM-dd') + ' '//dd.getFullYear() + '-' + dd.getMonth() + '-' + dd.getDate()
				var dd = new Date(date.getTime());
				var month = parseInt(dd.getMonth()) + 1;
				$('#dizzyContinueTime').val(dd.getFullYear() + '-' + month + '-' + dd.getDate());
			}
		});
		
		var painContinueTime = new Pikaday({
			field: jQuery('#painContinueTime')[0],
			firstDay: 2,
			minDate:	new Date('2000-01-01'), 
			maxDate:	new Date('2020-12-31'), 
			yearRange:	[2000,2020],
			i18n: 		i18n,
			onSelect: 	function() {
				var date = this.getDate(); //生成的时间格式化成 2013-09-25.Format('yyyy-MM-dd') + ' '//dd.getFullYear() + '-' + dd.getMonth() + '-' + dd.getDate()
				var dd = new Date(date.getTime());
				var month = parseInt(dd.getMonth()) + 1;
				$('#painContinueTime').val(dd.getFullYear() + '-' + month + '-' + dd.getDate());
			}
		});
		var operationTime = new Pikaday({
			field: jQuery('#operationTime')[0],
			firstDay: 2,
			minDate:	new Date('2000-01-01'), 
			maxDate:	new Date('2020-12-31'), 
			yearRange:	[2000,2020],
			i18n: 		i18n,
			onSelect: 	function() {
				var date = this.getDate(); //生成的时间格式化成 2013-09-25.Format('yyyy-MM-dd') + ' '//dd.getFullYear() + '-' + dd.getMonth() + '-' + dd.getDate()
				var dd = new Date(date.getTime());
				var month = parseInt(dd.getMonth()) + 1;
				$('#operationTime').val(dd.getFullYear() + '-' + month + '-' + dd.getDate());
			}
		});
		var transfusionTime = new Pikaday({
			field: jQuery('#transfusionTime')[0],
			firstDay: 2,
			minDate:	new Date('2000-01-01'), 
			maxDate:	new Date('2020-12-31'), 
			yearRange:	[2000,2020],
			i18n: 		i18n,
			onSelect: 	function() {
				var date = this.getDate(); //生成的时间格式化成 2013-09-25.Format('yyyy-MM-dd') + ' '//dd.getFullYear() + '-' + dd.getMonth() + '-' + dd.getDate()
				var dd = new Date(date.getTime());
				var month = parseInt(dd.getMonth()) + 1;
				$('#transfusionTime').val(dd.getFullYear() + '-' + month + '-' + dd.getDate());
			}
		});
		var untreatedDiseaseTime = new Pikaday({
			field: jQuery('#untreatedDiseaseTime')[0],
			firstDay: 2,
			minDate:	new Date('2000-01-01'), 
			maxDate:	new Date('2020-12-31'), 
			yearRange:	[2000,2020],
			i18n: 		i18n,
			onSelect: 	function() {
				var date = this.getDate(); //生成的时间格式化成 2013-09-25.Format('yyyy-MM-dd') + ' '//dd.getFullYear() + '-' + dd.getMonth() + '-' + dd.getDate()
				var dd = new Date(date.getTime());
				var month = parseInt(dd.getMonth()) + 1;
				$('#untreatedDiseaseTime').val(dd.getFullYear() + '-' + month + '-' + dd.getDate());
			}
		});
		var drugsBeingUsedTime = new Pikaday({
			field: jQuery('#drugsBeingUsedTime')[0],
			firstDay: 2,
			minDate:	new Date('2000-01-01'), 
			maxDate:	new Date('2020-12-31'), 
			yearRange:	[2000,2020],
			i18n: 		i18n,
			onSelect: 	function() {
				var date = this.getDate(); //生成的时间格式化成 2013-09-25.Format('yyyy-MM-dd') + ' '//dd.getFullYear() + '-' + dd.getMonth() + '-' + dd.getDate()
				var dd = new Date(date.getTime());
				var month = parseInt(dd.getMonth()) + 1;
				$('#drugsBeingUsedTime').val(dd.getFullYear() + '-' + month + '-' + dd.getDate());
			}
		});
		var recentlyMenstrualDay = new Pikaday({
			field: jQuery('#recentlyMenstrualDay')[0],
			firstDay: 2,
			minDate:	new Date('2000-01-01'), 
			maxDate:	new Date('2020-12-31'), 
			yearRange:	[2000,2020],
			i18n: 		i18n,
			onSelect: 	function() {
				var date = this.getDate(); //生成的时间格式化成 2013-09-25.Format('yyyy-MM-dd') + ' '//dd.getFullYear() + '-' + dd.getMonth() + '-' + dd.getDate()
				var dd = new Date(date.getTime());
				var month = parseInt(dd.getMonth()) + 1;
				$('#recentlyMenstrualDay').val(dd.getFullYear() + '-' + month + '-' + dd.getDate());
			}
		});
		
		
	});