package jp.co.loft.backoffice.api.sortinginspection;

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
 * 仕分検品情報のRestControllerクラス。 仕分検品業務におけるPDA端末からのリクエストを受け取る。
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
@Sql(scripts = { "/db/migration/truncate_t_sorting_inspections.sql", "/db/migration/insert_t_sorting_inspections.sql" })
public class SortingInspectionRestControllerTest {

    private static final String NULL_STRING = "null";

    // Rest-assuredで利用するポート。
    @Value("${local.server.port}")
    int port;
    // Input(パス変数)となるオブジェクト。
    SortingInspectionRequestedResource inputPathVariable;
    // Input(ボディ)となるオブジェクト。
    SortingInspectionRequestedResource inputBody;
    // 正常系のExpected(期待値)となるオブジェクト。
    SortingInspectionResponseResource expectedBody;
    // 準正常系のExpected(期待値)となるオブジェクト。
    ApiError apiError;

    @Before
    public void setup() throws Exception {
        RestAssured.port = port;
    }

    // @Test
    // public void 注文番号15103000000001に対応する仕分検品オブジェクト_注文数123_検品数000_計上数000を取得する()
    // throws Exception {
    // inputPathVariable = setInputPathVariable("15103000000001", "");
    // expectedBody = setExpectedBody(
    // "[15103000000001, 15103000000001, 15103000000001]",
    // "[3000000000011, 3000000000012, 3000000000013]",
    // "[RESTテスト商品名称11, RESTテスト商品名称12, RESTテスト商品名称13]", "[1, 2, 3]",
    // "[0, 0, 0]", "[0, 0, 0]");
    // testGet(inputPathVariable, expectedBody);
    // }

    // GETメソッドのテスト。
    // [(機能名)_PDAテストケース.xlsx]のGETメソッドに対応するテストメソッドテンプレートをペーストして利用してください。
    @Test
    public void No_8_注文番号98765432100001_商品コード9876543210011に対応する仕分検品オブジェクト_注文数1_検品数0_計上数0を取得する() throws Exception {
        // Input(パス変数)となるオブジェクトに値をセット。
        inputPathVariable = setInputPathVariable("98765432100001",
                                                 "9876543210011");
        // Expected(期待値)となるオブジェクトに値をセット。
        expectedBody = setExpectedBody("98765432100001",
                                       "9876543210011",
                                       "RESTテスト商品名称011",
                                       1,
                                       1,
                                       0);
        // GETメソッドのテストを実施。
        testGet(inputPathVariable,
                expectedBody);
    }

    @Test
    public void No_9_注文番号98765432100001_商品コード9876543210012に対応する仕分検品オブジェクト_注文数2_検品数0_計上数0を取得する() throws Exception {
        inputPathVariable = setInputPathVariable("98765432100001",
                                                 "9876543210012");
        expectedBody = setExpectedBody("98765432100001",
                                       "9876543210012",
                                       "RESTテスト商品名称012",
                                       2,
                                       2,
                                       0);
        testGet(inputPathVariable,
                expectedBody);
    }

    @Test
    public void No_10_注文番号98765432100001_商品コード9876543210013に対応する仕分検品オブジェクト_注文数3_検品数0_計上数0を取得する() throws Exception {
        inputPathVariable = setInputPathVariable("98765432100001",
                                                 "9876543210013");
        expectedBody = setExpectedBody("98765432100001",
                                       "9876543210013",
                                       "RESTテスト商品名称013",
                                       3,
                                       3,
                                       0);
        testGet(inputPathVariable,
                expectedBody);
    }

    @Test
    public void No_11_注文番号98765432100002_商品コード9876543210021に対応する仕分検品オブジェクト_注文数1_検品数0_計上数0を取得する() throws Exception {
        inputPathVariable = setInputPathVariable("98765432100002",
                                                 "9876543210021");
        expectedBody = setExpectedBody("98765432100002",
                                       "9876543210021",
                                       "RESTテスト商品名称021",
                                       1,
                                       0,
                                       0);
        testGet(inputPathVariable,
                expectedBody);
    }

    @Test
    public void No_12_注文番号98765432100002_商品コード9876543210022に対応する仕分検品オブジェクト_注文数2_検品数0_計上数0を取得する() throws Exception {
        inputPathVariable = setInputPathVariable("98765432100002",
                                                 "9876543210022");
        expectedBody = setExpectedBody("98765432100002",
                                       "9876543210022",
                                       "RESTテスト商品名称022",
                                       2,
                                       2,
                                       0);
        testGet(inputPathVariable,
                expectedBody);
    }

    @Test
    public void No_13_注文番号98765432100002_商品コード9876543210023に対応する仕分検品オブジェクト_注文数3_検品数0_計上数0を取得する() throws Exception {
        inputPathVariable = setInputPathVariable("98765432100002",
                                                 "9876543210023");
        expectedBody = setExpectedBody("98765432100002",
                                       "9876543210023",
                                       "RESTテスト商品名称023",
                                       3,
                                       3,
                                       0);
        testGet(inputPathVariable,
                expectedBody);
    }

    @Test
    public void No_14_注文番号98765432100003_商品コード9876543210031に対応する仕分検品オブジェクト_注文数1_検品数0_計上数0を取得する() throws Exception {
        inputPathVariable = setInputPathVariable("98765432100003",
                                                 "9876543210031");
        expectedBody = setExpectedBody("98765432100003",
                                       "9876543210031",
                                       "RESTテスト商品名称031",
                                       1,
                                       0,
                                       0);
        testGet(inputPathVariable,
                expectedBody);
    }

    @Test
    public void No_15_注文番号98765432100003_商品コード9876543210032に対応する仕分検品オブジェクト_注文数2_検品数0_計上数0を取得する() throws Exception {
        inputPathVariable = setInputPathVariable("98765432100003",
                                                 "9876543210032");
        expectedBody = setExpectedBody("98765432100003",
                                       "9876543210032",
                                       "RESTテスト商品名称032",
                                       2,
                                       2,
                                       0);
        testGet(inputPathVariable,
                expectedBody);
    }

    @Test
    public void No_16_注文番号98765432100003_商品コード9876543210033に対応する仕分検品オブジェクト_注文数3_検品数0_計上数0を取得する() throws Exception {
        inputPathVariable = setInputPathVariable("98765432100003",
                                                 "9876543210033");
        expectedBody = setExpectedBody("98765432100003",
                                       "9876543210033",
                                       "RESTテスト商品名称033",
                                       3,
                                       3,
                                       0);
        testGet(inputPathVariable,
                expectedBody);
    }

