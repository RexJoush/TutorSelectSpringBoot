(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-1ce55348"],{"0d3b":function(t,e,a){var n=a("d039"),r=a("b622"),s=a("c430"),i=r("iterator");t.exports=!n((function(){var t=new URL("b?a=1&b=2&c=3","http://a"),e=t.searchParams,a="";return t.pathname="c%20d",e.forEach((function(t,n){e["delete"]("b"),a+=n+t})),s&&!t.toJSON||!e.sort||"http://a/c%20d?a=1&c=3"!==t.href||"3"!==e.get("c")||"a=1"!==String(new URLSearchParams("?a=1"))||!e[i]||"a"!==new URL("https://a@b").username||"b"!==new URLSearchParams(new URLSearchParams("a=b")).get("a")||"xn--e1aybc"!==new URL("http://тест").host||"#%D0%B1"!==new URL("http://a#б").hash||"a1c3"!==a||"x"!==new URL("http://x",void 0).host}))},2189:function(t,e,a){"use strict";a.d(e,"b",(function(){return s})),a.d(e,"c",(function(){return i})),a.d(e,"a",(function(){return l})),a.d(e,"d",(function(){return u})),a.d(e,"e",(function(){return o})),a.d(e,"f",(function(){return c}));a("d3b7"),a("3ca3"),a("ddb0"),a("9861"),a("99af");var n=a("b775"),r=a("99b1");function s(t,e,a){var s=new URLSearchParams;return s.append("organizationId",t),s.append("applyStatuss",e),s.append("pageNumber",a),Object(n["a"])({url:"".concat(r["a"],"/admin/tutor-inspect/getInit"),method:"post",data:s})}function i(t,e){return Object(n["a"])({url:"".concat(r["a"],"/admin/tutor-inspect/search/").concat(e),method:"post",data:t})}function l(){return Object(n["a"])({url:"/admin/apply-type/getApplyType",method:"get"})}function u(t){return Object(n["a"])({url:"/admin/update-status/update",method:"post",data:t})}function o(t){return Object(n["a"])({url:"/admin/update-status/updateSfh",method:"post",data:t})}function c(t){return Object(n["a"])({url:"/admin/update-status/updateXy",method:"post",data:t})}},"3b38":function(t,e,a){"use strict";a.r(e);var n=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{staticClass:"app-container"},[a("el-form",{ref:"queryForm",attrs:{"label-width":"70px"}},[a("el-row",{attrs:{gutter:20}},[a("el-col",{attrs:{span:6}},[a("el-form-item",{attrs:{label:"工号"}},[a("el-input",{staticStyle:{width:"100%"},attrs:{placeholder:"请输入工号",clearable:"",size:"small"},model:{value:t.queryParams.userId,callback:function(e){t.$set(t.queryParams,"userId",e)},expression:"queryParams.userId"}})],1)],1),a("el-col",{attrs:{span:6}},[a("el-form-item",{attrs:{label:"姓名"}},[a("el-input",{staticStyle:{width:"100%"},attrs:{placeholder:"请输入姓名",clearable:"",size:"small"},model:{value:t.queryParams.userName,callback:function(e){t.$set(t.queryParams,"userName",e)},expression:"queryParams.userName"}})],1)],1),a("el-col",{attrs:{span:6}},[a("el-form-item",{attrs:{label:"申请类别"}},[a("el-select",{staticStyle:{width:"100%"},attrs:{placeholder:"请选择",clearable:"",size:"small"},model:{value:t.queryParams.applyType,callback:function(e){t.$set(t.queryParams,"applyType",e)},expression:"queryParams.applyType"}},t._l(t.applyTypeList,(function(t){return a("el-option",{key:t.applyTypeId,attrs:{label:t.applyName,value:t.applyTypeId}})})),1)],1)],1),a("el-col",{attrs:{span:6}},[a("el-form-item",{attrs:{label:"审核状态"}},[a("el-select",{staticStyle:{width:"100%"},attrs:{placeholder:"请选择",clearable:"",size:"small"},on:{change:t.changeApplyStatus},model:{value:t.queryParams.applyStatus,callback:function(e){t.$set(t.queryParams,"applyStatus",e)},expression:"queryParams.applyStatus"}},t._l(t.statusOptions,(function(t){return a("el-option",{key:t.value,attrs:{label:t.label,value:t.value}})})),1)],1)],1)],1),a("el-row",{attrs:{gutter:20}},[a("el-col",{attrs:{span:2,offset:20}},[a("el-button",{attrs:{type:"primary",icon:"el-icon-search",size:"small"},on:{click:t.search}},[t._v("搜索")])],1),a("el-col",{attrs:{span:2}},[a("el-button",{attrs:{icon:"el-icon-refresh",size:"small"},on:{click:function(e){return t.resetQuery(t.queryParams)}}},[t._v("重置")])],1)],1)],1),a("div",{staticStyle:{margin:"10px 0","border-bottom":"1px solid #DCDFE6","padding-bottom":"10px"}},[a("el-button",{attrs:{type:"success",plain:"",icon:"el-icon-success",size:"small",disabled:t.single},on:{click:function(e){return t.passFun()}}},[t._v("同意上分会 ")]),a("el-button",{attrs:{type:"danger",plain:"",icon:"el-icon-error",size:"small",disabled:t.multiple},on:{click:function(e){return t.unPassFun()}}},[t._v("不同意上分会 ")])],1),a("el-table",{directives:[{name:"loading",rawName:"v-loading",value:t.loading,expression:"loading"}],attrs:{data:t.tutorList},on:{"selection-change":t.handleSelectionChange}},[a("el-table-column",{attrs:{type:"selection",align:"center"}}),a("el-table-column",{attrs:{label:"工号",align:"center",prop:"tutorId"}}),a("el-table-column",{attrs:{label:"姓名",align:"center",prop:"name"}}),a("el-table-column",{attrs:{label:"所在单位（院系）",align:"center",prop:"organizationName"}}),a("el-table-column",{attrs:{label:"申请学科或类别代码",align:"center",prop:"applySubject"}}),a("el-table-column",{attrs:{label:"申请类别",align:"center",prop:"applyName"}}),a("el-table-column",{attrs:{label:"职称",align:"center",prop:"title"}}),a("el-table-column",{attrs:{label:"审核状态",align:"center"},scopedSlots:t._u([{key:"default",fn:function(e){return[19===e.row.status?a("el-tag",{attrs:{type:"success"}},[t._v(" "+t._s(e.row.inspectDescribe)+" ")]):20===e.row.status?a("el-tag",{attrs:{type:"danger"}},[t._v(" "+t._s(e.row.inspectDescribe)+" ")]):a("p",[t._v(t._s(e.row.inspectDescribe))])]}}])}),a("el-table-column",{attrs:{label:"详情",align:"center"},scopedSlots:t._u([{key:"default",fn:function(e){return[a("el-button",{attrs:{type:"text",size:"small"},on:{click:function(a){return t.toDetails(e.row.applyId,e.row.applyTypeId,e.row.tutorId)}}},[t._v("查 看 ")])]}}])}),a("el-table-column",{attrs:{label:"备注",align:"center",prop:"commit"}})],1),a("el-row",{attrs:{type:"flex",justify:"center"}},[a("el-pagination",{staticStyle:{margin:"10px 0"},attrs:{"current-page":t.queryParams.pageNum,"page-size":t.queryParams.pageSize,layout:"total, prev, pager, next",total:t.totalData},on:{"size-change":t.handleSizeChange,"current-change":t.handleCurrentChange}})],1),a("el-row",[a("el-col",{attrs:{span:2,offset:22}},[a("el-button",{attrs:{type:"success",plain:"",size:"small",icon:"el-icon-success",loading:t.exportLoading},on:{click:function(e){return t.submitFun()}}},[t._v("提交 ")])],1)],1)],1)},r=[],s=a("1da1"),i=(a("96cf"),a("2189")),l=a("6fa2"),u=a("a78e"),o=a.n(u),c={data:function(){return{returnCommit:"",dialogVisible:!1,dialogVisiblePass:!1,loading:!0,exportLoading:!1,single:!0,multiple:!0,totalData:0,applyTypeList:[],multipleSelection:[],commitArrays:[],pageNumber:1,queryParams:{userId:"",userName:"",organization:"",organizationName:"",applyType:"",subjectName:"",applyStatus:"",applyStatuss:[],subjectType:""},statusOptions:[{value:11,label:"初审符合条件"},{value:12,label:"初审不符合条件"},{value:13,label:"初审待定"},{value:19,label:"同意上分会"},{value:20,label:"不同意上分会"}],updateList:[],tutorList:[]}},created:function(){this.getSecretaryInit(),this.getApplyTypeList()},methods:{getOrganizationId:function(){if(null!==o.a.get("organizationId"))return o.a.get("organizationId");console.log("error-organizationId is null")},getOrganizationName:function(){if(null!==o.a.get("organizationName"))return o.a.get("organizationName");console.log("error-organizationName is null")},getSecretaryInit:function(){var t=this;this.loading=!0;var e=this.getOrganizationId(),a=["11","12","13","19","20"];Object(i["b"])(e,a,this.pageNumber).then((function(e){t.tutorList=e.data.data,t.totalData=e.data.total,console.log("res",e),t.loading=!1}))},toDetails:function(t,e,a){Object(l["d"])(this,t,e,a)},search:function(){var t=this;console.log("queryParams",this.queryParams),this.pageNumber=1,""===this.queryParams.applyStatus&&""===this.queryParams.userName&&""===this.queryParams.organization&&""===this.queryParams.applyType&&""===this.queryParams.subjectName&&""===this.queryParams.subjectType?this.getSecretaryInit():(""===this.queryParams.applyStatus&&(this.queryParams.applyStatuss=["11","12","13","19","20"]),this.queryParams.organization=this.getOrganizationId(),Object(i["c"])(this.queryParams,this.pageNumber).then((function(e){t.tutorList=e.data.data,t.totalData=e.data.total,console.log("res",e),t.loading=!1})).catch((function(t){throw t})))},getApplyTypeList:function(){var t=this;return Object(s["a"])(regeneratorRuntime.mark((function e(){return regeneratorRuntime.wrap((function(e){while(1)switch(e.prev=e.next){case 0:Object(i["a"])().then((function(e){t.applyTypeList=e.data}));case 1:case"end":return e.stop()}}),e)})))()},changeApplyStatus:function(){this.queryParams.applyStatuss=[]},resetQuery:function(){this.queryParams.userId="",this.queryParams.userName="",this.queryParams.applyType="",this.queryParams.applyStatus="",this.queryParams.applyStatuss=[],this.pageNumber=1},passFun:function(){this.check(19)},unPassFun:function(){this.check(20)},check:function(t){if("submit"===t)for(var e=0;e<this.updateList.length;e++)this.updateList[e].status_1=this.updateList[e].status_1+2;else{console.log(t);for(var a=0;a<this.updateList.length;a++)this.updateList[a].status_1=t}this.updateStatusFun(this.updateList,!0),console.log("更新状态",this.updateList)},updateStatusFun:function(t,e){var a=this;Object(i["d"])(t).then((function(t){2e4===t.code&&a.$message.success("操作成功!"),e?a.getSecretaryInit():a.updateTutorListDataCommit(a.commitArrays[0].id_1)}))},submitFun:function(){var t=this;this.$confirm("确认提交吗？").then((function(e){for(var a=!0,n=0;n<t.updateList.length;n++)11!==t.updateList[n].status_1&&12!==t.updateList[n].status_1&&13!==t.updateList[n].status_1||(a=!1);0===t.updateList.length?t.$message.warning("未选择数据，请先进行选择！"):a?(t.check("submit"),t.getSecretaryInit()):t.$message.warning("有待审核的数据，请先进行审核！")})).catch((function(){console.log("cancel")}))},handleSelectionChange:function(t){t.length>0?(this.single=!1,this.multiple=!1):(this.single=!0,this.multiple=!0),this.multipleSelection=t,this.updateObiect(this.multipleSelection)},updateObiect:function(t){this.updateList=[];for(var e=0;e<t.length;e++){var a={id_1:0,status_1:0,commit_1:""};a.id_1=t[e].applyId,a.status_1=t[e].status,a.commit_1=t[e].commit,this.updateList.push(a)}},handleSizeChange:function(t){},handleCurrentChange:function(t){this.queryParams.pageNum=t,this.getSecretaryInit()}}},p=c,h=a("2877"),d=Object(h["a"])(p,n,r,!1,null,null,null);e["default"]=d.exports},"6fa2":function(t,e,a){"use strict";a.d(e,"d",(function(){return s})),a.d(e,"c",(function(){return i})),a.d(e,"a",(function(){return l})),a.d(e,"b",(function(){return u}));a("99af");var n=a("a78e"),r=a.n(n);function s(t,e,a,n){t.$router.push("/applyDetails/".concat(e,"/").concat(a,"/").concat(n))}function i(t){var e=new Date(t);return new Date(e.getTime()+e.getTimezoneOffset()/60*3600*1e3)}function l(t){var e=new Date(t);return new Date(e.getTime()+3600*(e.getTimezoneOffset()/60+24)*1e3)}function u(){if(null!==r.a.get("organizationId"))return r.a.get("organizationId");console.log("error-organizationId is null")}},9861:function(t,e,a){"use strict";a("e260");var n=a("23e7"),r=a("d066"),s=a("0d3b"),i=a("6eeb"),l=a("e2cc"),u=a("d44e"),o=a("9ed3"),c=a("69f3"),p=a("19aa"),h=a("5135"),d=a("0366"),f=a("f5df"),m=a("825a"),g=a("861d"),y=a("7c73"),b=a("5c6c"),v=a("9a1f"),w=a("35a1"),S=a("b622"),P=r("fetch"),k=r("Headers"),L=S("iterator"),q="URLSearchParams",z=q+"Iterator",I=c.set,_=c.getterFor(q),x=c.getterFor(z),N=/\+/g,T=Array(4),O=function(t){return T[t-1]||(T[t-1]=RegExp("((?:%[\\da-f]{2}){"+t+"})","gi"))},R=function(t){try{return decodeURIComponent(t)}catch(e){return t}},j=function(t){var e=t.replace(N," "),a=4;try{return decodeURIComponent(e)}catch(n){while(a)e=e.replace(O(a--),R);return e}},U=/[!'()~]|%20/g,D={"!":"%21","'":"%27","(":"%28",")":"%29","~":"%7E","%20":"+"},C=function(t){return D[t]},F=function(t){return encodeURIComponent(t).replace(U,C)},A=function(t,e){if(e){var a,n,r=e.split("&"),s=0;while(s<r.length)a=r[s++],a.length&&(n=a.split("="),t.push({key:j(n.shift()),value:j(n.join("="))}))}},E=function(t){this.entries.length=0,A(this.entries,t)},$=function(t,e){if(t<e)throw TypeError("Not enough arguments")},J=o((function(t,e){I(this,{type:z,iterator:v(_(t).entries),kind:e})}),"Iterator",(function(){var t=x(this),e=t.kind,a=t.iterator.next(),n=a.value;return a.done||(a.value="keys"===e?n.key:"values"===e?n.value:[n.key,n.value]),a})),Q=function(){p(this,Q,q);var t,e,a,n,r,s,i,l,u,o=arguments.length>0?arguments[0]:void 0,c=this,d=[];if(I(c,{type:q,entries:d,updateURL:function(){},updateSearchParams:E}),void 0!==o)if(g(o))if(t=w(o),"function"===typeof t){e=t.call(o),a=e.next;while(!(n=a.call(e)).done){if(r=v(m(n.value)),s=r.next,(i=s.call(r)).done||(l=s.call(r)).done||!s.call(r).done)throw TypeError("Expected sequence with length 2");d.push({key:i.value+"",value:l.value+""})}}else for(u in o)h(o,u)&&d.push({key:u,value:o[u]+""});else A(d,"string"===typeof o?"?"===o.charAt(0)?o.slice(1):o:o+"")},V=Q.prototype;l(V,{append:function(t,e){$(arguments.length,2);var a=_(this);a.entries.push({key:t+"",value:e+""}),a.updateURL()},delete:function(t){$(arguments.length,1);var e=_(this),a=e.entries,n=t+"",r=0;while(r<a.length)a[r].key===n?a.splice(r,1):r++;e.updateURL()},get:function(t){$(arguments.length,1);for(var e=_(this).entries,a=t+"",n=0;n<e.length;n++)if(e[n].key===a)return e[n].value;return null},getAll:function(t){$(arguments.length,1);for(var e=_(this).entries,a=t+"",n=[],r=0;r<e.length;r++)e[r].key===a&&n.push(e[r].value);return n},has:function(t){$(arguments.length,1);var e=_(this).entries,a=t+"",n=0;while(n<e.length)if(e[n++].key===a)return!0;return!1},set:function(t,e){$(arguments.length,1);for(var a,n=_(this),r=n.entries,s=!1,i=t+"",l=e+"",u=0;u<r.length;u++)a=r[u],a.key===i&&(s?r.splice(u--,1):(s=!0,a.value=l));s||r.push({key:i,value:l}),n.updateURL()},sort:function(){var t,e,a,n=_(this),r=n.entries,s=r.slice();for(r.length=0,a=0;a<s.length;a++){for(t=s[a],e=0;e<a;e++)if(r[e].key>t.key){r.splice(e,0,t);break}e===a&&r.push(t)}n.updateURL()},forEach:function(t){var e,a=_(this).entries,n=d(t,arguments.length>1?arguments[1]:void 0,3),r=0;while(r<a.length)e=a[r++],n(e.value,e.key,this)},keys:function(){return new J(this,"keys")},values:function(){return new J(this,"values")},entries:function(){return new J(this,"entries")}},{enumerable:!0}),i(V,L,V.entries),i(V,"toString",(function(){var t,e=_(this).entries,a=[],n=0;while(n<e.length)t=e[n++],a.push(F(t.key)+"="+F(t.value));return a.join("&")}),{enumerable:!0}),u(Q,q),n({global:!0,forced:!s},{URLSearchParams:Q}),s||"function"!=typeof P||"function"!=typeof k||n({global:!0,enumerable:!0,forced:!0},{fetch:function(t){var e,a,n,r=[t];return arguments.length>1&&(e=arguments[1],g(e)&&(a=e.body,f(a)===q&&(n=e.headers?new k(e.headers):new k,n.has("content-type")||n.set("content-type","application/x-www-form-urlencoded;charset=UTF-8"),e=y(e,{body:b(0,String(a)),headers:b(0,n)}))),r.push(e)),P.apply(this,r)}}),t.exports={URLSearchParams:Q,getState:_}},"9a1f":function(t,e,a){var n=a("825a"),r=a("35a1");t.exports=function(t){var e=r(t);if("function"!=typeof e)throw TypeError(String(t)+" is not iterable");return n(e.call(t))}}}]);