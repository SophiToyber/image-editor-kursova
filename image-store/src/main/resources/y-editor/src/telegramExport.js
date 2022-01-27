async function sendImageToTelegram() {
  var xhr = new XMLHttpRequest();
  xhr.open("POST", "http://localhost:8899/api/image/receive", true);
  xhr.setRequestHeader('Content-Type', 'application/json');

  const file = document.querySelector('input[type=file]').files[0];
  const contents = await readFile(file);

  console.log("Image that will send to server: " + contents);
  xhr.send(JSON.stringify({
    contents
  }));
}

function readFile(file) {
  return new Promise((resolve, reject) => {
    const reader = new FileReader();

    reader.onload = res => {
      resolve(res.target.result);
    };
    reader.onerror = err => reject(err);

    reader.readAsDataURL(file);
  });
}

async function onSubmit() {
  const file = document.querySelector('#select-file').files[0];

  const contents = await readFile(file);
}

// function imgToBase64(img) {
//   console.log(img)
//   var file    = document.querySelector('input[type=file]').files[0];
//   var reader  = new FileReader();
//
//   reader.onloadend = function () {
//    stringifyImage = reader.result;
//    console.log("Image stringify: " + stringifyImage);
//  }
//
//  if (file) {
//    console.log(reader.readAsDataURL(file));
//  } else {
//  }
//  console.log("DATA: " + reader.result);
//  return reader.result;
//
// }
