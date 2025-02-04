let files = [
  "https://image.aladin.co.kr/product/33564/48/cover500/k602939885_2.jpg",
  "https://image.aladin.co.kr/product/35010/64/cover500/k802934887_1.jpg",
  "https://image.aladin.co.kr/product/27604/17/cover500/8966263151_1.jpg",
  "https://image.aladin.co.kr/product/33647/8/cover500/k732939411_1.jpg",
];
let shuffled = [...files].sort(() => Math.random() - 0.5); // 순서 섞는 것
const container = document.querySelector("#container");
const resultText = document.querySelector("#result");
const h1Tag = document.querySelector("h1");
let round = files.length;

function displayMatch() {
  container.innerHTML = ""; // 기존 이미지 삭제
  let countFiles = shuffled.length;
  if (Number.isInteger(Math.log2(countFiles))) {
    round = countFiles;
  }
  if (countFiles > 2) {
    h1Tag.innerHTML = `<h1>${round}강</h1>`;
  } else if (countFiles == 2) {
    h1Tag.innerHTML = `<h1>결승</h1>`;
  } else {
    h1Tag.innerHTML = `<h1>🏆 월드컵 🏆</h1>`;
  }

  if (shuffled.length === 1) {
    resultText.innerHTML = `<h2><strong>우승</strong></h2><br><img src="${shuffled[0]}""></img>`;
    return;
  }

  const pick1 = shuffled.pop();
  const pick2 = shuffled.pop();

  const img1 = document.createElement("img");
  img1.src = pick1;
  img1.addEventListener("click", () => {
    shuffled.unshift(pick1);
    nextRound();
  });

  const img2 = document.createElement("img");
  img2.src = pick2;
  img2.addEventListener("click", () => {
    shuffled.unshift(pick2);
    nextRound();
  });

  container.appendChild(img1);
  container.appendChild(img2);
}

function nextRound() {
  setTimeout(displayMatch, 300); // 클릭 후 잠깐 딜레이 후 변경
}

displayMatch(); // 초기 실행
