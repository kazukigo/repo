package jp.co.loft.backoffice.api.common.error;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.context.request.WebRequest;

/**
 * Json形式でレスポンスするエラー情報を作成するクラス。<br>
 * 
 * @author 7NM T. Hayakawa
 * @version 0.1.0
 * @since 0.1.0
 */
@Component
public class ApiErrorCreator {

    /** エラーメッセージをメッセージソースから取得する。 */
    @Autowired
    MessageSource messageSource;

    /**
     * エラー情報作成。<br>
     * Json形式でレスポンスするエラー情報を作成する。<br>
     * 
     * @param request
     *            HTTPリクエスト。<br>
     *            エラーメッセージの中にHTTPリクエストの内容を埋め込む要件が追加された場合を考慮している。<br>
     * @param errorCode
     *            エラーコード。<br>
     *            メッセージプロパティファイルのコードと対応している。<br>
     * @param defaultErrorMessage
     *            デフォルトエラーメッセージ。<br>
     *            メッセージプロパティファイルからエラーコードに対応するエラーメッセージが見つけられない場合にレスポンスする。<br>
     * @param arguments
     *            引数リスト。<br>
     *            エラーメッセージのパラメータに埋め込む。<br>
     * 
     * @return エラー情報。<br>
     */
    public ApiError createApiError(WebRequest request,
                                   String errorCode,
                                   String defaultErrorMessage,
                                   Object... arguments) {
        String localizedMessage = messageSource.getMessage(errorCode,
                                                           arguments,
                                                           defaultErrorMessage,
                                                           request.getLocale());
        return new ApiError(errorCode,
                            localizedMessage);
    }

    /**
     * 入力チェックエラー情報作成。<br>
     * Json形式でレスポンスする入力チェックエラー情報を作成する。<br>
     * 
     * @param request
     *            HTTPリクエスト。<br>
     *            エラーメッセージの中にHTTPリクエストの内容を埋め込む要件が追加された場合を考慮している。<br>
     * @param errorCode
     *            エラーコード。<br>
     *            メッセージプロパティファイルのコードと対応している。<br>
     * @param bindingResult
     *            入力チェック結果。<br>
     * @param defaultErrorMessage
     *            デフォルトエラーメッセージ。<br>
     *            メッセージプロパティファイルからエラーコードに対応するエラーメッセージが見つけられない場合にレスポンスする。<br>
     * 
     * @return エラー情報。<br>
     */
    public ApiError createBindingResultApiError(WebRequest request,
                                                String errorCode,
                                                BindingResult bindingResult,
                                                String defaultErrorMessage) {
        ApiError apiError = createApiError(request,
                                           errorCode,
                                           defaultErrorMessage);
        // 単項目チェックエラーを入力チェックエラー詳細情報に追加。
        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            apiError.addDetail(createApiError(request,
                                              fieldError,
                                              fieldError.getField()));
        }
        // 相関項目チェックエラーを入力チェックエラー詳細情報に追加。
        for (ObjectError objectError : bindingResult.getGlobalErrors()) {
            apiError.addDetail(createApiError(request,
                                              objectError,
                                              objectError.getObjectName()));
        }
        return apiError;
    }

    /**
     * エラー情報作成。<br>
     * Json形式でレスポンスするエラー情報を作成する。<br>
     * 
     * @param request
     *            HTTPリクエスト。<br>
     *            エラーメッセージの中にHTTPリクエストの内容を埋め込む要件が追加された場合を考慮している。<br>
     * @param messageResolvable
     *            エラーメッセージ属性保持オブジェクト。<br>
     *            エラーメッセージを解決するために必要な属性情報を保持するバリューオブジェクト。<br>
     * @param target
     *            入力チェックエラー発生項目。<br>
     *            メッセージプロパティファイルの項目名と対応している。<br>
     * 
     * @return エラー情報。<br>
     */
    private ApiError createApiError(WebRequest request,
                                    DefaultMessageSourceResolvable messageResolvable,
                                    String target) {
        String localizedMessage = messageSource.getMessage(messageResolvable,
                                                           request.getLocale());
        return new ApiError(messageResolvable.getCode(),
                            localizedMessage,
                            target);
    }

}
