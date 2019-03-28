package jp.co.loft.backoffice.api.sortinginspection;

import java.util.ArrayList;
import java.util.List;

import javax.validation.groups.Default;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jp.co.loft.backoffice.api.sortinginspection.SortingInspectionRequestedResource.PutSortingInspection;
import jp.co.loft.backoffice.domain.model.SortingInspection;
import jp.co.loft.backoffice.domain.service.sortinginspection.SortingInspectionService;

/**
 * 仕分検品情報のRestControllerクラス。<br>
 * 仕分検品業務におけるPDA端末からのリクエストを受け取る。<br>
 * 
 * <p>
 * <strong>REST API一覧</strong>
 * </p>
 * <blockquote> <div>
 * <p>
 * REST APIは以下の3つとなる。
 * </p>
 * <table style="border-collapse: collapse;">
 * <thead style="background-color: #F5F5F5;">
 * <tr style="border-bottom: 1px solid #D3D3D3;">
 * <th><div>項番</div></th>
 * <th><div>API名</div></th>
 * <th><div>HTTP</div> <div>メソッド</div></th>
 * <th><div>リソースパス</div></th>
 * <th><div>ステータス</div> <div>コード</div></th>
 * <th><div>API概要</div></th>
 * </tr>
 * </thead> <tbody>
 * <tr style="border-bottom: 1px solid #D3D3D3;">
 * <td><div>1</div></td>
 * <td><a href=
 * "../../../../../jp/co/xxx/ecbo/api/SortingInspectionRestController.html#getSortingInspections-java.lang.String-" >
 * <em>GET SortingInspections</em></a></td>
 * <td>GET</td>
 * <td><tt><span>/pda/sortinginspections/{odrNum}</span></tt></td>
 * <td><div>200</div> <div>(OK)</div></td>
 * <td>14)数量確認明細取得。<br>
 * 指定された注文番号に対する仕分検品情報を返す。<br>
 * </td>
 * </tr>
 * <tr style="border-bottom: 1px solid #D3D3D3;">
 * <td><div>2</div></td>
 * <td><a href=
 * "../../../../../jp/co/xxx/ecbo/api/SortingInspectionRestController.html#getSortingInspection-java.lang.String-java.lang.String-"
 * ><em>GET SortingInspection</em></a></td>
 * <td>GET</td>
 * <td><tt><span>/pda/sortinginspections/{odrNum}/{prdctCd}</span></tt></td>
 * <td><div>200</div> <div>(OK)</div></td>
 * <td>12)商品明細取得。<br>
 * 指定された注文番号 / 商品コードに対する仕分検品情報を返す。<br>
 * </td>
 * </tr>
 * <tr style="border-bottom: 1px solid #D3D3D3;">
 * <td><div>3</div></td>
 * <td><a href=
 * "../../../../../jp/co/xxx/ecbo/api/SortingInspectionRestController.html#putSortingInspection-java.lang.String-java.lang.String-jp.co.xxx.ecbo.domain.SortingInspection-"
 * ><em>PUT SortingInspection</em></a></td>
 * <td>PUT</td>
 * <td><tt><span>/pda/sortinginspections/{odrNum}/{prdctCd}</span></tt></td>
 * <td><div>200</div> <div>(OK)</div></td>
 * <td>13)検品数更新。<br>
 * 指定された注文番号 / 商品コードに対する注文の仕分検品数を更新する。<br>
 * </td>
 * </tr>
 * </tbody>
 * </table>
 * </div></blockquote>
 * 
 * 
 * 
 * <p>
 * <strong>リソースの形式</strong>
 * </p>
 * <blockquote> <div>
 * <p>
 * リクエストのAcceptヘッダのMIMEタイプによって切り替えを行う。
 * </p>
 * <p>
 * REST APIで使用するMIMEタイプを以下に示す。
 * </p>
 * <table style="border-collapse: collapse;">
 * <thead style="background-color: #F5F5F5;">
 * <tr style="border-bottom: 1px solid #D3D3D3;">
 * <th>
 * <p>
 * 項番
 * </p>
 * </th>
 * <th>
 * <p>
 * フォーマット
 * </p>
 * </th>
 * <th>
 * <p>
 * MIMEタイプ
 * </p>
 * </th>
 * </tr>
 * </thead> <tbody>
 * <tr style="border-bottom: 1px solid #D3D3D3;">
 * <td><div>1</div></td>
 * <td><div>JSON</div></td>
 * <td><div>application/json</div></td>
 * </tr>
 * </tbody>
 * </table>
 * </div></blockquote>
 * 
 * 
 * 
 * <p>
 * <strong>リソースの項目仕様</strong>
 * </p>
 * <blockquote> <div>
 * <p>
 * リソース(JSON)の項目毎の仕様は以下の通りとする。
 * </p>
 * <table style="border-collapse: collapse;">
 * <thead style="background-color: #F5F5F5;">
 * <tr style="border-bottom: 1px solid #D3D3D3;">
 * <th>項番</th>
 * <th>項目名</th>
 * <th>型</th>
 * <th>I/O仕様</th>
 * <th>桁数 (min-max)</th>
 * <th>その他の仕様</th>
 * </tr>
 * </thead> <tbody>
 * <tr style="border-bottom: 1px solid #D3D3D3;">
 * <td><div>1</div></td>
 * <td>shopCd - 店舗コード</td>
 * <td>String</td>
 * <td>I</td>
 * <td>4-4</td>
 * <td><div></div></td>
 * </tr>
 * <tr style="border-bottom: 1px solid #D3D3D3;">
 * <td><div>2</div></td>
 * <td>terminalNum - 端末No</td>
 * <td>String</td>
 * <td>I</td>
 * <td>4-4</td>
 * <td><div></div></td>
 * </tr>
 * <tr style="border-bottom: 1px solid #D3D3D3;">
 * <td><div>3</div></td>
 * <td>userId - ユーザーID</td>
 * <td>String</td>
 * <td>I</td>
 * <td>10-10</td>
 * <td><div></div></td>
 * </tr>
 * <tr style="border-bottom: 1px solid #D3D3D3;">
 * <td><div>4</div></td>
 * <td>odrNum - 注文番号</td>
 * <td>String</td>
 * <td>I/O</td>
 * <td>14-14</td>
 * <td>-</td>
 * </tr>
 * <tr style="border-bottom: 1px solid #D3D3D3;">
 * <td><div>5</div></td>
 * <td>prdctCd - 商品コード</td>
 * <td>String</td>
 * <td>I/O</td>
 * <td>1-24</td>
 * <td>-</td>
 * </tr>
 * <tr style="border-bottom: 1px solid #D3D3D3;">
 * <td><div>6</div></td>
 * <td>prdctNm - 商品名称</td>
 * <td>String</td>
 * <td>O</td>
 * <td>1-600</td>
 * <td>-</td>
 * </tr>
 * <tr style="border-bottom: 1px solid #D3D3D3;">
 * <td><div>7</div></td>
 * <td>odrQntty - 注文数</td>
 * <td>int</td>
 * <td>O</td>
 * <td>1-5</td>
 * <td>-</td>
 * </tr>
 * <tr style="border-bottom: 1px solid #D3D3D3;">
 * <td><div>8</div></td>
 * <td>inspectionQntty - 検品数</td>
 * <td>int</td>
 * <td>I/O</td>
 * <td>1-5</td>
 * <td>-</td>
 * </tr>
 * <tr style="border-bottom: 1px solid #D3D3D3;">
 * <td><div>9</div></td>
 * <td>recordedQntty - 計上数</td>
 * <td>int</td>
 * <td>O</td>
 * <td>1-5</td>
 * <td>-</td>
 * </tr>
 * </tbody>
 * </table>
 * </div></blockquote>
 * 
 * 
 * 
 * <p>
 * <strong>API仕様</strong>
 * </p>
 * <blockquote> <div>HTTPリクエストとレスポンスの具体例を用いて、REST APIのインタフェース仕様を示す。 <div>
 * <p>
 * <strong><a href=
 * "../../../../../jp/co/xxx/ecbo/api/SortingInspectionRestController.html#getSortingInspections-java.lang.String-" >
 * <em>GET SortingInspections</em></a></strong>
 * </p>
 * <p>
 * <strong>[リクエスト]</strong>
 * </p>
 * <div> <div>パス変数「<tt><span>odrNum</span></tt> 」に、取得対象のSortingInspectionリソースのIDを指定する。</div> <div>下記例では、パス変数「
 * <tt><span>odrNum</span></tt>」に<tt><span>10020020301242</span></tt> を指定している。</div> </div> <div style=
 * "background-color: #F5F5F5; border: solid 1px #D3D3D3;"><div>
 * 
 * <pre>
 * &gt; GET /pda/sortinginspections/10020020301242 HTTP/1.1
 * </pre>
 * 
 * </div> </div>
 * <p>
 * <strong>[レスポンス]</strong>
 * </p>
 * <p>
 * 作成済みのSortingInspectionリソースのリストをJSON形式で返却する。
 * </p>
 * <div style="background-color: #F5F5F5; border: solid 1px #D3D3D3;"><div>
 * 
 * <pre>
 * &lt; HTTP/1.1 200 OK
 * &lt; Content-Type: application/json;charset<span>=</span>UTF-8
 * &lt;
 * <span>[</span><span>{</span><span>&quot;odrNum&quot;</span>:<span>&quot;10020020301242&quot;</span>,<span>&quot;prdctCd&quot;</span>:<span>&quot;4560247710880&quot;</span>,<span>&quot;prdctNm&quot;</span>:<span>&quot;3Dマッサージピロー&quot;</span>
 * ,<span>&quot;odrQntty&quot;</span>:<span>5</span>,<span>&quot;inspectionQntty&quot;</span>:<span>2</span>,<span>&quot;recordedQntty&quot;</span>:<span>0</span><span>}</span>
 * ,<span>{</span><span>&quot;odrNum&quot;</span>:<span>&quot;10020020301242&quot;</span>,<span>&quot;prdctCd&quot;</span>:<span>&quot;4560247710881&quot;</span>,<span>&quot;prdctNm&quot;</span>:<span>&quot;3Dマッサージピロー&quot;</span>
 * ,<span>&quot;odrQntty&quot;</span>:<span>5</span>,<span>&quot;inspectionQntty&quot;</span>:<span>2</span>,<span>&quot;recordedQntty&quot;</span>:<span>1</span><span>}</span>
 * ,<span>{</span><span>&quot;odrNum&quot;</span>:<span>&quot;10020020301242&quot;</span>,<span>&quot;prdctCd&quot;</span>:<span>&quot;4560247710882&quot;</span>,<span>&quot;prdctNm&quot;</span>:<span>&quot;3Dマッサージピロー&quot;</span>
 * ,<span>&quot;odrQntty&quot;</span>:<span>5</span>,<span>&quot;inspectionQntty&quot;</span>:<span>2</span>,<span>&quot;recordedQntty&quot;</span>:<span>2</span><span>}</span><span>]</span>
 * </pre>
 * 
 * </div> </div> </div> <div>
 * <p>
 * <strong><a href=
 * "../../../../../jp/co/xxx/ecbo/api/SortingInspectionRestController.html#getSortingInspection-java.lang.String-java.lang.String-"
 * ><em>GET SortingInspection</em></a></strong>
 * </p>
 * <p>
 * <strong>[リクエスト]</strong>
 * </p>
 * <div> <div>パス変数「<tt><span>prdctCd</span></tt> 」に、取得対象のSortingInspectionリソースのIDを指定する。</div> <div>下記例では、パス変数「
 * <tt><span>prdctCd</span></tt>」に<tt><span>4560247710880</span></tt> を指定している。</div> </div> <div style=
 * "background-color: #F5F5F5; border: solid 1px #D3D3D3;">
 * 
 * <pre>
 * &gt; GET /pda/sortinginspections/10020020301242/4560247710880 HTTP/1.1
 * </pre>
 * 
 * </div>
 * <p>
 * <strong>[レスポンス]</strong>
 * </p>
 * <p>
 * パス変数「<tt><span>prdctCd</span></tt>」に一致するSortingInspectionリソースをJSON形式で返却する。
 * </p>
 * <div style="background-color: #F5F5F5; border: solid 1px #D3D3D3;"><div>
 * 
 * <pre>
 * &lt; HTTP/1.1 200 OK
 * &lt; Content-Type: application/json;charset<span>=</span>UTF-8
 * &lt;
 * <span>{</span><span>&quot;odrNum&quot;</span>:<span>&quot;10020020301242&quot;</span>,<span>&quot;prdctCd&quot;</span>:<span>&quot;4560247710880&quot;</span>,<span>&quot;prdctNm&quot;</span>:<span>&quot;3Dマッサージピロー&quot;</span>
 * ,<span>&quot;odrQntty&quot;</span>:<span>5</span>,<span>&quot;inspectionQntty&quot;</span>:<span>2</span>,<span>&quot;recordedQntty&quot;</span>:<span>0</span><span>}</span>
 * </pre>
 * 
 * </div> </div> </div> <div>
 * <p>
 * <strong><a href=
 * "../../../../../jp/co/xxx/ecbo/api/SortingInspectionRestController.html#putSortingInspection-java.lang.String-java.lang.String-jp.co.xxx.ecbo.domain.SortingInspection-"
 * ><em>PUT SortingInspection</em></a></strong>
 * </p>
 * <p>
 * <strong>[リクエスト]</strong>
 * </p>
 * <div> <div>パス変数「<tt><span>prdctCd</span></tt> 」に、更新対象のSortingInspectionのIDを指定する。</div> <div>PUT
 * SortingInspectionでは、更新するSortingInspectionリソースの内容(仕分検品数)をJSON形式で指定する。</div> </div> <div style=
 * "background-color: #F5F5F5; border: solid 1px #D3D3D3;">
 * 
 * <pre>
 * &gt; PUT /pda/sortinginspections/10020020301242/4560247710880 HTTP/1.1
 * &gt;
 * <span>{</span><span>&quot;shopCd&quot;</span>:<span>&quot;XXXXXXXXXX&quot;</span>,<span>&quot;terminalNum&quot;</span>:<span>&quot;YYYYYYYYYY&quot;</span>,<span>&quot;userId&quot;</span>:<span>&quot;ZZZZZZZZZ&quot;</span>,<span>&quot;inspectionQntty&quot;</span>:<span>1</span><span>}</span>
 * </pre>
 * 
 * </div>
 * <p>
 * <strong>[レスポンス]</strong>
 * </p>
 * <p>
 * パス変数「<tt><span>prdctCd</span></tt> 」に一致するSortingInspectionリソースの内容(仕分検品数)を更新し、レスポンスBODYは返却しない。
 * </p>
 * <div style="background-color: #F5F5F5; border: solid 1px #D3D3D3;"><div>
 * 
 * <pre>
 * &lt; HTTP/1.1 200 OK
 * </pre>
 * 
 * </div> </div> </div> </div></blockquote>
 * 
 * @author 7NM T. Hayakawa
 * @version 0.1.0
 * @since 0.1.0
 */
