package project.vo;

import java.util.Date;
//VO - 필드 , 생성자 , get , toString ,hashcode, equals

/**
 * tbl_buy 테이블의 필드와 1:1 매칭하는 변수로 정의합니다
 */
public class BuyVo {

    public int buy_idx;
    public String customId;
    public String pcode;
    public int quantity;
    public Date buy_date;

    public BuyVo(int buy_idx, String customId, String pcode, int quantity, Date buy_date) {
        this.buy_idx = buy_idx;
        this.customId = customId;
        this.pcode = pcode;
        this.quantity = quantity;
        this.buy_date = buy_date;
    }

    public int getBuy_idx() {
        return buy_idx;
    }

    public String getCustomId() {
        return customId;
    }

    public String getPcode() {
        return pcode;
    }

    public int getQuantity() {
        return quantity;
    }

    public Date getBuy_date() {
        return buy_date;
    }

    public void setBuy_idx(int buy_idx) {
        this.buy_idx = buy_idx;
    }

    public void setCustomId(String customId) {
        this.customId = customId;
    }

    public void setPcode(String pCode) {
        this.pcode = pCode;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setBuy_date(Date buy_date) {
        this.buy_date = buy_date;
    }

    @Override
    public String toString() {
        return "BuyVO [buy_idx=" + buy_idx + ", customId=" + customId + ", pcode=" + pcode + ", quantity=" + quantity
                + ", buy_date=" + buy_date + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + buy_idx;
        result = prime * result + ((customId == null) ? 0 : customId.hashCode());
        result = prime * result + ((pcode == null) ? 0 : pcode.hashCode());
        result = prime * result + quantity;
        result = prime * result + ((buy_date == null) ? 0 : buy_date.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        BuyVo other = (BuyVo) obj;
        if (buy_idx != other.buy_idx)
            return false;
        if (customId == null) {
            if (other.customId != null)
                return false;
        } else if (!customId.equals(other.customId))
            return false;
        if (pcode == null) {
            if (other.pcode != null)
                return false;
        } else if (!pcode.equals(other.pcode))
            return false;
        if (quantity != other.quantity)
            return false;
        if (buy_date == null) {
            if (other.buy_date != null)
                return false;
        } else if (!buy_date.equals(other.buy_date))
            return false;
        return true;
    }

}