    @Test
    public void No_17_注文番号98765432100004_商品コード9876543210041に対応する仕分検品オブジェクト_注文数1_検品数0_計上数0を取得する() throws Exception {
        inputPathVariable = setInputPathVariable("98765432100004",
                                                 "9876543210041");
        expectedBody = setExpectedBody("98765432100004",
                                       "9876543210041",
                                       "RESTテスト商品名称041",
                                       1,
                                       1,
                                       0);
        testGet(inputPathVariable,
                expectedBody);
    }

    @Test
    public void No_18_注文番号98765432100004_商品コード9876543210042に対応する仕分検品オブジェクト_注文数2_検品数0_計上数0を取得する() throws Exception {
        inputPathVariable = setInputPathVariable("98765432100004",
                                                 "9876543210042");
        expectedBody = setExpectedBody("98765432100004",
                                       "9876543210042",
                                       "RESTテスト商品名称042",
                                       2,
                                       2,
                                       0);
        testGet(inputPathVariable,
                expectedBody);
    }

    @Test
    public void No_19_注文番号98765432100004_商品コード9876543210043に対応する仕分検品オブジェクト_注文数3_検品数0_計上数0を取得する() throws Exception {
        inputPathVariable = setInputPathVariable("98765432100004",
                                                 "9876543210043");
        expectedBody = setExpectedBody("98765432100004",
                                       "9876543210043",
                                       "RESTテスト商品名称043",
                                       3,
                                       3,
                                       0);
        testGet(inputPathVariable,
                expectedBody);
    }

    @Test
    public void No_20_注文番号98765432100005_商品コード9876543210051に対応する仕分検品オブジェクト_注文数1_検品数0_計上数0を取得する() throws Exception {
        inputPathVariable = setInputPathVariable("98765432100005",
                                                 "9876543210051");
        expectedBody = setExpectedBody("98765432100005",
                                       "9876543210051",
                                       "RESTテスト商品名称051",
                                       1,
                                       1,
                                       1);
        testGet(inputPathVariable,
                expectedBody);
    }

    @Test
    public void No_21_注文番号98765432100005_商品コード9876543210052に対応する仕分検品オブジェクト_注文数2_検品数0_計上数0を取得する() throws Exception {
        inputPathVariable = setInputPathVariable("98765432100005",
                                                 "9876543210052");
        expectedBody = setExpectedBody("98765432100005",
                                       "9876543210052",
                                       "RESTテスト商品名称052",
                                       2,
                                       2,
                                       2);
        testGet(inputPathVariable,
                expectedBody);
    }

    @Test
    public void No_22_注文番号98765432100005_商品コード9876543210053に対応する仕分検品オブジェクト_注文数3_検品数0_計上数0を取得する() throws Exception {
        inputPathVariable = setInputPathVariable("98765432100005",
                                                 "9876543210053");
        expectedBody = setExpectedBody("98765432100005",
                                       "9876543210053",
                                       "RESTテスト商品名称053",
                                       3,
                                       3,
                                       3);
        testGet(inputPathVariable,
                expectedBody);
    }

    @Test
    public void No_23_注文番号98765432100006_商品コード9876543210061に対応する仕分検品オブジェクト_注文数1_検品数0_計上数0を取得する() throws Exception {
        inputPathVariable = setInputPathVariable("98765432100006",
                                                 "9876543210061");
        expectedBody = setExpectedBody("98765432100006",
                                       "9876543210061",
                                       "RESTテスト商品名称061",
                                       1,
                                       1,
                                       1);
        testGet(inputPathVariable,
                expectedBody);
    }

    @Test
    public void No_24_注文番号98765432100006_商品コード9876543210062に対応する仕分検品オブジェクト_注文数2_検品数0_計上数0を取得する() throws Exception {
        inputPathVariable = setInputPathVariable("98765432100006",
                                                 "9876543210062");
        expectedBody = setExpectedBody("98765432100006",
                                       "9876543210062",
                                       "RESTテスト商品名称062",
                                       2,
                                       2,
                                       2);
        testGet(inputPathVariable,
                expectedBody);
    }

    @Test
    public void No_25_注文番号98765432100006_商品コード9876543210063に対応する仕分検品オブジェクト_注文数3_検品数0_計上数0を取得する() throws Exception {
        inputPathVariable = setInputPathVariable("98765432100006",
                                                 "9876543210063");
        expectedBody = setExpectedBody("98765432100006",
                                       "9876543210063",
                                       "RESTテスト商品名称063",
                                       3,
                                       3,
                                       3);
        testGet(inputPathVariable,
                expectedBody);
    }

    @Test
    public void No_26_注文番号98765432100007_商品コード9876543210071に対応する仕分検品オブジェクト_注文数1_検品数0_計上数0を取得する() throws Exception {
        inputPathVariable = setInputPathVariable("98765432100007",
                                                 "9876543210071");
        expectedBody = setExpectedBody("98765432100007",
                                       "9876543210071",
                                       "RESTテスト商品名称071",
                                       1,
                                       1,
                                       1);
        testGet(inputPathVariable,
                expectedBody);
    }

    @Test
    public void No_27_注文番号98765432100007_商品コード9876543210072に対応する仕分検品オブジェクト_注文数2_検品数0_計上数0を取得する() throws Exception {
        inputPathVariable = setInputPathVariable("98765432100007",
                                                 "9876543210072");
        expectedBody = setExpectedBody("98765432100007",
                                       "9876543210072",
                                       "RESTテスト商品名称072",
                                       2,
                                       2,
                                       2);
        testGet(inputPathVariable,
                expectedBody);
    }

    @Test
    public void No_28_注文番号98765432100007_商品コード9876543210073に対応する仕分検品オブジェクト_注文数3_検品数0_計上数0を取得する() throws Exception {
        inputPathVariable = setInputPathVariable("98765432100007",
                                                 "9876543210073");
        expectedBody = setExpectedBody("98765432100007",
                                       "9876543210073",
                                       "RESTテスト商品名称073",
                                       3,
                                       3,
                                       3);
        testGet(inputPathVariable,
                expectedBody);
    }

    @Test
    public void No_29_注文番号98765432100008_商品コード9876543210081に対応する仕分検品オブジェクト_注文数1_検品数0_計上数0を取得する() throws Exception {
        inputPathVariable = setInputPathVariable("98765432100008",
                                                 "9876543210081");
        expectedBody = setExpectedBody("98765432100008",
                                       "9876543210081",
                                       "RESTテスト商品名称081",
                                       1,
                                       1,
                                       1);
        testGet(inputPathVariable,
                expectedBody);
    }

