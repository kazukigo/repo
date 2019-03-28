package jp.co.loft.backoffice.api.shipmentstatus;

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

import jp.co.loft.backoffice.api.shipmentstatus.ShipmentStatusRequestedResource.PutShipmentStatus;
import jp.co.loft.backoffice.domain.dao.shipmentstatus.ShipmentStatusResult;
import jp.co.loft.backoffice.domain.model.ShipmentStatus;
import jp.co.loft.backoffice.domain.service.shipmentstatus.ShipmentStatusService;

/**
 * 出荷ステータス情報のRestControllerクラス。<br>
 * 出荷検品業務におけるPDA端末からのリクエストを受け取る。<br>
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
 * <td><a href=
 * "../../../../../jp/co/xxx/ecbo/api/ShipmentStatusRestController.html#getShipmentStatus-java.lang.String-" >
 * <em>GET ShipmentStatus</em></a></td>
 * <td>GET</td>
 * <td><tt><span>/pda/shipmentstatuses/{inspectionNum}</span></tt></td>
 * <td><div>200</div> <div>(OK)</div></td>
 * <td>21)送り状情報取得。<br>
 * 指定された送り状番号に対する出荷ステータス情報を返す。<br>
 * </td>
 * </tr>
 * <tr style="border-bottom: 1px solid #D3D3D3;">
 * <td><div>2</div></td>
 * <td><a href=
 * "../../../../../jp/co/xxx/ecbo/api/ShipmentStatusRestController.html#putShipmentStatus-java.lang.String-jp.co.xxx.ecbo.domain.ShipmentStatus-"
 * ><em>PUT ShipmentStatus</em></a></td>
 * <td>PUT</td>
 * <td><tt><span>/pda/shipmentstatuses/{inspectionNum}</span></tt></td>
 * <td><div>200</div> <div>(OK)</div></td>
 * <td>22)出荷検品完了更新。<br>
 * 指定された送り状番号に対する出荷のステータスを出荷検品完了に更新する。<br>
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
 * <td>inspectionNum - 送り状番号</td>
 * <td>String</td>
 * <td>I/O</td>
 * <td>1-20</td>
 * <td>-</td>
 * </tr>
 * <tr style="border-bottom: 1px solid #D3D3D3;">
 * <td><div>5</div></td>
 * <td>odrStatus - 注文ステータス</td>
 * <td><div>String</div> <div>(Code)</div></td>
 * <td>O</td>
 * <td>2-2</td>
 * <td><div><tt><span>&quot;01&quot;</span></tt> : 受注(未仕分)</div> <div> <tt><span>&quot;02&quot;</span></tt> :
 * 仕分検品済(仕分検品完了)</div> <div> <tt><span>&quot;03&quot;</span></tt> : 欠品保留</div> <div>
 * <tt><span>&quot;04&quot;</span></tt> : 出荷保留</div> <div> <tt><span>&quot;05&quot;</span></tt> : 出荷検品中</div> <div>
 * <tt><span>&quot;06&quot;</span></tt> : 出荷検品完了</div> <div> <tt><span>&quot;90&quot;</span></tt> : その他</div></td>
 * </tr>
 * <tr style="border-bottom: 1px solid #D3D3D3;">
 * <td><div>6</div></td>
 * <td>shipmentKbn - 出荷ステータス</td>
 * <td><div>String</div> <div>(Code)</div></td>
 * <td>I</td>
 * <td>1-1</td>
 * <td><div><tt><span>&quot;0&quot;</span></tt> : 未検品(未仕分)</div> <div> <tt><span>&quot;1&quot;</span></tt> :
 * 検品済(出荷検品済)</div></td>
 * </tr>
 * <tr style="border-bottom: 1px solid #D3D3D3;">
 * <td><div>7</div></td>
 * <td>isAllInvoicesInspected - 他送り状検品有無フラグ</td>
 * <td><div>String</div> <div>(Code)</div></td>
 * <td>O</td>
 * <td>1-1</td>
 * <td><div><tt><span>&quot;0&quot;</span></tt> : 他送り状検品完了</div> <div> <tt><span>&quot;1&quot;</span></tt> : 未検品有</div>
 * </td>
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
 * "../../../../../jp/co/xxx/ecbo/api/ShipmentStatusRestController.html#getShipmentStatus-java.lang.String-" >
 * <em>GET ShipmentStatus</em></a></strong>
 * </p>
 * <p>
 * <strong>[リクエスト]</strong>
 * </p>
 * <div> <div>パス変数「<tt><span>inspectionNum</span></tt> 」に、取得対象のShipmentStatusリソースのIDを指定する。</div> <div>下記例では、パス変数「
 * <tt><span>inspectionNum</span></tt>」に<tt><span>0101111</span></tt> を指定している。</div> </div> <div style=
 * "background-color: #F5F5F5; border: solid 1px #D3D3D3;">
 * 
 * <pre>
 * &gt; GET /pda/shipmentstatuses/0101111 HTTP/1.1
 * </pre>
 * 
 * </div>
 * <p>
 * <strong>[レスポンス]</strong>
 * </p>
 * <p>
 * パス変数「<tt><span>inspectionNum</span></tt>」に一致するShipmentStatusリソースをJSON形式で返却する。
 * </p>
 * <div style="background-color: #F5F5F5; border: solid 1px #D3D3D3;"><div>
 * 
 * <pre>
 * &lt; HTTP/1.1 200 OK
 * &lt; Content-Type: application/json;charset<span>=</span>UTF-8
 * &lt;
 * <span>{</span><span>&quot;inspectionNum&quot;</span>:<span>&quot;0101111&quot;</span>,<span>&quot;odrStatus&quot;</span>:<span>&quot;02&quot;</span>,<span>&quot;isAllInvoicesInspected&quot;</span>:<span>&quot;0&quot;</span><span>}</span>
 * </pre>
 * 
 * </div> </div> </div> <div>
 * <p>
 * <strong><a href=
 * "../../../../../jp/co/xxx/ecbo/api/ShipmentStatusRestController.html#putShipmentStatus-java.lang.String-jp.co.xxx.ecbo.domain.ShipmentStatus-"
 * ><em>PUT ShipmentStatus</em></a></strong>
 * </p>
 * <p>
 * <strong>[リクエスト]</strong>
 * </p>
 * <div> <div>パス変数「<tt><span>inspectionNum</span></tt> 」に、更新対象のShipmentStatusのIDを指定する。</div> <div>PUT
 * ShipmentStatusでは、更新するShipmentStatusリソースの内容(出荷ステータス)をJSON形式で指定する。</div> </div> <div style=
 * "background-color: #F5F5F5; border: solid 1px #D3D3D3;">
 * 
 * <pre>
 * &gt; PUT /pda/shipmentstatuses/0101111 HTTP/1.1
 * &gt;
 * <span>{</span><span>&quot;shopCd&quot;</span>:<span>&quot;XXXXXXXXXX&quot;</span>,<span>&quot;terminalNum&quot;</span>:<span>&quot;YYYYYYYYYY&quot;</span>,<span>&quot;userId&quot;</span>:<span>&quot;ZZZZZZZZZ&quot;</span>,<span>&quot;shipmentKbn&quot;</span>:<span>&quot;1&quot;</span><span>}</span>
 * </pre>
 * 
 * </div>
 * <p>
 * <strong>[レスポンス]</strong>
 * </p>
 * <p>
 * パス変数「<tt><span>inspectionNum</span></tt> 」に一致するShipmentStatusリソースの内容(出荷ステータス)を更新し、レスポンスBODYは返却しない。
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
@RequestMapping("pda/shipmentstatuses")
public class ShipmentStatusRestController {

    /** 出荷ステータスサービスをインジェクション。 */
    @Autowired
    ShipmentStatusService shipmentService;

    /**
     * 21)送り状情報取得。<br>
     * 指定された送り状番号に対する出荷ステータス情報を返す。<br>
     * 
     * @param inspectionNum
     *            送り状番号。
     * @return 出荷ステータス情報。
     */
    // @RequestMappingアノテーションのvalue属性にパス変数(上記例では{inspectionNum})を指定する。
    // {inspectionNum}には、リソースを一意に識別するための値が指定される。
    @RequestMapping(value = "{inspectionNum}", method = RequestMethod.GET)
    // メソッドアノテーションとして、@org.springframework.web.bind.annotation.ResponseStatusアノテーションを付与し、応答するステータスコードを指定する。
    @ResponseStatus(HttpStatus.OK)
    // リソースを一意に識別するための値を、パス変数から取得する。
    // 引数アノテーションとして、@PathVariable("inspectionNum")を指定することで、パス変数({inspectionNum})に指定された値をメソッドの引数として受け取ることが出来る。
    public ShipmentStatusResponseResource getShipmentStatus(@PathVariable String inspectionNum) {
        ShipmentStatusRequestedResource shipmentStatusRequestedResource = new ShipmentStatusRequestedResource();
        shipmentStatusRequestedResource.setInspectionNum(inspectionNum);

        // ドメイン層のサービスのメソッドを呼び出し、パス変数から取得したIDに一致するリソースの情報(エンティティ等)を取得する。
        ShipmentStatusResult shipmentStatusResult = shipmentService.findShipmentStatus(inspectionNum);

        // 条件に一致したリソースの情報(エンティティ等)をもとに、Web上に公開する情報を保持するリソースオブジェクトを生成する。
        ShipmentStatusResponseResource shipmentStatusResponseResource = new ShipmentStatusResponseResource();
        BeanUtils.copyProperties(shipmentStatusResult,
                                 shipmentStatusResponseResource);

        // 生成したリソースオブジェクトを返却する。
        // ここで返却したオブジェクトがJSONやXMLにmarshalされ、レスポンスボディに設定される。
        return shipmentStatusResponseResource;
    }

    /**
     * 22)出荷検品完了更新。<br>
     * 指定された送り状番号に対する出荷のステータスを出荷検品完了に更新する。<br>
     * 
     * @param inspectionNum
     *            送り状番号。
     * @param shipmentStatusRequestedResource
     *            出荷ステータスオブジェクト。
     */
    // @RequestMappingアノテーションのvalue属性にパス変数(上記例では{inspectionNum})をを指定する。
    // {inspectionNum}には、リソースを一意に識別するための値が指定される。
    @RequestMapping(value = "{inspectionNum}", method = RequestMethod.PUT)
    // メソッドアノテーションとして、@org.springframework.web.bind.annotation.ResponseStatusアノテーションを付与し、応答するステータスコードを指定する。
    @ResponseStatus(HttpStatus.OK)
    // リソースの更新内容を受け取るためのJavaBean(リソースクラス)を引数に指定する。
    // 引数アノテーションとして、@RequestBodyアノテーションを付与することで、リクエストBodyに設定されているJSONやXMLのデータがリソースオブジェクトにunmarshalされる。
    // 入力チェックを有効化するために、引数アノテーションとして、@Validatedアノテーションを付与する。
    public void putShipmentStatus(@PathVariable String inspectionNum,
                                  @Validated({ PutShipmentStatus.class,
                                          Default.class }) @RequestBody ShipmentStatusRequestedResource shipmentStatusRequestedResource) {
        shipmentStatusRequestedResource.setInspectionNum(inspectionNum);

        ShipmentStatus shipmentStatus = new ShipmentStatus();
        BeanUtils.copyProperties(shipmentStatusRequestedResource,
                                 shipmentStatus);

        // ドメイン層のサービスのメソッドを呼び出し、パス変数から取得したIDに一致するリソースの情報(エンティティ等)を更新する。
        shipmentService.saveShipmentStatus(shipmentStatus);
    }

}
