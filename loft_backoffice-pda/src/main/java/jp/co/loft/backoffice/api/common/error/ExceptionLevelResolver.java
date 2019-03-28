package jp.co.loft.backoffice.api.common.error;

import org.springframework.stereotype.Component;

/**
 * エラーコードからエラーレベルを解決するクラス。<br>
 * エラーコードはメッセージプロパティファイルのコードと対応している。<br>
 * 
 * @author 7NM T. Hayakawa
 * @version 0.1.0
 * @since 0.1.0
 */
@Component
public class ExceptionLevelResolver {

    /**
     * エクセプションレベルEnumクラス。<br>
     * 
     * @author 7NM T. Hayakawa
     */
    public enum ExceptionLevel {
        /** INFOレベル */
        INFO, /** WARNレベル */
        WARN, /** ERRORレベル */
        ERROR
    }

    /**
     * エラーレベル解決。<br>
     * エラーコードからエラーレベルを解決する。<br>
     * 
     * @param errorCode
     *            エラーコード。<br>
     *            メッセージプロパティファイルのコードと対応している。<br>
     * 
     * @return エラーレベル。<br>
     */
    public ExceptionLevel resolveExceptionLevel(String errorCode) {
        // エラーコードが""の場合、エクセプションレベルをERRORとする。
        if ("".equals(errorCode)) {
            return ExceptionLevel.ERROR;
        }
        String errorCodePrefix = errorCode.substring(0,
                                                     1);
        // エラーコードの頭文字が"e"の場合、エクセプションレベルをERRORとする。
        if ("e".equalsIgnoreCase(errorCodePrefix)) {
            return ExceptionLevel.ERROR;
        }
        // エラーコードの頭文字が"w"の場合、エクセプションレベルをWARNとする。
        if ("w".equalsIgnoreCase(errorCodePrefix)) {
            return ExceptionLevel.WARN;
        }
        // エラーコードの頭文字が"i"の場合、エクセプションレベルをINFOとする。
        if ("i".equalsIgnoreCase(errorCodePrefix)) {
            return ExceptionLevel.INFO;
        }

        // デフォルトのエクセプションレベルをERRORとする。
        return ExceptionLevel.ERROR;
    }

}