    @Test
    public void No_30_注文番号98765432100008_商品コード9876543210082に対応する仕分検品オブジェクト_注文数2_検品数0_計上数0を取得する() throws Exception {
        inputPathVariable = setInputPathVariable("98765432100008",
                                                 "9876543210082");
        expectedBody = setExpectedBody("98765432100008",
                                       "9876543210082",
                                       "RESTテスト商品名称082",
                                       2,
                                       2,
                                       2);
        testGet(inputPathVariable,
                expectedBody);
    }

    @Test
    public void No_31_注文番号98765432100008_商品コード9876543210083に対応する仕分検品オブジェクト_注文数3_検品数0_計上数0を取得する() throws Exception {
        inputPathVariable = setInputPathVariable("98765432100008",
                                                 "9876543210083");
        expectedBody = setExpectedBody("98765432100008",
                                       "9876543210083",
                                       "RESTテスト商品名称083",
                                       3,
                                       3,
                                       3);
        testGet(inputPathVariable,
                expectedBody);
    }

    @Test
    public void No_32_注文番号98765432100009_商品コード9876543210091に対応する仕分検品オブジェクト_注文数1_検品数0_計上数0を取得する() throws Exception {
        inputPathVariable = setInputPathVariable("98765432100009",
                                                 "9876543210091");
        expectedBody = setExpectedBody("98765432100009",
                                       "9876543210091",
                                       "RESTテスト商品名称091",
                                       1,
                                       1,
                                       1);
        testGet(inputPathVariable,
                expectedBody);
    }

    @Test
    public void No_33_注文番号98765432100009_商品コード9876543210092に対応する仕分検品オブジェクト_注文数2_検品数0_計上数0を取得する() throws Exception {
        inputPathVariable = setInputPathVariable("98765432100009",
                                                 "9876543210092");
        expectedBody = setExpectedBody("98765432100009",
                                       "9876543210092",
                                       "RESTテスト商品名称092",
                                       2,
                                       2,
                                       2);
        testGet(inputPathVariable,
                expectedBody);
    }

    @Test
    public void No_34_注文番号98765432100009_商品コード9876543210093に対応する仕分検品オブジェクト_注文数3_検品数0_計上数0を取得する() throws Exception {
        inputPathVariable = setInputPathVariable("98765432100009",
                                                 "9876543210093");
        expectedBody = setExpectedBody("98765432100009",
                                       "9876543210093",
                                       "RESTテスト商品名称093",
                                       3,
                                       3,
                                       3);
        testGet(inputPathVariable,
                expectedBody);
    }

    @Test
    public void No_35_注文番号98765432100010_商品コード9876543210101に対応する仕分検品オブジェクト_注文数1_検品数0_計上数0を取得する() throws Exception {
        inputPathVariable = setInputPathVariable("98765432100010",
                                                 "9876543210101");
        expectedBody = setExpectedBody("98765432100010",
                                       "9876543210101",
                                       "RESTテスト商品名称101",
                                       1,
                                       1,
                                       1);
        testGet(inputPathVariable,
                expectedBody);
    }

    @Test
    public void No_36_注文番号98765432100010_商品コード9876543210102に対応する仕分検品オブジェクト_注文数2_検品数0_計上数0を取得する() throws Exception {
        inputPathVariable = setInputPathVariable("98765432100010",
                                                 "9876543210102");
        expectedBody = setExpectedBody("98765432100010",
                                       "9876543210102",
                                       "RESTテスト商品名称102",
                                       2,
                                       2,
                                       2);
        testGet(inputPathVariable,
                expectedBody);
    }

    @Test
    public void No_37_注文番号98765432100010_商品コード9876543210103に対応する仕分検品オブジェクト_注文数3_検品数0_計上数0を取得する() throws Exception {
        inputPathVariable = setInputPathVariable("98765432100010",
                                                 "9876543210103");
        expectedBody = setExpectedBody("98765432100010",
                                       "9876543210103",
                                       "RESTテスト商品名称103",
                                       3,
                                       3,
                                       3);
        testGet(inputPathVariable,
                expectedBody);
    }

    @Test
    public void No_38_注文番号98765432100011_商品コード9876543210111に対応する仕分検品オブジェクト_注文数1_検品数0_計上数0を取得する() throws Exception {
        inputPathVariable = setInputPathVariable("98765432100011",
                                                 "9876543210111");
        expectedBody = setExpectedBody("98765432100011",
                                       "9876543210111",
                                       "RESTテスト商品名称111",
                                       1,
                                       0,
                                       0);
        testGet(inputPathVariable,
                expectedBody);
    }

    @Test
    public void No_39_注文番号98765432100011_商品コード9876543210112に対応する仕分検品オブジェクト_注文数2_検品数0_計上数0を取得する() throws Exception {
        inputPathVariable = setInputPathVariable("98765432100011",
                                                 "9876543210112");
        expectedBody = setExpectedBody("98765432100011",
                                       "9876543210112",
                                       "RESTテスト商品名称112",
                                       2,
                                       2,
                                       2);
        testGet(inputPathVariable,
                expectedBody);
    }

    @Test
    public void No_40_注文番号98765432100011_商品コード9876543210113に対応する仕分検品オブジェクト_注文数3_検品数0_計上数0を取得する() throws Exception {
        inputPathVariable = setInputPathVariable("98765432100011",
                                                 "9876543210113");
        expectedBody = setExpectedBody("98765432100011",
                                       "9876543210113",
                                       "RESTテスト商品名称113",
                                       3,
                                       3,
                                       3);
        testGet(inputPathVariable,
                expectedBody);
    }

    @Test
    public void No_41_注文番号98765432100012_商品コード9876543210121に対応する仕分検品オブジェクト_注文数1_検品数0_計上数0を取得する() throws Exception {
        inputPathVariable = setInputPathVariable("98765432100012",
                                                 "9876543210121");
        expectedBody = setExpectedBody("98765432100012",
                                       "9876543210121",
                                       "RESTテスト商品名称121",
                                       1,
                                       1,
                                       1);
        testGet(inputPathVariable,
                expectedBody);
    }

    @Test
    public void No_42_注文番号98765432100012_商品コード9876543210122に対応する仕分検品オブジェクト_注文数2_検品数0_計上数0を取得する() throws Exception {
        inputPathVariable = setInputPathVariable("98765432100012",
                                                 "9876543210122");
        expectedBody = setExpectedBody("98765432100012",
                                       "9876543210122",
                                       "RESTテスト商品名称122",
                                       2,
                                       2,
                                       2);
        testGet(inputPathVariable,
                expectedBody);
    }

