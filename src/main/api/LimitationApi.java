import com.jiang.utils.DataWrapper;

/**
 * Created by XiaoJiang01 on 2017/2/23.
 */
public interface AreaApi {

    /**
     *
     * @api {get} http://localhost:8080/iws/api/limitation/checkAdmin 系统权限查询
     * @apiName checkAdmin
     * @apiGroup limitation
     * @apiVersion 0.1.0
     * @apiDescription 系统权限查询(No_Error具有该系统权限,Limitation_Error没有该系统权限)
     *
     * @apiParam {String} token 身份验证
     *
     * @apiSuccessExample Success-Response:
     *  HTTP/1.1 200 OK
     * {
     * callStatus:"SUCCEED",
     * errorCode:"No_Error",
     * data:null
     *
     *  @apiErrorExample {json} Error-Response:
     *  HTTP/1.1 200 OK
     * {
     * callStatus:"FAILED",
     * errorCode:"Limitation_Error",
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
     * @api {get} http://localhost:8080/iws/api/limitation/checkLimit 地区权限查询
     * @apiName checkSystem
     * @apiGroup limitation
     * @apiVersion 0.1.0
     * @apiDescription 系统权限查询(No_Error具有该系统权限,Limitation_Error没有该系统权限)
     *
     * @apiParam {int} systemId 系统id
     * @apiParam {int} areaId 城区id(可以为省/市/区,对应不同级别权限查询)
     * @apiParam {int} writable 读写权限(查该地区可读权限传1,查该地区读写权限传2)
     * @apiParam {String} token 身份验证
     *
     * @apiSuccessExample Success-Response:
     *  HTTP/1.1 200 OK
     * {
     * callStatus:"SUCCEED",
     * errorCode:"No_Error",
     * data:null
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
