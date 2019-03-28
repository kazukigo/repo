package jp.co.loft.backoffice.api.sortinginspection;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

/**
 * 仕分検品情報のレスポンスリソースクラス。<br>
 * 
 * @author 7NM T. Hayakawa
 * @version 0.1.0
 * @since 0.1.0
 */
public class SortingInspectionResponseResource implements Serializable {

    /** 注文番号 */
    @Getter
    @Setter
    private String odrNum;

    /** 商品コード */
    @Getter
    @Setter
    private String prdctCd;

    /** 商品名称 */
    @Getter
    @Setter
    private String prdctNm;

    /** 注文数 */
    @Getter
    @Setter
    private Integer odrQntty;

    /** 検品数 */
    @Getter
    @Setter
    private Integer inspectionQntty;

    /** 計上数 */
    @Getter
    @Setter
    private Integer recordedQntty;

}
