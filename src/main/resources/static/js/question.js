function update_code() {
  const result_elem = document.querySelector("#highlighting-code code");
  const text = document.querySelector("#code").value;
  let html = hljs.highlightAuto(text).value;
  result_elem.innerHTML =  html.replace(new RegExp("  ", "g"), "&nbsp; ");;
  code=result_elem.innerHTML;
}
