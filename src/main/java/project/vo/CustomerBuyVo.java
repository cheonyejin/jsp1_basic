package project.vo;

import java.sql.Timestamp;

public class CustomerBuyVo {

    public int buy_idx;
    public String pcode;
    public String pname;
    public int price;
    public int quantity;
    public Timestamp buy_date;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + buy_idx;
        result = prime * result + ((pcode == null) ? 0 : pcode.hashCode());
        result = prime * result + ((pname == null) ? 0 : pname.hashCode());
        result = prime * result + price;
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
        CustomerBuyVo other = (CustomerBuyVo) obj;
        if (buy_idx != other.buy_idx)
            return false;
        if (pcode == null) {
            if (other.pcode != null)
                return false;
        } else if (!pcode.equals(other.pcode))
            return false;
        if (pname == null) {
            if (other.pname != null)
                return false;
        } else if (!pname.equals(other.pname))
            return false;
        if (price != other.price)
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

    public CustomerBuyVo(int buy_idx, String pcode, String pname, int price, int quantity, Timestamp buy_date) {
        this.buy_idx = buy_idx;
        this.pcode = pcode;
        this.pname = pname;
        this.price = price;
        this.quantity = quantity;
        this.buy_date = buy_date;
    }

    public int getBuy_idx() {
        return buy_idx;
    }

    public void setBuy_idx(int buy_idx) {
        this.buy_idx = buy_idx;
    }

    public String getPcode() {
        return pcode;
    }

    public void setPcode(String pcode) {
        this.pcode = pcode;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Timestamp getBuy_date() {
        return buy_date;
    }

    public void setBuy_date(Timestamp buy_date) {
        this.buy_date = buy_date;
    }

    @Override
    public String toString() {
        return String.format("%8d %-15s %-40s\t %,6d %4d %30s", buy_idx, pcode, pname, price, quantity, buy_date);
    }

}
