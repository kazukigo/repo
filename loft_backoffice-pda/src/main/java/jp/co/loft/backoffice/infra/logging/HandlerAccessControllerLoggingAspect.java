package jp.co.loft.backoffice.infra.logging;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * AspectJによるコントローラーアクセスログ出力クラス。<br>
 * AOPを使ってコントローラーへのアクセスを捕捉しログを出力する。<br>
 * 
 * @author 7NM T. Hayakawa
 * @version 0.1.0
 * @since 0.1.0
 */
@Component
// @AspectアノテーションをつけてAspectを定義する。
@Aspect
@Slf4j
public class HandlerAccessControllerLoggingAspect {

    /**
     * AspectJによるコントローラーアクセスログ出力。<br>
     * AOPを使ってコントローラーへのアクセスを捕捉しログを出力する。<br>
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
    // Controllerが対象になるように設定する。
    @Around("execution(* jp.co.loft.backoffice..*Controller.*(..))")
    public Object logException(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("[START]" + joinPoint);

        Object ret = joinPoint.proceed();

        log.info("[END]" + joinPoint);

        return ret;
    }

}