    @Test
    public void No_43_注文番号98765432100012_商品コード9876543210123に対応する仕分検品オブジェクト_注文数3_検品数0_計上数0を取得する() throws Exception {
        inputPathVariable = setInputPathVariable("98765432100012",
                                                 "9876543210123");
        expectedBody = setExpectedBody("98765432100012",
                                       "9876543210123",
                                       "RESTテスト商品名称123",
                                       3,
                                       3,
                                       3);
        testGet(inputPathVariable,
                expectedBody);
    }

    @Test
    public void No_44_注文番号98765432100013_商品コード9876543210131に対応する仕分検品オブジェクト_注文数1_検品数0_計上数0を取得する() throws Exception {
        inputPathVariable = setInputPathVariable("98765432100013",
                                                 "9876543210131");
        expectedBody = setExpectedBody("98765432100013",
                                       "9876543210131",
                                       "RESTテスト商品名称131",
                                       1,
                                       0,
                                       0);
        testGet(inputPathVariable,
                expectedBody);
    }

    @Test
    public void No_45_注文番号98765432100013_商品コード9876543210132に対応する仕分検品オブジェクト_注文数2_検品数0_計上数0を取得する() throws Exception {
        inputPathVariable = setInputPathVariable("98765432100013",
                                                 "9876543210132");
        expectedBody = setExpectedBody("98765432100013",
                                       "9876543210132",
                                       "RESTテスト商品名称132",
                                       2,
                                       2,
                                       2);
        testGet(inputPathVariable,
                expectedBody);
    }

    @Test
    public void No_46_注文番号98765432100013_商品コード9876543210133に対応する仕分検品オブジェクト_注文数3_検品数0_計上数0を取得する() throws Exception {
        inputPathVariable = setInputPathVariable("98765432100013",
                                                 "9876543210133");
        expectedBody = setExpectedBody("98765432100013",
                                       "9876543210133",
                                       "RESTテスト商品名称133",
                                       3,
                                       3,
                                       3);
        testGet(inputPathVariable,
                expectedBody);
    }

    @Test
    public void No_47_注文番号98765432100014_商品コード9876543210141に対応する仕分検品オブジェクト_注文数1_検品数0_計上数0を取得する() throws Exception {
        inputPathVariable = setInputPathVariable("98765432100014",
                                                 "9876543210141");
        expectedBody = setExpectedBody("98765432100014",
                                       "9876543210141",
                                       "RESTテスト商品名称141",
                                       1,
                                       1,
                                       1);
        testGet(inputPathVariable,
                expectedBody);
    }

    @Test
    public void No_48_注文番号98765432100014_商品コード9876543210142に対応する仕分検品オブジェクト_注文数2_検品数0_計上数0を取得する() throws Exception {
        inputPathVariable = setInputPathVariable("98765432100014",
                                                 "9876543210142");
        expectedBody = setExpectedBody("98765432100014",
                                       "9876543210142",
                                       "RESTテスト商品名称142",
                                       2,
                                       2,
                                       2);
        testGet(inputPathVariable,
                expectedBody);
    }

    @Test
    public void No_49_注文番号98765432100014_商品コード9876543210143に対応する仕分検品オブジェクト_注文数3_検品数0_計上数0を取得する() throws Exception {
        inputPathVariable = setInputPathVariable("98765432100014",
                                                 "9876543210143");
        expectedBody = setExpectedBody("98765432100014",
                                       "9876543210143",
                                       "RESTテスト商品名称143",
                                       3,
                                       3,
                                       3);
        testGet(inputPathVariable,
                expectedBody);
    }

    @Test
    public void No_50_注文番号98765432100015_商品コード9876543210151に対応する仕分検品オブジェクト_注文数1_検品数0_計上数0を取得する() throws Exception {
        inputPathVariable = setInputPathVariable("98765432100015",
                                                 "9876543210151");
        expectedBody = setExpectedBody("98765432100015",
                                       "9876543210151",
                                       "RESTテスト商品名称151",
                                       1,
                                       1,
                                       1);
        testGet(inputPathVariable,
                expectedBody);
    }

    @Test
    public void No_51_注文番号98765432100015_商品コード9876543210152に対応する仕分検品オブジェクト_注文数2_検品数0_計上数0を取得する() throws Exception {
        inputPathVariable = setInputPathVariable("98765432100015",
                                                 "9876543210152");
        expectedBody = setExpectedBody("98765432100015",
                                       "9876543210152",
                                       "RESTテスト商品名称152",
                                       2,
                                       2,
                                       2);
        testGet(inputPathVariable,
                expectedBody);
    }

    @Test
    public void No_52_注文番号98765432100015_商品コード9876543210153に対応する仕分検品オブジェクト_注文数3_検品数0_計上数0を取得する() throws Exception {
        inputPathVariable = setInputPathVariable("98765432100015",
                                                 "9876543210153");
        expectedBody = setExpectedBody("98765432100015",
                                       "9876543210153",
                                       "RESTテスト商品名称153",
                                       3,
                                       3,
                                       3);
        testGet(inputPathVariable,
                expectedBody);
    }

    @Test
    public void No_53_注文番号98765432100016_商品コード9876543210161に対応する仕分検品オブジェクト_注文数1_検品数0_計上数0を取得する() throws Exception {
        inputPathVariable = setInputPathVariable("98765432100016",
                                                 "9876543210161");
        expectedBody = setExpectedBody("98765432100016",
                                       "9876543210161",
                                       "RESTテスト商品名称161",
                                       1,
                                       1,
                                       1);
        testGet(inputPathVariable,
                expectedBody);
    }

    @Test
    public void No_54_注文番号98765432100016_商品コード9876543210162に対応する仕分検品オブジェクト_注文数2_検品数0_計上数0を取得する() throws Exception {
        inputPathVariable = setInputPathVariable("98765432100016",
                                                 "9876543210162");
        expectedBody = setExpectedBody("98765432100016",
                                       "9876543210162",
                                       "RESTテスト商品名称162",
                                       2,
                                       2,
                                       2);
        testGet(inputPathVariable,
                expectedBody);
    }

    @Test
    public void No_55_注文番号98765432100016_商品コード9876543210163に対応する仕分検品オブジェクト_注文数3_検品数0_計上数0を取得する() throws Exception {
        inputPathVariable = setInputPathVariable("98765432100016",
                                                 "9876543210163");
        expectedBody = setExpectedBody("98765432100016",
                                       "9876543210163",
                                       "RESTテスト商品名称163",
                                       3,
                                       3,
                                       3);
        testGet(inputPathVariable,
                expectedBody);
    }

