﻿const { jsPDF } = window.jspdf;
let callAddFont = function () {
	this.addFileToVFS('NanumGothicLight-normal.ttf', font);
	this.addFont('NanumGothicLight-normal.ttf', 'NanumGothicLight', 'normal');
};
jsPDF.API.events.push(['addFonts', callAddFont])