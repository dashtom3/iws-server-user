/**
 * Created by XiaoJiang01 on 2017/2/23.
 */
public interface RoomApi {
    /**
     *
     * @api {post} http://localhost:8080/iws/api/room/add 添加泵房
     * @apiName add
     * @apiGroup room
     * @apiVersion 0.1.0
     * @apiDescription 添加新泵房
     *
     * @apiParam {int} locationId 泵房所属区域地点id
     * @apiParam {String} name 泵房名称
     * @apiParam {String} describes 泵房描述
     * @apiParam {String} token 身份验证
     *
     * @apiSuccessExample Success-Response:
     *  HTTP/1.1 200 OK
     * {
     * callStatus:"SUCCEED",
     * errorCode:"No_Error",
     * data:{
     *     id:1,
     *     locationId:1,
     *     name:"123",
     *     describes:"123"
     * },
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
     * }
     *
     */

    /**
     *
     * @api {post} http://localhost:8080/iws/api/room/delete 删除泵房
     * @apiName delete
     * @apiGroup room
     * @apiVersion 0.1.0
     * @apiDescription 删除泵房
     *
     * @apiParam {String} roomId 泵房id
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
     * @api {post} http://localhost:8080/iws/api/room/update 编辑泵房
     * @apiName update
     * @apiGroup room
     * @apiVersion 0.1.0
     * @apiDescription 编辑修改系统，更改系统状态
     *
     * @apiParam {int} id 泵房id
     * @apiParam {int} locationId 泵房所属区域地点id
     * @apiParam {String} name 泵房名称
     * @apiParam {String} describes 泵房描述
     * @apiParam {String} token 身份验证
     *
     * @apiSuccessExample Success-Response:
     *  HTTP/1.1 200 OK
     * {
     * callStatus:"SUCCEED",
     * errorCode:"No_Error",
     * data:{
     *     id:1,
     *     locationId:1,
     *     name:"123",
     *     describes:"123"
     * },
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
     * @api {post} http://localhost:8080/iws/api/room/detail 查看泵房
     * @apiName detail
     * @apiGroup room
     * @apiVersion 0.1.0
     * @apiDescription 获取某一泵房及泵房所属地点、泵房内所有控制器
     *
     * @apiParam {int} roomId 泵房id
     * @apiParam {String} token 身份验证
     *
     * @apiSuccessExample Success-Response:
     *  HTTP/1.1 200 OK
     * {
     * callStatus:"SUCCEED",
     * errorCode:"No_Error",
     * data:{
     *      id:1,
     *      locationId:1,
     *      name:"name",
     *      describes:"describes"
     *      location:{
     *          id:1，
     *          systemId:1，
     *          areaId:110101,
     *          positionX:123.1234567890,
     *          positionY:123.123456,
     *          name:"name",
     *          describes:"describes",
     *      }
     *      deviceGroup(List):{
     *          id:1,
     *          roomId:1,
     *          status:1,(1运行,2停止)
     *          type:"水箱变频",
     *          name:"水箱变频001",
     *          describes:"describes"
     *      }
     *
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
     * @api {post} http://localhost:8080/iws/api/room/addDevice 添加控制器
     * @apiName addDevice
     * @apiGroup room
     * @apiVersion 0.1.0
     * @apiDescription 创建控制器实例
     *
     * @apiParam {int} roomId 泵房id
     * @apiParam {String} port 端口号
     * @apiParam {String} name 名称
     * @apiParam {String} describes 描述
     * @apiParam {List} terms 控制器json数组(termId 终端id,number 编号)
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
     * @api {post} http://localhost:8080/iws/api/room/updateDevice 编辑控制器
     * @apiName addDevice
     * @apiGroup room
     * @apiVersion 0.1.0
     * @apiDescription 创建控制器实例
     *
     * @apiParam {int} roomId 泵房id
     * @apiParam {int} groupId 控制器组id
     * @apiParam {String} port 端口号
     * @apiParam {String} name 名称
     * @apiParam {String} describes 描述
     * @apiParam {List} terms 控制器json数组(termId 终端id,number 编号)
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
     * @api {post} http://localhost:8080/iws/api/room/deleteDevice 删除控制器
     * @apiName deleteDevice
     * @apiGroup room
     * @apiVersion 0.1.0
     * @apiDescription 创建控制器实例
     *
     * @apiParam {int} groupId 控制器组id
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
     * @api {get} http://localhost:8080/iws/api/room/groupList 控制器组列表
     * @apiName groupList
     * @apiGroup room
     * @apiVersion 0.1.0
     * @apiDescription 控制器组列表
     *
     * @apiParam {int} roomId 控制器组id
     * @apiParam {String} token 身份验证
     *
     * @apiSuccessExample Success-Response:
     *  HTTP/1.1 200 OK
     * {
     * callStatus:"SUCCEED",
     * errorCode:"No_Error",
     * data(List):{
     *      groupId:1
     *      roomId:1
     *      roomName:"1泵房"
     *      name:"1控组"
     *      describes:"测试控制器"
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
     * @api {get} http://localhost:8080/iws/api/room/groupDetail 控制器组详情
     * @apiName groupDetail
     * @apiGroup room
     * @apiVersion 0.1.0
     * @apiDescription 控制器组详情
     *
     * @apiParam {int} groupId 控制器组id
     * @apiParam {String} token 身份验证
     *
     * @apiSuccessExample Success-Response:
     *  HTTP/1.1 200 OK
     * {
     * callStatus:"SUCCEED",
     * errorCode:"No_Error",
     * data:{
     *      groupId:1
     *      roomId:1
     *      roomName:"1泵房"
     *      name:"1控组"
     *      describes:"测试控制器"
     *
     *      devices(List):{
     *          id:1,
     *          groupId:1,
     *          termId:1,
     *          status:1,
     *          port:"178.12.2.216"
     *          number:"01"
     *          name:"XX泵房控制器"
     *          describes:"XX泵房控制器"
     *          termName:"PLC01"
     *          termType:"PLC"
     *          count:41
     *          protocol:"TCP"
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
     * @api {post} http://localhost:8080/iws/api/room/start 开启数据采集
     * @apiName start
     * @apiGroup room
     * @apiVersion 0.1.0
     * @apiDescription 开启数据采集
     * @apiParam {int} groupId 控制器组id
     * @apiParam {String} token 身份验证
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
     * @api {post} http://localhost:8080/iws/api/room/close 关闭数据采集
     * @apiName close
     * @apiGroup room
     * @apiVersion 0.1.0
     * @apiDescription 关闭数据采集
     * @apiParam {int} groupId 控制器组id
     * @apiParam {String} token 身份验证
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
     * @api {post} http://localhost:8080/iws/api/room/test 测试
     * @apiName test
     * @apiGroup room
     * @apiVersion 0.1.0
     * @apiDescription 创建控制器实例
     *
     * @apiParam {int} roomId 泵房id
     * @apiParam {String} port 端口号
     * @apiParam {String} name 名称
     * @apiParam {String} describes 描述
     * @apiParam {List} terms 控制器json数组(termId 终端id,number 编号)
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
     * @api {post} http://localhost:8080/iws/api/room/manual 远程启停水泵
     * @apiName manual
     * @apiGroup room
     * @apiVersion 0.1.0
     * @apiDescription 创建控制器实例
     *
     * @apiParam {String} token 身份验证
     * @apiParam {String} deviceId 控制器id
     * @apiParam {String} number 字段编号
     * @apiParam {String} pumpStatus 泵机状态(自动/关闭传0, 手动/开启传1)
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
