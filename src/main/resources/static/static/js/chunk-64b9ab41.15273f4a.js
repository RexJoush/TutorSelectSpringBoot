(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-64b9ab41"],{"66aa":function(t,e,o){},"87bf":function(t,e,o){"use strict";o.r(e);var i=function(){var t=this,e=t.$createElement,o=t._self._c||e;return o("div",{directives:[{name:"loading",rawName:"v-loading",value:t.loading,expression:"loading"}],staticClass:"main",attrs:{"element-loading-text":"提交中..."}},[o("el-row",[o("el-col",{attrs:{span:8,offset:8}},[o("el-steps",{attrs:{active:t.active,"finish-status":"success"}},[o("el-step",{attrs:{title:"基本信息"}}),o("el-step",{attrs:{title:"研究信息"}}),o("el-step",{attrs:{title:"学术信息"}}),o("el-step",{attrs:{title:"教学信息"}})],1)],1)],1),o("br"),t.formVisible.first?o("el-row",[o("el-col",{attrs:{span:18,offset:3}},[o("transition",{attrs:{name:"el-fade-in-linear"}},[o("First",{attrs:{"apply-id":t.applyId,"apply-type":t.applyType,"apply-condition":t.applyCondition},on:{func:t.getFormSecond,load:function(e){t.loading=!0}}})],1)],1)],1):t._e(),o("el-row",[o("el-col",{attrs:{span:18,offset:3}},[o("transition",{attrs:{name:"el-fade-in-linear"}},[t.formVisible.second?o("el-card",{staticClass:"box-card"},[o("div",{staticClass:"clearfix",attrs:{slot:"header"},slot:"header"},[o("h2",[t._v("研究信息")])]),t.formVisible.second?o("el-form",{ref:"formSecond",attrs:{model:t.formSecond,"label-width":"100px","label-position":"top"}},[o("el-row",[o("el-col",{attrs:{span:24}},[o("el-row",{attrs:{gutter:20}},[o("el-col",{attrs:{span:8}},[o("el-form-item",{attrs:{label:"申请学科"}},[o("el-select",{staticStyle:{width:"100%"},attrs:{placeholder:"请选择"},model:{value:t.formSecond.applySubject,callback:function(e){t.$set(t.formSecond,"applySubject",e)},expression:"formSecond.applySubject"}},t._l(t.applySubjects,(function(t){return o("el-option",{key:t.value,attrs:{label:t.label,value:t.value}})})),1)],1)],1),o("el-col",{attrs:{span:8}},[o("el-form-item",{attrs:{label:"申请学科负责单位："}},[o("el-select",{staticStyle:{width:"100%"},attrs:{placeholder:"请选择"},on:{change:t.setChildNode},model:{value:t.formSecond.doctoralMasterApplicationSubjectUnit,callback:function(e){t.$set(t.formSecond,"doctoralMasterApplicationSubjectUnit",e)},expression:"formSecond.doctoralMasterApplicationSubjectUnit"}},t._l(t.doctorPrimaryDiscipline,(function(t){return o("el-option",{key:t.department,staticStyle:{color:"#606266","font-weight":"normal"},attrs:{label:t.department,value:t}})})),1)],1)],1),o("el-col",{attrs:{span:8}},[o("el-form-item",{attrs:{label:"一级学科代码及名称"}},[o("el-select",{staticStyle:{width:"100%"},attrs:{placeholder:"请选择"},model:{value:t.formSecond.doctoralMasterSubjectCodeName,callback:function(e){t.$set(t.formSecond,"doctoralMasterSubjectCodeName",e)},expression:"formSecond.doctoralMasterSubjectCodeName"}},t._l(t.childNodes,(function(t){return o("el-option",{key:t.code,attrs:{label:t.code+" "+t.degreeAuthorizationPoint,value:t.code+" "+t.degreeAuthorizationPoint}})})),1)],1)],1),o("el-col",{attrs:{span:8}},[o("el-form-item",{attrs:{label:"博导在岗学科"}},[o("el-select",{staticStyle:{width:"100%"},attrs:{placeholder:"请选择"},model:{value:t.formSecond.doctoralTutorOnDuty,callback:function(e){t.$set(t.formSecond,"doctoralTutorOnDuty",e)},expression:"formSecond.doctoralTutorOnDuty"}},t._l(t.doctorFirstDiscipline,(function(t){return o("el-option",{key:t.code,attrs:{label:t.code+" "+t.degreeAuthorizationPoint,value:t.code+" "+t.degreeAuthorizationPoint}})})),1)],1)],1),o("el-col",{attrs:{span:8}},[o("el-form-item",{attrs:{label:"上岗时间"}},[o("el-date-picker",{staticStyle:{width:"100%"},attrs:{format:"yyyy-MM","value-format":"yyyy-MM",type:"month",placeholder:"选择时间"},model:{value:t.formSecond.doctoralStartTime,callback:function(e){t.$set(t.formSecond,"doctoralStartTime",e)},expression:"formSecond.doctoralStartTime"}})],1)],1)],1),o("el-divider",{attrs:{"content-position":"left"}},[o("b",[o("span",{staticStyle:{color:"red"}},[t._v("*")]),t._v(" 仅外单位调入填写")])]),o("el-row",{attrs:{gutter:20}},[o("el-col",{attrs:{span:8}},[o("el-form-item",{attrs:{label:"原单位名称"}},[o("el-input",{model:{value:t.formSecond.sourceUnitName,callback:function(e){t.$set(t.formSecond,"sourceUnitName",e)},expression:"formSecond.sourceUnitName"}})],1)],1),o("el-col",{attrs:{span:8}},[o("el-form-item",{attrs:{label:"调入时间"}},[o("el-date-picker",{staticStyle:{width:"100%"},attrs:{format:"yyyy-MM","value-format":"yyyy-MM",type:"month",placeholder:"选择时间"},model:{value:t.formSecond.transferInTime,callback:function(e){t.$set(t.formSecond,"transferInTime",e)},expression:"formSecond.transferInTime"}})],1)],1)],1),o("el-divider")],1),o("el-col",{attrs:{span:24}},[o("el-form-item",{attrs:{label:"主要研究方向的内容及其意义（500字以内）"}},[o("el-input",{attrs:{type:"textarea",maxlength:"500","show-word-limit":"",autosize:{minRows:6}},model:{value:t.formSecond.major,callback:function(e){t.$set(t.formSecond,"major",e)},expression:"formSecond.major"}})],1)],1),o("el-col",{attrs:{span:24}},[o("el-form-item",{attrs:{label:"何时参加何种学术团体、任何种职务，有何社会兼职"}},[o("el-button",{staticClass:"addButton",attrs:{type:"primary",plain:""},on:{click:function(e){t.dialogSecond1=!0}}},[t._v("添加 ")]),o("el-table",{staticStyle:{width:"100%"},attrs:{data:t.formSecond.groupsOrPartTimeJobs,border:""}},[o("el-table-column",{attrs:{type:"index",width:"50",label:"序号"}}),o("el-table-column",{attrs:{prop:"time",label:"参加时间",width:"180"}}),o("el-table-column",{attrs:{prop:"groups",label:"学术团体或兼职",width:"200"}}),o("el-table-column",{attrs:{prop:"job",label:"所任职务"}}),o("el-table-column",{attrs:{align:"center",width:"150",label:"操作"},scopedSlots:t._u([{key:"default",fn:function(e){return[o("el-button",{attrs:{type:"info",size:"mini",plain:""},on:{click:function(o){return t.editGroupsOrPartTimeJob(e.$index)}}},[t._v("编 辑")]),o("el-button",{attrs:{type:"danger",size:"mini",plain:""},on:{click:function(o){return t.delGroupsOrPartTimeJob(e.$index)}}},[t._v("删除 ")])]}}],null,!1,1702961971)})],1)],1)],1),o("el-col",{attrs:{span:24}},[o("el-form-item",{attrs:{label:"获何专家称号及时间"},model:{value:t.formSecond.expertTitles,callback:function(e){t.$set(t.formSecond,"expertTitles",e)},expression:"formSecond.expertTitles"}},[o("el-button",{staticClass:"addButton",attrs:{type:"primary",plain:""},on:{click:function(e){t.dialogSecond2=!0}}},[t._v("添加 ")]),o("el-table",{staticStyle:{width:"100%"},attrs:{data:t.formSecond.expertTitles,border:""}},[o("el-table-column",{attrs:{type:"index",width:"50",label:"序号"}}),o("el-table-column",{attrs:{label:"获得时间",prop:"time",width:"180"}}),o("el-table-column",{attrs:{label:"称号名称",prop:"title"}}),o("el-table-column",{attrs:{align:"center",width:"150",label:"操作"},scopedSlots:t._u([{key:"default",fn:function(e){return[o("el-button",{attrs:{type:"info",size:"mini",plain:""},on:{click:function(o){return t.editExpertTitle(e.$index)}}},[t._v("编 辑")]),o("el-button",{attrs:{type:"danger",size:"mini",plain:""},on:{click:function(o){return t.delExpertTitle(e.$index)}}},[t._v("删除 ")])]}}],null,!1,928054003)})],1)],1)],1)],1),o("el-row",[o("el-col",{attrs:{offset:8}},[o("el-form-item",{staticStyle:{"margin-top":"20px"}},[o("el-button",{attrs:{type:"primary"},on:{click:t.onSubmitSecondPage}},[t._v("保存此部分，填写下一项 ")])],1)],1)],1)],1):t._e()],1):t._e()],1)],1)],1),t.formVisible.third?o("el-row",[o("el-col",{attrs:{span:18,offset:3}},[o("transition",{attrs:{name:"el-fade-in-linear"}},[o("Third",{attrs:{"apply-id":t.applyId,loading:t.loading,"apply-condition":t.applyCondition,"form-third":t.formThird},on:{func:t.getFormFourth,load:function(e){t.loading=!0}}})],1)],1)],1):t._e(),t.formVisible.fourth?o("el-row",[o("el-col",{attrs:{span:18,offset:3}},[o("transition",{attrs:{name:"el-fade-in-linear"}},[o("Fourth",{attrs:{"apply-id":t.applyId,"apply-type":t.applyType,"apply-condition":t.applyCondition,"form-fourth":t.formFourth,"tutor-name":t.tutorName},on:{load:function(e){t.loading=!0}}})],1)],1)],1):t._e(),o("el-dialog",{attrs:{title:t.isEdit?"修改学术团体或职务":"添加学术团体或职务",visible:t.dialogSecond1},on:{"update:visible":function(e){t.dialogSecond1=e},closed:function(e){return t.cancelFunc(1)}}},[o("el-form",{ref:"groupsOrPartTimeJobForm",attrs:{model:t.groupsOrPartTimeJob}},[o("el-form-item",{attrs:{label:"参加学术团体、或职务或社会兼职的时间"}},[o("el-date-picker",{staticStyle:{width:"100%"},attrs:{type:"month",format:"yyyy-MM","value-format":"yyyy-MM",placeholder:"选择日期"},model:{value:t.groupsOrPartTimeJob.time,callback:function(e){t.$set(t.groupsOrPartTimeJob,"time",e)},expression:"groupsOrPartTimeJob.time"}})],1),o("el-form-item",{attrs:{label:"学术团体、或职务，或兼职名称"}},[o("el-input",{model:{value:t.groupsOrPartTimeJob.groups,callback:function(e){t.$set(t.groupsOrPartTimeJob,"groups",e)},expression:"groupsOrPartTimeJob.groups"}})],1),o("el-form-item",{attrs:{label:"所任职务"}},[o("el-input",{model:{value:t.groupsOrPartTimeJob.job,callback:function(e){t.$set(t.groupsOrPartTimeJob,"job",e)},expression:"groupsOrPartTimeJob.job"}})],1)],1),o("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[t.isEdit?t._e():o("el-button",{on:{click:function(e){return t.cancelFunc(1)}}},[t._v("取 消")]),o("el-button",{attrs:{type:"primary"},on:{click:t.addGroupsOrPartTimeJob}},[t._v("确 定 ")])],1)],1),o("el-dialog",{attrs:{title:t.isEdit?"修改专家称号":"添加专家称号",visible:t.dialogSecond2},on:{"update:visible":function(e){t.dialogSecond2=e},closed:function(e){return t.cancelFunc(2)}}},[o("el-form",{attrs:{model:t.expertTitle}},[o("el-form-item",{attrs:{label:"获得专家称号时间"}},[o("el-date-picker",{staticStyle:{width:"100%"},attrs:{type:"month",format:"yyyy-MM","value-format":"yyyy-MM",placeholder:"选择日期"},model:{value:t.expertTitle.time,callback:function(e){t.$set(t.expertTitle,"time",e)},expression:"expertTitle.time"}})],1),o("el-form-item",{attrs:{label:"称号名称"}},[o("el-input",{model:{value:t.expertTitle.title,callback:function(e){t.$set(t.expertTitle,"title",e)},expression:"expertTitle.title"}})],1)],1),o("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[t.isEdit?t._e():o("el-button",{on:{click:function(e){return t.cancelFunc(2)}}},[t._v("取 消")]),o("el-button",{attrs:{type:"primary"},on:{click:t.addExpertTitle}},[t._v("确 定")])],1)],1)],1)},r=[],l=(o("a434"),o("25a9")),a=o("a7e8"),n=o("b384"),s=o("80bf"),c=o("37d5"),d={components:{First:n["a"],Third:s["a"],Fourth:c["a"]},data:function(){return{loading:!1,doctorPrimaryDiscipline:l["d"],doctorFirstDiscipline:l["c"],applyId:0,applyType:0,applyCondition:0,active:0,formVisible:{first:!0,second:!1,third:!1,fourth:!1},tutorName:"",isEdit:!1,editIndex:-1,childNodes:[],dialogSecond1:!1,dialogSecond2:!1,applySubjects:[{label:"文史",value:1},{label:"理工",value:2},{label:"交叉学科",value:3}],formSecond:{doctoralTutorOnDuty:"",doctoralStartTime:"",sourceUnitName:"",transferInTime:"",applySubject:"",doctoralMasterApplicationSubjectUnit:"",doctoralMasterSubjectCodeName:"",major:"",groupsOrPartTimeJobs:[],expertTitles:[]},groupsOrPartTimeJob:{time:"",groups:"",job:""},expertTitle:{time:"",title:""},formThird:{},formFourth:{}}},created:function(){this.applyCondition=1*this.$route.params.applyCondition,this.applyId=1*this.$route.params.applyId,this.applyType=1*this.$route.params.applyType},methods:{getFormSecond:function(t,e){console.log("second",t),this.applyId=t.applyId,this.tutorName=e,null!==t.applySubject?this.formSecond.applySubject=1*t.applySubject:this.formSecond.applySubject="",this.formSecond.doctoralMasterApplicationSubjectUnit=t.doctoralMasterApplicationSubjectUnit,this.formSecond.doctoralMasterSubjectCodeName=t.doctoralMasterSubjectCodeName,this.formSecond.doctoralTutorOnDuty=t.doctoralTutorOnDuty,this.formSecond.doctoralStartTime=t.doctoralStartTime,this.formSecond.sourceUnitName=t.sourceUnitName,this.formSecond.transferInTime=t.transferInTime,this.formSecond.major=t.major,this.formSecond.groupsOrPartTimeJobs=t.groupsOrPartTimeJobs,this.formSecond.expertTitles=t.expertTitles,this.formVisible.first=!1,this.formVisible.second=!0,this.loading=!1,this.active=1},addGroupsOrPartTimeJob:function(){this.isEdit?(this.formSecond.groupsOrPartTimeJobs[this.editIndex]=this.groupsOrPartTimeJob,this.isEdit=!1,this.editIndex=-1):this.formSecond.groupsOrPartTimeJobs.push(this.groupsOrPartTimeJob),this.groupsOrPartTimeJob={time:"",groups:"",job:""},this.dialogSecond1=!1},delGroupsOrPartTimeJob:function(t){this.formSecond.groupsOrPartTimeJobs.splice(t,1)},editGroupsOrPartTimeJob:function(t){this.groupsOrPartTimeJob=this.formSecond.groupsOrPartTimeJobs[t],this.dialogSecond1=!0,this.isEdit=!0,this.editIndex=t},addExpertTitle:function(){this.isEdit?(this.formSecond.expertTitles[this.editIndex]=this.expertTitle,this.isEdit=!1,this.editIndex=-1):this.formSecond.expertTitles.push(this.expertTitle),this.expertTitle={time:"",title:""},this.dialogSecond2=!1},delExpertTitle:function(t){this.formSecond.expertTitles.splice(t,1)},editExpertTitle:function(t){this.expertTitle=this.formSecond.expertTitles[t],this.dialogSecond2=!0,this.isEdit=!0,this.editIndex=t},cancelFunc:function(t){1===t?(this.groupsOrPartTimeJob={time:"",groups:"",job:""},this.dialogSecond1=!1):(this.expertTitle={time:"",title:""},this.dialogSecond2=!1),this.isEdit=!1,this.editIndex=-1},setChildNode:function(t){this.formSecond.doctoralMasterSubjectCodeName="",this.formSecond.doctoralMasterApplicationSubjectUnit=t.department,this.childNodes=t.professional},onSubmitSecondPage:function(){var t=this;console.log(this.formSecond),""!==this.formSecond.applySubject&&null!==this.formSecond.applySubject?this.$confirm("提交填写?").then((function(){t.loading=!0,Object(a["f"])(t.formSecond,2,t.applyId,t.applyCondition).then((function(e){if(1201===e.data.code)return t.$message.error(e.data.message),void console.log(e.data.errorMessage);t.formThird=e.data,t.$message.success("保存成功!"),t.formVisible.second=!1,t.loading=!1,t.formVisible.third=!0,t.active=2}))})).catch((function(){console.log("cancel")})):this.$message.warning("请填写申请学科信息")},getFormFourth:function(t){console.log("data",t),this.formFourth=t,this.formVisible.third=!1,this.loading=!1,this.formVisible.fourth=!0,this.active=3}}},p=d,m=(o("a4a3"),o("2877")),u=Object(m["a"])(p,i,r,!1,null,null,null);e["default"]=u.exports},a4a3:function(t,e,o){"use strict";o("66aa")}}]);