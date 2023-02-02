function runSpeechRecognition()
{
var output = document.getElementById("output");
var action = document.getElementById("action");
var SpeechRecognition = SpeechRecognition || webkitSpeechRecognition;
var recognition = new SpeechRecognition();
console.log(recognition);

recognition.onstart = function()
{
    action.innerHTML = "<small> listening, please speak...</small>"
}

recognition.onspeechend = function()
{
   action.innerHTML = "<small> stopped listening, Hope your are completed...</small>"
}

recognition.onresult = function(event)
{
    var transcript = event.results[0][0].transcript;
    var confidence = event.results[0][0].confidence;
    console.log(transcript);
    console.log(confidence);
    output.innerHTML = "<b>Text   </b>"+ transcript + "</br><b>Confidence   </b>" + confidence;
    output.value=transcript;
    console.log(output.value);
//
//    var consoleValue = console.log(transcript);
//    var xhr = new XMLHttpRequest();
//    xhr.open("POST", "http://localhost:8081/saveSpeech", true);
//    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
//    xhr.send("consoleValue = " + consoleValue);
}

recognition.start();
}