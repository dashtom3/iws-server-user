/**
 * Created by XiaoJiang01 on 2017/2/24.
 */
public interface RoleApi {

    /**
     *
     * @api {post} http://localhost:8080/iws/api/deviceTerm/pointRole 字段规则
     * @apiName pointRole
     * @apiGroup deviceTerm
     * @apiVersion 0.1.0
     * @apiDescription 获取点表字段规则
     *
     * @apiParam {String} token 身份验证
     *
     * @apiSuccessExample Success-Response:
     *  HTTP/1.1 200 OK
     * {
     * callStatus:"SUCCEED",
     * errorCode:"No_Error",
     * data(List):{
     *     id:2,
     *     protocol:"MODBUS",
     *     type:2(1表示实际值参数,2表示状态参数 8个点位,3表示写入参数0/1 1个点位),
     *     bit:2(2表示参数为2进制),
     *     name:"状态参数",
     *     describes:"0/1对应不同状态(8个点位)",
     *     bit01:"变频故障",
     *     bit02:"空开故障",
     *     bit03:"热继故障",
     *     bit04:"泵工频",
     *     bit05:"泵变频",
     *     bit06:"泵故障",
     *     bit07:"泵运行",
     *     bit08:"泵休息",
     *     write:null
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
     * @api {post} http://localhost:8080/iws/api/deviceTerm/add 添加控制器
     * @apiName add
     * @apiGroup deviceTerm
     * @apiVersion 0.1.0
     * @apiDescription 创建控制器
     *
     * @apiParam {List} fields 控制器点表字段(number 字段数; roleId 字段规则id; name 名称; describes 描述; unit 单位; min 下限值; max 上限值; multiple 检测值倍数)
     * @apiParam {int} count 字段参数数量
     * @apiParam {String} protocol 通讯协议
     * @apiParam {int}   start 寄存器首地址
     * @apiParam {String} type 控制器类型
     * @apiParam {String} name 控制器名称
     * @apiParam {String} describes 控制器描述
     * @apiParam {String} token 身份验证
     *
     * @apiSuccessExample Success-Response:
     *  HTTP/1.1 200 OK
     * {
     * callStatus:"SUCCEED",
     * errorCode:"No_Error",
     * data:{
     *     id:1,
     *     count:20,
     *     protocol:"MODBUS",
     *     type:"电压表",
     *     name:"电压表001",
     *     describes:"123"
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
     * @api {post} http://localhost:8080/iws/api/deviceTerm/delete 删除控制器
     * @apiName delete
     * @apiGroup deviceTerm
     * @apiVersion 0.1.0
     * @apiDescription 删除控制器
     *
     * @apiParam {int} deviceTermId 控制器id
     * @apiParam {String} token 身份验证
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

    /**
     *
     * @api {post} http://localhost:8080/iws/api/deviceTerm/update 编辑控制器
     * @apiName update
     * @apiGroup deviceTerm
     * @apiVersion 0.1.0
     * @apiDescription 编辑修改控制器
     *
     * @apiParam {String} name 控制器名称
     * @apiParam {String} describes 控制器描述
     * @apiParam {String} token 身份验证
     *
     * @apiSuccessExample Success-Response:
     *  HTTP/1.1 200 OK
     * {
     * callStatus:"SUCCEED",
     * errorCode:"No_Error",
     * data:{
     *     id:1,
     *     count:20,
     *     protocol:"MODBUS",
     *     type:"电压表",
     *     name:"电压表001",
     *     describes:"123"
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
     * @api {post} http://localhost:8080/iws/api/deviceTerm/list 控制器列表
     * @apiName list
     * @apiGroup deviceTerm
     * @apiVersion 0.1.0
     * @apiDescription 查看控制器详情
     *
     * @apiParam {int} type 身份验证
     * @apiParam {String} token 身份验证
     *
     * @apiSuccessExample Success-Response:
     *  HTTP/1.1 200 OK
     * {
     * callStatus:"SUCCEED",
     * errorCode:"No_Error",
     * data(List):{
     *     id:1,
     *     count:20,
     *     protocol:"MODBUS",
     *     type:1,
     *     name:"电压表001",
     *     describes:"123"
     *     }
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
     * @api {post} http://localhost:8080/iws/api/deviceTerm/detail 控制器详情
     * @apiName detail
     * @apiGroup deviceTerm
     * @apiVersion 0.1.0
     * @apiDescription 查看控制器详情
     * @apiParam {String} deviceTermId 控制器id
     * @apiParam {String} token 身份验证
     *
     * @apiSuccessExample Success-Response:
     *  HTTP/1.1 200 OK
     * {
     * callStatus:"SUCCEED",
     * errorCode:"No_Error",
     * data:{
     *     id:1,
     *     count:20,
     *     protocol:"MODBUS",
     *     type:"电压表"
     *     name:"电压表001",
     *     describes:"123"
     *     fields(List):{
     *         id:1,
     *         deviceid:1,
     *         number:1(表示点表的第一个字段),
     *         roleid:1(表示使用哪一项释义规则),
     *         name:"泵前压力",
     *         describes:"值的意义",
     *         unit:"Kpa",
     *         min:1000,
     *         max:2000,
     *         multiple:1000(表示实际值×1000)
     *         }
     *     }
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
     * @api {post} http://localhost:8080/iws/api/deviceTerm/typeList 控制器类型列表
     * @apiName typeList
     * @apiGroup deviceTerm
     * @apiVersion 0.1.0
     * @apiDescription 控制器类型列表
     * @apiParam {String} token 身份验证
     *
     * @apiSuccessExample Success-Response:
     *  HTTP/1.1 200 OK
     * {
     * callStatus:"SUCCEED",
     * errorCode:"No_Error",
     * data:{
     *     id:1,
     *     name:"电压表",
     *     pic:"img/001.jpg"
     *     describes:"123"
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
     * @api {post} http://localhost:8080/iws/api/deviceTerm/query 查询控制器
     * @apiName query
     * @apiGroup deviceTerm
     * @apiVersion 0.1.0
     * @apiDescription 按条件查询控制器
     *
     * @apiParam {String} protocol 通讯协议
     * @apiParam {String} type 控制器类型
     * @apiParam {String} name 控制器名称
     * @apiParam {String} token 身份验证
     *
     * @apiSuccessExample Success-Response:
     *  HTTP/1.1 200 OK
     * {
     * callStatus:"SUCCEED",
     * errorCode:"No_Error",
     * data:{
     *     id:1,
     *     count:20,
     *     protocol:"MODBUS",
     *     type:"电压表"
     *     name:"电压表001",
     *     describes:"123"
     *     }
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
     */
}
