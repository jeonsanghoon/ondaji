"use strict"
/**
 * 공통 함수
 */
var BaseCommon = {
	/** 
	 * Form 메서드
	*/
	FormInfo : {
		/** 
		 * 동적 Form 생성
		*/
		makeForm : (ActionURL) => {
			let frm = document.createElement("form");
			frm.setAttribute("method", "post");
			if (!(ActionURL == undefined || ActionURL == "")) {
				frm.setAttribute("action", ActionURL);
			}
			document.body.appendChild(frm);
			return frm;
		}, 
		/**
		 * Form에 동적 input Data 추가
		 */
		addData: (name, value, frm) => {
			let i = document.createElement("input");
			i.setAttribute("type", "hidden");
			i.setAttribute("name", name);
			i.setAttribute("value", value);
			frm.appendChild(i);
		}, 
		/**
		 * Form Data를 Json Object로 변환
		 */
		formDataToJson:(formId) =>
		{
			let object = {};
			let formData = new FormData(document.getElementById(formId));
			formData.forEach((value, key) => {object[key] = value});
			return JSON.stringify(object);
		}
	}
}