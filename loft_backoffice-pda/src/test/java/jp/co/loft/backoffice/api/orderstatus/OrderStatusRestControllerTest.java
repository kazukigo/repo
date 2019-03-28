package jp.co.loft.backoffice.api.orderstatus;

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
import jp.co.loft.backoffice.api.sortinginspection.SortingInspectionRequestedResource;
import jp.co.loft.backoffice.api.sortinginspection.SortingInspectionResponseResource;
import jp.co.loft.backoffice.api.sortinginspection.SortingInspectionRestControllerTest;

/**
 * 注文ステータス情報のRestControllerクラス。 仕分検品業務におけるPDA端末からのリクエストを受け取る。
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
@Sql(scripts = { "/db/migration/truncate_t_order_status.sql", "/db/migration/insert_t_order_status.sql" })
public class OrderStatusRestControllerTest {

    private static final String NULL_STRING = "null";

    // Rest-assuredで利用するポート。
    @Value("${local.server.port}")
    int port;
    // Input(パス変数)となるオブジェクト。
    OrderStatusRequestedResource inputPathVariable;
    // Input(ボディ)となるオブジェクト。
    OrderStatusRequestedResource inputBody;
    // 正常系のExpected(期待値)となるオブジェクト。
    OrderStatusResponseResource expectedBody;
    // 準正常系のExpected(期待値)となるオブジェクト。
    ApiError apiError;

    SortingInspectionRestControllerTest sortingInspectionTest;
    // Input(パス変数)となるオブジェクト。
    SortingInspectionRequestedResource sortingInspectionInputPathVariable;
    // Input(ボディ)となるオブジェクト。
    SortingInspectionRequestedResource sortingInspectionInputBody;
    // Expected(期待値)となるオブジェクト。
    SortingInspectionResponseResource sortingInspectionExpectedBody;

    @Before
    public void setup() throws Exception {
        RestAssured.port = port;
        sortingInspectionTest = new SortingInspectionRestControllerTest();
    }

    // GETメソッドのテスト。
    // [(機能名)_PDAテストケース.xlsx]のGETメソッドに対応するテストメソッドテンプレートをペーストして利用してください。
    @Test
    public void No_1_注文番号98765432100001に対応する注文ステータスオブジェクト_注文ステータス01を取得する() throws Exception {
        // Input(パス変数)となるオブジェクトに値をセット。
        inputPathVariable = setInputPathVariable("98765432100001");
        // Expected(期待値)となるオブジェクトに値をセット。
        expectedBody = setExpectedBody("98765432100001",
                                       3,
                                       "01",
                                       "202",
                                       "501");
        // GETメソッドのテストを実施。
        testGet(inputPathVariable,
                expectedBody);
    }

    @Test
    public void No_2_注文番号98765432100002に対応する注文ステータスオブジェクト_注文ステータス01を取得する() throws Exception {
        inputPathVariable = setInputPathVariable("98765432100002");
        expectedBody = setExpectedBody("98765432100002",
                                       3,
                                       "01",
                                       "202",
                                       "501");
        testGet(inputPathVariable,
                expectedBody);
    }

    @Test
    public void No_3_注文番号98765432100003に対応する注文ステータスオブジェクト_注文ステータス01を取得する() throws Exception {
        inputPathVariable = setInputPathVariable("98765432100003");
        expectedBody = setExpectedBody("98765432100003",
                                       3,
                                       "01",
                                       "202",
                                       "501");
        testGet(inputPathVariable,
                expectedBody);
    }

    @Test
    public void No_4_注文番号98765432100004に対応する注文ステータスオブジェクト_注文ステータス01を取得する() throws Exception {
        inputPathVariable = setInputPathVariable("98765432100004");
        expectedBody = setExpectedBody("98765432100004",
                                       3,
                                       "01",
                                       "202",
                                       "501");
        testGet(inputPathVariable,
                expectedBody);
    }

    @Test
    public void No_5_注文番号98765432100005に対応する注文ステータスオブジェクト_注文ステータス02を取得する() throws Exception {
        inputPathVariable = setInputPathVariable("98765432100005");
        expectedBody = setExpectedBody("98765432100005",
                                       3,
                                       "02",
                                       "202",
                                       "501");
        testGet(inputPathVariable,
                expectedBody);
    }

    @Test
    public void No_6_注文番号98765432100006に対応する注文ステータスオブジェクト_注文ステータス02を取得する() throws Exception {
        inputPathVariable = setInputPathVariable("98765432100006");
        expectedBody = setExpectedBody("98765432100006",
                                       3,
                                       "02",
                                       "202",
                                       "501");
        testGet(inputPathVariable,
                expectedBody);
    }

    @Test
    public void No_7_注文番号98765432100007に対応する注文ステータスオブジェクト_注文ステータス90を取得する() throws Exception {
        inputPathVariable = setInputPathVariable("98765432100007");
        expectedBody = setExpectedBody("98765432100007",
                                       3,
                                       "05",
                                       "202",
                                       "501");
        testGet(inputPathVariable,
                expectedBody);
    }

    @Test
    public void No_8_注文番号98765432100008に対応する注文ステータスオブジェクト_注文ステータス90を取得する() throws Exception {
        inputPathVariable = setInputPathVariable("98765432100008");
        expectedBody = setExpectedBody("98765432100008",
                                       3,
                                       "05",
                                       "202",
                                       "501");
        testGet(inputPathVariable,
                expectedBody);
    }

    @Test
    public void No_9_注文番号98765432100009に対応する注文ステータスオブジェクト_注文ステータス90を取得する() throws Exception {
        inputPathVariable = setInputPathVariable("98765432100009");
        expectedBody = setExpectedBody("98765432100009",
                                       3,
                                       "06",
                                       "202",
                                       "501");
        testGet(inputPathVariable,
                expectedBody);
    }

    @Test
    public void No_10_注文番号98765432100010に対応する注文ステータスオブジェクト_注文ステータス03を取得する() throws Exception {
        inputPathVariable = setInputPathVariable("98765432100010");
        expectedBody = setExpectedBody("98765432100010",
                                       3,
                                       "03",
                                       "202",
                                       "501");
        testGet(inputPathVariable,
                expectedBody);
    }

    @Test
    public void No_11_注文番号98765432100011に対応する注文ステータスオブジェクト_注文ステータス03を取得する() throws Exception {
        inputPathVariable = setInputPathVariable("98765432100011");
        expectedBody = setExpectedBody("98765432100011",
                                       3,
                                       "03",
                                       "202",
                                       "501");
        testGet(inputPathVariable,
                expectedBody);
    }

    @Test
    public void No_12_注文番号98765432100012に対応する注文ステータスオブジェクト_注文ステータス04を取得する() throws Exception {
        inputPathVariable = setInputPathVariable("98765432100012");
        expectedBody = setExpectedBody("98765432100012",
                                       3,
                                       "04",
                                       "202",
                                       "501");
        testGet(inputPathVariable,
                expectedBody);
    }

    @Test
    public void No_13_注文番号98765432100013に対応する注文ステータスオブジェクト_注文ステータス04を取得する() throws Exception {
        inputPathVariable = setInputPathVariable("98765432100013");
        expectedBody = setExpectedBody("98765432100013",
                                       3,
                                       "04",
                                       "202",
                                       "501");
        testGet(inputPathVariable,
                expectedBody);
    }

    @Test
    public void No_14_注文番号98765432100014に対応する注文ステータスオブジェクト_注文ステータス04を取得する() throws Exception {
        inputPathVariable = setInputPathVariable("98765432100014");
        expectedBody = setExpectedBody("98765432100014",
                                       3,
                                       "04",
                                       "202",
                                       "501");
        testGet(inputPathVariable,
                expectedBody);
    }

    @Test
    public void No_15_注文番号98765432100015に対応する注文ステータスオブジェクト_注文ステータス90を取得する() throws Exception {
        inputPathVariable = setInputPathVariable("98765432100015");
        expectedBody = setExpectedBody("98765432100015",
                                       3,
                                       "05",
                                       "202",
                                       "501");
        testGet(inputPathVariable,
                expectedBody);
    }

    @Test
    public void No_16_注文番号98765432100016に対応する注文ステータスオブジェクト_注文ステータス90を取得する() throws Exception {
        inputPathVariable = setInputPathVariable("98765432100016");
        expectedBody = setExpectedBody("98765432100016",
                                       3,
                                       "05",
                                       "202",
                                       "501");
        testGet(inputPathVariable,
                expectedBody);
    }

    @Test
    public void No_17_注文番号98765432100017に対応する注文ステータスオブジェクト_注文ステータス90を取得する() throws Exception {
        inputPathVariable = setInputPathVariable("98765432100017");
        expectedBody = setExpectedBody("98765432100017",
                                       3,
                                       "06",
                                       "202",
                                       "501");
        testGet(inputPathVariable,
                expectedBody);
    }

    @Test
    public void No_18_注文番号98765432100018に対応する注文ステータスオブジェクト_注文ステータス90を取得する() throws Exception {
        inputPathVariable = setInputPathVariable("98765432100018");
        expectedBody = setExpectedBody("98765432100018",
                                       3,
                                       "90",
                                       "202",
                                       "501");
        testGet(inputPathVariable,
                expectedBody);
    }

    @Test
    public void No_19_注文番号98765432100019に対応する注文ステータスオブジェクト_注文ステータス90を取得する() throws Exception {
        inputPathVariable = setInputPathVariable("98765432100019");
        expectedBody = setExpectedBody("98765432100019",
                                       3,
                                       "90",
                                       "202",
                                       "501");
        testGet(inputPathVariable,
                expectedBody);
    }

    // 正常系POSTメソッドのテスト。
    // [(機能名)_PDAテストケース.xlsx]のPOSTメソッドに対応するテストメソッドテンプレートをペーストして利用してください。
    @Test
    public void No_20_注文番号98765432100001に対応する注文ステータス情報_注文ステータスを01から02_を更新する() throws Exception {
        // Input(パス変数)となるオブジェクトに値をセット。
        inputPathVariable = setInputPathVariable("98765432100001");
        // Input(ボディ)となるオブジェクトに値をセット。
        inputBody = setInputBody("0201",
                                 "0001",
                                 "3446210033",
                                 "02");
        // POSTメソッドのテストを実施。
        testPost(inputPathVariable,
                 inputBody);
        // Expected(期待値)となるオブジェクトに値をセット。
        expectedBody = setExpectedBody("98765432100001",
                                       3,
                                       "02",
                                       "202",
                                       "501");
        // GETメソッドのテストを実施。
        testGet(inputPathVariable,
                expectedBody);

        // SortingInspection(仕分検品)のInput(パス変数)となるオブジェクトに値をセット。
        sortingInspectionInputPathVariable = sortingInspectionTest.setInputPathVariable("98765432100001",
                                                                                        "9876543210013");
        // SortingInspection(仕分検品)のExpected(期待値)となるオブジェクトに値をセット。
        sortingInspectionExpectedBody = sortingInspectionTest.setExpectedBody("98765432100001",
                                                                              "9876543210013",
                                                                              "RESTテスト商品名称013",
                                                                              3,
                                                                              3,
                                                                              3);
        // SortingInspection(仕分検品)のGETメソッドのテストを実施。
        sortingInspectionTest.testGet(sortingInspectionInputPathVariable,
                                      sortingInspectionExpectedBody);
    }

    @Test
    public void No_21_注文番号98765432100002に対応する注文ステータス情報_注文ステータスを01から03_を更新する() throws Exception {
        inputPathVariable = setInputPathVariable("98765432100002");
        inputBody = setInputBody("0201",
                                 "0001",
                                 "3446210033",
                                 "03");
        testPost(inputPathVariable,
                 inputBody);
        expectedBody = setExpectedBody("98765432100002",
                                       3,
                                       "03",
                                       "202",
                                       "501");
        testGet(inputPathVariable,
                expectedBody);

        sortingInspectionInputPathVariable = sortingInspectionTest.setInputPathVariable("98765432100002",
                                                                                        "9876543210023");
        sortingInspectionExpectedBody = sortingInspectionTest.setExpectedBody("98765432100002",
                                                                              "9876543210023",
                                                                              "RESTテスト商品名称023",
                                                                              3,
                                                                              3,
                                                                              3);
        sortingInspectionTest.testGet(sortingInspectionInputPathVariable,
                                      sortingInspectionExpectedBody);

    }

    @Test
    public void No_22_注文番号98765432100003に対応する注文ステータス情報_注文ステータスを01から04_を更新する() throws Exception {
        inputPathVariable = setInputPathVariable("98765432100003");
        inputBody = setInputBody("0201",
                                 "0001",
                                 "3446210033",
                                 "04");
        testPost(inputPathVariable,
                 inputBody);
        expectedBody = setExpectedBody("98765432100003",
                                       3,
                                       "04",
                                       "202",
                                       "501");
        testGet(inputPathVariable,
                expectedBody);

        sortingInspectionInputPathVariable = sortingInspectionTest.setInputPathVariable("98765432100003",
                                                                                        "9876543210033");
        sortingInspectionExpectedBody = sortingInspectionTest.setExpectedBody("98765432100003",
                                                                              "9876543210033",
                                                                              "RESTテスト商品名称033",
                                                                              3,
                                                                              3,
                                                                              3);
        sortingInspectionTest.testGet(sortingInspectionInputPathVariable,
                                      sortingInspectionExpectedBody);
    }

    @Test
    public void No_23_注文番号98765432100004に対応する注文ステータス情報_注文ステータスを01から01_を更新する() throws Exception {
        inputPathVariable = setInputPathVariable("98765432100004");
        inputBody = setInputBody("0201",
                                 "0001",
                                 "3446210033",
                                 "01");
        testPost(inputPathVariable,
                 inputBody);
        expectedBody = setExpectedBody("98765432100004",
                                       3,
                                       "01",
                                       "202",
                                       "501");
        testGet(inputPathVariable,
                expectedBody);

        sortingInspectionInputPathVariable = sortingInspectionTest.setInputPathVariable("98765432100004",
                                                                                        "9876543210043");
        sortingInspectionExpectedBody = sortingInspectionTest.setExpectedBody("98765432100004",
                                                                              "9876543210043",
                                                                              "RESTテスト商品名称043",
                                                                              3,
                                                                              0,
                                                                              0);
        sortingInspectionTest.testGet(sortingInspectionInputPathVariable,
                                      sortingInspectionExpectedBody);
    }

    @Test
    public void No_24_注文番号98765432100005に対応する注文ステータス情報_注文ステータスを02から01_を更新する() throws Exception {
        inputPathVariable = setInputPathVariable("98765432100005");
        inputBody = setInputBody("0201",
                                 "0001",
                                 "3446210033",
                                 "01");
        testPost(inputPathVariable,
                 inputBody);
        expectedBody = setExpectedBody("98765432100005",
                                       3,
                                       "01",
                                       "202",
                                       "501");
        testGet(inputPathVariable,
                expectedBody);

        sortingInspectionInputPathVariable = sortingInspectionTest.setInputPathVariable("98765432100005",
                                                                                        "9876543210053");
        sortingInspectionExpectedBody = sortingInspectionTest.setExpectedBody("98765432100005",
                                                                              "9876543210053",
                                                                              "RESTテスト商品名称053",
                                                                              3,
                                                                              0,
                                                                              0);
        sortingInspectionTest.testGet(sortingInspectionInputPathVariable,
                                      sortingInspectionExpectedBody);
    }

    @Test
    public void No_25_注文番号98765432100010に対応する注文ステータス情報_注文ステータスを03から02_を更新する() throws Exception {
        inputPathVariable = setInputPathVariable("98765432100010");
        inputBody = setInputBody("0201",
                                 "0001",
                                 "3446210033",
                                 "02");
        testPost(inputPathVariable,
                 inputBody);
        expectedBody = setExpectedBody("98765432100010",
                                       3,
                                       "02",
                                       "202",
                                       "501");
        testGet(inputPathVariable,
                expectedBody);

        sortingInspectionInputPathVariable = sortingInspectionTest.setInputPathVariable("98765432100010",
                                                                                        "9876543210103");
        sortingInspectionExpectedBody = sortingInspectionTest.setExpectedBody("98765432100010",
                                                                              "9876543210103",
                                                                              "RESTテスト商品名称103",
                                                                              3,
                                                                              3,
                                                                              3);
        sortingInspectionTest.testGet(sortingInspectionInputPathVariable,
                                      sortingInspectionExpectedBody);
    }

    @Test
    public void No_26_注文番号98765432100011に対応する注文ステータス情報_注文ステータスを03から01_を更新する() throws Exception {
        inputPathVariable = setInputPathVariable("98765432100011");
        inputBody = setInputBody("0201",
                                 "0001",
                                 "3446210033",
                                 "01");
        testPost(inputPathVariable,
                 inputBody);
        expectedBody = setExpectedBody("98765432100011",
                                       3,
                                       "01",
                                       "202",
                                       "501");
        testGet(inputPathVariable,
                expectedBody);

        sortingInspectionInputPathVariable = sortingInspectionTest.setInputPathVariable("98765432100011",
                                                                                        "9876543210113");
        sortingInspectionExpectedBody = sortingInspectionTest.setExpectedBody("98765432100011",
                                                                              "9876543210113",
                                                                              "RESTテスト商品名称113",
                                                                              3,
                                                                              0,
                                                                              0);
        sortingInspectionTest.testGet(sortingInspectionInputPathVariable,
                                      sortingInspectionExpectedBody);
    }

    @Test
    public void No_27_注文番号98765432100012に対応する注文ステータス情報_注文ステータスを04から02_を更新する() throws Exception {
        inputPathVariable = setInputPathVariable("98765432100012");
        inputBody = setInputBody("0201",
                                 "0001",
                                 "3446210033",
                                 "02");
        testPost(inputPathVariable,
                 inputBody);
        expectedBody = setExpectedBody("98765432100012",
                                       3,
                                       "02",
                                       "202",
                                       "501");
        testGet(inputPathVariable,
                expectedBody);

        sortingInspectionInputPathVariable = sortingInspectionTest.setInputPathVariable("98765432100012",
                                                                                        "9876543210123");
        sortingInspectionExpectedBody = sortingInspectionTest.setExpectedBody("98765432100012",
                                                                              "9876543210123",
                                                                              "RESTテスト商品名称123",
                                                                              3,
                                                                              3,
                                                                              3);
        sortingInspectionTest.testGet(sortingInspectionInputPathVariable,
                                      sortingInspectionExpectedBody);
    }

    @Test
    public void No_28_注文番号98765432100013に対応する注文ステータス情報_注文ステータスを04から01_を更新する() throws Exception {
        inputPathVariable = setInputPathVariable("98765432100013");
        inputBody = setInputBody("0201",
                                 "0001",
                                 "3446210033",
                                 "01");
        testPost(inputPathVariable,
                 inputBody);
        expectedBody = setExpectedBody("98765432100013",
                                       3,
                                       "01",
                                       "202",
                                       "501");
        testGet(inputPathVariable,
                expectedBody);

        sortingInspectionInputPathVariable = sortingInspectionTest.setInputPathVariable("98765432100013",
                                                                                        "9876543210133");
        sortingInspectionExpectedBody = sortingInspectionTest.setExpectedBody("98765432100013",
                                                                              "9876543210133",
                                                                              "RESTテスト商品名称133",
                                                                              3,
                                                                              0,
                                                                              0);
        sortingInspectionTest.testGet(sortingInspectionInputPathVariable,
                                      sortingInspectionExpectedBody);
    }

    // 準正常系POSTメソッドのテスト。
    // [(機能名)_PDAテストケース.xlsx]の準正常系POSTメソッドに対応するテストメソッドテンプレートをペーストして利用してください。
    @Test
    public void No_29_注文番号98765432100001に対応する注文ステータス情報_店舗コードnull_で更新する() throws Exception {
        inputPathVariable = setInputPathVariable("98765432100001");
        inputBody = setInputBody("null",
                                 "0001",
                                 "3446210033",
                                 "02");
        apiError = setExceptionExpectedBody("w.BOA-V105",
                                            "指定されたリクエストボディに不正な値が設定された項目があります。");
        testException(inputPathVariable,
                      inputBody,
                      apiError,
                      HttpStatus.BAD_REQUEST.value());
    }

    @Test
    public void No_30_注文番号98765432100001に対応する注文ステータス情報_店舗コード_店_で更新する() throws Exception {
        inputPathVariable = setInputPathVariable("98765432100001");
        inputBody = setInputBody("店",
                                 "0001",
                                 "3446210033",
                                 "02");
        apiError = setExceptionExpectedBody("w.BOA-V105",
                                            "指定されたリクエストボディに不正な値が設定された項目があります。");
        testException(inputPathVariable,
                      inputBody,
                      apiError,
                      HttpStatus.BAD_REQUEST.value());
    }

    @Test
    public void No_31_注文番号98765432100001に対応する注文ステータス情報_店舗コード__123_で更新する() throws Exception {
        inputPathVariable = setInputPathVariable("98765432100001");
        inputBody = setInputBody("_123",
                                 "0001",
                                 "3446210033",
                                 "02");
        apiError = setExceptionExpectedBody("w.BOA-V105",
                                            "指定されたリクエストボディに不正な値が設定された項目があります。");
        testException(inputPathVariable,
                      inputBody,
                      apiError,
                      HttpStatus.BAD_REQUEST.value());
    }

    @Test
    public void No_32_注文番号98765432100001に対応する注文ステータス情報_店舗コード12345_で更新する() throws Exception {
        inputPathVariable = setInputPathVariable("98765432100001");
        inputBody = setInputBody("12345",
                                 "0001",
                                 "3446210033",
                                 "02");
        apiError = setExceptionExpectedBody("w.BOA-V105",
                                            "指定されたリクエストボディに不正な値が設定された項目があります。");
        testException(inputPathVariable,
                      inputBody,
                      apiError,
                      HttpStatus.BAD_REQUEST.value());
    }

    @Test
    public void No_33_注文番号98765432100001に対応する注文ステータス情報_端末No_null_で更新する() throws Exception {
        inputPathVariable = setInputPathVariable("98765432100001");
        inputBody = setInputBody("0201",
                                 "null",
                                 "3446210033",
                                 "02");
        apiError = setExceptionExpectedBody("w.BOA-V105",
                                            "指定されたリクエストボディに不正な値が設定された項目があります。");
        testException(inputPathVariable,
                      inputBody,
                      apiError,
                      HttpStatus.BAD_REQUEST.value());
    }

    @Test
    public void No_34_注文番号98765432100001に対応する注文ステータス情報_端末No_端_で更新する() throws Exception {
        inputPathVariable = setInputPathVariable("98765432100001");
        inputBody = setInputBody("0201",
                                 "端",
                                 "3446210033",
                                 "02");
        apiError = setExceptionExpectedBody("w.BOA-V105",
                                            "指定されたリクエストボディに不正な値が設定された項目があります。");
        testException(inputPathVariable,
                      inputBody,
                      apiError,
                      HttpStatus.BAD_REQUEST.value());
    }

    @Test
    public void No_35_注文番号98765432100001に対応する注文ステータス情報_端末No__123_で更新する() throws Exception {
        inputPathVariable = setInputPathVariable("98765432100001");
        inputBody = setInputBody("0201",
                                 "_123",
                                 "3446210033",
                                 "02");
        apiError = setExceptionExpectedBody("w.BOA-V105",
                                            "指定されたリクエストボディに不正な値が設定された項目があります。");
        testException(inputPathVariable,
                      inputBody,
                      apiError,
                      HttpStatus.BAD_REQUEST.value());
    }

    @Test
    public void No_36_注文番号98765432100001に対応する注文ステータス情報_端末No_12345_で更新する() throws Exception {
        inputPathVariable = setInputPathVariable("98765432100001");
        inputBody = setInputBody("0201",
                                 "12345",
                                 "3446210033",
                                 "02");
        apiError = setExceptionExpectedBody("w.BOA-V105",
                                            "指定されたリクエストボディに不正な値が設定された項目があります。");
        testException(inputPathVariable,
                      inputBody,
                      apiError,
                      HttpStatus.BAD_REQUEST.value());
    }

    @Test
    public void No_37_注文番号98765432100001に対応する注文ステータス情報_ユーザーID_null_で更新する() throws Exception {
        inputPathVariable = setInputPathVariable("98765432100001");
        inputBody = setInputBody("0201",
                                 "0001",
                                 "null",
                                 "02");
        apiError = setExceptionExpectedBody("w.BOA-V105",
                                            "指定されたリクエストボディに不正な値が設定された項目があります。");
        testException(inputPathVariable,
                      inputBody,
                      apiError,
                      HttpStatus.BAD_REQUEST.value());
    }

    @Test
    public void No_38_注文番号98765432100001に対応する注文ステータス情報_ユーザーID_ユ_で更新する() throws Exception {
        inputPathVariable = setInputPathVariable("98765432100001");
        inputBody = setInputBody("0201",
                                 "0001",
                                 "ユ",
                                 "02");
        apiError = setExceptionExpectedBody("w.BOA-V105",
                                            "指定されたリクエストボディに不正な値が設定された項目があります。");
        testException(inputPathVariable,
                      inputBody,
                      apiError,
                      HttpStatus.BAD_REQUEST.value());
    }

    @Test
    public void No_39_注文番号98765432100001に対応する注文ステータス情報_ユーザーID__123456789_で更新する() throws Exception {
        inputPathVariable = setInputPathVariable("98765432100001");
        inputBody = setInputBody("0201",
                                 "0001",
                                 "_123456789",
                                 "02");
        apiError = setExceptionExpectedBody("w.BOA-V105",
                                            "指定されたリクエストボディに不正な値が設定された項目があります。");
        testException(inputPathVariable,
                      inputBody,
                      apiError,
                      HttpStatus.BAD_REQUEST.value());
    }

    @Test
    public void No_40_注文番号98765432100001に対応する注文ステータス情報_ユーザーID_12345678901_で更新する() throws Exception {
        inputPathVariable = setInputPathVariable("98765432100001");
        inputBody = setInputBody("0201",
                                 "0001",
                                 "12345678901",
                                 "02");
        apiError = setExceptionExpectedBody("w.BOA-V105",
                                            "指定されたリクエストボディに不正な値が設定された項目があります。");
        testException(inputPathVariable,
                      inputBody,
                      apiError,
                      HttpStatus.BAD_REQUEST.value());
    }

    @Test
    public void No_41_注文番号98765432100001に対応する注文ステータス情報_注文ステータス_null_で更新する() throws Exception {
        inputPathVariable = setInputPathVariable("98765432100001");
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
    public void No_42_注文番号98765432100001に対応する注文ステータス情報_注文ステータス_注_で更新する() throws Exception {
        inputPathVariable = setInputPathVariable("98765432100001");
        inputBody = setInputBody("0201",
                                 "0001",
                                 "3446210033",
                                 "注");
        apiError = setExceptionExpectedBody("w.BOA-V105",
                                            "指定されたリクエストボディに不正な値が設定された項目があります。");
        testException(inputPathVariable,
                      inputBody,
                      apiError,
                      HttpStatus.BAD_REQUEST.value());
    }

    @Test
    public void No_43_注文番号98765432100001に対応する注文ステータス情報_注文ステータス__1_で更新する() throws Exception {
        inputPathVariable = setInputPathVariable("98765432100001");
        inputBody = setInputBody("0201",
                                 "0001",
                                 "3446210033",
                                 "_1");
        apiError = setExceptionExpectedBody("w.BOA-V105",
                                            "指定されたリクエストボディに不正な値が設定された項目があります。");
        testException(inputPathVariable,
                      inputBody,
                      apiError,
                      HttpStatus.BAD_REQUEST.value());
    }

    @Test
    public void No_44_注文番号98765432100001に対応する注文ステータス情報_注文ステータス_123_で更新する() throws Exception {
        inputPathVariable = setInputPathVariable("98765432100001");
        inputBody = setInputBody("0201",
                                 "0001",
                                 "3446210033",
                                 "123");
        apiError = setExceptionExpectedBody("w.BOA-V105",
                                            "指定されたリクエストボディに不正な値が設定された項目があります。");
        testException(inputPathVariable,
                      inputBody,
                      apiError,
                      HttpStatus.BAD_REQUEST.value());
    }

    @Test
    public void No_45_注文番号00000000000000に対応する注文ステータスオブジェクト_注文ステータス01を取得する() throws Exception {
        inputPathVariable = setInputPathVariable("00000000000000");
        apiError = setExceptionExpectedBody("w.BOA-D101",
                                            "指定されたリソースが見つかりません。");
        testException(inputPathVariable,
                      inputBody,
                      apiError,
                      HttpStatus.NOT_FOUND.value());
    }

    @Test
    public void No_46_注文番号00000000000000に対応する注文ステータス情報_注文ステータスを01から02_を更新する() throws Exception {
        inputPathVariable = setInputPathVariable("00000000000000");
        inputBody = setInputBody("0201",
                                 "0001",
                                 "3446210033",
                                 "02");
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
     * @return 注文ステータスオブジェクト。
     */
    public OrderStatusRequestedResource setInputPathVariable(String odrNum) {
        OrderStatusRequestedResource orderStatusRequestedResource = new OrderStatusRequestedResource();
        orderStatusRequestedResource.setOdrNum(odrNum);

        return orderStatusRequestedResource;
    }

    /**
     * Input(ボディ)となるオブジェクトをセットする。
     * 
     * @param odrStatus
     *            注文ステータス。
     * @return 注文ステータスオブジェクト。
     */
    public OrderStatusRequestedResource setInputBody(String shopCd,
                                                     String terminalNum,
                                                     String userId,
                                                     String odrStatus) {
        OrderStatusRequestedResource orderStatusRequestedResource = new OrderStatusRequestedResource();
        if (NULL_STRING.equals(shopCd)) {
            shopCd = null;
        }
        if (NULL_STRING.equals(terminalNum)) {
            terminalNum = null;
        }
        if (NULL_STRING.equals(userId)) {
            userId = null;
        }
        if (NULL_STRING.equals(odrStatus)) {
            odrStatus = null;
        }
        orderStatusRequestedResource.setShopCd(shopCd);
        orderStatusRequestedResource.setTerminalNum(terminalNum);
        orderStatusRequestedResource.setUserId(userId);
        orderStatusRequestedResource.setOdrStatus(odrStatus);

        return orderStatusRequestedResource;
    }

    /**
     * 正常系のExpected(期待値)となるオブジェクトをセットする。
     * 
     * @param odrNum
     *            注文番号。
     * @param odrLineQntty
     *            注文明細数(アイテム数)。
     * @param odrStatus
     *            注文ステータス。
     * @param consignorShopCd
     *            出荷元店舗コード。
     * @param consigneeShopCd
     *            出荷先店舗コード。
     * @return 注文ステータスオブジェクト。
     */
    public OrderStatusResponseResource setExpectedBody(String odrNum,
                                                       int odrLineQntty,
                                                       String odrStatus,
                                                       String consignorShopCd,
                                                       String consigneeShopCd) {
        OrderStatusResponseResource orderStatusResponseResource = new OrderStatusResponseResource();
        orderStatusResponseResource.setOdrNum(odrNum);
        orderStatusResponseResource.setOdrLineQntty(odrLineQntty);
        orderStatusResponseResource.setOdrStatus(odrStatus);
        orderStatusResponseResource.setConsignorShopCd(consignorShopCd);
        orderStatusResponseResource.setConsigneeShopCd(consigneeShopCd);

        return orderStatusResponseResource;
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
     * 11)伝票情報取得。 指定された注文番号に対する注文ステータス情報を返す。
     * 
     * @param inputPathVariable
     *            Input(パス変数)となるオブジェクト。
     * @param expectedBody
     *            Expected(期待値)となるオブジェクト。
     * @throws Exception
     */
    public void testGet(OrderStatusRequestedResource inputPathVariable,
                        OrderStatusResponseResource expectedBody) throws Exception {
        when().get("pda/orderstatuses/{odrNum}",
                   inputPathVariable.getOdrNum()).then().statusCode(HttpStatus.OK.value()).contentType("application/json;charset=UTF-8").body("odrNum",
                                                                                                                                              is(expectedBody.getOdrNum())).body("odrLineQntty",
                                                                                                                                                                                 is(expectedBody.getOdrLineQntty())).body("odrStatus",
                                                                                                                                                                                                                          is(expectedBody.getOdrStatus())).body("consignorShopCd",
                                                                                                                                                                                                                                                                is(expectedBody.getConsignorShopCd())).body("consigneeShopCd",
                                                                                                                                                                                                                                                                                                            is(expectedBody.getConsigneeShopCd()));
    }

    /**
     * 15)欠品保留更新。<br>
     * 指定された注文番号に対する注文のステータスを欠品保留に更新する。<br>
     * 16)出荷保留更新。<br>
     * 指定された注文番号に対する注文のステータスを出荷保留に更新する。<br>
     * 17)仕分完了更新。<br>
     * 指定された注文番号に対する注文のステータスを仕分検品完了に更新する。<br>
     * 31)仕分検品取消更新。<br>
     * 指定された注文番号に対する注文のステータスを未仕分に更新する。<br>
     * 
     * @param inputPathVariable
     *            Input(パス変数)となるオブジェクト。
     * @param inputBody
     *            Input(ボディ)となるオブジェクト。
     * @throws Exception
     */
    public void testPost(OrderStatusRequestedResource inputPathVariable,
                         OrderStatusRequestedResource inputBody) throws Exception {
        given().body(inputBody).contentType(ContentType.JSON).and().when().post("pda/orderstatuses/{odrNum}",
                                                                                inputPathVariable.getOdrNum()).then().statusCode(HttpStatus.OK.value());
    }

    /**
     * 
     * @param inputPathVariable
     * @param inputBody
     * @param apiError
     * @param httpStatusValue
     * @throws Exception
     */
    public void testException(OrderStatusRequestedResource inputPathVariable,
                              OrderStatusRequestedResource inputBody,
                              ApiError apiError,
                              int httpStatusValue) throws Exception {
        if (inputBody == null) {
            when().get("pda/orderstatuses/{odrNum}",
                       inputPathVariable.getOdrNum()).then().statusCode(httpStatusValue).contentType("application/json;charset=UTF-8").body("code",
                                                                                                                                            is(apiError.getCode())).body("message",
                                                                                                                                                                         is(apiError.getMessage()));
        } else {
            given().body(inputBody).contentType(ContentType.JSON).and().when().post("pda/orderstatuses/{odrNum}",
                                                                                    inputPathVariable.getOdrNum()).then().statusCode(httpStatusValue).contentType("application/json;charset=UTF-8").body("code",
                                                                                                                                                                                                         is(apiError.getCode())).body("message",
                                                                                                                                                                                                                                      is(apiError.getMessage()));
        }
    }

}
