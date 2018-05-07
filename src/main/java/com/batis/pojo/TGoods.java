package com.batis.pojo;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "t_goods")
public class TGoods implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private Float price;

    @Column(name = "goodsName")
    private String goodsname;

    @Column(name = "shopName")
    private String shopname;

    @Column(name = "shopId")
    private String shopid;

    private String origin;

    private String describe;

    private Integer inventory;

    private static final long serialVersionUID = 1L;

    /**
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return price
     */
    public Float getPrice() {
        return price;
    }

    /**
     * @param price
     */
    public void setPrice(Float price) {
        this.price = price;
    }

    /**
     * @return goodsName
     */
    public String getGoodsname() {
        return goodsname;
    }

    /**
     * @param goodsname
     */
    public void setGoodsname(String goodsname) {
        this.goodsname = goodsname;
    }

    /**
     * @return shopName
     */
    public String getShopname() {
        return shopname;
    }

    /**
     * @param shopname
     */
    public void setShopname(String shopname) {
        this.shopname = shopname;
    }

    /**
     * @return shopId
     */
    public String getShopid() {
        return shopid;
    }

    /**
     * @param shopid
     */
    public void setShopid(String shopid) {
        this.shopid = shopid;
    }

    /**
     * @return origin
     */
    public String getOrigin() {
        return origin;
    }

    /**
     * @param origin
     */
    public void setOrigin(String origin) {
        this.origin = origin;
    }

    /**
     * @return describe
     */
    public String getDescribe() {
        return describe;
    }

    /**
     * @param describe
     */
    public void setDescribe(String describe) {
        this.describe = describe;
    }

    /**
     * @return inventory
     */
    public Integer getInventory() {
        return inventory;
    }

    /**
     * @param inventory
     */
    public void setInventory(Integer inventory) {
        this.inventory = inventory;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", price=").append(price);
        sb.append(", goodsname=").append(goodsname);
        sb.append(", shopname=").append(shopname);
        sb.append(", shopid=").append(shopid);
        sb.append(", origin=").append(origin);
        sb.append(", describe=").append(describe);
        sb.append(", inventory=").append(inventory);
        sb.append("]");
        return sb.toString();
    }
}