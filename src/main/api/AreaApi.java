import com.jiang.utils.DataWrapper;

/**
 * Created by XiaoJiang01 on 2017/2/23.
 */
public interface AreaApi {

    /**
     *
     * @api {post} http://localhost:8080/iws/api/area/provinces 省份列表
     * @apiName provinces
     * @apiGroup area
     * @apiVersion 0.1.0
     * @apiDescription 获取全部省份
     *
     * @apiSuccessExample Success-Response:
     *  HTTP/1.1 200 OK
     * {
     * callStatus:"SUCCEED",
     * errorCode:"No_Error",
     * data(List):{
     *     id:1,
     *     provinceId:340000,
     *     name:"安徽省"
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
     * @api {post} http://localhost:8080/iws/api/area/citise 城市列表
     * @apiName cities
     * @apiGroup area
     * @apiVersion 0.1.0
     * @apiDescription 获取全部城市，按省份封装
     *
     * @apiSuccessExample Success-Response:
     *  HTTP/1.1 200 OK
     * {
     * callStatus:"SUCCEED",
     * errorCode:"No_Error",
     * data(List):{
     *     id:1,
     *     provinceId:340000,
     *     name:"安徽省",
     *
     *     cities(List):{
     *         id:1,
     *         cityId:340100,
     *         name:"合肥市",
     *         provinceId:340000
     *     }
     * }
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
     * @api {post} http://localhost:8080/iws/api/area/areas 城区列表
     * @apiName areas
     * @apiGroup area
     * @apiVersion 0.1.0
     * @apiDescription 获取全部城区，按城市-省份封装
     *
     * @apiSuccessExample Success-Response:
     *  HTTP/1.1 200 OK
     * {
     * callStatus:"SUCCEED",
     * errorCode:"No_Error",
     * data(List):{
     *     id:1,
     *     provinceId:340000,
     *     name:"安徽省",
     *
     *     cities(List):{
     *         id:1,
     *         cityId:340100,
     *         name:"合肥市",
     *         provinceId:340000
     *
     *         areas(List):{
     *             id:1,
     *             areaId:340103,
     *             name:"庐阳区",
     *             cityId:340100
     *         }
     *     }
     * }
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
     * @api {post} http://localhost:8080/iws/api/area/province 省份详情
     * @apiName province
     * @apiGroup area
     * @apiVersion 0.1.0
     * @apiDescription 获取省份及其下属城市
     *
     * @apiParam {int} provinceId 省份id
     *
     * @apiSuccessExample Success-Response:
     *  HTTP/1.1 200 OK
     * {
     * callStatus:"SUCCEED",
     * errorCode:"No_Error",
     * data:{
     *     id:1,
     *     provinceId:340000,
     *     name:"安徽省",
     *
     *     cities(List):{
     *         id:1,
     *         cityId:340100,
     *         name:"合肥市",
     *         provinceId:340000
     *     }
     * }
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
     * @api {post} http://localhost:8080/iws/api/area/city 城市详情
     * @apiName city
     * @apiGroup area
     * @apiVersion 0.1.0
     * @apiDescription 获取城市及其所在省份、下属地区
     *
     * @apiParam {int} cityId 城市id
     *
     * @apiSuccessExample Success-Response:
     *  HTTP/1.1 200 OK
     * {
     * data:{
     *     id:1,
     *     cityId:340100,
     *     name:"合肥市",
     *     provinceId:340000,
     *
     *     province:{
     *         id:1,
     *         provinceId:340000,
     *         name:"安徽省",
     *     }
     *
     *     areas(List):{
     *         id:1,
     *         areaId:340103,
     *         name:"庐阳区",
     *         cityId:340100
     *     }
     * }
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
     * @api {post} http://localhost:8080/iws/api/area/area 城区详情
     * @apiName area
     * @apiGroup area
     * @apiVersion 0.1.0
     * @apiDescription 获取城区及其所在城市、省份
     *
     * @apiParam {int} areaId 城区id
     *
     * @apiSuccessExample Success-Response:
     *  HTTP/1.1 200 OK
     * {
     * data:{
     *     id:1,
     *     areaId:340103,
     *     name:"庐阳区",
     *     cityId:340100,
     *
     *     city:{
     *     id:1,
     *     cityId:340100,
     *     name:"合肥市",
     *     provinceId:340000,
     *     }
     *
     *     province:{
     *         id:1,
     *         provinceId:340000,
     *         name:"安徽省",
     *     }
     *
     * }
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
