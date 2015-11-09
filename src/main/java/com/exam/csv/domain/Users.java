package com.exam.csv.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


/**ユーザーを定義するクラス
*
*/
@Entity
@Table(name="users")
@Data
public class Users {
	
	/**
	 * ユーザーID
	 */
	@Id
	private Long id;
	
	/**
	 * ユーザー名
	 */
	private String name;
	
	/**
	 * ニックネーム
	 */

	private String nickname;
	
	/**
	 * パスワード
	 */
	private String password;

}
