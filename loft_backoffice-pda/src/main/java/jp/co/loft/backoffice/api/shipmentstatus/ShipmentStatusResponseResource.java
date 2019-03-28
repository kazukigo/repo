package jp.co.loft.backoffice.api.shipmentstatus;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

/**
 * 出荷ステータスのレスポンスリソースクラス。<br>
 * 
 * @author 7NM T. Hayakawa
 */
public class ShipmentStatusResponseResource implements Serializable {

    /** 検品番号 */
    @Getter
    @Setter
    private String inspectionNum;

    /** 注文ステータス */
    @Getter
    @Setter
    private String odrStatus;

    /** 他送り状検品有無フラグ */
    @Getter
    @Setter
    private String isAllInvoicesInspected;

}
