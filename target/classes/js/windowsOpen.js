var w = window;
function openWin(url) {
	if ((w == window) || w.closed) {
		w = open(url, "_blank", "width=500,height=500");
	} else {
		w.focus();
	}
	return (false);
}

/**
 * カテゴリ選択時の作業
 * 
 * 
 */
function goBackCategory(btnNo){
	//選択したカテゴリーの名前を取得
	var cateNameList=document.getElementsByName("category");
	//選択したカテゴリーのidを取得
	var cateIdList=document.getElementsByName("categoryId");
	//その他の入力情報取得
	var cateOther=document.getElementById("categoryOther").value;
	var name = "cateText"+btnNo;
	var hiddenId = "cateHiddenId"+btnNo;
	var hiddenName = "cateHiddenName"+btnNo;
	var other = "otherVal"+btnNo;
	//値をvalueに入れていく
	var value = "";
	//idをidListに入れていく
	var idList = "";
	for(var i=0;i<cateNameList.length;i++){
		if(cateNameList[i].checked){
			if(cateNameList[i].value!="その他"){
				value+=(cateNameList[i].value)+"/";
				idList+=(cateIdList[i].value)+"/";
			}else{
				value+=cateOther+"/";
				idList+=(cateIdList[i].value)+"/";
				window.opener.document.getElementById(other).value=cateOther;
			}
		}
	}
	value = value.substr( 0 , (value.length-1) );
	idList = idList.substr( 0 , (idList.length-1) );
	window.opener.document.getElementById(name).textContent=value;
	window.opener.document.getElementById(hiddenId).value=idList;
	window.opener.document.getElementById(hiddenName).value=value;
	window.close();	
}
