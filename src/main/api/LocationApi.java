/**
 * Created by XiaoJiang01 on 2017/2/23.
 */
public interface LocationApi {
    /**
     *
     * @api {post} http://localhost:8080/iws/api/location/add 添加地点
     * @apiName add
     * @apiGroup location
     * @apiVersion 0.1.0
     * @apiDescription 添加地点
     *
     * @apiParam {int} systemId 系统id
     * @apiParam {int} areaId 地点所属区域编号，标识到城区
     * @apiParam {double} positionX 地点经度坐标
     * @apiParam {double} positionY 地点维度坐标
     * @apiParam {String} name 地点名称
     * @apiParam {String} describes 地点描述
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
     * @api {post} http://localhost:8080/iws/api/location/update 编辑地点
     * @apiName update
     * @apiGroup location
     * @apiVersion 0.1.0
     * @apiDescription 修改地点
     *
     * @apiParam {int} id 地点id
     * @apiParam {int} systemId 系统id
     * @apiParam {int} areaId 地点所属区域编号，标识到城区
     * @apiParam {double} positionX 地点经度坐标
     * @apiParam {double} positionY 地点维度坐标
     * @apiParam {String} name 地点名称
     * @apiParam {String} describes 地点描述
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
     * @api {post} http://localhost:8080/iws/api/location/delete 删除地点
     * @apiName delete
     * @apiGroup location
     * @apiVersion 0.1.0
     * @apiDescription 删除地点
     *
     * @apiParam {String} locationId 地点id
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
     * @api {post} http://localhost:8080/iws/api/location/detail 地点详情
     * @apiName detail
     * @apiGroup location
     * @apiVersion 0.1.0
     * @apiDescription 传地点id,返回该地点及其所属系统和地点下全部泵房
     *
     * @apiParam {int} locationId 地点id
     * @apiParam {String} token 身份验证
     *
     * @apiSuccessExample Success-Response:
     *  HTTP/1.1 200 OK
     * {
     * callStatus:"SUCCEED",
     * errorCode:"No_Error",
     * data:{
     *      id:1,
     *      systemId:1,
     *      proviceId:110000,
     *      cityId:110100,
     *      areaId:110101,
     *      positionX:123.1234567890,
     *      positionY:123.123456,
     *      provinceName:"北京市",
     *      cityName:"市辖区",
     *      areaName:"东城区",
     *      name:"小区",
     *      describes:"describes"
     *      system:{
     *          id:1,
     *          name:"name",
     *          pic:"img/system01.png",
     *          describes:"describes"
     *
     *      }
     *      room(List):{
     *          id:1,
     *          locationId:1,
     *          name:"name",
     *          describes:"describes"
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
     * @api {post} http://localhost:8080/iws/api/location/list 地点列表
     * @apiName list
     * @apiGroup location
     * @apiVersion 0.1.0
     * @apiDescription 传系统id,返回系统下全部地点,散列数据,按省市区排序
     *
     * @apiParam {int} systemId 系统id(传0可查询所有地点)
     *
     * @apiSuccessExample Success-Response:
     *  HTTP/1.1 200 OK
     * {
     * callStatus:"SUCCEED",
     * errorCode:"No_Error",
     * data:{
     *      id:1,
     *      systemId:1,
     *      proviceId:110000,
     *      cityId:110100,
     *      areaId:110101,
     *      positionX:123.1234567890,
     *      positionY:123.123456,
     *      provinceName:"北京市",
     *      cityName:"市辖区",
     *      areaName:"东城区",
     *      name:"小区",
     *      describes:"describes"
     *      sytem:{
     *          id:1
     *          name:"供水系统",
     *          pic:"img/system01.png",
     *          describes:"123",a
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
     * @api {post} http://localhost:8080/iws/api/location/query 查询地点
     * @apiName query
     * @apiGroup location
     * @apiVersion 0.1.0
     * @apiDescription 条件查询,获取条件下全部地点。province,city,area中，查询优先级为area,city,province
     *
     * @apiParam {String} systemId 系统id
     * @apiParam {String} provinceId 省份id
     * @apiParam {String} cityId 城市id
     * @apiParam {String} areaId 城区id
     * @apiParam {String} token 身份验证
     *
     *
     * @apiSuccessExample Success-Response:
     *  HTTP/1.1 200 OK
     * {
     * callStatus:"SUCCEED",
     * errorCode:"No_Error",
     * data(List):{
     *      id:1,
     *      systemId:1,
     *      proviceId:110000,
     *      cityId:110100,
     *      areaId:110101,
     *      positionX:123.1234567890,
     *      positionY:123.123456,
     *      provinceName:"北京市",
     *      cityName:"市辖区",
     *      areaName:"东城区",
     *      name:"小区",
     *      describes:"describes"
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
