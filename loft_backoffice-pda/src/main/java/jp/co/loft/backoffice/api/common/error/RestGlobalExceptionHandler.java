package jp.co.loft.backoffice.api.common.error;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.dao.PessimisticLockingFailureException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import jp.co.loft.backoffice.domain.common.error.BusinessException;
import jp.co.loft.backoffice.domain.common.error.ResourceNotFoundException;

/**
 * レスポンスBodyにエラー情報を出力するクラス。<br>
 * Spring MVCから提供されているResponseEntityExceptionHandlerを継承している。<br>
 * 
 * @author 7NM T. Hayakawa
 * @version 0.1.0
 * @since 0.1.0
 */
@ControllerAdvice
public class RestGlobalExceptionHandler extends ResponseEntityExceptionHandler {

    /** Json形式でレスポンスするエラー情報を作成する。 */
    @Autowired
    ApiErrorCreator apiErrorCreator;
    /** エクセプションからエラーコードを解決する。 */
    @Autowired
    ExceptionCodeResolver exceptionCodeResolver;

    /**
     * エラー情報レスポンス。<br>
     * すべてのエクセプションに対するレスポンスをカスタマイズする。<br>
     * 
     * @param ex
     *            エクセプション。<br>
     * @param body
     *            レスポンスボディに出力する情報。<br>
     * @param headers
     *            レスポンスヘッダに出力する情報。<br>
     * @param status
     *            レスポンスするHTTPステータス情報。<br>
     * @param request
     *            HTTPリクエスト。<br>
     *            エラーメッセージの中にHTTPリクエストの内容を埋め込む要件が追加された場合を考慮している。<br>
     * 
     * @return HTTPレスポンス。<br>
     */
    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex,
                                                             Object body,
                                                             HttpHeaders headers,
                                                             HttpStatus status,
                                                             WebRequest request) {
        final Object apiError;
        // レスポンスボディに出力するJavaBeanの指定がない場合は、エラー情報を保持するJavaBeanオブジェクトを生成する。
        // レスポンスボディに出力するJavaBeanの指定がある場合は、指定されたJavaBeanをそのまま使用する。
        if (body == null) {
            String errorCode = exceptionCodeResolver.resolveExceptionCode(ex);
            apiError = apiErrorCreator.createApiError(request,
                                                      errorCode,
                                                      ex.getLocalizedMessage());
        } else {
            apiError = body;
        }

        // レスポンス用のHTTPエンティティのボディ部分に、上記で生成したエラー情報を設定し返却する。
        // 返却したエラー情報は、フレームワークによってJSONに変換されレスポンスされる。
        // ステータスコードには、Spring MVCから提供されているResponseEntityExceptionHandlerによって適切な値が設定される。
        return ResponseEntity.status(status).headers(headers).body(apiError);
    }

    /**
     * MethodArgumentNotValidException情報レスポンス。<br>
     * リクエストBODYに指定されたJSONやXMLに対する入力チェックでエラーが発生した場合、本例外が発生する。<br>
     * 具体的には、リソースのPOST又はPUT時に指定するリソースに不正な値が指定されている場合に発生する。<br>
     * 項目毎のエラー情報を出力するためオーバライドしている。<br>
     * 
     * @param ex
     *            MethodArgumentNotValidException。<br>
     * @param headers
     *            レスポンスヘッダに出力する情報。<br>
     * @param status
     *            レスポンスするHTTPステータス情報。<br>
     * @param request
     *            HTTPリクエスト。<br>
     *            エラーメッセージの中にHTTPリクエストの内容を埋め込む要件が追加された場合を考慮している。<br>
     * 
     * @return HTTPレスポンス。<br>
     */
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatus status,
                                                                  WebRequest request) {
        return handleBindingResult(ex,
                                   ex.getBindingResult(),
                                   headers,
                                   status,
                                   request);
    }

    /**
     * BindException情報レスポンス。<br>
     * リクエストパラメータ(key=value形式のクエリ文字列)に対する入力チェックでエラーが発生した場合、本例外が発生する。<br>
     * 具体的には、リソースコレクションのGET時に指定する検索条件に不正な値が指定されている場合に発生する。<br>
     * 項目毎のエラー情報を出力するためオーバライドしている。<br>
     * 
     * @param ex
     *            BindException。<br>
     * @param headers
     *            レスポンスヘッダに出力する情報。<br>
     * @param status
     *            レスポンスするHTTPステータス情報。<br>
     * @param request
     *            HTTPリクエスト。<br>
     *            エラーメッセージの中にHTTPリクエストの内容を埋め込む要件が追加された場合を考慮している。<br>
     * 
     * @return HTTPレスポンス。<br>
     */
    @Override
    protected ResponseEntity<Object> handleBindException(BindException ex,
                                                         HttpHeaders headers,
                                                         HttpStatus status,
                                                         WebRequest request) {
        return handleBindingResult(ex,
                                   ex.getBindingResult(),
                                   headers,
                                   status,
                                   request);
    }

    /**
     * 入力チェックエラー情報作成。<br>
     * 入力チェックエラーのエラー情報を保持するJavaBeanオブジェクトを生成する。<br>
     * 
     * @param ex
     *            エクセプション。<br>
     * @param bindingResult
     * @param headers
     *            レスポンスヘッダに出力する情報。<br>
     * @param status
     *            レスポンスするHTTPステータス情報。<br>
     * @param request
     *            HTTPリクエスト。<br>
     *            エラーメッセージの中にHTTPリクエストの内容を埋め込む要件が追加された場合を考慮している。<br>
     * 
     * @return HTTPレスポンス。<br>
     */
    private ResponseEntity<Object> handleBindingResult(Exception ex,
                                                       BindingResult bindingResult,
                                                       HttpHeaders headers,
                                                       HttpStatus status,
                                                       WebRequest request) {
        String errorCode = exceptionCodeResolver.resolveExceptionCode(ex);
        ApiError apiError = apiErrorCreator.createBindingResultApiError(request,
                                                                        errorCode,
                                                                        bindingResult,
                                                                        ex.getMessage());

        return handleExceptionInternal(ex,
                                       apiError,
                                       headers,
                                       status,
                                       request);
    }

    /**
     * リソース未検出エラー情報レスポンス。<br>
     * ResourceNotFoundExceptionの例外をハンドリングする。<br>
     * ステータスコードには404(Not Found)を設定し、指定されたリソースがサーバに存在しない事を通知する。<br>
     * 
     * @param ex
     *            ResourceNotFoundException。<br>
     * @param request
     *            HTTPリクエスト。<br>
     *            エラーメッセージの中にHTTPリクエストの内容を埋め込む要件が追加された場合を考慮している。<br>
     * 
     * @return HTTPレスポンス。<br>
     */
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Object> handleResourceNotFoundException(ResourceNotFoundException ex,
                                                                  WebRequest request) {
        return handleExceptionInternal(ex,
                                       null,
                                       new HttpHeaders(),
                                       HttpStatus.NOT_FOUND,
                                       request);
    }

    /**
     * 業務エラー情報レスポンス。<br>
     * BusinessExceptionの例外をハンドリングする。<br>
     * ステータスコードには409(Conflict)を設定し、クライアントから指定されたリソース自体には不備はないが、サーバで保持しているリソースを操作するための条件が全て整っていない事を通知する。<br>
     * 
     * @param ex
     *            BusinessException。<br>
     * @param request
     *            HTTPリクエスト。<br>
     *            エラーメッセージの中にHTTPリクエストの内容を埋め込む要件が追加された場合を考慮している。<br>
     * 
     * @return HTTPレスポンス。<br>
     */
    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<Object> handleBusinessException(BusinessException ex,
                                                          WebRequest request) {
        return handleExceptionInternal(ex,
                                       null,
                                       new HttpHeaders(),
                                       HttpStatus.CONFLICT,
                                       request);
    }

    /**
     * 排他エラー情報レスポンス。<br>
     * 排他エラー(OptimisticLockingFailureExceptionとPessimisticLockingFailureException)の例外をハンドリングする。<br>
     * ステータスコードには409(Conflict)を設定し、クライアントから指定されたリソース自体には不備はないが、処理が競合したためリソースを操作するための条件を満たすことが出来なかった事を通知する。<br>
     * 
     * @param ex
     *            OptimisticLockingFailureException。<br>
     *            PessimisticLockingFailureException。<br>
     * @param request
     *            HTTPリクエスト。<br>
     *            エラーメッセージの中にHTTPリクエストの内容を埋め込む要件が追加された場合を考慮している。<br>
     * 
     * @return HTTPレスポンス。<br>
     */
    @ExceptionHandler({ OptimisticLockingFailureException.class, PessimisticLockingFailureException.class })
    public ResponseEntity<Object> handleLockingFailureException(Exception ex,
                                                                WebRequest request) {
        return handleExceptionInternal(ex,
                                       null,
                                       new HttpHeaders(),
                                       HttpStatus.CONFLICT,
                                       request);
    }

    /**
     * システムエラー情報レスポンス。<br>
     * Exceptionの例外をハンドリングする。<br>
     * 使用している依存ライブラリから発生するシステム例外もハンドリング対象としている。<br>
     * ステータスコードには500(Internal Server Error)を設定する。<br>
     * 
     * @param ex
     *            エクセプション。<br>
     * @param request
     *            HTTPリクエスト。<br>
     *            エラーメッセージの中にHTTPリクエストの内容を埋め込む要件が追加された場合を考慮している。<br>
     * 
     * @return HTTPレスポンス。<br>
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleSystemError(Exception ex,
                                                    WebRequest request) {
        return handleExceptionInternal(ex,
                                       null,
                                       new HttpHeaders(),
                                       HttpStatus.INTERNAL_SERVER_ERROR,
                                       request);
    }

}