    @Test
    public void No_56_注文番号98765432100017_商品コード9876543210171に対応する仕分検品オブジェクト_注文数1_検品数0_計上数0を取得する() throws Exception {
        inputPathVariable = setInputPathVariable("98765432100017",
                                                 "9876543210171");
        expectedBody = setExpectedBody("98765432100017",
                                       "9876543210171",
                                       "RESTテスト商品名称171",
                                       1,
                                       1,
                                       1);
        testGet(inputPathVariable,
                expectedBody);
    }

    @Test
    public void No_57_注文番号98765432100017_商品コード9876543210172に対応する仕分検品オブジェクト_注文数2_検品数0_計上数0を取得する() throws Exception {
        inputPathVariable = setInputPathVariable("98765432100017",
                                                 "9876543210172");
        expectedBody = setExpectedBody("98765432100017",
                                       "9876543210172",
                                       "RESTテスト商品名称172",
                                       2,
                                       2,
                                       2);
        testGet(inputPathVariable,
                expectedBody);
    }

    @Test
    public void No_58_注文番号98765432100017_商品コード9876543210173に対応する仕分検品オブジェクト_注文数3_検品数0_計上数0を取得する() throws Exception {
        inputPathVariable = setInputPathVariable("98765432100017",
                                                 "9876543210173");
        expectedBody = setExpectedBody("98765432100017",
                                       "9876543210173",
                                       "RESTテスト商品名称173",
                                       3,
                                       3,
                                       3);
        testGet(inputPathVariable,
                expectedBody);
    }

    @Test
    public void No_59_注文番号98765432100018_商品コード9876543210181に対応する仕分検品オブジェクト_注文数1_検品数0_計上数0を取得する() throws Exception {
        inputPathVariable = setInputPathVariable("98765432100018",
                                                 "9876543210181");
        expectedBody = setExpectedBody("98765432100018",
                                       "9876543210181",
                                       "RESTテスト商品名称181",
                                       1,
                                       1,
                                       0);
        testGet(inputPathVariable,
                expectedBody);
    }

    @Test
    public void No_60_注文番号98765432100018_商品コード9876543210182に対応する仕分検品オブジェクト_注文数2_検品数0_計上数0を取得する() throws Exception {
        inputPathVariable = setInputPathVariable("98765432100018",
                                                 "9876543210182");
        expectedBody = setExpectedBody("98765432100018",
                                       "9876543210182",
                                       "RESTテスト商品名称182",
                                       2,
                                       2,
                                       0);
        testGet(inputPathVariable,
                expectedBody);
    }

    @Test
    public void No_61_注文番号98765432100018_商品コード9876543210183に対応する仕分検品オブジェクト_注文数3_検品数0_計上数0を取得する() throws Exception {
        inputPathVariable = setInputPathVariable("98765432100018",
                                                 "9876543210183");
        expectedBody = setExpectedBody("98765432100018",
                                       "9876543210183",
                                       "RESTテスト商品名称183",
                                       3,
                                       3,
                                       0);
        testGet(inputPathVariable,
                expectedBody);
    }

    @Test
    public void No_62_注文番号98765432100019_商品コード9876543210191に対応する仕分検品オブジェクト_注文数1_検品数0_計上数0を取得する() throws Exception {
        inputPathVariable = setInputPathVariable("98765432100019",
                                                 "9876543210191");
        expectedBody = setExpectedBody("98765432100019",
                                       "9876543210191",
                                       "RESTテスト商品名称191",
                                       1,
                                       1,
                                       1);
        testGet(inputPathVariable,
                expectedBody);
    }

    @Test
    public void No_63_注文番号98765432100019_商品コード9876543210192に対応する仕分検品オブジェクト_注文数2_検品数0_計上数0を取得する() throws Exception {
        inputPathVariable = setInputPathVariable("98765432100019",
                                                 "9876543210192");
        expectedBody = setExpectedBody("98765432100019",
                                       "9876543210192",
                                       "RESTテスト商品名称192",
                                       2,
                                       2,
                                       2);
        testGet(inputPathVariable,
                expectedBody);
    }

    @Test
    public void No_64_注文番号98765432100019_商品コード9876543210193に対応する仕分検品オブジェクト_注文数3_検品数0_計上数0を取得する() throws Exception {
        inputPathVariable = setInputPathVariable("98765432100019",
                                                 "9876543210193");
        expectedBody = setExpectedBody("98765432100019",
                                       "9876543210193",
                                       "RESTテスト商品名称193",
                                       3,
                                       3,
                                       3);
        testGet(inputPathVariable,
                expectedBody);
    }

    // 正常系PUTメソッドのテスト。
    // [(機能名)_PDAテストケース.xlsx]のPUTメソッドに対応するテストメソッドテンプレートをペーストして利用してください。
    @Test
    public void No_65_注文番号98765432100002_商品コード9876543210021に対応する仕分検品情報_検品数を0から1_を更新する() throws Exception {
        // Input(パス変数)となるオブジェクトに値をセット。
        inputPathVariable = setInputPathVariable("98765432100002",
                                                 "9876543210021");
        // Input(ボディ)となるオブジェクトに値をセット。
        inputBody = setInputBody("0201",
                                 "0001",
                                 "3446210033",
                                 1);
        // PUTメソッドのテストを実施。
        testPut(inputPathVariable,
                inputBody);
        // Expected(期待値)となるオブジェクトに値をセット。
        expectedBody = setExpectedBody("98765432100002",
                                       "9876543210021",
                                       "RESTテスト商品名称021",
                                       1,
                                       1,
                                       0);
        // GETメソッドのテストを実施。
        testGet(inputPathVariable,
                expectedBody);
    }

    @Test
    public void No_66_注文番号98765432100003_商品コード9876543210031に対応する仕分検品情報_検品数を0から1_を更新する() throws Exception {
        inputPathVariable = setInputPathVariable("98765432100003",
                                                 "9876543210031");
        inputBody = setInputBody("0201",
                                 "0001",
                                 "3446210033",
                                 1);
        testPut(inputPathVariable,
                inputBody);
        expectedBody = setExpectedBody("98765432100003",
                                       "9876543210031",
                                       "RESTテスト商品名称031",
                                       1,
                                       1,
                                       0);
        testGet(inputPathVariable,
                expectedBody);
    }

