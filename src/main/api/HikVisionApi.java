import com.jiang.utils.DataWrapper;

/**
 * Created by XiaoJiang01 on 2017/2/23.
 */
public interface HikVisionApi {

    /**
     *
     * @api {post} http://localhost:8080/iws/api/hikvision/add 添加摄像机
     * @apiName add
     * @apiGroup hikvision
     * @apiVersion 0.1.0
     * @apiDescription 添加摄像机
     *
     * @apiParam {String} token 身份验证
     * @apiParam {String} ip 必须 | ip
     * @apiParam {String} port 必须 | 端口
     * @apiParam {String} username 必须 | 用户名(默认值:admin)
     * @apiParam {String} password 必须 | 密码(默认值:12345)
     * @apiParam {String} protocol 非必须 | 通讯协议(1:http 2:https, 高级选项 一般配置不需填写)
     * @apiParam {String} streamType 非必须 | 媒体流(1:main stream 2:sub-stream 3:third stream 4:transcode stream, 高级选项 一般配置不需填写)
     * @apiParam {String} channelID 非必须 | 频道(高级选项 一般配置不需填写)
     * @apiParam {String} zeroChannel 非必须 | 0频道(填写 false/true,高级选项 一般配置不需填写)
     * @apiParam {String} locationId 必须 | 城区id
     * @apiParam {String} name 必须 | 名称
     * @apiParam {String} describes 非必须 | 描述
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
     * @api {post} http://localhost:8080/iws/api/hikvision/update 编辑摄像机
     * @apiName update
     * @apiGroup hikvision
     * @apiVersion 0.1.0
     * @apiDescription 编辑摄像机
     *
     * @apiParam {String} token 必须 | 身份验证
     * @apiParam {String} id 必须 | 摄像机id
     * @apiParam {String} ip 非必须 | ip
     * @apiParam {String} port 非必须 | 端口
     * @apiParam {String} username 非必须 | 用户名(默认值:admin)
     * @apiParam {String} password 非必须 | 密码(默认值:12345)
     * @apiParam {String} protocol 非必须 | 通讯协议(1:http 2:https, 高级选项 一般配置不需填写)
     * @apiParam {String} streamType 非必须 | 媒体流(1:main stream 2:sub-stream 3:third stream 4:transcode stream, 高级选项 一般配置不需填写)
     * @apiParam {String} channelID 非必须 | 频道(高级选项 一般配置不需填写)
     * @apiParam {String} zeroChannel 非必须 | 0频道(填写 false/true,高级选项 一般配置不需填写)
     * @apiParam {String} name 非必须 | 名称
     * @apiParam {String} describes 非必须 | 描述
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
     * @api {post} http://localhost:8080/iws/api/hikvision/delete 删除摄像机
     * @apiName delete
     * @apiGroup hikvision
     * @apiVersion 0.1.0
     * @apiDescription 删除摄像机
     *
     * @apiParam {int} hikvisionId 摄像机id
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
     * @api {get} http://localhost:8080/iws/api/hikvision/list 摄像机列表
     * @apiName list
     * @apiGroup hikvision
     * @apiVersion 0.1.0
     * @apiDescription 摄像机列表
     *
     * @apiParam {String} token 身份验证
     *
     * @apiSuccessExample Success-Response:
     *  HTTP/1.1 200 OK
     * {
     * callStatus:"SUCCEED",
     * errorCode:"No_Error",
     * data(List):{
     *     id:1,
     *     areaId:"110101",
     *     ip:"192.168.2.1",
     *     port:"80",
     *     username:"admin",
     *     password:"12345",
     *     protocol:1,
     *     streamType:1,
     *     channelID:1,
     *     zeroChannel:false,
     *     positionX:130.1234678,
     *     positionY:123.1234687,
     *     name:"XX街道摄像头",
     *     describes:"道路摄像头"
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
     * @api {get} http://localhost:8080/iws/api/hikvision/detail 摄像机详情
     * @apiName detail
     * @apiGroup hikvision
     * @apiVersion 0.1.0
     * @apiDescription 摄像机详情
     *
     * @apiParam {String} token 身份验证
     * @apiParam {int} id 摄像头id
     *
     * @apiSuccessExample Success-Response:
     *  HTTP/1.1 200 OK
     * {
     * callStatus:"SUCCEED",
     * errorCode:"No_Error",
     * data:{
     *     id:1,
     *     areaId:"110101",
     *     ip:"192.168.2.1",
     *     port:"80",
     *     username:"admin",
     *     password:"12345",
     *     protocol:1,
     *     streamType:1,
     *     channelID:1,
     *     zeroChannel:false,
     *     positionX:130.1234678,
     *     positionY:123.1234687,
     *     name:"XX街道摄像头",
     *     describes:"道路摄像头"
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
     * @api {get} http://localhost:8080/iws/api/hikvision/query 查询摄像机
     * @apiName query
     * @apiGroup hikvision
     * @apiVersion 0.1.0
     * @apiDescription 查询摄像机
     *
     * @apiParam {String} token 身份验证
     * @apiParam {String} locationId 必须 | 城区id
     * @apiParam {String} ip 非必须 | ip地址
     * @apiParam {String} name 非必须 | 摄像机名称(模糊查询)
     *
     * @apiSuccessExample Success-Response:
     *  HTTP/1.1 200 OK
     * {
     * callStatus:"SUCCEED",
     * errorCode:"No_Error",
     * data(List):{
     *     id:1,
     *     areaId:"110101",
     *     ip:"192.168.2.1",
     *     port:"80",
     *     username:"admin",
     *     password:"12345",
     *     protocol:1,
     *     streamType:1,
     *     channelID:1,
     *     zeroChannel:false,
     *     positionX:130.1234678,
     *     positionY:123.1234687,
     *     name:"XX街道摄像头",
     *     describes:"道路摄像头"
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
     * @api {get} http://localhost:8080/iws/api/hikvision/downloadComponent 下载插件
     * @apiName downloadComponent
     * @apiGroup hikvision
     * @apiVersion 0.1.0
     * @apiDescription 下载插件
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
     * @api {post} http://localhost:8080/iws/api/hikvision/addHikToUser 用户添加摄像机到自己
     * @apiName addHikToUser
     * @apiGroup hikvision
     * @apiVersion 0.1.0
     * @apiDescription 用户添加摄像机到自己
     *
     * @apiParam {int} hikId    not null | 摄像机id
     * @apiParam {String} token not null | 身份验证
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
     * @api {post} http://localhost:8080/iws/api/hikvision/deleteHikFromUser 用户删除自己摄像机
     * @apiName deleteHikFromUser
     * @apiGroup hikvision
     * @apiVersion 0.1.0
     * @apiDescription 用户删除自己摄像机
     *
     * @apiParam {int} hikId    not null | 摄像机id
     * @apiParam {String} token not null | 身份验证
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
