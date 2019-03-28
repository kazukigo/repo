package jp.co.loft.backoffice.api.orderstatus;

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

import jp.co.loft.backoffice.api.orderstatus.OrderStatusRequestedResource.PostOrderStatus;
import jp.co.loft.backoffice.domain.model.OrderStatus;
import jp.co.loft.backoffice.domain.service.orderstatus.OrderStatusService;

/**
 * 注文ステータス情報のRestControllerクラス。<br>
 * 仕分検品業務におけるPDA端末からのリクエストを受け取る。<br>
 * 
 * <p>
 * <strong>REST API一覧</strong>
 * </p>
 * <blockquote> <div>
 * <p>
 * REST APIは以下の2つとなる。
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
 * <td><a href= "../../../../../jp/co/xxx/ecbo/api/OrderStatusRestController.html#getOrderStatus-java.lang.String-" >
 * <em>GET OrderStatus</em></a></td>
 * <td>GET</td>
 * <td><tt><span>/pda/orderstatuses/{odrNum}</span></tt></td>
 * <td><div>200</div> <div>(OK)</div></td>
 * <td>11)伝票情報取得。<br>
 * 指定された注文番号に対する注文ステータス情報を返す。<br>
 * </td>
 * </tr>
 * <tr style="border-bottom: 1px solid #D3D3D3;">
 * <td><div>2</div></td>
 * <td><a href=
 * "../../../../../jp/co/xxx/ecbo/api/OrderStatusRestController.html#putOrderStatus-java.lang.String-jp.co.xxx.ecbo.domain.OrderStatus-"
 * ><em>POST OrderStatus</em></a></td>
 * <td>POST</td>
 * <td><tt><span>/pda/orderstatuses/{odrNum}</span></tt></td>
 * <td><div>200</div> <div>(OK)</div></td>
 * <td>
 * <ul>
 * <li>15)欠品保留更新。<br>
 * 指定された注文番号に対する注文のステータスを欠品保留に更新する。</li>
 * <li>16)出荷保留更新。<br>
 * 指定された注文番号に対する注文のステータスを出荷保留に更新する。</li>
 * <li>17)仕分完了更新。<br>
 * 指定された注文番号に対する注文のステータスを仕分検品完了に更新する。</li>
 * <li>31)仕分検品取消更新。<br>
 * 指定された注文番号に対する注文のステータスを未仕分に更新する。</li>
 * </ul>
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
 * <td><div>YYMM + 10桁(連番)</div></td>
 * </tr>
 * <tr style="border-bottom: 1px solid #D3D3D3;">
 * <td><div>5</div></td>
 * <td>odrLineQntty - 注文明細数(アイテム数)</td>
 * <td>int</td>
 * <td>O</td>
 * <td>1-3</td>
 * <td>-</td>
 * </tr>
 * <tr style="border-bottom: 1px solid #D3D3D3;">
 * <td><div>6</div></td>
 * <td>odrStatus - 注文ステータス</td>
 * <td><div>String</div> <div>(Code)</div></td>
 * <td>I/O</td>
 * <td>2-2</td>
 * <td><div><tt><span>&quot;01&quot;</span></tt> : 受注(未仕分)</div> <div> <tt><span>&quot;02&quot;</span></tt> :
 * 仕分検品済(仕分検品完了)</div> <div> <tt><span>&quot;03&quot;</span></tt> : 欠品保留</div> <div>
 * <tt><span>&quot;04&quot;</span></tt> : 出荷保留</div> <div> <tt><span>&quot;05&quot;</span></tt> : 出荷検品中</div> <div>
 * <tt><span>&quot;06&quot;</span></tt> : 出荷検品完了</div> <div> <tt><span>&quot;90&quot;</span></tt> : その他</div></td>
 * </tr>
 * <tr style="border-bottom: 1px solid #D3D3D3;">
 * <td><div>7</div></td>
 * <td>consignorShopCd - 出荷元店舗コード</td>
 * <td><div>String</div> <div>(Code)</div></td>
 * <td>O</td>
 * <td>3-4</td>
 * <td><div><tt><span>&quot;202&quot;</span></tt> : 渋谷</div></td>
 * </tr>
 * <tr style="border-bottom: 1px solid #D3D3D3;">
 * <td><div>8</div></td>
 * <td>consigneeShopCd - 出荷先店舗コード</td>
 * <td><div>String</div> <div>(Code)</div></td>
 * <td>O</td>
 * <td>3-4</td>
 * <td><div><tt><span>&quot;501&quot;</span></tt> : 久喜</div></td>
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
 * <strong><a href= "../../../../../jp/co/xxx/ecbo/api/OrderStatusRestController.html#getOrderStatus-java.lang.String-"
 * ><em>GET OrderStatus</em></a></strong>
 * </p>
 * <p>
 * <strong>[リクエスト]</strong>
 * </p>
 * <div> <div>パス変数「<tt><span>odrNum</span></tt> 」に、取得対象のOrderStatusリソースのIDを指定する。</div> <div>下記例では、パス変数「
 * <tt><span>odrNum</span></tt>」に<tt><span>10020020301242</span></tt> を指定している。</div> </div> <div>
 * 
 * <pre style="background-color: #F5F5F5; border: solid 1px #D3D3D3;">
 * &gt; GET /pda/orderstatuses/10020020301242 HTTP/1.1
 * </pre>
 * 
 * </div>
 * <p>
 * <strong>[レスポンス]</strong>
 * </p>
 * <p>
 * パス変数「<tt><span>odrNum</span></tt>」に一致するOrderStatusリソースをJSON形式で返却する。
 * </p>
 * <div style="background-color: #F5F5F5; border: solid 1px #D3D3D3;"><div>
 * 
 * <pre>
 * &lt; HTTP/1.1 200 OK
 * &lt; Content-Type: application/json;charset<span>=</span>UTF-8
 * &lt;
 * <span>{</span><span>&quot;odrNum&quot;</span>:<span>&quot;10020020301242&quot;</span>,<span>&quot;odrLineQntty&quot;</span>:<span>5</span>,<span>&quot;consignorShopCd&quot;</span>:<span>&quot;202&quot;</span>,<span>&quot;consigneeShopCd&quot;</span>:<span>&quot;501&quot;</span>,<span>&quot;odrStatus&quot;</span>:<span>&quot;01&quot;</span><span>}</span>
 * </pre>
 * 
 * </div> </div> </div> <div>
 * <p>
 * <strong><a href=
 * "../../../../../jp/co/xxx/ecbo/api/OrderStatusRestController.html#putOrderStatus-java.lang.String-jp.co.xxx.ecbo.domain.OrderStatus-"
 * ><em>POST OrderStatus</em></a></strong>
 * </p>
 * <p>
 * <strong>[リクエスト]</strong>
 * </p>
 * <div> <div>パス変数「<tt><span>odrNum</span></tt> 」に、更新対象のOrderStatusのIDを指定する。</div> <div>PUT
 * OrderStatusでは、更新するOrderStatusリソースの内容(注文ステータス)をJSON形式で指定する。</div> </div> <div style=
 * "background-color: #F5F5F5; border: solid 1px #D3D3D3;">
 * 
 * <pre>
 * &gt; POST /pda/orderstatuses/10020020301242 HTTP/1.1
 * &gt;
 * <span>{</span><span>&quot;shopCd&quot;</span>:<span>&quot;XXXXXXXXXX&quot;</span>,<span>&quot;terminalNum&quot;</span>:<span>&quot;YYYYYYYYYY&quot;</span>,<span>&quot;userId&quot;</span>:<span>&quot;ZZZZZZZZZ&quot;</span>,<span>&quot;odrStatus&quot;</span>:<span>&quot;02&quot;</span><span>}</span>
 * </pre>
 * 
 * </div>
 * <p>
 * <strong>[レスポンス]</strong>
 * </p>
 * <p>
 * パス変数「<tt><span>odrNum</span></tt> 」に一致するOrderStatusリソースの内容(注文ステータス)を更新し、レスポンスBODYは返却しない。
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
@RequestMapping("pda/orderstatuses")
public class OrderStatusRestController {

    /** 注文ステータスサービスをインジェクション。 */
    @Autowired
    OrderStatusService orderStatusService;

    /**
     * 11)伝票情報取得。<br>
     * 指定された注文番号に対する注文ステータス情報を返す。<br>
     * 
     * @param odrNum
     *            注文番号。
     * @return 注文ステータスオブジェクト。
     */
    // @RequestMappingアノテーションのvalue属性にパス変数(上記例では{odrNum})を指定する。
    // {odrNum}には、リソースを一意に識別するための値が指定される。
    @RequestMapping(value = "{odrNum}", method = RequestMethod.GET)
    // メソッドアノテーションとして、@org.springframework.web.bind.annotation.ResponseStatusアノテーションを付与し、応答するステータスコードを指定する。
    @ResponseStatus(HttpStatus.OK)
    // リソースを一意に識別するための値を、パス変数から取得する。
    // 引数アノテーションとして、@PathVariable("odrNum")を指定することで、パス変数({odrNum})に指定された値をメソッドの引数として受け取ることが出来る。
    public OrderStatusResponseResource getOrderStatus(@PathVariable String odrNum) {
        OrderStatusRequestedResource orderStatusRequestedResource = new OrderStatusRequestedResource();
        orderStatusRequestedResource.setOdrNum(odrNum);

        // ドメイン層のサービスのメソッドを呼び出し、パス変数から取得したIDに一致するリソースの情報(エンティティ等)を取得する。
        OrderStatus orderStatus = orderStatusService.findOrderStatus(odrNum);

        // 条件に一致したリソースの情報(エンティティ等)をもとに、Web上に公開する情報を保持するリソースオブジェクトを生成する。
        OrderStatusResponseResource orderStatusResponseResource = new OrderStatusResponseResource();
        BeanUtils.copyProperties(orderStatus,
                                 orderStatusResponseResource);

        // 生成したリソースオブジェクトを返却する。
        // ここで返却したオブジェクトがJSONやXMLにmarshalされ、レスポンスボディに設定される。
        return orderStatusResponseResource;
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
     * @param odrNum
     *            注文番号。
     * @param orderStatusRequestedResource
     *            注文ステータスオブジェクト。
     */
    // @RequestMappingアノテーションのvalue属性にパス変数(上記例では{odrNum})をを指定する。
    // {odrNum}には、リソースを一意に識別するための値が指定される。
    @RequestMapping(value = "{odrNum}", method = RequestMethod.POST)
    // メソッドアノテーションとして、@org.springframework.web.bind.annotation.ResponseStatusアノテーションを付与し、応答するステータスコードを指定する。
    @ResponseStatus(HttpStatus.OK)
    // 新規に作成するリソースの情報を受け取るためのJavaBean(リソースクラス)を引数に指定する。
    // 引数アノテーションとして、@org.springframework.web.bind.annotation.RequestBodyアノテーションを付与する。
    // @RequestBodyアノテーションを付与することで、リクエストボディに設定されているJSONやXMLのデータがリソースオブジェクトにunmarshalされる。
    // 入力チェックを有効化するために、引数アノテーションとして、@Validatedアノテーションを付与する。
    public void postOrderStatus(@PathVariable String odrNum,
                                @Validated({ PostOrderStatus.class,
                                        Default.class }) @RequestBody OrderStatusRequestedResource orderStatusRequestedResource) {
        orderStatusRequestedResource.setOdrNum(odrNum);

        OrderStatus orderStatus = new OrderStatus();
        BeanUtils.copyProperties(orderStatusRequestedResource,
                                 orderStatus);

        // ドメイン層のServiceのメソッドを呼び出し、新規にリソースを作成する。
        orderStatusService.saveOrderStatus(orderStatus);
    }

}
