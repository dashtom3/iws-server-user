/**
 * Created by XiaoJiang01 on 2017/2/24.
 */
public interface RoleApi {
    /**
     *
     * @api {post} http://localhost:8080/iws/api/role/add 添加角色
     * @apiName add
     * @apiGroup role
     * @apiVersion 0.1.0
     * @apiDescription 注册添加新角色
     *
     * @apiParam {List} subitem 角色权限子项(systemId 系统id; areaId 地区id，可为省、市或区; limitation 操作权限 1只读/2可写/3管理员)
     * @apiParam {String} name 角色名称
     * @apiParam {String} describes 角色描述
     * @apiParam {String} token 身份验证
     *
     * @apiSuccessExample Success-Response:
     *  HTTP/1.1 200 OK
     * {
     * callStatus:"SUCCEED",
     * errorCode:"No_Error",
     * data:{
     *     id:1,
     *     name:"123",
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
     * @api {post} http://localhost:8080/iws/api/role/delete 删除角色
     * @apiName delete
     * @apiGroup role
     * @apiVersion 0.1.0
     * @apiDescription 删除角色
     *
     * @apiParam {int} roleId 角色id
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
     * @api {post} http://localhost:8080/iws/api/role/update 编辑角色
     * @apiName update
     * @apiGroup role
     * @apiVersion 0.1.0
     * @apiDescription 编辑修改角色
     *
     * @apiParam {int} id 角色id
     * @apiParam {List} subitem 角色权限子项(systemId 系统id; areaId 地区id，可为省、市或区; limitation 操作权限 1只读/2可写/3管理员)
     * @apiParam {String} name 角色名称
     * @apiParam {String} describes 角色描述
     * @apiParam {String} token 身份验证
     *
     * @apiSuccessExample Success-Response:
     *  HTTP/1.1 200 OK
     * {
     * callStatus:"SUCCEED",
     * errorCode:"No_Error",
     * data:{
     *     id:1,
     *     name:"123",
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
     * @api {post} http://localhost:8080/iws/api/role/list 角色列表
     * @apiName list
     * @apiGroup role
     * @apiVersion 0.1.0
     * @apiDescription 查看角色详情
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
     *     name:"name",
     *     describes:"describes",
     *     rolesub(List):{
     *         id:1,
     *         roleId:1,
     *         systemId:1,
     *         areaId:110101,
     *         limitation:1,
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
     * @api {post} http://localhost:8080/iws/api/role/detail 查看角色
     * @apiName detail
     * @apiGroup role
     * @apiVersion 0.1.0
     * @apiDescription 查看角色详情
     *
     * @apiParam {String} roleId 角色id
     * @apiParam {String} token 身份验证
     *
     * @apiSuccessExample Success-Response:
     *  HTTP/1.1 200 OK
     * {
     * callStatus:"SUCCEED",
     * errorCode:"No_Error",
     * data(List):{
     *     id:1,
     *     name:"name",
     *     describes:"describes",
     *     rolesub(List):{
     *         id:1,
     *         roleId:1,
     *         systemId:1,
     *         areaId:110101,
     *         limitation:1,
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
     * @api {post} http://localhost:8080/iws/api/role/query 查询角色
     * @apiName query
     * @apiGroup role
     * @apiVersion 0.1.0
     * @apiDescription 按条件查询角色
     *
     * @apiparam {int} systemId 系统id
     * @apiparam {int} areaId 城区id
     * @apiparam {int} limitation 操作权限 1只读/2可写/3管理员
     * @apiparam {String} name 角色名称
     * @apiparam {String} token 身份验证
     *
     * @apiSuccessExample Success-Response:
     *  HTTP/1.1 200 OK
     * {
     * callStatus:"SUCCEED",
     * errorCode:"No_Error",
     * data(List):{
     *     id:1,
     *     name:"name",
     *     describes:"describes",
     *     rolesub(List):{
     *         id:1,
     *         roleId:1,
     *         systemId:1,
     *         areaId:110101,
     *         limitation:1,
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
