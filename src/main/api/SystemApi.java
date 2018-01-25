import com.jiang.utils.DataWrapper;

/**
 * Created by XiaoJiang01 on 2017/2/23.
 */
public interface SystemApi {
    /**
     *
     * @api {post} http://localhost:8080/iws/api/system/add 添加系统
     * @apiName add
     * @apiGroup system
     * @apiVersion 0.1.0
     * @apiDescription 添加系统
     *
     * @apiParam {String} name 系统名称
     * @apiParam {String} pic 图片
     * @apiParam {String} describes 系统描述
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
     * @api {post} http://localhost:8080/iws/api/system/update 编辑系统
     * @apiName update
     * @apiGroup system
     * @apiVersion 0.1.0
     * @apiDescription 编辑系统
     *
     * @apiParam {int} id 系统id
     * @apiParam {String} pic 图片
     * @apiParam {String} name 系统名称
     * @apiParam {String} describes 系统描述
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
     * @api {post} http://localhost:8080/iws/api/system/delete 删除系统
     * @apiName delete
     * @apiGroup system
     * @apiVersion 0.1.0
     * @apiDescription 删除系统
     *
     * @apiParam {int} systemId 系统id
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
     * @api {post} http://localhost:8080/iws/api/system/listPack 系统列表(封装)
     * @apiName listPack
     * @apiGroup system
     * @apiVersion 0.1.0
     * @apiDescription 调用 返回全部系统及系统下全部地点,按省市区封装
     *
     *
     * @apiSuccessExample Success-Response:
     *  HTTP/1.1 200 OK
     * {
     * callStatus:"SUCCEED",
     * errorCode:"No_Error",
     * data(List):{
     *     id:1
     *     name:"name"
     *     pic:"api/img/a.jpg"
     *     describes:"describes"
     *     provice(List):{
     *         provinceId:110000,
     *         name:"北京市",
     *         city(List):{
     *             cityId:110100,
     *             name:市辖区,
     *             area(List):{
     *                 areaId:110101,
     *                 name:"东城区",
     *                 location(List):{
     *                      id:1,
     *                      systemId:1,
     *                      proviceId:110000,
     *                      cityId:110100,
     *                      areaId:110101,
     *                      positionX:123.1234567890,
     *                      positionY:123.123456,
     *                      provinceName:"北京市",
     *                      cityName:"市辖区",
     *                      areaName:"东城区",
     *                      name:"小区",
     *                      describes:"describes"
     *                 }
     *             }
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
     * @api {post} http://localhost:8080/iws/api/system/detailPack 系统详情(封装)
     * @apiName detailPack
     * @apiGroup system
     * @apiVersion 0.1.0
     * @apiDescription 传系统id 返回该系统及系统下全部地点,按省市区封装
     *
     * @apiParam {int} systemId 系统id
     * @apiParam {String} token 身份验证
     *
     * @apiSuccessExample Success-Response:
     *  HTTP/1.1 200 OK
     * {
     * callStatus:"SUCCEED",
     * errorCode:"No_Error",
     * data(List):{
     *     id:1
     *     name:"name",
     *     pic:"api/img/a.jpg",
     *     describes:"describes",
     *     provice(List):{
     *         provinceId:110000,
     *         name:"北京市",
     *         city(List):{
     *             cityId:110100,
     *             name:市辖区,
     *             area(List):{
     *                 areaId:110101,
     *                 name:"东城区",
     *                 location(List):{
     *                      id:1,
     *                      systemId:1,
     *                      proviceId:110000,
     *                      cityId:110100,
     *                      areaId:110101,
     *                      positionX:123.1234567890,
     *                      positionY:123.123456,
     *                      provinceName:"北京市",
     *                      cityName:"市辖区",
     *                      areaName:"东城区",
     *                      name:"小区",
     *                      describes:"describes"
     *                 }
     *             }
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
     * @api {post} http://localhost:8080/iws/api/system/list 系统列表
     * @apiName list
     * @apiGroup system
     * @apiVersion 0.1.0
     * @apiDescription 调用 返回全部系统及系统下全部地点
     *
     *
     * @apiSuccessExample Success-Response:
     *  HTTP/1.1 200 OK
     * {
     * callStatus:"SUCCEED",
     * errorCode:"No_Error",
     * data(List):{
     *     id:1
     *     name:"name"
     *     pic:"api/img/a.jpg"
     *     describes:"describes"
     *     location(List):{
     *          id:1,
     *          systemId:1,
     *          proviceId:110000,
     *          cityId:110100,
     *          areaId:110101,
     *          positionX:123.1234567890,
     *          positionY:123.123456,
     *          provinceName:"北京市",
     *          cityName:"市辖区",
     *          areaName:"东城区",
     *          name:"小区",
     *          describes:"describes"
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
     * @api {post} http://localhost:8080/iws/api/system/detail 查看系统
     * @apiName detail
     * @apiGroup system
     * @apiVersion 0.1.0
     * @apiDescription 传系统id 返回该系统及系统下全部地点
     *
     * @apiParam {int} systemId 系统id
     * @apiParam {String} token 身份验证
     *
     * @apiSuccessExample Success-Response:
     *  HTTP/1.1 200 OK
     * {
     * callStatus:"SUCCEED",
     * errorCode:"No_Error",
     * data(List):{
     *     id:1
     *     name:"name",
     *     pic:"api/img/a.jpg",
     *     describes:"describes",
     *     location(List):{
     *          id:1,
     *          systemId:1,
     *          proviceId:110000,
     *          cityId:110100,
     *          areaId:110101,
     *          positionX:123.1234567890,
     *          positionY:123.123456,
     *          provinceName:"北京市",
     *          cityName:"市辖区",
     *          areaName:"东城区",
     *          name:"小区",
     *          describes:"describes"
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
