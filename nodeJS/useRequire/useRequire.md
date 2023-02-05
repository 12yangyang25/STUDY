###Require과 import
####CommonJS

- require - module.exports 사용
  node에서 사용하는 키워드

> ./exportsFunc.js
>
> ```javascript
> //함수 정의와 함께 exports
>
> exports.sum = () => {
>   const a = 3;
>   const b = 5;
>   return a + b;
> };
>
> 혹은;
>
> const sum = () => {
>   const a = 3;
>   const b = 5;
>   return a + b;
> };
>
> exports.sum = sum; //(1)
> 혹은;
> module.exports = sum; //(2)
> ```

> ./useFunc
>
> ```javascript
> const { sum } = require("./exportsFunc"); //(1)
> 혹은;
> const sum = require("./exportsFunc"); //(2)
> ```

####ES6

- import - export
  package.json에 "type":"module" 추가 시 node에서도 import statement 사용 가능
