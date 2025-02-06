### ex01/index.js

```js
console.log("hello world!");
```

```sh
node -v
cd ex01
node index.js
node .
# history
```

```js
// 한줄 주석
/* 여러줄 주석 */

// 입력, 저장, 계산, 출력
console.log(foo); // 변수가 지정이 안나서 에러가 남 (var가 있다면 괜찮음 - 호이스팅)
// 밑에 var가 있으면 undefined, var가 없으면 에러...
// var foo; // 내가 원하지 않아도 var라는 키워드가 알아서 붙습니다 -> 선언
foo = "apple"; // 변수에 값을 넣어주는 것을 -> 대입/할당 (var가 없으면 알아서 붙여줌)
console.log(foo);
bar = "mango";
console.log(bar);
var baz = "appleMango"; // 초기화. 변수에 대한 선언과 값에 대한 할당이 한번에 일어나는 것을 초기화
// 선언은 한 번밖에 못해. 굳이 2번할 필요가 없어. 특정 이름과 메모리에 대한 연결이 2번 일어날 필요가 없음.
var foo; // 아무런 반응이 없음. 중복 선언에 대해서...

// let, const (es6+, 2015~)
let dev = 100;
dev = 200; // 재할당
// let dev; // 재선언. SyntaxError: Identifier 'dev' has already been declared
// 프롬프트 예: (에러메시지) 에러를 재현할 수 있는 샘플코드를 제공해줘

// 절대 변하면 안된다? immutable, final, constant...
// 1. immutable ->  mutable. -> mutate -> property -> class/protype -> instance
// 2. final -> 주소값만 고정 (메모리 주소값) - (일반적으로는 객체인데) 처음으로 입력된 레퍼런스 객체 주소값이 안변함
// 3. constant -> 그냥 고정된 리터럴 값. 그자체. 유니코드 같은 것. 상수. 그 값.

const feature = 3.14; // 초기화밖에 안 돼.
// feature = 3; // TypeError: Assignment to constant variable.
```

```js
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
```

```js
// 산술 연산자
let add = 1 + 1;
console.log("add", add);
let divide = 10 / 7;
console.log("divide", divide);
let modulo = 10 % 7;
console.log("modulo", modulo);
let pow = 10 ** 3;
console.log("pow", pow);
console.log("zeroDivine", 1 / 0);
// 비교 연산자
console.log("1 == 1.0", 1 == 1.0); // (느슨한) 동등
console.log("1 != 1.0", 1 != 1.0); // (느슨한) 부등
console.log(`1 == "1.0"`, 1 == "1.0");
console.log(`1 === "1.0"`, 1 === "1.0"); //  (엄격한 동등) 일치
console.log(`1 !== "1.0"`, 1 !== "1.0"); //  (엄격한 부등) 불일치
console.log("1 > 10", 1 > 10);
console.log("1 < 10", 1 < 10);
console.log("1 >= 10", 1 >= 10);
console.log("1 <= 10", 1 <= 10);
console.log(`"a" > "b"`, "a" > "b"); // b에게 부여된 아스키 코드 (문자코드)가 더 커서 b다 더 크다 (a가 b보다 크다 는 거짓이다) 대문자. 65, 66. 소문자. 97, 98
// 논리 연산자
let condition1 = 100 < 1000; // true
let condition2 = "a" < "b"; // true
let condition3 = 100 > 1000; // false
let condition4 = "a" > "b"; // false
// AND (&&) 단축 평가
console.log("condition1 && condition2", condition1 && condition2); // T T
// O -> O => T
console.log("condition1 && condition3", condition1 && condition3); // T F
// O -> X => F
console.log("condition3 && condition2", condition3 && condition2); // F T
// X => F
console.log("condition4 && condition3", condition4 && condition3); // F F
// X => F
// OR (||) 단축 평가
console.log("condition1 || condition2", condition1 || condition2); // T T
// O => T
console.log("condition1 || condition3", condition1 || condition3); // T F
// O => T
console.log("condition3 || condition2", condition3 || condition2); // F T
// X -> O => T
console.log("condition4 || condition3", condition4 || condition3); // F F
// X -> X => F

console.log("!true", !true);
console.log("!false", !false);

// 삼항연산자
// 조건 ? 참일 때 : 거짓일 때
// python : true일 때 if 조건 else 거짓일 때
console.log(100 > 10 ? "100이 10보다 크네" : "100이 10보다 작네");
console.log(100 < 10 ? "100이 10보다 크네" : "100이 10보다 작네");

// 타입 반환 연산자
console.log(typeof 42);
console.log(typeof "hello");
console.log(typeof null); // 유명한 버그. (null의 타입은 object???)
console.log(typeof undefined);
```

```js
// 조건문
// 비교 연산자, 논리 연산자 (단축 평가), boolean.
let age = 10;
if (age >= 20) {
  console.log("일하러 가야지!");
}
if (age >= 20) {
  console.log("일하러 가야지!");
} else {
  console.log("놀아야지!");
}

// let money = 10000;
// let money = 6000;
let money = 4000;
if (money >= 10000) {
  console.log("고급 자장면을 먹어야지!");
} else if (money >= 5000) {
  console.log("자장면을 먹어야지!");
} else {
  console.log("못 먹겠네 ㅠㅠ");
}

const randNum = Math.floor(Math.random() * 6); // 0 include 포함, 1 exclude 제외
console.log(randNum);
// break가 없으면 해당하는 것 아래로 다 나옴
switch (randNum) {
  case 0:
    console.log("1입니다");
    break;
  case 1:
    console.log("2입니다");
    break;
  case 2:
    console.log("3입니다");
    break;
  case 3:
    console.log("4입니다");
    break;
  case 4:
    console.log("5입니다");
    break;
  case 5:
    console.log("6입니다");
    break;
  default:
    console.log("뭔가 잘못됐습니다");
    break;
}
```

```js
// 반복문
let w = 0;
while (w < 10) {
  console.log("w", w);
  //   w = w + 1;
  //   w += 1; // 복합대입연산자
  w++; // w--; // 증감연산자
}

let w2 = 2;
while (true) {
  if (w2 > 100) {
    break;
  }
  w2 **= 2;
  console.log(w2);
}

while (true) {
  if (Math.random() > 0.5) {
    console.log("HEAD!");
    break;
  } else {
    console.log("TAIL ㅠㅠ");
  }
}

for (let index = 0; index < 10; index++) {
  if (index % 2 == 0) {
    continue; // 하던거를 일단 멈춰. 근데 반복은 continue. (stop은 하고.)
  }
  console.log("index", index);
  //   break;
}

for (;;) {
  break;
}
```
