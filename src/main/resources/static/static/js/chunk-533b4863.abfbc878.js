(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-533b4863"],{2647:function(t,a,e){"use strict";e.d(a,"a",(function(){return r})),e.d(a,"b",(function(){return s})),e.d(a,"c",(function(){return i}));e("99af");var n=e("99b1"),c=e("b775");function r(t){return Object(c["a"])({url:"".concat(n["a"],"/tutor/checkApply/").concat(t),method:"get"})}function s(t){return Object(c["a"])({url:"".concat(n["a"],"/user/delFile"),method:"post",data:t})}function i(t){return Object(c["a"])({url:"".concat(n["a"],"/tutor/getOrganizationTime/").concat(t),method:"get"})}},"6fa2":function(t,a,e){"use strict";e.d(a,"d",(function(){return r})),e.d(a,"c",(function(){return s})),e.d(a,"a",(function(){return i})),e.d(a,"b",(function(){return o}));e("99af");var n=e("a78e"),c=e.n(n);function r(t,a,e,n){t.$router.push("/applyDetails/".concat(a,"/").concat(e,"/").concat(n))}function s(t){var a=new Date(t);return new Date(a.getTime()+a.getTimezoneOffset()/60*3600*1e3)}function i(t){var a=new Date(t);return new Date(a.getTime()+3600*(a.getTimezoneOffset()/60+24)*1e3)}function o(){if(null!==c.a.get("organizationId"))return c.a.get("organizationId");console.log("error-organizationId is null")}},"8b3c":function(t,a,e){},cbbc:function(t,a,e){"use strict";e("8b3c")},f073:function(t,a,e){"use strict";e.r(a);var n=function(){var t=this,a=t.$createElement,e=t._self._c||a;return e("div",[e("el-row",[e("el-col",{attrs:{span:24}},[e("el-divider",{attrs:{"content-position":"left"}},[e("span",{staticClass:"divider-title"},[t._v("申请类别选择")])])],1)],1),e("el-card",{staticClass:"box-card",attrs:{shadow:"always"}},[e("div",{staticClass:"clearfix",attrs:{slot:"header"},slot:"header"},[e("span",{staticStyle:{"font-size":"18px"}},[t._v("申请博士生导师")])]),e("el-row",{attrs:{gutter:20}},[e("el-col",{attrs:{span:7,offset:3}},[e("div",[e("el-button",{staticClass:"grid-content",attrs:{disabled:t.isOk,type:"primary"},on:{click:function(a){return t.checkApply(1)}}},[t._v("博士导师首次申请")])],1)]),e("el-col",{attrs:{span:7}},[e("div",[e("el-button",{staticClass:"grid-content",attrs:{disabled:t.isOk,type:"primary"},on:{click:function(a){return t.checkApply(2)}}},[t._v("博士导师增列岗位")])],1)]),e("el-col",{attrs:{span:7}},[e("div",[e("el-button",{staticClass:"grid-content",attrs:{disabled:t.isOk,type:"primary"},on:{click:function(a){return t.checkApply(3)}}},[t._v("博士导师免审申请")])],1)])],1)],1),e("el-card",{staticClass:"box-card",attrs:{shadow:"always"}},[e("div",{staticClass:"clearfix",attrs:{slot:"header"},slot:"header"},[e("span",{staticStyle:{"font-size":"18px"}},[t._v("申请硕士生导师（学术学位）")])]),e("el-row",{attrs:{gutter:20}},[e("el-col",{attrs:{span:7,offset:3}},[e("div",[e("el-button",{staticClass:"grid-content",attrs:{disabled:t.isOk,type:"primary"},on:{click:function(a){return t.checkApply(4)}}},[t._v("学硕导师首次申请")])],1)]),e("el-col",{attrs:{span:7}},[e("div",[e("el-button",{staticClass:"grid-content",attrs:{disabled:t.isOk,type:"primary"},on:{click:function(a){return t.checkApply(5)}}},[t._v("学硕导师增列岗位")])],1)]),e("el-col",{attrs:{span:7}},[e("div",[e("el-button",{staticClass:"grid-content",attrs:{disabled:t.isOk,type:"primary"},on:{click:function(a){return t.checkApply(6)}}},[t._v("学硕导师免审申请")])],1)])],1)],1),e("el-card",{staticClass:"box-card",attrs:{shadow:"always"}},[e("div",{staticClass:"clearfix",attrs:{slot:"header"},slot:"header"},[e("span",{staticStyle:{"font-size":"18px"}},[t._v("申请硕士生导师（专业学位）")])]),e("el-row",{attrs:{gutter:20}},[e("el-col",{attrs:{span:7,offset:3}},[e("div",[e("el-button",{staticClass:"grid-content",attrs:{disabled:t.isOk,type:"primary"},on:{click:function(a){return t.checkApply(7)}}},[t._v("专硕导师首次申请")])],1)]),e("el-col",{attrs:{span:7}},[e("div",[e("el-button",{staticClass:"grid-content",attrs:{disabled:t.isOk,type:"primary"},on:{click:function(a){return t.checkApply(8)}}},[t._v("专硕导师增列岗位")])],1)]),e("el-col",{attrs:{span:7}},[e("div")])],1)],1)],1)},c=[],r=e("2647"),s=e("6fa2"),i={data:function(){return{isOk:!0}},created:function(){this.getOrganizationTime()},methods:{getOrganizationTime:function(){var t=this,a=Object(s["b"])();Object(r["c"])(a).then((function(a){console.log("res",a);var e=new Date,n=Object(s["c"])(a.data.startTime),c=Object(s["a"])(a.data.endTime);console.log(n,c),e>c||e<n?(t.isOk=!0,t.$alert("当前时间不在系统时间范围内，无法申请","注意")):t.isOk=!1})).catch((function(t){throw t}))},checkApply:function(t){var a=this;Object(r["a"])(t).then((function(e){console.log(e.data);var n="";switch(t){case 1:n+="firstApplyDoctor/1";break;case 2:n+="addApplyDoctor/2";break;case 3:n+="noInspectApplyDoctor/3";break;case 4:n+="firstApplyMaster/4";break;case 5:n+="addApplyMaster/5";break;case 6:n+="noInspectApplyMaster/6";break;case 7:n+="firstApplyProfessional/7";break;case 8:n+="addApplyProfessional/8";break}101===e.data.applyCondition?(n+="/101/".concat(e.data.applyId),a.$router.push(n)):102===e.data.applyCondition?(n+="/102/".concat(e.data.applyId),a.$router.push(n)):1===t||4===t||7===t?a.$confirm("您已提交过该申请，请前往我的申请中查看","提示").then((function(t){a.$router.push("/myApply")})):(n+="/102/".concat(e.data.applyId),a.$router.push(n))}))}}},o=i,l=(e("cbbc"),e("2877")),d=Object(l["a"])(o,n,c,!1,null,"45583753",null);a["default"]=d.exports}}]);