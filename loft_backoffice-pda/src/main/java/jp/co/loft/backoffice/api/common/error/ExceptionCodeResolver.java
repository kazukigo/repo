package jp.co.loft.backoffice.api.common.error;

import org.springframework.stereotype.Component;

import jp.co.loft.backoffice.api.common.message.MessageKeys;

/**
 * エクセプションからエラーコードを解決するクラス。<br>
 * エラーコードはメッセージプロパティファイルのコードと対応している。<br>
 * 
 * @author 7NM T. Hayakawa
 * @version 0.1.0
 * @since 0.1.0
 */
@Component
public class ExceptionCodeResolver {

    /** サポートしていないメソッドをリクエストされたときにスローされます。 */
    private static final String HTTP_REQUEST_METHOD_NOT_SUPPORTED_EXCEPTION = "org.springframework.web.HttpRequestMethodNotSupportedException";
    /** 対象のURLで起動するメソッドが存在しないときにスローされます。 */
    private static final String NO_SUCH_REQUEST_HANDLING_METHOD_EXCEPTION = "org.springframework.web.servlet.mvc.multiaction.NoSuchRequestHandlingMethodException";
    /** リクエストされたメディアタイプを許容できないときにスローされます。 */
    private static final String HTTP_MEDIA_TYPE_NOT_ACCEPTABLE_EXCEPTION = "org.springframework.web.HttpMediaTypeNotAcceptableException";
    /** サポートしていないメディアタイプをリクエストされたときにスローされます。 */
    private static final String HTTP_MEDIA_TYPE_NOT_SUPPORTED_EXCEPTION = "org.springframework.web.HttpMediaTypeNotSupportedException";
    /** "@Valid"が付与されていないときスローされます。 */
    private static final String METHOD_ARGUMENT_NOT_VALID_EXCEPTION = "org.springframework.web.bind.MethodArgumentNotValidException";
    /** バリデーションエラーが発生したときにスローされます。 */
    private static final String BIND_EXCEPTION = "org.springframework.validation.BindException";
    /** リクエストされたパラメータが不足しているときにスローされます。 */
    private static final String MISSING_SERVLET_REQUEST_PARAMETER_EXCEPTION = "org.springframework.web.bind.MissingServletRequestParameterException";
    /** サーブレットのリクエストデータのバインドに失敗したときにスローされます。 */
    private static final String SERVLET_REQUEST_BINDING_EXCEPTION = "org.springframework.web.bind.ServletRequestBindingException";
    /** MessageConverterが読み込めない形式のリクエストのときにスローされます。 */
    private static final String HTTP_MESSAGE_NOT_READABLE_EXCEPTION = "org.springframework.http.converter.HttpMessageNotReadableException";
    /** MessageConverterが書き込めない形式のレスポンスのときにスローされます。 */
    private static final String HTTP_MESSAGE_NOT_WRITABLE_EXCEPTION = "org.springframework.http.converter.HttpMessageNotWritableException";
    /** multipart/form-dataのリクエストの一部が見つからないときにスローされます。 */
    private static final String MISSING_SERVLET_REQUEST_PART_EXCEPTION = "org.springframework.web.multipart.support.MissingServletRequestPartException";
    /** JSONとして不正な構文が含まれる場合に発生する。 */
    private static final String JSON_PARSE_EXCEPTION = "com.fasterxml.jackson.core.JsonParseException";
    /** Resourceオブジェクトに存在しないフィールドがJSONに指定されている場合に発生する。 */
    private static final String UNRECOGNIZED_PROPERTY_EXCEPTION = "com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException";
    /** JSONからResourceオブジェクトへ変換する際に、値の型変換エラーが発生した場合に発生する。 */
    private static final String JSON_MAPPING_EXCEPTION = "com.fasterxml.jackson.core.JsonMappingException";
    /** プロパティに対応するPropertyEditorやMessageConverterが見つからないときにスローされます。 */
    private static final String CONVERSION_NOT_SUPPORTED_EXCEPTION = "org.springframework.beans.ConversionNotSupportedException";
    /** プロパティの型とリクエストデータの型が一致しないときにスローされます。例えば、数値型のプロパティへ文字列をバイドしようとしたときです。 */
    private static final String TYPE_MISMATCH_EXCEPTION = "org.springframework.beans.TypeMismatchException";
    /** リソースが存在しない場合に発生する。 */
    private static final String RESOURCE_NOT_FOUND_EXCEPTION = "jp.co.loft.backoffice.domain.common.error.ResourceNotFoundException";
    /** ビジネスルールの違反を検知した場合に発生する。 */
    private static final String BUSSINESS_EXCEPTION = "jp.co.loft.backoffice.domain.common.error.BussinessException";
    /** 排他エラー(楽観ロック)が発生した場合に発生する。 */
    private static final String OPTIMISTIC_LOCKING_FAILURE_EXCEPTION = "org.springframework.dao.OptimisticLockingFailureException";
    /** 排他エラー(悲観ロック)が発生した場合に発生する。 */
    private static final String PESSIMISTIC_LOCKING_FAILURE_EXCEPTION = "org.springframework.dao.PessimisticLockingFailureException";

