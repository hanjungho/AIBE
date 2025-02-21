class Programmer {
  // @/ex02/index.js fill contructor

  constructor(
    language,
    device,
    disease,
    nation,
    age,
    junior,
    coffee,
    stress,
    eye
  ) {
    this.language = language; // this는 현재 객체를 가리킵니다. language 프로퍼티에 전달받은 language 값을 할당합니다.
    this.device = device; // this는 현재 객체를 가리킵니다. device 프로퍼티에 전달받은 device 값을 할당합니다.
    this.disease = disease; // this는 현재 객체를 가리킵니다. disease 프로퍼티에 전달받은 disease 값을 할당합니다.
    this.nation = nation; // this는 현재 객체를 가리킵니다. nation 프로퍼티에 전달받은 nation 값을 할당합니다.
    this.age = age; // this는 현재 객체를 가리킵니다. age 프로퍼티에 전달받은 age 값을 할당합니다.
    this.junior = junior; // this는 현재 객체를 가리킵니다. junior 프로퍼티에 전달받은 junior 값을 할당합니다.
    this.coffee = coffee; // this는 현재 객체를 가리킵니다. coffee 프로퍼티에 전달받은 coffee 값을 할당합니다.
    this.stress = stress; // this는 현재 객체를 가리킵니다. stress 프로퍼티에 전달받은 stress 값을 할당합니다.
    this.eye = eye; // this는 현재 객체를 가리킵니다. eye 프로퍼티에 전달받은 eye 값을 할당합니다.
  }

  // @/ex02/index.js 내부에 한글 주석으로 this에 대해서 자세히 설명해줘. 그리고 introduce라는 메서드를 추가해줘. 한글로 자기소개하는. 개발자가.

  introduce() {
    console.log(
      `안녕하세요, 저는 ${this.age}살 ${this.nation} 출신 개발자입니다. 주로 ${
        this.language
      } 언어를 사용하며, ${this.device}로 개발합니다. ${
        this.coffee ? "커피를 좋아합니다." : "커피를 즐기지 않습니다."
      } ${this.junior ? "주니어 개발자입니다." : "경력 개발자입니다."} 눈은 ${
        this.eye
      }이고, 스트레스 지수는 ${this.stress}입니다. ${
        this.disease ? "지병이 있습니다." : "건강합니다."
      }`
    );
  }
}

// @/ex02/index.js 적당한 2030 대학생 혹은 현업 개발자 5명 정도의 표본을 만들어서 줄줄이 for문으로 작성해줘.

const programmers = [
  new Programmer(
    "JavaScript",
    "MacBook Pro",
    false,
    "한국",
    28,
    true,
    true,
    8,
    "갈색"
  ),
  new Programmer(
    "Python",
    "Dell XPS",
    false,
    "미국",
    25,
    true,
    true,
    5,
    "파란색"
  ),
  new Programmer(
    "Java",
    "ThinkPad",
    true,
    "한국",
    30,
    false,
    true,
    9,
    "검은색"
  ),
  new Programmer(
    "C++",
    "MacBook Air",
    false,
    "일본",
    27,
    false,
    false,
    6,
    "갈색"
  ),
  new Programmer(
    "JavaScript",
    "LG Gram",
    true,
    "한국",
    23,
    true,
    true,
    7,
    "초록색"
  ),
];

for (const programmer of programmers) {
  programmer.introduce();
}

// 상속
class JavaScriptProgrammer extends Programmer {
  constructor(
    language,
    device,
    disease,
    nation,
    age,
    junior,
    coffee,
    stress,
    eye,
    framework
  ) {
    super(language, device, disease, nation, age, junior, coffee, stress, eye);
    this.framework = framework;
  }

  introduce() {
    console.log(
      `안녕하세요, 저는 ${this.age}살 ${this.nation} 출신 개발자입니다. 주로 ${
        this.language
      } 언어를 사용하며, ${this.device}로 개발합니다. ${
        this.framework
      } 프레임워크를 사용합니다. ${
        this.coffee ? "커피를 좋아합니다." : "커피를 즐기지 않습니다."
      } ${this.junior ? "주니어 개발자입니다." : "경력 개발자입니다."} 눈은 ${
        this.eye
      }이고, 스트레스 지수는 ${this.stress}입니다. ${
        this.disease ? "지병이 있습니다." : "건강합니다."
      }`
    );
  }
}

// @/ex02/index.js super를 채우고, introduce를 framework를 사용하며 새로운 내용으로 오버라이딩 (JavaScriptProgrammer) 그리고 새로운 3개의 인스턴스 예제 추가하기.

const js = new Programmer(
  "JavaScript",
  "MacBook Pro",
  false,
  "한국",
  31,
  false,
  true,
  3,
  "갈색"
);
const js2 = new JavaScriptProgrammer(
  "JavaScript",
  "MacBook Air",
  false,
  "미국",
  26,
  true,
  false,
  5,
  "파란색",
  "React"
);
js.introduce();
js2.introduce();

const jsProgrammers = [
  new JavaScriptProgrammer(
    "JavaScript",
    "MacBook Pro",
    false,
    "한국",
    28,
    true,
    true,
    8,
    "갈색",
    "React"
  ),
  new JavaScriptProgrammer(
    "JavaScript",
    "Dell XPS",
    false,
    "미국",
    25,
    true,
    true,
    5,
    "파란색",
    "Angular"
  ),
  new JavaScriptProgrammer(
    "JavaScript",
    "ThinkPad",
    true,
    "한국",
    30,
    false,
    true,
    9,
    "검은색",
    "Vue"
  ),
];

for (const jsProgrammer of jsProgrammers) {
  jsProgrammer.introduce();
}

class Senior {
  constructor() {
    // this.money = 0;
    this._money = 0;
  }

  get money() {
    return this._money;
  }

  set money(val) {
    this._money = val;
  }

  money2() {
    return 10000;
  }

  money3(newMoney) {
    this._money = newMoney;
  }
}

const young = new Senior();
// console.log(young.money);
console.log(young._money); // 가능은 하지만 쓰지 마세요 (이 상태에서도 수정까지 가능합니다)
young.money = 1000;
console.log(young.money);
console.log(young.money2);
console.log(young.money2());
console.log(young.money3);
console.log(young.money);
console.log(young.money3());
console.log(young.money);
console.log(young.money3(100000));
console.log(young.money);
