const texts = document.querySelector(".texts");

window.SpeechRecognition =
  window.SpeechRecognition || window.webkitSpeechRecognition;

const recognition = new SpeechRecognition();
recognition.interimResults = true;

let p = document.createElement("p");

recognition.addEventListener("result", (e) => {
  texts.appendChild(p);
  const text = Array.from(e.results)
    .map((result) => result[0])
    .map((result) => result.transcript)
    .join("");

  p.innerText = text;
  if (e.results[0].isFinal) {
    if (text.includes("how are you")) {
      p = document.createElement("p");
      p.classList.add("replay");
      p.innerText = "I am fine";
      texts.appendChild(p);
    }
    if (
      text.includes("what's your name") ||
      text.includes("what is your name")
    ) {
      p = document.createElement("p");
      p.classList.add("replay");
      p.innerText = "My Name is Cifar";
      texts.appendChild(p);
    }
    if (text.includes("Paracetamol")) {
      p = document.createElement("p");
      p.classList.add("replay");
      p.innerText = "Searching your result";
      texts.appendChild(p);
      console.log("opening youtube");
      window.open("https://www.netmeds.com/catalogsearch/result/paracetamol/Pain%20relief");
    }
    if (text.includes("Eno")) {
        p = document.createElement("p");
        p.classList.add("replay");
        p.innerText = "Searching your result";
        texts.appendChild(p);
        console.log("opening youtube");
        window.open("https://www.netmeds.com/catalogsearch/result/eno/all");
      }
      if (text.includes("Disprin")) {
        p = document.createElement("p");
        p.classList.add("replay");
        p.innerText = "Searching your result";
        texts.appendChild(p);
        console.log("opening youtube");
        window.open("https://www.netmeds.com/catalogsearch/result/disprin/all");
      }
      if (text.includes("at rest")) {
        p = document.createElement("p");
        p.classList.add("replay");
        p.innerText = "Searching your result";
        texts.appendChild(p);
        console.log("opening youtube");
        window.open("https://www.netmeds.com/prescriptions/atrest-12-5mg-tablet-10-s");
      }
      if (text.includes("clindoxyl")) {
        p = document.createElement("p");
        p.classList.add("replay");
        p.innerText = "Searching your result";
        texts.appendChild(p);
        console.log("opening youtube");
        window.open("https://www.netmeds.com/prescriptions/clindoxyl-gel-15gm");
      }
      if (text.includes("amoxicillin")) {
        p = document.createElement("p");
        p.classList.add("replay");
        p.innerText = "Searching your result";
        texts.appendChild(p);
        console.log("opening youtube");
        window.open("https://www.netmeds.com/catalogsearch/result/amoxycillin/Infection");
      }
      if (text.includes("Crocin")) {
        p = document.createElement("p");
        p.classList.add("replay");
        p.innerText = "Searching your result";
        texts.appendChild(p);
        console.log("opening youtube");
        window.open("https://www.netmeds.com/catalogsearch/result/crocin/all");
      }
      if (text.includes("ebook open")) {
        p = document.createElement("p");
        p.classList.add("replay");
        p.innerText = "Searching your result";
        texts.appendChild(p);
        console.log("opening youtube");
        window.open("https://www.netmeds.com/catalogsearch/result/ibuprofen/Pain%20relief");
      }
      if (text.includes("Dolo")) {
        p = document.createElement("p");
        p.classList.add("replay");
        p.innerText = "Searching your result";
        texts.appendChild(p);
        console.log("opening youtube");
        window.open("https://www.netmeds.com/catalogsearch/result/dolo/all");
      }
      if (text.includes("anemia")) {
        p = document.createElement("p");
        p.classList.add("replay");
        p.innerText = "Searching your result";
        texts.appendChild(p);
        console.log("opening youtube");
        window.open("https://www.netmeds.com/prescriptions/anaemia");
      }
      if (text.includes("anxiety")) {
        p = document.createElement("p");
        p.classList.add("replay");
        p.innerText = "Searching your result";
        texts.appendChild(p);
        console.log("opening youtube");
        window.open("https://www.netmeds.com/prescriptions/anxiety");
      }
      if (text.includes("asthma")) {
        p = document.createElement("p");
        p.classList.add("replay");
        p.innerText = "Searching your result";
        texts.appendChild(p);
        console.log("opening youtube");
        window.open("https://www.netmeds.com/prescriptions/asthma-copd");
      }
      if (text.includes("asthma")) {
        p = document.createElement("p");
        p.classList.add("replay");
        p.innerText = "Searching your result";
        texts.appendChild(p);
        console.log("opening youtube");
        window.open("https://www.netmeds.com/prescriptions/asthma-copd");
      }
      if (text.includes("Ayurved")) {
        p = document.createElement("p");
        p.classList.add("replay");
        p.innerText = "Searching your result";
        texts.appendChild(p);
        console.log("opening youtube");
        window.open("https://www.netmeds.com/prescriptions/ayurvedic-medicine");
      }
      if (text.includes("cancer")) {
        p = document.createElement("p");
        p.classList.add("replay");
        p.innerText = "Searching your result";
        texts.appendChild(p);
        console.log("opening youtube");
        window.open("https://www.netmeds.com/prescriptions/cancer-oncology");
      }
      if (text.includes("cold")) {
        p = document.createElement("p");
        p.classList.add("replay");
        p.innerText = "Searching your result";
        texts.appendChild(p);
        console.log("opening youtube");
        window.open("https://www.netmeds.com/prescriptions/cough-and-cold");
      }
      if (text.includes("diabetes")) {
        p = document.createElement("p");
        p.classList.add("replay");
        p.innerText = "Searching your result";
        texts.appendChild(p);
        console.log("opening youtube");
        window.open("https://www.netmeds.com/prescriptions/diabetes");
      }
      if (text.includes("constipation")) {
        p = document.createElement("p");
        p.classList.add("replay");
        p.innerText = "Searching your result";
        texts.appendChild(p);
        console.log("opening youtube");
        window.open("https://www.netmeds.com/prescriptions/constipation");
      }
      if (text.includes("diarrhoea")) {
        p = document.createElement("p");
        p.classList.add("replay");
        p.innerText = "Searching your result";
        texts.appendChild(p);
        console.log("opening youtube");
        window.open("https://www.netmeds.com/prescriptions/diarrhoea");
      }
      if (text.includes("digestion")) {
        p = document.createElement("p");
        p.classList.add("replay");
        p.innerText = "Searching your result";
        texts.appendChild(p);
        console.log("opening youtube");
        window.open("https://www.netmeds.com/prescriptions/digestion");
      }
      if (text.includes("fever")) {
        p = document.createElement("p");
        p.classList.add("replay");
        p.innerText = "Searching your result";
        texts.appendChild(p);
        console.log("opening youtube");
        window.open("https://www.netmeds.com/prescriptions/fever");
      }
      if (text.includes("hypertension")) {
        p = document.createElement("p");
        p.classList.add("replay");
        p.innerText = "Searching your result";
        texts.appendChild(p);
        console.log("opening youtube");
        window.open("https://www.netmeds.com/prescriptions/hypertension");
      }
      if (text.includes("infection")) {
        p = document.createElement("p");
        p.classList.add("replay");
        p.innerText = "Searching your result";
        texts.appendChild(p);
        console.log("opening youtube");
        window.open("https://www.netmeds.com/prescriptions/infection");
      }
      if (text.includes("vaccine")) {
        p = document.createElement("p");
        p.classList.add("replay");
        p.innerText = "Searching your result";
        texts.appendChild(p);
        console.log("opening youtube");
        window.open("https://www.netmeds.com/prescriptions/vaccines");
      }
    p = document.createElement("p");
  }
});

recognition.addEventListener("end", () => {
  recognition.start();
});

recognition.start();