/**
 * Created by XiaoJiang01 on 2017/2/23.
 */
public interface LocationApi {

    /**
     *
     * @api {get} http://localhost:8080/iws/api/log/list 日志列表
     * @apiName list
     * @apiGroup log
     * @apiVersion 0.1.0
     * @apiDescription 返回全部日志
     *
     * @apiParam {String} token 身份验证
     * @apiParam {String} startTime 开始时间 nullalbe
     * @apiParam {String} endTime 结束时间 nullable
     * @apiParam {String} type 消息状态 nullable(1操作日志,2异常日志)
     *
     *
     * @apiSuccessExample Success-Response:
     *  HTTP/1.1 200 OK
     * {
     * callStatus:"SUCCEED",
     * errorCode:"No_Error",
     * data(List):{
     *      id:1
     *      userId:1
     *      userName:"管理员"
     *      type:1(1操作日志,2异常日志)
     *      time:14782145
     *      describes:"添加控制器"
     *      errorCode:null
     *      ip:"127.0.0.1"
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
}
