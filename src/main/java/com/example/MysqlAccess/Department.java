package com.example.MysqlAccess; //フィールド


import java.sql.Timestamp; //import名前を宣言  java.sql.Timestampは小数点以下の時間数値(ミリ秒)まで保持することが出来る

import javax.persistence.Column; //javax.persistenceパッケージ
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity //このエンティティはデータベースに新規登録するデータである、該当のクラスがエンティティである @Entity 顧客マスターテーブルという箱
@Table(name="M_DEPARTMENT") //@Table 異なるテーブルをマッピング
public class Department {   //departmentメソッド
	@Id //@Id プライマリキーとなるプロパティかフィールドを指定する departmentマスターテーブルのprimaryはD_CD
	@Column(name="D_CD" ,columnDefinition = "CHAR(2)") //@Colum カラム属性を指定する  例） ()の中 C_CD(顧客コード) 15行目～30行目
	private String d_cd;
	
	@Column(name="D_NAME" ,nullable = false ,columnDefinition = "VARCHAR(20)")
	private String d_name;
	
	@Column(name="UPDATE_DATE" ,columnDefinition = "datetime") 
	private Timestamp update_date;
	
	@Column(name="UPDATE_USER" ,columnDefinition = "VARCHAR(40)")
	private String update_user;
	
	@Column(name="CREATE_DATE" ,columnDefinition = "datetime")
	private Timestamp create_date;
	
	@Column(name="CREATE_USER" ,columnDefinition = "VARCHAR(40)")
	private String create_user;
	
	public String getD_cd() { //ゲッタとセッタ
		return d_cd;
	}
	
	public void setD_cd(String d_cd) {
		this.d_cd = d_cd;
	}
	
	public String getD_name() {
		return d_name;
	}
	public void setD_name(String d_name) {
		this.d_name = d_name;
	}
	
	public void setAll(  String d_cd      //setALLすべての要素を設定する。部署マスターでは、部署コード、部署名を設定する
						,String d_name){
		this.d_cd = d_cd;
		this.d_name = d_name;

	}
	
	public Timestamp getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Timestamp create_date) {
		this.create_date = create_date;
	}
	public String getCreate_user() {
		return create_user;
	}
	public void setCreate_user(String create_user) {
		this.create_user = create_user;
	}
	public Timestamp getUpdate_date() {
		return update_date;
	}
	public void setUpdate_date(Timestamp update_date) {
		this.update_date = update_date;
	}
	public String getUpdate_user() {
		return update_user;
	}
	public void setUpdate_user(String update_user) {
		this.update_user = update_user;
	}

}