    @Test
    public void No_67_注文番号98765432100011_商品コード9876543210111に対応する仕分検品情報_検品数を0から1_を更新する() throws Exception {
        inputPathVariable = setInputPathVariable("98765432100011",
                                                 "9876543210111");
        inputBody = setInputBody("0201",
                                 "0001",
                                 "3446210033",
                                 1);
        testPut(inputPathVariable,
                inputBody);
        expectedBody = setExpectedBody("98765432100011",
                                       "9876543210111",
                                       "RESTテスト商品名称111",
                                       1,
                                       1,
                                       0);
        testGet(inputPathVariable,
                expectedBody);
    }

    @Test
    public void No_68_注文番号98765432100013_商品コード9876543210131に対応する仕分検品情報_検品数を0から1_を更新する() throws Exception {
        inputPathVariable = setInputPathVariable("98765432100013",
                                                 "9876543210131");
        inputBody = setInputBody("0201",
                                 "0001",
                                 "3446210033",
                                 1);
        testPut(inputPathVariable,
                inputBody);
        expectedBody = setExpectedBody("98765432100013",
                                       "9876543210131",
                                       "RESTテスト商品名称131",
                                       1,
                                       1,
                                       0);
        testGet(inputPathVariable,
                expectedBody);
    }

    // 準正常系PUTメソッドのテスト。
    // [(機能名)_PDAテストケース.xlsx]の準正常系PUTメソッドに対応するテストメソッドテンプレートをペーストして利用してください。
    @Test
    public void No_69_注文番号98765432100002_商品コード9876543210021に対応する仕分検品情報_店舗コードnull_で更新する() throws Exception {
        inputPathVariable = setInputPathVariable("98765432100013",
                                                 "9876543210131");
        inputBody = setInputBody("null",
                                 "0001",
                                 "3446210033",
                                 1);
        apiError = setExceptionExpectedBody("w.BOA-V105",
                                            "指定されたリクエストボディに不正な値が設定された項目があります。");
        testException(inputPathVariable,
                      inputBody,
                      apiError,
                      HttpStatus.BAD_REQUEST.value());
    }

    @Test
    public void No_70_注文番号98765432100002_商品コード9876543210021に対応する仕分検品情報_店舗コード_店_で更新する() throws Exception {
        inputPathVariable = setInputPathVariable("98765432100002",
                                                 "9876543210021");
        inputBody = setInputBody("店",
                                 "0001",
                                 "3446210033",
                                 1);
        apiError = setExceptionExpectedBody("w.BOA-V105",
                                            "指定されたリクエストボディに不正な値が設定された項目があります。");
        testException(inputPathVariable,
                      inputBody,
                      apiError,
                      HttpStatus.BAD_REQUEST.value());
    }

    @Test
    public void No_71_注文番号98765432100002_商品コード9876543210021に対応する仕分検品情報_店舗コード__123_で更新する() throws Exception {
        inputPathVariable = setInputPathVariable("98765432100002",
                                                 "9876543210021");
        inputBody = setInputBody("_123",
                                 "0001",
                                 "3446210033",
                                 1);
        apiError = setExceptionExpectedBody("w.BOA-V105",
                                            "指定されたリクエストボディに不正な値が設定された項目があります。");
        testException(inputPathVariable,
                      inputBody,
                      apiError,
                      HttpStatus.BAD_REQUEST.value());
    }

    @Test
    public void No_72_注文番号98765432100002_商品コード9876543210021に対応する仕分検品情報_店舗コード12345_で更新する() throws Exception {
        inputPathVariable = setInputPathVariable("98765432100002",
                                                 "9876543210021");
        inputBody = setInputBody("12345",
                                 "0001",
                                 "3446210033",
                                 1);
        apiError = setExceptionExpectedBody("w.BOA-V105",
                                            "指定されたリクエストボディに不正な値が設定された項目があります。");
        testException(inputPathVariable,
                      inputBody,
                      apiError,
                      HttpStatus.BAD_REQUEST.value());
    }

    @Test
    public void No_73_注文番号98765432100002_商品コード9876543210021に対応する仕分検品情報_端末No_null_で更新する() throws Exception {
        inputPathVariable = setInputPathVariable("98765432100002",
                                                 "9876543210021");
        inputBody = setInputBody("0201",
                                 "null",
                                 "3446210033",
                                 1);
        apiError = setExceptionExpectedBody("w.BOA-V105",
                                            "指定されたリクエストボディに不正な値が設定された項目があります。");
        testException(inputPathVariable,
                      inputBody,
                      apiError,
                      HttpStatus.BAD_REQUEST.value());
    }

    @Test
    public void No_74_注文番号98765432100002_商品コード9876543210021に対応する仕分検品情報_端末No_端_で更新する() throws Exception {
        inputPathVariable = setInputPathVariable("98765432100002",
                                                 "9876543210021");
        inputBody = setInputBody("0201",
                                 "端",
                                 "3446210033",
                                 1);
        apiError = setExceptionExpectedBody("w.BOA-V105",
                                            "指定されたリクエストボディに不正な値が設定された項目があります。");
        testException(inputPathVariable,
                      inputBody,
                      apiError,
                      HttpStatus.BAD_REQUEST.value());
    }

    @Test
    public void No_75_注文番号98765432100002_商品コード9876543210021に対応する仕分検品情報_端末No__123_で更新する() throws Exception {
        inputPathVariable = setInputPathVariable("98765432100002",
                                                 "9876543210021");
        inputBody = setInputBody("0201",
                                 "_123",
                                 "3446210033",
                                 1);
        apiError = setExceptionExpectedBody("w.BOA-V105",
                                            "指定されたリクエストボディに不正な値が設定された項目があります。");
        testException(inputPathVariable,
                      inputBody,
                      apiError,
                      HttpStatus.BAD_REQUEST.value());
    }

    @Test
    public void No_76_注文番号98765432100002_商品コード9876543210021に対応する仕分検品情報_端末No_12345_で更新する() throws Exception {
        inputPathVariable = setInputPathVariable("98765432100002",
                                                 "9876543210021");
        inputBody = setInputBody("0201",
                                 "12345",
                                 "3446210033",
                                 1);
        apiError = setExceptionExpectedBody("w.BOA-V105",
                                            "指定されたリクエストボディに不正な値が設定された項目があります。");
        testException(inputPathVariable,
                      inputBody,
                      apiError,
                      HttpStatus.BAD_REQUEST.value());
    }

