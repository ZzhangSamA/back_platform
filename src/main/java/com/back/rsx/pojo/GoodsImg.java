package com.back.rsx.pojo;

public class GoodsImg {
    private Integer imgId;

    private Integer goodsId;

    private String goodsImage;

    private Boolean isCover;

    public Integer getImgId() {
        return imgId;
    }

    public void setImgId(Integer imgId) {
        this.imgId = imgId;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsImage() {
        return goodsImage;
    }

    public void setGoodsImage(String goodsImage) {
        this.goodsImage = goodsImage == null ? null : goodsImage.trim();
    }

    public Boolean getIsCover() {
        return isCover;
    }

    public void setIsCover(Boolean isCover) {
        this.isCover = isCover;
    }

    public Boolean getCover() {
        return isCover;
    }

    public void setCover(Boolean cover) {
        isCover = cover;
    }

    @Override
    public String toString() {
        return "GoodsImg{" +
                "imgId=" + imgId +
                ", goodsId=" + goodsId +
                ", goodsImage='" + goodsImage + '\'' +
                ", isCover=" + isCover +
                '}';
    }
}