// コントローラーのメソッドに@ResponseBodyを付与することで、返却したリソースオブジェクトがJSONやXMLにmarshalされ、レスポンスボディに設定される。
@RestController
// コントローラーに対して、リソースのコレクション用のURI(サーブレットパス)をマッピングする。
@RequestMapping("pda/sortinginspections/{odrNum}")
public class SortingInspectionRestController {

    /** 仕分検品サービスをインジェクション。 */
    @Autowired
    SortingInspectionService sortingInspectionService;

    /**
     * 14)数量確認明細取得。<br>
     * 指定された注文番号に対する仕分検品情報を返す。<br>
     * 
     * @param odrNum
     *            注文番号。
     * 
     * @return 仕分検品オブジェクト。
     */
    @RequestMapping(method = RequestMethod.GET)
    // メソッドアノテーションとして、@org.springframework.web.bind.annotation.ResponseStatusアノテーションを付与し、応答するステータスコードを指定する。
    @ResponseStatus(HttpStatus.OK)
    // リソースを一意に識別するための値を、パス変数から取得する。
    // 引数アノテーションとして、@PathVariable("odrNum")を指定することで、パス変数({odrNum})に指定された値をメソッドの引数として受け取ることが出来る。
    public List<SortingInspectionResponseResource> getSortingInspections(@PathVariable String odrNum) {
        SortingInspectionRequestedResource sortingInspectionRequestedResource = new SortingInspectionRequestedResource();
        sortingInspectionRequestedResource.setOdrNum(odrNum);

        // ドメイン層のサービスのメソッドを呼び出し、パス変数から取得したIDに一致するリソースの情報(エンティティ等)を取得する。
        List<SortingInspection> sortingInspections = sortingInspectionService.findSortingInspections(odrNum);

        // 条件に一致したリソースの情報(エンティティ等)をもとに、Web上に公開する情報を保持するリソースオブジェクトを生成する。
        List<SortingInspectionResponseResource> sortingInspectionResponseResources = new ArrayList<SortingInspectionResponseResource>();
        for (SortingInspection sortingInspection : sortingInspections) {
            SortingInspectionResponseResource temp = new SortingInspectionResponseResource();
            BeanUtils.copyProperties(sortingInspection,
                                     temp);
            sortingInspectionResponseResources.add(temp);
        }

        // 生成したリソースオブジェクトを返却する。
        // ここで返却したオブジェクトがJSONやXMLにmarshalされ、レスポンスボディに設定される。
        return sortingInspectionResponseResources;
    }