    @Test
    public void No_77_注文番号98765432100002_商品コード9876543210021に対応する仕分検品情報_ユーザーID_null_で更新する() throws Exception {
        inputPathVariable = setInputPathVariable("98765432100002",
                                                 "9876543210021");
        inputBody = setInputBody("0201",
                                 "0001",
                                 "null",
                                 1);
        apiError = setExceptionExpectedBody("w.BOA-V105",
                                            "指定されたリクエストボディに不正な値が設定された項目があります。");
        testException(inputPathVariable,
                      inputBody,
                      apiError,
                      HttpStatus.BAD_REQUEST.value());
    }

    @Test
    public void No_78_注文番号98765432100002_商品コード9876543210021に対応する仕分検品情報_ユーザーID_ユ_で更新する() throws Exception {
        inputPathVariable = setInputPathVariable("98765432100002",
                                                 "9876543210021");
        inputBody = setInputBody("0201",
                                 "0001",
                                 "ユ",
                                 1);
        apiError = setExceptionExpectedBody("w.BOA-V105",
                                            "指定されたリクエストボディに不正な値が設定された項目があります。");
        testException(inputPathVariable,
                      inputBody,
                      apiError,
                      HttpStatus.BAD_REQUEST.value());
    }

    @Test
    public void No_79_注文番号98765432100002_商品コード9876543210021に対応する仕分検品情報_ユーザーID__123456789_で更新する() throws Exception {
        inputPathVariable = setInputPathVariable("98765432100002",
                                                 "9876543210021");
        inputBody = setInputBody("0201",
                                 "0001",
                                 "_123456789",
                                 1);
        apiError = setExceptionExpectedBody("w.BOA-V105",
                                            "指定されたリクエストボディに不正な値が設定された項目があります。");
        testException(inputPathVariable,
                      inputBody,
                      apiError,
                      HttpStatus.BAD_REQUEST.value());
    }

    @Test
    public void No_80_注文番号98765432100002_商品コード9876543210021に対応する仕分検品情報_ユーザーID_12345678901_で更新する() throws Exception {
        inputPathVariable = setInputPathVariable("98765432100002",
                                                 "9876543210021");
        inputBody = setInputBody("0201",
                                 "0001",
                                 "12345678901",
                                 1);
        apiError = setExceptionExpectedBody("w.BOA-V105",
                                            "指定されたリクエストボディに不正な値が設定された項目があります。");
        testException(inputPathVariable,
                      inputBody,
                      apiError,
                      HttpStatus.BAD_REQUEST.value());
    }

    @Test
    public void No_81_注文番号98765432100002_商品コード9876543210021に対応する仕分検品情報_検品数_minus1_で更新する() throws Exception {
        inputPathVariable = setInputPathVariable("98765432100002",
                                                 "9876543210021");
        inputBody = setInputBody("0201",
                                 "0001",
                                 "3446210033",
                                 -1);
        apiError = setExceptionExpectedBody("w.BOA-V105",
                                            "指定されたリクエストボディに不正な値が設定された項目があります。");
        testException(inputPathVariable,
                      inputBody,
                      apiError,
                      HttpStatus.BAD_REQUEST.value());
    }

    @Test
    public void No_82_注文番号98765432100002_商品コード9876543210021に対応する仕分検品情報_検品数_123456_で更新する() throws Exception {
        inputPathVariable = setInputPathVariable("98765432100002",
                                                 "9876543210021");
        inputBody = setInputBody("0201",
                                 "0001",
                                 "3446210033",
                                 123456);
        apiError = setExceptionExpectedBody("w.BOA-V105",
                                            "指定されたリクエストボディに不正な値が設定された項目があります。");
        testException(inputPathVariable,
                      inputBody,
                      apiError,
                      HttpStatus.BAD_REQUEST.value());
    }

    @Test
    public void No_84_注文番号00000000000000_商品コード9876543210011に対応する仕分検品オブジェクト_注文数1_検品数0_計上数0を取得する() throws Exception {
        inputPathVariable = setInputPathVariable("00000000000000",
                                                 "9876543210011");
        apiError = setExceptionExpectedBody("w.BOA-D101",
                                            "指定されたリソースが見つかりません。");
        testException(inputPathVariable,
                      inputBody,
                      apiError,
                      HttpStatus.NOT_FOUND.value());
    }

    @Test
    public void No_85_注文番号98765432100001_商品コード0000000000000に対応する仕分検品オブジェクト_注文数1_検品数0_計上数0を取得する() throws Exception {
        inputPathVariable = setInputPathVariable("98765432100001",
                                                 "0000000000000");
        apiError = setExceptionExpectedBody("w.BOA-D101",
                                            "指定されたリソースが見つかりません。");
        testException(inputPathVariable,
                      inputBody,
                      apiError,
                      HttpStatus.NOT_FOUND.value());
    }

    @Test
    public void No_86_注文番号00000000000000_商品コード9876543210021に対応する仕分検品情報_検品数_123456_で更新する() throws Exception {
        inputPathVariable = setInputPathVariable("00000000000000",
                                                 "9876543210021");
        inputBody = setInputBody("0201",
                                 "0001",
                                 "3446210033",
                                 1);
        apiError = setExceptionExpectedBody("w.BOA-D101",
                                            "指定されたリソースが見つかりません。");
        testException(inputPathVariable,
                      inputBody,
                      apiError,
                      HttpStatus.NOT_FOUND.value());
    }

