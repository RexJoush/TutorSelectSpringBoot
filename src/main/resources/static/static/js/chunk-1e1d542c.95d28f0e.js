(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-1e1d542c"],{"4bd1":function(e,t,o){"use strict";o("8cdf")},"8cdf":function(e,t,o){},ab6f:function(e,t,o){"use strict";o.r(t);var i=function(){var e=this,t=e.$createElement,o=e._self._c||t;return o("div",{directives:[{name:"loading",rawName:"v-loading",value:e.loading,expression:"loading"}],staticClass:"main",attrs:{"element-loading-text":"请稍等..."}},[o("el-row",[o("el-col",{attrs:{span:8,offset:8}},[o("el-steps",{attrs:{active:e.active,"finish-status":"success"}},[o("el-step",{attrs:{title:"基本信息"}}),o("el-step",{attrs:{title:"研究信息"}}),o("el-step",{attrs:{title:"学术信息"}}),o("el-step",{attrs:{title:"教学信息"}})],1)],1)],1),o("br"),e.formVisible.first?o("el-row",[o("el-col",{attrs:{span:18,offset:3}},[o("transition",{attrs:{name:"el-fade-in-linear"}},[o("First",{attrs:{"apply-id":e.applyId,"apply-type":e.applyType,"apply-condition":e.applyCondition},on:{func:e.getFormSecond,load:function(t){e.loading=!0}}})],1)],1)],1):e._e(),e.formVisible.second?o("el-row",[o("el-col",{attrs:{span:18,offset:3}},[o("transition",{attrs:{name:"el-fade-in-linear"}},[o("el-card",{staticClass:"box-card"},[o("div",{staticClass:"clearfix",attrs:{slot:"header"},slot:"header"},[o("h2",[e._v("研究信息")])]),o("el-form",{ref:"formSecond",attrs:{model:e.formSecond,"label-width":"100px","label-position":"top"}},[o("el-row",[o("el-col",{attrs:{span:24}},[o("el-row",{attrs:{gutter:20}},[o("el-col",{attrs:{span:8}},[o("el-form-item",{attrs:{label:"申请学科"}},[o("el-select",{staticStyle:{width:"100%"},attrs:{placeholder:"请选择"},model:{value:e.formSecond.applySubject,callback:function(t){e.$set(e.formSecond,"applySubject",t)},expression:"formSecond.applySubject"}},e._l(e.applySubjects,(function(e){return o("el-option",{key:e.value,attrs:{label:e.label,value:e.value}})})),1)],1)],1),o("el-col",{attrs:{span:8}},[o("el-form-item",{attrs:{label:"申请类别负责单位："}},[o("el-select",{staticStyle:{width:"100%"},attrs:{placeholder:"请选择"},on:{change:e.setChildProfessional},model:{value:e.formSecond.professionalApplicationSubjectUnit,callback:function(t){e.$set(e.formSecond,"professionalApplicationSubjectUnit",t)},expression:"formSecond.professionalApplicationSubjectUnit"}},e._l(e.professionalMasterDiscipline,(function(e){return o("el-option",{key:e.department,staticStyle:{color:"#606266","font-weight":"normal"},attrs:{label:e.department,value:e}})})),1)],1)],1),o("el-col",{attrs:{span:8}},[o("el-form-item",{attrs:{label:"申请类别代码及名称"}},[o("el-select",{staticStyle:{width:"100%"},attrs:{placeholder:"请选择"},on:{change:e.setChildDomain},model:{value:e.formSecond.professionalApplicationSubjectCodeName,callback:function(t){e.$set(e.formSecond,"professionalApplicationSubjectCodeName",t)},expression:"formSecond.professionalApplicationSubjectCodeName"}},e._l(e.childProfessional,(function(e){return o("el-option",{key:e.code,staticStyle:{color:"#606266","font-weight":"normal"},attrs:{label:e.code+" "+e.professionalDegreeCategory,value:e}})})),1)],1)],1),e.isDomain?o("el-col",{attrs:{span:8}},[o("el-form-item",{attrs:{label:"申请领域代码及名称"}},[o("el-select",{staticStyle:{width:"100%"},attrs:{placeholder:"请选择"},model:{value:e.formSecond.professionalFieldCodeName,callback:function(t){e.$set(e.formSecond,"professionalFieldCodeName",t)},expression:"formSecond.professionalFieldCodeName"}},e._l(e.childDomain,(function(e){return o("el-option",{key:e.domainCode,attrs:{label:e.domainCode+" "+e.domainName,value:e.domainCode+" "+e.domainName}})})),1)],1)],1):e._e()],1)],1),o("el-col",{attrs:{span:24}},[o("el-form-item",{attrs:{label:"主要研究方向的内容及其意义（500字以内）"}},[o("el-input",{attrs:{type:"textarea",maxlength:"500","show-word-limit":"",autosize:{minRows:6}},model:{value:e.formSecond.major,callback:function(t){e.$set(e.formSecond,"major",t)},expression:"formSecond.major"}})],1)],1),o("el-col",{attrs:{span:24}},[o("el-form-item",{attrs:{label:"何时参加何种学术团体、任何种职务，有何社会兼职"}},[o("el-button",{staticClass:"addButton",attrs:{type:"primary",plain:""},on:{click:function(t){e.dialogSecond1=!0}}},[e._v("添加")]),o("el-table",{staticStyle:{width:"100%"},attrs:{data:e.formSecond.groupsOrPartTimeJobs,border:""}},[o("el-table-column",{attrs:{type:"index",width:"50",label:"序号"}}),o("el-table-column",{attrs:{prop:"time",label:"参加时间",width:"180"}}),o("el-table-column",{attrs:{prop:"groups",label:"学术团体或兼职",width:"200"}}),o("el-table-column",{attrs:{prop:"job",label:"所任职务"}}),o("el-table-column",{attrs:{align:"center",width:"150",label:"操作"},scopedSlots:e._u([{key:"default",fn:function(t){return[o("el-button",{attrs:{type:"info",size:"mini",plain:""},on:{click:function(o){return e.editGroupsOrPartTimeJob(t.$index)}}},[e._v("编 辑")]),o("el-button",{attrs:{size:"mini",type:"danger",plain:""},on:{click:function(o){return e.delGroupsOrPartTimeJob(t.$index)}}},[e._v("删 除")])]}}],null,!1,1541063795)})],1)],1)],1),o("el-col",{attrs:{span:24}},[o("el-form-item",{attrs:{label:"获何专家称号及时间"},model:{value:e.formSecond.expertTitles,callback:function(t){e.$set(e.formSecond,"expertTitles",t)},expression:"formSecond.expertTitles"}},[o("el-button",{staticClass:"addButton",attrs:{type:"primary",plain:""},on:{click:function(t){e.dialogSecond2=!0}}},[e._v("添加")]),o("el-table",{staticStyle:{width:"100%"},attrs:{data:e.formSecond.expertTitles,border:""}},[o("el-table-column",{attrs:{type:"index",width:"50",label:"序号"}}),o("el-table-column",{attrs:{label:"获得时间",prop:"time",width:"180"}}),o("el-table-column",{attrs:{label:"称号名称",prop:"title"}}),o("el-table-column",{attrs:{align:"center",width:"150",label:"操作"},scopedSlots:e._u([{key:"default",fn:function(t){return[o("el-button",{attrs:{type:"info",size:"mini",plain:""},on:{click:function(o){return e.editExpertTitle(t.$index)}}},[e._v("编 辑")]),o("el-button",{attrs:{size:"mini",type:"danger",plain:""},on:{click:function(o){return e.delExpertTitle(t.$index)}}},[e._v("删 除")])]}}],null,!1,2089737651)})],1)],1)],1)],1),o("el-row",[o("el-col",{attrs:{offset:9}},[o("el-form-item",{staticStyle:{"margin-top":"20px"}},[o("el-button",{attrs:{type:"primary"},on:{click:e.onSubmitSecondPage}},[e._v("保存此部分，填写下一项")])],1)],1)],1)],1)],1)],1)],1)],1):e._e(),e.formVisible.third?o("el-row",[o("el-col",{attrs:{span:18,offset:3}},[o("transition",{attrs:{name:"el-fade-in-linear"}},[o("Third",{attrs:{"apply-id":e.applyId,loading:e.loading,"apply-condition":e.applyCondition,"form-third":e.formThird},on:{func:e.getFormFourth,load:function(t){e.loading=!0}}})],1)],1)],1):e._e(),e.formVisible.fourth?o("el-row",[o("el-col",{attrs:{span:18,offset:3}},[o("transition",{attrs:{name:"el-fade-in-linear"}},[o("Fourth",{attrs:{"apply-id":e.applyId,"apply-type":e.applyType,"apply-condition":e.applyCondition,"form-fourth":e.formFourth,"tutor-name":e.tutorName},on:{load:function(t){e.loading=!0}}})],1)],1)],1):e._e(),o("el-dialog",{attrs:{title:e.isEdit?"修改学术团体或职务":"添加学术团体或职务",visible:e.dialogSecond1},on:{"update:visible":function(t){e.dialogSecond1=t},closed:function(t){return e.cancelFunc(1)}}},[o("el-form",{ref:"groupsOrPartTimeJobForm",attrs:{model:e.groupsOrPartTimeJob}},[o("el-form-item",{attrs:{label:"参加学术团体、或职务或社会兼职的时间"}},[o("el-date-picker",{staticStyle:{width:"100%"},attrs:{type:"month",format:"yyyy-MM","value-format":"yyyy-MM",placeholder:"选择日期"},model:{value:e.groupsOrPartTimeJob.time,callback:function(t){e.$set(e.groupsOrPartTimeJob,"time",t)},expression:"groupsOrPartTimeJob.time"}})],1),o("el-form-item",{attrs:{label:"学术团体、或职务，或兼职名称"}},[o("el-input",{model:{value:e.groupsOrPartTimeJob.groups,callback:function(t){e.$set(e.groupsOrPartTimeJob,"groups",t)},expression:"groupsOrPartTimeJob.groups"}})],1),o("el-form-item",{attrs:{label:"所任职务"}},[o("el-input",{model:{value:e.groupsOrPartTimeJob.job,callback:function(t){e.$set(e.groupsOrPartTimeJob,"job",t)},expression:"groupsOrPartTimeJob.job"}})],1)],1),o("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[e.isEdit?e._e():o("el-button",{on:{click:function(t){return e.cancelFunc(1)}}},[e._v("取 消")]),o("el-button",{attrs:{type:"primary"},on:{click:e.addGroupsOrPartTimeJob}},[e._v("确 定")])],1)],1),o("el-dialog",{attrs:{title:e.isEdit?"修改专家称号":"添加专家称号",visible:e.dialogSecond2},on:{"update:visible":function(t){e.dialogSecond2=t},closed:function(t){return e.cancelFunc(2)}}},[o("el-form",{attrs:{model:e.expertTitle}},[o("el-form-item",{attrs:{label:"获得专家称号时间"}},[o("el-date-picker",{staticStyle:{width:"100%"},attrs:{type:"month",format:"yyyy-MM","value-format":"yyyy-MM",placeholder:"选择日期"},model:{value:e.expertTitle.time,callback:function(t){e.$set(e.expertTitle,"time",t)},expression:"expertTitle.time"}})],1),o("el-form-item",{attrs:{label:"称号名称"}},[o("el-input",{model:{value:e.expertTitle.title,callback:function(t){e.$set(e.expertTitle,"title",t)},expression:"expertTitle.title"}})],1)],1),o("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[e.isEdit?e._e():o("el-button",{on:{click:function(t){return e.cancelFunc(2)}}},[e._v("取 消")]),o("el-button",{attrs:{type:"primary"},on:{click:e.addExpertTitle}},[e._v("确 定")])],1)],1)],1)},l=[],a=(o("a434"),o("25a9")),r=o("a7e8"),s=o("b384"),n=o("80bf"),c=o("37d5"),d={components:{First:s["a"],Third:n["a"],Fourth:c["a"]},data:function(){return{professionalMasterDiscipline:a["f"],loading:!1,applyId:0,applyType:0,applyCondition:0,active:0,formVisible:{first:!0,second:!1,third:!1,fourth:!1},tutorName:"",isEdit:!1,editIndex:-1,childProfessional:[],childDomain:[],isDomain:!1,dialogSecond1:!1,dialogSecond2:!1,applySubjects:[{label:"文史",value:1},{label:"理工",value:2},{label:"交叉学科",value:3}],formSecond:{applySubject:"",professionalApplicationSubjectUnit:"",professionalApplicationSubjectCodeName:"",professionalFieldCodeName:"",major:"",groupsOrPartTimeJobs:[],expertTitles:[]},groupsOrPartTimeJob:{time:"",groups:"",job:""},expertTitle:{time:"",title:""},formThird:{},formFourth:{}}},created:function(){this.applyCondition=1*this.$route.params.applyCondition,this.applyId=1*this.$route.params.applyId,this.applyType=1*this.$route.params.applyType},methods:{getFormSecond:function(e,t){console.log("second",e),this.applyId=e.applyId,this.tutorName=t,null!==e.applySubject?this.formSecond.applySubject=1*e.applySubject:this.formSecond.applySubject="",this.formSecond.professionalApplicationSubjectUnit=e.professionalApplicationSubjectUnit,this.formSecond.professionalApplicationSubjectCodeName=e.professionalApplicationSubjectCodeName,this.formSecond.professionalFieldCodeName=e.professionalFieldCodeName,this.formSecond.major=e.major,""!==e.professionalFieldCodeName&&null!=e.professionalFieldCodeName&&(this.isDomain=!0),this.formSecond.groupsOrPartTimeJobs=e.groupsOrPartTimeJobs,this.formSecond.expertTitles=e.expertTitles,this.formVisible.first=!1,this.formVisible.second=!0,this.loading=!1,this.active=1},onSubmitSecondPage:function(){var e=this;""!==this.formSecond.applySubject&&null!==this.formSecond.applySubject?this.$confirm("提交填写?").then((function(){e.loading=!0,console.log(e.formSecond),Object(r["f"])(e.formSecond,7,e.applyId,e.applyCondition).then((function(t){if(1201===t.data.code)return e.$message.error(t.data.message),void console.log(t.data.errorMessage);console.log(t.data),e.formThird=t.data,e.$message.success("保存成功!"),e.formVisible.second=!1,e.loading=!1,e.formVisible.third=!0,e.active=2}))})).catch((function(){console.log("cancel")})):this.$message.warning("请填写申请学科信息")},setChildProfessional:function(e){this.formSecond.professionalApplicationSubjectCodeName="",this.formSecond.professionalFieldCodeName="",this.isDomain=!1,this.formSecond.professionalApplicationSubjectUnit=e.department,this.childProfessional=e.professional,this.childDomain=[]},setChildDomain:function(e){console.log(e),this.formSecond.professionalFieldCodeName="",this.formSecond.professionalApplicationSubjectCodeName=e.code+" "+e.professionalDegreeCategory,this.childDomain=e.domain,0!==e.domain.length?(this.isDomain=!0,this.childDomain=e.domain):this.isDomain=!1},addGroupsOrPartTimeJob:function(){this.isEdit?(this.formSecond.groupsOrPartTimeJobs[this.editIndex]=this.groupsOrPartTimeJob,this.isEdit=!1,this.editIndex=-1):this.formSecond.groupsOrPartTimeJobs.push(this.groupsOrPartTimeJob),this.groupsOrPartTimeJob={time:"",groups:"",job:""},this.dialogSecond1=!1},editGroupsOrPartTimeJob:function(e){this.groupsOrPartTimeJob=this.formSecond.groupsOrPartTimeJobs[e],this.dialogSecond1=!0,this.isEdit=!0,this.editIndex=e},delGroupsOrPartTimeJob:function(e){this.formSecond.groupsOrPartTimeJobs.splice(e,1)},addExpertTitle:function(){this.isEdit?(this.formSecond.expertTitles[this.editIndex]=this.expertTitle,this.isEdit=!1,this.editIndex=-1):this.formSecond.expertTitles.push(this.expertTitle),this.expertTitle={time:"",title:""},this.dialogSecond2=!1},editExpertTitle:function(e){this.expertTitle=this.formSecond.expertTitles[e],this.dialogSecond2=!0,this.isEdit=!0,this.editIndex=e},delExpertTitle:function(e){this.formSecond.expertTitles.splice(e,1)},cancelFunc:function(e){1===e?(this.groupsOrPartTimeJob={time:"",groups:"",job:""},this.dialogSecond1=!1):(this.expertTitle={time:"",title:""},this.dialogSecond2=!1),this.isEdit=!1,this.editIndex=-1},getFormFourth:function(e){console.log("data",e),this.formFourth=e,this.formVisible.third=!1,this.loading=!1,this.formVisible.fourth=!0,this.active=3}}},p=d,m=(o("4bd1"),o("2877")),u=Object(m["a"])(p,i,l,!1,null,"5c88c218",null);t["default"]=u.exports}}]);