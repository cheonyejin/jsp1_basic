package project.vo;

public class MenuVo {
    private String mcode;
    private String mname;
    private int mprice;

    public MenuVo(String mcode, String mname, int mprice) {
        this.mcode = mcode;
        this.mname = mname;
        this.mprice = mprice;
    }

    public String getMcode() {
        return mcode;
    }

    public String getMname() {
        return mname;
    }

    public int getMprice() {
        return mprice;
    }


    @Override
    public String toString() {
        return "MenuVo [mcode=" + mcode + ", mname=" + mname + ", mprice=" + mprice + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((mcode == null) ? 0 : mcode.hashCode());
        result = prime * result + ((mname == null) ? 0 : mname.hashCode());
        result = prime * result + mprice;
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
        MenuVo other = (MenuVo) obj;
        if (mcode == null) {
            if (other.mcode != null)
                return false;
        } else if (!mcode.equals(other.mcode))
            return false;
        if (mname == null) {
            if (other.mname != null)
                return false;
        } else if (!mname.equals(other.mname))
            return false;
        if (mprice != other.mprice)
            return false;
        return true;
    }
}