    /**
     * 12)商品明細取得。<br>
     * 指定された注文番号 / 商品コードに対する仕分検品情報を返す。<br>
     * 
     * @param odrNum
     *            注文番号。
     * @param prdctCd
     *            商品コード。
     * 
     * @return 仕分検品オブジェクト。
     */
    // @RequestMappingアノテーションのvalue属性にパス変数(上記例では{prdctCd})を指定する。
    // {prdctCd}には、リソースを一意に識別するための値が指定される。
    @RequestMapping(value = "{prdctCd}", method = RequestMethod.GET)
    // メソッドアノテーションとして、@org.springframework.web.bind.annotation.ResponseStatusアノテーションを付与し、応答するステータスコードを指定する。
    @ResponseStatus(HttpStatus.OK)
    // リソースを一意に識別するための値を、パス変数から取得する。
    // 引数アノテーションとして、@PathVariable("prdctCd")を指定することで、パス変数({prdctCd})に指定された値をメソッドの引数として受け取ることが出来る。
    public SortingInspectionResponseResource getSortingInspection(@PathVariable String odrNum,
                                                                  @PathVariable String prdctCd) {
        SortingInspectionRequestedResource sortingInspectionRequestedResource = new SortingInspectionRequestedResource();
        sortingInspectionRequestedResource.setOdrNum(odrNum);
        sortingInspectionRequestedResource.setPrdctCd(prdctCd);

        // ドメイン層のサービスのメソッドを呼び出し、パス変数から取得したIDに一致するリソースの情報(エンティティ等)を取得する。
        SortingInspection sortingInspection = sortingInspectionService.findSortingInspection(odrNum,
                                                                                             prdctCd);

        // 条件に一致したリソースの情報(エンティティ等)をもとに、Web上に公開する情報を保持するリソースオブジェクトを生成する。
        SortingInspectionResponseResource sortingInspectionResponseResource = new SortingInspectionResponseResource();
        BeanUtils.copyProperties(sortingInspection,
                                 sortingInspectionResponseResource);

        // 生成したリソースオブジェクトを返却する。
        // ここで返却したオブジェクトがJSONやXMLにmarshalされ、レスポンスボディに設定される。
        return sortingInspectionResponseResource;
    }

