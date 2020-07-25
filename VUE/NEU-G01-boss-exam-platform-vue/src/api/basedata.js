import request from '../utils/request';
//import { post, put, deletes, get } from '../utils/request'
const baseUrl = '/education/bes/v1/base-data-center/'



//====================题目类别======================//
export function initCategories(data) {
  return axios.post(baseUrl + 'category/queryCategory', data)
}
export function addCategory(data) {
  return axios.post(baseUrl + 'category/addCategory', data)
}
export function batchDeleteCategory(data) {
  return axios.post(baseUrl + 'category/batchDeleteCategory', data)
}
export function updateCategory(data) {
  return axios.post(baseUrl + 'category/updateCategory', data)
}
export function queryTree(data) {
  return axios.post(baseUrl + 'category/queryTree', data)
}
export function queryListWithId(data) {
  return axios.post(baseUrl + 'category/queryListWithId', data)
}
export function queryCategoryList(data) {
  return axios.post(baseUrl + 'category/queryCategoryList', data)
}
//======================================================//
//题目类别POST
//export const initCategories=param=>post('http://localhost:9004/education/bes/v1/base-data-center/category/queryCategory',param);
//export const addCategory=param=>post('/basedata/category/addCategory',param);
//export const batchDeleteCategory=param=>post('/basedata/category/batchDeleteCategory',param);
//export const updateCategory=param=>post('/basedata/category/updateCategory',param);
//export const queryTree=param=>post('/basedata/category/queryTree',param);
//export const queryListWithId=param=>post('/basedata/category/queryListWithId',param);
//export const queryCategoryList=param=>post('/basedata/category/queryCategoryList',param);






//=======================题目类型POST================================//
export function batchAddSubjectType(data) {
  return axios.post(baseUrl + 'subjecttype/batchAddSubjectType', data)
}
export function addSubjectType(data) {
  return axios.post(baseUrl + 'subjecttype/addSubjectType', data)
}
export function batchDeleteSubjectTypes(data) {
  return axios.post(baseUrl + 'subjecttype/batchDeleteSubjectType', data)
}
export function updateSubjectType(data) {
  return axios.post(baseUrl + 'subjecttype/updateSubjectType', data)
}
export function initSubjectTypes(data) {
  return axios.post(baseUrl + 'subjecttype/querySubjectType', data)
}
//================================================================//


//export const batchAddSubjectType=param=>post('/basedata/subjecttype/batchAddSubjectType',param);
//export const addSubjectType=param=>post('/basedata/subjecttype/addSubjectType',param);
//export const batchDeleteSubjectTypes=param=>post('/basedata/subjecttype/batchDeleteSubjectType',param);
//export const updateSubjectType=param=>post('/basedata/subjecttype/updateSubjectType',param);
//export const initSubjectTypes=param=>post('/basedata/subjecttype/querySubjectType',param);




//============================题目POST==================================//
export function addSubject(data) {
  return axios.post(baseUrl + 'subject/addSubject', data)
}
export function batchDeleteSubjects(data) {
  return axios.post(baseUrl + 'subject/batchDeleteSubject', data)
}
export function updateSubject(data) {
  return axios.post(baseUrl + 'subject/updateSubject', data)
}
export function initSubjects(data) {
  return axios.post(baseUrl + 'subject/querySubject', data)
}
export function getSubjectTypeList(data) {
  return axios.post(baseUrl + 'subjecttype/getSubjectTypeList', data)
}
export function batchAddSubject(data) {
  return axios.post(baseUrl + 'subject/batchAddSubject', data)
}
//export const addSubject=param=>post('/basedata/subject/addSubject',param);
//export const batchDeleteSubjects=param=>post('/basedata/subject/batchDeleteSubject',param);
//export const updateSubject=param=>post('/basedata/subject/updateSubject',param);
//export const initSubjects=param=>post('/basedata/subject/querySubject',param);
//export const getSubjectTypeList=param=>post('/basedata/subjecttype/getSubjectTypeList',param);
//批量导入题目
//export const batchAddSubject=param=>post('/basedata/subject/batchAddSubject',param);
//======================================================================//








//===============================组卷配置POST=========================================//
export function addCombExamConfig(data) {
  return axios.post(baseUrl + 'combexamconfig/addCombExamConfig', data)
}
export function batchDeleteCombExamConfig(data) {
  return axios.post(baseUrl + 'combexamconfig/batchDeleteCombExamConfig', data)
}
export function updateCombExamConfig(data) {
  return axios.post(baseUrl + 'combexamconfig/updateCombExamConfig', data)
}
export function initCombExamConfig(data) {
  return axios.post(baseUrl + 'combexamconfig/queryCombExamConfig', data)
}
//export const addCombExamConfig=param=>post('/basedata/combexamconfig/addCombExamConfig',param);
//export const batchDeleteCombExamConfig=param=>post('/basedata/combexamconfig/batchDeleteCombExamConfig',param);
//export const updateCombExamConfig=param=>post('/basedata/combexamconfig/updateCombExamConfig',param);
//export const initCombExamConfig=param=>post('/basedata/combexamconfig/queryCombExamConfig',param);









