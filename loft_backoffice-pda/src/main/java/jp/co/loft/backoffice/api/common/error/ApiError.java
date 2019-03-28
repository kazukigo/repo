package jp.co.loft.backoffice.api.common.error;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;

/**
 * Json形式でレスポンスするエラー情報を格納するクラス。<br>
 * 
 * @author 7NM T. Hayakawa
 * @version 0.1.0
 * @since 0.1.0
 */
public class ApiError {

    /**
     * エラーコード。<br>
     * メッセージプロパティファイルのコードと対応している。<br>
     */
    @Getter
    private final String code;

    /**
     * エラーメッセージ。<br>
     * メッセージプロパティファイルのメッセージと対応している。<br>
     */
    @Getter
    private final String message;

    /**
     * 入力チェックエラー発生項目。<br>
     * メッセージプロパティファイルの項目名と対応している。<br>
     */
    @Getter
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private final String target;

    /**
     * 入力チェックエラー詳細情報。<br>
     * 複数の入力チェックエラー情報を格納する。<br>
     */
    @Getter
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private final List<ApiError> details = new ArrayList<>();

    /**
     * エラーコードおよびエラーメッセージを受け取るApiErrorコンストラクタ。<br>
     * 
     * @param code
     *            エラーコード。<br>
     * @param message
     *            エラーメッセージ。<br>
     */
    public ApiError(String code, String message) {
        this(code,
             message,
             null);
    }

    /**
     * エラーコード、エラーメッセージおよび入力チェックエラー発生項目を受け取るApiErrorコンストラクタ。<br>
     * 
     * @param code
     *            エラーコード。<br>
     * @param message
     *            エラーメッセージ。<br>
     * @param target
     *            入力チェックエラー発生項目。<br>
     */
    public ApiError(String code, String message, String target) {
        this.code = code;
        this.message = message;
        this.target = target;
    }

    /**
     * 入力チェックエラー詳細情報追加。<br>
     * 
     * @param detail
     *            入力チェックエラー詳細情報。<br>
     */
    public void addDetail(ApiError detail) {
        details.add(detail);
    }

}
