package jp.co.loft.backoffice.api.shipmentstatus;

import static com.jayway.restassured.RestAssured.given;
import static com.jayway.restassured.RestAssured.when;
import static org.hamcrest.CoreMatchers.is;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;

import jp.co.loft.backoffice.Application;
import jp.co.loft.backoffice.api.common.error.ApiError;

/**
 * 出荷ステータス情報のRestControllerクラス。 出荷検品業務におけるPDA端末からのリクエストを受け取る。
 * 
 * @author 7NM T. Hayakawa
 * @version 0.1.0
 * @since 0.1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest({ "server.port:0",
        "spring.datasource.url:jdbc:oracle:thin:@(DESCRIPTION=(ADDRESS=(PROTOCOL=TCP)(HOST=localhost)(PORT=1521))(CONNECT_DATA=(SERVICE_NAME=XE)))" })
@Sql(scripts = { "/db/migration/truncate_t_shipment_status.sql", "/db/migration/insert_t_shipment_status.sql",
        "/db/migration/truncate_t_order_status.sql", "/db/migration/insert_t_order_status.sql" })
public class ShipmentStatusRestControllerTest {

    private static final String NULL_STRING = "null";

    // Rest-assuredで利用するポート。
    @Value("${local.server.port}")
    int port;
    // Input(パス変数)となるオブジェクト。
    ShipmentStatusRequestedResource inputPathVariable;
    // Input(ボディ)となるオブジェクト。
    ShipmentStatusRequestedResource inputBody;
    // 正常系のExpected(期待値)となるオブジェクト。
    ShipmentStatusResponseResource expectedBody;
    // 準正常系のExpected(期待値)となるオブジェクト。
    ApiError apiError;

    @Before
    public void setup() throws Exception {
        RestAssured.port = port;
    }

    // GETメソッドのテスト。
    // [(機能名)_PDAテストケース.xlsx]のGETメソッドに対応するテストメソッドテンプレートをペーストして利用してください。
    @Test
    public void No_1_送り状番号9870011に対応する出荷ステータスオブジェクト_注文ステータス01_他送り状検品有無フラグ1を取得する() throws Exception {
        // Input(パス変数)となるオブジェクトに値をセット。
        inputPathVariable = setInputPathVariable("9870011");
        // Expected(期待値)となるオブジェクトに値をセット。
        expectedBody = setExpectedBody("9870011",
                                       "01",
                                       "1");
        // GETメソッドのテストを実施。
        testGet(inputPathVariable,
                expectedBody);
    }

    @Test
    public void No_2_送り状番号9870012に対応する出荷ステータスオブジェクト_注文ステータス01_他送り状検品有無フラグを取得する() throws Exception {
        inputPathVariable = setInputPathVariable("9870012");
        expectedBody = setExpectedBody("9870012",
                                       "01",
                                       "1");
        testGet(inputPathVariable,
                expectedBody);
    }

    @Test
    public void No_3_送り状番号9870013に対応する出荷ステータスオブジェクト_注文ステータス01_他送り状検品有無フラグを取得する() throws Exception {
        inputPathVariable = setInputPathVariable("9870013");
        expectedBody = setExpectedBody("9870013",
                                       "01",
                                       "1");
        testGet(inputPathVariable,
                expectedBody);
    }

    @Test
    public void No_4_送り状番号9870021に対応する出荷ステータスオブジェクト_注文ステータス01_他送り状検品有無フラグ1を取得する() throws Exception {
        inputPathVariable = setInputPathVariable("9870021");
        expectedBody = setExpectedBody("9870021",
                                       "01",
                                       "1");
        testGet(inputPathVariable,
                expectedBody);
    }

    @Test
    public void No_5_送り状番号9870022に対応する出荷ステータスオブジェクト_注文ステータス01_他送り状検品有無フラグ1を取得する() throws Exception {
        inputPathVariable = setInputPathVariable("9870022");
        expectedBody = setExpectedBody("9870022",
                                       "01",
                                       "1");
        testGet(inputPathVariable,
                expectedBody);
    }

    @Test
    public void No_6_送り状番号9870023に対応する出荷ステータスオブジェクト_注文ステータス01_他送り状検品有無フラグ1を取得する() throws Exception {
        inputPathVariable = setInputPathVariable("9870023");
        expectedBody = setExpectedBody("9870023",
                                       "01",
                                       "1");
        testGet(inputPathVariable,
                expectedBody);
    }

    @Test
    public void No_7_送り状番号9870031に対応する出荷ステータスオブジェクト_注文ステータス01_他送り状検品有無フラグ0を取得する() throws Exception {
        inputPathVariable = setInputPathVariable("9870031");
        expectedBody = setExpectedBody("9870031",
                                       "01",
                                       "1");
        testGet(inputPathVariable,
                expectedBody);
    }

    @Test
    public void No_8_送り状番号9870032に対応する出荷ステータスオブジェクト_注文ステータス01_他送り状検品有無フラグ0を取得する() throws Exception {
        inputPathVariable = setInputPathVariable("9870032");
        expectedBody = setExpectedBody("9870032",
                                       "01",
                                       "1");
        testGet(inputPathVariable,
                expectedBody);
    }

    @Test
    public void No_9_送り状番号9870033に対応する出荷ステータスオブジェクト_注文ステータス01_他送り状検品有無フラグ0を取得する() throws Exception {
        inputPathVariable = setInputPathVariable("9870033");
        expectedBody = setExpectedBody("9870033",
                                       "01",
                                       "1");
        testGet(inputPathVariable,
                expectedBody);
    }

    @Test
    public void No_10_送り状番号9870041に対応する出荷ステータスオブジェクト_注文ステータス01_他送り状検品有無フラグ1を取得する() throws Exception {
        inputPathVariable = setInputPathVariable("9870041");
        expectedBody = setExpectedBody("9870041",
                                       "01",
                                       "1");
        testGet(inputPathVariable,
                expectedBody);
    }

    @Test
    public void No_11_送り状番号9870042に対応する出荷ステータスオブジェクト_注文ステータス01_他送り状検品有無フラグ1を取得する() throws Exception {
        inputPathVariable = setInputPathVariable("9870042");
        expectedBody = setExpectedBody("9870042",
                                       "01",
                                       "1");
        testGet(inputPathVariable,
                expectedBody);
    }

    @Test
    public void No_12_送り状番号9870043に対応する出荷ステータスオブジェクト_注文ステータス01_他送り状検品有無フラグ1を取得する() throws Exception {
        inputPathVariable = setInputPathVariable("9870043");
        expectedBody = setExpectedBody("9870043",
                                       "01",
                                       "1");
        testGet(inputPathVariable,
                expectedBody);
    }

    @Test
    public void No_13_送り状番号9870051に対応する出荷ステータスオブジェクト_注文ステータス02_他送り状検品有無フラグ1を取得する() throws Exception {
        inputPathVariable = setInputPathVariable("9870051");
        expectedBody = setExpectedBody("9870051",
                                       "02",
                                       "1");
        testGet(inputPathVariable,
                expectedBody);
    }

    @Test
    public void No_14_送り状番号9870052に対応する出荷ステータスオブジェクト_注文ステータス02_他送り状検品有無フラグ1を取得する() throws Exception {
        inputPathVariable = setInputPathVariable("9870052");
        expectedBody = setExpectedBody("9870052",
                                       "02",
                                       "1");
        testGet(inputPathVariable,
                expectedBody);
    }

    @Test
    public void No_15_送り状番号9870053に対応する出荷ステータスオブジェクト_注文ステータス02_他送り状検品有無フラグ1を取得する() throws Exception {
        inputPathVariable = setInputPathVariable("9870053");
        expectedBody = setExpectedBody("9870053",
                                       "02",
                                       "1");
        testGet(inputPathVariable,
                expectedBody);
    }

    @Test
    public void No_16_送り状番号9870061に対応する出荷ステータスオブジェクト_注文ステータス02_他送り状検品有無フラグ1を取得する() throws Exception {
        inputPathVariable = setInputPathVariable("9870061");
        expectedBody = setExpectedBody("9870061",
                                       "02",
                                       "1");
        testGet(inputPathVariable,
                expectedBody);
    }

    @Test
    public void No_17_送り状番号9870062に対応する出荷ステータスオブジェクト_注文ステータス02_他送り状検品有無フラグ1を取得する() throws Exception {
        inputPathVariable = setInputPathVariable("9870062");
        expectedBody = setExpectedBody("9870062",
                                       "02",
                                       "1");
        testGet(inputPathVariable,
                expectedBody);
    }

    @Test
    public void No_18_送り状番号9870063に対応する出荷ステータスオブジェクト_注文ステータス02_他送り状検品有無フラグ1を取得する() throws Exception {
        inputPathVariable = setInputPathVariable("9870063");
        expectedBody = setExpectedBody("9870063",
                                       "02",
                                       "1");
        testGet(inputPathVariable,
                expectedBody);
    }

    @Test
    public void No_19_送り状番号9870071に対応する出荷ステータスオブジェクト_注文ステータス06_他送り状検品有無フラグ0を取得する() throws Exception {
        inputPathVariable = setInputPathVariable("9870071");
        expectedBody = setExpectedBody("9870071",
                                       "05",
                                       "1");
        testGet(inputPathVariable,
                expectedBody);
    }

    @Test
    public void No_20_送り状番号9870072に対応する出荷ステータスオブジェクト_注文ステータス06_他送り状検品有無フラグ0を取得する() throws Exception {
        inputPathVariable = setInputPathVariable("9870072");
        expectedBody = setExpectedBody("9870072",
                                       "05",
                                       "1");
        testGet(inputPathVariable,
                expectedBody);
    }

    @Test
    public void No_21_送り状番号9870073に対応する出荷ステータスオブジェクト_注文ステータス06_他送り状検品有無フラグ0を取得する() throws Exception {
        inputPathVariable = setInputPathVariable("9870073");
        expectedBody = setExpectedBody("9870073",
                                       "05",
                                       "1");
        testGet(inputPathVariable,
                expectedBody);
    }

    @Test
    public void No_22_送り状番号9870081に対応する出荷ステータスオブジェクト_注文ステータス05_他送り状検品有無フラグ0を取得する() throws Exception {
        inputPathVariable = setInputPathVariable("9870081");
        expectedBody = setExpectedBody("9870081",
                                       "05",
                                       "0");
        testGet(inputPathVariable,
                expectedBody);
    }

    @Test
    public void No_23_送り状番号9870082に対応する出荷ステータスオブジェクト_注文ステータス05_他送り状検品有無フラグ0を取得する() throws Exception {
        inputPathVariable = setInputPathVariable("9870082");
        expectedBody = setExpectedBody("9870082",
                                       "05",
                                       "0");
        testGet(inputPathVariable,
                expectedBody);
    }

    @Test
    public void No_24_送り状番号9870083に対応する出荷ステータスオブジェクト_注文ステータス05_他送り状検品有無フラグ0を取得する() throws Exception {
        inputPathVariable = setInputPathVariable("9870083");
        expectedBody = setExpectedBody("9870083",
                                       "05",
                                       "0");
        testGet(inputPathVariable,
                expectedBody);
    }

    @Test
    public void No_25_送り状番号9870091に対応する出荷ステータスオブジェクト_注文ステータス02_他送り状検品有無フラグ0を取得する() throws Exception {
        inputPathVariable = setInputPathVariable("9870091");
        expectedBody = setExpectedBody("9870091",
                                       "06",
                                       "0");
        testGet(inputPathVariable,
                expectedBody);
    }

    @Test
    public void No_26_送り状番号9870092に対応する出荷ステータスオブジェクト_注文ステータス02_他送り状検品有無フラグ0を取得する() throws Exception {
        inputPathVariable = setInputPathVariable("9870092");
        expectedBody = setExpectedBody("9870092",
                                       "06",
                                       "0");
        testGet(inputPathVariable,
                expectedBody);
    }

    @Test
    public void No_27_送り状番号9870093に対応する出荷ステータスオブジェクト_注文ステータス02_他送り状検品有無フラグ0を取得する() throws Exception {
        inputPathVariable = setInputPathVariable("9870093");
        expectedBody = setExpectedBody("9870093",
                                       "06",
                                       "0");
        testGet(inputPathVariable,
                expectedBody);
    }

    @Test
    public void No_28_送り状番号9870101に対応する出荷ステータスオブジェクト_注文ステータス03_他送り状検品有無フラグ0を取得する() throws Exception {
        inputPathVariable = setInputPathVariable("9870101");
        expectedBody = setExpectedBody("9870101",
                                       "03",
                                       "1");
        testGet(inputPathVariable,
                expectedBody);
    }

    @Test
    public void No_29_送り状番号9870102に対応する出荷ステータスオブジェクト_注文ステータス03_他送り状検品有無フラグ0を取得する() throws Exception {
        inputPathVariable = setInputPathVariable("9870102");
        expectedBody = setExpectedBody("9870102",
                                       "03",
                                       "1");
        testGet(inputPathVariable,
                expectedBody);
    }

    @Test
    public void No_30_送り状番号9870103に対応する出荷ステータスオブジェクト_注文ステータス03_他送り状検品有無フラグ0を取得する() throws Exception {
        inputPathVariable = setInputPathVariable("9870103");
        expectedBody = setExpectedBody("9870103",
                                       "03",
                                       "1");
        testGet(inputPathVariable,
                expectedBody);
    }

    @Test
    public void No_31_送り状番号9870111に対応する出荷ステータスオブジェクト_注文ステータス03_他送り状検品有無フラグ1を取得する() throws Exception {
        inputPathVariable = setInputPathVariable("9870111");
        expectedBody = setExpectedBody("9870111",
                                       "03",
                                       "1");
        testGet(inputPathVariable,
                expectedBody);
    }

    @Test
    public void No_32_送り状番号9870112に対応する出荷ステータスオブジェクト_注文ステータス03_他送り状検品有無フラグを取得する() throws Exception {
        inputPathVariable = setInputPathVariable("9870112");
        expectedBody = setExpectedBody("9870112",
                                       "03",
                                       "1");
        testGet(inputPathVariable,
                expectedBody);
    }

    @Test
    public void No_33_送り状番号9870113に対応する出荷ステータスオブジェクト_注文ステータス03_他送り状検品有無フラグを取得する() throws Exception {
        inputPathVariable = setInputPathVariable("9870113");
        expectedBody = setExpectedBody("9870113",
                                       "03",
                                       "1");
        testGet(inputPathVariable,
                expectedBody);
    }

    @Test
    public void No_34_送り状番号9870121に対応する出荷ステータスオブジェクト_注文ステータス04_他送り状検品有無フラグ1を取得する() throws Exception {
        inputPathVariable = setInputPathVariable("9870121");
        expectedBody = setExpectedBody("9870121",
                                       "04",
                                       "1");
        testGet(inputPathVariable,
                expectedBody);
    }

    @Test
    public void No_35_送り状番号9870122に対応する出荷ステータスオブジェクト_注文ステータス04_他送り状検品有無フラグ1を取得する() throws Exception {
        inputPathVariable = setInputPathVariable("9870122");
        expectedBody = setExpectedBody("9870122",
                                       "04",
                                       "1");
        testGet(inputPathVariable,
                expectedBody);
    }

    @Test
    public void No_36_送り状番号9870123に対応する出荷ステータスオブジェクト_注文ステータス04_他送り状検品有無フラグ1を取得する() throws Exception {
        inputPathVariable = setInputPathVariable("9870123");
        expectedBody = setExpectedBody("9870123",
                                       "04",
                                       "1");
        testGet(inputPathVariable,
                expectedBody);
    }

    @Test
    public void No_37_送り状番号9870131に対応する出荷ステータスオブジェクト_注文ステータス04_他送り状検品有無フラグ0を取得する() throws Exception {
        inputPathVariable = setInputPathVariable("9870131");
        expectedBody = setExpectedBody("9870131",
                                       "04",
                                       "1");
        testGet(inputPathVariable,
                expectedBody);
    }

    @Test
    public void No_38_送り状番号9870132に対応する出荷ステータスオブジェクト_注文ステータス04_他送り状検品有無フラグ0を取得する() throws Exception {
        inputPathVariable = setInputPathVariable("9870132");
        expectedBody = setExpectedBody("9870132",
                                       "04",
                                       "1");
        testGet(inputPathVariable,
                expectedBody);
    }

    @Test
    public void No_39_送り状番号9870133に対応する出荷ステータスオブジェクト_注文ステータス04_他送り状検品有無フラグ0を取得する() throws Exception {
        inputPathVariable = setInputPathVariable("9870133");
        expectedBody = setExpectedBody("9870133",
                                       "04",
                                       "1");
        testGet(inputPathVariable,
                expectedBody);
    }

    @Test
    public void No_40_送り状番号9870141に対応する出荷ステータスオブジェクト_注文ステータス04_他送り状検品有無フラグ1を取得する() throws Exception {
        inputPathVariable = setInputPathVariable("9870141");
        expectedBody = setExpectedBody("9870141",
                                       "04",
                                       "1");
        testGet(inputPathVariable,
                expectedBody);
    }

    @Test
    public void No_41_送り状番号9870142に対応する出荷ステータスオブジェクト_注文ステータス04_他送り状検品有無フラグ1を取得する() throws Exception {
        inputPathVariable = setInputPathVariable("9870142");
        expectedBody = setExpectedBody("9870142",
                                       "04",
                                       "1");
        testGet(inputPathVariable,
                expectedBody);
    }

    @Test
    public void No_42_送り状番号9870143に対応する出荷ステータスオブジェクト_注文ステータス04_他送り状検品有無フラグ1を取得する() throws Exception {
        inputPathVariable = setInputPathVariable("9870143");
        expectedBody = setExpectedBody("9870143",
                                       "04",
                                       "1");
        testGet(inputPathVariable,
                expectedBody);
    }

    @Test
    public void No_43_送り状番号9870151に対応する出荷ステータスオブジェクト_注文ステータス05_他送り状検品有無フラグ1を取得する() throws Exception {
        inputPathVariable = setInputPathVariable("9870151");
        expectedBody = setExpectedBody("9870151",
                                       "05",
                                       "1");
        testGet(inputPathVariable,
                expectedBody);
    }

    @Test
    public void No_44_送り状番号9870152に対応する出荷ステータスオブジェクト_注文ステータス05_他送り状検品有無フラグ1を取得する() throws Exception {
        inputPathVariable = setInputPathVariable("9870152");
        expectedBody = setExpectedBody("9870152",
                                       "05",
                                       "1");
        testGet(inputPathVariable,
                expectedBody);
    }

    @Test
    public void No_45_送り状番号9870153に対応する出荷ステータスオブジェクト_注文ステータス05_他送り状検品有無フラグ1を取得する() throws Exception {
        inputPathVariable = setInputPathVariable("9870153");
        expectedBody = setExpectedBody("9870153",
                                       "05",
                                       "1");
        testGet(inputPathVariable,
                expectedBody);
    }

    @Test
    public void No_46_送り状番号9870161に対応する出荷ステータスオブジェクト_注文ステータス05_他送り状検品有無フラグ1を取得する() throws Exception {
        inputPathVariable = setInputPathVariable("9870161");
        expectedBody = setExpectedBody("9870161",
                                       "05",
                                       "0");
        testGet(inputPathVariable,
                expectedBody);
    }

    @Test
    public void No_47_送り状番号9870162に対応する出荷ステータスオブジェクト_注文ステータス05_他送り状検品有無フラグ1を取得する() throws Exception {
        inputPathVariable = setInputPathVariable("9870162");
        expectedBody = setExpectedBody("9870162",
                                       "05",
                                       "0");
        testGet(inputPathVariable,
                expectedBody);
    }

    @Test
    public void No_48_送り状番号9870163に対応する出荷ステータスオブジェクト_注文ステータス05_他送り状検品有無フラグ1を取得する() throws Exception {
        inputPathVariable = setInputPathVariable("9870163");
        expectedBody = setExpectedBody("9870163",
                                       "05",
                                       "0");
        testGet(inputPathVariable,
                expectedBody);
    }

    @Test
    public void No_49_送り状番号9870171に対応する出荷ステータスオブジェクト_注文ステータス06_他送り状検品有無フラグ0を取得する() throws Exception {
        inputPathVariable = setInputPathVariable("9870171");
        expectedBody = setExpectedBody("9870171",
                                       "06",
                                       "0");
        testGet(inputPathVariable,
                expectedBody);
    }

    @Test
    public void No_50_送り状番号9870172に対応する出荷ステータスオブジェクト_注文ステータス06_他送り状検品有無フラグ0を取得する() throws Exception {
        inputPathVariable = setInputPathVariable("9870172");
        expectedBody = setExpectedBody("9870172",
                                       "06",
                                       "0");
        testGet(inputPathVariable,
                expectedBody);
    }

    @Test
    public void No_51_送り状番号9870173に対応する出荷ステータスオブジェクト_注文ステータス06_他送り状検品有無フラグ0を取得する() throws Exception {
        inputPathVariable = setInputPathVariable("9870173");
        expectedBody = setExpectedBody("9870173",
                                       "06",
                                       "0");
        testGet(inputPathVariable,
                expectedBody);
    }

    @Test
    public void No_52_送り状番号9870181に対応する出荷ステータスオブジェクト_注文ステータス90_他送り状検品有無フラグ0を取得する() throws Exception {
        inputPathVariable = setInputPathVariable("9870181");
        expectedBody = setExpectedBody("9870181",
                                       "90",
                                       "1");
        testGet(inputPathVariable,
                expectedBody);
    }

    @Test
    public void No_53_送り状番号9870182に対応する出荷ステータスオブジェクト_注文ステータス90_他送り状検品有無フラグ0を取得する() throws Exception {
        inputPathVariable = setInputPathVariable("9870182");
        expectedBody = setExpectedBody("9870182",
                                       "90",
                                       "1");
        testGet(inputPathVariable,
                expectedBody);
    }

    @Test
    public void No_54_送り状番号9870183に対応する出荷ステータスオブジェクト_注文ステータス90_他送り状検品有無フラグ0を取得する() throws Exception {
        inputPathVariable = setInputPathVariable("9870183");
        expectedBody = setExpectedBody("9870183",
                                       "90",
                                       "1");
        testGet(inputPathVariable,
                expectedBody);
    }

    @Test
    public void No_55_送り状番号9870191に対応する出荷ステータスオブジェクト_注文ステータス90_他送り状検品有無フラグ0を取得する() throws Exception {
        inputPathVariable = setInputPathVariable("9870191");
        expectedBody = setExpectedBody("9870191",
                                       "90",
                                       "0");
        testGet(inputPathVariable,
                expectedBody);
    }

    @Test
    public void No_56_送り状番号9870192に対応する出荷ステータスオブジェクト_注文ステータス90_他送り状検品有無フラグ0を取得する() throws Exception {
        inputPathVariable = setInputPathVariable("9870192");
        expectedBody = setExpectedBody("9870192",
                                       "90",
                                       "0");
        testGet(inputPathVariable,
                expectedBody);
    }

    @Test
    public void No_57_送り状番号9870193に対応する出荷ステータスオブジェクト_注文ステータス90_他送り状検品有無フラグ0を取得する() throws Exception {
        inputPathVariable = setInputPathVariable("9870193");
        expectedBody = setExpectedBody("9870193",
                                       "90",
                                       "0");
        testGet(inputPathVariable,
                expectedBody);
    }

    @Test
    public void No_58_送り状番号9870063に対応する出荷ステータス情報_出荷ステータスを0から1_を更新する() throws Exception {
        inputPathVariable = setInputPathVariable("9870063");
        inputBody = setInputBody("0201",
                                 "0001",
                                 "3446210033",
                                 "1");
        testPut(inputPathVariable,
                inputBody);
        expectedBody = setExpectedBody("9870063",
                                       "05",
                                       "1");
        testGet(inputPathVariable,
                expectedBody);
    }

    @Test
    public void No_59_送り状番号9870073に対応する出荷ステータス情報_出荷ステータスを0から1_他送り状検品有無フラグを1から0_を更新する() throws Exception {
        inputPathVariable = setInputPathVariable("9870073");
        inputBody = setInputBody("0201",
                                 "0001",
                                 "3446210033",
                                 "1");
        testPut(inputPathVariable,
                inputBody);
        expectedBody = setExpectedBody("9870073",
                                       "05",
                                       "0");
        testGet(inputPathVariable,
                expectedBody);
    }

    @Test
    public void No_60_送り状番号9870083に対応する出荷ステータス情報_出荷ステータスを0から1_を更新する() throws Exception {
        inputPathVariable = setInputPathVariable("9870083");
        inputBody = setInputBody("0201",
                                 "0001",
                                 "3446210033",
                                 "1");
        testPut(inputPathVariable,
                inputBody);
        expectedBody = setExpectedBody("9870083",
                                       "06",
                                       "0");
        testGet(inputPathVariable,
                expectedBody);
    }

    @Test
    public void No_61_送り状番号9870143に対応する出荷ステータス情報_出荷ステータスを0から1_を更新する() throws Exception {
        inputPathVariable = setInputPathVariable("9870143");
        inputBody = setInputBody("0201",
                                 "0001",
                                 "3446210033",
                                 "1");
        testPut(inputPathVariable,
                inputBody);
        expectedBody = setExpectedBody("9870143",
                                       "05",
                                       "1");
        testGet(inputPathVariable,
                expectedBody);
    }

    @Test
    public void No_62_送り状番号9870153に対応する出荷ステータス情報_出荷ステータスを0から1_他送り状検品有無フラグを1から0_を更新する() throws Exception {
        inputPathVariable = setInputPathVariable("9870153");
        inputBody = setInputBody("0201",
                                 "0001",
                                 "3446210033",
                                 "1");
        testPut(inputPathVariable,
                inputBody);
        expectedBody = setExpectedBody("9870153",
                                       "05",
                                       "0");
        testGet(inputPathVariable,
                expectedBody);
    }

    @Test
    public void No_63_送り状番号9870163に対応する出荷ステータス情報_出荷ステータスを0から1_を更新する() throws Exception {
        inputPathVariable = setInputPathVariable("9870163");
        inputBody = setInputBody("0201",
                                 "0001",
                                 "3446210033",
                                 "1");
        testPut(inputPathVariable,
                inputBody);
        expectedBody = setExpectedBody("9870163",
                                       "06",
                                       "0");
        testGet(inputPathVariable,
                expectedBody);
    }

    // 準正常系PUTメソッドのテスト。
    // [(機能名)_PDAテストケース.xlsx]の準正常系PUTメソッドに対応するテストメソッドテンプレートをペーストして利用してください。
    @Test
    public void No_64_送り状番号9870063に対応する出荷ステータス情報_店舗コードnull_で更新する() throws Exception {
        inputPathVariable = setInputPathVariable("9870063");
        inputBody = setInputBody("null",
                                 "0001",
                                 "3446210033",
                                 "1");
        apiError = setExceptionExpectedBody("w.BOA-V105",
                                            "指定されたリクエストボディに不正な値が設定された項目があります。");
        testException(inputPathVariable,
                      inputBody,
                      apiError,
                      HttpStatus.BAD_REQUEST.value());
    }

    @Test
    public void No_65_送り状番号9870063に対応する出荷ステータス情報_店舗コード_店_で更新する() throws Exception {
        inputPathVariable = setInputPathVariable("9870063");
        inputBody = setInputBody("店",
                                 "0001",
                                 "3446210033",
                                 "1");
        apiError = setExceptionExpectedBody("w.BOA-V105",
                                            "指定されたリクエストボディに不正な値が設定された項目があります。");
        testException(inputPathVariable,
                      inputBody,
                      apiError,
                      HttpStatus.BAD_REQUEST.value());
    }

    @Test
    public void No_66_送り状番号9870063に対応する出荷ステータス情報_店舗コード__123_で更新する() throws Exception {
        inputPathVariable = setInputPathVariable("9870063");
        inputBody = setInputBody("_123",
                                 "0001",
                                 "3446210033",
                                 "1");
        apiError = setExceptionExpectedBody("w.BOA-V105",
                                            "指定されたリクエストボディに不正な値が設定された項目があります。");
        testException(inputPathVariable,
                      inputBody,
                      apiError,
                      HttpStatus.BAD_REQUEST.value());
    }

    @Test
    public void No_67_送り状番号9870063に対応する出荷ステータス情報_店舗コード12345_で更新する() throws Exception {
        inputPathVariable = setInputPathVariable("9870063");
        inputBody = setInputBody("12345",
                                 "0001",
                                 "3446210033",
                                 "1");
        apiError = setExceptionExpectedBody("w.BOA-V105",
                                            "指定されたリクエストボディに不正な値が設定された項目があります。");
        testException(inputPathVariable,
                      inputBody,
                      apiError,
                      HttpStatus.BAD_REQUEST.value());
    }

    @Test
    public void No_68_送り状番号9870063に対応する出荷ステータス情報_端末No_null_で更新する() throws Exception {
        inputPathVariable = setInputPathVariable("9870063");
        inputBody = setInputBody("0201",
                                 "null",
                                 "3446210033",
                                 "1");
        apiError = setExceptionExpectedBody("w.BOA-V105",
                                            "指定されたリクエストボディに不正な値が設定された項目があります。");
        testException(inputPathVariable,
                      inputBody,
                      apiError,
                      HttpStatus.BAD_REQUEST.value());
    }

    @Test
    public void No_69_送り状番号9870063に対応する出荷ステータス情報_端末No_端_で更新する() throws Exception {
        inputPathVariable = setInputPathVariable("9870063");
        inputBody = setInputBody("0201",
                                 "端",
                                 "3446210033",
                                 "1");
        apiError = setExceptionExpectedBody("w.BOA-V105",
                                            "指定されたリクエストボディに不正な値が設定された項目があります。");
        testException(inputPathVariable,
                      inputBody,
                      apiError,
                      HttpStatus.BAD_REQUEST.value());
    }

    @Test
    public void No_70_送り状番号9870063に対応する出荷ステータス情報_端末No__123_で更新する() throws Exception {
        inputPathVariable = setInputPathVariable("9870063");
        inputBody = setInputBody("0201",
                                 "_123",
                                 "3446210033",
                                 "1");
        apiError = setExceptionExpectedBody("w.BOA-V105",
                                            "指定されたリクエストボディに不正な値が設定された項目があります。");
        testException(inputPathVariable,
                      inputBody,
                      apiError,
                      HttpStatus.BAD_REQUEST.value());
    }

    @Test
    public void No_71_送り状番号9870063に対応する出荷ステータス情報_端末No_12345_で更新する() throws Exception {
        inputPathVariable = setInputPathVariable("9870063");
        inputBody = setInputBody("0201",
                                 "12345",
                                 "3446210033",
                                 "1");
        apiError = setExceptionExpectedBody("w.BOA-V105",
                                            "指定されたリクエストボディに不正な値が設定された項目があります。");
        testException(inputPathVariable,
                      inputBody,
                      apiError,
                      HttpStatus.BAD_REQUEST.value());
    }

    @Test
    public void No_72_送り状番号9870063に対応する出荷ステータス情報_ユーザーID_null_で更新する() throws Exception {
        inputPathVariable = setInputPathVariable("9870063");
        inputBody = setInputBody("0201",
                                 "0001",
                                 "null",
                                 "1");
        apiError = setExceptionExpectedBody("w.BOA-V105",
                                            "指定されたリクエストボディに不正な値が設定された項目があります。");
        testException(inputPathVariable,
                      inputBody,
                      apiError,
                      HttpStatus.BAD_REQUEST.value());
    }

    @Test
    public void No_73_送り状番号9870063に対応する出荷ステータス情報_ユーザーID_ユ_で更新する() throws Exception {
        inputPathVariable = setInputPathVariable("9870063");
        inputBody = setInputBody("0201",
                                 "0001",
                                 "ユ",
                                 "1");
        apiError = setExceptionExpectedBody("w.BOA-V105",
                                            "指定されたリクエストボディに不正な値が設定された項目があります。");
        testException(inputPathVariable,
                      inputBody,
                      apiError,
                      HttpStatus.BAD_REQUEST.value());
    }

    @Test
    public void No_74_送り状番号9870063に対応する出荷ステータス情報_ユーザーID__123456789_で更新する() throws Exception {
        inputPathVariable = setInputPathVariable("9870063");
        inputBody = setInputBody("0201",
                                 "0001",
                                 "_123456789",
                                 "1");
        apiError = setExceptionExpectedBody("w.BOA-V105",
                                            "指定されたリクエストボディに不正な値が設定された項目があります。");
        testException(inputPathVariable,
                      inputBody,
                      apiError,
                      HttpStatus.BAD_REQUEST.value());
    }

    @Test
    public void No_75_送り状番号9870063に対応する出荷ステータス情報_ユーザーID_12345678901_で更新する() throws Exception {
        inputPathVariable = setInputPathVariable("9870063");
        inputBody = setInputBody("0201",
                                 "0001",
                                 "12345678901",
                                 "1");
        apiError = setExceptionExpectedBody("w.BOA-V105",
                                            "指定されたリクエストボディに不正な値が設定された項目があります。");
        testException(inputPathVariable,
                      inputBody,
                      apiError,
                      HttpStatus.BAD_REQUEST.value());
    }

    @Test
    public void No_76_送り状番号9870063に対応する出荷ステータス情報_出荷ステータス_null_で更新する() throws Exception {
        inputPathVariable = setInputPathVariable("9870063");
        inputBody = setInputBody("0201",
                                 "0001",
                                 "3446210033",
                                 "null");
        apiError = setExceptionExpectedBody("w.BOA-V105",
                                            "指定されたリクエストボディに不正な値が設定された項目があります。");
        testException(inputPathVariable,
                      inputBody,
                      apiError,
                      HttpStatus.BAD_REQUEST.value());
    }

    @Test
    public void No_77_送り状番号9870063に対応する出荷ステータス情報_出荷ステータス_出_で更新する() throws Exception {
        inputPathVariable = setInputPathVariable("9870063");
        inputBody = setInputBody("0201",
                                 "0001",
                                 "3446210033",
                                 "出");
        apiError = setExceptionExpectedBody("w.BOA-V105",
                                            "指定されたリクエストボディに不正な値が設定された項目があります。");
        testException(inputPathVariable,
                      inputBody,
                      apiError,
                      HttpStatus.BAD_REQUEST.value());
    }

    @Test
    public void No_78_送り状番号9870063に対応する出荷ステータス情報_出荷ステータス___で更新する() throws Exception {
        inputPathVariable = setInputPathVariable("9870063");
        inputBody = setInputBody("0201",
                                 "0001",
                                 "3446210033",
                                 "_");
        apiError = setExceptionExpectedBody("w.BOA-V105",
                                            "指定されたリクエストボディに不正な値が設定された項目があります。");
        testException(inputPathVariable,
                      inputBody,
                      apiError,
                      HttpStatus.BAD_REQUEST.value());
    }

    @Test
    public void No_79_送り状番号9870063に対応する出荷ステータス情報_出荷ステータス_12_で更新する() throws Exception {
        inputPathVariable = setInputPathVariable("9870063");
        inputBody = setInputBody("0201",
                                 "0001",
                                 "3446210033",
                                 "12");
        apiError = setExceptionExpectedBody("w.BOA-V105",
                                            "指定されたリクエストボディに不正な値が設定された項目があります。");
        testException(inputPathVariable,
                      inputBody,
                      apiError,
                      HttpStatus.BAD_REQUEST.value());
    }

    @Test
    public void No_80_送り状番号0000000に対応する出荷ステータスオブジェクト_注文ステータス01_他送り状検品有無フラグ1を取得する() throws Exception {
        inputPathVariable = setInputPathVariable("0000000");
        apiError = setExceptionExpectedBody("w.BOA-D101",
                                            "指定されたリソースが見つかりません。");
        testException(inputPathVariable,
                      inputBody,
                      apiError,
                      HttpStatus.NOT_FOUND.value());
    }

    @Test
    public void No_81_送り状番号0000000に対応する出荷ステータス情報_出荷ステータスを0から1_を更新する() throws Exception {
        inputPathVariable = setInputPathVariable("0000000");
        inputBody = setInputBody("0201",
                                 "0001",
                                 "3446210033",
                                 "1");
        apiError = setExceptionExpectedBody("w.BOA-D101",
                                            "指定されたリソースが見つかりません。");
        testException(inputPathVariable,
                      inputBody,
                      apiError,
                      HttpStatus.NOT_FOUND.value());
    }

    // 共通処理。
    /**
     * Input(パス変数)となるオブジェクトをセットする。
     * 
     * @param inspectionNum
     *            送り状番号。
     * @return 出荷ステータスオブジェクト。
     */
    public ShipmentStatusRequestedResource setInputPathVariable(String inspectionNum) {
        ShipmentStatusRequestedResource shipmentStatusRequestedResource = new ShipmentStatusRequestedResource();
        shipmentStatusRequestedResource.setInspectionNum(inspectionNum);

        return shipmentStatusRequestedResource;
    }

    /**
     * Input(ボディ)となるオブジェクトをセットする。
     * 
     * @param shipmentKbn
     *            出荷ステータス。
     * @return 出荷ステータスオブジェクト。
     */
    public ShipmentStatusRequestedResource setInputBody(String shopCd,
                                                        String terminalNum,
                                                        String userId,
                                                        String shipmentKbn) {
        ShipmentStatusRequestedResource shipmentStatusRequestedResource = new ShipmentStatusRequestedResource();
        if (NULL_STRING.equals(shopCd)) {
            shopCd = null;
        }
        if (NULL_STRING.equals(terminalNum)) {
            terminalNum = null;
        }
        if (NULL_STRING.equals(userId)) {
            userId = null;
        }
        if (NULL_STRING.equals(shipmentKbn)) {
            shipmentKbn = null;
        }
        shipmentStatusRequestedResource.setShopCd(shopCd);
        shipmentStatusRequestedResource.setTerminalNum(terminalNum);
        shipmentStatusRequestedResource.setUserId(userId);
        shipmentStatusRequestedResource.setShipmentKbn(shipmentKbn);

        return shipmentStatusRequestedResource;
    }

    /**
     * 正常系のExpected(期待値)となるオブジェクトをセットする。
     * 
     * @param inspectionNum
     *            送り状番号
     * @param odrStatus
     *            注文ステータス
     * @param isAllInvoicesInspected
     *            他送り状検品有無フラグ
     * @return 出荷ステータスオブジェクト。
     */
    public ShipmentStatusResponseResource setExpectedBody(String inspectionNum,
                                                          String odrStatus,
                                                          String isAllInvoicesInspected) {
        ShipmentStatusResponseResource shipmentStatusResponseResource = new ShipmentStatusResponseResource();
        shipmentStatusResponseResource.setInspectionNum(inspectionNum);
        shipmentStatusResponseResource.setOdrStatus(odrStatus);
        shipmentStatusResponseResource.setIsAllInvoicesInspected(isAllInvoicesInspected);

        return shipmentStatusResponseResource;
    }

    /**
     * 準正常系のExpected(期待値)となるオブジェクトをセットする。
     * 
     * @param
     * @return
     */
    public ApiError setExceptionExpectedBody(String code,
                                             String message) {
        ApiError apiError = new ApiError(code,
                                         message);

        return apiError;
    }

    /**
     * 21)送り状情報取得。<br>
     * 指定された送り状番号に対する出荷ステータス情報を返す。<br>
     * 
     * @param inputPathVariable
     *            Input(パス変数)となるオブジェクト。
     * @param expectedBody
     *            Expected(期待値)となるオブジェクト。
     * @throws Exception
     */
    public void testGet(ShipmentStatusRequestedResource inputPathVariable,
                        ShipmentStatusResponseResource expectedBody) throws Exception {
        when().get("pda/shipmentstatuses/{inspectionNum}",
                   inputPathVariable.getInspectionNum()).then().statusCode(HttpStatus.OK.value()).contentType("application/json;charset=UTF-8").body("inspectionNum",
                                                                                                                                                     is(expectedBody.getInspectionNum())).body("odrStatus",
                                                                                                                                                                                               is(expectedBody.getOdrStatus())).body("isAllInvoicesInspected",
                                                                                                                                                                                                                                     is(expectedBody.getIsAllInvoicesInspected()));
    }

    /**
     * 22)出荷検品完了更新。<br>
     * 指定された送り状番号に対する出荷のステータスを出荷検品完了に更新する。<br>
     * 
     * @param inputPathVariable
     *            Input(パス変数)となるオブジェクト。
     * @param inputBody
     *            Input(ボディ)となるオブジェクト。
     * @throws Exception
     */
    public void testPut(ShipmentStatusRequestedResource inputPathVariable,
                        ShipmentStatusRequestedResource inputBody) throws Exception {
        given().body(inputBody).contentType(ContentType.JSON).and().when().put("pda/shipmentstatuses/{inspectionNum}",
                                                                               inputPathVariable.getInspectionNum()).then().statusCode(HttpStatus.OK.value());
    }

    /**
     * 
     * @param inputPathVariable
     * @param inputBody
     * @param apiError
     * @param httpStatusValue
     * @throws Exception
     */
    public void testException(ShipmentStatusRequestedResource inputPathVariable,
                              ShipmentStatusRequestedResource inputBody,
                              ApiError apiError,
                              int httpStatusValue) throws Exception {
        if (inputBody == null) {
            when().get("pda/shipmentstatuses/{inspectionNum}",
                       inputPathVariable.getInspectionNum()).then().statusCode(httpStatusValue).contentType("application/json;charset=UTF-8").body("code",
                                                                                                                                                   is(apiError.getCode())).body("message",
                                                                                                                                                                                is(apiError.getMessage()));
        } else {
            given().body(inputBody).contentType(ContentType.JSON).and().when().put("pda/shipmentstatuses/{inspectionNum}",
                                                                                   inputPathVariable.getInspectionNum()).then().statusCode(httpStatusValue).contentType("application/json;charset=UTF-8").body("code",
                                                                                                                                                                                                               is(apiError.getCode())).body("message",
                                                                                                                                                                                                                                            is(apiError.getMessage()));
        }
    }

}
