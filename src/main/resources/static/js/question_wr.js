function ajax_send(frm){ //질문 저장
    const title=document.getElementById("title").value+"";
    const problem=document.getElementById("question").value+"";
    const code="<xmp>"+document.getElementById("code").value+"</xmp>";

    const param={"title":title,"question":problem,"code":code};
    const accessToken=localStorage.getItem("token");
    $.ajax({
        url:'http://localhost:8080/ds-sw/question/create',
        type:'POST',
        contentType:'application/json',
        data:JSON.stringify(param),
        success:function(data){
            console.log(data.data);
        },error:function(xhr,status,error){
            console.log("["+xhr.status+"]"+error);
        }
    });
    clear();
    alert("저장되었습니다!");
    window.location.href = 'http://localhost:8080/ds-sw/question';
    return false;
}

function update_code() {
  const result_elem = document.querySelector("#highlighting-code code");
  const text = document.querySelector("#code").value;
  let html = hljs.highlightAuto(text).value;
  result_elem.innerHTML =  html.replace(new RegExp("  ", "g"), "&nbsp; ");;
}


function clear(){
    const title=document.getElementById("title");
    const question=document.getElementById("question");
    const code=document.getElementById("code");
    title.value="";
    question.value="";
    code.value="";
}





