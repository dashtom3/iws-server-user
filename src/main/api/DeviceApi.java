/**
 * Created by XiaoJiang01 on 2017/2/24.
 */
public interface DeviceApi {

    /**
     *
     * @api {post} http://localhost:8080/iws/api/device/addGroup 添加设备组
     * @apiName addGroup
     * @apiGroup device
     * @apiVersion 0.1.0
     * @apiDescription 添加设备组
     *
     * @apiParam {String} terms 设备id的字符串(格式:"1,2,3,")
     * @apiParam {int} type 设备类型
     * @apiParam {String} name 设备名称
     * @apiParam {String} describes 设备描述
     * @apiParam {String} token 身份验证
     *
     * @apiSuccessExample Success-Response:
     *  HTTP/1.1 200 OK
     * {
     * callStatus:"SUCCEED",
     * errorCode:"No_Error",
     * data:{
     *     id:1,
     *     terms:"1,2,"
     *     status:1,
     *     type:"水箱变频",
     *     name:"水箱变频001",
     *     describes:"123",
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
     * @api {post} http://localhost:8080/iws/api/device/delete 删除设备组
     * @apiName delete
     * @apiGroup device
     * @apiVersion 0.1.0
     * @apiDescription 删除设备组
     *
     * @apiParam {int} groupId 设备id
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
     * @api {post} http://localhost:8080/iws/api/device/update 编辑设备组
     * @apiName update
     * @apiGroup device
     * @apiVersion 0.1.0
     * @apiDescription 编辑修改设备
     *
     * @apiParam {int} id 设备组id
     * @apiParam {List} devices 设备实例int数组(基本设备id)
     * @apiParam {String} type 设备类型
     * @apiParam {String} name 设备名称
     * @apiParam {String} describes 设备描述
     * @apiParam {String} token 身份验证
     *
     * @apiSuccessExample Success-Response:
     *  HTTP/1.1 200 OK
     * {
     * callStatus:"SUCCEED",
     * errorCode:"No_Error",
     * data:{
     *     id:1,
     *     terms:"1,2,"
     *     status:1,
     *     type:"水箱变频",
     *     name:"水箱变频001",
     *     describes:"123",
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
     * @api {get} http://localhost:8080/iws/api/device/list 设备组列表
     * @apiName list
     * @apiGroup device
     * @apiVersion 0.1.0
     * @apiDescription 设备组列表
     *
     * @apiParam {String} token 身份验证
     *
     * @apiSuccessExample Success-Response:
     *  HTTP/1.1 200 OK
     * {
     * callStatus:"SUCCEED",
     * errorCode:"No_Error",
     * data:{
     *     id:1,
     *     terms:"1,2,"
     *     status:1,
     *     type:"水箱变频",
     *     name:"水箱变频001",
     *     describes:"123",
     *     deviceTerm(List):{
     *          id:1,
     *          count:41,
     *          protocol:"MODBUS",
     *          type:1,
     *          name:"PLC设备",
     *          describes:"PLC设备"
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
     * @api {get} http://localhost:8080/iws/api/device/groupDetail 设备组详情
     * @apiName groupDetail
     * @apiGroup device
     * @apiVersion 0.1.0
     * @apiDescription 查看设备组详情
     * @apiParam {String} groupId 设备id
     * @apiParam {String} token 身份验证
     *
     * @apiSuccessExample Success-Response:
     *  HTTP/1.1 200 OK
     * {
     * callStatus:"SUCCEED",
     * errorCode:"No_Error",
     * data:{
     *     id:1,
     *     terms:"1,2,"
     *     status:1,
     *     type:"水箱变频",
     *     name:"水箱变频001",
     *     describes:"123",
     *     deviceTerm(List):{
     *          id:1,
     *          count:41,
     *          protocol:"MODBUS",
     *          type:1,
     *          name:"PLC设备",
     *          describes:"PLC设备"
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
     * @api {get} http://localhost:8080/iws/api/device/groupType 设备组类型列表
     * @apiName groupType
     * @apiGroup device
     * @apiVersion 0.1.0
     * @apiDescription 设备组类型列表
     * @apiParam {String} token 身份验证
     *
     * @apiSuccessExample Success-Response:
     *  HTTP/1.1 200 OK
     * {
     * callStatus:"SUCCEED",
     * errorCode:"No_Error",
     * data:{
     *     id:1
     *     systemid:1
     *     name:"水箱变频"
     *     describes:"123"
     *     pic:"123"
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
}