    /**
     * エラーコード解決。<br>
     * エクセプションからエラーコードを解決する。<br>
     * 
     * @param ex
     *            エクセプション。<br>
     * 
     * @return エラーコード。<br>
     *         メッセージプロパティファイルのコードと対応している。<br>
     */
    public String resolveExceptionCode(Exception ex) {
        // e.BOA-5001 = システムエラーが発生しました。
        String errorCode = MessageKeys.E_BOA_5001;
        switch (ex.getClass().getName()) {
        // w.BOA-V101 = 指定されたHttpメソッドはサポートされていません。
        case HTTP_REQUEST_METHOD_NOT_SUPPORTED_EXCEPTION:
            errorCode = MessageKeys.W_BOA_V101;
            break;
        // w.BOA-V102 = 指定されたAPIメソッドはサポートされていません。
        case NO_SUCH_REQUEST_HANDLING_METHOD_EXCEPTION:
            errorCode = MessageKeys.W_BOA_V102;
            break;
        // w.BOA-V103 = 指定されたHttpメディアタイプ形式はサポートされていません。
        case HTTP_MEDIA_TYPE_NOT_ACCEPTABLE_EXCEPTION:
            errorCode = MessageKeys.W_BOA_V103;
            break;
        // w.BOA-V104 = 指定されたリクエストボディに含まれるHttpメディアタイプはサポートされていません。
        case HTTP_MEDIA_TYPE_NOT_SUPPORTED_EXCEPTION:
            errorCode = MessageKeys.W_BOA_V104;
            break;
        // w.BOA-V105 = 指定されたリクエストボディに不正な値が設定された項目があります。
        case METHOD_ARGUMENT_NOT_VALID_EXCEPTION:
            errorCode = MessageKeys.W_BOA_V105;
            break;
        // w.BOA-V106 = 指定された検索条件に不正な項目が設定されています。
        case BIND_EXCEPTION:
            errorCode = MessageKeys.W_BOA_V106;
            break;
        // w.BOA-V107 = 指定されたリクエストボディに不正な値が設定された項目があります。
        case MISSING_SERVLET_REQUEST_PARAMETER_EXCEPTION:
            errorCode = MessageKeys.W_BOA_V107;
            break;
        // w.BOA-V108 = リクエストデータのバインドに失敗しました。
        case SERVLET_REQUEST_BINDING_EXCEPTION:
            errorCode = MessageKeys.W_BOA_V108;
            break;
        // w.BOA-V109 = 指定されたJSONやXMLに構文不正やスキーマ定義違反があります。
        case HTTP_MESSAGE_NOT_READABLE_EXCEPTION:
            errorCode = MessageKeys.W_BOA_V109;
            break;
        // w.BOA-V110 = JSONやXMLに構文不正やスキーマ定義違反があります。
        case HTTP_MESSAGE_NOT_WRITABLE_EXCEPTION:
            errorCode = MessageKeys.W_BOA_V110;
            break;
        // w.BOA-V111 = 指定されたリクエストパラメータが見つかりません。
        case MISSING_SERVLET_REQUEST_PART_EXCEPTION:
            errorCode = MessageKeys.W_BOA_V111;
            break;
        // w.BOA-V112 = 指定されたJSONボディ形式は不正に設定されています。
        case JSON_PARSE_EXCEPTION:
            errorCode = MessageKeys.W_BOA_V112;
            break;
        // w.BOA-V113 = 指定されたJSONに不正な項目が設定されています。
        case UNRECOGNIZED_PROPERTY_EXCEPTION:
            errorCode = MessageKeys.W_BOA_V113;
            break;
        // w.BOA-V114 = 指定されたJSONに不正な型が設定されています。
        case JSON_MAPPING_EXCEPTION:
            errorCode = MessageKeys.W_BOA_V114;
            break;
        // w.BOA-V115 = 指定されたメッセージ変換はサポートされていません。
        case CONVERSION_NOT_SUPPORTED_EXCEPTION:
            errorCode = MessageKeys.W_BOA_V115;
            break;
        // w.BOA-V116 = 指定されたリクエストパラメータ、リクエストヘッダ、パス変数に不正な型が設定されています。
        case TYPE_MISMATCH_EXCEPTION:
            errorCode = MessageKeys.W_BOA_V116;
            break;
        // w.BOA-D101 = 指定されたリソースが見つかりません。
        case RESOURCE_NOT_FOUND_EXCEPTION:
            errorCode = MessageKeys.W_BOA_D101;
            break;
        // w.BOA-D102 = 業務エラーが発生しました。
        case BUSSINESS_EXCEPTION:
            errorCode = MessageKeys.W_BOA_D102;
            break;
        // w.BOA-D103 = 排他エラーが発生しました。
        case OPTIMISTIC_LOCKING_FAILURE_EXCEPTION:
            errorCode = MessageKeys.W_BOA_D103;
            break;
        // w.BOA-D104 = 排他エラーが発生しました。
        case PESSIMISTIC_LOCKING_FAILURE_EXCEPTION:
            errorCode = MessageKeys.W_BOA_D104;
            break;
        default:
            break;
        }

        return errorCode;
    }

}
