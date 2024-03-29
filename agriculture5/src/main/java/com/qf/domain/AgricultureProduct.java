package com.qf.domain;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@ApiModel("商品对象")
@Data
public class AgricultureProduct implements Serializable {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "product_id")
        private Integer productId;//产品编号
        @Column(name = "product_name")
        private String productName;//产品名称
        @Column(name = "product_scale")
        private String productScale;//产品规格
        @Column(name = "product_company")
        private String productCompany;//单位/份/盒
        @Column(name = "product_images")
        private String productImages;//'4张',1 备注：映射对应
        @Column(name = "product_content")
        private String productContent;//'产品功能,加农进口香蕉，甜香顺滑'
        @Column(name = "product_comment")
        private String productComment;//评论
        @Column(name = "product_brand")
        private String productBrand;//品牌,蒙牛
        @Column(name = "product_place")
        private String productPlace;//产地
        @Column(name = "product_storage")
        private String productStorage;//储存条件,鲜活
        @Column(name = "product_details_images")
        private String productDetailsImages;//'详情图片*7',2 备注：映射对应
        @Column(name = "product_service")
        private String productService;//'服务图',3 备注：映射对应
        @Column(name = "product_price")
        private BigDecimal productPrice;//单价
        @Column(name = "product_number")
        private String productNumber;//产品数量
        private List<AgriculturePicture> agriculturePictureList;//商品对应的图片信息
        private int aid;

//        @Column(name = "picture_id")
//        private  int prictureId;
//        @Column(name = "picture_url")
//        private  String prictureUrl;
}
