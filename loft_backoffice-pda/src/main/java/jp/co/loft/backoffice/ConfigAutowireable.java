package jp.co.loft.backoffice;

import org.seasar.doma.AnnotateWith;
import org.seasar.doma.Annotation;
import org.seasar.doma.AnnotationTarget;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 定義した設定クラスのインスタンスがDIコンテナによってインジェクトする。<br>
 * 
 * @author 7NM R. Nemoto
 * @author 7NM T. Hayakawa
 */
@AnnotateWith(annotations = { @Annotation(target = AnnotationTarget.CLASS, type = Component.class),
        @Annotation(target = AnnotationTarget.CONSTRUCTOR, type = Autowired.class) })
public @interface ConfigAutowireable {
}
