 var errorFlag = 0;
 var errorMsg = [];
 var errorList ="";
function validation(){
 // 必須項目(空かどうか)
 if(document.shopInsert.name.value == ""){ // 「名前」の入力チェック
 errorMsg.push("名前が空です");
 errorFlag = 1;
 }
 if(document.shopInsert.categoryName.value == ""){ // 「カテゴリ」の入力チェック
 errorMsg.push("カテゴリを選択してください");
 errorFlag = 2;
 }
 
 errorList="<th class='errorNum'></th>"
 for (var i=0;i<errorFlag;i++){
	 $("#errorList").append(errorList);
 }
 var j=0;
 $(".errorNum").each(function(){
	$(this).attr("id","errorText"+j)
	var text = "errorMsg"+j
	document.getElementById("errorText"+j).textContent=errorMsg[j];
	j+=1;
 });

 if(errorFlag != 0) {
	 hyoji(errorFlag);
 return false;
 } else {
 return true;
 }
}

function hyoji(num)
{
  if (num != 0)
  {
    document.getElementById("errorArea").style.display="block";
  }
  else
  {
    document.getElementById("errorArea").style.display="none";
  }
}