package project.vo;

import java.sql.Timestamp;

public class MemberBuyVo {

    // buy_index, menu_id, mname,mprice,menu_quantity ,buy_date

    private int buy_idx;
    private String customer_id;
    private String mname;
    private String menu_id;
    private int menu_quantity;
    private int mprice;
    private Timestamp buy_Date;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + buy_idx;
        result = prime * result + ((customer_id == null) ? 0 : customer_id.hashCode());
        result = prime * result + ((mname == null) ? 0 : mname.hashCode());
        result = prime * result + ((menu_id == null) ? 0 : menu_id.hashCode());
        result = prime * result + menu_quantity;
        result = prime * result + mprice;
        result = prime * result + ((buy_Date == null) ? 0 : buy_Date.hashCode());
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
        MemberBuyVo other = (MemberBuyVo) obj;
        if (buy_idx != other.buy_idx)
            return false;
        if (customer_id == null) {
            if (other.customer_id != null)
                return false;
        } else if (!customer_id.equals(other.customer_id))
            return false;
        if (mname == null) {
            if (other.mname != null)
                return false;
        } else if (!mname.equals(other.mname))
            return false;
        if (menu_id == null) {
            if (other.menu_id != null)
                return false;
        } else if (!menu_id.equals(other.menu_id))
            return false;
        if (menu_quantity != other.menu_quantity)
            return false;
        if (mprice != other.mprice)
            return false;
        if (buy_Date == null) {
            if (other.buy_Date != null)
                return false;
        } else if (!buy_Date.equals(other.buy_Date))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "구매번호:" + buy_idx + " 고객아이디:" + customer_id + " 제품이름:" + mname + " 제품번호:" + menu_id + " 수량"
                + menu_quantity + " 가격:" + mprice + " 구매날짜:" + buy_Date;
    }

    public MemberBuyVo(int buy_idx, String customer_id, String mname, String menu_id, int menu_quantity, int mprice,
            Timestamp buy_Date) {
        this.buy_idx = buy_idx;
        this.customer_id = customer_id;
        this.mname = mname;
        this.menu_id = menu_id;
        this.menu_quantity = menu_quantity;
        this.mprice = mprice;
        this.buy_Date = buy_Date;
    }

    // sql로 선언해야됨
    public int getBuy_idx() {
        return buy_idx;
    }

    public void setBuy_idx(int buy_idx) {
        this.buy_idx = buy_idx;
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getMenu_id() {
        return menu_id;
    }

    public void setMenu_id(String menu_id) {
        this.menu_id = menu_id;
    }

    public int getMenu_quantity() {
        return menu_quantity;
    }

    public void setMenu_quantity(int menu_quantity) {
        this.menu_quantity = menu_quantity;
    }

    public int getMprice() {
        return mprice;
    }

    public void setMprice(int mprice) {
        this.mprice = mprice;
    }

    public Timestamp getBuy_Date() {
        return buy_Date;
    }

    public void setBuy_Date(Timestamp buy_Date) {
        this.buy_Date = buy_Date;
    }

}