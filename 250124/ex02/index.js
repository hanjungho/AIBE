let integer = 4; // 정수
console.log(integer);
let float = 3.141592; // 실수
console.log(float);

// 문자열은 대부분 작은따옴표나 큰따옴표로 묶여있다
let string = "hello"; // 문자열 (빈 문자열)
let emptyString = ""; // 빈 문자열 (들어있는 문자가 없음)
// length. size...
console.log(`안녕하세요! ${integer}`); // 템플릿 리터럴 문법 (변수를 ${} 안에 넣어 바로 표현)

// boolean, bool. -> 불. jeorge bool.
let isCold = true; // 1+
let isHard = false; // 0, 아예 없거나, 애초에 존재하지도 않았던 것들. 빈 것들.

// undefined : defined 되지 않은 것. 정의되지 않았다?
let memory;
console.log("메모리 :", memory);

// null
let areYouReady = null;
console.log("areYouReady", areYouReady);

// object
let person = {
  name: "byi",
  job: "tutor",
  hunger: 100,
};
console.log(person);
console.log("console.log()", console.log());
console.log(person.job);
console.log(person["job"]);
console.log(person.school); // undefined
console.log(person["school"]); // undefined

// array
let array = [1, 2, 3];
console.log(array);
console.log("array.push('4');", array.push("4"));
console.log(array);
console.log("array.pop();", array.pop());
console.log(array);
