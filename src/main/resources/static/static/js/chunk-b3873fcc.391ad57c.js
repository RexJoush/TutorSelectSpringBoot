(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-b3873fcc"],{2189:function(t,e,a){"use strict";a.d(e,"b",(function(){return i})),a.d(e,"c",(function(){return o})),a.d(e,"a",(function(){return s})),a.d(e,"e",(function(){return l})),a.d(e,"f",(function(){return u})),a.d(e,"g",(function(){return c})),a.d(e,"d",(function(){return p}));a("d3b7"),a("3ca3"),a("ddb0"),a("9861"),a("99af");var r=a("b775"),n=a("99b1");function i(t,e,a){var i=new URLSearchParams;return i.append("organizationId",t),i.append("applyStatuss",e),i.append("pageNumber",a),Object(r["a"])({url:"".concat(n["a"],"/admin/tutor-inspect/getInit"),method:"post",data:i})}function o(t,e){return Object(r["a"])({url:"".concat(n["a"],"/admin/tutor-inspect/search/").concat(e),method:"post",data:t})}function s(){return Object(r["a"])({url:"/admin/apply-type/getApplyType",method:"get"})}function l(t){return Object(r["a"])({url:"/admin/update-status/update",method:"post",data:t})}function u(t){return Object(r["a"])({url:"/admin/update-status/updateSfh",method:"post",data:t})}function c(t){return Object(r["a"])({url:"/admin/update-status/updateXy",method:"post",data:t})}function p(t){return Object(r["a"])({url:"/admin/update-status/updateSocial",method:"post",data:t})}},"48b7":function(t,e,a){"use strict";a.r(e);var r=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{staticClass:"app-container"},[a("el-form",{ref:"queryForm",attrs:{"label-width":"70px"}},[a("el-row",{attrs:{gutter:20}},[a("el-col",{attrs:{span:6}},[a("el-form-item",{attrs:{label:"工号"}},[a("el-input",{staticStyle:{width:"100%"},attrs:{placeholder:"请输入工号",clearable:"",size:"small"},model:{value:t.queryParams.userId,callback:function(e){t.$set(t.queryParams,"userId",e)},expression:"queryParams.userId"}})],1)],1),a("el-col",{attrs:{span:6}},[a("el-form-item",{attrs:{label:"姓名"}},[a("el-input",{staticStyle:{width:"100%"},attrs:{placeholder:"请输入姓名",clearable:"",size:"small"},model:{value:t.queryParams.userName,callback:function(e){t.$set(t.queryParams,"userName",e)},expression:"queryParams.userName"}})],1)],1),a("el-col",{attrs:{span:6}},[a("el-form-item",{attrs:{label:"申请类别"}},[a("el-select",{staticStyle:{width:"100%"},attrs:{placeholder:"请选择",clearable:"",size:"small"},model:{value:t.queryParams.applyType,callback:function(e){t.$set(t.queryParams,"applyType",e)},expression:"queryParams.applyType"}},t._l(t.applyTypeList,(function(t){return a("el-option",{key:t.applyTypeId,attrs:{label:t.applyName,value:t.applyTypeId}})})),1)],1)],1),a("el-col",{attrs:{span:6}},[a("el-form-item",{attrs:{label:"审核状态"}},[a("el-select",{staticStyle:{width:"100%"},attrs:{placeholder:"请选择",clearable:"",size:"small"},on:{change:t.changeApplyStatus},model:{value:t.queryParams.applyStatus,callback:function(e){t.$set(t.queryParams,"applyStatus",e)},expression:"queryParams.applyStatus"}},t._l(t.statusOptions,(function(t){return a("el-option",{key:t.value,attrs:{label:t.label,value:t.value}})})),1)],1)],1)],1),a("el-row",{attrs:{gutter:20}},[a("el-col",{attrs:{span:2,offset:20}},[a("el-button",{attrs:{type:"primary",icon:"el-icon-search",size:"small"},on:{click:t.search}},[t._v("搜索")])],1),a("el-col",{attrs:{span:2}},[a("el-button",{attrs:{icon:"el-icon-refresh",size:"small"},on:{click:function(e){return t.resetQuery(t.queryParams)}}},[t._v("重置")])],1)],1)],1),a("el-table",{directives:[{name:"loading",rawName:"v-loading",value:t.loading,expression:"loading"}],attrs:{data:t.tutorList}},[a("el-table-column",{attrs:{label:"工号",align:"center",prop:"tutorId"}}),a("el-table-column",{attrs:{label:"姓名",align:"center",prop:"name"}}),a("el-table-column",{attrs:{label:"所在单位（院系）",align:"center",prop:"organizationName"}}),a("el-table-column",{attrs:{label:"申请学科或类别代码",align:"center",prop:"applySubject"}}),a("el-table-column",{attrs:{label:"申请类别",align:"center",prop:"applyName"}}),a("el-table-column",{attrs:{label:"职称",align:"center",prop:"title"}}),a("el-table-column",{attrs:{label:"审核状态",align:"center"},scopedSlots:t._u([{key:"default",fn:function(e){return[11===e.row.status?a("el-tag",{attrs:{type:"success"}},[t._v(t._s(e.row.inspectDescribe))]):12===e.row.status?a("el-tag",{attrs:{type:"danger"}},[t._v(" "+t._s(e.row.inspectDescribe))]):t._e()]}}])}),a("el-table-column",{attrs:{label:"详情",align:"center"},scopedSlots:t._u([{key:"default",fn:function(e){return[a("el-button",{attrs:{type:"text",size:"small"},on:{click:function(a){return t.toDetails(e.row.applyId,e.row.applyTypeId,e.row.tutorId)}}},[t._v("查 看 ")])]}}])}),a("el-table-column",{attrs:{label:"备注",align:"center"},scopedSlots:t._u([{key:"default",fn:function(e){return[a("el-button",{attrs:{type:"text",size:"small"},on:{click:function(a){return t.commitFun(e.row)}}},[t._v("添加备注")])]}}])})],1),a("el-row",{attrs:{type:"flex",justify:"center"}},[a("el-pagination",{staticStyle:{margin:"10px 0"},attrs:{"current-page":t.pageNumber,"page-size":10,layout:"total, prev, pager, next",total:t.totalData},on:{"size-change":t.handleSizeChange,"current-change":t.handleCurrentChange}})],1),a("el-row",[a("el-col",{attrs:{span:2}},[a("el-button",{attrs:{plain:"",icon:"el-icon-download",size:"small",loading:t.exportLoading},on:{click:function(e){return t.exportFun()}}},[t._v("导出excel ")])],1)],1),t._m(0),a("el-dialog",{attrs:{title:"院系提交分会备注(可以为空)",visible:t.dialogVisible,width:"20%"},on:{"update:visible":function(e){t.dialogVisible=e}}},[a("el-input",{attrs:{type:"textarea",autocomplete:"off"},model:{value:t.returnCommit,callback:function(e){t.returnCommit=e},expression:"returnCommit"}}),a("span",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[a("el-button",{on:{click:function(e){return t.cancel()}}},[t._v("取 消")]),a("el-button",{attrs:{type:"primary"},on:{click:function(e){return t.returnFun()}}},[t._v("确 定")])],1)],1)],1)},n=[function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("p",{staticStyle:{margin:"10px 0"}},[t._v(" 注意：导出上表所有审核状态为"),a("span",{staticStyle:{color:"#f56c6c"}},[t._v("同意上分会")]),t._v("的记录 ")])}],i=a("1da1"),o=(a("96cf"),a("d3b7"),a("3ca3"),a("ddb0"),a("2b3d"),a("9861"),a("2189")),s=a("6fa2"),l=a("a78e"),u=a.n(l),c=a("8d63"),p={data:function(){return{returnCommit:"",dialogVisible:!1,dialogVisiblePass:!1,loading:!0,exportLoading:!1,single:!0,multiple:!0,showSearch:!0,totalData:0,secretaryInitList:[],applyTypeList:[],multipleSelection:[],currentSelection:[],commitArrays:[],pageNumber:1,queryParams:{userId:"",userName:"",organization:"",organizationName:"",applyType:"",subjectName:"",applyStatus:"",applyStatuss:[],subjectType:""},statusOptions:[{value:11,label:"同意上分会"},{value:12,label:"不同意分会"}],queryParamCopy:{},updataList:[],tutorList:[]}},created:function(){this.getSecretaryInit(),this.getApplyTypeList()},methods:{getOrganizationId:function(){if(null!==u.a.get("organizationId"))return u.a.get("organizationId");console.log("error-organizationId is null")},getOrganizationName:function(){if(null!==u.a.get("organizationName"))return u.a.get("organizationName");console.log("error-organizationName is null")},getSecretaryInit:function(){var t=this;this.loading=!0;var e=["11","12"],a=this.getOrganizationId();Object(o["b"])(a,e,this.pageNumber).then((function(e){t.tutorList=e.data.data,t.totalData=e.data.total,console.log("res",e),t.loading=!1})),this.resetQuery()},toDetails:function(t,e,a){Object(s["d"])(this,t,e,a)},search:function(){var t=this;this.pageNumber=1,""===this.queryParams.applyStatus&&""===this.queryParams.userName&&""===this.queryParams.organization&&""===this.queryParams.applyType&&""===this.queryParams.subjectName&&""===this.queryParams.subjectType?this.getSecretaryInit():(""===this.queryParams.applyStatus&&(this.queryParams.applyStatuss=["11","12"]),this.queryParams.organization=this.getOrganizationId(),Object(o["c"])(this.queryParams,this.pageNumber).then((function(e){t.tutorList=e.data.data,t.totalData=e.data.total,console.log("res",e),t.loading=!1})).catch((function(t){throw t})))},changeApplyStatus:function(){this.queryParams.applyStatuss=[]},dataOption:function(t){this.loading=!0;var e=["11"];this.queryParams.organization=this.getOrganizationId(),this.queryParams.organizationName=this.getOrganizationName(),null==this.queryParams.applyStatus||""===this.queryParams.applyStatus?(this.queryParamCopy=JSON.parse(JSON.stringify(this.queryParams)),this.queryParamCopy.applyStatuss=e,t(this.queryParamCopy)):t(this.queryParams)},exportFun:function(){this.dataOption(this.exportExcel)},exportExcel:function(t){var e=this;console.log(t);var a=new Date,r=a.getFullYear();Object(c["e"])(t).then((function(t){var a=new Blob([t],{type:"application/vnd.ms-excel"}),n=window.URL.createObjectURL(a),i=document.createElement("a");i.download="西北大学"+r+"年"+e.getOrganizationName()+"学位评定分委员会推荐汇总表.xlsx",i.href=n,i.click()})),this.loading=!1},getApplyTypeList:function(){var t=this;return Object(i["a"])(regeneratorRuntime.mark((function e(){return regeneratorRuntime.wrap((function(e){while(1)switch(e.prev=e.next){case 0:Object(o["a"])().then((function(e){t.applyTypeList=e.data}));case 1:case"end":return e.stop()}}),e)})))()},resetQuery:function(){this.queryParams.userId="",this.queryParams.userName="",this.queryParams.applyType="",this.queryParams.applyStatus="",this.queryParams.applyStatuss=[],this.pageNumber=1},commitFun:function(t){this.commitArrays.length=0,this.dialogVisible=!0,this.returnCommit=t.commitYxSfh;var e={id_1:0,status_1:0,commit_1:""};e.id_1=t.applyId,e.status_1=t.status,e.commit_1=t.commitYxSfh,this.commitArrays.push(e)},returnFun:function(){this.commitArrays[0].commit_1=this.returnCommit,this.updateStatusFun(this.commitArrays,!1),console.log("备注确定按钮",this.commitArrays),this.dialogVisible=!1},updateStatusFun:function(t,e){var a=this;Object(o["f"])(t).then((function(t){2e4===t.code&&a.$message.success("操作成功!"),e?a.getSecretaryInit():a.updateTutorListDataCommit(a.commitArrays[0].id_1)}))},updateTutorListDataCommit:function(t){for(var e=0;e<this.tutorList.length;e++)if(t===this.tutorList[e].applyId){this.tutorList[e].commitYxSfh=this.returnCommit;break}},cancel:function(){this.dialogVisible=!1,this.returnCommit=null},handleSizeChange:function(t){},handleCurrentChange:function(t){this.pageNumber=t,this.getSecretaryInit()}}},m=p,d=a("2877"),y=Object(d["a"])(m,r,n,!1,null,null,null);e["default"]=y.exports},"6fa2":function(t,e,a){"use strict";a.d(e,"d",(function(){return i})),a.d(e,"c",(function(){return o})),a.d(e,"a",(function(){return s})),a.d(e,"b",(function(){return l}));a("99af");var r=a("a78e"),n=a.n(r);function i(t,e,a,r,n){t.$router.push("/applyDetails/".concat(e,"/").concat(a,"/").concat(r,"/").concat(n))}function o(t){var e=new Date(t);return new Date(e.getTime()+e.getTimezoneOffset()/60*3600*1e3)}function s(t){var e=new Date(t);return new Date(e.getTime()+3600*(e.getTimezoneOffset()/60+24)*1e3)}function l(){if(null!==n.a.get("organizationId"))return n.a.get("organizationId");console.log("error-organizationId is null")}},"8d63":function(t,e,a){"use strict";a.d(e,"a",(function(){return n})),a.d(e,"e",(function(){return i})),a.d(e,"f",(function(){return o})),a.d(e,"b",(function(){return s})),a.d(e,"d",(function(){return l})),a.d(e,"c",(function(){return u}));var r=a("b775");function n(t){return Object(r["a"])({url:"/admin/export/cs",method:"post",data:t,responseType:"blob"})}function i(t){return Object(r["a"])({url:"/admin/export/sfh",method:"post",data:t,responseType:"blob"})}function o(t){return Object(r["a"])({url:"/admin/export/sxyfh",method:"post",data:t,responseType:"blob"})}function s(t){return Object(r["a"])({url:"/admin/export/finalOrg",method:"post",data:t,responseType:"blob"})}function l(t){return Object(r["a"])({url:"/admin/export/qualification",method:"post",data:t,responseType:"blob"})}function u(t){return Object(r["a"])({url:"/admin/export/finalListGraduate",method:"post",data:t,responseType:"blob"})}}}]);