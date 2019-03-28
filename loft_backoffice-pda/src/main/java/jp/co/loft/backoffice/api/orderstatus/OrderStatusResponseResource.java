package jp.co.loft.backoffice.api.orderstatus;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

/**
 * 注文ステータスのレスポンスリソースクラス。<br>
 * 
 * @author 7NM T. Hayakawa
 */
public class OrderStatusResponseResource implements Serializable {

    /** 注文番号 */
    @Getter
    @Setter
    private String odrNum;

    /** 注文明細数(アイテム数) */
    @Getter
    @Setter
    private Integer odrLineQntty;

    /** 出荷元店舗コード */
    @Getter
    @Setter
    private String consignorShopCd;

    /** 出荷先店舗コード */
    @Getter
    @Setter
    private String consigneeShopCd;

    /** 注文ステータス */
    @Getter
    @Setter
    private String odrStatus;

}
