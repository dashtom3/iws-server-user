import com.jiang.utils.DataWrapper;

/**
 * Created by XiaoJiang01 on 2017/2/23.
 */
public interface UserManageApi {

    /**
     *
     * @api {get} http://localhost:8080/iws/api/userManage/role 编辑用户角色
     * @apiName role
     * @apiGroup userManage
     * @apiVersion 0.1.0
     * @apiDescription 编辑用户角色
     *
     * @apiParam {int} userId 用户id
     * @apiParam {String} roleId 角色id
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
     * @api {get} http://localhost:8080/iws/api/userManage/status 编辑用户状态
     * @apiName status
     * @apiGroup userManage
     * @apiVersion 0.1.0
     * @apiDescription 编辑用户状态，关闭/开启/审核 用户（此功能依据需要启用）
     *
     * @apiParam {int} userId 用户id
     * @apiParam {int} status 用户状态 0:正常 1:关闭
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
     * @api {get} http://localhost:8080/iws/api/userManage/list 用户列表
     * @apiName list
     * @apiGroup userManage
     * @apiVersion 0.1.0
     * @apiDescription 获取用户列表
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
     *     username:18712345678,
     *     password:"d1b2cc725d846f0460ff290c60925070",
     *     roleid:1,
     *     status:1,
     *     date:2017-01-01 12:00:00,
     *     name:"name",
     *     describes:"describes",
     *     roleName:"123"
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
     * @api {get} http://localhost:8080/iws/api/userManage/detail 用户列表
     * @apiName detail
     * @apiGroup userManage
     * @apiVersion 0.1.0
     * @apiDescription 获取用户详情
     *
     * @apiParam {String} token 身份验证
     * @apiParam {int} userId 用户Id
     *
     * @apiSuccessExample Success-Response:
     *  HTTP/1.1 200 OK
     * {
     * callStatus:"SUCCEED",
     * errorCode:"No_Error",
     * data:{
     *     id:1,
     *     username:18712345678,
     *     password:"d1b2cc725d846f0460ff290c60925070",
     *     roleid:1,
     *     status:1,
     *     date:2017-01-01 12:00:00,
     *     name:"name",
     *     describes:"describes",
     *     roleName:"123"
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
