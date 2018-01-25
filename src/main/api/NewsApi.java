/**
 * Created by XiaoJiang01 on 2017/2/23.
 */
public interface LocationApi {

    /**
     *
     * @api {get} http://localhost:8080/iws/api/news/list 消息列表
     * @apiName list
     * @apiGroup news
     * @apiVersion 0.1.0
     * @apiDescription 返回全部消息
     *
     * @apiParam {String} token 身份验证
     * @apiParam {String} startTime 开始时间 nullalbe
     * @apiParam {String} endTime 结束时间 nullable
     * @apiParam {String} status 消息状态 nullable(1已确认,2未确认)
     * @apiParam {String} systemId 系统id nullable
     *
     *
     * @apiSuccessExample Success-Response:
     *  HTTP/1.1 200 OK
     * {
     * callStatus:"SUCCEED",
     * errorCode:"No_Error",
     * data(List):{
     *     id:1,
     *     alarmid:1,
     *     userid:1(确认人,若未确认则该项为空),
     *     status:1(1已确认,2未确认),
     *     alarmtime:"2017-01-01 12:00:00",
     *     confirmtime:"2017-01-01 12:00:00",
     *     name:"报警01"
     *     describes:"供水系统 XX省XX市XX区 A小区 01泵房 XX设备 水压故障",
     *     userName:"XXX"(确认人,若未确认则该项为空)
     *     systemName:"XX系统"
     * }
     * token:"SK1d7a4fe3-c2cd-417f-8f6f-bf7412592996",
     * numberPerPage:0,
     * currentPage:0,
     * totalNumber:0,
     * totalPage:0
     *  }
     *
     *  @apiErrorExample {json} Error-Response:
     *  HTTP/1.1 200 OK
     * {
     * callStatus:"FAILED",
     * errorCode:"Error",
     * data:null,
     * token:null,
     * numberPerPage:0,
     * currentPage:0,
     * totalNumber:0,
     * totalPage:0
     *  }
     *
     */

    /**
     *
     * @api {post} http://localhost:8080/iws/api/news/confirm 消息确认
     * @apiName confirm
     * @apiGroup news
     * @apiVersion 0.1.0
     * @apiDescription 确认消息
     *
     * @apiParam {String} token 身份验证
     * @apiParam {int} newsId 消息id
     *
     * @apiSuccessExample Success-Response:
     *  HTTP/1.1 200 OK
     * {
     * callStatus:"SUCCEED",
     * errorCode:"No_Error",
     * data:null,
     * token:"SK1d7a4fe3-c2cd-417f-8f6f-bf7412592996",
     * numberPerPage:0,
     * currentPage:0,
     * totalNumber:0,
     * totalPage:0
     *  }
     *
     *  @apiErrorExample {json} Error-Response:
     *  HTTP/1.1 200 OK
     * {
     * callStatus:"FAILED",
     * errorCode:"Error",
     * data:null,
     * token:null,
     * numberPerPage:0,
     * currentPage:0,
     * totalNumber:0,
     * totalPage:0
     *  }
     *
     */
}
