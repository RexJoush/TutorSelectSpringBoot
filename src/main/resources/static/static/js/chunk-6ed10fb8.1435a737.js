(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-6ed10fb8"],{2189:function(t,e,a){"use strict";a.d(e,"b",(function(){return r})),a.d(e,"c",(function(){return s})),a.d(e,"a",(function(){return o})),a.d(e,"d",(function(){return l})),a.d(e,"e",(function(){return u})),a.d(e,"f",(function(){return c}));a("d3b7"),a("3ca3"),a("ddb0"),a("9861"),a("99af");var n=a("b775"),i=a("99b1");function r(t,e,a){var r=new URLSearchParams;return r.append("organizationId",t),r.append("applyStatuss",e),r.append("pageNumber",a),Object(n["a"])({url:"".concat(i["a"],"/admin/tutor-inspect/getInit"),method:"post",data:r})}function s(t,e){return Object(n["a"])({url:"".concat(i["a"],"/admin/tutor-inspect/search/").concat(e),method:"post",data:t})}function o(){return Object(n["a"])({url:"/admin/apply-type/getApplyType",method:"get"})}function l(t){return Object(n["a"])({url:"/admin/update-status/update",method:"post",data:t})}function u(t){return Object(n["a"])({url:"/admin/update-status/updateSfh",method:"post",data:t})}function c(t){return Object(n["a"])({url:"/admin/update-status/updateXy",method:"post",data:t})}},"6fa2":function(t,e,a){"use strict";a.d(e,"d",(function(){return r})),a.d(e,"c",(function(){return s})),a.d(e,"a",(function(){return o})),a.d(e,"b",(function(){return l}));a("99af");var n=a("a78e"),i=a.n(n);function r(t,e,a,n){t.$router.push("/applyDetails/".concat(e,"/").concat(a,"/").concat(n))}function s(t){var e=new Date(t);return new Date(e.getTime()+e.getTimezoneOffset()/60*3600*1e3)}function o(t){var e=new Date(t);return new Date(e.getTime()+3600*(e.getTimezoneOffset()/60+24)*1e3)}function l(){if(null!==i.a.get("organizationId"))return i.a.get("organizationId");console.log("error-organizationId is null")}},8740:function(t,e,a){"use strict";a.r(e);var n=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{staticClass:"app-container"},[a("el-form",{ref:"queryForm",attrs:{"label-width":"70px"}},[a("el-row",{attrs:{gutter:20}},[a("el-col",{attrs:{span:6}},[a("el-form-item",{attrs:{label:"工号"}},[a("el-input",{staticStyle:{width:"100%"},attrs:{placeholder:"请输入工号",clearable:"",size:"small"},model:{value:t.queryParams.userId,callback:function(e){t.$set(t.queryParams,"userId",e)},expression:"queryParams.userId"}})],1)],1),a("el-col",{attrs:{span:6}},[a("el-form-item",{attrs:{label:"姓名"}},[a("el-input",{staticStyle:{width:"100%"},attrs:{placeholder:"请输入姓名",clearable:"",size:"small"},model:{value:t.queryParams.userName,callback:function(e){t.$set(t.queryParams,"userName",e)},expression:"queryParams.userName"}})],1)],1),a("el-col",{attrs:{span:6}},[a("el-form-item",{attrs:{label:"申请类别"}},[a("el-select",{staticStyle:{width:"100%"},attrs:{placeholder:"请选择",clearable:"",size:"small"},model:{value:t.queryParams.applyType,callback:function(e){t.$set(t.queryParams,"applyType",e)},expression:"queryParams.applyType"}},t._l(t.applyTypeList,(function(t){return a("el-option",{key:t.applyTypeId,attrs:{label:t.applyName,value:t.applyTypeId}})})),1)],1)],1),a("el-col",{attrs:{span:6}},[a("el-form-item",{attrs:{label:"审核状态"}},[a("el-select",{staticStyle:{width:"100%"},attrs:{placeholder:"请选择",clearable:"",size:"small"},on:{change:t.changeApplyStatus},model:{value:t.queryParams.applyStatus,callback:function(e){t.$set(t.queryParams,"applyStatus",e)},expression:"queryParams.applyStatus"}},t._l(t.statusOptions,(function(t){return a("el-option",{key:t.value,attrs:{label:t.label,value:t.value}})})),1)],1)],1)],1),a("el-row",{attrs:{gutter:20}},[a("el-col",{attrs:{span:2,offset:20}},[a("el-button",{attrs:{type:"primary",icon:"el-icon-search",size:"small"},on:{click:t.search}},[t._v("搜索")])],1),a("el-col",{attrs:{span:2}},[a("el-button",{attrs:{icon:"el-icon-refresh",size:"small"},on:{click:function(e){return t.resetQuery(t.queryParams)}}},[t._v("重置")])],1)],1)],1),a("div",{staticStyle:{margin:"10px 0","border-bottom":"1px solid #dcdfe6","padding-bottom":"10px"}},[a("el-button",{attrs:{type:"success",plain:"",icon:"el-icon-success",size:"small",disabled:t.single},on:{click:function(e){return t.passFun()}}},[t._v("符合条件 ")]),a("el-button",{attrs:{type:"danger",plain:"",icon:"el-icon-error",size:"small",disabled:t.multiple},on:{click:function(e){return t.unPassFun()}}},[t._v("不符合条件 ")]),a("el-button",{attrs:{type:"info",plain:"",icon:"el-icon-edit",size:"small",disabled:t.multiple},on:{click:function(e){return t.alterFun()}}},[t._v("需修改 ")])],1),a("el-table",{directives:[{name:"loading",rawName:"v-loading",value:t.loading,expression:"loading"}],attrs:{data:t.tutorList},on:{"selection-change":t.handleSelectionChange}},[a("el-table-column",{attrs:{type:"selection",align:"center"}}),a("el-table-column",{attrs:{label:"工号",align:"center",prop:"tutorId"}}),a("el-table-column",{attrs:{label:"姓名",align:"center",prop:"name"}}),a("el-table-column",{attrs:{label:"所在单位（院系）",align:"center",prop:"organizationName"}}),a("el-table-column",{attrs:{label:"申请学科或类别代码",align:"center",prop:"applySubject"}}),a("el-table-column",{attrs:{label:"申请类别",align:"center",prop:"applyName"}}),a("el-table-column",{attrs:{label:"职称",align:"center",prop:"title"}}),a("el-table-column",{attrs:{label:"审核状态",align:"center"},scopedSlots:t._u([{key:"default",fn:function(e){return[15===e.row.status?a("el-tag",{attrs:{type:"success"}},[t._v(t._s(e.row.inspectDescribe))]):16===e.row.status?a("el-tag",{attrs:{type:"danger"}},[t._v(" "+t._s(e.row.inspectDescribe))]):17===e.row.status?a("el-tag",{attrs:{type:"warning"}},[t._v(" "+t._s(e.row.inspectDescribe))]):18===e.row.status||13===e.row.status?a("el-tag",{attrs:{type:"info"}},[t._v(" "+t._s(e.row.inspectDescribe))]):a("p",[t._v(t._s(e.row.inspectDescribe))])]}}])}),a("el-table-column",{attrs:{label:"详情",align:"center"},scopedSlots:t._u([{key:"default",fn:function(e){return[a("el-button",{attrs:{type:"text",size:"small"},on:{click:function(a){return t.toDetails(e.row.applyId,e.row.applyTypeId,e.row.tutorId)}}},[t._v("查 看 ")])]}}])}),a("el-table-column",{attrs:{label:"备注",align:"center"},scopedSlots:t._u([{key:"default",fn:function(e){return[a("el-button",{attrs:{type:"text",size:"small"},on:{click:function(a){return t.commitFun(e.row)}}},[t._v("添加备注")])]}}])})],1),a("el-row",{attrs:{type:"flex",justify:"center"}},[a("el-pagination",{staticStyle:{margin:"10px 0"},attrs:{"current-page":t.pageNumber,"page-size":10,layout:"total, prev, pager, next",total:t.totalData},on:{"size-change":t.handleSizeChange,"current-change":t.handleCurrentChange}})],1),a("el-row",[a("el-col",{attrs:{span:2}},[a("el-button",{attrs:{plain:"",icon:"el-icon-download",size:"small",loading:t.exportLoading},on:{click:function(e){return t.exportFun()}}},[t._v("导出excel ")])],1),a("el-col",{attrs:{span:2,offset:20}},[a("el-button",{attrs:{type:"success",plain:"",size:"small",icon:"el-icon-success",loading:t.exportLoading,disabled:t.disable},on:{click:function(e){return t.submitFun()}}},[t._v("提交 ")])],1)],1),a("p",{staticStyle:{margin:"10px 0"}},[t._v("注意：导出上表所有的数据")]),a("el-dialog",{attrs:{title:"初审备注(可以为空)",visible:t.dialogVisible,width:"20%"},on:{"update:visible":function(e){t.dialogVisible=e}}},[a("el-input",{attrs:{type:"textarea",autocomplete:"off"},model:{value:t.returnCommit,callback:function(e){t.returnCommit=e},expression:"returnCommit"}}),a("span",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[a("el-button",{on:{click:function(e){return t.cancel()}}},[t._v("取 消")]),a("el-button",{attrs:{type:"primary"},on:{click:function(e){return t.returnFun()}}},[t._v("确 定")])],1)],1)],1)},i=[],r=a("1da1"),s=(a("d3b7"),a("3ca3"),a("ddb0"),a("2b3d"),a("9861"),a("96cf"),a("2189")),o=a("6fa2"),l=a("a78e"),u=a.n(l),c=a("8d63"),p={data:function(){return{returnCommit:"",dialogVisible:!1,dialogVisiblePass:!1,loading:!0,exportLoading:!1,single:!0,multiple:!0,totalData:0,applyTypeList:[],multipleSelection:[],commitArrays:[],pageNumber:1,queryParams:{userId:"",userName:"",organization:"",organizationName:"",applyType:"",subjectName:"",applyStatus:"",applyStatuss:[],subjectType:""},queryParamCopy:{},statusOptions:[{value:10,label:"待初审"},{value:15,label:"符合条件"},{value:16,label:"不符合条件"},{value:18,label:"需修改"},{value:63,label:"社科处已审核"},{value:64,label:"科研处已审核"}],updateList:[],tutorList:[],disable:!1}},created:function(){this.getSystemTime(),this.getSecretaryInit(),this.getApplyTypeList()},methods:{getOrganizationId:function(){if(null!==u.a.get("organizationId"))return u.a.get("organizationId");console.log("error-organizationId is null")},getOrganizationName:function(){if(null!==u.a.get("organizationName"))return u.a.get("organizationName");console.log("error-organizationName is null")},getSystemTime:function(){var t=this;return Object(r["a"])(regeneratorRuntime.mark((function e(){var a,n,i,r,s,l;return regeneratorRuntime.wrap((function(e){while(1)switch(e.prev=e.next){case 0:return a=new Date,n=0,e.next=4,t.$http.get("/admin/system-time/get/"+n);case 4:i=e.sent,r=i.data,s=Object(o["c"])(r[0]),l=Object(o["a"])(r[1]),console.log(a,s,l),a>l||a<s?(t.disable=!0,t.$alert("当前时间不在系统时间范围内，提交操作禁用！！！","提示",{confirmButtonText:"确定"})):t.disable=!1;case 10:case"end":return e.stop()}}),e)})))()},getSecretaryInit:function(){var t=this;this.loading=!0;var e=this.getOrganizationId(),a=["10","15","16","17","18"];Object(s["b"])(e,a,this.pageNumber).then((function(e){t.tutorList=e.data.data,t.totalData=e.data.total,console.log("res",e),t.loading=!1}))},toDetails:function(t,e,a){Object(o["d"])(this,t,e,a)},search:function(){var t=this;this.pageNumber=1,""===this.queryParams.applyStatus&&""===this.queryParams.userName&&""===this.queryParams.organization&&""===this.queryParams.applyType&&""===this.queryParams.subjectName&&""===this.queryParams.subjectType?this.getSecretaryInit():(""===this.queryParams.applyStatus&&(this.queryParams.applyStatuss=["10","15","16","17","18"]),this.queryParams.organization=this.getOrganizationId(),Object(s["c"])(this.queryParams,this.pageNumber).then((function(e){t.tutorList=e.data.data,t.totalData=e.data.total,console.log("res",e),t.loading=!1})).catch((function(t){throw t})))},changeApplyStatus:function(){this.queryParams.applyStatuss=[]},dataOption:function(t){this.loading=!0;var e=["10","15","16","17","18"];this.queryParams.organization=this.getOrganizationId(),this.queryParams.organizationName=this.getOrganizationName(),null==this.queryParams.applyStatus||""===this.queryParams.applyStatus?(this.queryParamCopy=JSON.parse(JSON.stringify(this.queryParams)),this.queryParamCopy.applyStatuss=e,t(this.queryParamCopy)):t(this.queryParams)},exportFun:function(){this.dataOption(this.exportExcel)},exportExcel:function(t){var e=this,a=new Date,n=a.getFullYear();Object(c["a"])(t).then((function(t){var a=new Blob([t],{type:"application/vnd.ms-excel"}),i=window.URL.createObjectURL(a),r=document.createElement("a");r.download="西北大学"+n+"年"+e.getOrganizationName()+"学位评定汇总表.xlsx",r.href=i,r.click()})),this.loading=!1},getApplyTypeList:function(){var t=this;return Object(r["a"])(regeneratorRuntime.mark((function e(){return regeneratorRuntime.wrap((function(e){while(1)switch(e.prev=e.next){case 0:Object(s["a"])().then((function(e){t.applyTypeList=e.data}));case 1:case"end":return e.stop()}}),e)})))()},resetQuery:function(){this.queryParams.userId="",this.queryParams.userName="",this.queryParams.applyType="",this.queryParams.applyStatus="",this.queryParams.applyStatuss=[],this.pageNumber=1},passFun:function(){this.check(15)},unPassFun:function(){this.check(16)},unEnsureFun:function(){this.check(17)},alterFun:function(){this.check(18)},commitFun:function(t){this.commitArrays.length=0,this.dialogVisible=!0,this.returnCommit=t.commit;var e={id_1:0,status_1:0,commit_1:""};e.id_1=t.applyId,e.status_1=t.status,e.commit_1=t.commit,this.commitArrays.push(e)},returnFun:function(){this.commitArrays[0].commit_1=this.returnCommit,this.updateStatusFun(this.commitArrays,!1),console.log("备注确定按钮",this.commitArrays),this.dialogVisible=!1},updateTutorListDataCommit:function(t){for(var e=0;e<this.tutorList.length;e++)if(t===this.tutorList[e].applyId){this.tutorList[e].commit=this.returnCommit;break}for(var a=0;a<this.updateList.length;a++)if(t===this.updateList[a].id_1){this.updateList[a].commit_1=this.returnCommit,console.log(this.updateList[a]);break}},cancel:function(){this.dialogVisible=!1,this.returnCommit=null},check:function(t){if("submit"===t)for(var e=0;e<this.updateList.length;e++)this.updateList[e].status_1=this.updateList[e].status_1-4;else{console.log(t);for(var a=0;a<this.updateList.length;a++)this.updateList[a].status_1=t}this.updateStatusFun(this.updateList,!0),console.log("更新状态",this.updateList)},updateStatusFun:function(t,e){var a=this;Object(s["d"])(t).then((function(t){2e4===t.code&&a.$message.success("操作成功!"),e?a.getSecretaryInit():a.updateTutorListDataCommit(a.commitArrays[0].id_1)}))},submitFun:function(){var t=this;this.$confirm("确认提交吗？").then((function(e){for(var a=!0,n=0;n<t.updateList.length;n++)10===t.updateList[n].status_1&&(a=!1);0===t.updateList.length?t.$message.warning("未选择数据，请先进行选择！"):a?(t.check("submit"),t.getSecretaryInit()):t.$message.warning("有待审核的数据，请先进行审核！"),t.dialogVisiblePass=!1})).catch((function(){console.log("cancel")}))},handleSelectionChange:function(t){t.length>0?(this.single=!1,this.multiple=!1):(this.single=!0,this.multiple=!0),this.multipleSelection=t,this.updateObject(this.multipleSelection)},updateObject:function(t){this.updateList=[];for(var e=0;e<t.length;e++){var a={id_1:0,status_1:0,commit_1:""};a.id_1=t[e].applyId,a.status_1=t[e].status,a.commit_1=t[e].commit,this.updateList.push(a)}},handleSizeChange:function(t){},handleCurrentChange:function(t){this.pageNumber=t,this.getSecretaryInit()}}},m=p,d=a("2877"),h=Object(d["a"])(m,n,i,!1,null,"35706262",null);e["default"]=h.exports},"8d63":function(t,e,a){"use strict";a.d(e,"a",(function(){return i})),a.d(e,"c",(function(){return r})),a.d(e,"d",(function(){return s})),a.d(e,"b",(function(){return o}));var n=a("b775");function i(t){return Object(n["a"])({url:"/admin/export/cs",method:"post",data:t,responseType:"blob"})}function r(t){return Object(n["a"])({url:"/admin/export/sfh",method:"post",data:t,responseType:"blob"})}function s(t){return Object(n["a"])({url:"/admin/export/sxyfh",method:"post",data:t,responseType:"blob"})}function o(t){return Object(n["a"])({url:"/admin/export/qualification",method:"post",data:t,responseType:"blob"})}}}]);