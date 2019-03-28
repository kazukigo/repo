package jp.co.loft.backoffice.infra.logging;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jp.co.loft.backoffice.api.common.error.ExceptionCodeResolver;
import jp.co.loft.backoffice.api.common.error.ExceptionLevelResolver;
import jp.co.loft.backoffice.api.common.error.ExceptionLevelResolver.ExceptionLevel;
import lombok.extern.slf4j.Slf4j;

/**
 * AspectJによるエラーログ出力クラス。<br>
 * AOPを使ってエラーを捕捉しログを出力する。<br>
 * 
 * @author 7NM T. Hayakawa
 * @version 0.1.0
 * @since 0.1.0
 */
@Component
// @AspectアノテーションをつけてAspectを定義する。
@Aspect
@Slf4j
public class HandlerExceptionResolverLoggingAspect {

    /** エクセプションからエラーコードを解決する。 */
    @Autowired
    ExceptionCodeResolver exceptionCodeResolver;
    /** エクセプションからエラーレベルを解決する。 */
    @Autowired
    ExceptionLevelResolver exceptionLevelResolver;

    /** HandlerExceptionResolver#resolveExceptionメソッドは複数回呼ばれる可能性があるため、マークをつけて複数回呼ばれないようにする。 */
    private static final String ERROR_LOGGED = "ERROR_LOGGED";

    /**
     * AspectJによるエラーログ出力。<br>
     * AOPを使ってエラーを捕捉しログを出力する。<br>
     * 
     * @param joinPoint
     *            JoinPoint情報。<br>
     *            JoinPoint情報から、実行されたメソッドの情報を取得できる。ここでは引数を取得する。<br>
     * 
     * @return
     * 
     * @throws Throwable
     */
    // @AroundアノテーションをつけてAroundアドバイスを定義する。
    // HandlerExceptionResolver#resolveExceptionメソッドが対象になるように設定する。
    @Around("execution(* org.springframework.web.servlet.HandlerExceptionResolver.resolveException(..))")
    public Object logException(ProceedingJoinPoint joinPoint) throws Throwable {
        Object ret = joinPoint.proceed();
        HttpServletRequest request = (HttpServletRequest) joinPoint.getArgs()[0];

        if (request.getAttribute(ERROR_LOGGED) == null) {
            Object handler = joinPoint.getArgs()[2];
            Exception exception = (Exception) joinPoint.getArgs()[3];

            String errorCode = exceptionCodeResolver.resolveExceptionCode(exception);
            ExceptionLevel errorLevel = exceptionLevelResolver.resolveExceptionLevel(errorCode);
            String message = "[" + request.getRequestURI() + "]" + "\t" + request.getMethod() + "\t" + errorCode + "\t"
                    + exception.getMessage() + "\t" + handler;
            switch (errorLevel) {
            case ERROR:
                log.error(message,
                          exception);
                break;
            case WARN:
                log.warn(message,
                         exception);
                break;
            case INFO:
                log.info(message,
                         exception);
                break;
            default:
                log.error(message,
                          exception);
                break;
            }

            // HandlerExceptionResolver#resolveExceptionメソッドは複数回呼ばれる可能性があるため、マークをつけて複数回呼ばれないようにする。
            request.setAttribute(ERROR_LOGGED,
                                 true);
        }

        return ret;
    }

}
