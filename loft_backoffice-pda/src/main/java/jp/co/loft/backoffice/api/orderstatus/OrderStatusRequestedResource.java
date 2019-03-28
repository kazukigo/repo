package jp.co.loft.backoffice.api.orderstatus;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Getter;
import lombok.Setter;

/**
 * 注文ステータスのリクエストリソースクラス。<br>
 * 
 * @author 7NM T. Hayakawa
 */
public class OrderStatusRequestedResource implements Serializable {

    /**
     * Getメソッドに対するバリデーショングループ。<br>
     * 
     * Bean Validationのバリデーショングループを指定するためのインタフェース。<br>
     */
    public static interface GetOrderStatus {
    };

    /** Postメソッドに対するバリデーショングループ。 */
    public static interface PostOrderStatus {
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

    /** 注文番号 */
    @Getter
    @Setter
    @NotNull(groups = GetOrderStatus.class)
    @Pattern(regexp = "[0-9]{14}", groups = GetOrderStatus.class)
    private String odrNum;

    /** 注文ステータス */
    @Getter
    @Setter
    @NotNull(groups = PostOrderStatus.class)
    @Pattern(regexp = "[0-9]{2}", groups = PostOrderStatus.class)
    private String odrStatus;

}