    /**
     * 13)検品数更新。<br>
     * 指定された注文番号 / 商品コードに対する注文の仕分検品数を更新する。<br>
     * 
     * @param odrNum
     *            注文番号。
     * @param prdctCd
     *            商品コード。
     * @param sortingInspectionRequestedResource
     *            仕分検品オブジェクト。
     */
    // @RequestMappingアノテーションのvalue属性にパス変数(上記例では{prdctCd})をを指定する。
    // {prdctCd}には、リソースを一意に識別するための値が指定される。
    @RequestMapping(value = "{prdctCd}", method = RequestMethod.PUT)
    // メソッドアノテーションとして、@org.springframework.web.bind.annotation.ResponseStatusアノテーションを付与し、応答するステータスコードを指定する。
    @ResponseStatus(HttpStatus.OK)
    // リソースの更新内容を受け取るためのJavaBean(リソースクラス)を引数に指定する。
    // 引数アノテーションとして、@RequestBodyアノテーションを付与することで、リクエストBodyに設定されているJSONやXMLのデータがリソースオブジェクトにunmarshalされる。
    // 入力チェックを有効化するために、引数アノテーションとして、@Validatedアノテーションを付与する。
    public void putSortingInspection(@PathVariable String odrNum,
                                     @PathVariable String prdctCd,
                                     @Validated({ PutSortingInspection.class,
                                             Default.class }) @RequestBody SortingInspectionRequestedResource sortingInspectionRequestedResource) {
        sortingInspectionRequestedResource.setOdrNum(odrNum);
        sortingInspectionRequestedResource.setPrdctCd(prdctCd);

        SortingInspection sortingInspection = new SortingInspection();
        BeanUtils.copyProperties(sortingInspectionRequestedResource,
                                 sortingInspection);

        // ドメイン層のサービスのメソッドを呼び出し、パス変数から取得したIDに一致するリソースの情報(エンティティ等)を更新する。
        sortingInspectionService.saveSortingInspection(sortingInspection);
    }

}
