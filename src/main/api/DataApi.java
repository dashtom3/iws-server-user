/**
 * Created by XiaoJiang01 on 2017/2/23.
 */
public interface LocationApi {

    /**
     *
     * @api {get} http://localhost:8080/iws/api/data/query 查询历史数据
     * @apiName query
     * @apiGroup data
     * @apiVersion 0.1.0
     * @apiDescription 传条件查询,返回条件下全部数据。
     *
     * @apiParam {String} deviceId 设备id
     * @apiParam {String} startTime 开始时间id(日期格式:'yyyy-MM-dd HH:mm:ss')
     * @apiParam {String} endTime 结束时间id(日期格式:'yyyy-MM-dd HH:mm:ss')
     * @apiParam {String} timeStep 时间间隔id(以秒为单位,如:间隔为1分钟,传入60)
     * @apiParam {String} token 身份验证
     *
     *
     * @apiSuccessExample Success-Response:
     *  HTTP/1.1 200 OK
     * {
     * callStatus:"SUCCEED",
     * errorCode:"No_Error",
     * data:{
     *      id:1
     *      groupid:1
     *      deviceid:1
     *      com:1
     *      number:1
     *      time:'2017-01-01 12:00:00'
     *      error:'No_Exception'
     *      count:40(数据总数为40)
     *      data(List):{
     *          name:"泵前压力"
     *          data:"10Kpa"
     *          exception:"No_Exception"
     *      }
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
     * @api {get} http://localhost:8080/iws/api/data/todayData 查询当日数据
     * @apiName todayData
     * @apiGroup data
     * @apiVersion 0.1.0
     * @apiDescription 传条件查询,返回条件下全部数据。
     *
     * @apiParam {String} deviceId 设备id
     * @apiParam {String} startTime 开始时间id(日期格式:'yyyy-MM-dd HH:mm:ss')
     * @apiParam {String} endTime 结束时间id(日期格式:'yyyy-MM-dd HH:mm:ss')
     * @apiParam {String} timeStep 时间间隔id(以秒为单位,如:间隔为1分钟,传入60)
     * @apiParam {String} token 身份验证
     *
     *
     * @apiSuccessExample Success-Response:
     *  HTTP/1.1 200 OK
     * {
     * callStatus:"SUCCEED",
     * errorCode:"No_Error",
     * data:{
     *      id:1
     *      groupid:1
     *      deviceid:1
     *      com:1
     *      number:1
     *      time:'2017-01-01 12:00:00'
     *      error:'No_Exception'
     *      count:40(数据总数为40)
     *      data(List):{
     *          name:"泵前压力"
     *          data:"10Kpa"
     *          exception:"No_Exception"
     *      }
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
     * @api {get} http://localhost:8080/iws/api/data/presentData 实时数据查询
     * @apiName presentData
     * @apiGroup data
     * @apiVersion 0.1.0
     * @apiDescription 查询当前时刻数据
     *
     * @apiParam {String} deviceId 设备id
     * @apiParam {String} token 身份验证
     *
     *
     * @apiSuccessExample Success-Response:
     *  HTTP/1.1 200 OK
     * {
     * callStatus:"SUCCEED",
     * errorCode:"No_Error",
     * data:{
     *      id:1
     *      groupid:1
     *      deviceid:1
     *      com:1
     *      number:1
     *      time:'2017-01-01 12:00:00'
     *      error:'No_Exception'
     *      count:40(数据总数为40)
     *      data(List):{
     *          name:"泵前压力"
     *          data:"10Kpa"
     *          exception:"No_Exception"
     *      }
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
     * @api {get} http://localhost:8080/iws/api/data/outputExcel 导出Excel
     * @apiName outputExcel
     * @apiGroup data
     * @apiVersion 0.1.0
     * @apiDescription 传条件查询,返回条件下全部数据的Excel。
     *
     * @apiParam {String} deviceId 设备id
     * @apiParam {String} startTime 开始时间id(日期格式:'yyyy-MM-dd HH:mm:ss')
     * @apiParam {String} endTime 结束时间id(日期格式:'yyyy-MM-dd HH:mm:ss')
     * @apiParam {String} timeStep 时间间隔id(以秒为单位,如:间隔为1分钟,传入60)
     * @apiParam {String} token 身份验证
     *
     *
     * @apiSuccessExample Success-Response:
     *  HTTP/1.1 200 OK
     * {
     * callStatus:"SUCCEED",
     * errorCode:"No_Error",
     * data:null
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
     * @api {get} http://localhost:8080/iws/api/data/modelData 模型数据查询
     * @apiName modelData
     * @apiGroup data
     * @apiVersion 0.1.0
     * @apiDescription 查询模型所需当前时刻数据, 返回值按模型对应位置顺序排列
     *
     * @apiParam {String} deviceId 设备id
     * @apiParam {String} token 身份验证
     *
     *
     * @apiSuccessExample Success-Response:
     *  HTTP/1.1 200 OK
     * {
     * callStatus:"SUCCEED",
     * errorCode:"No_Error",
     * data:{
     *      id:1
     *      groupid:1
     *      deviceid:1
     *      com:1
     *      number:1
     *      time:'2017-01-01 12:00:00'
     *      error:'No_Exception'
     *      count:40(数据总数为40)
     *      data(List):{
     *          name:"泵前压力"
     *          data:"10Kpa"
     *          exception:"No_Exception"
     *      }
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
     * @api {get} http://localhost:8080/iws/api/data/pumpStatus 泵机状态显示
     * @apiName pumpStatus
     * @apiGroup data
     * @apiVersion 0.1.0
     * @apiDescription 泵机状态显示
     *
     * @apiParam {String} deviceId 设备id
     * @apiParam {String} token 身份验证
     *
     *
     * @apiSuccessExample Success-Response:
     *  HTTP/1.1 200 OK
     * {
     * callStatus:"SUCCEED",
     * errorCode:"No_Error",
     * data(List):{
     *      name:"1#状态"
     *      data:"1"
     *      exception:"No_Exception"
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
