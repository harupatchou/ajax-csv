package com.exam.csv.util;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

public class CsvUtil {
	
	/**
	 * ダウンロード時に使用する共有化したメソッド
	 * 
	 * @param res
	 * @param store
	 * @param name
	 * @throws Exception
	 */
	public static void download(HttpServletResponse res,List<String> store,String name) throws Exception{
		// ContentTypeを指定
		res.setContentType("text/csv;charset=MS932");
		// ファイル名を設定
		String fileName = new String(name.getBytes("MS932"), "ISO-8859-1");
		// Headerを設定
		res.setHeader("Content-Disposition", "attachment; filename="+fileName+".csv");
		// 内容を出力
		PrintWriter writer = res.getWriter();
		for (String st : store){
			writer.println(st);
		}
		writer.close();
		}

}
