const me = {
  name: "김개발",
  job: "영화감독",
  age: 37,
  height: 172.5,
  married: false,
  hobby: ["코딩", "야구", "카드게임"],
  1: "영화",
  movie: {
    name: "AI 감독관",
    year: 2025,
  },
  hello: function () {
    console.log("안녕하세요!");
  },
  sayMyName: function () {
    console.log(`내 이름은 ${this.name}`);
  },
};

console.log(me.name);
console.log(me["name"]);
// console.log(me.1);
console.log(me["1"]);
me.hello();
me.sayMyName();

function add(a, b) {
  return a + b;
}

add(1, 2);
console.log(add(1, 2));

function minus(a, b) {
  console.log(a - b);
  return;
  console.log("뒤가 없음");
}

minus(1, 2);
console.log(minus(1, 2));
