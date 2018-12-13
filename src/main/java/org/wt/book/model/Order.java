package org.wt.book.model;

import java.util.Date;


public class Order{
    private Integer id;

    private Integer userid;

    private Integer bookdid;

    private Integer goodsid;

    private Integer txnat;

    private Double discount;

    private String orderno;

    private String mchid;

    private String feetype;

    private String userip;

    private String timestart;

    private String timeexpire;

    private String appid;

    private Integer feetotal;

    private Integer oderstatu;

    private Integer paystatu;

    private Integer actstatu;

    private Date createdt;

    private Date lastdt;

    private String tranno;

    private String paytimeend;

    private String signtype;

    private String str1;

    private String str2;

    private String str3;

    private String str4;

    private String str5;

    private String str6;

    private String str7;

    private String str8;

    private String str9;

    private String str10;
    
    //附加字段
    private String method;
    private String charset;
    private String sign_type;
    private String timestamp;
    private String version;
    private String notify_url;
    private String biz_content;
    
    private Integer beginindex;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getBookdid() {
        return bookdid;
    }

    public void setBookdid(Integer bookdid) {
        this.bookdid = bookdid;
    }

    public Integer getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(Integer goodsid) {
        this.goodsid = goodsid;
    }

    public Integer getTxnat() {
        return txnat;
    }

    public void setTxnat(Integer txnat) {
        this.txnat = txnat;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public String getOrderno() {
        return orderno;
    }

    public void setOrderno(String orderno) {
        this.orderno = orderno == null ? null : orderno.trim();
    }

    public String getMchid() {
        return mchid;
    }

    public void setMchid(String mchid) {
        this.mchid = mchid == null ? null : mchid.trim();
    }

    public String getFeetype() {
        return feetype;
    }

    public void setFeetype(String feetype) {
        this.feetype = feetype == null ? null : feetype.trim();
    }

    public String getUserip() {
        return userip;
    }

    public void setUserip(String userip) {
        this.userip = userip == null ? null : userip.trim();
    }

    public String getTimestart() {
        return timestart;
    }

    public void setTimestart(String timestart) {
        this.timestart = timestart == null ? null : timestart.trim();
    }

    public String getTimeexpire() {
        return timeexpire;
    }

    public void setTimeexpire(String timeexpire) {
        this.timeexpire = timeexpire == null ? null : timeexpire.trim();
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid == null ? null : appid.trim();
    }

    public Integer getFeetotal() {
        return feetotal;
    }

    public void setFeetotal(Integer feetotal) {
        this.feetotal = feetotal;
    }

    public Integer getOderstatu() {
        return oderstatu;
    }

    public void setOderstatu(Integer oderstatu) {
        this.oderstatu = oderstatu;
    }

    public Integer getPaystatu() {
        return paystatu;
    }

    public void setPaystatu(Integer paystatu) {
        this.paystatu = paystatu;
    }

    public Integer getActstatu() {
        return actstatu;
    }

    public void setActstatu(Integer actstatu) {
        this.actstatu = actstatu;
    }

    public Date getCreatedt() {
        return createdt;
    }

    public void setCreatedt(Date createdt) {
        this.createdt = createdt;
    }

    public Date getLastdt() {
        return lastdt;
    }

    public void setLastdt(Date lastdt) {
        this.lastdt = lastdt;
    }

    public String getTranno() {
        return tranno;
    }

    public void setTranno(String tranno) {
        this.tranno = tranno == null ? null : tranno.trim();
    }

    public String getPaytimeend() {
        return paytimeend;
    }

    public void setPaytimeend(String paytimeend) {
        this.paytimeend = paytimeend == null ? null : paytimeend.trim();
    }

    public String getSigntype() {
        return signtype;
    }

    public void setSigntype(String signtype) {
        this.signtype = signtype == null ? null : signtype.trim();
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

    public String getStr6() {
        return str6;
    }

    public void setStr6(String str6) {
        this.str6 = str6 == null ? null : str6.trim();
    }

    public String getStr7() {
        return str7;
    }

    public void setStr7(String str7) {
        this.str7 = str7 == null ? null : str7.trim();
    }

    public String getStr8() {
        return str8;
    }

    public void setStr8(String str8) {
        this.str8 = str8 == null ? null : str8.trim();
    }

    public String getStr9() {
        return str9;
    }

    public void setStr9(String str9) {
        this.str9 = str9 == null ? null : str9.trim();
    }

    public String getStr10() {
        return str10;
    }

    public void setStr10(String str10) {
        this.str10 = str10 == null ? null : str10.trim();
    }

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getCharset() {
		return charset;
	}

	public void setCharset(String charset) {
		this.charset = charset;
	}

	public String getSign_type() {
		return sign_type;
	}

	public void setSign_type(String sign_type) {
		this.sign_type = sign_type;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getNotify_url() {
		return notify_url;
	}

	public void setNotify_url(String notify_url) {
		this.notify_url = notify_url;
	}

	public String getBiz_content() {
		return biz_content;
	}

	public void setBiz_content(String biz_content) {
		this.biz_content = biz_content;
	}

	public Integer getBeginindex() {
		return beginindex;
	}

	public void setBeginindex(Integer beginindex) {
		this.beginindex = beginindex;
	}
	
	
}