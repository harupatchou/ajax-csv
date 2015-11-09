//現状のプロジェクトの番号
var shopNo = 1;
//ボタンの番号
var btnNo = 0;

/**
 * 初期表示時の実行
 */
window.onload = function(){
	addShop('addShop');
	hyoji(0);
}

/**
 * 現在の先頭に対して、店舗の追加を行う
 * @param tableIdName 追加したいテーブルのId名
 */
function addShop(addShop){
	//番号の初期化
	shopNo = 1;
	//ボタン系の番号を増やす
	btnNo += 1;
	//追加したい表示コンテンツを書き込む
	var appendContent = 
			"<tbody id='tableId" + btnNo + "' >" +
			"<tr><th>番号</th><th>店舗名</th><th>店舗住所</th><th colspan='2'>店舗カテゴリ</th><td>行削除</td></tr>" +
			"<tr><input type='hidden' name='no' class='shopNoHidden' /><td rowspan='3' class='shopNo'>" +
			"</td><td><input name='name' size='20' /></td><td><input name='address' size='20' /></td>" +
			"<td id='cateText" + btnNo + "'>選択したカテゴリ表示</td><td>" +
			"<input type='hidden' name='categoryName' id='cateHiddenName" + btnNo + "' size='20' />" +
			"<input type='hidden' name='categoryId' id='cateHiddenId" + btnNo + "' />" +
			"<input type='hidden' name='other' id='otherVal" + btnNo + "' />" +
			"<input type='button' value='カテゴリ選択' id='categoryBtn' onclick=\"return openWin('/shop/window?btnNo="　+ btnNo +　"')\" /></td>" +
			"<td><input type='button' value='行削除' id='deleteShop" + btnNo  + "' class='' onclick=\"deleteShop(\'" + btnNo + "\')\" /></td></tr>" +
			"<tr><th colspan='5'>店舗詳細</th></tr><tr><td colspan='5'><textarea name='detail' rows='10' cols='75' /></td></tr></tbody>";	
	$("#"+addShop).prepend(appendContent);
	setProNo();
}

/**
 * 店舗の削除を行う。
 * @param tableIdName 削除を行いたいテーブルのId名
 */
function deleteShop(btnNo){
	//削除した分番号を減らす
	var work = $("#tableId"+btnNo);
	work.remove();
	setProNo();
}

/**
 * 店舗番号の自動采配を行う。
*/
function setProNo(){
	//ボタンを押すたび、番号の割り振り
	$(".shopNoHidden").each(function(){
		$(this).attr("value",shopNo)
		shopNo+=1;
	});
	//番号の初期化
	shopNo = 1;
	$(".shopNo").each(function(){
		$(this).text(shopNo)
		shopNo+=1;
	});
	//番号の初期化
	shopNo = 1;
	
}