(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-16cedba5"],{2647:function(t,e,a){"use strict";a.d(e,"b",(function(){return i})),a.d(e,"a",(function(){return o})),a.d(e,"c",(function(){return c}));a("99af");var n=a("99b1"),r=a("b775");function i(t){return Object(r["a"])({url:"".concat(n["a"],"/tutor/checkApply/").concat(t),method:"get"})}function o(t,e){return Object(r["a"])({url:"".concat(n["a"],"/user/noDelFile/").concat(e),method:"post",data:t})}function c(t){return Object(r["a"])({url:"".concat(n["a"],"/tutor/getOrganizationTime/").concat(t),method:"get"})}},"6fa2":function(t,e,a){"use strict";a.d(e,"d",(function(){return i})),a.d(e,"c",(function(){return o})),a.d(e,"a",(function(){return c})),a.d(e,"b",(function(){return s}));a("99af");var n=a("a78e"),r=a.n(n);function i(t,e,a,n,r){t.$router.push("/applyDetails/".concat(e,"/").concat(a,"/").concat(n,"/").concat(r))}function o(t){var e=new Date(t);return new Date(e.getTime()+e.getTimezoneOffset()/60*3600*1e3)}function c(t){var e=new Date(t);return new Date(e.getTime()+3600*(e.getTimezoneOffset()/60+24)*1e3)}function s(){if(null!==r.a.get("organizationId"))return r.a.get("organizationId");console.log("error-organizationId is null")}},9956:function(t,e,a){"use strict";a.r(e);var n=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{staticClass:"main"},[a("el-row",[a("el-col",{attrs:{span:24}},[a("el-divider",{attrs:{"content-position":"left"}},[a("span",{staticClass:"divider-title"},[t._v("我的申请")])])],1)],1),a("el-table",{directives:[{name:"loading",rawName:"v-loading",value:t.loading,expression:"loading"}],staticStyle:{width:"100%"},attrs:{data:t.applyList,stripe:"","element-loading-text":"获取中..."}},[a("el-table-column",{attrs:{align:"center",type:"index",width:"50",label:"序号"}}),a("el-table-column",{attrs:{align:"center",prop:"applyName",label:"申请类别"}}),a("el-table-column",{attrs:{align:"center",prop:"applyDepartment",label:"申请负责单位"}}),a("el-table-column",{attrs:{align:"center",prop:"applySubject",label:"申请学科"}}),a("el-table-column",{attrs:{align:"center",prop:"statusDisplay",label:"当前状态"},scopedSlots:t._u([{key:"default",fn:function(e){return[0===e.row.status?a("el-tag",{attrs:{type:"warning"}},[t._v(" 需继续填写，未完成 ")]):6===e.row.status?a("el-tag",{attrs:{type:"success"}},[t._v(" 已填写完成，待提交 ")]):14===e.row.status?a("el-tag",{attrs:{type:"danger"}},[t._v(" 被院系驳回，待修改 ")]):a("el-tag",{attrs:{type:"info"}},[t._v(" 已提交审核，请等待 ")])]}}])}),a("el-table-column",{attrs:{align:"center",label:"备注信息",width:"130"},scopedSlots:t._u([{key:"default",fn:function(e){return[14===e.row.status?a("el-button",{attrs:{size:"mini",type:"danger",plain:""},on:{click:function(a){return t.watchCommit(e.row)}}},[t._v("查看修改意见 ")]):t._e()]}}])}),a("el-table-column",{attrs:{align:"center",label:"操作",width:"180"},scopedSlots:t._u([{key:"default",fn:function(e){return[14!==e.row.status&&0!==e.row.status?a("el-button",{attrs:{size:"mini",type:"primary",plain:""},on:{click:function(a){return t.toApplyDetails(e.row)}}},[t._v("查 看 ")]):t._e(),14===e.row.status?a("el-button",{attrs:{disabled:t.isOk,size:"mini",type:"danger",plain:""},on:{click:function(a){return t.editApply(e.row)}}},[t._v("修 改 ")]):0===e.row.status?a("el-button",{attrs:{disabled:t.isOk,size:"mini",type:"warning",plain:""},on:{click:function(a){return t.editApply(e.row)}}},[t._v(" 填 写 ")]):6===e.row.status?a("el-button",{attrs:{disabled:t.isOk,size:"mini",type:"success",plain:""},on:{click:function(a){return t.submitApply(e.row)}}},[t._v(" 提交 ")]):t._e()]}}])})],1),a("el-dialog",{attrs:{title:"修改意见",visible:t.dialogVisible,width:"40%","show-close":!1,center:""},on:{"update:visible":function(e){t.dialogVisible=e}}},[a("el-descriptions",{staticClass:"margin-top",attrs:{column:1,border:"","label-class-name":"commit"}},[a("el-descriptions-item",{attrs:{label:"院系意见"}},[a("span",{staticStyle:{"white-space":"pre-wrap"}},[t._v(" "+t._s(t.commit)+" ")])]),a("el-descriptions-item",{attrs:{label:"研究生院意见"}},[a("span",{staticStyle:{"white-space":"pre-wrap"}},[t._v(" "+t._s(t.commitGraduate)+" ")])]),a("el-descriptions-item",{attrs:{label:"社科处意见"}},[a("span",{staticStyle:{"white-space":"pre-wrap"}},[t._v(" "+t._s(t.commitSocial)+" ")])])],1),a("span",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[a("el-button",{attrs:{type:"primary"},on:{click:function(e){t.dialogVisible=!1}}},[t._v("确 定")])],1)],1)],1)},r=[],i=a("1da1"),o=(a("96cf"),a("99af"),a("e6e7")),c=a("6fa2"),s=a("2647"),l={name:"Index",data:function(){return{dialogVisible:!1,isOk:!0,loading:!1,applyList:[],commit:"",commitSocial:"",commitGraduate:""}},created:function(){this.getApplyList(),this.loading=!0,this.getOrganizationTime()},methods:{getOrganizationTime:function(){var t=this,e=Object(c["b"])();Object(s["c"])(e).then((function(e){console.log("res",e);var a=new Date,n=Object(c["c"])(e.data.startTime),r=Object(c["a"])(e.data.endTime);console.log(n,r),a>r||a<n?(t.isOk=!0,t.$alert("当前时间不在系统时间范围内，无法进行修改、填写或提交","注意")):t.isOk=!1})).catch((function(t){throw t}))},getApplyList:function(){var t=this;Object(o["d"])().then((function(e){console.log(e),t.applyList=e.data,t.loading=!1})).catch((function(t){throw t}))},submitApply:function(t){var e=this;this.$alert("请务必点击查看，确认信息填写正确后再提交，提交后不可修改！","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then((function(){Object(o["a"])(t.applyId,2).then((function(t){1201===t.code?e.$message.error(t.data.message()):(e.$message.success("提交成功！"),e.getApplyList())}))})).catch((function(){console.log("cancel")}))},editApply:function(){var t=Object(i["a"])(regeneratorRuntime.mark((function t(e){var a;return regeneratorRuntime.wrap((function(t){while(1)switch(t.prev=t.next){case 0:a="tutorApply/",t.t0=e.applyTypeId,t.next=1===t.t0?4:2===t.t0?8:3===t.t0?10:4===t.t0?12:5===t.t0?16:6===t.t0?18:7===t.t0?20:8===t.t0?22:9===t.t0?24:25;break;case 4:return a+="firstApplyDoctor/1",t.next=7,Object(o["a"])(e.applyId,1);case 7:return t.abrupt("break",25);case 8:return a+="addApplyDoctor/2",t.abrupt("break",25);case 10:return a+="noInspectApplyDoctor/3",t.abrupt("break",25);case 12:return a+="firstApplyMaster/4",t.next=15,Object(o["a"])(e.applyId,1);case 15:return t.abrupt("break",25);case 16:return a+="addApplyMaster/5",t.abrupt("break",25);case 18:return a+="noInspectApplyMaster/6",t.abrupt("break",25);case 20:return a+="firstApplyProfessional/7",t.abrupt("break",25);case 22:return a+="addApplyProfessional/8",t.abrupt("break",25);case 24:a+="noInspectApplyProfessional/9";case 25:this.$router.push("".concat(a,"/101/").concat(e.applyId));case 26:case"end":return t.stop()}}),t,this)})));function e(e){return t.apply(this,arguments)}return e}(),watchCommit:function(t){this.dialogVisible=!0,this.commit=t.commit,this.commitSocial=t.commitSocial,this.commitGraduate=t.commitGraduate},toApplyDetails:function(t){console.log("apply",t),Object(c["d"])(this,t.applyId,t.applyTypeId,t.tutorId,t.status)}}},u=l,p=(a("e6aa"),a("2877")),d=Object(p["a"])(u,n,r,!1,null,null,null);e["default"]=d.exports},ba49:function(t,e,a){},e6aa:function(t,e,a){"use strict";a("ba49")},e6e7:function(t,e,a){"use strict";a.d(e,"d",(function(){return i})),a.d(e,"a",(function(){return o})),a.d(e,"c",(function(){return c})),a.d(e,"b",(function(){return s}));a("99af");var n=a("99b1"),r=a("b775");function i(){return Object(r["a"])({url:"".concat(n["a"],"/tutor/getApplyList"),method:"get"})}function o(t,e){return Object(r["a"])({url:"".concat(n["a"],"/tutor/changeStatus/").concat(t,"/").concat(e),method:"get"})}function c(t,e,a){return Object(r["a"])({url:"".concat(n["a"],"/common/tutor/getApplyDetails/").concat(t,"/").concat(e,"/").concat(a),method:"get"})}function s(t,e){return Object(r["a"])({url:"".concat(n["a"],"/tutor/getPdf/").concat(t,"/").concat(e),method:"get"})}}}]);