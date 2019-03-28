package jp.co.loft.backoffice;

import javax.sql.DataSource;

import org.seasar.doma.jdbc.Config;
import org.seasar.doma.jdbc.NoCacheSqlFileRepository;
import org.seasar.doma.jdbc.SqlFileRepository;
import org.seasar.doma.jdbc.dialect.Dialect;
import org.seasar.doma.jdbc.dialect.OracleDialect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import net.sf.log4jdbc.Log4jdbcProxyDataSource;

/**
 * DIコンテナにBeanを管理させるためのBean定義ファイル。<br>
 * "@Configuration"アノテーションを付けることで、JavaConfig用のクラスであることを示す。<br>
 *
 * @author 7NM R. Nemoto
 * @author 7NM T. Hayakawa
 */
@Configuration
@EnableTransactionManagement
public class AppConfig {

    /**
     * 明示的に設定したデータソース用のプロパティ群(application.yml)を格納するクラスをインジェクションする。<br>
     * "@Autowired"アノテーションを付け、DIコンテナがインジェクションすべきフィールドであることを示す。<br>
     */
    @Autowired
    private DataSourceProperties dataSourceProperties;

    /**
     * データソース。<br>
     * Log4jdbcProxyDataSourceクラスでDataSourceをラップしている。<br>
     * このクラスがDataSourceの各処理に対して、ロギング処理を挟む。<br>
     * また、Doma2のコネクションはSpringの管理外になっているため、実行時例外発生時にRollbackされない。<br>
     * TransactionAwareDataSourceProxyでラップする。<br>
     *
     * DIコンテナに管理させたいBeanを生成するメソッドに"@Bean"アノテーションを付ける。<br>
     * デフォルトでは、メソッド名 = Bean名となる。<br>
     * また、デフォルトでは、生成されたインスタンスはsingletonとして管理され、DIコンテナにつき1インスタンスのみ生成される。<br>
     *
     * @return データソース。<br>
     */
    // @Sqlアノテーションと競合するため、テストコードを流す際は@Beanのみコメントアウトが必要。
    @Bean
    DataSource dataSource() {
        DataSource dataSource = DataSourceBuilder.create(this.dataSourceProperties.getClassLoader()).driverClassName(this.dataSourceProperties.getDriverClassName()).url(this.dataSourceProperties.getUrl()).username(this.dataSourceProperties.getUsername()).password(this.dataSourceProperties.getPassword()).build();

        return new TransactionAwareDataSourceProxy(new Log4jdbcProxyDataSource(dataSource));
    }

    /**
     * トランザクション管理。<br>
     *
     * @return トランザクション管理。<br>
     */
    // @Sqlアノテーションと競合するため、テストコードを流す際は@Beanのみコメントアウトが必要。
    @Bean
    public PlatformTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }

    /**
     * Oracleの方言。<br>
     *
     * @return Oracleの方言。<br>
     */
    @Bean
    public Dialect dialect() {
        return new OracleDialect();
    }

    /**
     * SQLファイルのリポジトリ。<br>
     * キャッシュは行わず、 毎回SQLファイルからSQLを読み取りパースする。<br>
     *
     * @return SQLファイルのリポジトリ。<br>
     */
    @Bean
    public SqlFileRepository sqlFileRepository() {
        return new NoCacheSqlFileRepository();
    }

    @Bean
    public Config config() {
        return new Config() {
            @Override
            public Dialect getDialect() {
                return dialect();
            }

            @Override
            public DataSource getDataSource() {
                return dataSource();
            }

            @Override
            public SqlFileRepository getSqlFileRepository() {
                return sqlFileRepository();
            }
        };
    }

}
