var foto;
window.onload = function(){
  foto = new Foto();
}

function selectImage() {
  document.getElementById('foto-file').click();
}

function makeGrayScale() {
  foto.grayscale();
}

function makeBright() {
  foto.makeBright();
}

function makeDark() {
  foto.makeDark();
}

function makeBlur() {
  foto.applyBlurFilter();
}

function makeEmboss() {
  foto.applyEmbossFilter();
}

function makeSharp() {
  foto.applySharpFilter();
}

function download() {
  foto.export();
}

function openColorpicker() {
  document.getElementById("color-picker").click();
}

function makeColorize(elem) {
  var color = elem.value;
  foto.colorize(color);
}

function openColorFilterPicker(){
  document.getElementById('colorize-color-picker').click();
}

function applyColorFilter(elem) {
  var color = elem.value;
  foto.applyColorFilter(color);
}

function makeTransparent() {
  foto.makeTransparent();
}
function crop() {
  foto.cropSelected();
}

function flipVertically() {
  foto.flipVertically();
}
function rotate(elem) {
  var someValue = elem.value;
  foto.rotate(someValue);
}

function telegramExport() {
  contents = foto.genereateImageForExport();
  var xhr = new XMLHttpRequest();
  xhr.open("POST", "http://localhost:8899/api/image/receive", true);
  xhr.setRequestHeader('Content-Type', 'application/json');

  console.log("Image that will send to server: " + contents);
  xhr.send(JSON.stringify({
    imageBase64: contents,
    token: document.getElementById('token').value,
    description: document.getElementById('desc').value
  }));
}
