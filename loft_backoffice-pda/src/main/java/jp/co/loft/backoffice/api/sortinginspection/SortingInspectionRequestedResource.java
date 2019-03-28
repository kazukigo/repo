package jp.co.loft.backoffice.api.sortinginspection;

import java.io.Serializable;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

/**
 * 仕分検品情報のリクエストリソースクラス。<br>
 * 
 * @author 7NM T. Hayakawa
 * @version 0.1.0
 * @since 0.1.0
 */
public class SortingInspectionRequestedResource implements Serializable {

    /**
     * Getメソッドに対するバリデーショングループ。<br>
     * 
     * Bean Validationのバリデーショングループを指定するためのインタフェース。<br>
     */
    public static interface GetSortingInspections {
    };

    /** Getメソッドに対するバリデーショングループ。 */
    public static interface GetSortingInspection {
    };

    /**
     * Putメソッドに対するバリデーショングループ。<br>
     */
    public static interface PutSortingInspection {
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
    @NotNull(groups = { GetSortingInspections.class, GetSortingInspection.class })
    @Pattern(regexp = "[0-9]{14}", groups = { GetSortingInspections.class, GetSortingInspection.class })
    private String odrNum;

    /** 商品コード */
    @Getter
    @Setter
    @NotNull(groups = GetSortingInspection.class)
    @Size(min = 1, max = 24, groups = GetSortingInspection.class)
    @Pattern(regexp = "[a-zA-Z0-9]*", groups = GetSortingInspection.class)
    private String prdctCd;

    /** 検品数 */
    @Getter
    @Setter
    @NotNull(groups = PutSortingInspection.class)
    @Min(value = 0, groups = PutSortingInspection.class)
    @Max(value = 99999, groups = PutSortingInspection.class)
    private Integer inspectionQntty;

}
