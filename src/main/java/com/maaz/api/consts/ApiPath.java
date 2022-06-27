package com.maaz.api.consts;

public interface ApiPath {
    String API = "/api/v1";

    //ping
    String PING = API + "/ping";

    //company
    String COMPANY_GET_ALL = API + "/company/get-all";
    String COMPANY_GET_UUID = API + "/company/get-by-uuid";
    String COMPANY_CREATE = API + "/company/create";
    String COMPANY_UPDATE = API + "/company/update";
    String COMPANY_DELETE = API + "/company/delete";

    //recognition
    String RECOGNITION_GET_ALL = API + "/recognition/get-all";
    String RECOGNITION_GET_BY_UUID = API + "/recognition/get-by-uuid";
    String RECOGNITION_CREATE = API + "/recognition/create";
    String RECOGNITION_UPDATE = API + "/recognition/update";
    String RECOGNITION_DELETE = API + "/recognition/delete";

    //partner
    String PARTNER_GET_ALL = API + "/partner/get-all";
    String PARTNER_GET_BY_UUID = API + "/partner/get-by-uuid";
    String PARTNER_CREATE = API + "/partner/create";
    String PARTNER_UPDATE = API + "/partner/update";
    String PARTNER_DELETE = API + "/partner/delete";

    //services
    String SERVICE_GET_ALL = API + "/service/get-all";
    String SERVICE_GET_BY_UUID = API + "/service/get-by-uuid";
    String SERVICE_CREATE = API + "/service/create";
    String SERVICE_UPDATE = API + "/service/update";
    String SERVICE_DELETE = API + "/service/delete";

    //news
    String NEWS_GET_ALL = API + "/news/get-all";
    String NEWS_GET_BY_UUID = API + "/news/get-by-uuid";
    String NEWS_CREATE = API + "/news/create";
    String NEWS_UPDATE = API + "/news/update";
    String NEWS_DELETE = API + "/news/delete";

    //products
    String PRODUCT_GET_ALL = API + "/product/get-all";
    String PRODUCT_GET_BY_UUID = API + "/product/get-by-uuid";
    String PRODUCT_CREATE = API + "/product/create";
    String PRODUCT_UPDATE = API + "/product/update";
    String PRODUCT_DELETE = API + "/product/delete";

    //end
}
