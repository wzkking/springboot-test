package org.wt.book.model;

import java.util.Date;


public class Friends {
    /**
	 * 
	 */
	private static final long serialVersionUID = -8095382111865321874L;


	private Integer id;

    private String phone;

    private Integer sysos;

    private String myCode;

    private String friendcode;

    private String gamelogo;

    private Date createDt;

    private String str1;

    private String str2;

    private String str3;

    private String str4;

    private String str5;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Integer getSysos() {
        return sysos;
    }

    public void setSysos(Integer sysos) {
        this.sysos = sysos;
    }

    public String getMyCode() {
        return myCode;
    }

    public void setMyCode(String myCode) {
        this.myCode = myCode == null ? null : myCode.trim();
    }

    public String getFriendcode() {
        return friendcode;
    }

    public void setFriendcode(String friendcode) {
        this.friendcode = friendcode == null ? null : friendcode.trim();
    }

    public String getGamelogo() {
        return gamelogo;
    }

    public void setGamelogo(String gamelogo) {
        this.gamelogo = gamelogo == null ? null : gamelogo.trim();
    }

    public Date getCreateDt() {
        return createDt;
    }

    public void setCreateDt(Date createDt) {
        this.createDt = createDt;
    }

    public String getStr1() {
        return str1;
    }

    public void setStr1(String str1) {
        this.str1 = str1 == null ? null : str1.trim();
    }

    public String getStr2() {
        return str2;
    }

    public void setStr2(String str2) {
        this.str2 = str2 == null ? null : str2.trim();
    }

    public String getStr3() {
        return str3;
    }

    public void setStr3(String str3) {
        this.str3 = str3 == null ? null : str3.trim();
    }

    public String getStr4() {
        return str4;
    }

    public void setStr4(String str4) {
        this.str4 = str4 == null ? null : str4.trim();
    }

    public String getStr5() {
        return str5;
    }

    public void setStr5(String str5) {
        this.str5 = str5 == null ? null : str5.trim();
    }
}