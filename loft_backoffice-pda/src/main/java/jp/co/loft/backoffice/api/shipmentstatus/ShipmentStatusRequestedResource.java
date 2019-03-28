package jp.co.loft.backoffice.api.shipmentstatus;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

/**
 * 出荷ステータスのリクエストリソースクラス。<br>
 * 
 * @author 7NM T. Hayakawa
 */
public class ShipmentStatusRequestedResource implements Serializable {

    /**
     * Getメソッドに対するバリデーショングループ。<br>
     * 
     * Bean Validationのバリデーショングループを指定するためのインタフェース。<br>
     */
    public static interface GetShipmentStatus {
    };

    /** Putメソッドに対するバリデーショングループ。 */
    public static interface PutShipmentStatus {
    };

    /** 店舗コード */
    @Getter
    @Setter
    @NotNull
    @Pattern(regexp = "[0-9]{4}")
    private String shopCd;

    /** 端末No */
    @Getter
    @Setter
    @NotNull
    @Pattern(regexp = "[0-9]{4}")
    private String terminalNum;

    /** ユーザーID */
    @Getter
    @Setter
    @NotNull
    @Pattern(regexp = "[0-9]{10}")
    private String userId;

    /** 検品番号 */
    @Getter
    @Setter
    @NotNull(groups = GetShipmentStatus.class)
    @Size(min = 1, max = 20, groups = GetShipmentStatus.class)
    @Pattern(regexp = "[a-zA-Z0-9]*")
    private String inspectionNum;

    /** 出荷検品状況 */
    @Getter
    @Setter
    @NotNull(groups = PutShipmentStatus.class)
    @Pattern(regexp = "[0-9]{1}", groups = PutShipmentStatus.class)
    private String shipmentKbn;

}
