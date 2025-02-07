document.addEventListener("DOMContentLoaded", function () {
  // Form과 요소들을 제대로 선택
  const controllerForm = document.getElementById("controller");
  const inputField = controllerForm.querySelector("input[name='destination']"); // 원하는 input 필드를 정확히 선택
  const submitBtn = controllerForm.querySelector("button[type='submit']");
  const spinner = document.getElementById("spinner");
  const box = document.getElementById("box");

  // Toast 메시지 표시 함수
  function showToast(message, type) {
    const toastContainer = document.querySelector(".toast-container");

    // 새로운 toast 생성
    const toast = document.createElement("div");
    toast.classList.add(
      "toast",
      "align-items-center",
      "text-white",
      "border-0",
      "show"
    );

    // 메시지의 유형에 따라 클래스 추가
    if (type === "success") {
      toast.classList.add("bg-success");
    } else if (type === "danger") {
      toast.classList.add("bg-danger");
    } else if (type === "info") {
      toast.classList.add("bg-info");
    } else {
      toast.classList.add("bg-warning");
    }

    // Toast 내용 추가
    toast.innerHTML = `
      <div class="d-flex">
        <div class="toast-body">${message}</div>
        <button type="button" class="btn-close btn-close-white me-2 m-auto" data-bs-dismiss="toast"></button>
      </div>
    `;

    // Toast를 Toast container에 추가
    toastContainer.appendChild(toast);

    // Bootstrap의 Toast 객체 생성 후, 3초 후에 자동으로 사라지게 설정
    const bootstrapToast = new bootstrap.Toast(toast, { delay: 3000 });
    bootstrapToast.show();
  }

  // 폼 제출 이벤트 처리
  controllerForm.addEventListener("submit", (event) => {
    event.preventDefault();

    // inputField가 null인 경우 방지
    if (!inputField) {
      console.error("입력 필드를 찾을 수 없습니다.");
      return;
    }

    const inputData = inputField.value.trim();
    if (!inputData) {
      showToast("입력 필드를 채워주세요!", "danger");
      return;
    }

    // 버튼 비활성화 및 스피너 표시
    submitBtn.disabled = true;
    spinner.classList.remove("d-none");

    setTimeout(() => {
      showToast("데이터가 성공적으로 제출되었습니다!", "success");
      inputField.value = ""; // 필드 비우기
      submitBtn.disabled = false; // 버튼 다시 활성화
      spinner.classList.add("d-none"); // 스피너 숨기기
    }, 1500);
  });

  // 두 번째 기능 (마크다운 파싱 + 로컬 스토리지 활용)
  const addMsg = (msg) => {
    const p = document.createElement("p");
    p.innerHTML = `<pre>${marked.parse(msg)}</pre>`; // 마크다운 파싱
    box.appendChild(p);
  };

  const markdown = localStorage.getItem("markdown");
  if (markdown !== null) {
    addMsg(markdown);
  }

  const visitPlaceText = localStorage.getItem("array");
  if (visitPlaceText !== null) {
    console.log(visitPlaceText);
  }

  // controllerForm 제출 이벤트
  controllerForm.addEventListener("submit", async (event) => {
    event.preventDefault();
    box.innerHTML = "";

    const formData = new FormData(controllerForm);
    const [
      GEMINI_API_KEY,
      destination,
      travelDays,
      travelStart,
      travelEnd,
      travelStyle,
      companion,
      budget,
    ] = [...formData.keys()].map((key) => formData.get(key));

    if (!GEMINI_API_KEY) {
      addMsg("GEMINI API 키가 설정되지 않았습니다.");
      return;
    }

    const callModel = async (
      prompt,
      modelName = "gemini-2.0-pro-exp-02-05",
      action = "generateContent",
      generationConfig = {},
      autoSearch = true
    ) => {
      const modelPool = new Set([
        "gemini-2.0-flash-001",
        "gemini-2.0-flash-lite-preview-02-05",
        "gemini-1.5-flash",
        "gemini-1.5-flash-8b",
        "gemini-1.5-pro",
        "gemini-2.0-pro-exp-02-05",
        "gemini-2.0-flash-thinking-exp-01-21",
        "gemini-2.0-flash-exp",
        "gemini-exp-1206",
      ]);

      while (true) {
        const url = `https://generativelanguage.googleapis.com/v1beta/models/${modelName}:${action}?key=${GEMINI_API_KEY}`;
        console.log("처리 시작", new Date(), "모델:", modelName);
        try {
          const response = await axios.post(
            url,
            {
              contents: [
                {
                  parts: [{ text: prompt }],
                },
              ],
              generationConfig,
            },
            {
              headers: {
                "Content-Type": "application/json",
              },
            }
          );
          return response.data.candidates[0].content.parts[0].text;
        } catch (error) {
          console.error("오류 발생:", error);
          if (error.response && error.response.status === 429) {
            if (!autoSearch || modelPool.size === 0) {
              throw new Error("모델 재시도 불가: 요청 거부됨.");
            }
            const newModelName = modelPool.keys().next().value;
            console.log(
              `모델 ${modelName}에서 429 발생, 모델 ${newModelName}로 전환 후 재시도!`
            );
            modelName = newModelName;
            modelPool.delete(newModelName);
          }
          await new Promise((resolve) => setTimeout(resolve, 4000));
        } finally {
          console.log("처리 종료", new Date());
        }
      }
    };

    const firstAI = async (
      budget,
      companion,
      destination,
      travelDays,
      travelStyle
    ) => {
      const prompt = `당신은 세계 최고의 숙소 전문가입니다. 단어만 나열하고 다른 설명 **없이** 출력하세요. ${travelDays}일 동안 ${travelStyle} 여행을 위한 ${destination}으로 여행을 ${companion}와 같이 갑니다. 전체 여행 예산이 ${budget} 입니다. 이를 바탕으로 숙소를 추천해주세요. 숙소는 숙소 카테고리가 아닌 세부적으로 특정한 이름을 가진 숙박업소 이름입니다. 고를 수 있도록 넉넉하게 2*${travelDays} 개 정도 추천해주세요. 구글에 검색하면 해당 장소가 나오도록 **영어로** 작성해야합니다. 출력 형태는 숙소이름만 작성하고 구분자는 , 으로 합니다.`;
      return await callModel(prompt, "gemini-2.0-flash-thinking-exp-01-21");
    };

    const firstResponse = await firstAI(
      budget,
      companion,
      destination,
      travelDays,
      travelStyle
    );
    addMsg("- **추천 숙소**: " + firstResponse);

    const secondAI = async (
      budget,
      companion,
      destination,
      travelDays,
      travelStyle
    ) => {
      const prompt = `당신은 세계 최고의 음식점 전문가입니다. 단어만 나열하고 다른 설명 **없이** 출력하세요. ${travelDays}일 동안 ${travelStyle} 여행을 위한 ${destination}으로 여행을 ${companion}와 같이 갑니다. 전체 여행 예산이 ${budget} 입니다. 이를 바탕으로 음식점을 추천해주세요. 음식점은 음식 이름이 아닌 세부적으로 특정한 이름을 가진 가게이름입니다. 고를 수 있도록 넉넉하게 4*${travelDays} 개 정도 추천해주세요. 구글에 검색하면 해당 장소가 나오도록 **영어로** 작성해야합니다. 출력 형태는 음식점이름만 작성하고 구분자는 , 으로 합니다.`;
      return await callModel(prompt, "gemini-2.0-flash-thinking-exp-01-21");
    };

    const secondResponse = await secondAI(
      budget,
      companion,
      destination,
      travelDays,
      travelStyle
    );
    addMsg("- **추천 음식점**: " + secondResponse);

    const thirdAI = async (
      budget,
      companion,
      destination,
      travelDays,
      travelStyle
    ) => {
      const prompt = `당신은 세계 최고의 관광지 전문가입니다. 단어만 나열하고 다른 설명 **없이** 출력하세요. ${travelDays}일 동안 ${travelStyle} 여행을 위한 ${destination}으로 여행을 ${companion}와 같이 갑니다. 전체 여행 예산이 ${budget} 입니다. 이를 바탕으로 관광지를 추천해주세요. 관광지는 도시, 지역명이 아닌 특징이 있는 세부적인 spot입니다. 고를 수 있도록 넉넉하게 3*${travelDays} 개 정도 추천해주세요. 구글에 검색하면 해당 장소가 나오도록 **영어로** 작성해야합니다. 출력 형태는 관광지이름만 작성하고 구분자는 , 으로 합니다.`;
      return await callModel(prompt, "gemini-2.0-flash-thinking-exp-01-21");
    };

    const thirdResponse = await thirdAI(
      budget,
      companion,
      destination,
      travelDays,
      travelStyle
    );
    addMsg("- **추천 관광지**: " + thirdResponse);

    const fourthAI = async (
      firstResponse,
      secondResponse,
      thirdResponse,
      budget,
      companion,
      destination,
      travelStart,
      travelEnd,
      travelDays,
      travelStyle
    ) => {
      const prompt = `당신은 세계 최고의 여행플래너입니다. 숙소: ${firstResponse}, 음식점: ${secondResponse}, 관광지: ${thirdResponse} 를 참고하여 예산 ${budget} 내에서 ${companion} 와의 최적화된 ${destination} 여행 계획을 작성해주세요. 숙박, 식사, 활동, 교통비 등을 포함하여 전체 여행 계획을 예산에 맞게 최적화해 주세요. 최소한의 이동경로로 최적화해 주세요. 한국이 아닌 나라는 외국입니다. ${destination}이 한국이 아닌 다른 나라이면 시작과 종료는 인천공항으로 입니다. 한국일 경우 시작과 종료는 ${destination}에서 합니다. 여행 기간은 ${travelDays}입니다. 선호하는 여행 스타일은 ${travelStyle}입니다. 시작 시간은 ${travelStart}이고 도착 시간은 ${travelEnd} 입니다. 마크다운 문법으로 작성하세요. 모든 장소는 구글맵의 해당 장소랑 연결되도록 구글맵 링크를 [Apple 여의도](https://www.google.com/maps/search/Apple+여의도){:target="_blank"} 새창으로 열기 헝식은 작성하세요. 올바른 URL 형식은 https://www.google.com/maps/search/Apple+여의도 입니다. 마크다운은 아래를 참고하세요.
    # ✈ [여행 제목]
    
    ## 📌 1. 여행 개요
    - **여행지:** 
    - **여행 기간:**  
    - **여행 컨셉:**  
    - **예산:**  
    - **동행자:**  
    - **환전 계획:**  
    - **교통 패스:**  
    
    ---
    ## 📅 2. 여행 일정 (Day별 상세 일정)
    ### 📆 Day 1 (날짜) - 일정 요약  
    **🚀 시간 | 활동명**  
    - 상세 내용  
        `;
      return await callModel(prompt, "gemini-2.0-flash-thinking-exp-01-21");
    };

    const fourthResponse = await fourthAI(
      firstResponse,
      secondResponse,
      thirdResponse,
      budget,
      companion,
      destination,
      travelStart,
      travelEnd,
      travelDays,
      travelStyle
    );
    localStorage.setItem("markdown", fourthResponse);
    addMsg(`- AI 여행 플래너: ${fourthResponse}`);

    // 올바른 방문 장소 목록 저장
    localStorage.setItem("array", JSON.stringify(visitPlace));
    const fifthAI = async (fourthResponse) => {
      const prompt = `당신은 최고의 데이터 수집가입니다. 단어만 나열하고 다른 설명 **없이** 출력하세요. 아래의 여행 플래너에서 방문 장소를 수집하여 나열해주세요. 장소는 구글에 검색하면 해당 장소가 나오도록 **영어로** 작성해야합니다. 중복되는 장소없이 나열하세요. 출력 형태는 숙소이름만 작성하고 구분자는 , 으로 합니다.
                ${fourthResponse}`;
      return await callModel(prompt, "gemini-2.0-flash-thinking-exp-01-21");
    };

    const fifthResponse = await fifthAI(fourthResponse);
    addMsg(fifthResponse);

    localStorage.setItem("visitPlaces", JSON.stringify(fifthResponse));
  });
});
