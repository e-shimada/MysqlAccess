


import java.sql.Timestamp; //import名前を宣言  java.sql.Timestampは小数点以下の時間数値(ミリ秒)まで保持することが出来る

import javax.persistence.Column; //javax.persistenceパッケージ
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity //このエンティティはデータベースに新規登録するデータである、該当のクラスがエンティティである @Entity 顧客マスターテーブルという箱
@Table(name="M_CUSTOMER") //@Table 異なるテーブルをマッピング
public class Customer_messagememo {   //customerメソッド
	@Id //@Id プライマリキーとなるプロパティかフィールドを指定する customerマスターテーブルのprimaryはC_CD
	@Column(name="C_CD" ,columnDefinition = "VARCHAR(4)") //@Colum カラム属性を指定する  例） ()の中C_CD(顧客コード) 15行目～37行目
	private String c_num;
	
	@Column(name="C_NAME" ,nullable = false ,columnDefinition = "VARCHAR(100)")
	private String c_name;
	
	@Column(name="ADDRESS" ,columnDefinition = "VARCHAR(256)")
	private String address;
	
	@Column(name="TEL" ,columnDefinition = "VARCHAR(11)") //TEL追加
	private String tel;
	
	@Column(name="UPDATE_DATE" ,columnDefinition = "datetime") 
	private Timestamp update_date;

	@Column(name="UPDATE_USER" ,columnDefinition = "VARCHAR(40)")
	private String update_user;

	@Column(name="CREATE_DATE" ,columnDefinition = "datetime")
	private Timestamp create_date;

	@Column(name="CREATE_USER" ,columnDefinition = "VARCHAR(40)")
	private String create_user;
	
	public String getC_num() { //ゲッタとセッタ
		return c_num;
	}
	public void setC_num(String c_num) {
		this.c_num = c_num;
	}
	public String getC_name() {
		return c_name;
	}
	public void setC_name(String c_name) {
		this.c_name = c_name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}	

	public String getTel() {
		return tel;
	}
	
	public void setTel(String tel) { //TEL追加
		this.tel = tel;
				
	}
	
	public void setAll(  String c_num  //setALLすべての要素を設定する 顧客マスターでは、顧客コード、顧客名、住所、TELを設定する
						,String c_name
						,String address
						,String tel    //TEL追加
						) {
		this.c_num = c_num;
		this.c_name = c_name;
		this.address = address;
		this.tel = tel;                //TEL追加
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
