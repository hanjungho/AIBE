// 실제 함수 선언의 지점은 여기다???

myFun();

function myFun() {
  // 선언을 여기에 했는데...
  // 호이스팅
  console.log("myFun");
}

console.log(myFun);
console.log(myFun());
myFun();

// myFun2(); // ReferenceError: Cannot access 'myFun2' before initialization

// 함수 표현식

const myFun2 = function () {
  console.log("myFun2");
};

myFun2();

// 화살표 함수 (arrow function)

// () => {}

function yourFun() {
  return true;
}
const yourFun2 = function () {
  return true;
};
const yourFun3 = () => {
  return true;
};
const yourFun4 = () => true;
const yourFun5 = (a) => true; // (a) a 괄호 생략 여부는 취향인데 린팅, 규칙에 따라서 가독성에서는 넣는 걸 권장하는 듯하다

// undefined!!!
function ourFun(a = "aaa", b, c = "ccc") {
  console.log(a, b, c);
}

ourFun();
ourFun(1);
ourFun(1, 2);
ourFun(1, 2, 3);

function ourFun2(...arr) {
  console.log(arr);
}

console.log();
console.log(1);
console.log([]);
console.log({});
console.log(1, "", 3);

// map. 사상.
const arr = ["Python", "JavaScript", "Java", "C++"];
const newArr = [];
for (const v of arr) {
  newArr.push(v.toLowerCase());
}
console.log(newArr);

const mapArr = arr.map(function (el) {
  return el.toLowerCase();
});

console.log(mapArr);

console.log(Object.is(mapArr, newArr));

// filter
const ddbk = [{ price: 15000 }, { price: 20000 }, { price: 18000 }];
console.log(
  ddbk.filter(function (el) {
    return el.price > 17000; // 17000원보다 큰 떡볶이
  })
);

// reduce -> 2개 acc(prev), cur
const elements = [{ name: "월개발" }, { name: "화개발" }, { name: "수개발" }];
// 1. map
console.log(elements.map((el) => el.name));
// 2. reduce
console.log(
  elements.reduce((acc, cur) => {
    acc.push(cur.name);
    return acc; // acc -> return 된게 다음 acc(prev)
  }, [])
);

// 배열 구조 분해 할당
const a = [1, 2, 3];
const [x, y, z] = a;
console.log(x, y, z);

// ... 스프레드

// 객체 구조 분해 할당
const b = { name: "john", age: 123 };
const { name, age } = b;
const { name: name2, age: age2, job = "programmer" } = b;
console.log(name, name2, job);

// 스프레드 연산자
console.log(a, [...a], Object.is(a, [...a]));
console.log(b, { ...b }, Object.is(b, { ...b }));
