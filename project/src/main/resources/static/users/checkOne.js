window.onload = function () {
  document.getElementById("loggingOut").addEventListener("click", getClick);
};

function getClick() {
  let xhttp = new XMLHttpRequest();
  xhttp.open("POST", `http://localhost:9008/logout`);
  xhttp.send();
}
