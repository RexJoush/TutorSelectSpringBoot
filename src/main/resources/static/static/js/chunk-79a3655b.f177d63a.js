(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-79a3655b"],{2189:function(t,e,a){"use strict";a.d(e,"b",(function(){return i})),a.d(e,"c",(function(){return o})),a.d(e,"a",(function(){return s})),a.d(e,"e",(function(){return u})),a.d(e,"f",(function(){return l})),a.d(e,"g",(function(){return c})),a.d(e,"d",(function(){return p}));a("d3b7"),a("3ca3"),a("ddb0"),a("9861"),a("99af");var n=a("b775"),r=a("99b1");function i(t,e,a){var i=new URLSearchParams;return i.append("organizationId",t),i.append("applyStatuss",e),i.append("pageNumber",a),Object(n["a"])({url:"".concat(r["a"],"/admin/tutor-inspect/getInit"),method:"post",data:i})}function o(t,e){return Object(n["a"])({url:"".concat(r["a"],"/admin/tutor-inspect/search/").concat(e),method:"post",data:t})}function s(){return Object(n["a"])({url:"/admin/apply-type/getApplyType",method:"get"})}function u(t){return Object(n["a"])({url:"/admin/update-status/update",method:"post",data:t})}function l(t){return Object(n["a"])({url:"/admin/update-status/updateSfh",method:"post",data:t})}function c(t){return Object(n["a"])({url:"/admin/update-status/updateXy",method:"post",data:t})}function p(t){return Object(n["a"])({url:"/admin/update-status/updateSocial",method:"post",data:t})}},"6fa2":function(t,e,a){"use strict";a.d(e,"d",(function(){return i})),a.d(e,"c",(function(){return o})),a.d(e,"a",(function(){return s})),a.d(e,"b",(function(){return u}));a("99af");var n=a("a78e"),r=a.n(n);function i(t,e,a,n,r){t.$router.push("/applyDetails/".concat(e,"/").concat(a,"/").concat(n,"/").concat(r))}function o(t){var e=new Date(t);return new Date(e.getTime()+e.getTimezoneOffset()/60*3600*1e3)}function s(t){var e=new Date(t);return new Date(e.getTime()+3600*(e.getTimezoneOffset()/60+24)*1e3)}function u(){if(null!==r.a.get("organizationId"))return r.a.get("organizationId");console.log("error-organizationId is null")}},7230:function(t,e,a){"use strict";a.r(e);var n=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{staticClass:"app-container"},[a("el-form",{ref:"queryForm",attrs:{"label-width":"70px"}},[a("el-row",{attrs:{gutter:20}},[a("el-col",{attrs:{span:6}},[a("el-form-item",{attrs:{label:"工号"}},[a("el-input",{staticStyle:{width:"100%"},attrs:{placeholder:"请输入工号",clearable:"",size:"small"},model:{value:t.queryParams.userId,callback:function(e){t.$set(t.queryParams,"userId",e)},expression:"queryParams.userId"}})],1)],1),a("el-col",{attrs:{span:6}},[a("el-form-item",{attrs:{label:"姓名"}},[a("el-input",{staticStyle:{width:"100%"},attrs:{placeholder:"请输入姓名",clearable:"",size:"small"},model:{value:t.queryParams.userName,callback:function(e){t.$set(t.queryParams,"userName",e)},expression:"queryParams.userName"}})],1)],1),a("el-col",{attrs:{span:6}},[a("el-form-item",{attrs:{label:"申请类别"}},[a("el-select",{staticStyle:{width:"100%"},attrs:{placeholder:"请选择",clearable:"",size:"small"},model:{value:t.queryParams.applyType,callback:function(e){t.$set(t.queryParams,"applyType",e)},expression:"queryParams.applyType"}},t._l(t.applyTypeList,(function(t){return a("el-option",{key:t.applyTypeId,attrs:{label:t.applyName,value:t.applyTypeId}})})),1)],1)],1),a("el-col",{attrs:{span:6}},[a("el-col",{attrs:{span:6,offset:6}},[a("el-button",{attrs:{type:"primary",icon:"el-icon-search",size:"small"},on:{click:t.search}},[t._v("搜索")])],1),a("el-col",{attrs:{span:6,offset:2}},[a("el-button",{attrs:{icon:"el-icon-refresh",size:"small"},on:{click:function(e){return t.resetQuery(t.queryParams)}}},[t._v("重置")])],1)],1)],1)],1),a("el-table",{directives:[{name:"loading",rawName:"v-loading",value:t.loading,expression:"loading"}],attrs:{data:t.tutorList}},[a("el-table-column",{attrs:{label:"工号",align:"center",prop:"tutorId"}}),a("el-table-column",{attrs:{label:"姓名",align:"center",prop:"name"}}),a("el-table-column",{attrs:{label:"所在单位（院系）",align:"center",prop:"organizationName"}}),a("el-table-column",{attrs:{label:"申请学科或类别代码",align:"center",prop:"applySubject"}}),a("el-table-column",{attrs:{label:"申请类别",align:"center",prop:"applyName"}}),a("el-table-column",{attrs:{label:"职称",align:"center",prop:"title"}}),a("el-table-column",{attrs:{label:"审核状态",align:"center",prop:"inspectDescribe"},scopedSlots:t._u([{key:"default",fn:function(e){return[81===e.row.status?a("el-tag",{attrs:{type:"success"}},[t._v(" "+t._s(e.row.inspectDescribe)+" ")]):t._e()]}}])}),a("el-table-column",{attrs:{label:"详情",align:"center"},scopedSlots:t._u([{key:"default",fn:function(e){return[a("el-button",{attrs:{type:"text",size:"small"},on:{click:function(a){return t.toDetails(e.row.applyId,e.row.applyTypeId,e.row.tutorId)}}},[t._v("查 看 ")])]}}])})],1),a("el-row",{attrs:{type:"flex",justify:"center"}},[a("el-pagination",{staticStyle:{margin:"10px 0"},attrs:{"current-page":t.queryParams.pageNum,"page-size":t.queryParams.pageSize,layout:"total, prev, pager, next",total:t.totalData},on:{"size-change":t.handleSizeChange,"current-change":t.handleCurrentChange}})],1),a("el-row",[a("el-col",{attrs:{span:2}},[a("el-button",{attrs:{plain:"",icon:"el-icon-download",size:"small",loading:t.exportLoading},on:{click:function(e){return t.exportFun()}}},[t._v("导出excel ")])],1)],1),a("p",{staticStyle:{margin:"10px 0"}},[t._v("注意：导出最终通过名单")])],1)},r=[],i=a("1da1"),o=(a("d3b7"),a("3ca3"),a("ddb0"),a("2b3d"),a("9861"),a("96cf"),a("2189")),s=a("6fa2"),u=a("a78e"),l=a.n(u),c=a("8d63"),p={data:function(){return{loading:!0,exportLoading:!1,single:!0,multiple:!0,showSearch:!0,totalData:0,secretaryInitList:[],applyTypeList:[],multipleSelection:[],pageNumber:1,queryParams:{userId:"",userName:"",organization:"",organizationName:"",applyType:"",subjectName:"",applyStatus:"",applyStatuss:[],subjectType:""},tutorList:[]}},created:function(){this.getSecretaryInit(),this.getApplyTypeList()},methods:{getApplyTypeList:function(){var t=this;return Object(i["a"])(regeneratorRuntime.mark((function e(){return regeneratorRuntime.wrap((function(e){while(1)switch(e.prev=e.next){case 0:Object(o["a"])().then((function(e){t.applyTypeList=e.data}));case 1:case"end":return e.stop()}}),e)})))()},getOrganizationId:function(){if(null!==l.a.get("organizationId"))return l.a.get("organizationId");console.log("error-organizationId is null")},getOrganizationName:function(){if(null!==l.a.get("organizationName"))return l.a.get("organizationName");console.log("error-organizationName is null")},getSecretaryInit:function(){var t=this;this.loading=!0;var e=this.getOrganizationId(),a=["81"];Object(o["b"])(e,a,this.pageNumber).then((function(e){t.tutorList=e.data.data,t.totalData=e.data.total,t.loading=!1})),this.resetQuery()},toDetails:function(t,e,a){Object(s["d"])(this,t,e,a)},dataOption:function(t){this.loading=!0;var e=["81"];this.queryParams.organization=this.getOrganizationId(),this.queryParams.organizationName=this.getOrganizationName(),null==this.queryParams.applyStatus||""===this.queryParams.applyStatus?(this.queryParamCopy=JSON.parse(JSON.stringify(this.queryParams)),this.queryParamCopy.applyStatuss=e,t(this.queryParamCopy)):t(this.queryParams)},exportFun:function(){this.dataOption(this.exportExcel)},exportExcel:function(t){var e=this,a=new Date,n=a.getFullYear();Object(c["b"])(t).then((function(t){var a=new Blob([t],{type:"application/vnd.ms-excel"}),r=window.URL.createObjectURL(a),i=document.createElement("a");i.download="西北大学"+n+"年"+e.getOrganizationName()+"导师遴选最终通过名单.xlsx",i.href=r,i.click()})),this.loading=!1},search:function(){var t=this;this.pageNumber=1,""===this.queryParams.userId&&""===this.queryParams.applyStatus&&""===this.queryParams.userName&&""===this.queryParams.organization&&""===this.queryParams.applyType&&""===this.queryParams.subjectName&&""===this.queryParams.subjectType?this.getSecretaryInit():(""===this.queryParams.applyStatus&&(this.queryParams.applyStatuss=["81"]),this.queryParams.organization=this.getOrganizationId(),Object(o["c"])(this.queryParams,this.pageNumber).then((function(e){t.tutorList=e.data.data,t.totalData=e.data.total,t.loading=!1})).catch((function(t){throw t})))},changeApplyStatus:function(){this.queryParams.applyStatuss=[]},resetQuery:function(){this.queryParams.userId="",this.queryParams.userName="",this.queryParams.applyType="",this.queryParams.applyStatus="",this.queryParams.applyStatuss=[]},handleSizeChange:function(t){},handleCurrentChange:function(t){this.pageNumber=t,this.getSecretaryInit()}}},d=p,m=a("2877"),y=Object(m["a"])(d,n,r,!1,null,null,null);e["default"]=y.exports},"8d63":function(t,e,a){"use strict";a.d(e,"a",(function(){return r})),a.d(e,"e",(function(){return i})),a.d(e,"f",(function(){return o})),a.d(e,"b",(function(){return s})),a.d(e,"d",(function(){return u})),a.d(e,"c",(function(){return l}));var n=a("b775");function r(t){return Object(n["a"])({url:"/admin/export/cs",method:"post",data:t,responseType:"blob"})}function i(t){return Object(n["a"])({url:"/admin/export/sfh",method:"post",data:t,responseType:"blob"})}function o(t){return Object(n["a"])({url:"/admin/export/sxyfh",method:"post",data:t,responseType:"blob"})}function s(t){return Object(n["a"])({url:"/admin/export/finalOrg",method:"post",data:t,responseType:"blob"})}function u(t){return Object(n["a"])({url:"/admin/export/qualification",method:"post",data:t,responseType:"blob"})}function l(t){return Object(n["a"])({url:"/admin/export/finalListGraduate",method:"post",data:t,responseType:"blob"})}}}]);