    @Test
    public void No_87_注文番号98765432100002_商品コード0000000000000に対応する仕分検品情報_検品数_123456_で更新する() throws Exception {
        inputPathVariable = setInputPathVariable("98765432100002",
                                                 "0000000000000");
        inputBody = setInputBody("0201",
                                 "0001",
                                 "3446210033",
                                 1);
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
     * @param odrNum
     *            注文番号。
     * @param prdctCd
     *            商品コード。
     * @return 仕分検品オブジェクト。
     */
    public SortingInspectionRequestedResource setInputPathVariable(String odrNum,
                                                                   String prdctCd) {
        SortingInspectionRequestedResource sortingInspectionRequestedResource = new SortingInspectionRequestedResource();
        sortingInspectionRequestedResource.setOdrNum(odrNum);
        sortingInspectionRequestedResource.setPrdctCd(prdctCd);

        return sortingInspectionRequestedResource;
    }

    /**
     * Input(ボディ)となるオブジェクトをセットする。
     * 
     * @param inspectionQntty
     *            検品数。
     * @return 仕分検品オブジェクト。
     */
    public SortingInspectionRequestedResource setInputBody(String shopCd,
                                                           String terminalNum,
                                                           String userId,
                                                           int inspectionQntty) {
        SortingInspectionRequestedResource sortingInspectionRequestedResource = new SortingInspectionRequestedResource();
        if (NULL_STRING.equals(shopCd)) {
            shopCd = null;
        }
        if (NULL_STRING.equals(terminalNum)) {
            terminalNum = null;
        }
        if (NULL_STRING.equals(userId)) {
            userId = null;
        }
        sortingInspectionRequestedResource.setShopCd(shopCd);
        sortingInspectionRequestedResource.setTerminalNum(terminalNum);
        sortingInspectionRequestedResource.setUserId(userId);
        sortingInspectionRequestedResource.setInspectionQntty(inspectionQntty);

        return sortingInspectionRequestedResource;
    }

    /**
     * 正常系のExpected(期待値)となるオブジェクトをセットする。
     * 
     * @param odrNum
     *            注文番号
     * @param prdctCd
     *            商品コード
     * @param prdctNm
     *            商品名称
     * @param odrQntty
     *            注文数
     * @param inspectionQntty
     *            検品数
     * @param recordedQntty
     *            計上数
     * @return
     */
    public SortingInspectionResponseResource setExpectedBody(String odrNum,
                                                             String prdctCd,
                                                             String prdctNm,
                                                             int odrQntty,
                                                             int inspectionQntty,
                                                             int recordedQntty) {
        SortingInspectionResponseResource sortingInspectionResponseResource = new SortingInspectionResponseResource();
        sortingInspectionResponseResource.setOdrNum(odrNum);
        sortingInspectionResponseResource.setPrdctCd(prdctCd);
        sortingInspectionResponseResource.setPrdctNm(prdctNm);
        sortingInspectionResponseResource.setOdrQntty(odrQntty);
        sortingInspectionResponseResource.setInspectionQntty(inspectionQntty);
        sortingInspectionResponseResource.setRecordedQntty(recordedQntty);

        return sortingInspectionResponseResource;
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
     * 12)商品明細取得。<br>
     * 指定された注文番号 / 商品コードに対する仕分検品情報を返す。<br>
     * 
     * @param inputPathVariable
     *            Input(パス変数)となるオブジェクト。
     * @param expectedBody
     *            Expected(期待値)となるオブジェクト。
     * @throws Exception
     */
    public void testGet(SortingInspectionRequestedResource inputPathVariable,
                        SortingInspectionResponseResource expectedBody) throws Exception {
        if ("".equals(inputPathVariable.getPrdctCd())) {
            when().get("pda/sortinginspections/{odrNum}",
                       inputPathVariable.getOdrNum()).then().statusCode(HttpStatus.OK.value()).contentType("application/json;charset=UTF-8").body("odrNum",
                                                                                                                                                  is(expectedBody.getOdrNum())).body("prdctCd",
                                                                                                                                                                                     is(expectedBody.getPrdctCd())).body("prdctNm",
                                                                                                                                                                                                                         is(expectedBody.getPrdctNm())).body("odrQntty",
                                                                                                                                                                                                                                                             is(expectedBody.getOdrQntty())).body("inspectionQntty",
                                                                                                                                                                                                                                                                                                  is(expectedBody.getInspectionQntty())).body("recordedQntty",
                                                                                                                                                                                                                                                                                                                                              is(expectedBody.getRecordedQntty()));
        } else {
            when().get("pda/sortinginspections/{odrNum}/{prdctCd}",
                       inputPathVariable.getOdrNum(),
                       inputPathVariable.getPrdctCd()).then().statusCode(HttpStatus.OK.value()).contentType("application/json;charset=UTF-8").body("odrNum",
                                                                                                                                                   is(expectedBody.getOdrNum())).body("prdctCd",
                                                                                                                                                                                      is(expectedBody.getPrdctCd())).body("prdctNm",
                                                                                                                                                                                                                          is(expectedBody.getPrdctNm())).body("odrQntty",
                                                                                                                                                                                                                                                              is(expectedBody.getOdrQntty())).body("inspectionQntty",
                                                                                                                                                                                                                                                                                                   is(expectedBody.getInspectionQntty())).body("recordedQntty",
                                                                                                                                                                                                                                                                                                                                               is(expectedBody.getRecordedQntty()));
        }
    }

    /**
     * 13)検品数更新。<br>
     * 指定された注文番号 / 商品コードに対する注文の仕分検品数を更新する。<br>
     * 
     * @param inputPathVariable
     *            Input(パス変数)となるオブジェクト。
     * @param inputBody
     *            Input(ボディ)となるオブジェクト。
     * @throws Exception
     */
    public void testPut(SortingInspectionRequestedResource inputPathVariable,
                        SortingInspectionRequestedResource inputBody) throws Exception {
        given().body(inputBody).contentType(ContentType.JSON).and().when().put("pda/sortinginspections/{odrNum}/{prdctCd}",
                                                                               inputPathVariable.getOdrNum(),
                                                                               inputPathVariable.getPrdctCd()).then().statusCode(HttpStatus.OK.value());
    }

    /**
     * 
     * @param inputPathVariable
     * @param inputBody
     * @param apiError
     * @param httpStatusValue
     * @throws Exception
     */
    public void testException(SortingInspectionRequestedResource inputPathVariable,
                              SortingInspectionRequestedResource inputBody,
                              ApiError apiError,
                              int httpStatusValue) throws Exception {
        if (inputBody == null) {
            if ("".equals(inputPathVariable.getPrdctCd())) {
                when().get("pda/sortinginspections/{odrNum}",
                           inputPathVariable.getOdrNum()).then().statusCode(httpStatusValue).contentType("application/json;charset=UTF-8").body("code",
                                                                                                                                                is(apiError.getCode())).body("message",
                                                                                                                                                                             is(apiError.getMessage()));
            } else {
                when().get("pda/sortinginspections/{odrNum}/{prdctCd}",
                           inputPathVariable.getOdrNum(),
                           inputPathVariable.getPrdctCd()).then().statusCode(httpStatusValue).contentType("application/json;charset=UTF-8").body("code",
                                                                                                                                                 is(apiError.getCode())).body("message",
                                                                                                                                                                              is(apiError.getMessage()));
            }
        } else {
            given().body(inputBody).contentType(ContentType.JSON).and().when().put("pda/sortinginspections/{odrNum}/{prdctCd}",
                                                                                   inputPathVariable.getOdrNum(),
                                                                                   inputPathVariable.getPrdctCd()).then().statusCode(httpStatusValue).contentType("application/json;charset=UTF-8").body("code",
                                                                                                                                                                                                         is(apiError.getCode())).body("message",
                                                                                                                                                                                                                                      is(apiError.getMessage()));
        }
    }

}
