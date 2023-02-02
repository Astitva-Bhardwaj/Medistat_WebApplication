//function getElement(id) {
//  return document.getElementById(id);
//}
//
//fetch('http://localhost:8081/upload')
//.then(res => res.json())
//.then((res) => {
//  const data = res.data;
//  getElement('message').innerHTML =  'Message: ' + data.message;
//  getElement('fileId').innerHTML = 'FileId: ' + data.fileId;
//  // do the rest here
//});
//<div>
//  <p id="message"></p>
//  <p id="fileId"></p>
//</div>
//

//
//var xmlhttp = new XMLHttpRequest();
//xmlhttp.onreadystatechange = function() {
//    if (this.readyState == 4 && this.status == 200) {
//        var myObj = JSON.parse(this.responseText);
//        document.getElementById("name").innerHTML = myObj.data.name;
//    }
//};
//xmlhttp.open("GET", "https://api.coinmarketcap.com/v2/ticker/1312/", true);
//xmlhttp.send();