/**
 * Created by XiaoJiang01 on 2017/2/23.
 */
public interface LocationApi {

    /**
     *
     * @api {post} http://localhost:8080/iws/api/model/add 添加模型内参数
     * @apiName add
     * @apiGroup model
     * @apiVersion 0.1.0
     * @apiDescription 添加模型内参数
     *
     * @apiParam {String} token 身份验证
     * @apiParam {String} fieldId 字段ID(按对应顺序排序,以","分隔. 例:13,14,17)
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
     * @api {post} http://localhost:8080/iws/api/model/delete 删除模型内参数
     * @apiName delete
     * @apiGroup model
     * @apiVersion 0.1.0
     * @apiDescription 删除模型内参数
     *
     * @apiParam {String} token 身份验证
     * @apiParam {String} termId 控制器ID
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
     * @api {post} http://localhost:8080/iws/api/model/update 修改模型内参数
     * @apiName update
     * @apiGroup model
     * @apiVersion 0.1.0
     * @apiDescription 修改模型内参数
     *
     * @apiParam {String} token 身份验证
     * @apiParam {String} fieldId 字段ID(按对应顺序排序,以","分隔. 例:1,5,7. 如修改部分参数也须传全部参数, 例: 将1,2,3改为1,2,4, 则传1,2,4)
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
     * @api {get} http://localhost:8080/iws/api/model/detail 查询模型某一参数
     * @apiName detail
     * @apiGroup model
     * @apiVersion 0.1.0
     * @apiDescription 查询模型某一参数
     *
     * @apiParam {String} token 身份验证
     * @apiParam {String} fieldId 字段ID
     *
     * @apiSuccessExample Success-Response:
     *  HTTP/1.1 200 OK
     * {
     * callStatus:"SUCCEED",
     * errorCode:"No_Error",
     * data:{
     *     id:字段ID,
     *     termId:所属控制器ID,
     *     roleId:字段释义规则ID,
     *     name:字段名称,
     *     modelId:对应模型数据位置
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
     * @api {get} http://localhost:8080/iws/api/model/list 查询模型全部参数
     * @apiName list
     * @apiGroup model
     * @apiVersion 0.1.0
     * @apiDescription 查询模型全部参数
     *
     * @apiParam {String} token 身份验证
     * @apiParam {String} termId 控制器ID
     *
     * @apiSuccessExample Success-Response:
     *  HTTP/1.1 200 OK
     * {
     * callStatus:"SUCCEED",
     * errorCode:"No_Error",
     * data(List):{
     *     id:字段ID,
     *     termId:所属控制器ID,
     *     roleId:字段释义规则ID,
     *     name:字段名称,
     *     modelId:对应模型数据位置
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
