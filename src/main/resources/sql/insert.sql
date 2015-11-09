-- カテゴリ情報テーブル
INSERT INTO categories_defene VALUES(1,'和食');
INSERT INTO categories_defene VALUES(2,'洋食');
INSERT INTO categories_defene VALUES(3,'中華');
INSERT INTO categories_defene VALUES(100,'その他');

--ユーザーテーブル
INSERT INTO users VALUES(1,'テスト太郎','taro','aaaaaaaa');
INSERT INTO users VALUES(2,'テスト次郎','ziro','bbbbbbbb');

-- shopテーブル
INSERT INTO shops VALUES(1,'くら寿司','渋谷','安い');
INSERT INTO shops VALUES(2,'ラーメン次郎','横浜','豚の飯');
INSERT INTO shops VALUES(3,'トイザラス','入間','子供向け');
INSERT INTO shops VALUES(4,'ハローワーク','東京','ニートの友');

-- shopの保持したカテゴリ情報テーブル
INSERT INTO categories_exp VALUES(1,1);
INSERT INTO categories_exp VALUES(2,2);
INSERT INTO categories_exp VALUES(3,3);
INSERT INTO categories_exp VALUES(4,1);
