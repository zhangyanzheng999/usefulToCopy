const utils = {
  request (url, body, method, vm) {
    const config = {
      method: method,
      url: `http://120.78.193.20:9003/education/bes/v1/boss-bes-exam-center/${url}`,
      headers: {
        'Content-Type': 'application/json'
      },
      data : body
    };
    return vm.axios(config);
  },
  mixin (ObA, ObB) {
    Object.keys(ObB).forEach(val => {
      ObA.val = ObB.val;
    })
    return ObA;
  },
  checkForm (form, regexList) {
    let res = '';
    Object.keys(form).forEach((key) => {
      if (!form[key]) {
        res += `请填上${key}吧\n`;
      }
      if (key === 'mobile') {
        if (!regexList.phone.test(form.mobile)) {
          res += '手机格式错误\n';
        }
      }

      if (key === 'email') {
        if (!regexList.email.test(form.email)) {
          res += '邮箱格式错误\n';
        }
      }
    });
    return res;
  },

  regexList: {
    email: /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/,
    phone: /^1[3456789]\d{9}$/
  },

  resetForm (form) {
    Object.keys(form).forEach( (key) => {
      form.key = '';
    })
  },
};
export default utils;
