document.addEventListener("DOMContentLoaded", () => {
  const container = document.querySelector("#container");
  const form = document.querySelector("#controller");
  const resetButton = document.querySelector("#resetButton");

  resetButton.addEventListener("click", () => {
    data.length = 0;
    updateStorage(data);
  });

  const data = new Proxy([], {
    set(target, property, value) {
      target[property] = value;
      updateContainer();
      updateStorage(target);
      return true;
    },
  });

  function onMounted() {
    data.push(...(JSON.parse(localStorage.getItem("myData")) ?? []));
  }
  onMounted();

  function parseCodeBlocks(text) {
    return text.replace(/(`{3,4})([\s\S]*?)\1/g, (match, ticks, code) => {
      return `<pre><code>${code.trim()}</code></pre>`;
    });
  }

  function updateContainer() {
    container.innerHTML = "";
    for (const d of data) {
      const entry = document.createElement("div");
      entry.classList.add("entry");

      // 백틱 코드 블록 변환
      const parsedText = parseCodeBlocks(d.text);
      entry.innerHTML = `<p>${parsedText}</p>`;

      if (d.reply) {
        const replyBox = document.createElement("div");
        replyBox.classList.add("code-block");
        replyBox.innerHTML = `<pre>${marked.parse(d.reply)}</pre>`;
        entry.appendChild(replyBox);
      }

      const deleteButton = document.createElement("button");
      deleteButton.textContent = "삭제";
      deleteButton.addEventListener("click", () => {
        const filtered = data.filter((value) => value.id !== d.id);
        data.length = 0;
        data.push(...filtered);
      });

      entry.appendChild(deleteButton);
      container.appendChild(entry);
    }
  }

  function updateStorage(target) {
    localStorage.setItem("myData", JSON.stringify(target));
  }

  async function handleForm(event) {
    event.preventDefault();
    const formData = new FormData(form);
    const text = formData.get("textData");

    const reply = await makeReply(text);

    const displayData = {
      id: Date.now(),
      text,
      reply,
    };

    data.push(displayData);
  }

  async function makeReply(content, model = "deepseek-r1-distill-llama-70b") {
    const GROQ_API_KEY =
      "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";
    const url = "https://api.groq.com/openai/v1/chat/completions";
    const response = await fetch(url, {
      method: "POST",
      body: JSON.stringify({
        messages: [
          {
            role: "user",
            content: `너는 웹 개발자야. {${content}} 이게 뭔지 설명해. 개발 입문자도 알아듣기 쉽게 한글로 마크다운 문법으로 설명해.`,
          },
        ],
        model,
      }),
      headers: {
        Authorization: `Bearer ${GROQ_API_KEY}`,
        "Content-Type": "application/json",
      },
    });
    const json = await response.json();
    return json.choices[0].message.content.split("</think>")[1].trim();
  }

  form.addEventListener("submit", handleForm);
});
