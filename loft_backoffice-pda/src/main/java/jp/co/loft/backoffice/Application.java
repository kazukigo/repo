package jp.co.loft.backoffice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * アプリケーションのエントリポイント。<br>
 * "@SpringBootApplication"アノテーションを付けることで、
 * "@Configuration"、"@EnableAutoConfiguration"、"@ComponentScan"を付けたのと同様の設定を行うことができる。<br>
 * "@ComponentScan"を付けることで、このクラスと同じパッケージ以下のクラスを操作する。<br>
 * 対象のパッケージを変更する場合は、basePackages属性で指定する。<br>
 * 
 * @author 7NM R. Nemoto
 * @author 7NM T. Hayakawa
 */
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        /**
         * Spring Bootアプリケーションを起動。<br>
         * 第一引数には"@EnableAutoConfiguration"を付けたクラスを指定する。<br>
         * 返り値は、DIコンテナの本体であるApplicationContextになる。<br>
         */
        SpringApplication.run(Application.class,
                              args);
    }

}
